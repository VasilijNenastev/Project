package org.skypro.skychop;

import org.skypro.skychop.basket.ProductBasket;
import org.skypro.skychop.product.DiscountedProduct;
import org.skypro.skychop.product.FixPriceProduct;
import org.skypro.skychop.product.SimpleProduct;

public class App {


    public static class Main {

        public Main() {

        }

        public static void main(String[] args) {


            {
                SimpleProduct product1 = new SimpleProduct("сахар", 350);
                DiscountedProduct product2 = new DiscountedProduct("молоко", 200, 20);
                FixPriceProduct product3 = new FixPriceProduct("кофе");
                SimpleProduct product4 = new SimpleProduct("конфеты", 700);
                SimpleProduct product5 = new SimpleProduct("колбаса", 600);
                SimpleProduct product6 = new SimpleProduct("мясо", 2000);

                ProductBasket productBasket = new ProductBasket();
                ProductBasket.addProduct(product1);
                ProductBasket.addProduct(product2);
                ProductBasket.addProduct(product3);
                ProductBasket.addProduct(product4);
                ProductBasket.addProduct(product5);
                ProductBasket.addProduct(product6);


            }

            System.out.println("=================================");
            ProductBasket.addProduct(new SimpleProduct());//Проверка на возможность добавить продукт
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
            System.out.println("Итого: " + ProductBasket.totalPriceOfProduct() + " рублей.");//Стоимость пустой корзины
            System.out.println(ProductBasket.isHasProduct("колбаса"));//Поиск товара в пустой корзине


        }


    }
}


