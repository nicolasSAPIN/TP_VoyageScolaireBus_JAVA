package fr.epsi.tp.voyage.IHM;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import fr.epsi.tp.voyage.BLL.*;
import fr.epsi.tp.voyage.BO.*;
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
public class Exec2 {
	private static String[] prenom={"pierre","paul","jacques","emmanuel","manu","numa","toto","roto","polo","marco","Albert","nicolas","Aurélian","Augustino","Gaston","Angelin","Allen","Andoni","Arno","nono","dodo","lolo","popo","coco","vivi","mimil","fred","fredy","pascal","claude","sebastien","regis","serge","quentin","morgan","eddy","guillaume","mickael","magali","celia","helene","tartuf","fabien","famal","titi","rominet","jesus","mathieu","paul","pierre","david","marc" };
	private static String[] nom={"Nadal","sapin","Noel","Janvier","Lenormand", "LeBreton", "Paris", "Zidane", "Henry", "Gates", "neymard","Petit","Loeb","Oreille", "Pinard","Hyde","Jekkil","Jobs","Sharzeneger", "zinzin", "Bergerg","Trump", "Sarkozy", "Hollande", "Chirac", "Mitterand", "DeGaule", "Musso", "DeBussi", "Baudelaire","Hemingway","Daniels", "Rechman", "Carlos" , "DaCosta", "Lecouillard", "DeLapin", "DeLaCoure", "DeMontmirail","Jeanne","Charles","Robert","Malabry", "StaussKan","Merkel","Jones","Bond"};
	private static Eleve lastEleve;
	/**
	 * @ 
	 * @param args
	 *  
	 */
	public static void main(String[] args) throws GestionException {
		// Saisie des variables
		//Variables relatives aux eleves aux profs et aux classes d'esleves
		Integer nbrEleve=0, nbrElevesClasse=0, nbrelevesTot=0, nbrElevebyProf=0;// Variables relatives aux eleves 
		Integer nbrProf=0, nbrProfClasse=0, nbrProfClasseMin=0, nbrProfTotalmin=0, nbrprofsTot=0;//Variables relatives aux profs
		Integer nbrClasse=0;// Variables relatives aux classes d'eleves
		String nomClasse="";
		
		Integer nbrBus=0, numBus=0, nbrPlacesBus=0, nbrElevesBusMax=0, nbrProfbusMin=0;//Variables relatives aux bus
		
		Boolean lastEleveTest= false;
		Integer nbrPassagersTot=0;//et relatives aux passagers du bus
		Scanner sc =new Scanner(System.in);// scan pour les saisies
		//Explications du deroulement
		System.out.println("WELCOME TO \"VOYAGE SCOLAIRE ORGANISE\" ");
		System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
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
		System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
		System.out.println("_____________________________________________________________________________________");
		System.out.println("|_______________________________| Creation des bus |_________________________________|");
		System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
		System.out.println("Le nombre de bus sera determiné en fonction de leur nombre de passagers: ");
		System.out.println("Combien de personnes peut transporter chaque bus ?");
		nbrPlacesBus = sc.nextInt();
		sc.close();
		System.out.println("");
		System.out.println("_____________________________________________________________________________________");
		System.out.println("|_____________________|Liste des passagers de chaques bus|___________________________|");
		System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
		//System.out.println("Nombre de professeurs pour chaque bus");
		//Calcul du nombre de bus min
		if(nbrPassagersTot % nbrPlacesBus >0 ) nbrBus=nbrPassagersTot/nbrPlacesBus + 1;
		else nbrBus=nbrPassagersTot/nbrPlacesBus;
		System.out.println("Pour un total de "+nbrPassagersTot+" passagers et "+nbrPlacesBus+" places pas bus, nous avons besoin de "+nbrBus+" bus pour le voyage");
		//calcul du nombre de Profs par bus	
		if (nbrPlacesBus%10 > 0) nbrProfbusMin=nbrPlacesBus/10 +1;
		else nbrProfbusMin = nbrPlacesBus/10;
		//Clcul du nombre d'elevres par bus
		nbrElevesBusMax=nbrPlacesBus-nbrProfbusMin;
		//+++ tenir compte du calcul du nombre d'eleve et de prof dans le bus 
		//+++ par rapport au nombre d eleve et de prof dans la classe
		int iBus = 0;
		int iClasse = 0;
		int iProf = 0, iProfBus=0;
		int iEleve = 0, iEleveBus=0;
		int iPassagers=1;
		int nbrEleveClasse = 0;
		int nbrElemClasse = 0;
		int placeRestanteBus=0;
		boolean remplissBus= false;
		List<Bus> lstBus = new ArrayList<Bus>(); 
		placeRestanteBus = nbrPlacesBus;
		while (iBus<nbrBus) {
			List<Personne> lstPassagersBus = new ArrayList<Personne>();
			int nbrPassagerBus = 1; //nbr de passager dans le bus (remis à zero à chaque boucle de création d'un bus)
			int iClasseBus = 0; // compteur de classe ds chaque bus (remis à zero à chaque boucle de création d'un bus)
			 // Liste des passagers d'un bus ( Une nouvelle à chaque boucle de création d'un bus)
			numBus=iBus+1;			
			while( placeRestanteBus > 0 && iClasseBus < 2 ) {//Dans un bus, tant qu il y a des places restantes et que le nombre de passagers < nombre de place dans le bus
				//&& iClasseBus < VoyageManager.getlstClasseEcole().size()-1
				ClasseEcole classeEcole = VoyageManager.getlstClasseEcole().get(iClasse);// parcours des classes par index
				nbrProfClasse= classeEcole.getLstProf().size(); // nbr de profs ds la classe
				nbrEleveClasse = classeEcole.getLstEleve().size(); //nbr d'eleves ds la classe
				if( iProf < nbrProfbusMin && iProf < classeEcole.getLstProf().size() ) {
					Prof prof = classeEcole.getLstProf().get(iProf);
					lstPassagersBus.add(prof);
					System.out.println(iPassagers+" / "+nbrPassagersTot);
					System.out.println("Prof "+prof.getPrenom()+" "+prof.getNom()+" est monté dans le Bus numero "+numBus+". Passager n° "+nbrPassagerBus+ "/ "+nbrPlacesBus);
					iProf++;
					iPassagers++;
					nbrPassagerBus++;
					placeRestanteBus--;
				}
				if( iEleve < nbrElevesBusMax && iEleve < classeEcole.getLstEleve().size() ) {
					Eleve eleve = classeEcole.getLstEleve().get(iEleve);
					lstPassagersBus.add(eleve);
					System.out.println(iPassagers+" / "+nbrPassagersTot);
					System.out.println("Eleve "+eleve.getPrenom()+" "+eleve.getNom()+" est monté dans le Bus numero "+numBus+". Passager n° "+nbrPassagerBus+ "/ "+nbrPlacesBus);
					iEleve++;
					iPassagers++;
					nbrPassagerBus++;
					placeRestanteBus--;
				}	
				// Si tous les profs et eleves de la classe parcouru
				if(iEleve == classeEcole.getLstEleve().size() && iProf == classeEcole.getLstProf().size()) { 
					iProf = 0;
					iEleve = 0;
					iClasse++;
					iClasseBus++;
					placeRestanteBus= nbrPlacesBus;
				}	
			}
			Bus bus= new Bus(numBus,nbrPlacesBus,lstPassagersBus);
			System.out.println("_____________");
			System.out.println("| oooooooooo |_ ");            
			System.out.println("|--O--------O--| ");
			System.out.println("Le bus n°"+numBus+" est plein ");
			VoyageManager.getLstBus().add(bus);
			iClasseBus=0;
			iBus++;
		}
		System.out.println(VoyageManager.afficherlistBus());
	}
	// Méthodes annexes
	/**
	 * @isInteger Verifie si l'objet est un Integer 
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