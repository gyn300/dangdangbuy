package com.model;


public class Books {
    private int id;
    private String book_name;
    private double book_price;
    private double dangdang_price;
    private String publishing;//出版社
    private String synopsis;//简介
    private String family;
    private String author;

    public Books(int id, String book_name, double book_price, double dangdang_price, String publishing, String synopsis, String family, String author) {
        this.id = id;
        this.book_name = book_name;
        this.book_price = book_price;
        this.dangdang_price = dangdang_price;
        this.publishing = publishing;
        this.synopsis = synopsis;
        this.family = family;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public double getBook_price() {
        return book_price;
    }

    public void setBook_price(double book_price) {
        this.book_price = book_price;
    }

    public double getDangdang_price() {
        return dangdang_price;
    }

    public void setDangdang_price(double dangdang_price) {
        this.dangdang_price = dangdang_price;
    }

    public String getPublishing() {
        return publishing;
    }

    public void setPublishing(String publishing) {
        this.publishing = publishing;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    @Override


    public String toString() {
        return "书本{" +
                "id=" + id +
                ", 书名='" + book_name + '\'' +
                ", 作者='" + author + '\'' +
                ", 出版社='" + publishing + '\'' +
                ", 分类='" + family + '\'' +
                ", 简介='" + synopsis + '\'' +
                ", 定价=" + book_price +
                ", 当当价=" + dangdang_price +
                '}';
    }
}
