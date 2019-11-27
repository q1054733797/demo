package com.demo.lucene.test;

import com.sun.nio.zipfs.ZipFileSystem;
import com.sun.nio.zipfs.ZipPath;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.IOException;

/**
 * @ClassName: Test01
 * @Author: zhanghongkai
 * @Date: Create in 2019/8/30 20:55
 * @Version: 1.0
 */
public class Test01 {
    public static void main(String[] args) throws IOException {
        //1 创建文档对象
        Document document = new Document();
        document.add(new TextField("id", "1", Field.Store.YES));
        document.add(new TextField("title", "谷歌地图之父跳槽facebook", Field.Store.YES));
        //2 创建存储目录
        Directory directory = FSDirectory.open(new File("F:/indexDir"));
        //3 创建分词器
        Analyzer analyzer = new IKAnalyzer();
        //4 创建索引写入器的配置对象
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LATEST,analyzer);
        //5 创建索引写入器对象
        IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);
        //6 将文档交给索引写入器
        indexWriter.addDocument(document);
        //7 提交
        indexWriter.commit();
        //8 关闭
        indexWriter.close();
    }
}
