package com.example.onlinestoreproject.dto;

import com.example.onlinestoreproject.model.Category;
import lombok.Data;

@Data
public class CategoryDTO {
    private Long id;
    private String name;

    public static CategoryDTO of(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        return categoryDTO;
    }

    public static Category to(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setId(categoryDTO.getId());
        category.setName(categoryDTO.getName());
        return category;
    }
}
