package com.control;


import com.dao.BookDao;
import com.dao.UserDao;
import com.daoinf.BookDaoInf;
import com.daoinf.UserDaoInf;
import com.model.Books;
import com.model.PageData;
import com.model.Users;

import java.awt.print.Book;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BookControl {
    List<Books> books;
    BookDaoInf bdi = new BookDao();


    /**
     * 更新书本集合
     */
    public void updateAllBooks() {
        books = bdi.getAllBooks();
    }
    /**
     * 添加书本
     */
    public boolean regist(String book_name, double book_price, double dangdang_price, String publishing, String synopsis, String family,String author){
        boolean flag=false;
        if(bdi.regist(book_name,book_price,dangdang_price,publishing,synopsis,family,author)!=0){
            flag=true;
        }
        return flag;
    }
    /**
     * 获取书本列表
     */
    public List<Books> getBooks(){
        return bdi.getAllBooks();
    }

    public PageData getPageData(int pageNum)  {
        PageData pageData = new PageData();
        // 获取总记录数
        int count = bdi.getCount();
        // 赋值的同时，算出总页数
        pageData.setCount(count);
        // pageNum 判断值是否正确 ，最小值是1，不允许有0或负数。
        pageNum = pageNum < 1 ? 1 : pageNum;

        // 如果大于最大页数，就等于最大页数
        if(pageData.getPageCount()<1) {
            pageData.setPageCount(1);
        }
        pageNum = pageNum > pageData.getPageCount() ? pageData.getPageCount() : pageNum;
            // 赋值当前页码
        pageData.setPageNum(pageNum);
        // 获取数据调用dao

        List<Books> list = bdi.getBooksList(pageData.getStart(),pageData.getPageSize());
        // 设置分页数据list到PageData中
        pageData.setList(list);
        return pageData;

    }
    public PageData getFamilyPageData(int pageNum,String family)  {
        PageData pageData = new PageData();
        // 获取总记录数
        int count = bdi.getFamilyBooksList(family).size();
        // 赋值的同时，算出总页数
        pageData.setCount(count);
        // pageNum 判断值是否正确 ，最小值是1，不允许有0或负数。
        pageNum = pageNum < 1 ? 1 : pageNum;

        // 如果大于最大页数，就等于最大页数
        if(pageData.getPageCount()<1) {
            pageData.setPageCount(1);
        }
        pageNum = pageNum > pageData.getPageCount() ? pageData.getPageCount() : pageNum;
        // 赋值当前页码
        pageData.setPageNum(pageNum);
        // 获取数据调用dao

        List<Books> list = getPageFamilyBooksList(pageData.getStart(),pageData.getPageSize(),family);
        // 设置分页数据list到PageData中
        pageData.setList(list);
        return pageData;

    }

    /**
     * 获得family分页书本列表
     */
    public List<Books> getPageFamilyBooksList(int start,int size,String family){
        List<Books> books=bdi.getFamilyBooksList(family);
        List<Books> pageBooks=new ArrayList<>();
        if(books!=null){
            for (int i = start; i <(start+size>books.size()?books.size():start+size); i++) {

                pageBooks.add(books.get(i));

            }
        }

        return pageBooks;
    }
    /**
     * 通过ID获取书本
     */
    public Books getBook(int id){
        return bdi.getBook(id);
    }
    /**
     * 修改书名
     */
    public boolean updateBook_name(int id,String book_name){
        if(bdi.updateBook_name(id,book_name)!=0){
            return true;
        }else{
            return false;
        }
    }
    /**
     * 修改定价
     */
    public boolean updateBook_price(int id,Double book_price){
        if(bdi.updateBook_price(id,book_price)!=0){
            return true;
        }else{
            return false;
        }
    }
    /**
     * 修改当当定价
     */
    public boolean updateDangdang_price(int id,Double dangdang_price){
        if(bdi.updateDangdang_price(id,dangdang_price)!=0){
            return true;
        }else{
            return false;
        }
    }
    /**
     * 修改作者
     */
    public boolean updateAuthor(int id,String author){
        if(bdi.updateAuthor(id,author)!=0){
            return true;
        }else{
            return false;
        }
    }
    /**
     * 修改出版社
     */
    public boolean updatePublishing(int id,String publishing){
        if(bdi.updatePublishing(id,publishing)!=0){
            return true;
        }else{
            return false;
        }
    }
    /**
     * 修改简介
     */
    public boolean updateSynopsis(int id,String synopsis){
        if(bdi.updateSynopsis(id,synopsis)!=0){
            return true;
        }else{
            return false;
        }
    }
    /**
     * 修改分类
     */
    public boolean updateFamily(int id,String family){
        if(bdi.updateFamily(id,family)!=0){
            return true;
        }else{
            return false;
        }
    }
}
