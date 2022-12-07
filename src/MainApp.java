
public class MainApp {

	public static void main(String[] args) {

		int matricule = 2;
		String nom = "Guendouziiiii";
		String prenom = "wassila";
		String email = "guen@gmail.com";
		String passcode = "xxxx";
		int univId = 1;

		EtudiantService serv = new EtudiantService();
		EtudiantRepository repo = new EtdR();
		UniversiteRepository UnivRepo = new univer();

		try {
			Universite uni = UnivRepo.GetById(univId);
			if(uni != null) {
				Etudiant stud = new Etd(matricule, nom, prenom, email, passcode, univId, uni.getPack());
				serv.inscription(repo, UnivRepo, uni, stud, email, matricule);
			}

			repo.addAllStudNbrLivre(5);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}