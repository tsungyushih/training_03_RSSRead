package com.frandog.training_03_rssread;

import android.util.Log;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by Student on 2018/2/1.
 */

public class SAXParseXML {
    public static List<Book> readXML(InputStream inStream) throws Exception{
        SAXParserFactory factory=SAXParserFactory.newInstance();
        SAXParser saxParse=factory.newSAXParser();  //建立解析器

        SAXContentHandler handler=new SAXContentHandler();
        saxParse.parse(inStream, handler);
        inStream.close();

//test
        Log.d("=======================","SAXParseXML is done");


        return handler.getBooks();
    }
}