package com.example.library.service.Impl;

import com.example.library.model.Author;
import com.example.library.model.Book;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;
import com.example.library.service.BookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookInfoService bookInfoService;
    private final AuthorRepository authorRepository;
    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public List<Book> getBooksByAuthor(String author) {
//        System.out.println(author);
//        System.out.println("lalalallalasllfal");
//        System.out.println(bookRepository.findBookById(2));
//        System.out.println(authorRepository.findAuthorById(1));
//        System.out.println(authorRepository.findByAuthorName(author).get().getBooks());
        return authorRepository.findByAuthorName(author).get().getBooks();


    }

    @Override
    public Book getBook(int id) {
//        System.out.println(bookRepository.findBookById(id));
        return bookRepository.findBookById(id);
    }


    @Override
    public Book addBook(Book book) throws JsonProcessingException {
        Book infoAboutBook = bookInfoService.getBookInfo(book.getTitle());
        System.out.println(infoAboutBook);
        Optional<Author> existingAuthor = authorRepository.findByAuthorName(infoAboutBook.getAuthor().getAuthorName());

        Author author;
        if (existingAuthor.isPresent()) {
            // Используем существующего автора
            author = existingAuthor.get();
            book.setAuthor(author);
        } else {
            // Создаем нового автора и сохраняем его в базе

            book.setAuthor(infoAboutBook.getAuthor());
                  // Сохраняем нового автора и получаем его объект
        }
        book.setDescription(infoAboutBook.getDescription());
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book book) throws JsonProcessingException {
//        Book infoAboutBook = bookInfoService.getBookInfo(book.getTitle());
//        book.setAuthor(infoAboutBook.getAuthor());
//        book.setDescription(infoAboutBook.getDescription());
        Book infoAboutBook = bookInfoService.getBookInfo(book.getTitle());
        System.out.println(infoAboutBook);
        Optional<Author> existingAuthor = authorRepository.findByAuthorName(infoAboutBook.getAuthor().getAuthorName());

        Author author;
        if (existingAuthor.isPresent()) {
            // Используем существующего автора
            author = existingAuthor.get();
            book.setAuthor(author);
        } else {
            // Создаем нового автора и сохраняем его в базе

            book.setAuthor(infoAboutBook.getAuthor());
            // Сохраняем нового автора и получаем его объект
        }
        book.setDescription(infoAboutBook.getDescription());
        return bookRepository.save(book);
    }


    @Override
    public void deleteBook(int id) {
        bookRepository.deleteBookById(id);
    }

//    public static boolean nameCorrect(String authorName) {
//        int countSpaces = authorName.length() - authorName.replaceAll(" ", "").length();
//        int firstLetter = authorName.charAt(0);
//        return (firstLetter >= 'А' && firstLetter <= 'я') && (countSpaces == 1);
//    }
//    public static boolean descriptionCorrect(String description) {
//        int descriptionLength = description.length();
//        int firstLetter = description.charAt(0);
//        return (firstLetter >= 'А' && firstLetter <= 'я') && (descriptionLength <= 300);
//    }
//    public static Book getBookInfo(JsonNode node) {
//        for (int i = 0; i < node.size(); i++) {
//            try {
//                JsonNode volumeInfo = node.get("items").get(i).get("volumeInfo");
//                String authorName = volumeInfo.get("authors").get(0).asText();
//                String description = volumeInfo.get("description").get(0).asText();
//                if (nameCorrect(authorName)) {
//                    if (descriptionCorrect(description)) {
//                        return new Book(authorName, description);
//                    }
//                    return new Book(authorName, "Описание неизвестно");
//                }
//
//            } catch (Exception e) {
//                return new Book("Автор неизвестен", "Описание неизвестно");
//            }
//
//        }
//        return new Book("Автор неизвестен", "Описание неизвестно");
//    }
}
