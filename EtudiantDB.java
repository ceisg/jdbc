package jdbc;

import java.sql.*;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

public class EtudiantDB {

	
	
	
	public static Connection getConnection() {
		
		Connection cn =null ; 
		
		
		try {
			////cn = DriverManager.getConnection("jdbc:ucanaccess://d:/etudiants.accdb");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "") ;
		} catch (SQLException e) {
		
			e.printStackTrace();
		} 
		
	return cn ; 	
		
	}
	
	
	public static ArrayList<Etudiant> getAll() {
		Connection cn = getConnection() ; 
		ArrayList<Etudiant> liste = new ArrayList<Etudiant>();
		
		
		
		try {
			Statement st = cn.createStatement();
			ResultSet rs =  st.executeQuery("select * from etudiants") ; 
			while (rs.next()) {
				
				liste.add(new Etudiant(rs.getInt(1), rs.getString(2), rs.getString(3))) ; 
				
			}
			
			cn.close();
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return liste;
		
		
	}
	
	
	
	
	
}
