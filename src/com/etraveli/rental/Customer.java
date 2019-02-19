package com.etraveli.rental;

import java.util.List;

public class Customer {
    
    private String name;
    private List<Rental> rentals;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setRentals(List<Rental> rentals) {
        this.rentals = rentals;
    }

    public List<Rental> getRentals() {
        return this.rentals;
    }

    public Record getRecord() {
        return new Record();
    }
}