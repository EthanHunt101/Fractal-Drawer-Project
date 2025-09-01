import java.util.ArrayList;

/**
 * Represents a fractal structure based on triangles.
 * This fractal is recursively created by subdividing a base triangle into 
 * smaller triangles.
 * 
 * @param <T> A type that extends Polygon and implements TriangleShape.
 * @author Ethan Hunt 
 */
public class TriangleFractal<T extends Polygon & TriangleShape> extends Fractal<T> {

    /**
     * Constructs a TriangleFractal instance with a base triangle and number of levels.
     * 
     * @param baseShape The base triangle shape for the fractal.
     * @param numLevels The number of recursive levels for the fractal.
     */
    public TriangleFractal(T baseShape, int numLevels) {
        super(baseShape, numLevels);
    }
    
    /**
     * Returns an array of lines that form the fractal.
     * Currently only supports the Triangle shape.
     * 
     * @return An array of lines representing the fractal structure.
     */
    @Override
    public Line[] getLines() {
        return createFractalLinesForTriangle(this.getBaseShape(), getNumLevels());
    }

    /**
     * Recursively generates the lines for the fractal based on the input triangle and level.
     * Each triangle is subdivided into three smaller triangles, and their lines are generated.
     * 
     * @param t The base polygon to generate lines from.
     * @param levelsLeft The number of recursive levels remaining.
     * @return An array of lines representing the fractal at the current level.
     */
    private Line[] createFractalLinesForTriangle(Polygon t, int levelsLeft) {
        if (levelsLeft == 0) {
            return t.getLines();
        }

        // Get the vertices of the triangle
        Point[] endPoints = this.getBaseShape().getPoints();
        Point endPoint1 = endPoints[0];
        Point endPoint2 = endPoints[1];
        Point endPoint3 = endPoints[2];

        Point center = t.getCenter();

        // Create three smaller triangles using the center and two vertices
        Triangle firstT = new Triangle(center, endPoint1, endPoint2);
        Triangle secondT = new Triangle(center, endPoint2, endPoint3);
        Triangle thirdT = new Triangle(center, endPoint3, endPoint1);

        ArrayList<Line> levelLines = new ArrayList<Line>();

        // Recursively generate lines for each smaller triangle
        for (Line line : createFractalLinesForTriangle(firstT, levelsLeft - 1)) {
            levelLines.add(line);
        }
        for (Line line : createFractalLinesForTriangle(secondT, levelsLeft - 1)) {
            levelLines.add(line);
        }
        for (Line line : createFractalLinesForTriangle(thirdT, levelsLeft - 1)) {
            levelLines.add(line);
        }

        return levelLines.toArray(new Line[levelLines.size()]);
    }
}
