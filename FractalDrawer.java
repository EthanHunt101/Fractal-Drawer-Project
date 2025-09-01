import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.geometry.Orientation;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;


/**
 * Represents an application for drawing fractals, including Snowflake, Triangle, and Rectangle fractals.
 * The application uses JavaFX for user interaction and drawing on a canvas.
 * 
 * @author Ethan Hunt
 */
public class FractalDrawer extends Application {
  
  // Canvas for drawing the fractals
  private Canvas canvas;
  
  // Color picker for selecting the drawing color
  private ColorPicker colorPicker;
  
  // Slider for adjusting the stroke width
  private Slider slider;
  
  // Buttons for selecting fractal types and erasing the canvas
  private Button buttonSnow;
  private Button buttonTri;
  private Button buttonRect;
  private Button buttonErase;
  
  // Layout containers
  private HBox hboxTop;
  private HBox hboxBottom;
  private VBox vbox;
  
  // Text fields for input parameters
  private TextField fieldNumSides;
  private TextField fieldWidth;
  private TextField fieldHeight;
  private TextField fieldLength;
  
  private TextField fieldFirstX;
  private TextField fieldFirstY;
  private TextField fieldSecondX;
  private TextField fieldSecondY;
  private TextField fieldThirdX;
  private TextField fieldThirdY;
  
  private TextField fieldNumLevels;
  private TextField fieldRotation;
  
  private TextField fieldIterations;
  
  // Buttons for drawing fractals
  private Button buttonDrawSnow;
  private Button buttonDrawTri;
  private Button buttonDrawRect;
  
