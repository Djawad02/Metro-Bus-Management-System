package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AdminViewController {

    @FXML
    private AnchorPane anchorP;

    @FXML
    private Pane TitlePane;

    @FXML
    private ImageView bookingLogo;

    @FXML
    private Text BookTicketTitle;

    @FXML
    private Line bookingLine1;

    @FXML
    private Button BackButton;

    @FXML
    private Pane bookingOptions;

    @FXML
    private Text BookTicketTitle1;

    @FXML
    private ImageView bookingTicket;

    @FXML
    private Line bookingLine11;

    @FXML
    private Button ManageBus;

    @FXML
    private Button ManageFeedback;

    @FXML
    private Button ManageBusSchedule;

    @FXML
    private Button PrintTicket;

    @FXML
    void Login(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		Stage window = (Stage) BackButton.getScene().getWindow();
		window.setScene(new Scene(root, 700, 650));
    }

    @FXML
    void ManageBusSchedule(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("AddSchedule.fxml"));
		Stage window = (Stage) ManageBusSchedule.getScene().getWindow();
		window.setScene(new Scene(root, 700, 650));
    }

    @FXML
    void ManageBuses(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("AddBus.fxml"));
		Stage window = (Stage) ManageBus.getScene().getWindow();
		window.setScene(new Scene(root, 700, 650));
    }

    @FXML
    void ManageFeedback(ActionEvent event) {

    }

    @FXML
    void PrintTicket(ActionEvent event) {

    }

}
