package org.skypro.skychop.product;

public class DiscountedProduct extends Product {
    public int basePrice;
    public int percentageDiscount;

    public DiscountedProduct(String nameProduct, int basePrice, int percentageDiscount) {
        super(nameProduct);
        this.basePrice = basePrice;
        this.percentageDiscount = percentageDiscount;
    }

    public DiscountedProduct() {
        this(" ",0,0);
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

