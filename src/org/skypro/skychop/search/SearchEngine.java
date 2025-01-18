package org.skypro.skychop.search;

import org.skypro.skychop.exception.BestResultNotFoundException;

import java.util.ArrayList;
import java.util.LinkedList;

public class SearchEngine {
    LinkedList<Searchable> searchables;

    public SearchEngine() {
        searchables = new LinkedList<>();
    }

    public ArrayList<Searchable> search(String searchTerm) {
        ArrayList<Searchable> results = new ArrayList<>();
        for (Searchable searchable : searchables) {
            if (searchable.getSearchTerm().contains(searchTerm)) {
                results.add(searchable);
            }
        }
        return results;
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
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
        if (Match == null) throw new BestResultNotFoundException("Для запроса " + search + "  нет совпадения !!!");
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
