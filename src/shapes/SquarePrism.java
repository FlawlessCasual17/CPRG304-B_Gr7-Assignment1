package shapes;

/**
 * This class represents a square prism,
 * which is a three-dimensional shape with
 * two square bases and four rectangular faces.
 */
public class SquarePrism extends ThreeDShape {
    private final double edgeLength, height;

    /**
     * Constructs a new square prism with the given edge, length, and height.
     *
     * @param edgeLength    the length of each square base edge
     * @param height        the height of the prism
     *
     * @throws IllegalArgumentException
     *      If either edge length or height is non-positive
     */
    public SquarePrism(double edgeLength, double height) {
        if (edgeLength <= 0 || height <= 0)
            throw new IllegalArgumentException("Edge length and height must be positive.");

        this.edgeLength = edgeLength; this.height = height;
    }

    /**
     * Returns the height of the square prism.
     *
     * @return      The height
     */
    @Override
    public double getHeight() { return height; }

    /**
     * Returns the base area of the square prism.
     *
     * @return      The base area
     */
    @Override
    public double getBaseArea() { return Math.pow(edgeLength, 2); }

    /**
     * Returns the volume of the square prism.
     *
     * @return      The volume
     */
    @Override
    public double getVolume() { return getBaseArea() * height; }

    /**
     * Returns a string representation of the square prism.
     *
     * @return      A string representation of the square prism
     */
    @Override
    public String toString() {
        return "SquarePrism [edge length=%.2f, height=%.2f, base area=%.2f, volume=%.2f]"
            .formatted(edgeLength, getHeight(), getBaseArea(), getVolume());
    }
}
