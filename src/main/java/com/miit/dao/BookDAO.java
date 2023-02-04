package com.miit.dao;

import com.miit.dto.Book;

import java.sql.*;
import java.util.ArrayList;

public class BookDAO {

    private Connection jdbcConnection;

    public ArrayList<Book> listAllBooks() throws SQLException {
        connect();
        ArrayList<Book> bookList = new ArrayList<>();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM book");
        while (resultSet.next()) {
            String title = resultSet.getString("title");
            String author = resultSet.getString("author");
            String price = resultSet.getString("price");

            Book book = new Book(title, author, Float.parseFloat(price));
            bookList.add(book);
        }
        resultSet.close();
        statement.close();
        disconnect();
        return bookList;
    }

    public boolean insertBook(Book book) throws SQLException {
        connect();
        String sql = "INSERT INTO book (title,author,price) VALUES (?,?,?)";
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, book.getTitle());
        statement.setString(2, book.getAuthor());
        statement.setString(3, String.valueOf(book.getPrice()));
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    public void connect() {
        try {
            if (jdbcConnection == null || jdbcConnection.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String jdbcURL = "jdbc:mysql://localhost:3306/book";
                String jdbcUsername = "root";
                String jdbcPassword = "Tudsj_9921";
                jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);

//                System.out.printf("MySQL Connection Established");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            if (jdbcConnection != null && !jdbcConnection.isClosed()) {
                jdbcConnection.close();

//                System.out.printf("MySQL Connection Closed");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
