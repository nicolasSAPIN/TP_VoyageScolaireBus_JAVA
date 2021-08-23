package fr.epsi.tp.voyage.IHM;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import fr.epsi.tp.voyage.BLL.*;
import fr.epsi.tp.voyage.BO.Bus;
import fr.epsi.tp.voyage.BO.ClasseEcole;
import fr.epsi.tp.voyage.BO.Eleve;
import fr.epsi.tp.voyage.BO.GroupeEleve;
import fr.epsi.tp.voyage.BO.Personne;
import fr.epsi.tp.voyage.BO.Prof;
/** 
 * @Nicolas SAPIN  
 *  C'est cet Exec1 qui est à privilegier
 		 * Voici les fonctionnalités qui doivent être mise en place :
		 *1. saisir de nouveau passagers (profs ou lycéens). Chaque lycéen fait parti d’une classe (qui est
		 *juste une chaîne de caractère).
		 *2 . saisir de nouveaux cars. Un car doit obligatoirement avoir un nombre de places maximum.
		 *3. mettre des passagers dans un car en respectant les règles de gestion (voir plus loin)
		 *4. afficher à l’écran les cars avec leurs passagers
		 *5. vérifier que tous les cars peuvent partir en respectant les règles de gestion (voir plus loin)
		 *Voici les règles de gestion de l’application :
		 *1. un bus ne peut pas prendre plus de passager qu’il n’a de places
		 *2. un car ne peut pas partir s’il n’y a pas au moins un prof pour 10 lycéens maximum
		 *3. il ne peut pas y avoir plus de 3 classes différentes dans un car
		 *4. un car ne part pas à vide (s’il n’y a personne dedans)
		 *5. Un lycéen a obligatoirement un nom de classe
  * */
