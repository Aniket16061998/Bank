package Management;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Bankdb {
	String url = "jdbc:mysql://localhost:3306/bankdb";
	String user = "root";
	String pass = "root";
	Connection connection;
	Statement statement;
	PreparedStatement preparedsStatement;
	String query;
	Scanner scanner = new Scanner(System.in);
	
	


public Connection getConnection() throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection connection = DriverManager.getConnection(url,user,pass);
	return connection;
	
	
}

public void displayAcc(int accountnumber) throws Exception {
	  
		Connection connection = getConnection();

	    PreparedStatement preparedstatement = connection.prepareStatement("Select * from account where accountnumber = ?");
	    
	    preparedstatement.setInt(1, accountnumber);
	
		ResultSet resultSet = preparedstatement.executeQuery();
		System.out.println("`````````` Account Holder Details `````````\n");
		while(resultSet.next()){
			System.out.println(  "\t Name.     : "+resultSet.getString(1)+"\n\t Address   : "
					+resultSet.getString(2)+"\n\t Contact.    : "+resultSet.getLong(3)+"\n\t Account Number : "
					+resultSet.getInt(4)+"\n\t Pan No.     : "+resultSet.getString(5)
					+"\n\t Acc Pin     : "+resultSet.getInt(6)+"\n\t Acc Bal     : "+resultSet.getDouble(7));
			System.out.println("\n ````````````````````````````````````````````````` \n");
		}
		connection.close();
		
		
	
}

public void saveAcc(Account ac) throws Exception {

	    Connection connection = getConnection();
		
		String query = "Insert into account(acname,acadd,acphone,acpan,acpin,acbal,accountNumber) values(?,?,?,?,?,?,?)";
		
		PreparedStatement preparedstatement = connection.prepareStatement(query);
        preparedstatement.setString(1, ac.getName()); 
        preparedstatement.setString(2, ac.getAddress());
        preparedstatement.setLong(3, ac.getContact());
        preparedstatement.setString(4, ac.getPan());
        preparedstatement.setInt(5, ac.getPin());
        preparedstatement.setDouble(6, ac.getBalance());
        preparedstatement.setInt(7, ac.accountNumber);
        
        int result = preparedstatement.executeUpdate();
		 if(result!=0)
		 {
			 System.out.println("Account data saved successfully");
		 }else {
			 System.out.println("Unable to save the account data");
		 }
		 connection.close();
}

public int getPin(int accountnumber) throws Exception {
	    
	
	    Connection connection = getConnection();
	
	    PreparedStatement preparedstatement = connection.prepareStatement("Select acpin from account where accountnumber = ?");
	    
	    preparedstatement.setInt(1, accountnumber);
	    ResultSet resultSet = preparedstatement.executeQuery();
		 
	    if(resultSet.next()) 
		 {
			 
			      return resultSet.getInt("acpin");
			 
		 }else {
			 System.out.println("Invalid Account Number");
		 }
		connection.close();
	
	return -1;
}

public double getBal(int accountnumber) throws Exception {
	
	 Connection connection = getConnection();
		
	    PreparedStatement preparedstatement = connection.prepareStatement("Select acbal from account where accountnumber = ?");
	    
	    preparedstatement.setInt(1, accountnumber);
	    ResultSet resultSet = preparedstatement.executeQuery();
		 
	    if(resultSet.next()) 
		 {
			 
			      return resultSet.getDouble("acbal");
			 
		 }else {
			 System.out.println("Invalid Account Number");
		 }
		connection.close();
	
	return -1;
}

public void updateName(String name, int accountnumber) throws Exception {

		 Connection connection = getConnection();
			
		    PreparedStatement preparedstatement = connection.prepareStatement("update account set acname =? where accountNumber = ?");
		    
		    preparedstatement.setString(1, name);
		    preparedstatement.setInt(2, accountnumber);
		    int ra = preparedstatement.executeUpdate();
			 
		    if(ra==1) 
			 {
				 
				      System.out.println(ra+" Row affected");
				 
			 }else {
				 System.out.println("Invalid Account Number");
			 }
			connection.close();
	
}

public void updateAdd(String add, int accountnumber) throws Exception {

		
		
		Connection connection = getConnection();
		
	    PreparedStatement preparedstatement = connection.prepareStatement("update account set acadd = ? where accountNumber = ?");
	    
	    preparedstatement.setString(1, add);
	    preparedstatement.setInt(2, accountnumber);
	    int ra = preparedstatement.executeUpdate();
		 
	    if(ra==1) 
		 {
			 
			      System.out.println(ra+" Row affected");
			 
		 }else {
			 System.out.println("Invalid Account Number");
		 }
		connection.close();
	
}
	
public void updateContact(long phone, int accountnumber) throws Exception {

		
	Connection connection = getConnection();
	
    PreparedStatement preparedstatement = connection.prepareStatement("update account set acphone =? where accountNumber = ?");
    
    preparedstatement.setLong(1, phone);
    preparedstatement.setInt(2, accountnumber);
    int ra = preparedstatement.executeUpdate();
	 
    if(ra==1) 
	 {
		 
		      System.out.println(ra+" Row affected");
		 
	 }else {
		 System.out.println("Invalid Account Number");
	 }
	connection.close();
		
}

public void updatePin(int pin, int accountnumber) throws Exception {

    Connection connection = getConnection();
	
    PreparedStatement preparedstatement = connection.prepareStatement("update account set acpin =? where accountNumber = ?");
    
    preparedstatement.setInt(1, pin);
    preparedstatement.setInt(2, accountnumber);
    int ra = preparedstatement.executeUpdate();
	 
    if(ra==1) 
	 {
		 
		      System.out.println(ra+" Row affected");
		 
	 }else {
		 System.out.println("Invalid Account Number");
	 }
	connection.close();
	
}

public void updateBal(double acbal,int accountnumber) throws Exception {

	Connection connection = getConnection();
	
    PreparedStatement preparedstatement = connection.prepareStatement("update account set acbal =? where accountNumber = ?");
    
    preparedstatement.setDouble(1, acbal);
    preparedstatement.setInt(2, accountnumber);
    int ra = preparedstatement.executeUpdate();
	 
    if(ra==1) 
	 {
		 
		      System.out.println(ra+" Row affected");
		 
	 }else {
		 System.out.println("Invalid Account Number");
	 }
	connection.close();
	
}

//public void displayAcc() throws Exception {
//	
//		ResultSet resultSet = statement.executeQuery("select * from account");
//		System.out.println("`````````` Account Holder Details `````````\n");
//		while(resultSet.next()){
//			System.out.println(  "\t Acc No.     : "+resultSet.getInt(1)+"\n\t Acc Name    : "+resultSet.getString(2)+"\n\t Acc Add.    : "+resultSet.getString(3)+"\n\t Acc Contact : "+resultSet.getString(4)+"\n\t Pan No.     : "+resultSet.getString(5)+"\n\t UID No.     : "+resultSet.getString(6)+"\n\t Acc Pin     : "+resultSet.getInt(7)+"\n\t Acc Bal     : "+resultSet.getDouble(8)  );
//			System.out.println("\n ````````````````````````````````````````````````` \n");
//		}
//
//}


}
