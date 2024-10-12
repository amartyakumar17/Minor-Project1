package com.example.minortwo.service;

import com.example.minortwo.Repository.ProductRepository;
import com.example.minortwo.dto.ProductRequest;
import com.example.minortwo.dto.ProductResponse;
import com.example.minortwo.model.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(new BigDecimal(productRequest.getPrice()))
                .build();

        productRepository.save(product);
        log.info("Product created: {}", product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream()
                .map(product -> ProductResponse.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .description(product.getDescription())
                        .price(product.getPrice().toString())
                        .build())
                .collect(Collectors.toList());
    }
}
