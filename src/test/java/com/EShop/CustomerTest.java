package com.EShop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer(100);
    }

    @Test
    void testAddSaldoIncreasesValue() {
        customer.addBalance(100.0);
        assertEquals(200.0, customer.getBalance());
    }

    @Test
    void testAddSaldoFailsWithNegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> customer.addBalance(-20.0));
    }


    @Test
    void testDeductsWhenEnoughSaldo() {
        assertTrue(customer.deductBalance(30.0));
        assertEquals(70.0, customer.getBalance());
    }

    @Test
    void testDoesNotDeductIfNotEnough() {
        assertFalse(customer.deductBalance(180.0));
        assertEquals(100.0, customer.getBalance());
    }

    @Test
    void testDeductFailsIfNegativeAmount() {
        assertFalse(customer.deductBalance(-10.0));
        assertEquals(100.0, customer.getBalance());
    }

    @Test
    void testDeductsExactAmountToZero() {
        assertTrue(customer.deductBalance(100.0));
        assertEquals(0.0, customer.getBalance());
    }

    @Test
    void testNoDeductionIfAmountIsZero() {
        assertFalse(customer.deductBalance(0.0));
        assertEquals(100.0, customer.getBalance());
    }
}

