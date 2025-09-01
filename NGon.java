/**
 * Represents a regular polygon (NGon) with a specified number of sides, a center point,
 * and a side length. Provides methods to set and retrieve the center, side length,
 * and number of sides, as well as to calculate the polygon's vertices.
 * Extends the Polygon class to inherit functionality for point and line management.
 * 
 * @author Ethan Hunt
 */
public class NGon extends Polygon  implements Snowflakeable{
  
  /** The center point of the NGon */
  private Point center;
  
  /** The length of each side of the NGon */
  private double sideLength;
  
  /** The number of sides of the NGon, initialized to 0 and set via setNumSides() */
  private int numSides = 0;
  
  /**
   * Constructs an NGon with a specified center point and side length.
   * The number of sides must be set separately using setNumSides().
   *
   * @param center The center point of the NGon
   * @param sideLength The length of each side of the NGon
   */
  public NGon(Point center, double sideLength) {
    super(new Point[0]);  // Initialize an empty array for points; to be calculated later
    this.center = center;
    this.sideLength = sideLength;
  }
  
  /**
   * Returns the center point of the NGon.
   *
   * @return The center point of the NGon
   */
  @Override
  public Point getCenter() {
    return this.center;
  }
  
  /**
   * Sets a new center point for the NGon and recalculates its vertices accordingly.
   *
   * @param center The new center point of the NGon
   */
  @Override
  public void setCenter(Point center) {
    this.center = center;
    
    Point[] points = new Point[this.getNumSides()];
    for (int i = 0; i < this.getNumSides(); i++) {
        points[i] = new Point(center.getX() + getSideLength() * Math.cos(i * 2 * Math.PI / this.getNumSides()), center.getY() + getSideLength() * Math.sin(i * 2 * Math.PI / this.getNumSides()));
    }
    setPoints(points); 
  }
  
  /**
   * Returns the length of each side of the NGon.
   *
   * @return The side length of the NGon
   */
  public double getSideLength() {
    return this.sideLength;
  }
  
  /**
   * Sets a new side length for the NGon and recalculates its vertices accordingly.
   *
   * @param sideLength The new length for each side of the NGon
   */
  public void setSideLength(double sideLength) {
    this.sideLength = sideLength;
    
    Point[] points = new Point[this.getNumSides()];
    for (int i = 0; i < this.getNumSides(); i++) {
        points[i] = new Point(center.getX() + getSideLength() * Math.cos(i * 2 * Math.PI / this.getNumSides()), center.getY() + getSideLength() * Math.sin(i * 2 * Math.PI / this.getNumSides()));
    }
    setPoints(points); 
  }
  
  /**
   * Returns the number of sides of the NGon.
   *
   * @return The number of sides of the NGon
   */
  public int getNumSides() {
    return this.numSides;
  }
  
  /**
   * Sets the number of sides for the NGon and recalculates its vertices accordingly.
   *
   * @param numSides The number of sides of the NGon
   */
  public void setNumSides(int numSides) {
    this.numSides = numSides;
    
    Point[] points = new Point[this.getNumSides()];
    for (int i = 0; i < this.getNumSides(); i++) {
        points[i] = new Point(center.getX() + getSideLength() * Math.cos(i * 2 * Math.PI / this.getNumSides()), center.getY() + getSideLength() * Math.sin(i * 2 * Math.PI / this.getNumSides()));
    }
    setPoints(points); 
  }
}
