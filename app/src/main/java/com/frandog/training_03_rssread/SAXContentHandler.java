package com.frandog.training_03_rssread;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Student on 2018/2/1.
 */

public class SAXContentHandler extends DefaultHandler {
    private List<Book> books;
    private Book book;
    private String preTag;

    public List<Book> getBooks(){
        return books;
    }

    /**
     * 接收文件的開始
     */
    @Override
    public void startDocument() throws SAXException {
        books = new ArrayList<Book>();
    }

    /**
     * 接收字元資料的通知
     */
    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {

    }

    /**
     * 接收元素開始的通知
     */
    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        if("book".equals(localName)){
            book=new Book();
            book.setId(attributes.getValue("","id"));
            book.setName(attributes.getValue("", "name"));
            book.setPublishers(attributes.getValue("publishers"));
            book.setPrice(attributes.getValue("price"));
        }
        preTag=localName;
    }

    /**
     * 接收元素結尾的通知
     */
    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if("book".equals(localName) && book!=null){
            books.add(book);
            book=null;
        }
        preTag=null;
    }


}