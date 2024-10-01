package com.example.library.service;


import com.example.library.model.Author;
import com.example.library.model.Book;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

public interface BookService {
    public List<Book> getBooks();
    public Book getBook(int id);
    public Book addBook(Book book) throws JsonProcessingException;
    public Book updateBook(Book book) throws JsonProcessingException;
    public void deleteBook(int id);
    public List<Book> getBooksByAuthor(String author);
//    public boolean nameCorrect(String authorName);
//    public boolean descriptionCorrect(String description);
//    public Book getBookInfo(JsonNode node);
}
