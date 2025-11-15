package com.example.libmanager.strategy;

import java.util.Calendar;
import java.util.Date;

public class RegularLoanStrategy implements LoanStrategy {
    @Override
    public Date calculateDueDate(Date loanDate) {
        Calendar c = Calendar.getInstance();
        c.setTime(loanDate);
        c.add(Calendar.DAY_OF_MONTH, 14);
        return c.getTime();
    }

    @Override
    public boolean canRenew(Object loan) {
        return true;
    }
}
