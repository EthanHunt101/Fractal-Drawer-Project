/**
 * Represents a rectangle as a subclass of Polygon, defined by a center point, width, and height.
 * The rectangle is oriented with its sides parallel to the x and y axes.
 * Provides methods to get and set the center, width, and height of the rectangle.
 * 
 * @author Ethan Hunt
 */
public class Rectangle extends Polygon implements RectangleShape{

  /** The center point of the rectangle */
  private Point center;
  
  /** The width of the rectangle */
  private double width = 0.0;
  
  /** The height of the rectangle */
  private double height = 0.0;
  
  /** The top-left corner point of the rectangle */
  private Point topLeftPoint;
  
  /** The top-right corner point of the rectangle */
  private Point topRightPoint;
  
  /** The bottom-left corner point of the rectangle */
  private Point bottomLeftPoint;
  
  /** The bottom-right corner point of the rectangle */
  private Point bottomRightPoint;
  
  /**
   * Constructs a Rectangle with a specified center, width, and height.
   * Initializes the vertices of the rectangle based on the provided dimensions.
   *
   * @param center The center point of the rectangle
   * @param width The width of the rectangle
   * @param height The height of the rectangle
   */
  public Rectangle(Point center, double width, double height) {
    super(new Point[]{
      new Point(center.getX() - width / 2, center.getY() + height / 2),
      new Point(center.getX() + width / 2, center.getY() + height / 2),
      new Point(center.getX() + width / 2, center.getY() - height / 2),
      new Point(center.getX() - width / 2, center.getY() - height / 2)
    });
    this.center = center;
    this.width = width;
    this.height = height;
  }
  
  /**
   * Returns the center point of the rectangle.
   *
   * @return The center point of the rectangle
   */
  @Override
  public Point getCenter() {
    return this.center;
  }
  
  /**
   * Returns the width of the rectangle.
   *
   * @return The width of the rectangle
   */
  public double getWidth() {
    return this.width;
  }
  
  /**
   * Returns the height of the rectangle.
   *
   * @return The height of the rectangle
   */
  public double getHeight() {
    return this.height;
  }
  
  /**
   * Sets a new center point for the rectangle and recalculates its vertices accordingly.
   *
   * @param center The new center point of the rectangle
   */
  @Override
  public void setCenter(Point center) {
    super.setPoints(new Point[]{
      new Point(center.getX() - this.getWidth() / 2, center.getY() + this.getHeight() / 2),
      new Point(center.getX() + this.getWidth() / 2, center.getY() + this.getHeight() / 2),
      new Point(center.getX() + this.getWidth() / 2, center.getY() - this.getHeight() / 2),
      new Point(center.getX() - this.getWidth() / 2, center.getY() - this.getHeight() / 2)
    });
    this.center = center;
  }
  
  /**
   * Sets a new width for the rectangle and recalculates its vertices accordingly.
   *
   * @param width The new width of the rectangle
   */
  public void setWidth(double width) {
    this.width = width;
    super.setPoints(new Point[]{
      new Point(center.getX() - this.getWidth() / 2, center.getY() + this.getHeight() / 2),
      new Point(center.getX() + this.getWidth() / 2, center.getY() + this.getHeight() / 2),
      new Point(center.getX() + this.getWidth() / 2, center.getY() - this.getHeight() / 2),
      new Point(center.getX() - this.getWidth() / 2, center.getY() - this.getHeight() / 2)
    });
  }
  
  /**
   * Sets a new height for the rectangle and recalculates its vertices accordingly.
   *
   * @param height The new height of the rectangle
   */
  public void setHeight(double height) {
    this.height = height;
    super.setPoints(new Point[]{
      new Point(center.getX() - this.getWidth() / 2, center.getY() + this.getHeight() / 2),
      new Point(center.getX() + this.getWidth() / 2, center.getY() + this.getHeight() / 2),
      new Point(center.getX() + this.getWidth() / 2, center.getY() - this.getHeight() / 2),
      new Point(center.getX() - this.getWidth() / 2, center.getY() - this.getHeight() / 2)
    });
  }
}