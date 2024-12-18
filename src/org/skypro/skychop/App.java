package org.skypro.skychop;

import org.skypro.skychop.basket.ProductBasket;
import org.skypro.skychop.product.Product;

public class App {


    public static class Main {

        public Main() {

        }

        public static void main(String[] args) {


            {
                Product product1 = new Product("сахар", 350);
                Product product2 = new Product("молоко", 200);
                Product product3 = new Product("кофе", 400);
                Product product4 = new Product("конфеты", 700);
                Product product5 = new Product("колбаса", 600);
                Product product6 = new Product("молоко", 100);

                ProductBasket productBasket = new ProductBasket();
                productBasket.addProduct(product1);
                productBasket.addProduct(product2);
                productBasket.addProduct(product3);
                productBasket.addProduct(product4);
                productBasket.addProduct(product5);
                productBasket.addProduct(product6);


            }

            System.out.println("=================================");
            ProductBasket.addProduct(new Product());//Проверка на возможность добавить продукт
            System.out.println("=================================");
            ProductBasket.basketEmpty();//Проверка не пуста ли корзина
            System.out.println("=================================");
            System.out.println("В корзине:");//Печать товара в корзине
            ProductBasket.printAllProductBasket();
            System.out.println("=================================");
            System.out.println("Итого:" + ProductBasket.totalPriceOfProduct() + " рублей.");// Общая стоимость корзины
            System.out.println("=================================");
            System.out.println("Проверка наличия продукта в корзине: ");
            System.out.println("колла - " + ProductBasket.isHasProduct("колла"));
            System.out.println("колбаса - " + ProductBasket.isHasProduct("колбаса"));
            System.out.println("=================================");
            ProductBasket.deleteBasket();//Удаление продуктов из корзины
            System.out.println("В корзине:");
            ProductBasket.basketEmpty();
            ProductBasket.printAllProductBasket();
            System.out.println("Итого:" + ProductBasket.totalPriceOfProduct() + " рублей.");//Стоимость пустой корзины
            System.out.println(ProductBasket.isHasProduct("колбаса"));//Поиск товара в пустой корзине


        }


    }
}

