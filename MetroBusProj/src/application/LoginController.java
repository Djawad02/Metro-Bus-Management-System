package application;


import java.io.IOException;

import javax.swing.JOptionPane;

import database.ConnectDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Pane welcomePane;

    @FXML
    private Text welcomeText;

    @FXML
    private Pane credentialsbox;

    @FXML
    private ImageView logo;

    @FXML
    private Text tagline;

    @FXML
    private Text loginText;

    @FXML
    private Text usernameBox;

    @FXML
    private Text passwordBox;

    @FXML
    private TextField usernameText;

    @FXML
    private PasswordField passText;
    
    @FXML
    private Button SignIn;

    @FXML
    private Button SignUp;

    @FXML
    void LoggingIn(ActionEvent event) {
    	try {
    		ConnectDB Obj1 = new ConnectDB();
    		String usern = usernameText.getText();
    		String Pw = passText.getText();
    		
    		String ans = Obj1.ReturningPassword(usern);
//    		System.out.println(ans);
    		if((usern.isEmpty() || Pw.isEmpty()) || (usern.isEmpty() && Pw.isEmpty()) ) {
    			JOptionPane.showMessageDialog(null, "Kindly fill both fields");
    			passText.setText(null);
    			usernameText.setText(null);
    		}
    		else {
    			if(ans.equals(Pw)) {
        			JOptionPane.showMessageDialog(null,"Login successful");
        			if(usern.equals("admin")) {
            			Parent root = FXMLLoader.load(getClass().getResource("AdminView.fxml"));
            			Stage window = (Stage) SignIn.getScene().getWindow();
            			window.setScene(new Scene(root, 700, 650));	
            		}
        			else {
        				Parent root = FXMLLoader.load(getClass().getResource("PassengerView.fxml"));
            			Stage window = (Stage) SignIn.getScene().getWindow();
            			window.setScene(new Scene(root, 700, 650));			   
        			}
        		}
        	    
        		else {
        			   Alert alert1= new Alert(AlertType.ERROR);
    				   alert1.setTitle("Warning");
    				   alert1.setHeaderText("Wrong Username or Password" + "\nTry Again");
    				   alert1.showAndWait();
        			   passText.setText(null);
    				   usernameText.setText(null);
        			}
    		}
    		
    	
    	}catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void Register(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Register.fxml"));
		Stage window = (Stage) SignUp.getScene().getWindow();
		window.setScene(new Scene(root, 700, 650));		
    }

}
