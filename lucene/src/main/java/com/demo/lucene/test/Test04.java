package com.demo.lucene.test;

import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.NIOFSDirectory;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.IOException;

/**
 * @author : zhanghongkai
 * @version : 1.0
 * @ClassName : Test04
 * @date : Create in 2019/9/4 20:38
 */
public class Test04 {
    public static void main(String[] args) throws IOException {
        //1 创建文档对象目录
        Directory directory = new NIOFSDirectory(new File("F:/indexDir"));
        //2 创建索引写入器配置对象
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LATEST, new IKAnalyzer());
        //3 创建索引写入器
        IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);
        //4 删除
        indexWriter.deleteAll();
        //5 提交
        indexWriter.commit();
        //6 关闭
        indexWriter.close();
    }
}
