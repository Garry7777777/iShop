package com.skypro.onlinestore.service;

import com.skypro.onlinestore.dto.ProductDTO;
import com.skypro.onlinestore.model.Product;
import com.skypro.onlinestore.repository.ProductRepository;
import com.skypro.onlinestore.repository.Specification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> findProduct(Boolean sort) {
        List<Product> products = productRepository.findFetchAllBy(
                sort ?
                        Sort.by(Sort.Direction.DESC, "creationDate") :
                        Sort.unsorted());
        return products.stream().map(ProductDTO::toDTO).collect(Collectors.toList());
    }

    public ProductDTO save(ProductDTO productDTO) {
        productDTO.setId(null);
        productDTO.setModificationDate(Instant.now());
        productDTO.setCreationDate(Instant.now());
        productRepository.save(productDTO.toProduct());
        return productDTO;
    }

    public ProductDTO update(ProductDTO productDTO) {
        productDTO.setCreationDate(null);
        productDTO.setModificationDate(Instant.now());
        productRepository.save(productDTO.toProduct());
        return productDTO;
    }

    public void delete(Long productId) {
        productRepository.deleteById(productId);
    }

    public List<ProductDTO> search(String name, String description, String categoryName) {
        List<Product> products = productRepository
                .findAll(Specification.byName(name)
                .and(Specification.byDescription(description))
                .and(Specification.byCategory(categoryName)));
        return products.stream().map(ProductDTO::toDTO).collect(Collectors.toList());
    }
}