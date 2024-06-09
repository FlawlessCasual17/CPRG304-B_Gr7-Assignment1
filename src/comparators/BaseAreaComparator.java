package comparators;

import shapes.*;

public class BaseAreaComparator implements ShapeComparator {
    @Override
    public int compare(ThreeDShape s1, ThreeDShape s2) {
        return Double.compare(s1.getBaseArea(), s2.getBaseArea());
    }
}
