package com.example.northwindexample.business;

import com.example.northwindexample.business.responses.GetAllProductsResponse;
import com.example.northwindexample.business.responses.GetCajunDelightsResponse;
import com.example.northwindexample.business.responses.GetProductsInPriceRangeResponse;
import com.example.northwindexample.business.responses.GetSeafoodProductsResponse;
import com.example.northwindexample.core.mappers.ModelMapperService;
import com.example.northwindexample.entities.Product;
import com.example.northwindexample.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ModelMapperService modelMapperService;

    public List<GetAllProductsResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();

        List<GetAllProductsResponse> getAllResponses = products.stream()
                .map(product -> this.modelMapperService.forResponse()
                        .map(product, GetAllProductsResponse.class))
                .collect(Collectors.toList());

        return getAllResponses;
    }

    public List<GetSeafoodProductsResponse> getSeafoodProducts() {
        return productRepository.getSeafoodProducts();
    }

    public List<GetCajunDelightsResponse> getCajunDelights() {
        return productRepository.getCajunDelights();
    }

    public List<GetProductsInPriceRangeResponse> productsInPriceRange(double minPrice, double maxPrice){
        List<Product> products = productRepository.productsInPriceRange(minPrice, maxPrice);
        List<GetProductsInPriceRangeResponse> responses = products.stream()
                .map(product -> this.modelMapperService.forResponse()
                        .map(product, GetProductsInPriceRangeResponse.class))
                .collect(Collectors.toList());
        return responses;
    }

}


