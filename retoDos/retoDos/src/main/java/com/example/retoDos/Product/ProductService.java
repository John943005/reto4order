/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.retoDos.Product;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author john
 */
@Service
public class ProductService {
    @Autowired
     private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Optional<Product> getCleaningProducts(String reference){
        return productRepository.getProduct(reference);
    }

    public Product save(Product cleaningProduct){
        if(cleaningProduct.getReference() == null) {
            return cleaningProduct;
        }else{
            return productRepository.create(cleaningProduct);
        }
    }

    public Product update(Product product) {

        if (product.getReference() != null) {
            Optional<Product> dbProduct = productRepository.getProduct(product.getReference());
            if (!dbProduct.isEmpty()) {
                if (product.getBrand() != null) {
                    dbProduct.get().setBrand(product.getBrand());
                }
                if (product.getCategory() != null) {
                    dbProduct.get().setCategory(product.getCategory());
                }
                if (product.getMateriales() != null) {
                    dbProduct.get().setMateriales(product.getMateriales());
                }
                if (product.getDimensiones() != null) {
                    dbProduct.get().setDimensiones(product.getDimensiones());
                }
                if (product.getDescription() != null) {
                    dbProduct.get().setDescription(product.getDescription());
                }
                
                if (product.getPrice() != 0.0) {
                    dbProduct.get().setPrice(product.getPrice());
                }
                if (product.getQuantity() != 0) {
                    dbProduct.get().setQuantity(product.getQuantity());
                }
                if (product.getPhotography() != null) {
                    dbProduct.get().setPhotography(product.getPhotography());
                }
                dbProduct.get().setAvailability(product.isAvailability());
                productRepository.update(dbProduct.get());
                return dbProduct.get();
            } else {
                return product;
            }
        }else{
            return product;
        }
    }

    public boolean delete(String reference){
        Boolean aboolean= getCleaningProducts(reference).map(cleaningProduct -> {
            productRepository.delete(cleaningProduct);
            return true;
        }).orElse(false);
        return aboolean;
    }
}
