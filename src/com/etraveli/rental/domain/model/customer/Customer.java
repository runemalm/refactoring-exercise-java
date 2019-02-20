package com.etraveli.rental.domain.model.customer;

import java.util.List;

import com.etraveli.rental.domain.service.RecordService;

import com.etraveli.rental.domain.model.record.Record;
import com.etraveli.rental.domain.model.rental.Rental;

public class Customer {
    /*
     * The 'Customer' entity.
     */
    private String name;
    private List<Rental> rentals;

    public Customer(String name) {
        this.name = name;
    }

    // Business Logic

    public Record getRecord(RecordService recordService) throws Exception {
        /*
         * Get a record (of movie rentals).
         *
         * The record contains information about movies rented, the cost of each
         * and frequent renter points earned.
         *
         * Returns: The record.
         */
        Record record = new Record();

        record.setCustomerName(this.name);
        record.setMovieCosts(recordService.calculateMovieCosts(this.getRentals()));
        record.setTotal(recordService.calculateTotal(record.getMovieCosts()));
        record.setFrequentRenterPoints( 
            recordService.calculateFrequentRenterPoints(
                this.getRentals()
            )
        );

        return record;
    }

    // Getters & Setters

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