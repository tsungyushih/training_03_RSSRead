package com.frandog.training_03_rssread;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String str = getFilesDir().getAbsolutePath();
        File file = new File(str,"books.xml");
        Log.d("==========FileDir",str);
        String string = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<books>\n" +
                "\t<book id=\"P631\" name=\"Android 2.X 應用程式開發實戰\" publishers=\"碁峯\" price=\"580\">\n" +
                "\t\t<auther name=\"林城\"/>\n" +
                "\t</book>\n" +
                "\t<book id=\"P697\" name=\"深入淺出 Android 遊戲程式開發範例大全\" publishers=\"博碩文化\" price=\"620\">\n" +
                "\t\t<auther name=\"吳亞峰\"/>\n" +
                "\t\t<auther name=\"蘇亞光\"/>\n" +
                "\t</book> \n" +
                "\t<book id=\"XP6037\" name=\"Silverlight 4 商業級應用程式開發\" publishers=\"悅知文化\" price=\"590\">\n" +
                "\t\t<auther name=\"Frank LaVigne. Cameron Albert\"/>\n" +
                "\t</book>\n" +
                "</books>";
        FileOutputStream outputStream;
        try {
            outputStream = openFileOutput("file.xml",MODE_PRIVATE);
            outputStream.write(string.getBytes());
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }




}
