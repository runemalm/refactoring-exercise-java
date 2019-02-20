package com.etraveli.rental.domain.service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.etraveli.rental.domain.model.movie.Movie;
import com.etraveli.rental.domain.model.movie.MovieCost;
import com.etraveli.rental.domain.model.movie.MovieRepository;
import com.etraveli.rental.domain.model.movie.MovieType;
import com.etraveli.rental.domain.model.record.Record;
import com.etraveli.rental.domain.model.rental.Rental;

public class RecordService {
    /*
     * Record domain service.
     *
     * Calculates rental costs and frequent rental points earned.
     */
    private MovieRepository movieRepository;

    public RecordService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieCost> calculateMovieCosts(List<Rental> rentals) throws Exception {
        /*
         * Calculate the costs of each rental.
         * 
         * The pricing model involves a price deduction for movies of certain
         * types, based on number of days they have been rented.
         * 
         * Returns: List of costs for each rental.
         */
        List<MovieCost> movieCosts = new ArrayList<MovieCost>();

        for (Rental r : rentals) {
            Movie movie = this.movieRepository.get(r.getMovieId());

            // Calculate cost
            BigDecimal cost = BigDecimal.valueOf(0);

            switch (movie.getType()) {
                case REGULAR:
                    cost = BigDecimal.valueOf(2);
                    if (r.getDays() > 2) {
                        cost = cost.add(BigDecimal.valueOf((r.getDays() - 2) * 1.5));
                    }
                    break;
                case NEW:
                    cost = BigDecimal.valueOf(r.getDays() * 3);
                    break;
                case CHILDRENS:
                    cost = BigDecimal.valueOf(1.5);
                    if (r.getDays() > 3) {
                        cost = cost.add(BigDecimal.valueOf((r.getDays() - 3) * 1.5));
                    }
                    break;
                default:
                    throw new Exception(
                        "Couldn't calculate total, unsupported movie type: " +
                            movie.getType());
            }

            MovieCost movieCost = new MovieCost(movie.getTitle(), cost);
            
            // ..add cost
            movieCosts.add(movieCost);
        }

        return movieCosts;
    }

    public BigDecimal calculateTotal(List<MovieCost> costs) {
        /*
         * Calculate the total cost of some rentals, from a list of movie costs.
         * 
         * TODO: There's probably a nice map method in Java 
         * to do this without the use of this method..
         * 
         * Returns: The total cost.
         */
        BigDecimal total = BigDecimal.valueOf(0);
        for (MovieCost cost : costs) {
            total = total.add(cost.getCost());
        }
        return total;
    }

    public int calculateFrequentRenterPoints(List<Rental> rentals) {
        /*
         * Calculate the frequent renter points earned from renting the rentals.
         * 
         * Returns: The points earned.
         */
        int points = 0;

        for (Rental r : rentals) {
            Movie movie = this.movieRepository.get(r.getMovieId());

            // Add one point for rental
            points++;

            // ..and bonus point for a two-day-new-release rental
            if (movie.getType() == MovieType.NEW && r.getDays() > 2) points++;
        }

        return points;
    }
}
