/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.retoDos.Product;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author john
 */
public interface ProductCrudRepository extends MongoRepository<Product,String>{
    
}
