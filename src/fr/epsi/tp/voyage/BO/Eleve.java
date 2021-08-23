package fr.epsi.tp.voyage.BO;
/**
 * 
 * @author nicos
 *
 */
public class Eleve extends Personne{
	//Variables
	private String nom;
	private String prenom;
	private String  nomClasse;
	
	//Constructeurs
	/**
	 * 
	 */
	public Eleve() {
		super();
	}
	/**
	 * 
	 * @param nom
	 * @param prenom
	 */
	public Eleve(String nom, String prenom) {
		super(nom, prenom);
	}
	/**
	 * 
	 * @param nom
	 * @param prenom
	 * @param nomClasse
	 */
	public Eleve(String nom, String prenom, String nomClasse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.nomClasse = nomClasse;
	}
	//Getters & Setters
	
	/**
	 * 
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * 
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * @return the nomClasse
	 */
	public String getNomClasse() {
		return nomClasse;
	}
	
	/**
	 * @return the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * @return the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @param nomClasse the nomClasse to set
	 */
	public void setNomClasse(String nomClasse) {
		this.nomClasse = nomClasse;
	}
		/**
	 * 	@Override
	 *
	 */
	public String toString() {
		return "Eleve [" + nom + " " +prenom+" "+nomClasse+" ]";
	}
}