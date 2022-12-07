public class Etd implements Etudiant{
  
  private int matricule;
  private String nom;
  private String prenom;
  private String email ;
  private String pwd;
  private int nbLivreMensuel_Autorise;
  private int nbLivreEmprunte;
  private int id_universite;  
 
  public Etd(int matricule, String nom, String prenom, String email,String pwd, int id_universite, TypePackage Pack) {
    
    this.matricule = matricule;
    this.nom = nom;
    this.prenom = prenom;
    this.email = email;
    this.pwd = pwd;
    this.id_universite = id_universite;
    
		if (Pack == TypePackage.Standard){
	    nbLivreMensuel_Autorise = 10;
		}else if (Pack == TypePackage.Premium){
	    nbLivreMensuel_Autorise = 10*2;
	  }

  }

  public void addNbrLivre(int nbrAjout){
    nbLivreMensuel_Autorise = nbLivreMensuel_Autorise + nbrAjout;
  }


  public int getMatricule() {
    return matricule;
  }


  public void setMatricule(int matricule) {
    this.matricule = matricule;
  }


  public String getNom() {
    return nom;
  }


  public void setNom(String nom) {
    this.nom = nom;
  }


  public String getPrenom() {
    return prenom;
  }


  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }


  public String getEmail() {
    return email;
  }


  public void setEmail(String email) {
    this.email = email;
  }


  public int getNbLivreMensuel_Autorise() {
    return nbLivreMensuel_Autorise;
  }


  public void setNbLivreMensuel_Autorise(int nbLivreMensuel_Autorise) {
    this.nbLivreMensuel_Autorise = nbLivreMensuel_Autorise;
  }


  public int getNbLivreEmprunte() {
    return nbLivreEmprunte;
  }


  public void setNbLivreEmprunte(int nbLivreEmprunte) {
    this.nbLivreEmprunte = nbLivreEmprunte;
  }


  public int getId_universite() {
    return id_universite;
  }


  public void setId_universite(int id_universite) {
    this.id_universite = id_universite;
  }


  public String getPwd() {
    return pwd;
  }


  public void setPwd(String pwd) {
    this.pwd = pwd;
  }

}