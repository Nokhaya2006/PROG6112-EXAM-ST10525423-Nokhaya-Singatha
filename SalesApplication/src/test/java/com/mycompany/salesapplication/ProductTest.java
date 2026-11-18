package com.mycompany.salesapplication;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */
public class ProductTest {
    
    public ProductTest() {
    }

    @BeforeAll
    public static void setUpClass() throws Exception {
    }

    @AfterAll
    public static void tearDownClass() throws Exception {
    }

    @BeforeEach
    public void setUp() throws Exception {
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    /**
     * Test of calculateTotalSales method, of class Product.
     */
    @Test
    public void testCalculateTotalSales() {
        System.out.println("calculateTotalSales");
        
        // Mock 2D sales array that adds up to a grand total of 100
        int[][] sales = {
            { 20, 20, 10 }, // Total = 50
            { 20, 10, 10 }, // Total = 40
            { 5,  5,  0 }   // Total = 10
        };                   // Grand Total = 100
        
        Product instance = new Product();
        int expResult = 100;
        int result = instance.calculateTotalSales(sales);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of calculateAverageSales method, of class Product.
     */
    @Test
    public void testCalculateAverageSales() {
        System.out.println("calculateAverageSales");
        
        int[][] sales = {
            { 20, 20, 10 }, 
            { 20, 10, 10 }, 
            { 5,  5,  0 }  
        }; // Sum = 100, Count = 9 elements -> Average = 100.0 / 9
        
        Product instance = new Product();
        double expResult = 100.0 / 9.0;
        double result = instance.calculateAverageSales(sales);
        
        assertEquals(expResult, result, 0.001);
    }

    /**
     * Test of getMostPopularProduct method, of class Product.
     */
    @Test
    public void testGetMostPopularProduct() {
        System.out.println("getMostPopularProduct");
        
        String[] products = {
            "Cosy Nights Monarch mattress",
            "Restonic Barbados mattress",
            "Sealy Phuket mattress"
        };
        
        int[][] sales = {
            { 10, 10, 10 }, // Total = 30
            { 40, 30, 30 }, // Total = 100 (Most popular)
            { 10, 10, 10 }  // Total = 30
        };
        
        Product instance = new Product();
        String expResult = "Restonic Barbados mattress (Total Sales: 100)";
        String result = instance.getMostPopularProduct(products, sales);
        
        assertEquals(expResult, result);
    }
}