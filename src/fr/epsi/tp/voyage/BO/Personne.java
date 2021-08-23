package fr.epsi.tp.voyage.BO;

import java.util.ArrayList;
import java.util.List;

import fr.epsi.tp.voyage.BLL.GestionException;

/**
 * 
 * @author nicos
 *
 */
public abstract class Personne {
	private static List<Personne> lstPassagers = new ArrayList<Personne>();
	private String nom;
	private String prenom;
	/**
	 * 
	 */
	public Personne() {
	}
	/**
	 * 
	 * @param nom
	 * @param prenom
	 */
	public Personne(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	/**
	 * 
	 * @return
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * 
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * 
	 * @return
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * 
	 * @param prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * 
	 * @param p
	 * @throws BusException
	 */
	//Ajoute un passager dans la liste des passagers DU bus
	public  void addPassager( Personne p) {
	 lstPassagers.add(p);
	}
	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + "]";
	}
}