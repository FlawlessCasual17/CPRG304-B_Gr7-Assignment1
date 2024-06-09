package shapes;

/**
 * This abstract class represents a 3D shape with height and base area.
 * Subclasses must implement methods to calculate the specific volume of the shape.
 *
 * @see Comparable
 */
public abstract class ThreeDShape implements Comparable<ThreeDShape> {
    /**
     * Gets the height of the 3D shape.
     *
     * @return      The height of the shape
     */
    public abstract double getHeight();

    /**
     * Gets the base area of the 3D shape.
     *
     * @return      The base area of the shape
     */
    public abstract double getBaseArea();

    /**
     * Calculates and returns the volume of the 3D shape.
     *
     * @return      The volume of the shape
     */
    public abstract double getVolume();

    /**
     * Compares this 3D shape to another 3D shape based on their height and base area.
     *
     * @param other        The other 3D shape to compare to
     *
     * @return
     *      A negative integer, zero, or a positive integer
     *      as this shape is less than, equal to,
     *      or greater than the specified shape
     *
     * @throws NullPointerException
     *      If the specified shape is null
     */
    @Override
    public int compareTo(ThreeDShape other) {
        // Return the volume comparison if not equal to zero
        var volumeComparison = Double.compare(this.getVolume(), other.getVolume());
        if (volumeComparison != 0) return volumeComparison;

        // Return the base area comparison if not equal to zero
        var baseAreaComparison = Double.compare(this.getBaseArea(), other.getBaseArea());
        if (baseAreaComparison != 0) return baseAreaComparison;

        // Return the height comparison by default
        return Double.compare(this.getHeight(), other.getHeight());
    }
}
