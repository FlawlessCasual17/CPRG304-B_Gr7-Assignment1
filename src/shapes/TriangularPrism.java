package shapes;

public class TriangularPrism extends ThreeDShape {
    private double edgeLength;
    private double height;

    public TriangularPrism(double edgeLength, double height) {
        this.edgeLength = edgeLength;
        this.height = height;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getBaseArea() {
        return (Math.sqrt(3) / 4) * edgeLength * edgeLength;
    }

    @Override
    public double getVolume() {
        return getBaseArea() * height;
    }

    @Override
    public String toString() {
        return String.format("TriangularPrism [edge length=%.2f, height=%.2f, base area=%.2f, volume=%.2f]",
                edgeLength, getHeight(), getBaseArea(), getVolume());
    }
}
