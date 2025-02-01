package org.skypro.skychop.comparator;

import org.skypro.skychop.search.Searchable;

public class NameComparator implements java.util.Comparator<Searchable> {

    @Override
    public int compare(Searchable o1, Searchable o2) {
        if (o1.getStringRepresentation().length() != o2.getStringRepresentation().length())
            return Integer.compare(o2.getStringRepresentation().length(), o1.getStringRepresentation().length());
        return o2.getStringRepresentation().compareTo(o1.getStringRepresentation());
    }
}
