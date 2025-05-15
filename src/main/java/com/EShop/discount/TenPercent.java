package com.EShop.discount;

public class TenPercent implements Discount{
    @Override
    public double applyDiscount(double total) {
        return total - (total * 0.10);
    }

    @Override
    public double discountAmount(double total) {
        return total * 0.10;
    }

    @Override
    public boolean isApplicable(double total) {
        return (total >=100 && total <=299);
    }


}
