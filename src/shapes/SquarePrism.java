package shapes;

public class SquarePrism extends ThreeDShape {
    private double edgeLength;
    private double height;

    public SquarePrism(double edgeLength, double height) {
        this.edgeLength = edgeLength;
        this.height = height;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getBaseArea() {
        return Math.pow(edgeLength, 2);
    }

    @Override
    public double getVolume() {
        return getBaseArea() * height;
    }

    @Override
    public String toString() {
        return String.format("SquarePrism [edge length=%.2f, height=%.2f, base area=%.2f, volume=%.2f]", edgeLength, getHeight(), getBaseArea(), getVolume());
    }
}
