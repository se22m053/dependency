package com.example.dependency.entity;

import javax.persistence.*;

@Entity
@Table
public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private String name;
    private int balance;
    private String productCode;
    private String interestRate;

    public Product(String name, int balance, String productCode, String interestRate) {
        this.name = name;
        this.balance = balance;
        this.productCode = productCode;
        this.interestRate = interestRate;
    }

    public Product() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", productCode='" + productCode + '\'' +
                ", interestRate='" + interestRate + '\'' +
                '}';
    }
}
