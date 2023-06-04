package business;
import database.ConnectDB;

import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.beans.property.SimpleStringProperty;

public class Schedule {
	   private String schedule_id;
	   private String train_id;
	   private String arrival_time;
	   private String departure_time;
	   private String price;
	   
	   ConnectDB obj2 = new ConnectDB();
	   
	   public Schedule() {
		   
	   }
	public Schedule(String tid, String seats, String time, String price) {
		// TODO Auto-generated constructor stub
		this.train_id = new String(tid);
        this.schedule_id = new String(seats);
        this.departure_time = new String(time);
        this.price = new String(price);
	}
	public String getSchedule_id() {
		return schedule_id;
	}
	public void setSchedule_id(String schedule_id) {
		this.schedule_id = schedule_id;
	}
	public String getTrain_id() {
		return train_id;
	}
	public void setTrain_id(String train_id) {
		this.train_id = train_id;
	}
	public String getArrival_time() {
		return arrival_time;
	}
	public void setArrival_time(String arrival_time) {
		this.arrival_time = arrival_time;
	}
	public String getDeparture_time() {
		return departure_time;
	}
	public void setDeparture_time(String departure_time) {
		this.departure_time = departure_time;
	}
//	public String searchSchedule(String source, String destination) {
//		// TODO Auto-generated method stub
//		String id = obj2.getTrainID(source,destination);
//		return id;
//	}
	public ResultSet Retvalues(String id) throws SQLException {
		// TODO Auto-generated method stub
		
		ResultSet rs = obj2.ReturnSource(id);
		return rs;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
}
