package com.example.northwindexample.business;

import com.example.northwindexample.business.responses.GetAllCategoriesResponse;
import com.example.northwindexample.business.responses.MostExpensiveProductsPerCategoriesResponse;
import com.example.northwindexample.core.mappers.ModelMapperService;
import com.example.northwindexample.entities.Category;
import com.example.northwindexample.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryService {
    private CategoryRepository categoryRepository;
    private ModelMapperService modelMapperService;

    public List<GetAllCategoriesResponse> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();

        List<GetAllCategoriesResponse> getAllCategoriesResponses = categories.stream()
                .map(category -> this.modelMapperService.forResponse()
                        .map(category, GetAllCategoriesResponse.class))
                .collect(Collectors.toList());

        return getAllCategoriesResponses;
    }

    public List<MostExpensiveProductsPerCategoriesResponse> mostExpensivePerCategories() {
        return categoryRepository.mostExpensivePerCategories();
    }

}



