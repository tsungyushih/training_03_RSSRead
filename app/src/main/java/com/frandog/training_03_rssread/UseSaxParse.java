package com.frandog.training_03_rssread;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.style.AbsoluteSizeSpan;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;
import static android.os.Environment.getDataDirectory;

/**
 * Created by Student on 2018/2/1.
 */

public class UseSaxParse extends Activity {
    String Tag = "UseSax";
    TextView list_title;
    ListView bookList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booklist);

        findView();
        ShowXMLData();
    }

    private void findView() {
        list_title = findViewById(R.id.list_title);
        bookList = findViewById(R.id.bookListView);
    }

    private void ShowXMLData() {
        Bundle bundle = this.getIntent().getExtras();
        list_title.setText("書籍列表("+bundle.getString("list_title")+")");

        List<Book> books = new ArrayList<Book>();
        books = getXMLData();

        bookList.setAdapter(new BookAdapter(this,books));
    }

    private List<Book> getXMLData()
    {
        List<Book> books = new ArrayList<Book>();
        try
        {
            InputStream inStream = UseSaxParse.class.getClassLoader().getResourceAsStream("xml/Books.xml");
            books = SAXParseXML.readXML(inStream);
        }
        catch (Exception er)
        {
            Log.e(TAG,er.getMessage());
        }
        return books;
    }
}
