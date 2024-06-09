package shapes;

public class OctagonalPrism extends ThreeDShape {
    private final double edgeLength, height;

    public OctagonalPrism(double edgeLength, double height) {
        this.edgeLength = edgeLength; this.height = height;
    }

    @Override
    public double getHeight() { return height; }

    @Override
    public double getBaseArea() {
        // Base area of an octagon
        return 2 * (1 + Math.sqrt(2)) * edgeLength * edgeLength;
    }

    @Override
    public double getVolume() {
        // Volume = base area * height
        return getBaseArea() * height;
    }

    @Override
    public String toString() {
        return String.format("OctagonalPrism [edge length=%.2f, height=%.2f, base area=%.2f, volume=%.2f]", edgeLength, getHeight(), getBaseArea(), getVolume());
    }
}
