package javase01.t03;


import javase01.t02.Stationery.*;

import java.util.ArrayList;
import java.util.List;

public class BeginnerSet {

    protected List<Stationery> beginnerSet;

    public BeginnerSet() {
        this.beginnerSet = new ArrayList<>();
        fill();
    }

    public List<Stationery> getBeginnerSet() {
        return beginnerSet;
    }

    public void setBeginnerSet(List<Stationery> beginnerSet) {
        this.beginnerSet = beginnerSet;
    }

    private void fill() {
        beginnerSet.add(new Pencil("pencil", 20, "soft"));
        beginnerSet.add(new Lasting("lacting", 20, "round"));
        beginnerSet.add(new Scissors("scissors", 55));
        beginnerSet.add(new Pen("pen", 50, "gel", "black"));
        beginnerSet.add(new Ruler("ruler", 17.5, 20 ));
    }
}
