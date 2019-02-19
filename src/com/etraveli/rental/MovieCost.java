package com.etraveli.rental;

import java.math.BigDecimal;

public class MovieCost {
    private final String title;
    private final BigDecimal cost;
    
    public MovieCost(String title, BigDecimal cost) {
        this.title = title;
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getCost() {
        return cost;
    }
}