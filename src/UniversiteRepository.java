
import java.sql.SQLException;



public interface UniversiteRepository {	
	univer GetById(int universityId) throws SQLException;
	
}