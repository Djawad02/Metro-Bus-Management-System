package application;

import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import business.Metro;
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
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AddScheduleController {

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
    private Text source;

    @FXML
    private TextField arrivalTime;

    @FXML
    private Button AddBus;

    @FXML
    private Button DeleteDeleteScheduleBus;

    @FXML
    private Text BookTicketTitle111;

    @FXML
    private TextField departTime;

    @FXML
    private Text BookTicketTitle112;

    @FXML
    private TextField regNo;

    @FXML
    private Text BookTicketTitle113;

    @FXML
    private TextField Route;

    @FXML
    private Text BookTicketTitle114;

    @FXML
    private Text Destination;

    @FXML
    private TextField Dest;

    @FXML
    private TextField Sourcc;


    @FXML
    void DeleteSchedule(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("DeleteSchedule.fxml"));
		Stage window = (Stage) DeleteDeleteScheduleBus.getScene().getWindow();
		window.setScene(new Scene(root, 700, 650));
    }

    @FXML
    void register(ActionEvent event) throws SQLException, IOException {
    	Metro M1 = new Metro();
    	String sourcee = Sourcc.getText();
    	String Des = Dest.getText();
    	String arrival = arrivalTime.getText();
    	String dept = departTime.getText();
    	String r = regNo.getText();
    	String rou = Route.getText();
    	M1.addBusSchedule(r, arrival, dept, rou, sourcee, Des);
    	JOptionPane.showMessageDialog(null,"Bus schedule Added Successfully!");
		Parent root = FXMLLoader.load(getClass().getResource("AdminView.fxml"));
		Stage window = (Stage) AddBus.getScene().getWindow();
		window.setScene(new Scene(root, 700, 650));	
    }

    @FXML
    void toOption(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("AdminView.fxml"));
		Stage window = (Stage) BackButton.getScene().getWindow();
		window.setScene(new Scene(root, 700, 650));
    }

}
