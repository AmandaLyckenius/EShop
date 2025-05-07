package com.EShop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void testAddSaldoIncreasesValue() {
        Customer customer = new Customer(0.0);
        customer.addSaldo(100.0);
        assertEquals(100.0, customer.getSaldo());
    }

    @Test
    void testAddSaldoFailsWithNegativeAmount() {
        Customer customer = new Customer(50.0);
        assertThrows(IllegalArgumentException.class, () -> customer.addSaldo(-20.0));
    }


    @Test
    void testDeductsWhenEnoughSaldo() {
        Customer customer = new Customer(100.0);
        assertTrue(customer.deductSaldo(30.0));
        assertEquals(70.0, customer.getSaldo());
    }

    @Test
    void testDoesNotDeductIfNotEnough() {
        Customer customer = new Customer(50.0);
        assertFalse(customer.deductSaldo(80.0));
        assertEquals(50.0, customer.getSaldo());
    }

    @Test
    void testDeductFailsIfNegativeAmount() {
        Customer customer = new Customer(50.0);
        assertFalse(customer.deductSaldo(-10.0));
        assertEquals(50.0, customer.getSaldo());
    }

    @Test
    void testDeductsExactAmountToZero() {
        Customer customer = new Customer(25.0);
        assertTrue(customer.deductSaldo(25.0));
        assertEquals(0.0, customer.getSaldo());
    }

    @Test
    void testNoDeductionIfAmountIsZero() {
        Customer customer = new Customer(40.0);
        assertFalse(customer.deductSaldo(0.0));
        assertEquals(40.0, customer.getSaldo());
    }
}

