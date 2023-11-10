package com.example.northwindexample.business.responses;

import com.example.northwindexample.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProductsResponse {
    private String productName;
    private Category category;
}





