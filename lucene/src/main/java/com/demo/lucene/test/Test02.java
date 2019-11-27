package com.demo.lucene.test;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.NIOFSDirectory;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.IOException;

/**
 * @author : zhanghongkai
 * @version : 1.0
 * @ClassName : Test02
 * @date : Create in 2019/9/4 20:11
 */
public class Test02 {
    public static void main(String[] args) throws IOException, ParseException {
        //1 创建读取目录对象
        Directory directory = new NIOFSDirectory(new File("F:/indexDir"));
        //2 创建索引读取工具
        IndexReader indexReader = IndexReader.open(directory);
        //3 创建索引搜索工具
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        //4 创建查询解析器
        QueryParser queryParser = new QueryParser("title", new IKAnalyzer());
        //5 创建查询对象
        Query query = queryParser.parse("谷歌");
//        Query query = new TermQuery(new Term("title", "谷歌"));
//        Query query = new WildcardQuery(new Term("title", "*歌"));
//        Query query1 = new FuzzyQuery(new Term("title", "facebook"),2);
//        Query query2 = NumericRangeQuery.newLongRange("id", 0L, 2L, true, true);
//        BooleanQuery query = new BooleanQuery();
//        query.add(query1, BooleanClause.Occur.MUST);
//        query.add(query2, BooleanClause.Occur.SHOULD);
        //6 搜索数据
        TopDocs topDocs = indexSearcher.search(query, 10);
        System.out.println(topDocs.totalHits);
        //7 各种操作
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        for (ScoreDoc scoreDoc : scoreDocs) {
            int docId = scoreDoc.doc;
            Document document = indexReader.document(docId);
            System.out.println(document.get("id"));
            System.out.println(document.get("title"));
            System.out.println(scoreDoc.score);
        }
    }
}
