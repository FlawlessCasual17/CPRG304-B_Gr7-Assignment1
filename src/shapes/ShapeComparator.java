package shapes;

import java.util.Comparator;

public interface ShapeComparator extends Comparator<ThreeDShape> { }

class BaseAreaComparator implements ShapeComparator {
    @Override
    public int compare(ThreeDShape s1, ThreeDShape s2) {
        return Double.compare(s1.getBaseArea(), s2.getBaseArea());
    }
}

class VolumeComparator implements ShapeComparator {
    @Override
    public int compare(ThreeDShape s1, ThreeDShape s2) {
        return Double.compare(s1.getVolume(), s2.getVolume());
    }
}
