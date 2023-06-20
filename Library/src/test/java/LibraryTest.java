import com.library.model.Author;
import com.library.model.Book;
import com.library.model.Library;
import com.library.model.Publisher;
import com.library.service.LibraryService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LibraryTest {
    Library library = new Library();
    LibraryService libraryService = new LibraryService(library);

    @Test
    public void testAddBook() {
        Author author = new Author("J.R.R. Tolkien", "British");
        Publisher publisher = new Publisher("Houghton Mifflin", "USA");
        Book book = new Book("Lord of The Rings", author, publisher);
        libraryService.addBooks(book);

        assertEquals(1, library.getBooks().size());
        assertTrue(library.getBooks().contains(book));
    }
}
