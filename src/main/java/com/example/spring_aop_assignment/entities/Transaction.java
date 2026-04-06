package com.example.spring_aop_assignment.entities;


import com.example.spring_aop_assignment.enums.TransactionType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transactions")
@Builder
public class Transaction{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Positive(message = "Amount should be positive")
    private BigDecimal amount;

    @Size(min = 1, max = 50,message = "Description should be between 1 and 50 characters")
    private String description;

    @PositiveOrZero(message = "Tax should be zero or positive")
    private BigDecimal tax;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;


}
