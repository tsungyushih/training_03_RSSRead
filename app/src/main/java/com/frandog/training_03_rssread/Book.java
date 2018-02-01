package com.frandog.training_03_rssread;

/**
 * Created by Student on 2018/2/1.
 */

public class Book {
    public String id;
    public String name;
    public String publishers;
    public String price;

    public Book(){}

    public Book(String id,String name,String publishers,String price)
    {
        this.id = id;
        this.name = name;
        this.publishers = publishers;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublishers() {
        return publishers;
    }

    public void setPublishers(String publishers) {
        this.publishers = publishers;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
