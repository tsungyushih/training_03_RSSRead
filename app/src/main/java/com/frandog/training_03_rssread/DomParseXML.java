package com.frandog.training_03_rssread;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by Student on 2018/2/2.
 */

public class DomParseXML {
    public static List<Book> ReadBookXML(InputStream inStream) throws Exception{
        List<Book> books=new ArrayList<Book>();
        DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();
        DocumentBuilder builder=factory.newDocumentBuilder();
        Document document=builder.parse(inStream);  //以樹狀格式存於記憶體中﹐比較耗記憶體
        Element root=document.getDocumentElement();
        NodeList nodes=root.getElementsByTagName("book");

        for(int i=0;i<nodes.getLength();i++){
            Element bookElement=(Element)nodes.item(i);
            Book book=new Book();
            book.setId(bookElement.getAttribute("id"));
            book.setName(bookElement.getAttribute("name"));
            book.setPublishers(bookElement.getAttribute("publishers"));
            book.setPrice(bookElement.getAttribute("price"));

            books.add(book);
        }

        return books;
    }
}
