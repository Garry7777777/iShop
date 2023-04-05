package com.skypro.onlinestore.repository;

import com.skypro.onlinestore.model.Category;
import com.skypro.onlinestore.model.Product;
import javax.persistence.criteria.*;

//        Спецификации дублируют Join, но это известный баг. Можно решить вот так:
//
//        Join<Object, Object> categories = (Join<Object, Object>) root.fetch("categories", JoinType.LEFT);
//        и вынести в отдельный метод fetch вот так:
//
//        return (root, query, criteriaBuilder) -> {
//        if (root.getFetches().stream().noneMatch(productFetch -> productFetch.getAttribute().getName().equals("categories")))
//        root.fetch("categories", JoinType.LEFT);
//
//        return criteriaBuilder.conjunction();
//        };
//
public class Specification {

    public static org.springframework.data.jpa.domain.Specification<Product> fetchCategories(){
        return (root, query, criteriaBuilder) -> {
        if (root.getFetches()
                .stream().noneMatch(productFetch -> productFetch.getAttribute().getName().equals("categories")))
            root.fetch("categories", JoinType.LEFT);
        return criteriaBuilder.conjunction();
        };
    }

    public static org.springframework.data.jpa.domain.Specification<Product> byName(String name) {
        return (root, query, criteriaBuilder) -> {
            if (name == null || name.isBlank() || name.isEmpty())  return criteriaBuilder.conjunction();
            root.join("categories", JoinType.LEFT);
//            root.fetch("categories");
            return criteriaBuilder.like(root.get("name"), "%" + name + "%");
        };
    }

    public static org.springframework.data.jpa.domain.Specification<Product> byDescription(String desc) {
        return (root, query, criteriaBuilder) -> {
            if (desc == null || desc.isBlank() || desc.isEmpty())  return criteriaBuilder.conjunction();
            root.join("categories", JoinType.LEFT);
//            root.fetch("categories");
            return criteriaBuilder.like(root.get("description"), "%" + desc + "%");
        };
    }

//TODO: ПРОВЕРИТЬ!!!!!!    ПРОВЕРИТЬ!!!!!!      ПРОВЕРИТЬ!!!!!!       ПРОВЕРИТЬ!!!!!!
    public static org.springframework.data.jpa.domain.Specification<Product> byCategory(String category) {
        return (root, query, criteriaBuilder) -> {
            if (category == null || category.isBlank() || category.isEmpty()) return criteriaBuilder.conjunction();
//            Join<Product, Category> categoryJoin = root.join("categories", JoinType.LEFT);
//            root.fetch("categories");
//            return criteriaBuilder.equal(categoryJoin.get("name"), category);
            root.join("categories", JoinType.LEFT);
            return criteriaBuilder.equal(root.get("name"), category);
        };
    }
}