public class Exec1 {
	private static String[] prenom={"pierre","paul","jacques","emmanuel","manu","numa","toto","roto","polo","marco","Albert","nicolas","Aurélian","Augustino","Gaston","Angelin","Allen","Andoni","Arno","nono","dodo","lolo","popo","coco","vivi","mimil","fred","fredy","pascal","claude","sebastien","regis","serge","quentin","morgan","eddy","guillaume","mickael","magali","celia","helene","tartuf","fabien","famal","titi","rominet","jesus","mathieu","paul","pierre","david","marc" };
	private static String[] nom={"Nadal","sapin","Noel","Janvier","Lenormand", "LeBreton", "Paris", "Zidane", "Henry", "Gates", "neymard","Petit","Loeb","Oreille", "Pinard","Hyde","Jekkil","Jobs","Sharzeneger", "zinzin", "Bergerg","Trump", "Sarkozy", "Hollande", "Chirac", "Mitterand", "DeGaule", "Musso", "DeBussi", "Baudelaire","Hemingway","Daniels", "Rechman", "Carlos" , "DaCosta", "Lecouillard", "DeLapin", "DeLaCoure", "DeMontmirail","Jeanne","Charles","Robert","Malabry", "StaussKan","Merkel","Jones","Bond"};
	private static Eleve lastEleve;
	/**
	 * 
	 * @param args
	 *  
	 */
	public static void main(String[] args) throws GestionException {
	// Saisie des variables
	Integer nbrEleve=0, nbrElevesClasse=0, nbrelevesTot=0, nbrElevebyProf=0;// Variables relatives aux eleves
	Integer nbrProf=0, nbrProfClasse=0, nbrProfClasseMin=0, nbrProfTotalmin=0, nbrprofsTot=0;//Variables relatives aux profs
	Integer nbrClasse=0;// Variables relatives aux classes d'eleves
	String nomClasse="";
	Integer numGroupe=0,nbrGroupbyBus=0;// Variables relatives aux groupes 
	Integer nbrBus=0,numBus=0,nbrPlacesBus=0;//Variables relatives aux bus
	Boolean lastEleveTest= false;
	Integer nbrPassagersTot=0;//et relatives aux passagers du bus
	Scanner sc =new Scanner(System.in);// scan pour les saisies
	//Explications du deroulement
	System.out.println("\"VOYAGE SCOLAIRE ORGANISE\" ");
	System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
	System.out.println("");
	System.out.println("Ce programme est conçu pour vous aider à organiser un voyage scolaire:(Selon les règles de gestion définies au préalable)");
	System.out.println("Dans le cadre de cet essai, le programme va génerer et afficher les listes des classes, des professeurs et des éleves.");
	System.out.println("Pour façilité la vérification de bon fonctionnement de ce programme vous n'aurez qu'à saisir dans l'ordre: ");
	System.out.println("Un nombre de classe, puis pour chacunes d'elles: Son nom, son nombre d'élèves et son nombre de professeurs. ");
	System.out.println("(La saisie individuelle sera mise en place si par la suite vous désirez saisir les bus, les classes, les groupes, les profs et les élèves uns à uns)");
	System.out.println(" Ensuite, en fonction des listes établies précédemment, le programme va vous présenter les groupes d'élèves créés (1 professeur pour un maximum de 10 élèves  .");
	System.out.println("2-Vous indiquerez le nombre de places maximale que les Bus peuvent accueillirent (On partira du principe qu'il n'y a que des bus de la même dimension: le nombre de places assises ne varient pas pour le moment)");
	System.out.println(" Le programme organisera les groupes en fonction de la taille des bus et déterminera le nombre de bus nécessaires ");
	System.out.println("Les liste des bus et de l'ensemble de leur passagers vous serons présentées.");
	System.out.println("Vous n'aurez qu'à Valider l'organisation pour que tout le monde puisse partir en voyage.... ");
	System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
	System.out.println("");
	System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
	System.out.println(" __________________________________________________________________________________");
	System.out.println("|_____________________| Création des classes d'éleves |____________________________|");
	System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
	//__________________ DEBUT DU PROGRAMME_____________________
	//__________________LES CLASSES D'ELEVES____________________
	do {// on demande d'abord le nombre de classe d'eleves
		System.out.println("Quel est le nombre de classes d'éleves du collége à participer à ce voyage ?");
		nbrClasse = sc.nextInt();	
	}// Tant qu'un entier n'est pas saisi, la question est reposé
	while(!isInteger(nbrClasse));
	// Creation/Généreration les classes d'eleves
	for(int i=0;i<nbrClasse;i++) {
		System.out.println("Pour la classe numero "+(i+1)+" :");
		System.out.println("Quel est le nom de cette classes d'éleves ?");
		sc.nextLine();
		nomClasse = sc.nextLine();	
		System.out.println("Nombre d'éleves de la classe '"+ nomClasse+"' qui participent au voyage ?");
		//On vide la ligne avant d'en lire une autre
		nbrElevesClasse =sc.nextInt();	
		//calcul du nombre minimum de profs pour assurer la surveillance de cette classe
		if ( nbrElevesClasse%10 > 0) nbrProfClasseMin=nbrElevesClasse/10 +1;
		else nbrProfClasseMin = nbrElevesClasse/10;
		//Tant que le nombre de profs saisi est inferieur au nombre de profs necessaire à l'encadrement des élèves on repose la question
		do {System.out.println("Nombre de professeurs de la classe '"+ nomClasse+"' qui participent au voyage ?");
			System.out.println("(il faut au moins "+nbrProfClasseMin+" de professeurs pour encadrer les élèves)");
			nbrProfClasse = sc.nextInt();	
		}		
		while(nbrProfClasse-nbrProfClasseMin < 0);// c'est ici qu'on s'assure un nombre min de prof pour que les eleves ne soient pas plus de 10 par groupes
		List<Prof> listProf =new ArrayList<Prof>();
		// ici on génère aléatoirement  les prenoms et noms de chaque profs grace aux tableaux prenom et nom 
		for(int k=0; k<nbrProfClasse;k++) {
			Random rdp2 = new java.util.Random();
			int rd=rdp2.nextInt(prenom.length);
			String prenomrd2=prenom[rd];
			Random rdn2 = new java.util.Random();
			int rd1=rdn2.nextInt(nom.length);
			String nomrd2=nom[rd1];	
			Prof prof = new Prof(nomrd2,prenomrd2,nomClasse);//on cree un nouveau prof
			listProf.add(prof);//on l'ajoute a la liste des profs en cours
			VoyageManager.addProf(prof);//on l'ajoute a la liste des profs globale
		}
		// ici on génère aléatoirement  les prenoms et noms de chaque eleves grace aux tableaux prenom et nom 
		List<Eleve> lstEleve = new ArrayList<Eleve>();
		for(int j=0; j<nbrElevesClasse;j++) {
			Random rdp = new java.util.Random();
			int r=rdp.nextInt(prenom.length);
			String prenomrd=prenom[r];
			Random rdn = new java.util.Random();
			int r1=rdn.nextInt(nom.length);
			String nomrd=nom[r1];			
			Eleve eleve = new Eleve(nomrd,prenomrd,nomClasse);//on cree un nouvel eleve
			lstEleve.add(eleve);// on l'ajoute a la liste des éleves
			VoyageManager.addEleve(eleve);//on l'ajoute a la liste des éleves globale
		}
		nbrelevesTot=nbrelevesTot+lstEleve.size();//Calcul le nombre total d eleves participants au voyage
		nbrprofsTot=nbrprofsTot+listProf.size();//Calcul le nombre de professeurs participants au voyage
		nbrPassagersTot=nbrPassagersTot+lstEleve.size()+listProf.size();//Calcul le nombre total de participants au voyage
		//On créé une classe définie par son nom, la liste de ses profs et la liste de ses eleves
		ClasseEcole classeEcole = new ClasseEcole (nomClasse,lstEleve,listProf);
		// Ajout de la classe à la liste des classes
		VoyageManager.addClasseEleve(classeEcole);
	}//fin de la boucle pour la creation des classes d eleves
	System.out.println("Affichage de la composition des classes");
	System.out.println(VoyageManager.afficherLstClassesEcole());
	//if ( nbrelevesTot%10 > 0) nbrProfTotalmin=nbrelevesTot/10 +1;
	//else nbrProfTotalmin = nbrelevesTot/10;
	System.out.println("Nous avons donc "+nbrPassagersTot+" passagers en tout: "+nbrprofsTot+" profs et "+nbrelevesTot+" eleves");
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	System.out.println("");
	System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
	System.out.println("____________________________________________________________________________________");
	System.out.println("|______________________________| Création des Groupes |_____________________________|");
	System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
	//__________________ LES GROUPES D'ELEVES__________________
	System.out.println("Solution n°1: Création des groupes par classes: Dans un groupe,tous les eleves appartiennent à la même classe.");
	//Maintenant on va parcourir la liste des classes d'ecoles pour générer des groupes
	System.out.println("Si on génère les groupes à partir de la liste des classes:");
	for (ClasseEcole classeEcole: VoyageManager.getlstClasseEcole()) {
		numGroupe=1;
		//Calcul du nombre d'eleves par profs pour chaque classe d'ecole,		
		//exemple: pour 21 eleves et 3 profs: 21/3 = 7 (chiffre rond tout va bien)
		nbrElevebyProf=classeEcole.getLstEleve().size()/classeEcole.getLstProf().size();
		//mais autre exemple: 
		// si on a 22 eleves pour 3 profs :
		// 	- soit on a 22/10: 2 groupes de 10  et 1 groupe de 2 
		//	- soit on divise le nombre d'eleves par le nombre de profs: 22/3= 7 eleves il reste 1 eleve (ça ne va pas)
		// il faut donc augmenter le nombre d'eleves par profs de 1 pour mieux repartir les groupes:
		//		2*8 = 16 + 1*6 = 22 : 2 groupes de 8 et 1 groupe de 6
		//Donc pour le cas où nombre d'eleves / nombre de profs ne donne pas un chiffre rond:
		if ((classeEcole.getLstEleve().size()%classeEcole.getLstProf().size()) > 0) {
			nbrElevebyProf=nbrElevebyProf+1;
		}// autre exemple: 53 eleves pour 6 profs: (5*10 et 1*3) ou  (6*8  reste 5) ou (5*(8+1) et 1*8)
		// initialisation de l'increment du nombe d'eleves (va servir à parcourir la liste d'eleves de la classe)
		int iNbrEleve=0;
		// pour chaque prof de la liste des profs de la classe en cours
		for (Prof prof : classeEcole.getLstProf()) {
			//Creation d'une liste d'eleves (du même groupe)
			List<Eleve> lstEleveGroupe = new ArrayList<Eleve>();
			//pour ieleve inferieur au nombre d'eleves par prof
			for(int iEleve=0 ; iEleve< nbrElevebyProf; iEleve++) {
				//on va chercher eleve apres eleve dans la liste des eleves de la classe entiere 
				if(iNbrEleve < classeEcole.getLstEleve().size()) {//tant qu'il y a des eleves dans la liste d'eleve d'une classe
					Eleve eleveadd = classeEcole.getLstEleve().get(iNbrEleve);
					//pour les ajouter a la liste des eleves du groupe en cours.
					lstEleveGroupe.add(eleveadd);
					//incrementation du nombre d'eleves (pour le parcours de la liste d'eleves de la classe)
					iNbrEleve++;
				}
			}
			//on créé le nouveau groupe avec son prof, son numero et sa liste d'éléves
			GroupeEleve groupeEleve = new GroupeEleve(prof, numGroupe, lstEleveGroupe);
			//on ajoute  le groupe en cours dans la liste de groupes
			VoyageManager.addGroupEleves(groupeEleve);
			numGroupe++;
		}
		System.out.println(VoyageManager.afficherGroupEleve());
		//  on réparti les groupes par bus ici si on considere que chaque groupe est rempli par des eleves de la même classe 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
	System.out.println("_____________________________________________________________________________________");
	System.out.println("|_______________________________| Creation des bus |_________________________________|");
	System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
	System.out.println("Le nombre de bus sera determiné en fonction de leur nombre de passagers: ");
	System.out.println("Combien de personnes peut transporter chaque bus ?");
	nbrPlacesBus = sc.nextInt();
	sc.close();
	System.out.println("");
	System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
	System.out.println("_____________________________________________________________________________");
	System.out.println("|Liste des passagers des BUS établies à partir des groupes précedement créés|");
	System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
	// calcul du nombre de groupe par bus avec le nombre de place dans chaque bus et le nombre de personnes par groupe 
	nbrGroupbyBus=nbrPlacesBus/nbrElevebyProf;
	//calcul du nbr de bus  avec le nombre de groupes total et le nombre de groupes par bus
	nbrBus=VoyageManager.getLstGroupeEleves().size()/nbrGroupbyBus;
	// initialisation de l'increment du nombe de groupes (va servir à parcourir la liste des groupes)
	int iNbGroup=0;
	
	//Pour respecter l'interdiction des 3 classes  ds le meme bus:
 	// Boucle sur la liste des classes puis
	// A partir de la deuxieme classe d'eleves, et pour chaque nouvelles classes, recalcul de la somme du nombre des eleves des deux dernieres classes.
	// S'il arrive que l'une de ces sommes calculées soit inferieure au nombre maximum de places assises,cela veut dire que l'ajout d'un groupe d'eleve 
	// est susceptible d'arriver. 
 	//c'est donc le dernier eleve de la liste d'eleves de classe en cours (celle avec laquelle on verifie cette infèriorité)
 	// qui va servir de point d'arret d'insertion: On créé un nouveau bus
	// C.A.D: le nombre de places assises du bus est SUPPERIEUR a la somme du nombre d'eleves de deux classes successives.
 	// -> ceci peut entrainer la présence d'une 3eme classe dans le même bus(D'où cette vérification)
	
	for(int index=0 ; index<VoyageManager.getlstClasseEcole().size() ; index++) {			//parcoure de la liste des classes
		 if(index>1) {																		// a partir de la deuxieme classe d'ecole
			ClasseEcole classeEcoleActuel =  VoyageManager.getlstClasseEcole().get(index);	//on recupere la classe actuelle 
			ClasseEcole classeEcoleMoins1 = VoyageManager.getlstClasseEcole().get(index-1); // et la précedente
			 int SommeElevesTwoClasses = classeEcoleActuel.getLstEleve().size() + classeEcoleMoins1.getLstEleve().size(); // pour faire l'addition des deux
			 if(SommeElevesTwoClasses <  nbrPlacesBus) { 									// Si la somme deux deux est inferieur au nombre de place dans le bus
				Eleve lastEleve = classeEcoleActuel.getLstEleve().get(classeEcoleActuel.getLstEleve().size()); //On determine 
			 } 
		 }
		index++;
	 }	
	
	//pour chaque bus	 
	for (int ibus=1;ibus<=nbrBus;ibus++) {
		// nouvelle liste de passagers d'un bus
		List<Personne> lstPassagers = new ArrayList<Personne>();
		numBus=ibus;
		// et pour chaque groupe du bus
		for(int iGrpBus=0; iGrpBus<nbrGroupbyBus;iGrpBus++) {
			// on recupere le groupe d'eleves correspondant dans la listes des groupes d'eleves
			if(iNbGroup< VoyageManager.getLstGroupeEleves().size()){//tant qu'il y a des groupes d'eleves dans la liste
				GroupeEleve groupeEleve = VoyageManager.getLstGroupeEleves().get(iNbGroup);
				iNbGroup++;
				//et ajout du prof dans la liste des Passagers
				lstPassagers.add(groupeEleve.getProfResponsable());
				//et pour chaque eleves de ce groupe d'eleves 
				 for(Eleve eleve : groupeEleve.getLstEleveGroupe()) {
					//Ajout  de l'eleve dans la liste des Passagers
					lstPassagers.add(eleve);
					// Verification du dernier eleve des 2 classes
					if (eleve.equals(lastEleve)) {
						Bus bus =new Bus(numBus, nbrPlacesBus, lstPassagers);
						lastEleveTest=true;
						nbrBus=nbrBus+1;
						VoyageManager.addBus(bus);
					 }	
				}
			}
		}
		if (!lastEleveTest){
			Bus bus =new Bus(numBus, nbrPlacesBus, lstPassagers);
			VoyageManager.addBus(bus);
		}	
	}
	System.out.println(VoyageManager.afficherlistBus());
		
	
}
	// Méthodes annexes
	/**
	 * @isInteger Verifie si l'objet est un Integer
	 * 
	 * **/
public static boolean isInteger(Object object) { 
		if(object instanceof Integer) { 
			return true; 
		} else { 
			String string = object.toString(); 
			 
			try { 
				Integer.parseInt(string); 
			} catch(Exception e) { 
				return false; 
			}	 
		} 
	   return true; 
} 
}