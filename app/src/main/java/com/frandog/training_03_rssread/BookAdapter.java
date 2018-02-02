package com.frandog.training_03_rssread;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Student on 2018/2/1.
 */

public class BookAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    List<Book> books=null;

    public BookAdapter(Context context,List<Book> books){
        inflater=LayoutInflater.from(context);
        this.books=books;
    }

    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Object getItem(int arg0) {
        return arg0;
    }

    @Override
    public long getItemId(int arg0) {
        return arg0;
    }

    @Override
    public View getView(int arg0, View arg1, ViewGroup arg2) {
        ViewHolder viewHolder;
        if(arg1==null){
            arg1=inflater.inflate(R.layout.book_data, null);
            viewHolder=new ViewHolder();
            viewHolder.bookNameTxt=(TextView)arg1.findViewById(R.id.bookNameTxt);
            viewHolder.publishersTxt=(TextView)arg1.findViewById(R.id.publishersTxt);
            viewHolder.priceTxt=(TextView)arg1.findViewById(R.id.priceTxt);
            arg1.setTag(viewHolder);
        }else{
            viewHolder=(ViewHolder)arg1.getTag();
        }
//		String name1="";
//		String publ1="";
//		String price1="";
//		name1=books.get(arg0).name;
//		publ1=books.get(arg0).publishers;
//		price1=books.get(arg0).price;

        viewHolder.bookNameTxt.setText(books.get(arg0).name);
        viewHolder.publishersTxt.setText(books.get(arg0).publishers);
        viewHolder.priceTxt.setText("NT."+books.get(arg0).price+" 元");

        return arg1;
    }

    private class ViewHolder{
        TextView bookNameTxt;
        TextView publishersTxt;
        TextView priceTxt;
    }

}