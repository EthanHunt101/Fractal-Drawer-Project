/**
 * Represents an abstract polygon defined by an array of points (vertices).
 * Provides methods to retrieve, set, and manipulate the points of the polygon,
 * including rotation around a center point and generating line segments between vertices.
 * Subclasses must implement methods for retrieving and setting the center point.
 * 
 * @author Ethan Hunt
 */
public abstract class Polygon {

  /** The array of points (vertices) that define the polygon */
  private Point[] points;
  
  /**
   * Constructs a Polygon with the specified points.
   *
   * @param points An array of points representing the vertices of the polygon
   */
  public Polygon(Point[] points) {
    this.points = points;
  }
  
  /**
   * Rotates the polygon around its center by a specified angle.
   * Each point in the polygon is rotated about the center by the given angle.
   *
   * @param angle The angle in radians by which to rotate the polygon
   */
  public void rotate(double angle) {
    Point center = this.getCenter();
    Point[] points = this.getPoints();
    for (Point p : points) {
      p.rotateAbout(center, angle);
    }
  }
  
  /**
   * Returns the array of points representing the vertices of the polygon.
   *
   * @return An array of points representing the vertices of the polygon
   */
  public Point[] getPoints() {
    return this.points;
  }
  
  /**
   * Sets the points of the polygon to a new array of points.
   *
   * @param points The new array of points representing the vertices of the polygon
   */
  public void setPoints(Point[] points) {
    this.points = points;
  }
  
  /**
   * Returns an array of Line objects representing the edges of the polygon.
   * Each line connects a pair of consecutive points, with the last point connecting back to the first.
   *
   * @return An array of lines representing the edges of the polygon
   */
  public Line[] getLines() {
    int numberOfPoints = this.points.length;
    Line[] lines = new Line[numberOfPoints];
    Point startOfLine;
    Point endOfLine;
    
    for (int idx = 0; idx < numberOfPoints; idx++) {
      startOfLine = this.points[idx];
      if (idx < numberOfPoints - 1) {
        endOfLine = this.points[idx + 1];
      } else {
        endOfLine = this.points[0];
      }
      
      lines[idx] = new Line(startOfLine, endOfLine);
    }
    
    return lines;
  }
  
  /**
   * Returns the center point of the polygon. This method must be implemented by subclasses.
   *
   * @return The center point of the polygon
   */
  public abstract Point getCenter();
  
  /**
   * Sets the center of the polygon to a new point. This method must be implemented by subclasses.
   *
   * @param center The new center point of the polygon
   */
  public abstract void setCenter(Point center);
}
