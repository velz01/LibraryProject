package com.example.library.service.Impl;

import com.example.library.model.Author;
import com.example.library.model.Book;
import com.example.library.service.ApiService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BookInfoService {
    public final ApiService apiService;

    public Book getBookInfo(String bookName) throws JsonProcessingException {
        JsonNode node = apiService.fetchBookData(bookName);
        Author author = new Author();
        author.setAuthorName("Автор неизвестен");
        Book book = new Book(author, "Описание неизвестно");
        for (int i = 0; i < node.size(); i++) {
            try {
                if (!node.has("items")) {
                    System.err.println("Не нашлось элемента items");
                    break;
                }
                JsonNode volumeInfo = node.get("items").get(i).get("volumeInfo");
                if (volumeInfo.has("authors")) {
                    String authorName = volumeInfo.get("authors").get(0).asText();

                    if (author.getAuthorName().equals("Автор неизвестен") && nameCorrect(authorName)) {
                        author.setAuthorName(authorName);
                        book.setAuthor(author);
                    }
                }

                if (volumeInfo.has("description")) {
                    String description = volumeInfo.get("description").asText();
                    if (book.getDescription().equals("Описание неизвестно") && descriptionCorrect(description)) {
                        book.setDescription(description);
                    }
                }
                if (!book.getDescription().equals("Описание неизвестно") && !author.getAuthorName().equals("Автор неизвестен")) {
                    break;
                }

            } catch (Exception e) {
                System.err.println("Ошибка при обработке данных книги: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return book;
    }
    public boolean nameCorrect(String authorName) {
        int countSpaces = authorName.length() - authorName.replaceAll(" ", "").length();
        int firstLetter = authorName.charAt(0);
        return (firstLetter >= 'А' && firstLetter <= 'я') && (countSpaces == 1);
    }
    public boolean descriptionCorrect(String description) {
        int descriptionLength = description.length();
        int firstLetter = description.charAt(0);
        return (firstLetter >= 'А' && firstLetter <= 'я') && (descriptionLength <= 500);
    }
}
