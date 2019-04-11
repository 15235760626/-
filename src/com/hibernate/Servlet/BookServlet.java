package com.hibernate.Servlet;

import com.hibernate.dao.BookDao;
import com.hibernate.entity.Book;
import com.hibernate.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookServlet",urlPatterns = "/BookServlet",initParams = {@WebInitParam(name ="pageCount" ,value = "5")})
public class BookServlet extends HttpServlet {
         private BookDao dao = new BookDao();

     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        String action = request.getParameter("action");
         System.out.println(action);
        if ("query".equals(action)){
            query(request,response);
        } else if ("add".equals(action)){
            add(request,response);
        }else if ("delete".equals(action)){
            delete(request,response);
        }else if ("update".equals(action)){
            update(request,response);
        }else if ("queryOne".equals(action))
            queryOne(request,response);
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> all = dao.queryAll();
        request.setAttribute("all",all);
        request.getRequestDispatcher("/query.jsp").forward(request,response);
    }





    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookName = request.getParameter("name");
        Book book = new Book(bookName);
        dao.add(book);
        response.getWriter().print("添加成功");


    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int bookId=-1;
        if(!StringUtil.isEmpty(id)){
            bookId=Integer.parseInt(id);
        }
        Book book = dao.queryOneById(Integer.parseInt(id));
        dao.delete(book);
        response.getWriter().print("删除成功");

    }

    //修改
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String bookId = request.getParameter("bookId");
        String bookName = request.getParameter("bookName");

        Book book = new Book(Integer.parseInt(bookId),bookName);
        dao.update(book);
        response.getWriter().print("修改成功");
    }
    protected void queryOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        dao.queryOneById(Integer.parseInt(id));
        response.getWriter().print("添加成功");
        request.getRequestDispatcher("/queryOne.jsp").forward(request,response);


    }
}
