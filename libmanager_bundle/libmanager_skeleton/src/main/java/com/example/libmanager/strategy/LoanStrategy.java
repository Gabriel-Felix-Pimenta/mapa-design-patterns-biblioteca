package com.example.libmanager.strategy;

import java.util.Date;
import com.example.libmanager.model.*;

public interface LoanStrategy {
    Date calculateDueDate(Date loanDate);
    boolean canRenew(Object loan);
}
