package com.example.northwindexample.repository;

import com.example.northwindexample.business.responses.GetCajunDelightsResponse;
import com.example.northwindexample.business.responses.GetSeafoodProductsResponse;
import com.example.northwindexample.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    // Seafood kategorisindeki ürünleri listeleme
    @Query(value = "SELECT new com.example.northwindexample.business.responses.GetSeafoodProductsResponse(p.productName, p.category.categoryName) " +
            "FROM Product p " +
            "INNER JOIN Category c ON p.category.id = c.categoryId " +
            "WHERE c.categoryName ='Seafood'")
    List<GetSeafoodProductsResponse> getSeafoodProducts();

    // New Orleans Cajun Delights tedarikçisinin ürünlerini listeleme
    @Query(value = "SELECT new com.example.northwindexample.business.responses.GetCajunDelightsResponse(p.productName) " +
            "FROM Product p " +
            "INNER JOIN Supplier s ON p.supplier.id = s.supplierId " +
            "WHERE s.supplierName = 'New Orleans Cajun Delights' ")
    List<GetCajunDelightsResponse> getCajunDelights();


    // Kullanıcıdan alınan 2 değer arasındaki ürünleri listeleme
    @Query(nativeQuery = true,
    value = "SELECT * " +
            "FROM products p " +
            "WHERE p.unit_price " +
            "BETWEEN :minPrice AND :maxPrice " +
            "ORDER BY p.unit_price")
    List<Product> productsInPriceRange(@Param("minPrice") double minPrice, @Param("maxPrice") double maxPrice);

}

