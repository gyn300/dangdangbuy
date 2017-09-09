package com.model;



public class ShoppingTrolley {
    private int id;
    private int book_id;
    private int count;
    private String user_name;

    public ShoppingTrolley(int id, int book_id, int count, String user_name) {
        this.id=id;
        this.book_id = book_id;
        this.count = count;
        this.user_name = user_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    @Override
    public String toString() {
        return "ShoppingTrolley{" +
                "id=" + id +
                ", book_id=" + book_id +
                ", count=" + count +
                ", user_name='" + user_name + '\'' +
                '}';
    }
}
