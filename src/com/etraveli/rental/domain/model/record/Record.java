package com.etraveli.rental.domain.model.record;

import java.math.BigDecimal;
import java.util.List;

import com.etraveli.rental.domain.model.movie.MovieCost;

public class Record {
    /*
     * The 'Record' entity.
     */
    private String customerName;
    private List<MovieCost> movieCosts;
    private BigDecimal total;
    private int frequentRenterPoints;

    public Record() {
        
    }

    public String toStatement() {
        /*
         * Get a statement of movie rentals, 
         * (suitable to put on a customer receipt).
         *
         * Returns: The statement.
         */
        StringBuilder sb = new StringBuilder(
            "Rental Record for " + this.getCustomerName() + "\n"
        );
        
        // Add movie lines
        for (MovieCost m : movieCosts) {
            sb.append("\t" + m.getTitle() + "\t" + m.getCost() + "\n");
        }

        // ..add footer lines
        sb.append("Amount owed is " + this.total + "\n");
        sb.append(
            "You earned " + 
            this.frequentRenterPoints + 
            " frequent renter points\n"
        );

        return sb.toString();
    }

    // Getters & Setters

    public String getCustomerName() {
        return customerName;
    }

    public List<MovieCost> getMovieCosts() {
        return movieCosts;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setMovieCosts(List<MovieCost> movieCosts) {
        this.movieCosts = movieCosts;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public void setFrequentRenterPoints(int frequentRenterPoints) {
        this.frequentRenterPoints = frequentRenterPoints;
    }
}