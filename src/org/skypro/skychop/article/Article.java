package org.skypro.skychop.article;

import org.skypro.skychop.search.Searchable;

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


}
