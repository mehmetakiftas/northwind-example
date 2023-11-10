package com.example.northwindexample.web;

import com.example.northwindexample.business.ProductService;
import com.example.northwindexample.business.SupplierService;
import com.example.northwindexample.business.responses.GetAllSuppliersResponse;
import com.example.northwindexample.business.responses.GetCajunDelightsResponse;
import com.example.northwindexample.business.responses.GetProductsPerSuppliersResponse;
import com.example.northwindexample.business.responses.GetSuppliersandTheirProductsResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/supplier")
@AllArgsConstructor
public class SupplierController {
    private SupplierService supplierService;
    private ProductService productService;
    @GetMapping
    public List<GetAllSuppliersResponse> getAllSuppliers() {
        return this.supplierService.getAllSuppliers();
    }

    @GetMapping("/no-cajun-delights")
    public List<GetCajunDelightsResponse> getCajunDelights() {
        return productService.getCajunDelights();
    }

    @GetMapping("/products-per")
    public List<GetProductsPerSuppliersResponse> productsPerSuppliers(){
        return this.supplierService.productsPerSuppliers();
    }

    @GetMapping("/suppliers-and-their-products")
    public List<GetSuppliersandTheirProductsResponse> getSuppliersandTheirProducts(){
        return supplierService.getSuppliersandTheirProducts();
    }

}
