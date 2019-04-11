package com.hibernate.dao;

import com.hibernate.entity.Book;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author :Mr.Xu
 * Date    :2019-4-9
 */
public class BookDao {
    private Session session=null;

    private void doBefore(){
        System.out.println("=111111111");

        session = HibernateUtil.getSession();
        System.out.println("2222222");

        session.beginTransaction();

    }

    private   void doAfter(){

        session.getTransaction().commit();
        session.close();
    }
    //查询所有
    public List<Book>  queryAll(){
        doBefore();
        String hql ="from Book  ";
        Query<Book> query = session.createQuery(hql, Book.class);
        List<Book> list = query.list();
        doAfter();
        return list;
    }
    //通过id查询书籍
    public  Book  queryOneById(int id ){
        doBefore();
        String hql ="from Book where id= :id ";
        Query<Book> query = session.createQuery(hql, Book.class);
        query.setParameter("id",1);
        Book book = query.list().get(0);
        doAfter();

        return book;
    }
    //添加
    public void add(Book book){
        doBefore();
        session.save(book);
        doAfter();

    }
    public void update(Book book){
        doBefore();
        session.update(book);
        doAfter();

    }

    public void delete(Book book){
        doBefore();
        session.delete(book);
        doAfter();

    }

}
