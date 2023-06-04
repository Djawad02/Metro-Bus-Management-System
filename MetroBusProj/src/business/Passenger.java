package business;
import java.sql.SQLException;

import database.ConnectDB;

//import javafx.beans.property.SimpleStringProperty;
//import javafx.beans.property.StringProperty;

public class Passenger extends Person{
	private String username1, password1,email1, phone1 ,address1, name1, DOB1;
	//StringProperty username, email, address, name, pasword, DOB, phone;
	private ConnectDB connection=new ConnectDB();
	boolean verifyLogin(String username, String password) throws SQLException
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
	
	
	Passenger()
	{
		
	}
	
//	public Passenger()
//	{
//		this.username=new SimpleStringProperty();
//		this.email=new SimpleStringProperty();
//		this.address=new SimpleStringProperty();
//		this.name=new SimpleStringProperty();
//		this.pasword=new SimpleStringProperty();
//		this.DOB=new SimpleStringProperty();
//		this.phone=new SimpleStringProperty();
//	}
//	
//	Passenger(StringProperty un, StringProperty email, StringProperty phone, StringProperty address, StringProperty name, StringProperty password, StringProperty DOB) throws SQLException
//	{
//		this.username=un;
//		this.email=email;
//		this.phone=phone;
//		this.address=address;
//		this.name=name;
//		this.DOB=DOB;
//		this.pasword=password;
//	}
//
//	public StringProperty getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username.set(username);
//	}
//
//	public StringProperty getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email.set(email);;
//	}
//
//	public StringProperty getAddress() {
//		return address;
//	}
//
//	public void setAddress(String address) {
//		this.address.set(address);
//	}
//
//	public StringProperty getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name.set(name);
//	}
//
//	
//
//	
//
//	public StringProperty getPasword() {
//		return pasword;
//	}
//
//	public void setPasword(String pasword) {
//		this.pasword.set(pasword);
//	}
//
//	public StringProperty getDOB() {
//		return DOB;
//	}
//
//	public void setDOB(String dOB) {
//		this.DOB.set(dOB);
//	}
//
//	public StringProperty getPhone() {
//		return phone;
//	}
//
//	public void setPhone(String phone) {
//		this.phone.set(phone);
//	}
	public Passenger(String un, String email, String phone, String address, String name, String password, String DOB) throws SQLException
	{
		this.username1=un;
		this.email1=email;
		this.phone1=phone;
		this.address1=address;
		this.name1=name;
		this.DOB1=DOB;
		password1=password;
		
		//adding to database
		
	}
	
	
	
	public String getPassord1()
	{
		return password1;
	}

	public String getUsername1() {
		return username1;
	}

	public void setUsername1(String username1) {
		this.username1 = username1;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public String getDOB1() {
		return DOB1;
	}

	public void setDOB1(String dOB1) {
		DOB1 = dOB1;
	}
	
	
	

}
