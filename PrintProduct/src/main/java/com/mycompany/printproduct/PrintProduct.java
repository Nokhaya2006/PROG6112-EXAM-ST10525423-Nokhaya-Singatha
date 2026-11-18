package com.mycompany.printproduct;

/**
 *
 * @author Student
 */
public class PrintProduct {
    private IProduct productReport;

    // Constructor injection of the IProduct interface
    public PrintProduct(IProduct productReport) {
        this.productReport = productReport;
    }

    public void printReport() {
        System.out.println("PRODUCT SALES REPORT - 2026");
        System.out.println("**************************************************");
        System.out.println("TOTAL PRODUCT SALES: " + productReport.GetTotalProductsSold());
        System.out.println("AVERAGE PRODUCT SALES: " + (int) Math.round(productReport.GetAverageProductSold()));
        System.out.println("MOST POPULAR PRODUCT: " + productReport.GetMostPopularProduct());
    }

    public static void main(String[] args) {
        IProduct productReport = new ProductService();
        PrintProduct printer = new PrintProduct(productReport);
        printer.printReport();
    }
}