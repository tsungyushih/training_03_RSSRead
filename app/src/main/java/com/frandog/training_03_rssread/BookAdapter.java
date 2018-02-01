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
    List<Book> books = null;

    public BookAdapter(Context context,List<Book> books)
    {
        inflater = LayoutInflater.from(context);
        this.books = books;
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
    public View getView(int position, View arg1, ViewGroup parent) {
        ViewHolder viewHolder;
        if(arg1 == null)
        {
            arg1 = inflater.inflate(R.layout.book_data,null);
            viewHolder = new ViewHolder();
            viewHolder.bookNameTxt = arg1.findViewById(R.id.bookNameTxt);
            viewHolder.publishersTxt = arg1.findViewById(R.id.publishersTxt);
            viewHolder.priceTxt = arg1.findViewById(R.id.priceTxt);
            arg1.setTag(viewHolder);
        }
        else
        {
            viewHolder =(ViewHolder) arg1.getTag();
        }

        viewHolder.bookNameTxt.setText(books.get(position).name);
        viewHolder.publishersTxt.setText(books.get(position).publishers);
        viewHolder.priceTxt.setText("NT."+books.get(position).price+" 元");

        return arg1;
    }

    private class ViewHolder
    {
        TextView bookNameTxt;
        TextView publishersTxt;
        TextView priceTxt;
    }
}
