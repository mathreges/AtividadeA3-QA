import com.library.model.Author;
import com.library.model.Book;
import com.library.model.Publisher;
import com.library.service.LibraryService;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LibraryTest {
    private LibraryService libraryService;

    @Before
    public void setUp() {
        libraryService = new LibraryService();
    }

    @Test
    public void testAddBook() {
        Author author = new Author("J.R.R. Tolkien", "British");
        Publisher publisher = new Publisher("Houghton Mifflin", "USA");
        Book book = new Book("Lord of The Rings", author, publisher);
        libraryService.addBooks(book);

        assertEquals(6, libraryService.getLibrary().getBooks().size()); // 5 pre-loaded books + 1 added
        assertTrue(libraryService.getLibrary().getBooks().contains(book));
    }

    @Test
    public void testSearchBooks() {
        Author author = new Author("F. Scott Fitzgerald", "USA");
        Publisher publisher = new Publisher("Charles Scribner's Sons", "USA");
        List<Book> books = libraryService.searchBooks("The Great Gatsby", author, publisher);

        assertEquals(1, books.size());
        assertEquals("The Great Gatsby", books.get(0).getTitle());
    }

    @Test
    public void testRemoveBook() {
        Author author = new Author("F. Scott Fitzgerald", "USA");
        Publisher publisher = new Publisher("Charles Scribner's Sons", "USA");
        libraryService.removeBook("The Great Gatsby", author, publisher);

        List<Book> books = libraryService.searchBooks("The Great Gatsby", author, publisher);
        assertTrue(books.isEmpty());

        assertEquals(4, libraryService.getLibrary().getBooks().size()); // 5 pre-loaded books - 1 removed
    }
}
