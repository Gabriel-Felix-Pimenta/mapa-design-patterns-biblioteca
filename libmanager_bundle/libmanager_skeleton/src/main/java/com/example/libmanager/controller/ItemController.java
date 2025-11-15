package com.example.libmanager.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.libmanager.dto.ItemDTO;
import com.example.libmanager.model.Item;
import com.example.libmanager.service.ItemService;

@RestController
@RequestMapping("/api/items")
public class ItemController {
    private final ItemService service;
    public ItemController(ItemService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<Item> create(@RequestBody ItemDTO dto) {
        Item created = service.createItem(dto);
        return ResponseEntity.ok(created);
    }
}