      /**
     * The main entry point for the JavaFX application.
     * Initializes the UI components and sets up event handling.
     * 
     * @param primaryStage The primary stage for this application.
     */
  public void start(Stage primaryStage) {
    // Initialize the canvas for drawing
    canvas = new Canvas(1500, 500);
    
    // Create a border pane and add the canvas
    BorderPane pane = new BorderPane();
    BorderPane.setMargin(canvas, new Insets(10));
    pane.setBottom(canvas);
    
    // Initialize the vertical box layout
    vbox = new VBox();
    vbox.setAlignment(Pos.CENTER);
    
    hboxTop = new HBox();
    hboxTop.setAlignment(Pos.CENTER);
    
    // Initialize the top and bottom horizontal box layouts
    hboxBottom = new HBox();
    hboxBottom.setAlignment(Pos.CENTER);
    hboxTop.setSpacing(20);
    hboxTop.setPrefHeight(40);
    
    hboxBottom.setSpacing(15);
    hboxBottom.setPrefHeight(50);
    BorderPane.setMargin(hboxBottom, new Insets(10));
    
    BorderPane.setMargin(hboxTop, new Insets(10, 10, 0, 10));
    
    // Initialize buttons
    buttonSnow = new Button("Snowflake Fractal");
    buttonTri = new Button("Triangle Fractal");
    buttonRect = new Button("Rectangle Fractal");
    buttonErase = new Button("Erase");
    
    // Add layouts to the vertical box
    vbox.getChildren().add(hboxTop);
    vbox.getChildren().add(hboxBottom);
    vbox.setSpacing(10);
    
    // Add the vertical box to the top of the border pane
    pane.setTop(vbox);
    
    // Add buttons to the top layout
    hboxTop.getChildren().add(buttonSnow);
    hboxTop.getChildren().add(buttonTri);
    hboxTop.getChildren().add(buttonRect);
    hboxTop.getChildren().add(buttonErase);
    
    // Initialize the color picker and add it to the center of the pane
    colorPicker = new ColorPicker(Color.BLACK);
    pane.setCenter(colorPicker);
    
    // Set up event handlers for the buttons
    buttonSnow.setOnAction(new RespondToButtonClick());
    buttonTri.setOnAction(new RespondToButtonClick());
    buttonRect.setOnAction(new RespondToButtonClick());
    buttonErase.setOnAction(new RespondToButtonClick());
    
    // Initialize text fields with prompt text for user input
    fieldIterations = new TextField();
    fieldIterations.setPromptText("Number of Iterations");
    fieldIterations.setFocusTraversable(false);
    
    fieldNumSides = new TextField();
    fieldNumSides.setPromptText("Number of Sides:");
    fieldNumSides.setFocusTraversable(false);
    
    fieldWidth = new TextField();
    fieldWidth.setPromptText("Base Shape's Width:");
    fieldWidth.setFocusTraversable(false);
    
    fieldHeight = new TextField();
    fieldHeight.setPromptText("Base Shape's Height:");
    fieldHeight.setFocusTraversable(false);
    
    fieldLength = new TextField();
    fieldLength.setPromptText("Base Shape's Side Length:");
    fieldLength.setFocusTraversable(false);
    
    fieldFirstX = new TextField();
    fieldFirstX.setPromptText("First Coord. X Value");
    fieldFirstX.setFocusTraversable(false);
    
    fieldFirstY = new TextField();
    fieldFirstY.setPromptText("First Coord. Y Value");
    fieldFirstY.setFocusTraversable(false);
    
    fieldSecondX = new TextField();
    fieldSecondX.setPromptText("Second Coord. X Value");
    fieldSecondX.setFocusTraversable(false);
    
    fieldSecondY = new TextField();
    fieldSecondY.setPromptText("Second Coord. Y Value");
    fieldSecondY.setFocusTraversable(false);
    
    fieldThirdX = new TextField();
    fieldThirdX.setPromptText("Third Coord. X Value");
    fieldThirdX.setFocusTraversable(false);
    
    fieldThirdY = new TextField();
    fieldThirdY.setPromptText("Third Coord. Y Value");
    fieldThirdY.setFocusTraversable(false);
    
    fieldNumLevels = new TextField();
    fieldNumLevels.setPromptText("Number of Levels");
    fieldNumLevels.setFocusTraversable(false);
    
    fieldRotation = new TextField();
    fieldRotation.setPromptText("Rotation of the Fractal");
    fieldRotation.setFocusTraversable(false);
    
    // Initialize buttons for drawing fractals
    buttonDrawSnow = new Button("Draw");
    buttonDrawTri = new Button("Draw");
    buttonDrawRect = new Button("Draw");
    
    // Set event handlers for drawing buttons
    buttonDrawSnow.setOnAction(new RespondToButtonClick());
    buttonDrawTri.setOnAction(new RespondToButtonClick());
    buttonDrawRect.setOnAction(new RespondToButtonClick());
    
    // Initialize the slider for stroke width adjustment
    slider = new Slider(0,10,2);
    slider.setOrientation(Orientation.VERTICAL);
    slider.setPrefHeight(250);
    slider.setShowTickMarks(true);
    slider.setShowTickLabels(true);
    slider.setMajorTickUnit(1);
    slider.setBlockIncrement(.5);
    pane.setRight(slider);
    
    // Create and display the scene
    Scene scene = new Scene(pane);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  
  /**
   * The main method to launch the application.
   * 
   * @param args Command-line arguments.
   */
  public static void main(String[] args) {
    Application.launch(args);
  }
  
  /**
   * Handles button click events and updates the UI or performs fractal drawing.
   */
  private class RespondToButtonClick implements EventHandler<ActionEvent> {
    
    public void handle(ActionEvent event) {
      Button b = (Button)event.getSource();
      GraphicsContext graph = canvas.getGraphicsContext2D();
      
      // Handle Snowflake fractal button click
      if (b == buttonSnow) {
        // Clear previous input fields
        fieldNumSides.clear();
        fieldLength.clear();
        fieldNumLevels.clear();
        fieldRotation.clear();
        hboxBottom.getChildren().clear();
        
        // Add correct input fields
        hboxBottom.getChildren().addAll(fieldIterations, fieldNumSides, fieldLength, fieldNumLevels, fieldRotation, buttonDrawSnow);
        
        hboxBottom.setSpacing(20);
        
      } 
      
      // Handle Triangle fractal button click
      else if (b == buttonTri) {
        // Clear previous input fields
        fieldFirstX.clear();
        fieldFirstY.clear();
        fieldSecondX.clear();
        fieldSecondY.clear();
        fieldThirdX.clear();
        fieldThirdY.clear();
        fieldNumLevels.clear();
        fieldRotation.clear();
        hboxBottom.getChildren().clear();
        
        // Add correct input fields
        hboxBottom.getChildren().addAll(fieldFirstX, fieldFirstY, fieldSecondX, fieldSecondY, fieldThirdX, fieldThirdY, fieldNumLevels, fieldRotation, buttonDrawTri);
        
        hboxBottom.setSpacing(20); 
      }
      
      else if (b == buttonRect) {
        // Clear previous input fields
        fieldHeight.clear();
        fieldWidth.clear();
        fieldNumLevels.clear();
        fieldRotation.clear();
        hboxBottom.getChildren().clear();
        
        // Add correct input fields
        hboxBottom.getChildren().addAll(fieldHeight, fieldWidth, fieldNumLevels, fieldRotation, buttonDrawRect);
        
        hboxBottom.setSpacing(20);
      }
      
      // Handles the drawing of a Snowflake Fractal
      else if (b == buttonDrawSnow) {
        // Reset the transformation and translate the canvas center
        graph.setTransform(1, 0, 0, 1, 0, 0);
        graph.translate(canvas.getWidth() / 2, canvas.getHeight() / 2);
        
        // Parse user input for fractal parameters
        int numSides = Integer.parseInt(fieldNumSides.getText());
        double length = Double.parseDouble(fieldLength.getText());
        int numLevels = Integer.parseInt(fieldNumLevels.getText());
        double rotation = Double.parseDouble(fieldRotation.getText());
        
        int iterations = Integer.parseInt(fieldIterations.getText());
        
        // Variable to hold the base shape
        Polygon baseShape;
        
        // Check if the shape is an equilateral triangle (3 sides)
        if (numSides == 3) {
          // Create an equilateral triangle as the base shape
          baseShape = new EquilateralTriangle(new Point(0,0), length);
          SnowflakeFractal<EquilateralTriangle> fractal = new SnowflakeFractal<EquilateralTriangle>((EquilateralTriangle) baseShape, numLevels);
          
          // Apply rotation and set drawing properties
          fractal.rotate(rotation);
          graph.setStroke(colorPicker.getValue());
          graph.setLineWidth(slider.getValue());
          
          // Draw the fractal by iterating through its lines
          for (Line line : fractal.getLines()) {
            graph.strokeLine(
                             (int) (line.getFirstPoint().getX()), 
                             -1 * (int) (line.getFirstPoint().getY()), 
                             (int) (line.getSecondPoint().getX()), 
                             -1 * (int) (line.getSecondPoint().getY())
                            );
          }
        }
        
        // Check if the shape is a square (4 sides)
        else if (numSides == 4) {
          baseShape = new Square(new Point(0,0), length);
          SnowflakeFractal<Square> fractal = new SnowflakeFractal<Square>((Square) baseShape, numLevels);
          
          // Apply rotation and set drawing properties
          fractal.rotate(rotation);
          graph.setStroke(colorPicker.getValue());
          graph.setLineWidth(slider.getValue());
          
          // Draw the fractal by iterating through its lines
          for (Line line : fractal.getLines()) {
            graph.strokeLine(
                             (int) (line.getFirstPoint().getX()), 
                             -1 * (int) (line.getFirstPoint().getY()), 
                             (int) (line.getSecondPoint().getX()), 
                             -1 * (int) (line.getSecondPoint().getY())
                            );
          }
        }
        
        // Handle polygons if its a NGon (more than 4 sides)
        else {
          // Create a generic NGon as the base shape
          baseShape = new NGon(new Point(0,0), length);
          ((NGon) baseShape).setNumSides(numSides);
          SnowflakeFractal<NGon> fractal = new SnowflakeFractal<NGon>((NGon)baseShape, numLevels);
          
          // Apply rotation and set drawing properties
          fractal.rotate(rotation);
          graph.setStroke(colorPicker.getValue());
          graph.setLineWidth(slider.getValue());
          
          // Draw the fractal by iterating through its lines
          for (Line line : fractal.getLines()) {
            graph.strokeLine(
                             (int) (line.getFirstPoint().getX()), 
                             -1 * (int) (line.getFirstPoint().getY()), 
                             (int) (line.getSecondPoint().getX()), 
                             -1 * (int) (line.getSecondPoint().getY())
                            );
          }
        }
      }
      
      // Handles the drawing of a Triangle Fractal
      else if (b == buttonDrawTri) {
        // Reset the transformation and translate the canvas center
        graph.setTransform(1, 0, 0, 1, 0, 0);
        graph.translate(canvas.getWidth() / 2, canvas.getHeight() / 2);
        
        // Parse user input for triangle coordinates and fractal parameters
        double firstX = Double.parseDouble(fieldFirstX.getText());
        double firstY = Double.parseDouble(fieldFirstY.getText());
        double secondX = Double.parseDouble(fieldSecondX.getText());
        double secondY = Double.parseDouble(fieldSecondY.getText());
        double thirdX = Double.parseDouble(fieldThirdX.getText());
        double thirdY = Double.parseDouble(fieldThirdY.getText());
        int numLevels = Integer.parseInt(fieldNumLevels.getText());
        double rotation = Double.parseDouble(fieldRotation.getText());
        
        // Create a triangle as the base shape
        Polygon baseShape;
        baseShape = new Triangle(new Point(firstX,firstY), new Point(secondX,secondY), new Point(thirdX,thirdY));
        TriangleFractal<Triangle> fractal = new TriangleFractal<Triangle>((Triangle) baseShape, numLevels);
        
        // Apply rotation and set drawing properties
        fractal.rotate(rotation);
        graph.setStroke(colorPicker.getValue());
        graph.setLineWidth(slider.getValue());
        
        // Draw the fractal by iterating through its lines
        for (Line line : fractal.getLines()) {
          graph.strokeLine(
                           (int) (line.getFirstPoint().getX()), 
                           -1 * (int) (line.getFirstPoint().getY()), 
                           (int) (line.getSecondPoint().getX()), 
                           -1 * (int) (line.getSecondPoint().getY())
                          );
        }
      }
      
      // Handles the drawing of a Rectangle Fractal
      else if (b == buttonDrawRect) {
        // Reset the transformation and translate the canvas center
        graph.setTransform(1, 0, 0, 1, 0, 0);
        graph.translate(canvas.getWidth() / 2, canvas.getHeight() / 2);
        
        // Parse user input for rectangle dimensions and fractal parameters
        double width = Double.parseDouble(fieldWidth.getText());
        double height = Double.parseDouble(fieldHeight.getText());
        int numLevels = Integer.parseInt(fieldNumLevels.getText());
        double rotation = Double.parseDouble(fieldRotation.getText());
        
        // Check if the rectangle is a square or not
        if (width != height) {
          Rectangle rec = new Rectangle(new Point(0,0), width, height);
          RectangleFractal<Rectangle> recFrac = new RectangleFractal<Rectangle>(rec, numLevels);
          
          // Apply rotation and set drawing properties
          recFrac.rotate(rotation);
          graph.setStroke(colorPicker.getValue());
          graph.setLineWidth(slider.getValue());
          
          // Draw the fractal by iterating through its lines
          for (Line line : recFrac.getLines()) {
            graph.strokeLine(
                             (int) (line.getFirstPoint().getX()), 
                             -1 * (int) (line.getFirstPoint().getY()), 
                             (int) (line.getSecondPoint().getX()), 
                             -1 * (int) (line.getSecondPoint().getY())
                            );
          }
        }
        
        // Handle square case
        else {
          // Create a square as the base shape
          Square square = new Square(new Point(0,0), width);
          RectangleFractal<Square> squareFrac = new RectangleFractal<Square>(square, numLevels);
          
          // Apply rotation and set drawing properties
          squareFrac.rotate(rotation);
          graph.setStroke(colorPicker.getValue());
          graph.setLineWidth(slider.getValue());
          
          // Draw the fractal by iterating through its lines
          for (Line line : squareFrac.getLines()) {
            graph.strokeLine(
                             (int) (line.getFirstPoint().getX()), 
                             -1 * (int) (line.getFirstPoint().getY()), 
                             (int) (line.getSecondPoint().getX()), 
                             -1 * (int) (line.getSecondPoint().getY())
                            );
          }
        }
      }
      
      // Handle Erase button click
      else if (b == buttonErase) {
        graph.setTransform(1, 0, 0, 1, 0, 0);
        graph.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
      }
    }
    
  }
  
}
