package com.example.northwindexample.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProductsPerSuppliersResponse {
    private String supplierName;
    private Long productCount;
}
