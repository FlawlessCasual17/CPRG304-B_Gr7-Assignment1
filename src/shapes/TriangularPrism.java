package shapes;

/**
 * This class represents a triangular prism,
 * which is a three-dimensional shape with
 * two triangular bases and three rectangular faces.
 */
public class TriangularPrism extends ThreeDShape {
    private final double edgeLength, height;

    /**
     * Constructs a new triangular prism with the given edge length and height.
     *
     * @param edgeLength    The length of each the triangular base edge
     * @param height        The height of the prism
     *
     * @throws IllegalArgumentException If either edge length or height is non-positive
     */
    public TriangularPrism(double edgeLength, double height) {
        if (edgeLength <= 0 || height <= 0) {
            throw new IllegalArgumentException("Edge length and height must be positive.");
        }
        this.edgeLength = edgeLength; this.height = height;
    }

    /**
     * Returns the height of the triangular prism.
     *
     * @return      The height
     */
    @Override
    public double getHeight() { return height; }

    /**
     * Returns the base area of the triangular prism.
     *
     * @return      The base area
     */
    @Override
    public double getBaseArea() { return (Math.sqrt(3) / 4) * edgeLength * edgeLength; }

    /**
     * Returns the volume of the triangular prism.
     *
     * @return      The volume
     */
    @Override
    public double getVolume() { return getBaseArea() * height; }

    /**
     * Returns a string representation of the triangular prism.
     *
     * @return      A string representation of the triangular prism
     */
    @Override
    public String toString() {
        return "TriangularPrism [edge length=%.2f, height=%.2f, base area=%.2f, volume=%.2f]"
            .formatted(edgeLength, getHeight(), getBaseArea(), getVolume());
    }
}
