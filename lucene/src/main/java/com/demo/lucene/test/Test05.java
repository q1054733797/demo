package com.demo.lucene.test;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.search.highlight.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.NIOFSDirectory;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.IOException;

/**
 * @author : zhanghongkai
 * @version : 1.0
 * @ClassName : Test05
 * @date : Create in 2019/9/4 20:44
 */
public class Test05 {
    public static void main(String[] args) throws IOException, ParseException, InvalidTokenOffsetsException {
        //1 创建目录 对象
        Directory directory = new NIOFSDirectory(new File("F:/indexDir"));
        //2 创建索引读取工具
        IndexReader indexReader = IndexReader.open(directory);
        //3 创建索引搜索工具
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        //4 创建查询解析器
        QueryParser queryParser = new QueryParser("title", new IKAnalyzer());
        //5 创建查询对象
        Query query = queryParser.parse("谷歌");
        //6 创建格式化器
        Formatter formatter = new SimpleHTMLFormatter("<em>", "</em>");
        //7 创建查询分数工具
        QueryScorer queryScorer = new QueryScorer(query);
        //8 准备高亮工具
        Highlighter highlighter = new Highlighter(formatter, queryScorer);
        //排序
        Sort sort = new Sort(new SortField("id", SortField.Type.LONG,true));
        //9 搜索
        TopDocs topDocs = indexSearcher.search(query, 10,sort);
        //10 获取结果
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        for (ScoreDoc scoreDoc : scoreDocs) {
            int doc = scoreDoc.doc;
            Document document = indexReader.document(doc);
            System.out.println(document.get("id"));
            System.out.println(document.get("title"));
            //11 用高亮工具处理普通的查询结果
            System.out.println(highlighter.getBestFragment(new IKAnalyzer(), "title", document.get("title")));
        }
    }
}
