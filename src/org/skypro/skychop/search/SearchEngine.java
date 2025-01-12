package org.skypro.skychop.search;

import org.skypro.skychop.exception.BestResultNotFoundException;

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

    public Searchable getMaximumMatchQuery(String search) throws BestResultNotFoundException {
        Searchable Match = null;
        int Count = 0;

        for (Searchable searchable : searchables) {
            int Count1 = countSubstrings(searchable.toString(), search);
            if (Count1 > Count) {
                Count = Count1;
                Match = searchable;
            }
        }

        if(Match == null) throw new BestResultNotFoundException("Для запроса " + search + "  нет совпадения !!!");
        return Match;
    }

    private int countSubstrings(String str, String substring) {
        if (str == null || substring == null || substring.isEmpty()) {
            return 0;
        }

        int count = 0;
        int index = 0;
        int subIndex = str.indexOf(substring, index);

        while (subIndex != -1) {
            count++;
            index = index + substring.length();
            subIndex = str.indexOf(substring, index);
        }

        return count;
    }


}
