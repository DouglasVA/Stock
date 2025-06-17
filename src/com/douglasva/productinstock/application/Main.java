package com.douglasva.productinstock.application;

import com.douglasva.productinstock.entities.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("How many products will be added? ");
        int n = sc.nextInt();

        List<Product> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.printf("\nProduct #%d", i + 1);
            System.out.print("\nID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price: ");
            Double price = sc.nextDouble();
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();

            if (hasId(list, id)) {
                System.out.println("This ID already exists!");
                i--;
            } else {
                Product p = new Product(id, name, price, quantity);
                list.add(p);
            }
        }

        Product p;

        do {
            System.out.printf("\nID's product to add in stock: ");
            int id = sc.nextInt();
            p = findProductById(list, id);
            if (p == null) {
                System.out.print("This ID doesn't exist!");
            }
        } while (p == null);

        System.out.print("Quantity to add: ");
        int qtdAdd = sc.nextInt();
        p.addStock(qtdAdd);

        do {
            System.out.printf("\nID's product to remove from stock: ");
            int id = sc.nextInt();
            p = findProductById(list, id);
            if (p == null) {
                System.out.print("This ID doesn't exist!");
            }
        } while (p == null);

        System.out.print("Quantity to remove: ");
        int qtdRmv = sc.nextInt();
        p.removeStock(qtdRmv);

        System.out.printf("\nList of products:\n");
        for (Product prod : list) {
            System.out.println(prod);
        }

        sc.close();

    }

    public static boolean hasId(List<Product> list, int id) {
        for (Product p : list) {
            if (p.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public static Product findProductById(List<Product> list, int id) {
        for (Product p : list) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

}