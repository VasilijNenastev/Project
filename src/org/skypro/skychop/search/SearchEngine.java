package org.skypro.skychop.search;

import org.skypro.skychop.comparator.NameComparator;
import org.skypro.skychop.exception.BestResultNotFoundException;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SearchEngine {
    Set<Searchable> searchables;

    public SearchEngine() {
        searchables = new HashSet<>();
    }

    public Set<Searchable> search(String searchTerm) {
        return searchables.stream().filter(searchable -> searchable.getSearchTerm().contains(searchTerm))
                .collect(Collectors.toCollection(()-> new TreeSet<>(new NameComparator())));
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
