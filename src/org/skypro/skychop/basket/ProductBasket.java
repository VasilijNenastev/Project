package org.skypro.skychop.basket;

import org.skypro.skychop.product.Product;

import java.util.*;


public class ProductBasket {

    private static Map<String, LinkedList<Product>> products;

    public ProductBasket() {
        products = new HashMap<>();
    }

    public static void addProduct(Product product) {
        products.computeIfAbsent(product.getNameProduct(), k -> new LinkedList<>()).add(product);
    }

    public static void printAllProductBasket() {
        StringBuilder printProduct = new StringBuilder();
        products.values().stream().flatMap(Collection::stream)
                .forEach(product -> printProduct.append(product).append("\n"));
        int CountSpecial = (int)
                products.values().stream().flatMap(Collection::stream)
                        .filter(Product::isSpecial).count();

        System.out.print(printProduct);
        if (CountSpecial != 0) {
            System.out.println("Специальных товаров: " + CountSpecial);
        }
        if (printProduct.isEmpty()) {
            System.out.println(" Корзина пуста");
        }

    }


    public static int totalPriceOfProduct() {
        return
                products.values().stream().flatMap(Collection::stream)
                        .mapToInt(Product::getPriceOfProduct).sum();

    }

    public static boolean isHasProduct(String name) {
        if (products.isEmpty()) return false;
        return products.containsKey(name);
    }

    public static void deleteBasket() {
        products.clear();
    }

    public static List removeProduct(String name) {
        if (products.isEmpty() || !products.containsKey(name)) return new ArrayList<Product>();
        LinkedList<Product> removedProducts = products.remove(name);
        return removedProducts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductBasket that = (ProductBasket) o;
        return Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(products);
    }
}


