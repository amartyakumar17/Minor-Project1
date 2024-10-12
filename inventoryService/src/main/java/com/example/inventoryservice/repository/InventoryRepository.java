package com.example.inventoryservice.repository;

import com.example.inventoryservice.model.InventoryData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepository extends JpaRepository<InventoryData, Long> {
    List<InventoryData> findBySkuCodeIn(List<String> skuCode);

}
