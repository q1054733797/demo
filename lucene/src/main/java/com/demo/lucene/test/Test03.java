package com.demo.lucene.test;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.NIOFSDirectory;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.IOException;

/**
 * @author : zhanghongkai
 * @version : 1.0
 * @ClassName : Test03
 * @date : Create in 2019/9/4 20:33
 */
public class Test03 {
    public static void main(String[] args) throws IOException {
        //1 创建目录对象
        Directory directory = new NIOFSDirectory(new File("F:/indexDir"));
        //2 创建索引写入器配置对象
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LATEST, new IKAnalyzer());
        //3 创建索引写入器
        IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);
        //4 创建文档数据
        Document doc = new Document();
        doc.add(new StringField("id","1", Field.Store.YES));
        doc.add(new TextField("title","谷歌地图之父跳槽facebook ", Field.Store.YES));
        //5 修改
        indexWriter.updateDocument(new Term("id","1"), doc);
        //6 提交
        indexWriter.commit();
        //7 关闭
        indexWriter.close();
    }
}
