package shapes;

/**
 * This class represents a pyramid,
 * which is a three-dimensional shape with a
 * polygonal base and triangular faces
 * that meet at a point called the apex.
 */
public class Pyramid extends ThreeDShape {
    private final double edgeLength, height;

    /**
     * Constructs a new pyramid with the given edge, length, and height.
     *
     * @param edgeLength    The length of each base edge
     * @param height        The height of the pyramid
     *
     * @throws IllegalArgumentException
     *      If either edge length or height is non-positive
     */
    public Pyramid(double edgeLength, double height) {
        if (edgeLength <= 0 || height <= 0)
            throw new IllegalArgumentException("Edge length and height must be positive.");

        this.edgeLength = edgeLength; this.height = height;
    }

    /**
     * Returns the height of the pyramid.
     *
     * @return the height
     */
    @Override
    public double getHeight() { return height; }

    /**
     * Returns the base area of the pyramid.
     *
     * @return the base area
     */
    @Override
    public double getBaseArea() { return Math.pow(edgeLength, 2); }

    /**
     * Returns the volume of the pyramid.
     *
     * @return the volume
     */
    @Override
    public double getVolume() { return (1.0 / 3) * getBaseArea() * height; }

    /**
     * Returns a string representation of the pyramid.
     *
     * @return a string representation of the pyramid
     */
    @Override
    public String toString() {
        return "Pyramid [edge length=%.2f, height=%.2f, base area=%.2f, volume=%.2f]"
            .formatted(edgeLength, getHeight(), getBaseArea(), getVolume());
    }
}
