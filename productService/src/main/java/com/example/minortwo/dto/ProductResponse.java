package com.example.minortwo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
// This class is used to send the response back to the client
// this is a good practice to have a separate class for response(DTO and Models class)
public class ProductResponse {
    private String id;
    private String name;
    private String description;
    private String price;
}
