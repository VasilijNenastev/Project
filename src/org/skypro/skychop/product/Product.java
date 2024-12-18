package org.skypro.skychop.product;

import java.util.Objects;

public class Product {

    private String nameProduct;
    private int priceOfProduct;


    public Product(String nameProduct, int priceOfProduct) {

        this.nameProduct = nameProduct;
        this.priceOfProduct = priceOfProduct;
    }

    public Product() {
        this("", 0);
    }

    public String getNameProduct() {
        return nameProduct;
    }

    //public void setNameProduct(String newNameProduct) {
    //    nameProduct = newNameProduct;
    //}

    public int getPriceOfProduct() {
        return priceOfProduct;
    }

    //public void setPriceOfProduct(int newPriceOfProduct) {
    //    priceOfProduct = newPriceOfProduct;
    //}

    @Override
    public String toString() {
        return nameProduct + " " + ':' + " " + priceOfProduct + " рублей.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return priceOfProduct == product.priceOfProduct && Objects.equals(nameProduct, product.nameProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameProduct, priceOfProduct);
    }
}

