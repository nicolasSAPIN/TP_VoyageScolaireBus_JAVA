package fr.epsi.tp.voyage.BO;

import java.util.ArrayList;
import java.util.List;


/**
 * @ClassEcole
 * 		Classe d'école
 * @constructor
 *  	ClasseEcole();
 *  	ClasseEcole(String nomclasse);
 * 		ClasseEcole(String nom, Integer nbrElevesClasse, Integer nbrProfsClasse) ;
 * 		ClasseEcole(String nom, List<Eleve> lstEleve, List<Prof> lstProf);
 * */
/**
 * 
 * @author nicos
 *
 */
public class ClasseEcole {
	
	//Variables
	/**
	 * 
	 */
	private String nom;
	private Integer nbrElevesClasse=0;
	private Integer nbrProfsClasse=0;
	public  List<Prof> lstProf =new ArrayList<Prof>();// Liste des Profs de la class
	public List<Eleve> lstEleve = new ArrayList<Eleve>(); //Liste des eleves de la classe

	//Constructeurs
	/**
	 * 
	 */
	public ClasseEcole() {
		super();
	}
	//Getters & Setters
	/**
	 * 
	 * @param nomclasse
	 */
	public ClasseEcole(String nomclasse) {
		// TODO Auto-generated constructor s
		super();
		this.nom = nomclasse;
	}
	/**
	 * @param nom
	 * @param lstEleve
	 * @param lstProf
	 */
	public ClasseEcole(String nom, List<Eleve> lstEleve, List<Prof> lstProf) {
		super();
		this.nom = nom;
		this.lstProf = lstProf;
		this.lstEleve = lstEleve;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @return the lstEleve
	 */
	public List<Eleve> getLstEleve() {
		return lstEleve;
	}
	/**
	 * @param lstEleve the lstEleve to set
	 */
	public void setLstEleve(List<Eleve> lstEleve) {
		this.lstEleve = lstEleve;
	}
	
	/**
	 * @return the nbrElevesClasse
	 */
	public Integer getNbrElevesClasse() {
		return nbrElevesClasse;
	}

	/**
	 * @param nbrElevesClasse the nbrElevesClasse to set
	 */
	public void setNbrElevesClasse(Integer nbrElevesClasse) {
		this.nbrElevesClasse = nbrElevesClasse;
	}

	/**
	 * @return the nbrProfsClasse
	 */
	public Integer getNbrProfsClasse() {
		return nbrProfsClasse;
	}

	/**
	 * @param nbrProfsClasse the nbrProfsClasse to set
	 */
	public void setNbrProfsClasse(Integer nbrProfsClasse) {
		this.nbrProfsClasse = nbrProfsClasse;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}	
	//---les profs de cette classe
	/**
	 * 
	 * @param prof
	 */
	public  void addProf(Prof prof) {
		this.lstProf.add(prof);
		// TODO Auto-generated method stub
	}
	/**
	 * @return the LstProfs
	 */
	public List<Prof> getLstProf() {
		return lstProf;
	}
	
	/**
	 * @param lstProfs the lstProfs to set
	 */
	public void setLstProf(List<Prof> lstProf) {
		this.lstProf = lstProf;
	}
	
	
	//--- les eleves de cette classe
	/**
	 * 
	 * @param eleve
	 */
	public  void addEleve(Eleve eleve) {
		this.lstEleve.add(eleve);
	}
	
	@Override
	public String toString() {
		return "ClasseEcole [nom=" + nom + ", nbrElevesClasse=" + nbrElevesClasse + ", nbrProfsClasse=" + nbrProfsClasse
				+ ", lstProf=" + lstProf + ", lstEleve=" + lstEleve + "]";
	}
	
	/**
	 * 
	 * @// Affiche la classe: liste des profs et des eleves
	 */
	public  String afficherClasseEcole() {
		StringBuffer result = new StringBuffer();
		result.append("---------------------------------------------------").append("\n");
		result.append("Classe").append(this.getNom()).append("\n");
		result.append("Liste des Profs:\n--------------------").append("\n");
		for (Prof prof : this.getLstProf()) {
			result.append("----Prof: "+prof.getPrenom()+" "+prof.getNom()+"\n");
			//on pourait faire aussi prof.toString a la place de prenom nom? A Verifier 
		}
		result.append("Liste des Eleves:\n--------------------").append("\n");
		for (Eleve  eleve : this.getLstEleve()) {
			result.append("----Eleve: "+eleve.getPrenom()+" "+eleve.getNom()+"\n");
		}
		return result.toString();
	}
}
