package com.frandog.training_03_rssread;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.style.AbsoluteSizeSpan;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;
import static android.os.Environment.getDataDirectory;
import static android.webkit.ConsoleMessage.MessageLevel.LOG;

/**
 * Created by Student on 2018/2/1.
 */

public class UseSaxParse extends Activity {
    String TAG="UseSAX";
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

    private List<Book> getXMLData(){
        List<Book> books=new ArrayList<Book>();
        try{

//test  卡到這，自己下if，發現"file.xml"好像是空的，目前想不到該怎麼辦
            File file = new File(getFilesDir(),"file.xml");
            Log.d("==========FileDir",getFilesDir().toString());

            if(UseSaxParse.class.getClassLoader().getResourceAsStream("file.xml") != null)
            {
                FileOutputStream outputStream;

                try {
                    outputStream = openFileOutput("file.xml", Context.MODE_PRIVATE);
                    outputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            else
            {
                Log.d("=======================","it's null");
            }


//原CODE
//            InputStream inStream=UseSaxParse.class.getClassLoader().getResourceAsStream("file.xml");
//            books = SAXParseXML.readXML(inStream);

        }catch(Exception er){
            Log.e(TAG, er.getMessage());
        }

//        test
        Log.d("================","getXMLData() is done");

        return books;
    }

}