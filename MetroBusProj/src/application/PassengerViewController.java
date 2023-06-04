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

public class PassengerViewController {

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
    private Button BookTicket;

    @FXML
    private Button Seat;

    @FXML
    private Button BusSchedule;

    @FXML
    private Button GiveFeedback;

    @FXML
    private Button BusDetails;

    @FXML
    private Button CancelTicket;

    @FXML
    void BookTicket(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("BookTicket.fxml"));
    	Stage window = (Stage) BookTicket.getScene().getWindow();
    	window.setScene(new Scene(root, 700, 650));
    }

    @FXML
    void BusDetails(ActionEvent event) {

    }

    @FXML
    void BusSchedule(ActionEvent event) {

    }

    @FXML
    void CancelTicket(ActionEvent event) {

    }

    @FXML
    void GiveFeedback(ActionEvent event) {

    }

    @FXML
    void Login(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		Stage window = (Stage) BackButton.getScene().getWindow();
		window.setScene(new Scene(root, 700, 650));	
    }

    @FXML
    void Seatfunc(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("CheckSeatAvailability.fxml"));
		Stage window = (Stage) Seat.getScene().getWindow();
		window.setScene(new Scene(root, 700, 650));	
    }

}
