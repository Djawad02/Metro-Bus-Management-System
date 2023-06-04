package application;

import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import business.Metro;

public class RegisterController {

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
    private TextField name;

    @FXML
    private Button Register;

    @FXML
    private Text loginText1;

    @FXML
    private Text usernameBox1;

    @FXML
    private TextField dob;

    @FXML
    private Text loginText2;

    @FXML
    private Text usernameBox2;

    @FXML
    private TextField username;

    @FXML
    private TextField email;

    @FXML
    private Text loginText11;

    @FXML
    private Text usernameBox21;

    @FXML
    private TextField address;

    @FXML
    private Text loginText12;

    @FXML
    private Text usernameBox22;

    @FXML
    private TextField cnic;

    @FXML
    private Text loginText13;

    @FXML
    private Text usernameBox23;

    @FXML
    private TextField phone;

    @FXML
    private Text loginText14;

    @FXML
    private Text usernameBox24;

    @FXML
    private TextField password;

    @FXML
    void register(ActionEvent event) throws SQLException, IOException {
    	Metro M1 = new Metro();
    	String n = name.getText();
    	String usern = username.getText();
    	String dobb = dob.getText();
    	String emaill = email.getText();
    	String add = address.getText();
    	String phn = phone.getText();
    	String pw = password.getText();
    	M1.addPassenger(usern, emaill, phn, add, n, pw, dobb);
    	JOptionPane.showMessageDialog(null,"Register Successful");
		Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		Stage window = (Stage) Register.getScene().getWindow();
		window.setScene(new Scene(root, 700, 650));	
    }

}
