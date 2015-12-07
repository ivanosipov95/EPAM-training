package javase01.t04;

import javase01.t02.Stationery.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SortedSetTest {

    SortedSet set;
    List<Stationery> sortByName;
    List<Stationery> sortByPrice;
    List<Stationery> sortByPriceAndName;

    @Before
    public void setUp() {
        set = new SortedSet();
        sortByName =  new ArrayList<>();
        sortByPrice = new ArrayList<>();
        sortByPriceAndName = new ArrayList<>();

        fillByAlphabet(sortByName);
        fillByPrice(sortByPrice);
        fillByPriceAndName(sortByPriceAndName);
    }

    private void fillByAlphabet(List<Stationery> sortByName) {
        sortByName.add(new Lasting("lacting", 20, "round"));
        sortByName.add(new Pen("pen", 50, "gel", "black"));
        sortByName.add(new Pencil("pencil", 20, "soft"));
        sortByName.add(new Ruler("ruler", 17.5, 20 ));
        sortByName.add(new Scissors("scissors", 55));
    }

    private void fillByPrice(List<Stationery> sortByPrice) {
        sortByPrice.add(new Ruler("ruler", 17.5, 20 ));
        sortByPrice.add(new Pencil("pencil", 20, "soft"));
        sortByPrice.add(new Lasting("lacting", 20, "round"));
        sortByPrice.add(new Pen("pen", 50, "gel", "black"));
        sortByPrice.add(new Scissors("scissors", 55));
    }

    private void fillByPriceAndName(List<Stationery> sortByPriceAndName) {
        sortByPriceAndName.add(new Ruler("ruler", 17.5, 20 ));
        sortByPriceAndName.add(new Lasting("lacting", 20, "round"));
        sortByPriceAndName.add(new Pencil("pencil", 20, "soft"));
        sortByPriceAndName.add(new Pen("pen", 50, "gel", "black"));
        sortByPriceAndName.add(new Scissors("scissors", 55));
    }

    @Test
    public void testSortByName() throws Exception {
        set.sortByName();

        assertEquals(sortByName, set.getBeginnerSet());
    }

    @Test
    public void testSortByPrice() throws Exception {
        set.sortByPrice();

        assertEquals(sortByPrice, set.getBeginnerSet());
    }
    @Test
    public void testSortByPriceAndName() throws Exception {
        set.sortByPriceAndName();

        assertEquals(sortByPriceAndName, set.getBeginnerSet());
    }
}