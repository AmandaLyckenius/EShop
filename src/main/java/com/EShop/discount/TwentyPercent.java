package com.EShop.discount;

public class TwentyPercent implements Discount{
    @Override
    public double applyDiscount(double total) {
        return total - (total * 0.20);
    }

    @Override
    public double discountAmount(double total) {
        return (total * 0.20);
    }

    @Override
    public boolean isApplicable(double total) {
        return total >= 300;
    }
}
