/**
 * Represents a square as a subclass of Rectangle, defined by a center point and side length.
 * Since a square has equal width and height, setting either dimension will update both.
 * Provides methods to set and retrieve the side length of the square.
 * 
 * Extends the Rectangle class, leveraging its functionality but enforcing equal width and height.
 * 
 * @author Ethan Hunt
 */
public class Square extends Rectangle implements Snowflakeable, RectangleShape {

  /**
   * Constructs a Square with a specified center and side length.
   * Sets both the width and height of the square to the specified length.
   *
   * @param center The center point of the square
   * @param length The length of each side of the square
   */
  public Square(Point center, double length) {
    super(center, length, length);
  }

  /**
   * Sets a new height for the square. Since the width and height are equal,
   * this method also updates the width to match the new height.
   *
   * @param height The new length for both the height and width of the square
   */
  @Override
  public void setHeight(double height) {
    super.setHeight(height);
    super.setWidth(height);
  }

  /**
   * Sets a new width for the square. Since the width and height are equal,
   * this method also updates the height to match the new width.
   *
   * @param width The new length for both the width and height of the square
   */
  @Override
  public void setWidth(double width) {
    this.setHeight(width);
  }
}
