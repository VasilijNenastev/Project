package org.skypro.skychop.basket;

import org.skypro.skychop.product.Product;

public class ProductBasket {


    private static Product[] products;

    private static int Count = 0;

    private static final int LENGTH = 5;


    public ProductBasket() {

        products = new Product[LENGTH];
        for (int i = 0; i < LENGTH; i++) {
            products[i] = null;
        }
    }

    public static void addProduct(Product product) {
        if (Count == LENGTH) {
            System.out.println("Невозможно добавить продукт");
            return;
        }
        products[Count++] = product;
    }

    public static void printAllProductBasket() {
        int CountSpecial = 0;
        for (Product product : products) {
            if (product == null) {
                continue;
            }
            System.out.println(product);
            if (product.isSpecial()) CountSpecial++;
        }
        if (CountSpecial != 0) {
            System.out.println("Специальных товаров: " + CountSpecial);
        }

    }

    public static int totalPriceOfProduct() {
        int sum = 0;
        for (Product product : products) {
            if (product == null) {
                continue;
            }
            sum += product.getPriceOfProduct();
        }
        return sum;
    }


    public static void basketEmpty() {
        if (totalPriceOfProduct() == 0 || products == null) {
            System.out.println(" Корзина пуста");
        }
    }

    public static boolean isHasProduct(String name) {
        if (Count == 0) return false;
        for (Product product : products) {
            if (product.getNameProduct().equals(name)) return true;
        }
        return false;
    }

    public static void deleteBasket() {
        products = new Product[LENGTH];
        Count = 0;
    }


}
