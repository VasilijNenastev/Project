package org.skypro.skychop.search;

public interface Searchable {
    String searchTerm();

    String searchContent();

    default String getStringRepresentation(){
        return searchTerm() + " - " + searchContent();
    }
}
