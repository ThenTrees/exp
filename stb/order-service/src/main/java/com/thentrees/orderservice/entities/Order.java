package com.thentrees.orderservice.entities;

import com.thentrees.orderservice.utils.VaultEncryptConverter;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameCustomer;

    @Convert(converter = VaultEncryptConverter.class)
    private String cardNumber;

    private String productId;

    private int quantity;
}
