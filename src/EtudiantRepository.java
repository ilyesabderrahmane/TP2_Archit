import java.sql.SQLException;

public interface EtudiantRepository {
  void add(Etudiant E) throws SQLException;
  boolean Exists(String email) throws SQLException;
  boolean Exists(int mat) throws SQLException;
  void addAllStudNbrLivre(int nbrAjout);
}