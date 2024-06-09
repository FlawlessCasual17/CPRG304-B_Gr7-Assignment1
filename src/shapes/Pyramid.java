package shapes;

public class Pyramid extends ThreeDShape {
    private double edgeLength;
    private double height;

    public Pyramid(double edgeLength, double height) {
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
        return (1.0 / 3) * getBaseArea() * height;
    }
    
    @Override
    public String toString() {
        return String.format("Pyramid [edge length=%.2f, height=%.2f, base area=%.2f, volume=%.2f]",
                             edgeLength, getHeight(), getBaseArea(), getVolume());
    }
}
