package com.frandog.training_03_rssread;

import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by Student on 2018/2/1.
 */

public class SAXParseXML {
    public static List<Book> readXML(InputStream inStream) throws Exception
    {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();   //建立解析器

        SAXContentHandler handler = new SAXContentHandler();
        saxParser.parse(inStream,handler);
        inStream.close();

        return handler.getBooks();
    }
}
