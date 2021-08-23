package fr.epsi.tp.voyage.BO;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 * 
 * @author nicos
 * 
 *
 */
public class GroupeEleve {
	//Variables
	public Prof profResponsable;
	private Integer numGroupe=0;
	public List<Eleve> lstEleveGroupe = new ArrayList<Eleve>();//liste d'éléve au sein du groupe d'élève
	//Constructeurs
	/**
	 * 
	 */
	public GroupeEleve() {
		super();
	}
	public GroupeEleve(Prof profResponsable, Integer numGroupe, List<Eleve> lstEleveGroupe) {
		super();
		this.profResponsable = profResponsable;
		this.numGroupe = numGroupe;
		this.lstEleveGroupe = lstEleveGroupe;
	}
	//Getters & Setters
	/**
	 * @return the profResponsable
	 */
	public Prof getProfResponsable() {
		return profResponsable;
	}
	/**
	 * @param profResponsable the profResponsable to set
	 */
	public void setProfResponsable(Prof profResponsable) {
		this.profResponsable = profResponsable;
	}
	/**
	 * @return the numGroupe
	 */
	public Integer getNumGroupe() {
		return numGroupe;
	}
	/**
	 * @param numGroupe the numGroupe to set
	 */
	public void setNumGroupe(Integer numGroupe) {
		this.numGroupe = numGroupe;
	}
	/**
	 * @return the lstEleveGroupe
	 */
	public List<Eleve> getLstEleveGroupe() {
		return lstEleveGroupe;
	}
	/**
	 * @param lstEleveGroupe the lstEleveGroupe to set
	 */
	public void setLstEleveGroupe(List<Eleve> lstEleveGroupe) {
		this.lstEleveGroupe = lstEleveGroupe;
	}
	/**
	 * 
	 * @param e
	 */
	public void addEleve(Eleve e) {
		lstEleveGroupe.add(e);
	}
	@Override
	public String toString() {
		return "GroupeEleve [profResponsable=" + profResponsable + ", numGroupe=" + numGroupe + ", lstEleveGroupe="
				+ lstEleveGroupe + "]";
	}
	/**
	 * 
	 * @return
	 */
	public String afficherGroupEleve() {// Affiche un groupe
		StringBuffer result = new StringBuffer();
		result.append("---------------------------------------------------").append("\n");
		result.append("Groupe numero : ").append(this.getNumGroupe()).append("\n");
		result.append("Professeur responsable : ").append(this.getProfResponsable()).append("\n");
		result.append("Eleves du groupe:------------------------------").append("\n");
		for (Eleve  eleve : getLstEleveGroupe()) {System.out.println("----"+eleve.getPrenom()+" "+eleve.getNom()+",");}
		result.append("---------------------------------------------------");
		return result.toString();
	}
}