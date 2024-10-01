package com.example.library.controller;

import com.example.library.model.Book;
import com.example.library.service.BookService;
import com.example.library.service.Impl.BookServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/books")
public class LibraryController {
    private final BookService bookService;

    @GetMapping
    public String displayAllBooks(Model model) {
        model.addAttribute("books", bookService.getBooks());
        return "books/index";
    }

    @GetMapping("/{authorName}")
    public String displayAuthorBooks(@PathVariable String authorName, Model model) {

        model.addAttribute("books", bookService.getBooksByAuthor(authorName));
        return "books/author";
    }

    @GetMapping("/show/{id}")
    public String displayBook(@PathVariable int id, Model model) {
        model.addAttribute("book", bookService.getBook(id));
        return "books/show";
    }

    @GetMapping("/new")
    public String newBook() {
        return "books/new";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable int id, Model model) {
        model.addAttribute("book", bookService.getBook(id));
        return "books/edit";
    }

    @PostMapping("/create")
    public String createBook(Book book) throws JsonProcessingException {
        bookService.addBook(book);
        return "redirect:/books";
    }
    //Trans

    @PutMapping("/update/{id}")
    public String updateBook(Book book, @PathVariable int id)  throws JsonProcessingException {
        Book bookToUpdate = bookService.getBook(book.getId());
        bookToUpdate.setTitle(book.getTitle());
//        bookToUpdate.setAuthor(book.getAuthor());


        bookService.updateBook(bookToUpdate);
        return "redirect:/books";
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}

@Controller
class RedirectController {
    @GetMapping
    public String RedirectToBooks() {
        return "redirect:/books";
    }
}