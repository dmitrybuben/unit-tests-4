package seminars.fourth.book;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class BookServiceTest {

    BookRepository bookRepositoryMock;
    BookService bookService;

    @BeforeEach
    void setUp() {
        bookRepositoryMock = mock(BookRepository.class);
        bookService = new BookService(bookRepositoryMock);
    }

    @Test
    void checkFindBookById() {
        when(bookRepositoryMock.findById("one")).
                thenReturn(new Book("first", "firstBook", "firstAuthor"));

        Book testbook = bookService.findBookById("one");

        assertThat(testbook).isEqualTo(new Book("first", "firstBook", "firstAuthor"));
    }

    @Test
    void checkFindAll() {
        when(bookRepositoryMock.findAll()).
                thenReturn(Arrays.asList(
                        new Book("first", "firstBook", "firstAuthor"),
                        new Book("second", "secondBook","secondAuthor")
                ));
        List<Book>bookList = bookService.findAllBooks();

        verify(bookRepositoryMock,times(1)).findAll();
        assertThat(bookList).
                isNotEmpty().
                hasSize(2).
                containsExactly(
                        new Book("first", "firstBook", "firstAuthor"),
                        new Book("second", "secondBook","secondAuthor")
                );
    }
}