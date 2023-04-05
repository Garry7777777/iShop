package com.skypro.onlinestore.repository;

import com.skypro.onlinestore.model.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>, JpaSpecificationExecutor<Product> {

    @EntityGraph(attributePaths = {"categories"})
    List<Product> findFetchAllBy(Sort sort);

}