package com.miit.servlet;

import com.miit.dao.BookDAO;
import com.miit.dto.Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(value = "/books/*", loadOnStartup = 1)
public class ControllerServlet extends HttpServlet {
    private final BookDAO bookDAO;

    public ControllerServlet() {
        super();
        bookDAO = new BookDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setDateHeader("Expires", 0); // Proxies.

        String action = request.getPathInfo();
        if (action.equals("/new")) {
            addBook(request, response);
        } else {
            try {
                listBooks(request, response);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void addBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/BookForm.jsp");
        dispatcher.forward(request, response);
    }

    private void listBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        ArrayList<Book> bookList = bookDAO.listAllBooks();
        request.setAttribute("book_list", bookList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/BookList.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getPathInfo();
        if (action.equals("/insert")) {
            try {
                insertBook(request, response);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void insertBook(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        String title = request.getParameter("bookTitle");
        String author = request.getParameter("bookAuthor");
        String price = request.getParameter("bookPrice");

        Book book = new Book(title, author, Float.parseFloat(price));
        bookDAO.insertBook(book);
        response.sendRedirect("list");
    }
}
