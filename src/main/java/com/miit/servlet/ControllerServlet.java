package com.miit;

import com.miit.dto.Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/books/*")
public class ControllerServlet extends HttpServlet {
    ArrayList<Book> bookList = new ArrayList<>();

    public ControllerServlet() {
        super();
        bookList.add(new Book("Lord of the rings", "J. R. R. Tolkien", 5.5F));
        bookList.add(new Book("Harry Potter", "George R.R. Martin", 8.99F));
        bookList.add(new Book("The best of me", "Nicholas Sparks", 7.99F));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*request.setAttribute("book_list", bookList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/BookList.jsp");
        dispatcher.forward(request, response);*/

        String action = request.getPathInfo();
        if (action.equals("/new")) {
            addBook(request, response);
        } else {
            listBooks(request, response);
        }
    }

    private void addBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/BookForm.jsp");
        dispatcher.forward(request, response);
    }

    private void listBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("book_list", bookList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/BookList.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getPathInfo();
        if (action.equals("/insert")) {
            insertBook(request, response);
        }
    }

    private void insertBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String title = request.getParameter("bookTitle");
        String author = request.getParameter("bookAuthor");
        String price = request.getParameter("bookPrice");

        Book book = new Book(title, author, Float.parseFloat(price));
        bookList.add(book);

        response.sendRedirect("list");
    }
}
