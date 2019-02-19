package com.etraveli.rental;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class RecordTests extends UnitTests {

    @Test
    public void TestCreateStatment() throws Exception {

        // Setup
        Customer customer = new Customer("martin");
        
        customer.setRentals(
            Arrays.asList(
                new Rental("F001", 3),
                new Rental("F002", 1)
            )
        );

        RecordService service = new RecordService();

        // Excercise
        Record record = service.createRecord(customer);

        // Assert
        String expectedStatement = this.readFile(
            "test/com/etraveli/rental/mock/Statement.txt"
        );

        Assert.assertEquals(expectedStatement, record.createStatement());
    }
}