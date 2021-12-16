/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.retoDos.Order;

import com.example.retoDos.Product.Product;
import com.example.retoDos.User;
import java.util.Date;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



/**
 *
 * @author john
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="orders")
public class Order {
    public static String PENDING = "Pendiente";
    public static String APROVED = "Aprobada";
    public static String REJECTED = "Rechazada";
    @Id
    private Integer id;
    private Date date;
    private String state;
    private String status;
    private User salesMan;
    private Map<String, Product>products;
    private Map<String,Integer>quantities;
    
    
    
            
    
}
