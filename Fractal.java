import java.util.ArrayList;

/**
 * Represents an abstract fractal structure based on a polygonal shape.
 * This class provides common functionality for fractals, such as retrieving
 * the base shape, managing the fractal's levels, and applying transformations.
 * 
 * @param <T> A type that extends the Polygon class, representing the base shape of the fractal.
 * @author Ethan Hunt
 */
public abstract class Fractal<T extends Polygon> {

    /** The base polygon shape used to generate the fractal. */
    private T baseShape;

    /** The number of levels in the fractal structure. */
    private int numLevels;

    /**
     * Constructs a Fractal instance with the given base shape and number of levels.
     * 
     * @param baseShape The polygon that serves as the base shape for the fractal.
     * @param numLevels The number of recursive levels in the fractal structure.
     */
    public Fractal(T baseShape, int numLevels) {
        this.baseShape = baseShape;
        this.numLevels = numLevels;
    }

    /**
     * Returns the base shape of the fractal.
     * 
     * @return The base polygon of the fractal.
     */
    public T getBaseShape() {
        return this.baseShape;
    }

    /**
     * Returns the number of levels in the fractal.
     * 
     * @return The number of recursive levels.
     */
    public int getNumLevels() {
        return this.numLevels;
    }

    /**
     * Sets the number of levels in the fractal.
     * 
     * @param numLevels The new number of recursive levels.
     */
    public void setNumLevels(int numLevels) {
        this.numLevels = numLevels;
    }

    /**
     * Returns the center of the fractal.
     * 
     * @return The center point of the base polygon.
     */
    public Point getCenter() {
        return baseShape.getCenter();
    }

    /**
     * Sets a new center for the fractal and adjusts all points accordingly.
     * 
     * @param newCenter The new center point for the fractal.
     */
    public void setCenter(Point newCenter) {
        Point oldCenter = baseShape.getCenter();

        // Calculate the difference between the old and new center
        double xDiff = newCenter.getX() - oldCenter.getX();
        double yDiff = newCenter.getY() - oldCenter.getY();

        // Move all points by the calculated difference
        Point[] points = this.getPoints();
        for (Point p : points) {
            p.setX(p.getX() + xDiff);
            p.setY(p.getY() + yDiff);
        }
        this.baseShape.setCenter(newCenter);
    }

    /**
     * Rotates the entire fractal about its center by a specified angle.
     * 
     * @param angle The angle in radians by which to rotate the fractal.
     */
    public void rotate(double angle) {
        Point center = this.getCenter();
        Point[] points = this.getPoints();

        // Rotate each point around the fractal's center
        for (Point p : points) {
            p.rotateAbout(center, angle);
        }
    }

    /**
     * Returns an array of unique points that make up the fractal.
     * 
     * @return An array of points that define the fractal structure.
     */
    public Point[] getPoints() {
        Line[] lines = this.getLines();
        ArrayList<Point> points = new ArrayList<Point>();

        // Add unique points from the lines to the list
        for (Line currentLine : lines) {
            Point currentPoint = currentLine.getSecondPoint();
            if (!points.contains(currentPoint)) {
                points.add(currentPoint);
            }
        }

        return points.toArray(new Point[points.size()]);
    }

    /**
     * Abstract method to return the lines that form the fractal.
     * Subclasses must implement this method to provide specific fractal structures.
     * 
     * @return An array of lines representing the fractal structure.
     */
    public abstract Line[] getLines();   
}
