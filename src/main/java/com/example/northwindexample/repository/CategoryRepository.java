package com.example.northwindexample.repository;

import com.example.northwindexample.business.responses.MostExpensiveProductsPerCategoriesResponse;
import com.example.northwindexample.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    // Bir kategorideki en pahalı ürün
    @Query(value = "SELECT new com.example.northwindexample.business.responses.MostExpensiveProductsPerCategoriesResponse(p.category.categoryName, p.productName, p.unitPrice) " +
            "FROM Product p " +
            "INNER JOIN Category c ON p.category.id = c.categoryId " +
            "WHERE (categoryId, p.unitPrice) IN(" +
            "SELECT categoryId, MAX(unitPrice) " +
            "FROM Product p " +
            "GROUP BY p.category.id) ")
    List<MostExpensiveProductsPerCategoriesResponse> mostExpensivePerCategories();



}
