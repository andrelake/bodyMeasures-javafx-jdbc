package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.entities.User;

public class NewRecordController implements Initializable{

	ObservableList<String> genderlist = FXCollections.observableArrayList("Male", "Female");
	
	private User entity;
	
	@FXML
	private TextField txtId;
	
	@FXML
	private TextField txtName;
	
	@FXML
	private Label labelErrorName;
	
	@FXML
	private TextField txtAge;
	
	@FXML
	private ChoiceBox<String> choiceBoxGender;
	
	@FXML
	private Button btnRecord;
	
	@FXML
	private Button btnCancel;
	
	public void setUser(User entity) {
		this.entity = entity;
	}
	
	@FXML
	public void onBtRecordAction() {
		System.out.println("onBtRecordAction");
	}
	
	@FXML
	public void onBtCancelAction() {
		System.out.println("onBtCancelAction");
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		choiceBoxGender.setItems(genderlist);
		
		Stage stage = (Stage) Main.getMainScene().getWindow();
	}
	
	public void updateFormData() {
		txtId.setText(String.valueOf(entity.getId())); //converte int do id pra string
		txtName.setText(entity.getName());
		txtAge.setText(String.valueOf(entity.getAge()));
	}

}
