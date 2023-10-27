package seminars.fourth.book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InMemoryBookRepositoryTest {

    InMemoryBookRepository im;

    @BeforeEach
    void setUp() {
        im = new InMemoryBookRepository();
    }

    @Test
    void checkInMemoryBookRepositoryGetById() {
        assertThat(im.findById("1")).
                isEqualTo(new Book("1", "Book1", "Author1"));
    }

    @Test
    void checkInMemoryBookRepositoryGetAll() {

        List<Book>bookList = im.findAll();

        assertThat(bookList).isEqualTo(Arrays.asList(
                new Book("1", "Book1", "Author1"),
                new Book("2", "Book2", "Author2"))
        );
    }
}
