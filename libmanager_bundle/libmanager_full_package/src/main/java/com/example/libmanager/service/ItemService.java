package com.example.libmanager.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.libmanager.dto.ItemDTO;
import com.example.libmanager.factory.ItemFactory;
import com.example.libmanager.model.Item;
import com.example.libmanager.repository.ItemRepository;

import java.util.Optional;

@Service
public class ItemService {
    private final ItemRepository repo;
    public ItemService(ItemRepository repo) { this.repo = repo; }

    public Item createItem(ItemDTO dto) {
        Item item = ItemFactory.create(dto);
        return repo.save(item);
    }

    public Optional<Item> findById(Long id) {
        return repo.findById(id);
    }

    @Transactional
    public void decrementAvailableCopies(Long id) {
        Item it = repo.findById(id).orElseThrow(() -> new IllegalStateException("Item não encontrado"));
        if (it.getAvailableCopies() <= 0) throw new IllegalStateException("Sem cópias disponíveis");
        it.setAvailableCopies(it.getAvailableCopies()-1);
        repo.save(it);
    }
}
