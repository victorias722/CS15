import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;


public class CompositeShape {
	private Rectangle rect;
	private Ellipse scoop;
	
	public CompositeShape(Pane cartoonPane){
		rect = new Rectangle(100,100,Color.TAN);
		scoop = new Ellipse(50,50);
		scoop.setFill(Color.TAN);
		cartoonPane.getChildren().addAll(rect,scoop);
        rect.setLayoutY(50);
		this.setXLoc(200);
		//this.setYLoc(100);
	}
	
	public double getYLoc(){
		return scoop.getCenterY();
	}
	public void setXLoc(double x){
		scoop.setCenterX(x);
		rect.setX(x-50);
	}
	public void setYLoc(double y){
		scoop.setCenterY(y);
		rect.setY(y-50);
	}
	public void setColor(Color color){
		scoop.setFill(color);
	}
	public Node getNode(){
		return scoop;
	}
}