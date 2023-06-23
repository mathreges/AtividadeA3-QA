package com.library.controller;

import com.library.model.Author;
import com.library.model.Book;
import com.library.model.Publisher;
import com.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @PostMapping("/books")
    public List<Book> addBook(@RequestBody Book book) {
        return libraryService.addBooks(book);
    }

    @GetMapping("/books")
    public List<Book> searchBooks(@RequestParam(required = false) String title,
                                  @RequestParam(required = false) Author author,
                                  @RequestParam(required = false) Publisher publisher) {
        return libraryService.searchBooks(title, author, publisher);
    }

    @DeleteMapping("/books")
    public List<Book> removeBook(@RequestBody Book book) {
        return libraryService.removeBook(book.getTitle(), book.getAuthor(), book.getPublisher());
    }

}


