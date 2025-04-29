package com.EShop.discount;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TenPercentTest {

    @Test
    void apply10Percent () {
        TenPercent tenPercent = new TenPercent();
        double total = 100;
        assertEquals(90, tenPercent.applyDiscount(total));
    }

}
