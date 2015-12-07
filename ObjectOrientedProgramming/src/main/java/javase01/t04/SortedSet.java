package javase01.t04;

import javase01.t03.BeginnerSet;

import java.util.Collections;

public class SortedSet extends BeginnerSet {

    public void sortByName() {
        Collections.sort(beginnerSet, (a, b) -> a.getName().compareTo(b.getName()));
    }

    public void sortByPrice() {
        Collections.sort(beginnerSet, (a, b) -> {
            if (a.getPrice() > b.getPrice()) {
                return 1;
            } else if (a.getPrice() < b.getPrice()) {
                return -1;
            } else {
                return 0;
            }
        });
    }

    public void sortByPriceAndName() {
        Collections.sort(beginnerSet, (a, b) -> {
            if (a.getPrice() > b.getPrice()) {
                return 1;
            } else if (a.getPrice() < b.getPrice()) {
                return -1;
            } else {
                return a.getName().compareTo(b.getName());
            }
        });
    }
}
