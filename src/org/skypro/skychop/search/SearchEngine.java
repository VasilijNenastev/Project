package org.skypro.skychop.search;

public class SearchEngine {
    Searchable[] searchables;
    int Count = 0;

    public SearchEngine(int quantity) {
        searchables = new Searchable[quantity];
    }

    public Searchable[] search(String searchTerm) {
        Searchable[] results = new Searchable[5];
        int CountResult = 0;
        for (int i = 0; i < Count; i++) {
            if (searchables[i].getSearchTerm().contains(searchTerm)) {
                results[CountResult++] = searchables[i];
            }
            if (CountResult == 5) break;

        }
        return results;
    }

    public void add(Searchable searchable) {
        searchables[Count++] = searchable;
    }


}
