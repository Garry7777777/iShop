package com.skypro.onlinestore.service;

import com.skypro.onlinestore.dto.CategoryDTO;
import com.skypro.onlinestore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryDTO> findAll() {
        return categoryRepository.findAll()
                .stream().map(CategoryDTO::toDTO).collect(Collectors.toList());
    }
}
