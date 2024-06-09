package shapes;

public class PentagonalPrism extends ThreeDShape {
    private final double edgeLength, height;

    public PentagonalPrism(double edgeLength, double height) {
        this.edgeLength = edgeLength; this.height = height;
    }

    @Override
    public double getHeight() { return height; }

    @Override
    public double getBaseArea() {
        // Base area of a regular pentagon
        var apothem = edgeLength / (2 * Math.tan(Math.PI / 5));
        return (5 * edgeLength * apothem) / 2;
    }

    @Override
    public double getVolume() {
        // Volume = base area * height
        return getBaseArea() * height;
    }

    @Override
    public String toString() {
        return String.format("PentagonalPrism [edge length=%.2f, height=%.2f, base area=%.2f, volume=%.2f]", edgeLength, getHeight(), getBaseArea(), getVolume());
    }
}
