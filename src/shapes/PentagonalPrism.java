package shapes;

/**
 * This class represents a pentagonal prism,
 * which is a three-dimensional shape with
 * two pentagonal bases and five rectangular faces.
 */
public class PentagonalPrism extends ThreeDShape {
    private final double edgeLength, height;

    /**
     * Constructs a new pentagonal prism with the given edge length and height.
     *
     * @param edgeLength    The length of each pentagonal base edge
     * @param height        The height of the prism
     *
     * @throws IllegalArgumentException
     *      If either edge length or height is non-positive
     */
    public PentagonalPrism(double edgeLength, double height) {
        if (edgeLength <= 0 || height <= 0)
            throw new IllegalArgumentException("Edge length and height must be positive.");

        this.edgeLength = edgeLength; this.height = height;
    }

    /**
     * Returns the height of the pentagonal prism.
     *
     * @return      The height
     */
    @Override
    public double getHeight() { return height; }

    /**
     * Returns the base area of the pentagonal prism.
     *
     * @return      The base area
     */
    @Override
    public double getBaseArea() {
        // Base area of a regular pentagon
        var apothem = edgeLength / (2 * Math.tan(Math.PI / 5));
        return (5 * edgeLength * apothem) / 2;
    }

    /**
     * Returns the volume of the pentagonal prism.
     *
     * @return      The volume
     */
    @Override
    public double getVolume() {
        // Volume = base area * height
        return getBaseArea() * height;
    }

    /**
     * Returns a string representation of the pentagonal prism.
     *
     * @return      A string representation of the pentagonal prism
     */
    @Override
    public String toString() {
        return "PentagonalPrism [edge length=%.2f, height=%.2f, base area=%.2f, volume=%.2f]"
            .formatted(edgeLength, getHeight(), getBaseArea(), getVolume());
    }
}
