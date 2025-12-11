package com.h3ydhruv.Learning.JPAPractice.controllers;


import com.h3ydhruv.Learning.JPAPractice.entities.ProductEntity;
import com.h3ydhruv.Learning.JPAPractice.repositories.ProductRepository;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    private final ProductRepository productRepository;


    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping(path = "/sorting")
    public List<ProductEntity> getAllProducts(@RequestParam(defaultValue = "id") String sortBy){
        return productRepository.findBy(Sort.by(sortBy));
    }

    @GetMapping(path = "/pages")
    public List<ProductEntity> getAllProductPages(@RequestParam(defaultValue = "0") String pageNumber){
        return productRepository.findAll(PageRequest.of(Integer.parseInt(pageNumber),2)).getContent();
    }

    @GetMapping(path = "/order")
    public List<ProductEntity> getAllProductsByQuantity(){
        return productRepository.findAllByOrderByQuantity();
    }

    @GetMapping(path = "/infinite")
    public List<ProductEntity> getAllProductsWithInfiniteScroll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        Pageable pageable = PageRequest.of(page,size);
        return productRepository.findAllBy(pageable).getContent();
    }
}
