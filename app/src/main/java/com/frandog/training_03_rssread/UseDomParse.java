package com.frandog.training_03_rssread;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Student on 2018/2/2.
 */

public class UseDomParse extends Activity {
    String TAG="UseDomParse";
    TextView list_title;
    ListView bookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booklist);

        findView();
        ShowXMLData();
    }

    private void findView(){
        list_title=(TextView)findViewById(R.id.list_title);
        bookList=(ListView)findViewById(R.id.bookListView);
    }

    private void ShowXMLData(){
        Bundle bundle=this.getIntent().getExtras();
        list_title.setText("書籍列表("+bundle.getString("list_title")+")");

        List<Book> books=new ArrayList<Book>();
        books=getXMLData();

        bookList.setAdapter(new BookAdapter(this,books));
    }

    private List<Book> getXMLData() {
        List<Book> books = new ArrayList<Book>();
        try {
            InputStream inStream = UseDomParse.class.getClassLoader()
                    .getResourceAsStream("Books.xml");  //讀取檔案

//			InputStream inStream = UseDomParse.class.getClassLoader()
//			.getResourceAsStream("com/sample/AndroidUseXML/Books2.xml");  //讀取檔案

            books = DomParseXML.ReadBookXML(inStream);
        } catch (Exception er) {
            Log.e(TAG, er.getMessage());
        }
        return books;
    }
}
