package com.example.libmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.libmanager.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {}
