package com.library.controller;

import com.library.model.Book;
import com.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @PostMapping("/books")
    public void addBook(@RequestBody Book book) {
        libraryService.addBooks(book);
    }

}


