package com.mycompany.salesapplication;

public class Product {

    // Calculate the total sales across all rows and columns
    public int calculateTotalSales(int[][] sales) {
        int total = 0;
        for (int i = 0; i < sales.length; i++) {
            for (int j = 0; j < sales[i].length; j++) {
                total += sales[i][j];
            }
        }
        return total;
    }

    // Calculate the average sales per data point
    public double calculateAverageSales(int[][] sales) {
        int total = 0;
        int count = 0;
        for (int i = 0; i < sales.length; i++) {
            for (int j = 0; j < sales[i].length; j++) {
                total += sales[i][j];
                count++;
            }
        }
        return count == 0 ? 0.0 : (double) total / count;
    }

    // Find the product with the highest total sales
    public String getMostPopularProduct(String[] products, int[][] sales) {
        int maxSales = -1;
        int maxIndex = 0;

        for (int i = 0; i < sales.length; i++) {
            int productTotal = 0;
            for (int j = 0; j < sales[i].length; j++) {
                productTotal += sales[i][j];
            }
            if (productTotal > maxSales) {
                maxSales = productTotal;
                maxIndex = i;
            }
        }
        return products[maxIndex] + " (Total Sales: " + maxSales + ")";
    }
}