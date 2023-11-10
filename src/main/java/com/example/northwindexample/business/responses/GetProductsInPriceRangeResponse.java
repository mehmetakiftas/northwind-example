package com.example.northwindexample.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProductsInPriceRangeResponse {
    private String productName;
    private double unitPrice;
}
