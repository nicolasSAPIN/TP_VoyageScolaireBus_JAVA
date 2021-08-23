package fr.epsi.tp.voyage.BLL;

import java.util.ArrayList;
import java.util.List;

import fr.epsi.tp.voyage.BO.Bus;
import fr.epsi.tp.voyage.BO.ClasseEcole;
import fr.epsi.tp.voyage.BO.Eleve;
import fr.epsi.tp.voyage.BO.GroupeEleve;
import fr.epsi.tp.voyage.BO.Personne;
import fr.epsi.tp.voyage.BO.Prof;
/**
 *  @author nicolas Sapin
 * @Class VoyageManager
 */
public class VoyageManager {
	private static List<Eleve> lstEleve = new ArrayList<Eleve>();
	private static List<Prof> listProfs =new ArrayList<Prof>();
	private static List<ClasseEcole> lstclasseEcole = new ArrayList<ClasseEcole>();//liste des eleves dans la classe
	private static List<Eleve> lstEleveClasseEcole = new ArrayList<Eleve>();//liste des eleves dans le groupe
	private static List<GroupeEleve> lstGroupeEleves = new ArrayList<GroupeEleve>();// Liste de groupes d'eleves (nbr de Groupe <=11) et (1 groupe =  1prof + X eleves)
	private static List<Eleve> lstEleveGroupe = new ArrayList<Eleve>();//liste des eleves dans le groupe
	private static List<Bus> lstBus = new ArrayList<Bus>();//liste des bus
	private static List<Personne> lstPassagers = new ArrayList<Personne>();//listes des passagers
	/**
	 * @param eleve add eleve to lstEleve
	 */
	public static void addEleve(Eleve e) {
		lstEleve.add(e);
	}
	/**
	 * @param Prof add Prof to listProf
	 */
	public static void addProf(Prof p) {
		listProfs.add(p);
	}
	/**
	 * @param ClasseEcole ce
	 * Ajoute une classe dans la liste des classes
	 **/
	
	public static void addClasseEleve(ClasseEcole ce) {
		lstclasseEcole.add(ce);
	}
	/**
	 *  @param ClasseEcole
	 * @param e
	//Ajoute un eleves dans une Classe (la liste d'eleve d'un groupe)
	//public static void addEleveClasse( ClasseEcole ClasseEcole, Eleve e) {
		ClasseEcole.lstEleve.add(e);
		}
		 */
	/**
	 * @param GroupeEleve Gr
	 */
	// Ajoute un groupe d'eleves dans la liste des groupes
	public static void  addGroupEleves(GroupeEleve Gr) {
		lstGroupeEleves.add(Gr);
	}
	/**
	 * @param Bus b
	 * Ajoute un bus dans la liste des bus
	 */
	public static  void addBus(Bus b) {
			lstBus.add(b);
	}

	public static void addPassagerBus( Personne p, Bus b) throws GestionException {
		if(b.lstPassagers.size()>= b.getNbrPlacesMax()) {
			throw new GestionException("Le bus est plein "+ p.getPrenom()+" "+p.getNom()+" ne peux pas partir");
		}
		else {lstPassagers.add(p);	}
	}
	
	/**
	//LES GETTERS

	 * @return the lstEleve
	 */
	public static List<Eleve> getLstEleve() {
		return lstEleve;
	}
	/**
	 * @return the listProfs
	 */
	public static List<Prof> getListProfs() {
		return listProfs;
	}
	/**
	 * @return the lstclasseEcole
	 */
	public static List<ClasseEcole> getlstClasseEcole() {
		return lstclasseEcole;
	}
	/**
	 * 
	 * @return lstEleveClasseEcole
	 */
	public static List<Eleve> getlstEleveClasseEcole() {
		return lstEleveClasseEcole;
	}
	/**
	 * @return the lstGroupeEleves
	 */
	public static List<GroupeEleve> getLstGroupeEleves() {
		return lstGroupeEleves;
	}
	/**
	 * @return the lstEleveGroupe liste des eleves d'un groupe
	 */
	public static List<Eleve> getLstEleveGroupe() {
		return lstEleveGroupe;
	}
	/**
	 * @return the lstBus
	 */
	public static List<Bus> getLstBus() {
		return lstBus;
	}
	/**
	 * @return the lstPassagers
	 */
	public static List<Personne> getLstPassagers() {
		return lstPassagers;
	}
	/**
	 * @return the nbrPlacesMax
	 */
	
