package com.etraveli.rental.domain.model.customer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Arrays;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

import com.etraveli.rental.UnitTests;

import com.etraveli.rental.domain.model.customer.Customer;
import com.etraveli.rental.domain.model.record.Record;
import com.etraveli.rental.domain.model.rental.Rental;
import com.etraveli.rental.domain.service.RecordService;

import com.etraveli.rental.port.adapter.persistence.mock.MockMovieRepository;

public class CustomerTests extends UnitTests {
    /*
     * Tests for the 'Customer' entity.
     */
    private RecordService recordService;
    private MockMovieRepository movieRepository;
     

    @Before
    public void setUp() {
        this.movieRepository = new MockMovieRepository();
        this.recordService = new RecordService(movieRepository);
    }

    @Test
    public void TestCreateCustomer() throws Exception {

        // Setup
        List<Rental> rentals =
            Arrays.asList(
                new Rental("F001", 3),
                new Rental("F002", 1)
            );

        // Excercise
        Customer customer = new Customer("martin");
        customer.setRentals(rentals);

        // Assert
        Assert.assertEquals("martin", customer.getName());
        Assert.assertEquals(rentals, customer.getRentals());
    }

    @Test
    public void TestGetRecordStatement() throws Exception {

        // Setup
        Customer customer = new Customer("martin");
        
        customer.setRentals(
            Arrays.asList(
                new Rental("F001", 3),
                new Rental("F002", 1)
            )
        );

        // Excercise
        Record record = customer.getRecord(this.recordService);
        String statement = record.toStatement();

        // Assert
        String expected = this.readFile(
            "test/com/etraveli/rental/domain/model/customer/mock/Statement.txt"
        );

        Assert.assertEquals(
            expected,
            statement
        );
    }
}