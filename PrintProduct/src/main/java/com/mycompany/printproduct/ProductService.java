/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.printproduct;

/**
 *
 * @author Student
 */
public class ProductService implements IProduct {
    @Override
    public String GetTotalProductsSold() {
        // Return your calculated or retrieved total products sold
        return "150"; 
    }

    @Override
    public float GetAverageProductSold() {
        // Return your calculated average
        return 25.5f; 
    }

    @Override
    public String GetMostPopularProduct() {
        // Return the most popular product name
        return "Widget A"; 
    }
    
}

