package com.skypro.onlinestore.model;

import lombok.*;
import javax.persistence.*;
import java.time.Instant;
import java.util.Set;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Instant creationDate = Instant.now();
    private Instant modificationDate = Instant.now();
    @ManyToMany
    private Set<Category> categories;
}