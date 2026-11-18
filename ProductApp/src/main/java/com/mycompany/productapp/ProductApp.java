/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.productapp;

/**
 *
 * @author Student
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ProductApp extends JFrame {
    private JTextField txtCustomerName;
    private JComboBox<String> cmbProducts;
    private JTextField txtPrice;
    private JButton btnProcess;

    public ProductApp() {
        // Frame setup (Standard first-year JFrame approach)
        setTitle("Product App");
        setSize(420, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenu menuEdit = new JMenu("Edit");
        menuBar.add(menuFile);
        menuBar.add(menuEdit);
        setJMenuBar(menuBar);

        // Customer Name Label & Text Field
        JLabel lblCustomer = new JLabel("Customer Name:");
        lblCustomer.setBounds(30, 30, 120, 25);
        add(lblCustomer);

        txtCustomerName = new JTextField();
        txtCustomerName.setBounds(150, 30, 200, 25);
        add(txtCustomerName);

        // Select Product Label & ComboBox
        JLabel lblProduct = new JLabel("Select Product:");
        lblProduct.setBounds(30, 80, 120, 25);
        add(lblProduct);

        String[] products = {
            "Cosy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };
        cmbProducts = new JComboBox<>(products);
        cmbProducts.setBounds(150, 80, 200, 25);
        add(cmbProducts);

        // Enter Price Label & Text Field
        JLabel lblPrice = new JLabel("Enter Price:");
        lblPrice.setBounds(30, 130, 120, 25);
        add(lblPrice);

        txtPrice = new JTextField();
        txtPrice.setBounds(150, 130, 200, 25);
        add(txtPrice);

        // Process Button
        btnProcess = new JButton("PROCESS");
        btnProcess.setBounds(110, 195, 180, 35);
        add(btnProcess);

        // Button Action Event Listener
        btnProcess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processSaleDetails();
            }
        });
    }

    private void processSaleDetails() {
        try {
            // Retrieve inputs
            String customerName = txtCustomerName.getText().trim();
            String productName = (String) cmbProducts.getSelectedItem();
            
            if (customerName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter the customer name.", "Validation Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            double price = Double.parseDouble(txtPrice.getText().trim());

            // Calculation requirements (VAT: 15%, Commission: 5%)
            double vat = price * 0.15;
            double commission = price * 0.05;
            double totalSaleAmount = price + vat + commission;

            // Format message dialog matching your sample screenshot
            String messageReport = String.format(
                "Customer Name: %s\n" +
                "Product: %s\n" +
                "VAT: R %.1f\n" +
                "COMMISSION: R %.1f\n" +
                "TOTAL: R %.1f",
                customerName, productName, vat, commission, totalSaleAmount
            );

            JOptionPane.showMessageDialog(this, messageReport, "Message", JOptionPane.INFORMATION_MESSAGE);

            // Save information to data.txt matching the required data log format
            try (PrintWriter writer = new PrintWriter(new FileWriter("data.txt", true))) {
                writer.println("DATA LOG");
                writer.println("**************************************************");
                writer.println("Customer Name: " + customerName);
                writer.println("Product: " + productName);
                writer.println("VAT: R " + vat);
                writer.println("COMMISSION: R " + commission);
                writer.println("TOTAL: R " + totalSaleAmount);
                writer.println("**************************************************");
                writer.println(); // Blank line separation for multiple entries
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric value for the price.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving to file: " + ex.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ProductApp().setVisible(true);
            }
        });
    }
}