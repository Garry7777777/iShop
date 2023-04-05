package com.skypro.onlinestore.dto;

import com.skypro.onlinestore.model.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toSet;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Long id;
    private String name;
    private String description;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Instant creationDate;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Instant modificationDate;
    private List<CategoryDTO> categories;

    public static ProductDTO toDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setCreationDate(product.getCreationDate());
        dto.setModificationDate(product.getModificationDate());
        dto.setCategories(product.getCategories().stream().map(CategoryDTO::toDTO).collect(Collectors.toList()));
        return dto;
    }

    public Product toProduct() {
        Product product = new Product();
        product.setId(this.getId());
        product.setName(this.getName());
        product.setDescription(this.getDescription());
        product.setCreationDate(this.getCreationDate());
        product.setModificationDate(this.getModificationDate());
        product.setCategories(this.getCategories().stream().map(CategoryDTO::toCategory).collect(toSet()));
        return product;
    }
}