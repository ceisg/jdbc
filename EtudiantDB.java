package jdbc;

import java.sql.*;
import java.util.ArrayList;



public class EtudiantDB {

	
	//----------------------------------------------getConnection()----------------------------------------------------------------
	
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
	
	//-----------------------------------------------getAll()---------------------------------------------------------------
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
	//--------------------------------------------------------ajouter(Etudiant e)------------------------------------------------------
	public static void ajouter(Etudiant e) {
		Connection cn = getConnection();
		PreparedStatement ps;
		
		try {
			ps = cn.prepareStatement("insert into etudiants(nom,prenom,email) values(?,?,?)");

			
			ps.setString(1, e.getNom());
			ps.setString(2, e.getPrenom());
			ps.setString(3, e.getEmail());
			
			ps.executeUpdate();

			cn.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}
	//----------------------------------------------------getById(int id)----------------------------------------------------------
	public static Etudiant getById(int id) {
		Connection cn = getConnection();
		PreparedStatement ps;
		Etudiant etud = null;
		try {
			ps = cn.prepareStatement("select * from etudiants where id =?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			rs.next();
			etud = new Etudiant(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return etud;

	}
//------------------------------------------------------supprimer(int id)--------------------------------------------------------
	public static void supprimer(int id) {

		Connection cn = getConnection();
		PreparedStatement ps;
		try {
			ps = cn.prepareStatement("delete from etudiants where id=?");

			ps.setInt(1, id);

			ps.executeUpdate();

			cn.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}


	
	
}
