package seminars.fourth.book;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BookTest {

    Book book;

    @BeforeEach
    void setUp() {
        book = new Book("1","first","firstAuthor");
    }
    @Test
    void checkGetId() {
        assertThat(book.getId()).isEqualTo("1");
    }

    @Test
    void checkGetTitle() {
        assertThat(book.getTitle()).isEqualTo("first");
    }

    @Test
    void checkGetAuthor() {
        assertThat(book.getAuthor()).isEqualTo("firstAuthor");
    }

    @Test
    void checkSetAuthor() {
        book.setAuthor("famousAuthor");

        assertThat(book.getAuthor()).isEqualTo("famousAuthor");
    }

}
