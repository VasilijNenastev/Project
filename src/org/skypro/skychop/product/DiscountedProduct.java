package org.skypro.skychop.product;

import org.skypro.skychop.exception.BestResultNotFoundException;
import org.skypro.skychop.exception.DiscountedException;
import org.skypro.skychop.exception.PriceException;

public class DiscountedProduct extends Product {
    public int basePrice;
    public int percentageDiscount;

    public DiscountedProduct(String nameProduct, int basePrice, int percentageDiscount) {
        if (basePrice < 0) {
            throw new PriceException();
        }
        if (percentageDiscount < 0 || percentageDiscount > 100){
            throw new DiscountedException();
        }
            super(nameProduct);
        this.basePrice = basePrice;
        this.percentageDiscount = percentageDiscount;
    }

    public DiscountedProduct() {
        this("f", 1, 0);
    }

    @Override
    public int getPriceOfProduct() {
        return basePrice - ((basePrice * percentageDiscount) / 100);
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return nameProduct + " : " + basePrice + " рублей : скидка " + percentageDiscount + " %  ";
    }

}

