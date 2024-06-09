package comparators;

import shapes.ThreeDShape;
import shapes.ShapeComparator;

public class VolumeComparator implements ShapeComparator {
    @Override
    public int compare(ThreeDShape s1, ThreeDShape s2) {
        return Double.compare(s1.getVolume(), s2.getVolume());
    }
}
