import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import com.dao.CityDAO;
import com.vo.City;

public class Test {
public static void addCity(City city) {
	
		String insertQuery = "INSERT INTO city (id, name, countrycode, district,population) VALUES(?,?,?,?,?)";
		
	//Here ? is a Bind parameter(place holders)
		//We can replace values in them at runtime
		//Bind parameters are indexed based
		
		try {
			
			//Step1: Load Drivers
			//forName is used to load class into memeory
			Class.forName("org.gjt.mm.mysql.Driver");
			
			//JDBC driver class for oracle server
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//JDBC driver class for Microsoft SQL server
			//Class.forName("com.microsoft.sqlserver.jdbc.sqlserverDriver");
			
			//Step-2:Establishing Connection
			
			Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3333/world","root","root");
			
			//Connection URL for Oracle Server
			//Connection connection =DriverManager.getConnection("jdbc:oracle:this:@localhost:1521:sid","root","root");
			
			//Connection URL for Microsoft SQL server
			//Connection connection =DriverManager.getConnection("jdbc:microsoft:sqlserver://localhost:1433;DatabasName=world","root","root");
			
			//step 3:Create Statement Object
			/*Statement statement = connection.createStatement();*/
			//prepareStatement is used to execute query,it supports bind parameters
			PreparedStatement statement = connection.prepareStatement(insertQuery);
			statement.setInt(1,city.getId() );
			statement.setString(2, city.getName());
			statement.setString(3,city.getCountryCode() );
			statement.setString(4, city.getDistrict());
			statement.setInt(5,city.getPoulation() );
			
			//Step 4:Execute Query
			//When we execute non-select statement ,we use executeUpdate Method,and for select we use executeQuery stmt
			statement.executeUpdate();
			
			
			System.out.println("Connection Successfull");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


public static ArrayList<Object[]> getCitiesNC(){
	
	
	return null;
	
	
	
}

//Each record from DB to objects

public static ArrayList<City> getCities(){
	
	ArrayList<City> cityList = new ArrayList<City>();
	
	String query = "select * from city where id =306";
	
	try {
		
		//Step1: Load Drivers
		Class.forName("org.gjt.mm.mysql.Driver");
		
		//Step-2:Establishing Connection
		
		Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3333/world","root","root");
		
		
		Statement stmt = connection.createStatement();
		
		//ResultSet helps to read the record and fetch the record
		ResultSet resultset =stmt.executeQuery(query);
		
		
		
		
		while(resultset.next() ){
			
			City city =new City();
			System.out.println("\n");
			city.setId(resultset.getInt("id"));
			city.setName(resultset.getString("name"));
			city.setCountryCode(resultset.getString("countrycode"));
			city.setDistrict(resultset.getString("district"));
			city.setPoulation(resultset.getInt("population"));
			System.out.println();
			
			cityList.add(city);
		}
		
		resultset.close();
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	return cityList;
	
	
}
		
public static void main(String[] args) {

	CityDAO cityDAO = new CityDAO();
	
	City cityID = cityDAO.getCityById(7);
	
	
		System.out.println("ID :"+cityID.getId());
		System.out.println("Name :"+cityID.getName());
		System.out.println("Country Code :"+cityID.getCountryCode());
		System.out.println("District :"+cityID.getDistrict());
		System.out.println("Population :"+cityID.getPoulation());
	
	
	
	
	/*CityDAO cityDAO = new CityDAO();
	
	ArrayList<City> cityList = cityDAO.getCitys();
	
	for(City city: cityList){
	System.out.println("ID :"+city.getId());
	System.out.println("Name :"+city.getName());
	System.out.println("Country Code :"+city.getCountryCode());
	System.out.println("District :"+city.getDistrict());
	System.out.println("Population :"+city.getPoulation());
	
	}*/
	
//	
//	//For Stored-Procedure execution
//	
//try {
//		
//		//Step1: Load Drivers
//		Class.forName("org.gjt.mm.mysql.Driver");
//		
//		//Step-2:Establishing Connection
//		
//		Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3333/world","root","root");
//		
//		CallableStatement callableStatement = connection.prepareCall("CALL country_hos('kabol')");
//		
//		callableStatement.execute();
//		System.out.println(callableStatement.getInt(1));
//		System.out.println(callableStatement.getString(2));
//		
//		
//} catch (ClassNotFoundException | SQLException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//}
		
		
	/*ArrayList<City> citiess = getCities();
	
	for(City city :citiess){
		
		System.out.println("ID :"+city.getId());
		System.out.println("Name :"+city.getName());
		System.out.println("Country Code :"+city.getCountryCode());
		System.out.println("District :"+city.getDistrict());
		System.out.println("Population :"+city.getPoulation());
	}
	*/
	
	/*City city = new City(9009, "Londoon", "LDN", "Pensilvania", 96453);
	
	addCity(city);*/
}
}
