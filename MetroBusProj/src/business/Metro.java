package business;

import database.ConnectDB;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Metro {
	private static ConnectDB connection=new ConnectDB();
	//---------------PASSENGER-------------------------------------------
	public static void addPassenger(String username, String email, String phone, String address, String name, String password, String DOB) throws SQLException
	{
		Passenger cust=new Passenger(username, email, phone, address, name, password, DOB);
		connection.insertCustomer(cust);
	}
	
	static boolean verifyPassenger(String username, String password) throws SQLException
    {
		Passenger cust;
		cust=connection.verifyCustomerLogin(username, password);
		
		if(cust == null)
			return false;	
		if(cust.getPassord1().equals(password))
		{
			return true;
		}
		return false;
    }
	//------------------------------------Bus--------------------------------
	public static void addBus(String reg) throws SQLException
	{
		Bus car;
		car=new Bus(reg);
		connection.insertCar(car);
	}
	
	static boolean verifyBus(String regNo) throws SQLException
	{
		return connection.verifyCar(regNo);
	}
	
	 public static void deleteBus(String regNo) throws SQLException
    {
		 connection.deleteCar(regNo);
    }
	 
	//------------------------------------Bus Schedule--------------------------------
	public static void addBusSchedule(String reg, String arrival, String departure, String route,String source,String destin) throws SQLException
	{
		
		connection.addSchedule(reg, departure, arrival,source,destin, route);
	}
	
	public static void deleteBusSchedule(String reg) throws SQLException
	{
		
		connection.deleteSchedule(reg);
	}

	//------------------------------------Seat Availibility--------------------------------
	public static String checkSeatAvailibility(String seats) throws SQLException
	{
		Seat S1 = new Seat();
		String ss = S1.checkSeatAvailibility(seats);
		return ss;
	}

//	public ResultSet seatDetails(String seats) throws SQLException {
//		// TODO Auto-generated method stub
//		Seat S1 = new Seat();
//		S1.checkSeatAvailibility(seats);
//		
//		connection.seatAvail(seats);
//		return null;
//	}

	public ResultSet ReturnSource(String busID) throws SQLException {
		
		Schedule S1 = new Schedule();
		ResultSet val = S1.Retvalues(busID);
		return val;
		// TODO Auto-generated method stub
		 
	}

	public void Booking(String busid, String seatid, String custid) throws SQLException {
		// TODO Auto-generated method stub
		Seat S1 = new Seat();
		S1.Booking(busid, seatid, custid);
	}


	


}
