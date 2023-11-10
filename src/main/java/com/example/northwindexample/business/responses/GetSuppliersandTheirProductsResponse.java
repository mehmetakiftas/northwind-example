package com.example.northwindexample.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetSuppliersandTheirProductsResponse {
    private String supplierName;
    private List<String> productArray;
}
