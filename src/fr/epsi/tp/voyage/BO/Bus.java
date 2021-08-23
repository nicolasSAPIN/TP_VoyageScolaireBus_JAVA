package fr.epsi.tp.voyage.BO;
import java.util.ArrayList;
import java.util.List;
import fr.epsi.tp.voyage.BLL.GestionException;
/**
 *  
 * @author nicos
 *
 * */
public class Bus {
	//Variables
	private Integer numBus;
	private  Integer nbrPlacesMax;
	public List<Personne> lstPassagers = new ArrayList<Personne>();
	List<ClasseEcole> lstClassesEleve = new ArrayList<ClasseEcole>();
	List<GroupeEleve> lstGroupeEleve = new ArrayList<GroupeEleve>();
	//Constructeurs
	/**
	 * 
	 */
	public Bus() {
		super();
	}
	/**
	 * @constructor Bus() 
	 * @param numBus
	 * @param nbrPlacesMax
	 */
	public Bus(Integer numBus, Integer nbrPlacesMax) {
		super();
		this.numBus = numBus;
		this.nbrPlacesMax = nbrPlacesMax;
	}
	/**
	 * @constructor Bus()
	 * @param numBus
	 * @param nbrPlacesMax
	 * @param lstPassagers
	 */
	public Bus(Integer numBus, Integer nbrPlacesMax, List<Personne> lstPassagers) {
		super();
		this.numBus = numBus;
		this.nbrPlacesMax = nbrPlacesMax;
		this.lstPassagers = lstPassagers;
	}
	//Getters & Setters
	/**
	 * @return the nomBus
	 */
	public  Integer getNumBus() {
		return numBus;
	}
	/**
	 * @param nomBus the nomBus to set
	 */
	public void setNumBus(Integer nomBus) {
		this.numBus = nomBus;
	}
	/**
	 * @return the nbrPlacesMax
	 */
	public Integer getNbrPlacesMax() {
		return nbrPlacesMax;
	}
	/**
	 * @param nbrPlacesMax the nbrPlacesMax to set
	 */
	public void setNbrPlacesMax(Integer nbrPlacesMax) {
		this.nbrPlacesMax = nbrPlacesMax;
	}
	//---Les passagers de d'UN bus 
	/**
	 * @return the lstPassagers
	 */
	public List<Personne> getLstPassagers() {
		return lstPassagers;
	}
	/**
	 * @param List<Personne> lstPassagers
	 *  the lstPassagers to set
	 */
	public void setLstPassagers(List<Personne> lstPassagers) {
		this.lstPassagers = lstPassagers;
	}
	/**
	 * Ajoute un passager dans la liste des passagers du bus
	 * @param Personne p
	 * @throws BusException
	 */
	
	public void addPassager( Personne p) throws GestionException {
		if(this.lstPassagers.size()>=this.getNbrPlacesMax()) {
			throw new GestionException("Le bus est plein "+ p.getPrenom()+" "+p.getNom()+" ne peux pas partir");
		}
		else {this.lstPassagers.add(p);	}
	}
	/**
	 * 
	 * @param classeEcole
	 */
	
	public void addClasse(ClasseEcole classeEcole) {
		this.lstClassesEleve.add(classeEcole);
	}
	/**
	 * @return the lstClassesEleve
	 */
	public List<ClasseEcole> getLstClassesEleve() {
		return lstClassesEleve;
	}
	/**
	 * @param lstClassesEleve the lstClassesEleve to set
	 */
	public void setLstClassesEleve(List<ClasseEcole> lstClassesEleve) {
		this.lstClassesEleve = lstClassesEleve;
	}
	/**
	 * @return the lstGroupeEleve
	 */
	public List<GroupeEleve> getLstGroupeEleve() {
		return lstGroupeEleve;
	}
	/**
	 * @param lstGroupeEleve the lstGroupeEleve to set
	 */
	public void setLstGroupeEleve(List<GroupeEleve> lstGroupeEleve) {
		this.lstGroupeEleve = lstGroupeEleve;
	}
	/**
	 *  * @return
	 * // Affiche les infos d'UN bus et la liste de ses passagers: eleves et profs 	
	 */
	public String afficherPassagers() {
		StringBuffer result = new StringBuffer();
		result.append("---------------------------------------------------").append("\n");
		result.append("Bus : ").append(this.getNumBus()).append("\n");
		result.append("Liste des passagers:-------------------------------").append("\n");
		for (Personne personne : getLstPassagers()) {
			if(personne instanceof Prof) {System.out.println("Prof: "+personne.getPrenom()+" "+personne.getNom()+","); }
			if(personne instanceof Eleve) {System.out.println("----Eleve:"+personne.getPrenom()+" "+personne.getNom()+",");}
		}
		result.append("Nom des classes présentes dans le bus:-----").append("\n");
		for (ClasseEcole classeEcole : getLstClassesEleve()) {System.out.println("----Classe:"+classeEcole.getNom()+",");}
		//result.append("Numeros des groupes présents dans le bus:--------------------------").append("\n");
		//for (GroupeEleve groupeEleve : getLstGroupeEleve()) {System.out.println("----groupe:"+groupeEleve.getNumGroupe()+",");}
		result.append("---------------------------------------------------");
		return result.toString();
	}
}