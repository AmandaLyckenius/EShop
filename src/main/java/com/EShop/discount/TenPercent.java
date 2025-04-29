package com.EShop.discount;

public class TenPercent implements Discount{
    @Override
    public double applyDiscount(double total) {
        return total - (total * 0.10);
    }
}
