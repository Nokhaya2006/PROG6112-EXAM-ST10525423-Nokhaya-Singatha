/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.salesapplication;

/**
 *
 * @author Student
 */
import java.util.Scanner;

public class SalesApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       
        // Single-dimensional array for the 3 mattress products
        String[] products = {
            "Cosy Nights Monarch mattress",
            "Restonic Barbados mattress",
            "Sealy Phuket mattress"
        };
       
        // Two-dimensional array: 3 rows (products) by 3 columns (months)
        int[][] sales = new int[3][3];
       
        // Populate 2D array dynamically using nested loops and Scanner
        for (int i = 0; i < products.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter number of sales for month " + (j + 1) + " for " + products[i] + ": ");
                sales[i][j] = scanner.nextInt();
            }
            System.out.println(); // Blank line for clean formatting
        }
       
        // Create an instance of the Product class to perform calculations
        Product report = new Product();
       
        int totalSales = report.calculateTotalSales(sales);
        double avgSales = report.calculateAverageSales(sales);
        String popularProductInfo = report.getMostPopularProduct(products, sales);
       
        // Display the final report
        System.out.println("PRODUCT SALES REPORT - 2026");
        System.out.println("**************************************************");
        System.out.println("TOTAL PRODUCT SALES: " + totalSales);
        System.out.println("AVERAGE PRODUCT SALES: " + (int) Math.round(avgSales));
        System.out.println("MOST POPULAR PRODUCT: " + popularProductInfo);
       
        scanner.close();
    }
}
