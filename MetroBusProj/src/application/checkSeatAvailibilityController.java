package application;

import java.io.IOException;
import java.sql.ResultSet;
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

public class checkSeatAvailibilityController {

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
    private Text BookTicketTitle11;

    @FXML
    private TextField reg;

    @FXML
    private Button seatAvailibilityButton;

    @FXML
    private Text BookTicketTitle111;

    @FXML
    private TextField reg1;

    @FXML
    void adminView(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("PassengerView.fxml"));
    	Stage window = (Stage) seatAvailibilityButton.getScene().getWindow();
    	window.setScene(new Scene(root, 700, 650));
    }

    @FXML
    void checkSeatAvailibility(ActionEvent event) throws SQLException, IOException  {
	    	Metro Obj1 = new Metro();
    		String seats = reg.getText();
	   		 String ans;
	   		 if(seats.equals("")) {
	   			 JOptionPane.showMessageDialog(null,"Kindly enter seatID");
	   			 reg.setText(null);
	   			 seats = reg.getText();
	   		 }
	   		else{
   			 ans = Obj1.checkSeatAvailibility(seats);
//   			System.out.println(ans);
   			 if(ans.equals("false")) {
        			JOptionPane.showInternalMessageDialog(null, "Seat available");
        			Parent root = FXMLLoader.load(getClass().getResource("PassengerView.fxml"));
                	Stage window = (Stage) seatAvailibilityButton.getScene().getWindow();
                	window.setScene(new Scene(root, 700, 650));
        	  }
        	 else {
        			 JOptionPane.showInternalMessageDialog(null, "Seat not available");
        			 Parent root = FXMLLoader.load(getClass().getResource("PassengerView.fxml"));
        	        	Stage window = (Stage) seatAvailibilityButton.getScene().getWindow();
        	        	window.setScene(new Scene(root, 700, 650));
        	        	reg.setText("");
        		 }
   		     }

    }

}
