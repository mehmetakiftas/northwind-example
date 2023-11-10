package com.example.northwindexample.web;

import com.example.northwindexample.business.ProductService;
import com.example.northwindexample.business.responses.GetAllProductsResponse;
import com.example.northwindexample.business.responses.GetProductsInPriceRangeResponse;
import com.example.northwindexample.business.responses.GetSeafoodProductsResponse;
import com.example.northwindexample.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<GetAllProductsResponse> getAllProducts() {
        return this.productService.getAllProducts();
    }

    @GetMapping("/seafoods")
    public List<GetSeafoodProductsResponse> getSeafoodProducts() {
        return this.productService.getSeafoodProducts();
    }

    @GetMapping("/in-price-range")
    public List<GetProductsInPriceRangeResponse> productsInPriceRange(@RequestParam double minPrice, @RequestParam double maxPrice){
        return this.productService.productsInPriceRange(minPrice, maxPrice);
    }


}
