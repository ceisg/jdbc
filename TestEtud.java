package jdbc;



public class TestEtud {

	public static void main(String[] args) {
	
		
		for(Etudiant e : EtudiantDB.getAll())
			System.out.println(e.toString()) ; 
		
		
	}

}
