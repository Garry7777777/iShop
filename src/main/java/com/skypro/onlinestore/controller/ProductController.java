package com.skypro.onlinestore.controller;

import com.skypro.onlinestore.dto.ProductDTO;
import com.skypro.onlinestore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private  ProductService productService;

    @GetMapping
    public List<ProductDTO> findProduct(@RequestParam(defaultValue = "false", value = "sort") Boolean sort) {
        return productService.findProduct(sort);
    }

    @PostMapping
    public ProductDTO create(@RequestBody ProductDTO productDTO) {
        return productService.save(productDTO);
    }

    @PatchMapping
    public ProductDTO update(@RequestBody ProductDTO productDTO) {
        return productService.update(productDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }

    @GetMapping("/search")
    public List<ProductDTO> search(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) String categoryName) {

        return productService.search(name, description, categoryName);
    }
}
