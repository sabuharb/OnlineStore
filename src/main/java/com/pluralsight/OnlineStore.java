package com.pluralsight;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class OnlineStore {

    static HashMap<String, Product> inventory
            = new HashMap<String, Product>();

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("Welcome to Online Store! What would you like to do?" );
            System.out.println("1. Display Products");
            System.out.println("2. Display Cart");
            System.out.println("3. Exit");
            System.out.print("Please select an option: " );
            int choice = scanner.nextInt();
switch (choice) {
    case 1:
        displayProducts(scanner, inventory);
        break;
    case 2:
        displayCart("Cart");
            break;
    case 3:
       System.out.println("Exit");
       return;





}


        }
        //Use the provided products.csv file to load the store's product  inventory into your application.


    }

    private static void displayCart(String cart) {
    }

    private static void displayProducts(Scanner scanner, HashMap<String, Product> inventory) {

        System.out.println("Available Products: ");

        System.out.println("1 - Search" );
        System.out.println("2 - Add");
        System.out.println("3 - Go Back");
        System.out.print("Select an option: ");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                searchProduct(inventory);

                break;
            case 2:
                displayCart("Cart");
                break;
            case 3:
                System.out.println("Exit");
                return;


        }



    }

    private static void searchProduct(HashMap<String, Product> inventory) {
            loadInventory(inventory);

            System.out.print("What item are you interested in?(Type in the product name): ");
            Scanner scanner = new Scanner(System.in);
            String product = scanner.nextLine().trim();

            Product matchedProduct = inventory.get(product);
            if(matchedProduct == null){
                System.out.println("We don't carry that product");
            }
            else{
                System.out.printf("We carry %s and the price is $%.2f\n",
                        matchedProduct.getProductName(), matchedProduct.getPrice());
            }



    }

    public static void loadInventory(HashMap<String, Product> inventory) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/products.csv"));
            String line;

           bufferedReader.readLine();

            while ((line = bufferedReader.readLine()) != null) {

                String[] tokens = line.split("\\|");

                String SKU = tokens[0];
                String productName = tokens[1];
                float price = Float.parseFloat(tokens[2]);
                String department = tokens[3];

                inventory.put(productName, new Product(SKU, productName, price, department));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

