/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.iproducts;

/**
 *
 * @author Student
 */
public interface IProducts {
    int getTotalProductsSold();
    double getAverageProductsSold();
    String getMostPopularProduct();
    int getMostPopularProductSales();
}

public class Product implements IProducts {
    private final String[] names;      // one name per product
    private final int[][] sales;       // [product][month]

    public Product(String[] names, int[][] sales) {
        this.names = names;
        this.sales = sales;
    }

    @Override
    public int getTotalProductsSold() {
        int total = 0;
        for (int p = 0; p < sales.length; p++) {
            for (int m = 0; m < sales[p].length; m++) {
                total += sales[p][m];
            }
        }
        return total;
    }

    @Override
    public double getAverageProductsSold() {
        int count = 0;
        for (int p = 0; p < sales.length; p++) {
            count += sales[p].length;
        }
        return count == 0 ? 0 : (double) getTotalProductsSold() / count;
    }

    // total sales for a single product across all months
    private int productTotal(int p) {
        int sum = 0;
        for (int m = 0; m < sales[p].length; m++) {
            sum += sales[p][m];
        }
        return sum;
    }

    private int mostPopularIndex() {
        int best = 0;
        for (int p = 1; p < sales.length; p++) {
            if (productTotal(p) > productTotal(best)) {
                best = p;
            }
        }
        return best;
    }

    @Override
    public String getMostPopularProduct() {
        return names[mostPopularIndex()];
    }

    @Override
    public int getMostPopularProductSales() {
        return productTotal(mostPopularIndex());
    }
}