	//Les SETTERS
	/**
	 * @param lstEleve the lstEleve to set
	 */
	public static void setLstEleve(List<Eleve> lstEleve) {
		VoyageManager.lstEleve =lstEleve;
	}
	/**
	 * @param listProfs the listProfs to set
	 */
	public static void setListProfs(List<Prof> listProfs) {
		VoyageManager.listProfs = listProfs;
	}
	/**
	 * @param classeEcole the lstclasseEcole to set
	 */
	public static void setsltClasseEcole(List<ClasseEcole> classeEcole) {
		VoyageManager.lstclasseEcole = classeEcole;
	}
	public static void setLstEleveClasseEcole(List<Eleve> lstEleveClasseEcole) {
		VoyageManager.lstEleveClasseEcole = lstEleveClasseEcole;
	}
	/**
	 * @setLstGroupeEleves
	 * @param lstGroupeEleves the lstGroupeEleves to set
	 * 
	 */
	public static void setLstGroupeEleves(List<GroupeEleve> lstGroupeEleves) {
		VoyageManager.lstGroupeEleves = lstGroupeEleves;
	}
	/**
	 * @setLstEleveGroupe
	 * @param lstEleveGroupe the lstEleveGroupe to set
	 */
	public static void setLstEleveGroupe(List<Eleve> lstEleveGroupe) {
		VoyageManager.lstEleveGroupe = lstEleveGroupe;
	}
	/**
	 * @setLstBus
	 * @param lstBus the lstBus to set
	 */
	public static void setLstBus(List<Bus> lstBus) {
		VoyageManager.lstBus = lstBus;
	}
	/**
	 * @setLstPassagers
	 * @param lstPassagers the lstPassagers to set
	 */
	public static void setLstPassagers(List<Personne> lstPassagers) {
		VoyageManager.lstPassagers = lstPassagers;
	}
	/**
	 * @afficherEleves
	 *  Affiche un Eleve
	 */
	public static String afficherEleves() {
		StringBuffer result = new StringBuffer();
		result.append("---------------------------------------------------").append("\n");
		result.append("Liste des Eleves:------------------------------").append("\n");
		for (Eleve  eleve : getLstEleve()) {
			result.append("----"+eleve.getPrenom()+" "+eleve.getNom()+"\n");
		}
		result.append("---------------------------------------------------");
		return result.toString();
	}
	/**
	 * @afficherProfs
	 *  Affiche liste des profs
	 */
	public static String afficherProfs() {
		StringBuffer result = new StringBuffer();
		result.append("---------------------------------------------------").append("\n");
		result.append("Liste des Profs:------------------------------").append("\n");
		for (Prof prof : getListProfs()) {
			result.append("----"+prof.getPrenom()+" "+prof.getNom()+"\n");
		}
		result.append("-------------------------------------------------- \n");
		return result.toString();
	}
	/**
	 *  @afficherLstClassesEcole
	 *   Affiche liste des classes d'école
	 * & Le nom de la classe
	 * & La liste des profs et des eleves
	 */
	public static String afficherLstClassesEcole() {
		StringBuffer result = new StringBuffer();
		result.append("---------------------------------------------------").append("\n");
		result.append("Liste des Classes:\n--------------------").append("\n");
		for (ClasseEcole classeEcole : getlstClasseEcole()) {
			System.out.println("");
			result.append("Classe "+ classeEcole.getNom() +":\n--------------------").append("\n");
			for(Prof prof : classeEcole.getLstProf()) {
				result.append("Prof : "+prof.getPrenom()+" "+prof.getNom()).append("\n");
			}
			result.append("\n--------------------\n").append("\n");
			
			for(Eleve eleve : classeEcole.getLstEleve()) {
				result.append("Eleve : "+eleve.getPrenom()+" "+eleve.getNom()).append("\n");
			}
			result.append("\n--------------------\n").append("\n");
		}
		return result.toString();
	}
	/**
	 * 
	 * @lstEleveClasseEcole
	 *  Affiche les infos d un bus et la liste de ses passagers: 	
	 * & Détail si prof ou eleve + nom, prenom
	 */
	public static  String afficherPassagers() {
		StringBuffer result = new StringBuffer();
		result.append("---------------------------------------------------").append("\n");
		result.append("Liste des passagers:\n--------------------").append("\n");
		for (Personne personne : getLstPassagers()) {
			if(personne instanceof Prof) {System.out.println("Prof: "+personne.getPrenom()+" "+personne.getNom()+"\n"); }
			if(personne instanceof Eleve) {System.out.println("----Eleve:"+personne.getPrenom()+" "+personne.getNom()+"\n");}
		}
		result.append("---------------------------------------------------");
		//result.append("Numeros des groupes présents dans le bus:\n--------------------").append("\n");
		//for (GroupeEleve groupeEleve : getLstGroupeEleves()) {System.out.println("----groupe:"+groupeEleve.getNumGroupe()+",");}
		result.append("Nom des classes présentes dans le bus:\n--------------------").append("\n");
		for (ClasseEcole classeEcole : getlstClasseEcole()) {System.out.println("----Classe:"+classeEcole.getNom()+",");}
		return result.toString();
	}
	/**
	 *  @afficherGroupEleve
	 *   Affiche un groupe d'eleves: numero du groupe 
	 * & Professeur responsable
	 * & Eleves:nom, prenom
	 */
	public static String afficherGroupEleve() {
		StringBuffer result = new StringBuffer();
		result.append("Liste des groupes:\n--------------------").append("\n");
		for (GroupeEleve  groupeEleve : getLstGroupeEleves()) {
			result.append("Groupe numero : ").append(groupeEleve.getNumGroupe()).append("\n--------------------\n");
			result.append("Professeur responsable : ").append(groupeEleve.getProfResponsable()).append("\n--------------------\n");
			result.append("Eleves du groupe:").append("\n--------------------\n");
			for(Eleve eleve : groupeEleve.getLstEleveGroupe()) {
				result.append("----"+eleve.getPrenom()+" "+eleve.getNom()+",\n");
			}
		}
		return result.toString();
	}
	/** 
	 * @afficherTTGroupEleve
	 *  Affiche tout les groupes: numero du groupe 
	 * & Professeur responsable
	 * & Eleves:nom, prenom 
	 */
	public static String afficherTTGroupEleve() {
		StringBuffer result = new StringBuffer();
		result.append("---------------------------------------------------").append("\n");
		result.append("Liste des Groupes d'eleves:-------------------------").append("\n");
		result.append("---------------------------------------------------").append("\n");
		for (GroupeEleve  groupeEleve : getLstGroupeEleves()) {
			result.append("Groupe numero : ").append(groupeEleve.getNumGroupe()).append("\n");
			result.append("Professeur responsable : ").append(groupeEleve.getProfResponsable()).append("\n");
			result.append("Eleves du groupe:------------------------------").append("\n");
			for (Eleve  eleve : getLstEleveGroupe()) {
					System.out.println("----"+eleve.getPrenom()+" "+eleve.getNom()+",\n");
			}
			result.append("------------------------------------------------ \n");
		}
		return result.toString();	
	}
	/**
	 * @afficherlistBus
	 * Affiche la liste des bus et de leurs passagers 
	 */
	public static String afficherlistBus() {
		
		StringBuffer result = new StringBuffer();
		result.append("");
		result.append("Liste des Bus:\n------------------------------").append("\n");
		for (Bus bus : getLstBus()) {
			result.append("");
			result.append("Liste des passagers du Bus n° "+bus.getNumBus()+" :\n--------------------").append("\n");
			
			for (Personne personne : bus.getLstPassagers()) {
				if(personne instanceof Prof) {result.append("Bus n° "+bus.getNumBus()+"-(Prof) "+personne.getPrenom()+" "+personne.getNom()+"\n"); }
				if(personne instanceof Eleve) {result.append("Bus n° "+bus.getNumBus()+"----(Eleve) "+personne.getPrenom()+" "+personne.getNom()+"\n");}
			}
		}
		return result.toString();
	}
}
