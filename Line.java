/**
 * Represents a line segment defined by two endpoints, stored as Point objects.
 * Provides methods to retrieve and set the endpoints, as well as a method to
 * return an array containing this line segment.
 * 
 * @author Ethan Hunt
 */
public class Line {
  
  /** The first endpoint of the line */
  private Point first;
  
  /** The second endpoint of the line */
  private Point second;
  
  /**
   * Constructs a Line with specified endpoints.
   *
   * @param first The first endpoint of the line
   * @param second The second endpoint of the line
   */
  public Line(Point first, Point second) {
    this.first = first;
    this.second = second;
  }
  
  /**
   * Constructs a Line with specified coordinates for the two endpoints.
   *
   * @param firstX The x-coordinate of the first endpoint
   * @param firstY The y-coordinate of the first endpoint
   * @param secondX The x-coordinate of the second endpoint
   * @param secondY The y-coordinate of the second endpoint
   */
  public Line(double firstX, double firstY, double secondX, double secondY) {
    this.first = new Point(firstX, firstY);
    this.second = new Point(secondX, secondY);
  }
  
  /**
   * Returns the first endpoint of the line.
   *
   * @return The first endpoint as a Point
   */
  public Point getFirstPoint() {
    return first;
  }
  
  /**
   * Returns the second endpoint of the line.
   *
   * @return The second endpoint as a Point
   */
  public Point getSecondPoint() {
    return second;
  }
  
  /**
   * Sets the first endpoint of the line.
   *
   * @param first The new first endpoint of the line
   */
  public void setFirstPoint(Point first) {
    this.first = first;
  }
  
  /**
   * Sets the second endpoint of the line.
   *
   * @param second The new second endpoint of the line
   */
  public void setSecondPoint(Point second) {
    this.second = second;
  }
  
  /**
   * Returns an array containing this line segment.
   * 
   * @return An array of Lines containing this line
   */
  public Line[] getLines() {
    Line[] lines = new Line[] {this};
    return lines;
  }
}