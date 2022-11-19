package com.example.dependency.DTO;

public class CustomerNameAndBalanceDTO {
    private String name;
    private int aggregatedBalance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAggregatedBalance() {
        return aggregatedBalance;
    }

    public void setAggregatedBalance(int aggregatedBalance) {
        this.aggregatedBalance = aggregatedBalance;
    }
}
