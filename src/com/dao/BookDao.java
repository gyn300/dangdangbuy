package com.dao;


import com.daoinf.BookDaoInf;
import com.model.Books;
import com.model.Users;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BookDao implements BookDaoInf {

    @Override
    /**
     * 增加记录
     */
    public int regist(String book_name, double book_price, double dangdang_price, String publishing, String synopsis, String family,String author) {
        String sql="insert into books(book_name,book_price,dangdang_price,publishing,synopsis,family,author) value(?,?,?,?,?,?,?)";
        PreparedStatement ps=null;
        ResultSet rs=null;
        int num=0;
        try {
            ps=Baseconn.getConn().prepareStatement(sql);
            ps.setString(1, book_name);
            ps.setDouble(2, book_price);
            ps.setDouble(3,dangdang_price);
            ps.setString(4, publishing);
            ps.setString(5, synopsis);
            ps.setString(6, family);
            ps.setString(7,author);
            num=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            Baseconn.closeAll(rs, ps);
        }
        return num;
    }
    /**
     * 通过ID获取书本
     *
     */
    @Override
    public Books getBook(int Book_id) {
        String sql="select * from books where id=?";
        Books book=null;
        PreparedStatement ps=null;
        ResultSet rs=null;

        try {
            ps=Baseconn.getConn().prepareStatement(sql);

            ps.setInt(1,Book_id);
            rs=ps.executeQuery();

            while (rs.next()) {
                int id=rs.getInt("id");
                String book_name=rs.getString("book_name");
                double book_price=rs.getDouble("book_price");
                double dangdang_price=rs.getDouble("dangdang_price");
                String author=rs.getString("author");
                String publishing=rs.getString("publishing");
                String synopsis=rs.getString("synopsis");
                String family=rs.getString("family");
                book=new Books(id,book_name,book_price,dangdang_price,publishing,synopsis,family,author);
               ;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            Baseconn.closeAll(rs, ps);
        }

        return book;
    }

    @Override
    public List<Books> getFamilyBooksList(String family) {
        String sql="select * from books where family=?";
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Books> books=new ArrayList<>();
        try {
            ps=Baseconn.getConn().prepareStatement(sql);
            ps.setString(1,family);
            rs=ps.executeQuery();
            while (rs.next()) {
                int book_id=rs.getInt("id");
                String book_name=rs.getString("book_name");
                double book_price=rs.getDouble("book_price");
                double dangdang_price=rs.getDouble("dangdang_price");
                String publishing=rs.getString("publishing");
                String synopsis=rs.getString("synopsis");

                String author=rs.getString("author");
                Books book=new Books(book_id, book_name, book_price, dangdang_price, publishing, synopsis, family,author);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            Baseconn.closeAll(rs, ps);
        }
        return books;
    }

    /**
     * 修改名字
     * @return
     */
    public int updateBook_name(int id ,String book_name) {
        String sql="update books set book_name=? WHERE id=?";
        PreparedStatement ps=null;
        ResultSet rs=null;
        int num=0;
        try {
            ps=Baseconn.getConn().prepareStatement(sql);
            ps.setString(1, book_name);
            ps.setInt(2, id);

            num=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            Baseconn.closeAll(rs, ps);
        }
        return num;
    }
    /**
     * 修改定价
     * @return
     */
    public int updateBook_price(int id ,double book_price) {
        String sql="update books set book_price=? WHERE id=?";
        PreparedStatement ps=null;
        ResultSet rs=null;
        int num=0;
        try {
            ps=Baseconn.getConn().prepareStatement(sql);
            ps.setDouble(1, book_price);
            ps.setInt(2, id);

            num=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            Baseconn.closeAll(rs, ps);
        }
        return num;
    }
    /**
     * 修改当当定价
     * @return
     */
    public int updateDangdang_price(int id ,double dangdang_price) {
        String sql="update books set dangdang_price=? WHERE id=?";
        PreparedStatement ps=null;
        ResultSet rs=null;
        int num=0;
        try {
            ps=Baseconn.getConn().prepareStatement(sql);
            ps.setDouble(1, dangdang_price);
            ps.setInt(2, id);

            num=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            Baseconn.closeAll(rs, ps);
        }
        return num;
    }
    /**
     * 修改出版社
     * @return
     */
    public int updatePublishing(int id ,String publishing) {
        String sql="update books set publishing=? WHERE id=?";
        PreparedStatement ps=null;
        ResultSet rs=null;
        int num=0;
        try {
            ps=Baseconn.getConn().prepareStatement(sql);
            ps.setString(1, publishing);
            ps.setInt(2, id);

            num=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            Baseconn.closeAll(rs, ps);
        }
        return num;
    }
    /**
     * 修改简介
     * @return
     */
    public int updateSynopsis(int id ,String synopsis) {
        String sql="update books set synopsis=? WHERE id=?";
        PreparedStatement ps=null;
        ResultSet rs=null;
        int num=0;
        try {
            ps=Baseconn.getConn().prepareStatement(sql);
            ps.setString(1, synopsis);
            ps.setInt(2, id);

            num=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            Baseconn.closeAll(rs, ps);
        }
        return num;
    }
    /**
     * 修改分类
     * @return
     */
    public int updateFamily(int id ,String family) {
        String sql="update books set family=? WHERE id=?";
        PreparedStatement ps=null;
        ResultSet rs=null;
        int num=0;
        try {
            ps=Baseconn.getConn().prepareStatement(sql);
            ps.setString(1, family);
            ps.setInt(2, id);

            num=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            Baseconn.closeAll(rs, ps);
        }
        return num;
    }
    /**
     * 修改作者
     * @return
     */
    public int updateAuthor(int id ,String author) {
        String sql="update books set author=? WHERE id=?";
        PreparedStatement ps=null;
        ResultSet rs=null;
        int num=0;
        try {
            ps=Baseconn.getConn().prepareStatement(sql);
            ps.setString(1, author);
            ps.setInt(2, id);

            num=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            Baseconn.closeAll(rs, ps);
        }
        return num;
    }
    @Override
    public List<Books> getAllBooks() {
        String sql="select * from books";
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Books> books=new ArrayList<>();
        try {
            ps=Baseconn.getConn().prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                int book_id=rs.getInt("id");
                String book_name=rs.getString("book_name");
                double book_price=rs.getDouble("book_price");
                double dangdang_price=rs.getDouble("dangdang_price");
                String publishing=rs.getString("publishing");
                String synopsis=rs.getString("synopsis");
                String family=rs.getString("family");
                String author=rs.getString("author");
                Books book=new Books(book_id, book_name, book_price, dangdang_price, publishing, synopsis, family,author);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            Baseconn.closeAll(rs, ps);
        }
          return books;
    }
    /**
     * 删除商品
     */
    @Override
    public int deleteBook(int id){
        String sql="delete from books where id=?";
        PreparedStatement ps=null;
        ResultSet rs=null;
        int num=0;
        try {
            ps=Baseconn.getConn().prepareStatement(sql);
            ps.setInt(1, id);
            num=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            Baseconn.closeAll(rs, ps);
        }
        return num;
    }
    @Override
    public List<Books> getBooksList(int start, int size) {
        List<Books> data = new LinkedList<Books>();
        PreparedStatement ps=null;
        ResultSet rs=null;
        // 分页获取数据
        String sql = "select * from books limit ? , ?";
        try {
            ps = Baseconn.getConn().prepareStatement(sql);
            ps.setInt(1, start);
            ps.setInt(2, size);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String book_name = rs.getString("book_name");
                double book_price = rs.getDouble("book_price");
                double dangdang_price = rs.getDouble("dangdang_price");
                String publishing = rs.getString("publishing");
                String synopsis = rs.getString("synopsis");
                String family = rs.getString("family");
                String author=rs.getString("author");
                data.add(new Books(id, book_name, book_price, dangdang_price, publishing, synopsis, family,author));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }finally{
            Baseconn.closeAll(rs, ps);
        }
        return data;
    }
    @Override
    public int getCount() {
        int count = 0;


        // 分页获取数据
        String sql = "select count(1) as total from books ";
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {

        ps = Baseconn.getConn().prepareStatement(sql);

        rs = ps.executeQuery();

        if (rs.next()) {
            count = rs.getInt("total");
        }

        }catch (SQLException e) {
            e.printStackTrace();
        }finally{
            Baseconn.closeAll(rs, ps);
        }


        return count;
    }


}
