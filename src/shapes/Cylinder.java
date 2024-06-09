package shapes;

/**
 * This class represents a cylinder,
 * which is a three-dimensional shape with
 * two circular bases and a curved lateral surface.
 */
public class Cylinder extends ThreeDShape {
    private final double radius, height;

    /**
     * Constructs a new cylinder with the given radius and height.
     *
     * @param radius    The radius of the circular base
     * @param height    The height of the cylinder
     *
     * @throws IllegalArgumentException
     *      If either radius or height is non-positive
     */
    public Cylinder(double radius, double height) {
        if (radius <= 0 || height <= 0)
            throw new IllegalArgumentException("Radius and height must be positive.");

        this.radius = radius; this.height = height;
    }

    /**
     * Returns the height of the cylinder.
     *
     * @return      The height
     */
    @Override
    public double getHeight() { return height; }

    /**
     * Returns the base area of the cylinder.
     *
     * @return      The base area
     */
    @Override
    public double getBaseArea() { return Math.PI * radius * radius; }

    /**
     * Returns the volume of the cylinder.
     *
     * @return      The volume
     */
    @Override
    public double getVolume() { return getBaseArea() * height; }

    /**
     * Returns a string representation of the cylinder.
     *
     * @return
     *      A string representation of the cylinder
     */
    @Override
    public String toString() {
        return "Cylinder [radius=%.2f, height=%.2f, base area=%.2f, volume=%.2f]"
            .formatted(radius, getHeight(), getBaseArea(), getVolume());
    }
}
