package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class MainViewController implements Initializable{

	@FXML
	private MenuItem menuItemAddRecord;
	
	@FXML
	private MenuItem menuItemClose;
	
	@FXML
	private MenuItem menuItemAbout;
	
	@FXML
	public void onMenuItemAddRecordAction() {
		loadView("/gui/NewRecord.fxml");
	}
	
	@FXML
	public void onMenuItemCloseAction() {
		System.out.println("onMenuItemClose");
	}
	
	@FXML
	public void onMenuItemAboutAction() {
		loadView("/gui/About.fxml");
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		
	}
	
	private synchronized void loadView(String path) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
			VBox newVbox = loader.load();
			
			//Show the view in the main window. Working in MainView.FXML
			Scene mainScene = Main.getMainScene();  //main scene reference
			VBox mainVbox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent(); //root get the first item of fxml
																					//content is the second item
			Node mainMenu = mainVbox.getChildren().get(0); //main menu reference
			mainVbox.getChildren().clear(); // clear the mainVbox
			mainVbox.getChildren().add(mainMenu); // add mainMenu
			mainVbox.getChildren().addAll(newVbox.getChildren()); //add children of the new opened window
		}
		catch(IOException e) {
			Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
		}
	}
}
