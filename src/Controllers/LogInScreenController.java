package Controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LogInScreenController {

	@FXML
	private TextField usernameTextField;

	@FXML
	private PasswordField passwordTextField;

	@FXML
	private Button logInBtn;

	@FXML
	private Label wrongLogIn;

	public void userLogIn(ActionEvent event) throws IOException {
		checkLogin();
		
	}

	private void checkLogin() throws IOException {

		if (usernameTextField.getText().toString().equals("admin")
				&& passwordTextField.getText().toString().equals("123")) {
			wrongLogIn.setText("Success!");
			
			Main.setRoot("ComputerRepairStore");
			Main.changeStageTitle("Computer Repair Store");
		

		} else if (usernameTextField.getText().isEmpty() && passwordTextField.getText().isEmpty()) {
			wrongLogIn.setText("Please enter your username and password.");

		} else {
			wrongLogIn.setText("Wrong username or password!");
		}
		
		

	}

}
