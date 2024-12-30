package org.skypro.skychop.product;

public class SimpleProduct extends Product {
    final int priceOfProduct;

    public SimpleProduct(String nameProduct, int priceOfProduct) {
        super(nameProduct);
        this.priceOfProduct = priceOfProduct;
    }

    public SimpleProduct() {
        this("", 0);

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
