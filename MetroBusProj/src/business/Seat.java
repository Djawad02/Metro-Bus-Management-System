package business;
import database.ConnectDB;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Seat {
		private String seat_id;
		private String availibility;
		private String cust_id;
		private String bus_id;
		private String price;
		
		private ConnectDB connection=new ConnectDB();
		
		public String getSeat_id() {
			return seat_id;
		}
		public void setSeat_id(String seat_id) {
			this.seat_id = seat_id;
		}
		public String getAvailibility() {
			return availibility;
		}
		public void setAvailibility(String availibility) {
			this.availibility = availibility;
		}
		public String getCust_id() {
			return cust_id;
		}
		public void setCust_id(String cust_id) {
			this.cust_id = cust_id;
		}
		public String getBus_id() {
			return bus_id;
		}
		public void setBus_id(String bus_id) {
			this.bus_id = bus_id;
		}
		public String getPrice() {
			return price;
		}
		public void setPrice(String price) {
			this.price = price;
		}
		
		public String checkSeatAvailibility(String seats) throws SQLException {
			ResultSet rs = connection.seatAvail(seats);

    		try {
				if(rs.next()){
					availibility = rs.getString("status");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
			return availibility;
		}

		public void Booking(String busid, String seatid,String custid) throws SQLException {
			
			connection.Booking(busid, seatid, custid);
			connection.EnteringTicketDetails(seatid,custid);
		}
		public ResultSet seatDetails(String seatnum) throws SQLException {
			
			ResultSet rs = connection.priceFromDB(seatnum);
			return rs;
			
		}
		public String seatNumber(String custid)throws SQLException {
			// TODO Auto-generated method stub
			String rs = connection.countSeats(custid);
			System.out.print(rs);
			return rs;
		}
		
		
}
