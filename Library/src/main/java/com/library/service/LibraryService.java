package com.library.service;

import com.library.model.Author;
import com.library.model.Book;
import com.library.model.Library;
import com.library.model.Publisher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibraryService {

    private final Library library;

    public Library getLibrary() {
        return this.library;
    }

    public LibraryService() {
        this.library = new Library(new ArrayList<>());

        // Pre-loading books
        library.getBooks().add(new Book("The Great Gatsby", new Author("F. Scott Fitzgerald", "USA"), new Publisher("Charles Scribner's Sons", "USA")));
        library.getBooks().add(new Book("To Kill a Mockingbird", new Author("Harper Lee", "USA"), new Publisher("J.B. Lippincott & Co.", "USA")));
        library.getBooks().add(new Book("1984", new Author("George Orwell", "UK"), new Publisher("Secker & Warburg", "UK")));
        library.getBooks().add(new Book("Pride and Prejudice", new Author("Jane Austen", "UK"), new Publisher("T. Egerton", "UK")));
        library.getBooks().add(new Book("War and Peace", new Author("Leo Tolstoy", "Russia"), new Publisher("The Russian Messenger", "Russia")));
    }

    public List<Book> addBooks(Book book) {
        this.library.getBooks().add(book);
        return this.library.getBooks();
    }

    public List<Book> searchBooks(String title, Author author, Publisher publisher) {
        return library.getBooks().stream()
                .filter(book -> (title == null || book.getTitle().equals(title)) &&
                        (author == null || book.getAuthor().getName().equals(author.getName())) &&
                        (publisher == null || book.getPublisher().getName().equals(publisher.getName())))
                .collect(Collectors.toList());
    }


    public List<Book> removeBook(String title, Author author, Publisher publisher) {
        library.getBooks().removeIf(book ->
                book.getTitle().equals(title) &&
                        book.getAuthor().getName().equals(author.getName()) &&
                        book.getPublisher().getName().equals(publisher.getName()));
        return this.library.getBooks();
    }
}

