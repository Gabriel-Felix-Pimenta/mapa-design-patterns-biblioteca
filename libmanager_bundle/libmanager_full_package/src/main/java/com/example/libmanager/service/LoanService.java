package com.example.libmanager.service;

import org.springframework.stereotype.Service;
import com.example.libmanager.model.Loan;
import com.example.libmanager.repository.LoanRepository;

import java.util.Date;

@Service
public class LoanService {
    private final LoanRepository repo;
    public LoanService(LoanRepository repo) { this.repo = repo; }

    public Loan createLoan(Long userId, Long itemId, Date loanDate, Date dueDate) {
        Loan loan = new Loan();
        loan.setUserId(userId);
        loan.setItemId(itemId);
        loan.setLoanDate(loanDate);
        loan.setDueDate(dueDate);
        loan.setRenewals(0);
        return repo.save(loan);
    }
}
