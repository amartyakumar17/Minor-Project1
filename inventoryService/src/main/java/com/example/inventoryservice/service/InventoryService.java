package com.example.inventoryservice.service;

import com.example.inventoryservice.dto.InventoryResponse;
import com.example.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository InventoryRepository;

    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode) {
        return InventoryRepository.findBySkuCodeIn(skuCode).stream()
                .map(inventoryData ->
                        InventoryResponse.builder()
                                .skuCode(inventoryData.getSkuCode())
                                .isInStock(inventoryData.getQuantity() > 0)
                                .build()
                ).collect(Collectors.toList());
    }
}
