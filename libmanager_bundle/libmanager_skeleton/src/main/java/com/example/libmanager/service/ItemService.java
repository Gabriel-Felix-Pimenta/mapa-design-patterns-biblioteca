package com.example.libmanager.service;

import org.springframework.stereotype.Service;
import com.example.libmanager.dto.ItemDTO;
import com.example.libmanager.factory.ItemFactory;
import com.example.libmanager.model.Item;
import com.example.libmanager.repository.ItemRepository;

@Service
public class ItemService {
    private final ItemRepository repo;
    public ItemService(ItemRepository repo) { this.repo = repo; }

    public Item createItem(ItemDTO dto) {
        Item item = ItemFactory.create(dto);
        return repo.save(item);
    }
}
