package com.h3ydhruv.Learning.JPAPractice;

import com.h3ydhruv.Learning.JPAPractice.entities.ProductEntity;
import com.h3ydhruv.Learning.JPAPractice.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class JpaPracticeApplicationTests {
    @Autowired
    ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

    @Test
    void testRepository(){
        ProductEntity productEntity =  ProductEntity
                .builder()
                .sku("Cola1234")
                .title("Diet Coke")
                .price(BigDecimal.valueOf(40))
                .quantity(10).build();

        ProductEntity savedProduct = productRepository.save(productEntity );
        System.out.println(savedProduct);
    }
    @Test
    void fetchRepository(){
        List<ProductEntity> productEntity = productRepository.findAll();
        System.out.println(productEntity);
    }

    @Test
    void fetchCustomRepo(){
        List<ProductEntity> entities = productRepository.findFirst2ByQuantity(50);
        entities.forEach(entity -> System.out.println(entity));
    }

    @Test
    void fetchSingleResult(){
        Optional<ProductEntity> entity = productRepository.findByTitleAndPrice("Daawat Basmati Rice 1kg", BigDecimal.valueOf(89.99));
        System.out.println(entity);
    }
}
