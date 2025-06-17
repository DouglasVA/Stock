package com.douglasva.productinstock.entities;

public class Product {

    private Integer id;
    public Integer qtdStock;
    private Double price;
    private String name;

    public Product () {

    }

    public Product (Integer id, String name, Double price, Integer qtdStock) {
        this.id = id;
        this.qtdStock = qtdStock;
        this.price = price;
        this.name = name;
    }

    public void addStock(int amount) {
        this.qtdStock += amount;
    }

    public void removeStock(int amount) {
        if (amount <= this.qtdStock) {
            this.qtdStock -= amount;
        } else {
            System.out.println("Insufficient stock to remove.");
        }
    }

    public double totalValueInStock() {
        return price * qtdStock;
    }

    public Integer getId() {
        return id;
    }

    public Integer getQtdStock() {
        return qtdStock;
    }

    public Double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String toString () {
        return id + ": "
                + name + ", "
                + "$" + String.format("%.2f", price) + ", "
                + "Quantity: " + qtdStock + ", "
                + "Total: $" + String.format("%.2f", totalValueInStock());
    }

}