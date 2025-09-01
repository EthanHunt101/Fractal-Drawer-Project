/**
 * Represents an equilateral triangle as a subclass of Polygon.
 * The triangle is defined by a center point and a side length, with vertices calculated
 * based on these parameters. Provides methods to set and retrieve the center and side length.
 * 
 * @author Ethan Hunt
 */
public class EquilateralTriangle extends Polygon  implements Snowflakeable, TriangleShape{

  /** The center point of the equilateral triangle */
  private Point center;
  
  /** The length of each side of the equilateral triangle */
  private double sideLength;

  /**
   * Constructs an EquilateralTriangle with the specified center and side length.
   * Initializes the vertices based on the provided center and side length.
   *
   * @param center The center point of the equilateral triangle
   * @param sideLength The length of each side of the equilateral triangle
   */
  public EquilateralTriangle(Point center, double sideLength) {
    super(new Point[] {
        // First vertex (top vertex if oriented upwards)
        new Point(center.getX(), center.getY() + (sideLength / Math.sqrt(3))),
        
        // Second vertex (120 degrees clockwise from the first)
        new Point(center.getX() - (sideLength / 2), center.getY() - (sideLength / (2 * Math.sqrt(3)))),
        
        // Third vertex (240 degrees clockwise from the first, or -120 degrees)
        new Point(center.getX() + (sideLength / 2), center.getY() - (sideLength / (2 * Math.sqrt(3))))
    });
    
    this.center = center;
    this.sideLength = sideLength;
  }

  /**
   * Returns the center point of the equilateral triangle.
   *
   * @return The center point of the equilateral triangle
   */
  @Override
  public Point getCenter() {
    return this.center;
  }

  /**
   * Sets a new center point for the equilateral triangle and recalculates its vertices accordingly.
   *
   * @param center The new center point of the equilateral triangle
   */
  @Override
  public void setCenter(Point center) {
    super.setPoints(new Point[] {
        new Point(center.getX(), center.getY() + (this.getSideLength() / Math.sqrt(3))),
        new Point(center.getX() - (this.getSideLength() / 2), center.getY() - (this.getSideLength() / (2 * Math.sqrt(3)))),
        new Point(center.getX() + (this.getSideLength() / 2), center.getY() - (this.getSideLength() / (2 * Math.sqrt(3))))
    });
    this.center = center;
  }

  /**
   * Returns the length of each side of the equilateral triangle.
   *
   * @return The side length of the equilateral triangle
   */
  public double getSideLength() {
    return sideLength;
  }

  /**
   * Sets a new side length for the equilateral triangle and recalculates its vertices accordingly.
   *
   * @param sideLength The new length of each side of the equilateral triangle
   */
  public void setSideLength(double sideLength) {
    super.setPoints(new Point[] {
        new Point(this.getCenter().getX(), this.getCenter().getY() + (sideLength / Math.sqrt(3))),
        new Point(this.getCenter().getX() - (sideLength / 2), this.getCenter().getY() - (sideLength / (2 * Math.sqrt(3)))),
        new Point(this.getCenter().getX() + (sideLength / 2), this.getCenter().getY() - (sideLength / (2 * Math.sqrt(3))))
    });
    this.sideLength = sideLength;
  }
}
