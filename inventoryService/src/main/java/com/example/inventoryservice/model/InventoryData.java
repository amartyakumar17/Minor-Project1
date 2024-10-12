package com.example.inventoryservice.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tableInventory")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InventoryData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String skuCode;
    //check product is in stock or not
    private Integer quantity;
}
