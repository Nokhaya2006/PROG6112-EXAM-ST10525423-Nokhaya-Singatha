package com.mycompany.productapp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductCalculationsTest {
    
    public ProductCalculationsTest() {
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
     * Test of GetVat method, of class ProductCalculations.
     * Matches Q.2.6 requirement: GetVal_WithValidData_ReturnsCorrectValue()[cite: 11]
     */
    @Test
    public void GetVal_WithValidData_ReturnsCorrectValue() {
        System.out.println("GetVat");
        
        // Using sample price 3500 (VAT should be 15% -> 525.0)
        double price = 3500.0;
        ProductCalculations instance = new ProductCalculations(price);
        
        double expResult = 525.0;
        double result = instance.GetVat();
        
        assertEquals(expResult, result, 0.001);
    }

    /**
     * Test of GetCommission method, of class ProductCalculations.
     */
    @Test
    public void GetCommission_WithValidData_ReturnsCorrectValue() {
        System.out.println("GetCommission");
        
        // Using sample price 3500 (Commission should be 5% -> 175.0)
        double price = 3500.0;
        ProductCalculations instance = new ProductCalculations(price);
        
        double expResult = 175.0;
        double result = instance.GetCommission();
        
        assertEquals(expResult, result, 0.001);
    }

    /**
     * Test of GetTotal method, of class ProductCalculations.
     */
    @Test
    public void GetTotal_WithValidData_ReturnsCorrectValue() {
        System.out.println("GetTotal");
        
        // Using sample price 3500 (Total = 3500 + 525 + 175 = 4200.0)
        double price = 3500.0;
        ProductCalculations instance = new ProductCalculations(price);
        
        double expResult = 4200.0;
        double result = instance.GetTotal();
        
        assertEquals(expResult, result, 0.001);
    }
}