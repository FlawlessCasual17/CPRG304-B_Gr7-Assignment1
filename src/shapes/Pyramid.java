package shapes;

public class Pyramid extends ThreeDShape {
    private final double edgeLength, height;

    public Pyramid(double edgeLength, double height) {
        this.edgeLength = edgeLength; this.height = height;
    }

    @Override
    public double getHeight() { return height; }

    @Override
    public double getBaseArea() { return Math.pow(edgeLength, 2); }

    @Override
    public double getVolume() { return (1.0 / 3) * getBaseArea() * height; }

    @Override
    public String toString() {
        return "Pyramid [edge length=%.2f, height=%.2f, base area=%.2f, volume=%.2f]"
            .formatted(edgeLength, getHeight(), getBaseArea(), getVolume());
    }
}
