package com.example.libmanager.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.libmanager.facade.BorrowFacade;
import com.example.libmanager.strategy.LoanStrategy;
import com.example.libmanager.strategy.RegularLoanStrategy;
import com.example.libmanager.model.Loan;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.Map;

@RestController
@RequestMapping("/api/loans")
public class BorrowController {
    private final BorrowFacade facade;

    public BorrowController(BorrowFacade facade) {
        this.facade = facade;
    }

    @PostMapping("/borrow")
    public ResponseEntity<Loan> borrow(@RequestBody Map<String, String> body) {
        Long userId = Long.valueOf(body.get("userId"));
        Long itemId = Long.valueOf(body.get("itemId"));
        // strategy selection simplified
        LoanStrategy strategy = new RegularLoanStrategy();
        Loan loan = facade.borrow(userId, itemId, strategy);
        return ResponseEntity.ok(loan);
    }
}

@Tag(name = "Items")
@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Operation(summary = "Cria um item")
    @PostMapping
    public ResponseEntity<Item> create(@RequestBody ItemDTO dto) { ... }
}