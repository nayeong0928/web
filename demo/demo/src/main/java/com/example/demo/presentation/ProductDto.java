package com.example.demo.presentation;


import jakarta.validation.constraints.NotNull;

public class ProductDto {
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private int price;

    @NotNull
    private int amount;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public void setId(Long id){
        this.id=id;
    }
}
