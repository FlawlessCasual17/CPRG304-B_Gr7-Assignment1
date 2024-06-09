package shapes;

/**
 * This class represents an octagonal prism,
 * which is a three-dimensional shape with
 * two octagonal bases and eight rectangular faces.
 */
public class OctagonalPrism extends ThreeDShape {

    private final double edgeLength, height;

    /**
     * Constructs a new octagonal prism with the given edge length and height.
     *
     * @param edgeLength    The length of each octagonal base edge
     * @param height        The height of the prism
     *
     * @throws IllegalArgumentException
     *      If either edge length or height is non-positive
     */
    public OctagonalPrism(double edgeLength, double height) {
        if (edgeLength <= 0 || height <= 0)
            throw new IllegalArgumentException("Edge length and height must be positive.");

        this.edgeLength = edgeLength; this.height = height;
    }

    /**
     * Returns the height of the octagonal prism.
     *
     * @return      The height
     */
    @Override
    public double getHeight() { return height; }

    /**
     * Returns the base area of the octagonal prism.
     *
     * @return      The base area
     */
    @Override
    public double getBaseArea() {
        // Base area of an octagon
        return 2 * (1 + Math.sqrt(2)) * edgeLength * edgeLength;
    }

    /**
     * Returns the volume of the octagonal prism.
     *
     * @return      The volume
     */
    @Override
    public double getVolume() {
        // Volume = base area * height
        return getBaseArea() * height;
    }

    /**
     * Returns a string representation of the cone.
     *
     * @return      A string representation of the octagonal prism
     */
    @Override
    public String toString() {
        return "OctagonalPrism [edge length=%.2f, height=%.2f, base area=%.2f, volume=%.2f]"
            .formatted(edgeLength, getHeight(), getBaseArea(), getVolume());
    }
}
