package shapes;

public class Cone extends ThreeDShape {
    private double radius;
    private double height;

    public Cone(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getBaseArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getVolume() {
        return (1.0 / 3) * getBaseArea() * height;
    }
    
    public String toString() {
        return String.format("Cone [radius=%.2f, height=%.2f, base area=%.2f, volume=%.2f]",
                             radius, getHeight(), getBaseArea(), getVolume());
    }
}