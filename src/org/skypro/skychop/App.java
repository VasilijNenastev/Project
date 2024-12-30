package org.skypro.skychop;

import org.skypro.skychop.article.Article;
import org.skypro.skychop.basket.ProductBasket;
import org.skypro.skychop.product.DiscountedProduct;
import org.skypro.skychop.product.FixPriceProduct;
import org.skypro.skychop.product.SimpleProduct;
import org.skypro.skychop.search.SearchEngine;

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
                System.out.println("=================================");
                System.out.println( "Поиск по признаку");


                SearchEngine searchEngine = new SearchEngine(10);
                searchEngine.add(product1);
                searchEngine.add(product2);
                searchEngine.add(product3);
                searchEngine.add(product4);
                searchEngine.add(product5);
                searchEngine.add(product6);

                Article article1 = new Article("Название статьи 1", "Текст статьи 1");
                Article article2 = new Article("Название статьи 2", "Текст статьи 2");
                Article article3 = new Article("Название статьи 3", "Текст статьи 3");
                Article article4 = new Article("Название статьи 4", "Текст статьи 4");

                searchEngine.add(article1);
                searchEngine.add(article2);
                searchEngine.add(article3);
                searchEngine.add(article4);

                String[] searchResults = searchEngine.search("PRODUCT");
                for (String result : searchResults) {
                    if (result == null) continue;
                    System.out.println(result);
                }
                System.out.println();

                searchResults = searchEngine.search("ARTICLE");
                for (String result : searchResults) {
                    if (result == null) continue;
                    System.out.println(result);
                }
                System.out.println();

                searchResults = searchEngine.search("колбаса");
                for (String result : searchResults) {
                    if (result == null) continue;
                    System.out.println(result);
                }
                System.out.println();


            }


        }


    }


}



