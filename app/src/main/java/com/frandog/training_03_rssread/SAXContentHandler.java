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

    public List<Book> getBooks()
    {
        return books;
    }

    @Override
    public void startDocument() throws SAXException
    {
        books = new ArrayList<Book>();
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if("book".equals(localName))
        {
            book = new Book();
            book.setId(attributes.getValue("","id"));
            book.setName(attributes.getValue("","name"));
            book.setPublishers(attributes.getValue("publishers"));
            book.setPrice(attributes.getValue("price"));
        }
        preTag = localName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if("book".equals(localName) && book != null)
        {
            books.add(book);
            book = null;
        }
        preTag = null;
    }
}
