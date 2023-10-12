


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	//  declare two HBoxes
	private Button button1, button2, button3, button4, button5;
	private Label label;
	private TextField textField;
	private HBox buttonBox, textBox;
	
	//student Task #4:
	//  declare an instance of DataManager
	private DataManager dataManager;
	/*****
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 ******/
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		//Instantiate buttons
		this.button1 = new Button("Button 1");
		this.button2 = new Button("Button 2");
		this.button3 = new Button("Button 3");
		this.button4 = new Button("Button 4");
		this.button5 = new Button("Button 5");
		
		this.button1.setOnAction(new ButtonHandler());
		this.button2.setOnAction(new ButtonHandler());
		this.button3.setOnAction(new ButtonHandler());
		this.button4.setOnAction(new ButtonHandler());
		this.button5.setOnAction(new ButtonHandler());
		//Instantiate label
		Label label = new Label("Label:");
		//Instantiate Text Field
		textField = new TextField();
		//  instantiate the HBoxes
		HBox buttonBox = new HBox(button1, button2, button3, button4, button5);
		HBox textBox = new HBox(label, textField);
		HBox textBoxStandIn = new HBox(label, textField);
		
		//student Task #4:
		//  instantiate the DataManager instance
		dataManager = new DataManager();
		//  set margins and set alignment of the components
		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		textBox.getChildren().addAll(textBoxStandIn);
		//  add the buttons to the other HBoxs
		/*NOTE TO SELF
		/My program will not run without the line 
		 * of code immediately below
		This deviates from lab instructions*/
		HBox buttonBoxStandIn = new HBox(button1, button2, button3, button4, button5);
		buttonBox.getChildren().addAll(buttonBoxStandIn);
		//  add the HBoxes to this FXMainPanel (a VBox)
		getChildren().addAll(buttonBoxStandIn, textBoxStandIn);
		
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	@SuppressWarnings("unused")
	private class ButtonHandler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent arg0) {
			Object buttonClicked = arg0.getTarget();
			
			if(buttonClicked == button1) {
				textField.setText(dataManager.getHello());
			}else if(buttonClicked == button2) {
				textField.setText(dataManager.getHowdy());
			}else if(buttonClicked == button3) {
				textField.setText(dataManager.getChinese());
			}else if(buttonClicked == button4){
				textField.setText("");
			}else{
				Platform.exit();
				System.exit(0);
			}
			
		}
		
	}
}
	
