package database;

import business.Bus;
import business.Passenger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import business.Passenger;



public class ConnectDB {
	String connectionStr = "jdbc:mysql://localhost:3306/projectdata";
	String user = "root";
	String Passwrd = "daniajawad";
	
	public String ReturningPassword(String usernamee)throws SQLException {

		String passwordd = "";
		Connection con=DriverManager.getConnection(connectionStr, user, Passwrd);

		//step4 create statement to execute  query
		Statement staten = con.createStatement();	
		String sql;
        if(usernamee.equals("admin")) {
        	 sql = "Select password from passenger WHERE username=?";
        }
        else {
        	sql = "Select password from passenger WHERE username=?";
        }
		 
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, usernamee);
			
		ResultSet rs = statement.executeQuery();
		if(rs.next()){
			passwordd = rs.getString("password");
		}
		
		con.close();
			 

		return passwordd;
	}
	
	//--------------------------------------------------------------------------PASSENGER-----------------------------------------------------------------
	public void insertCustomer(Passenger cust) throws SQLException
	{
		Connection con=DriverManager.getConnection(connectionStr, user, Passwrd);
		
		PreparedStatement stm = con.prepareStatement("INSERT INTO passenger (Username, Name, DOB, Email, Address, Phone, Password) VALUES (?, ?, ?, ?, ?, ?, ?);");
		stm.setString(1,  cust.getUsername1());
		stm.setString(2, cust.getName1());
		stm.setString(3, cust.getDOB1());
		stm.setString(4, cust.getEmail1());
		stm.setString(5, cust.getAddress1());
		stm.setString(6, cust.getPhone1());
		stm.setString(7, cust.getPassord1());
		stm.executeUpdate();
		stm.close();
		con.close();
	}

	public Passenger verifyCustomerLogin(String username, String password) throws SQLException
	{
		Connection con=DriverManager.getConnection(connectionStr, user, Passwrd);
		boolean status=false;
		Statement stm = con.createStatement();
		String query = "select * from passenger where Username='"+username+"'";
		ResultSet rs = stm.executeQuery(query);
		boolean emp=rs.next();
		if(emp == false)
			return null;
		System.out.println(rs.getString(7));
		Passenger cust=new Passenger(rs.getString(1), rs.getString(4), rs.getString(6), rs.getString(5), rs.getString(2), rs.getString(7), rs.getString(3));
		System.out.println(cust.getPassord1());
		con.close();
		return cust;
		
		
	}
	//--------------------------------------------------------------------------BUS-----------------------------------------------------------------
	
	public void insertCar(Bus car) throws SQLException
	{
		Connection con=DriverManager.getConnection(connectionStr, user, Passwrd);
		
		PreparedStatement stm = con.prepareStatement("INSERT INTO bus (registrationNo) VALUES (?);");
		
		stm.setString(1, car.getRegistration1());
		
		
		stm.executeUpdate();
		stm.close();
		con.close();
	}
	public boolean verifyCar(String reg) throws SQLException
	{
		Connection con=DriverManager.getConnection(connectionStr, user, Passwrd);
		Statement stm = con.createStatement();
		String query = "select * from bus where registrationNo='"+reg+"'";
		ResultSet rs = stm.executeQuery(query);
		boolean emp=rs.next();
		if(emp == false)
			return false;
		
		//Customer cust=new Customer(rs.getString(1), rs.getString(4), rs.getString(7), rs.getString(5), rs.getString(2), rs.getString(6), rs.getString(8), rs.getString(3));
		//System.out.println(rs.getString(1) + rs.getString(4) + rs.getString(7) + rs.getString(5) + rs.getString(2) + rs.getString(6) + rs.getString(8) + rs.getString(3));
		con.close();
		return true;
		
	}
	public void deleteCar(String regNo) throws SQLException
	{
		Connection con=DriverManager.getConnection(connectionStr, user, Passwrd);
		String query = "delete from bus where registrationNo='"+regNo+"'";
		PreparedStatement stm = con.prepareStatement(query);
		
		stm.executeUpdate();
		stm.close();
		con.close();
		
	}
	//--------------------------------------------------------------------------SCHEDULE-----------------------------------------------------------------
	public void addSchedule(String reg, String departure,String arrival, String source, String destin,  String route)throws SQLException
	{
		Connection con=DriverManager.getConnection(connectionStr, user, Passwrd);
		
		PreparedStatement stm = con.prepareStatement("INSERT INTO schedule (reg, departure, arrival,source,destination,route) VALUES (?, ?,?,?, ?, ?);");
		
		stm.setString(1, reg);
		stm.setString(2,departure);
		stm.setString(3,arrival);
		stm.setString(4,source);
		stm.setString(5,destin);
		stm.setString(6,route);
		
		
		
		stm.executeUpdate();
		stm.close();
		con.close();
	}
	
	public void deleteSchedule(String reg)throws SQLException
	{
		Connection con=DriverManager.getConnection(connectionStr, user, Passwrd);
		System.out.println(reg);
		String query = "delete from schedule where id='"+reg+"'";
		PreparedStatement stm = con.prepareStatement(query);
		
		stm.executeUpdate();
		stm.close();
		con.close();
	}

	public ResultSet seatAvail(String seats)throws SQLException
	{
		// TODO Auto-generated method stub
		Connection con=DriverManager.getConnection(connectionStr, user, Passwrd);
		String sql = "Select status from seat WHERE seatID=?";
		PreparedStatement statement = con.prepareStatement(sql);
		
		statement.setString(1,seats);
		
		ResultSet rs = statement.executeQuery();
		
		return rs;
		
	}

	public ResultSet priceFromDB(String seatnum)throws SQLException {
		// TODO Auto-generated method stub
		String price = "";
		Connection con=DriverManager.getConnection(connectionStr, user, Passwrd);

		//step4 create statement to execute  query
		Statement staten = con.createStatement();	
		String sql= "Select * from Seat INNER JOIN Passenger on Seat.pid=Passenger.pid  WHERE Seat.pid_id=?";
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, seatnum);
			
		ResultSet rs = statement.executeQuery();
		
		
		 return rs;


	}

	public void Booking(String busid, String seatid, String p_id) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=DriverManager.getConnection(connectionStr, user, Passwrd);

		//step4 create statement to execute  query
		
		String sql = "UPDATE Seat SET status =? WHERE seatID=?";
		PreparedStatement statement = con.prepareStatement(sql);
		
		statement.setString(1, "true");
		statement.setString(2, seatid);
		
		int rowsUpdated = statement.executeUpdate();
		if (rowsUpdated > 0) {
		    System.out.println("Seat Booked Successfully!");
		}
			
				
	}

	public void EnteringTicketDetails(String seatid, String custid) {
		// TODO Auto-generated method stub
		
	}

	public String countSeats(String custid) throws SQLException {
		// TODO Auto-generated method stub
		
		Connection con=DriverManager.getConnection(connectionStr, user, Passwrd);
		String count = "";

			//step4 create statement to execute  query
			
			String sql = "Select count(seatID) as num from Seat WHERE cust_id=?";
			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setString(1, custid);
			
			ResultSet rs = statement.executeQuery();
			if(rs.next()){
				count = rs.getString("num");
			}	 

		return count;
		
	}

	public ResultSet ReturnSource(String id) throws SQLException {
		// TODO Auto-generated method stub
		String source = "";
		Connection con=DriverManager.getConnection(connectionStr,user,Passwrd);

		//step4 create statement to execute  query
		Statement staten = con.createStatement();	
		String sql= "Select * from Bus INNER JOIN Schedule on Bus.registrationNo=Schedule.reg WHERE Bus.registrationNo=?";
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, id);
			
		ResultSet rs = statement.executeQuery();
		
		
		 return rs;
	}
	
	
}
