package org.skypro.skychop;

import org.skypro.skychop.article.Article;
import org.skypro.skychop.basket.ProductBasket;
import org.skypro.skychop.exception.BestResultNotFoundException;
import org.skypro.skychop.exception.DiscountedException;
import org.skypro.skychop.exception.NameException;
import org.skypro.skychop.exception.PriceException;
import org.skypro.skychop.product.DiscountedProduct;
import org.skypro.skychop.product.FixPriceProduct;
import org.skypro.skychop.product.SimpleProduct;
import org.skypro.skychop.search.SearchEngine;
import org.skypro.skychop.search.Searchable;

import java.util.List;
import java.util.Set;


public class App {


    public static class Main {

        public Main() {

        }

        public static void main(String[] args) {


            try {
                SimpleProduct product1 = new SimpleProduct("сахар", 700);
                DiscountedProduct product2 = new DiscountedProduct("молоко", 200, 11);
                FixPriceProduct product3 = new FixPriceProduct("кофе");
                SimpleProduct product4 = new SimpleProduct("конфеты", 500);
                SimpleProduct product5 = new SimpleProduct("колбаса", 600);
                SimpleProduct product6 = new SimpleProduct("мясо", 2000);
                SimpleProduct product7 = new SimpleProduct("молоко", 300);

                ProductBasket productBasket = new ProductBasket();
                ProductBasket.addProduct(product1);
                ProductBasket.addProduct(product2);
                ProductBasket.addProduct(product3);
                ProductBasket.addProduct(product4);
                ProductBasket.addProduct(product5);
                ProductBasket.addProduct(product6);
                ProductBasket.addProduct(product7);


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
                System.out.println(" Удаление продукта по названию");
                System.out.println("----------------------------------");

                List removedProducts = ProductBasket.removeProduct("мясо");
                List removedProductsTry = ProductBasket.removeProduct("торт");

                System.out.println("Удаленные товары: " + removedProducts);
                if (removedProductsTry.isEmpty()) {
                    System.out.println("Не существующие удаленные товары: " + removedProductsTry + " список пуст.");
                } else {
                    ProductBasket.printAllProductBasket();
                }
                System.out.println("----------------------------------");
                System.out.println("В корзине:");
                ProductBasket.printAllProductBasket();
                System.out.println("Итого:" + ProductBasket.totalPriceOfProduct() + " рублей.");
                System.out.println("=================================");
                System.out.println("Удаление всех продуктов из корзины.");
                ProductBasket.deleteBasket();//Удаление продуктов из корзины
                System.out.println("В корзине:");
                ProductBasket.printAllProductBasket();
                System.out.println("Итого: " + ProductBasket.totalPriceOfProduct() + " рублей.");//Стоимость пустой корзины
                System.out.println("Поиск товара в пустой корзине по названию продукта:");
                System.out.println(ProductBasket.isHasProduct("колбаса"));//Поиск товара в пустой корзине
                System.out.println("=================================");
                System.out.println("Поиск по признаку");
                System.out.println("__________________________________");


                SearchEngine searchEngine = new SearchEngine();
                searchEngine.add(product1);
                searchEngine.add(product2);
                searchEngine.add(product3);
                searchEngine.add(product4);
                searchEngine.add(product5);
                searchEngine.add(product6);
                searchEngine.add(product7);

                Article article1 = new Article("Название статьи 1", "Текст статьи 1");
                Article article2 = new Article("Название статьи 2", "Текст статьи 2");
                Article article3 = new Article("Название статьи 3", "Текст статьи 3");
                Article article4 = new Article("Название статьи 4", "Текст статьи 4");

                searchEngine.add(article1);
                searchEngine.add(article2);
                searchEngine.add(article3);
                searchEngine.add(article4);


                Set<Searchable> searchResults = searchEngine.search("PRODUCT");
                for (Searchable result : searchResults) {
                    if (result == null) continue;
                    System.out.println(result);
                }
                System.out.println("__________________________________");

                searchResults = searchEngine.search("ARTICLE");
                for (Searchable result : searchResults) {
                    if (result == null) continue;
                    System.out.println(result);
                }
                System.out.println("__________________________________");
                searchResults = searchEngine.search("колбаса");
                for (Searchable result : searchResults) {
                    if (result == null) continue;
                    System.out.println(result);
                }
                System.out.println("=================================");
                System.out.println("Поиск объекта по совпадению");

                System.out.println(searchEngine.getMaximumMatchQuery("сах"));
                System.out.println(searchEngine.getMaximumMatchQuery("кеф"));


            } catch (NameException e) {// для проверки изменить наименование продукта в массиве/
                System.out.println(" Наименование продукта не может быть пустым!!!");
            } catch (PriceException e) {//Для проверки изменить цену продукта в массиве/
                System.out.println(" Цена продукта не может быть менее или равна 0 рублей !!!");
            } catch (DiscountedException e) {//Для проверки изменить скидку на продукт в массиве/
                System.out.println(" Скидка не может быть менее 0% и более 100% !!!");
            } catch (BestResultNotFoundException e) {
                System.out.println(e.getMessage());

            }


        }


    }


}



