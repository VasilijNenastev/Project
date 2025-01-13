package org.skypro.skychop.product;

import org.skypro.skychop.exception.PriceException;

public class SimpleProduct extends Product {
    final int priceOfProduct;

    public SimpleProduct(String nameProduct, int priceOfProduct) {
        super(nameProduct);
        if (priceOfProduct <= 0) {
            throw new PriceException();
        }

        this.priceOfProduct = priceOfProduct;
    }

    public SimpleProduct() {
        this("f", 1);

    }

    @Override
    public int getPriceOfProduct() {
        return priceOfProduct;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return nameProduct + " : " + priceOfProduct + " рублей";
    }


}
