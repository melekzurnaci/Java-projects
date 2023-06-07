package com.demo.ProductMS.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    // methods

    Product addProduct(Product product){
        return productRepo.save(product);
    };
    List<Product> getAllProducts(){
        return productRepo.findAll();
    }
    Product findProductById(Long id){
        return productRepo.findById(id).orElseThrow(()-> new ProductNotFoundException("Product with id "+ id + " not found"));
    }

    void deleteProductById(Long id){
        productRepo.deleteById(id);
    }
}
