package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

public class MainViewController implements Initializable{

	@FXML
	private MenuItem menuItemAddRecord;
	
	@FXML
	private MenuItem menuItemClose;
	
	@FXML
	private MenuItem menuItemAbout;
	
	@FXML
	public void onMenuItemAddRecord() {
		System.out.println("onMenuItemAddRecord");
	}
	
	@FXML
	public void onMenuItemClose() {
		System.out.println("onMenuItemClose");
	}
	
	@FXML
	public void onMenuItemAbout() {
		System.out.println("onMenuItemAbout");
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		
	}
}
