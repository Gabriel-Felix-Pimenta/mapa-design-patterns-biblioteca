package com.example.libmanager.factory;

import com.example.libmanager.dto.ItemDTO;
import com.example.libmanager.model.*;

public class ItemFactory {

    public static Item create(ItemDTO dto) {
        switch (dto.getType()) {
            case "BOOK":
                Book b = new Book(dto.getTitle(), dto.getAuthor(), dto.getIsbn());
                b.setTotalCopies(dto.getTotalCopies());
                b.setAvailableCopies(dto.getTotalCopies());
                return b;
            default:
                throw new IllegalArgumentException("Tipo desconhecido: " + dto.getType());
        }
    }
}
