package com.frandog.training_03_rssread;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

/**
 * Created by Student on 2018/2/1.
 */

public class UseXML extends Activity {
    Button saxbtn;
    String list_title;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findView();
        setListener();
    }

    private void findView() {
        saxbtn = findViewById(R.id.saxbtn);
    }

    private void setListener() {
        saxbtn.setOnClickListener(saxbtns);
    }

    private  Button.OnClickListener saxbtns = new Button.OnClickListener()
    {
        public void onClick(View arg0)
        {
            Intent intent = new Intent();
            intent.setClass(UseXML.this,UseSaxParse.class);

            Bundle bundle = new Bundle();
            list_title = "使用SAX解析";
            bundle.putString("list_title",list_title);
            intent.putExtras(bundle);

            startActivity(intent);
        }
    };

}
