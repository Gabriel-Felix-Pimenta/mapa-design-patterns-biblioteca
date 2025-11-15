package com.example.libmanager.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.libmanager.model.Loan;
public interface LoanRepository extends JpaRepository<Loan, Long> {}