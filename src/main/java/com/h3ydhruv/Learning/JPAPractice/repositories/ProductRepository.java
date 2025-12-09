package com.h3ydhruv.Learning.JPAPractice.repositories;

import com.h3ydhruv.Learning.JPAPractice.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository< ProductEntity,Long> {

    ProductEntity findByTitle(String title);

    List<ProductEntity> findFirst2ByQuantity(int i);

    @Query("select p from ProductEntity p where p.title=?1 and p.price=?2")
    Optional<ProductEntity> findByTitleAndPrice(String title, BigDecimal price);
}
