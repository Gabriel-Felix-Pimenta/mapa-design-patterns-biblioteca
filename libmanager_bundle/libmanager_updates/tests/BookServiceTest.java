
package com.example.libmanager.service;

import com.example.libmanager.model.Book;
import com.example.libmanager.repository.BookRepository;
import org.junit.jupiter.api.*;
import org.mockito.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceTest {

    @Mock
    private BookRepository repo;

    @InjectMocks
    private BookService service;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnAllBooks() {
        List<Book> list = List.of(new Book(1L, "Test", "Author", 2020));
        when(repo.findAll()).thenReturn(list);

        assertEquals(1, service.getAllBooks().size());
    }

    @Test
    void shouldSaveBook() {
        Book b = new Book(null, "New", "Author", 2021);
        when(repo.save(b)).thenReturn(new Book(1L, "New", "Author", 2021));

        Book result = service.saveBook(b);

        assertNotNull(result.getId());
    }
}
