package com.daoinf;


import com.model.Books;
import com.model.Users;

import java.util.List;

public interface BookDaoInf {
    public int regist(String book_name,double book_price,double dangdang_price,String publishing,String synopsis,String family,String author);
    public List<Books> getAllBooks();
    public int deleteBook(int id);
    public int getCount();
    public List<Books> getBooksList(int start, int size);
    public int updateBook_name(int id ,String book_name);
    public int updateBook_price(int id ,double book_price);
    public int updateDangdang_price(int id ,double dangdang_price);
    public int updatePublishing(int id ,String publishing);
    public int updateSynopsis(int id ,String synopsis);
    public int updateFamily(int id ,String family);
    public int updateAuthor(int id ,String author);
    public Books getBook(int Book_id);
    public List<Books> getFamilyBooksList(String family);

}
