package org.skypro.skychop.product;

import java.util.Objects;

public abstract class Product {

    final String nameProduct;

    public Product(String nameProduct) {

        this.nameProduct = nameProduct;

    }

    public Product() {

        this("");
    }

    public String getNameProduct() {

        return nameProduct;
    }


    public abstract int getPriceOfProduct();

    public abstract boolean isSpecial();


    @Override
    public String toString() {

        return nameProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(nameProduct, product.nameProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nameProduct);
    }
}


