package org.example;

import java.math.BigDecimal;
import java.util.Date;

public record Transaction(BigDecimal amount, BigDecimal balance, Date date) {
}
