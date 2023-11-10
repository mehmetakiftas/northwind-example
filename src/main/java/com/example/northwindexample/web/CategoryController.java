package com.example.northwindexample.web;

import com.example.northwindexample.business.CategoryService;
import com.example.northwindexample.business.responses.GetAllCategoriesResponse;
import com.example.northwindexample.business.responses.MostExpensiveProductsPerCategoriesResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<GetAllCategoriesResponse> getAllCategories() {
        return this.categoryService.getAllCategories();
    }


    @GetMapping("/most-expensive-products-per")
    public List<MostExpensiveProductsPerCategoriesResponse> mostExpensivePerCategories() {
        return this.categoryService.mostExpensivePerCategories();
    }

}