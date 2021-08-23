package fr.epsi.tp.voyage.BO;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author nicos
 *
 */
public class Prof extends Personne{
	//Variables
	private String nom;
	private String prenom;
	private String nomClasse;
	//private List<Eleve> lstEleve = new ArrayList<Eleve>();
	
	
	
	//Constructeurs
	/**
	 * Default
	 */
	public Prof() {
		super();
	}
	/**
	 * 
	 * @param nom
	 * @param prenom
	 */
	public Prof(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	/**
	 * 
	 * @param nom
	 * @param prenom
	 * @param nomClasse
	 */
	public Prof(String nom, String prenom, String nomClasse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.nomClasse = nomClasse;
	}
	//Getters & Setters
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	
	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	/**
	 * @return the nomClasse
	 */
	public String getNomClasse() {
		return nomClasse;
	}
	
	/**
	 * @param nomClasse the nomClasse to set
	 */
	public void setNomClasse(String nomClasse) {
		this.nomClasse = nomClasse;
	}

	
	@Override
	public String toString() {
		return "Prof : " + nom + " " + prenom + " .";
	}
}