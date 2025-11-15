package com.example.libmanager.factory;

import com.example.libmanager.dto.ItemDTO;
import com.example.libmanager.model.Book;
import com.example.libmanager.model.Item;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ItemFactoryTest {

    @Test
    void shouldCreateBookFromDto() {
        ItemDTO dto = new ItemDTO();
        dto.setType("BOOK");
        dto.setTitle("Factory Book");
        dto.setAuthor("Author");
        dto.setIsbn("ISBN-1234");
        dto.setTotalCopies(3);

        Item item = ItemFactory.create(dto);

        assertNotNull(item);
        assertTrue(item instanceof Book);
        assertEquals("Factory Book", item.getTitle());
        assertEquals(3, item.getTotalCopies());
        assertEquals(3, item.getAvailableCopies());
    }

    @Test
    void shouldThrowForUnknownType() {
        ItemDTO dto = new ItemDTO();
        dto.setType("UNKNOWN");
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            ItemFactory.create(dto);
        });
        assertTrue(ex.getMessage().contains("Tipo desconhecido"));
    }
}
