package shapes;

/**
 * This class represents a cone, which is a
 * three-dimensional shape with a circular
 * base and a tapered lateral surface
 * that meets at a point called the apex.
 */
public class Cone extends ThreeDShape {
    private final double radius, height;

    /**
     * Constructs a new cone with the given radius and height.
     *
     * @param radius    The radius of the circular base
     * @param height    The height of the cone
     *
     * @throws IllegalArgumentException
     *      If either radius or height is non-positive
     */
    public Cone(double radius, double height) {
        if (radius <= 0 || height <= 0)
            throw new IllegalArgumentException("Radius and height must be positive.");

        this.radius = radius;  this.height = height;
    }

    /**
     * Returns the height of the cone.
     *
     * @return      The height
     */
    @Override
    public double getHeight() { return height; }

    /**
     * Returns the base area of the cone.
     *
     * @return      The base area
     */
    @Override
    public double getBaseArea() { return Math.PI * radius * radius; }

    /**
     * Returns the volume of the cone.
     *
     * @return      The volume
     */
    @Override
    public double getVolume() { return (1.0 / 3) * getBaseArea() * height; }

    /**
     * Returns a string representation of the cone.
     *
     * @return      A string representation of the cone
     */
    @Override
    public String toString() {
        return "Cone [radius=%.2f, height=%.2f, base area=%.2f, volume=%.2f]"
            .formatted(radius, getHeight(), getBaseArea(), getVolume());
    }
}
