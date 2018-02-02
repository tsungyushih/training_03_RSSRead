package com.frandog.training_03_rssread;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by Student on 2018/2/1.
 */

public class UseXML extends Activity {

    Button saxbtn;
    Button dombtn;

    String list_title;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findView();
        setListener();



    }

    private void findView(){
        saxbtn=(Button)findViewById(R.id.saxbtn);
        dombtn=(Button)findViewById(R.id.dombtn);


    }

    private void setListener(){
        saxbtn.setOnClickListener(saxbtnls);
        dombtn.setOnClickListener(dombtnls);

    }

    private Button.OnClickListener saxbtnls=new Button.OnClickListener(){
        @Override
        public void onClick(View arg0) {
            Intent intent=new Intent();
            intent.setClass(UseXML.this, UseSaxParse.class);

            //傳遞資料給Activity-------------
            Bundle bundle = new Bundle();
            list_title="使用SAX解析";
            bundle.putString("list_title", list_title);
            intent.putExtras(bundle);

            startActivity(intent);
        }
    };

    private Button.OnClickListener dombtnls=new Button.OnClickListener(){
        @Override
        public void onClick(View v) {
            Intent intent=new Intent();
            intent.setClass(UseXML.this, UseDomParse.class);

            //傳遞資料給Activity-------------
            Bundle bundle = new Bundle();
            list_title="使用DOM解析";
            bundle.putString("list_title", list_title);
            intent.putExtras(bundle);

            startActivity(intent);
        }
    };



}
