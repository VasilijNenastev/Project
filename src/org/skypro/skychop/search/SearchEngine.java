package org.skypro.skychop.search;

public class SearchEngine {
    Searchable[] searchables;
    int Count = 0;

    public SearchEngine(int quantity) {
        searchables = new Searchable[quantity];
    }

    public String[] search(String searchTerm) {
        String[] results = new String[5];
        int CountResult = 0;
        for (int i = 0; i < Count; i++) {
            if (searchables[i].searchTerm().contains(searchTerm)) {
                results[CountResult++] = searchables[i].getStringRepresentation();
            }
            if (CountResult == 5) break;

        }
        return results;
    }
    public void add(Searchable searchable) {
        searchables[Count++] = searchable;
    }


}
