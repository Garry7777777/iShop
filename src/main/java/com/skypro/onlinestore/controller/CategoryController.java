package com.skypro.onlinestore.controller;

import com.skypro.onlinestore.dto.CategoryDTO;
import com.skypro.onlinestore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<CategoryDTO> findAll(){
        return categoryService.findAll();
    }
}