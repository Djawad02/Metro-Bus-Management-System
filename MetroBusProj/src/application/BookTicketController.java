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

public class BookTicketController {

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
    private TextField custIDField;

    @FXML
    private TextField TrainIDField;

    @FXML
    private Text BookTicketTitle1;

    @FXML
    private ImageView bookingTicket;

    @FXML
    private Line bookingLine11;

    @FXML
    private Text BookTicketTitle11;

    @FXML
    private Button findID;

    @FXML
    private Text BookTicketTitle111;

    @FXML
    private TextField SeatnumField;

    @FXML
    private Text BookTicketTitle1111;

    @FXML
    private TextField SourceField;

    @FXML
    private Text BookTicketTitle1112;

    @FXML
    private TextField DestField;

    @FXML
    private Text BookTicketTitle11111;

    @FXML
    private TextField ArrivalTime;

    @FXML
    private Text BookTicketTitle11121;

    @FXML
    private TextField DepartTime;

    @FXML
    private Text BookTicketTitle111111;

    @FXML
    private Button checkOutButton;

    @FXML
    void Search(ActionEvent event) throws SQLException {
    		Metro Obj1 = new Metro();
    		String custid = custIDField.getText();
    		String trainid = TrainIDField.getText();
    		
    		ResultSet rs;
    		if(TrainIDField.getText() =="") {
    			JOptionPane.showMessageDialog(null, "Kindly fill Bus Id field to fetch data");
    		}
    		else {
    			rs= Obj1.ReturnSource(trainid);
    			
        		if(rs.next()){
        			SourceField.setText(rs.getString("source"));
        			DestField.setText(rs.getString("destination"));
        			ArrivalTime.setText(rs.getString("arrival"));
        			DepartTime.setText(rs.getString("departure"));
        		}
    		}
    }

    @FXML
    void checkToFare(ActionEvent event) throws IOException, SQLException {
    	Metro Obj1 = new Metro();
		String seats = SeatnumField.getText();
		 String ans;
		 if(seats.equals("")) {
			 JOptionPane.showMessageDialog(null,"Kindly enter seatID");
			 SeatnumField.setText(null);
			  seats = SeatnumField.getText();
		 }
		 else{
			 ans = Obj1.checkSeatAvailibility(seats);
			 if(ans.equals("false")) {
    			 
     			String trainid = TrainIDField.getText();
  	    		String seatid = SeatnumField.getText();
  	    		String custid=custIDField.getText();
  	    		Obj1.Booking(trainid,seatid,custid);
  	    		
  	    		JOptionPane.showMessageDialog(null,"Booking successful");
  	    		
  	        	Parent root = FXMLLoader.load(getClass().getResource("PassengerView.fxml"));
  	        	Stage window = (Stage) checkOutButton.getScene().getWindow();
  	        	window.setScene(new Scene(root, 700, 650));
     		 }
     		 else {
     			 JOptionPane.showInternalMessageDialog(null, "Seat not available");
     			
     			 SeatnumField.setText("");
     		 }
		 }
    }

    @FXML
    void viewSchedule(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("PassengerView.fxml"));
    	Stage window = (Stage) BackButton.getScene().getWindow();
    	window.setScene(new Scene(root, 700, 650));
    }

}
