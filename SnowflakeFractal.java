import java.util.ArrayList;

/**
 * Represents a fractal structure based on a snowflake pattern.
 * This fractal is created by recursively subdividing each line 
 * of the base shape into smaller segments with a snowflake-like pattern.
 * 
 * @param <T> A type that extends Polygon and implements Snowflakeable.
 * @author Ethan Hunt 
 */
public class SnowflakeFractal<T extends Polygon & Snowflakeable> extends Fractal<T> {

    /**
     * Constructs a SnowflakeFractal instance with a base polygon and number of levels.
     * 
     * @param baseShape The base polygon shape for the snowflake fractal.
     * @param numLevels The number of recursive levels for the fractal.
     */
    public SnowflakeFractal(T baseShape, int numLevels) {
        super(baseShape, numLevels);
    }

    /**
     * Returns an array of lines that form the fractal.
     * 
     * @return An array of lines representing the fractal structure.
     */
    @Override
    public Line[] getLines() {
        return createFractalLines(getBaseShape().getLines(), getNumLevels());
    }

    /**
     * Recursively generates the lines for the fractal based on the input lines and level.
     * Each line is subdivided into four smaller segments forming a snowflake-like shape.
     * 
     * @param shapeLines The lines of the base shape to generate fractal lines from.
     * @param levelsLeft The number of recursive levels remaining.
     * @return An array of lines representing the fractal at the current level.
     */
    private Line[] createFractalLines(Line[] shapeLines, int levelsLeft) {
        if (levelsLeft == 0) {
            return shapeLines;
        }

        ArrayList<Line> levelLines = new ArrayList<Line>();

        // Iterate over each line to subdivide it into smaller segments
        for (Line line : shapeLines) { 
            Point firstP = line.getFirstPoint();
            Point fifthP = line.getSecondPoint();

            // Calculate the intermediate points for the snowflake pattern
            Point secondP = new Point(
                firstP.getX() + (fifthP.getX() - firstP.getX()) / 3, 
                firstP.getY() + (fifthP.getY() - firstP.getY()) / 3
            );

            Point fourthP = new Point(
                firstP.getX() + (fifthP.getX() - firstP.getX()) * 2 / 3, 
                firstP.getY() + (fifthP.getY() - firstP.getY()) * 2 / 3
            );

            Point thirdP = new Point(fourthP.getX(), fourthP.getY());
            thirdP.rotateAbout(secondP, -(Math.PI / 3));

            // Add the four segments of the transformed line
            levelLines.add(new Line(firstP, secondP));
            levelLines.add(new Line(secondP, thirdP));
            levelLines.add(new Line(thirdP, fourthP));
            levelLines.add(new Line(fourthP, fifthP));
        }

        // Recursively generate lines for the next level
        return createFractalLines(levelLines.toArray(new Line[levelLines.size()]), levelsLeft - 1);
    }
}
