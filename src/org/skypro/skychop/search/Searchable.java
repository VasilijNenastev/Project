package org.skypro.skychop.search;

public interface Searchable {
    String getSearchTerm();

    String getSearchContent();

    default String getStringRepresentation() {
        return getSearchTerm() + " - " + getSearchContent();
    }
}
