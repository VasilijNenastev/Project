package org.skypro.skychop.product;

import org.skypro.skychop.exception.NameException;
import org.skypro.skychop.search.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {

    final String nameProduct;

    public Product(String nameProduct) {
        if (nameProduct == null || nameProduct.equals("") || nameProduct.isBlank()){

          throw new NameException();

        }

        this.nameProduct = nameProduct;

    }

    public Product() {

        this("f");
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

    public String getSearchTerm() {
        return getNameProduct() + " : " + getSearchContent();
    }

    @Override
    public String getSearchContent() {
        return "PRODUCT";
    }


    public String getStringRepresentation() {
        return getNameProduct() + " : " + getSearchContent();
    }
}


