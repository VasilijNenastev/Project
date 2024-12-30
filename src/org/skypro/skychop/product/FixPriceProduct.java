package org.skypro.skychop.product;

public class FixPriceProduct extends Product {
    public static int FIX_PRICE_PRODUCT = 100;

    public FixPriceProduct(String nameProduct) {
        super(nameProduct);
    }

    public FixPriceProduct() {
        this(" ");
    }


    @Override
    public int getPriceOfProduct() {
        return FIX_PRICE_PRODUCT;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return nameProduct + " : фиксированная цена " + FIX_PRICE_PRODUCT + " рублей";
    }

    public String searchTerm() {
        return toString() + " : " + typeContent();
    }

    public String typeContent() {
        return "PRODUCT";
    }

    public String getStringRepresentation() {
        return getNameProduct() + " : " + typeContent();
    }
}
