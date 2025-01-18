package org.skypro.skychop.basket;

import org.skypro.skychop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class ProductBasket {

    private static LinkedList<Product> products;

    public ProductBasket() {
        products = new LinkedList<>();
    }

    public static void addProduct(Product product) {
        products.add(product);
    }

    public static void printAllProductBasket() {
        StringBuilder printProduct = new StringBuilder();
        int CountSpecial = 0;
        for (Product product : products) {
            printProduct.append(product);
            {
                System.out.println(product);
            }
            if (product.isSpecial()) CountSpecial++;
        }
        if (CountSpecial != 0) {
            System.out.println("Специальных товаров: " + CountSpecial);
        }
        if (printProduct.isEmpty()) {
            System.out.println(" Корзина пуста");
        }
    }

    public static int totalPriceOfProduct() {
        if (products.isEmpty()) return 0;
        int sum = 0;
        for (Product product : products) {
            sum += product.getPriceOfProduct();
        }
        return sum;
    }

    public static boolean isHasProduct(String name) {
        if (products.isEmpty()) return false;
        for (Product product : products) {
            if (product.getNameProduct().equals(name)) return true;
        }
        return false;
    }

    public static void deleteBasket() {
        products.clear();
    }

    public static List removeProduct(String name) {
        if (products.isEmpty()) return new ArrayList<Product>();
        ArrayList<Product> removedProducts = new ArrayList<>();
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product p = iterator.next();
            if (p.getNameProduct().equals(name)) {
                removedProducts.add(p);
                iterator.remove();
            }
        }
        return removedProducts;
    }
}


