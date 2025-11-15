package com.example.libmanager.facade;

import org.springframework.stereotype.Service;
import com.example.libmanager.service.ItemService;
import com.example.libmanager.service.LoanService;
import com.example.libmanager.strategy.LoanStrategy;
import com.example.libmanager.model.Item;
import com.example.libmanager.model.Loan;

import java.util.Date;

@Service
public class BorrowFacade {
    private final LoanService loanService;
    private final ItemService itemService;

    public BorrowFacade(LoanService loanService, ItemService itemService) {
        this.loanService = loanService;
        this.itemService = itemService;
    }

    public Loan borrow(Long userId, Long itemId, LoanStrategy strategy) {
        Item item = itemService.findById(itemId).orElseThrow(() -> new IllegalStateException("Item não encontrado"));
        if (item.getAvailableCopies() <= 0) {
            throw new IllegalStateException("Item indisponível");
        }
        Date now = new Date();
        Date due = strategy.calculateDueDate(now);
        Loan loan = loanService.createLoan(userId, itemId, now, due);
        itemService.decrementAvailableCopies(itemId);
        return loan;
    }
}
