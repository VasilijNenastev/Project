package org.skypro.skychop.article;

import org.skypro.skychop.search.Searchable;

import java.util.Objects;

public class Article implements Searchable {
    private final String article;
    private final String text;

    public Article(String article, String text) {
        this.article = article;
        this.text = text;
    }

    public String getArticle() {
        return article;
    }


    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return article + '\n' + text;
    }

    @Override
    public String getSearchTerm() {
        return article + "\nТип - ARTICLE\n";
    }

    @Override
    public String getSearchContent() {
        return "ARTICLE\n";
    }

    @Override
    public String getStringRepresentation() {
        return article + "\nТип - ARTICLE";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article1 = (Article) o;
        return Objects.equals(article, article1.article) && Objects.equals(text, article1.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(article, text);
    }
}
