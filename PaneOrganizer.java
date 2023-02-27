import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;


public class PaneOrganizer {
	private BorderPane root;
	private VBox buttonPane;
	private CompositeShape compositeShape;
	private Label label;
	private Timeline timeline;
	private int num;
	
	
	public PaneOrganizer(){
		root = new BorderPane();
		root.setStyle("-fx-background-color: white;");
		root.setPrefSize(400,400);
		Pane cartoonPane = new Pane();
		compositeShape = new CompositeShape(cartoonPane);
		root.setCenter(cartoonPane);
		label = new Label("Hello! Welcome to Victoria's Creamery. Let me show you what flavors we have available for you today!");
		label.setTextFill(Color.BLACK);
		root.setTop(label);
		this.setupTimeline();
		this.setupButton();

	}
	
	public void setupTimeline(){
		KeyFrame keyframe = new KeyFrame(Duration.seconds(0.5), new TimeHandler());
		timeline = new Timeline(keyframe);
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
		
	}
	
	public BorderPane getRoot(){
		return root;
	}
	
	public void setupButton(){
		buttonPane = new VBox();
		Button btn = new Button("Quit");
		buttonPane.getChildren().add(btn);
		root.setBottom(buttonPane);
		btn.setOnAction(new ClickHandler());		
	}

	public void changeColor(){
		switch (num) {
		case 0:
			num = 1;
			compositeShape.setColor(Color.PINK);
			label.setText("We have strawberry ice cream");
			label.setTextFill(Color.PINK);
			break;
		case 1:
			num = 2;
			compositeShape.setColor(Color.YELLOW);
			label.setText("We have mango ice cream");
			label.setTextFill(Color.YELLOW);
			break;
		case 2:
			num = 3;
			compositeShape.setColor(Color.BLUE);
			label.setText("We have cookie monster ice cream");
			label.setTextFill(Color.BLUE);
			break;
		case 3:
			num = 4;
			compositeShape.setColor(Color.PURPLE);
			label.setText("We have black raspberry ice cream");
			label.setTextFill(Color.PURPLE);
			break;
		case 4: 
			num = 5;
			compositeShape.setColor(Color.RED);
			label.setText("We have red velvet ice cream");
			label.setTextFill(Color.RED);
			break;
		case 5:
			num = 6;
			compositeShape.setColor(Color.ORANGE);
			label.setText("We have caramel ice cream");
			label.setTextFill(Color.ORANGE);
			break;
		case 6:
			num = 7;
			compositeShape.setColor(Color.GREEN);
			label.setText("We have Matcha ice cream");
			label.setTextFill(Color.GREEN);
			break;
		default:
			compositeShape.setColor(Color.PINK);
			label.setText("Thank you for coming! Enjoy your ice cream!");
			label.setTextFill(Color.PINK);
			break;
		}
	}
	
	private class TimeHandler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			PaneOrganizer.this.changeColor();
			
			
			if (compositeShape.getYLoc() < 275){
				compositeShape.setYLoc(compositeShape.getYLoc() + 25);
			} else{
				timeline.stop();
				label.setText("What kind of ice cream would you like?");
			}
		}
	}
	
	private class ClickHandler implements EventHandler<ActionEvent>{
		
		public void handle(ActionEvent event){
			System.exit(0);
		}
	}
}