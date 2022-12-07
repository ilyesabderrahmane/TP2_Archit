
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EtdR implements EtudiantRepository{
	
	IJournal journal = new DiffOutJ("efd"); // e: pour ecran  f: pour fichier;
	
	public void add(Etudiant E) throws SQLException{

		DBConnection BD = DBConnection.getDB();
		Connection connect = BD.getConn();
		
		Statement stmt = connect.createStatement();
		String sql = "INSERT into etudiant values (" + E.getMatricule() + ",'" + E.getNom() + "','" + E.getPrenom() + "','" + E.getEmail() + "','" + E.getPwd() + "'," +E.getNbLivreMensuel_Autorise() + "," +E.getNbLivreEmprunte() + "," +E.getId_universite()+")";
		int rs = stmt.executeUpdate(sql);
		
		if (rs == 1){
				journal.outPut_Msg("ajout dans la BD reussi de l'etudiant  du Matricule" + E.getMatricule());
			}else if (rs == 0){
				journal.outPut_Msg("Echec de l'ajout dans la BD de l'etudiant  du Matricule" + E.getMatricule());
			}
		connect.close();
	 }


	public boolean Exists(String email) throws SQLException{
		DBConnection BD = DBConnection.getDB();
		Connection connect = BD.getConn();
		
		Statement stmt = connect.createStatement();
		String sql = "select * from etudiant where email='"+ email+"'";
		boolean rs = stmt.execute(sql);
		
		if (rs){
			journal.outPut_Msg("email existe dans la BD  " + email);
			connect.close();
			return true;
			}
		journal.outPut_Msg("email n'existe pas " + email);	
		connect.close();
		return false;
	}
	
	public boolean Exists(int mat) throws SQLException{
		DBConnection BD = DBConnection.getDB();
		Connection connect = BD.getConn();
		
		Statement stmt = connect.createStatement();
		String sql = "select * from etudiant where matricule="+ mat;
		boolean rs = stmt.execute(sql);
		
		if (rs){
			journal.outPut_Msg("etudiant avec ce matricule existe deja dans la BD  " + mat);
			connect.close();
			return true;
			}
		journal.outPut_Msg("etudiant avec ce matricule n'existe pas " + mat);	
		connect.close();
		return false;
	}

	
	public void addAllStudNbrLivre(int nbrAjout){
		
		try {
			DBConnection BD = DBConnection.getDB();
			Connection connect = BD.getConn();
			
			Statement stmt = connect.createStatement();
			String sql = "SELECT matricule, nbLivreMensuel_Autorise FROM etudiant WHERE nbLivreMensuel_Autorise != 0";
			ResultSet rs = stmt.executeQuery(sql);

			if(rs.isBeforeFirst()){
				rs.next();
				while(!rs.isAfterLast()){
					sql = "UPDATE Customers SET nbLivreMensuel_Autorise = " + Integer.toString(rs.getInt(2) + nbrAjout) + " WHERE maticule = " + rs.getString(1);
					rs.next();
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}