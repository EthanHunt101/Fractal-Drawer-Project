/**
 * Represents a triangle as a subclass of Polygon, defined by three vertices.
 * Provides methods to get and set the center of the triangle, which is calculated
 * as the centroid (average of the vertices' coordinates). Changing the center
 * moves the triangle while maintaining its shape and size.
 * 
 * Each vertex is represented as a Point object.
 * 
 * @author Ethan Hunt
 */
public class Triangle extends Polygon implements TriangleShape{

  /** The calculated center (centroid) of the triangle */
  private Point center = new Point(0,0);
  
  /** The first vertex of the triangle */
  private Point p1;
  
  /** The second vertex of the triangle */
  private Point p2;
  
  /** The third vertex of the triangle */
  private Point p3;

  /**
   * Constructs a Triangle with specified vertices.
   *
   * @param p1 The first vertex of the triangle
   * @param p2 The second vertex of the triangle
   * @param p3 The third vertex of the triangle
   */
  public Triangle(Point p1, Point p2, Point p3) {
    super(new Point[] {p1, p2, p3});
    this.p1 = p1;
    this.p2 = p2;
    this.p3 = p3;
  }

  /**
   * Calculates and returns the centroid of the triangle, which serves as its center.
   * The centroid is calculated as the average of the x and y coordinates of the vertices.
   *
   * @return The center (centroid) of the triangle
   */
  @Override
  public Point getCenter() {
    this.center.setX((p1.getX() + p2.getX() + p3.getX()) / 3);
    this.center.setY((p1.getY() + p2.getY() + p3.getY()) / 3);
    return this.center;
  }

  /**
   * Sets a new center (centroid) for the triangle and moves all vertices accordingly.
   * The position of each vertex is adjusted by the difference between the current
   * and new center coordinates, effectively translating the triangle.
   *
   * @param newCenter The new center point for the triangle
   */
  @Override
  public void setCenter(Point newCenter) {
    double xDiff = newCenter.getX() - this.getCenter().getX();
    double yDiff = newCenter.getY() - this.getCenter().getY();
    
    // Translate each vertex by the difference between the old and new center
    this.p1 = new Point(this.p1.getX() + xDiff, this.p1.getY() + yDiff);
    this.p2 = new Point(this.p2.getX() + xDiff, this.p2.getY() + yDiff);
    this.p3 = new Point(this.p3.getX() + xDiff, this.p3.getY() + yDiff);

    // Update the vertices in the Polygon superclass
    super.setPoints(new Point[] {p1, p2, p3});
    this.center = newCenter;
  }
}
