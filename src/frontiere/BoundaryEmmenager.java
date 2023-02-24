package frontiere;

import controleur.ControlEmmenager;


public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					//TODO a completer
					System.out.println("Bienvenu "+nomVisiteur);
					int force  = Clavier.entrerEntier("Quelle est votre force?");
					controlEmmenager.ajouterGaulois(nomVisiteur, force);
					
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					emmenager(nomVisiteur);
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		//TODO a completer
		System.out.println("Bienvenu "+nomVisiteur);
		int forceDruide = Clavier.entrerEntier("Quelle est votre force ?");
		int minforcePotion,maxforcePotion;
		do {

			minforcePotion = Clavier.entrerEntier("Quelle est la force de potion la\r\n"
					+ "plus faible que vous produisez ?");
			maxforcePotion = Clavier.entrerEntier("Quelle est la force de potion la\r\n"
					+ "plus faible que vous produisez ?");
		}
		while(!((minforcePotion<=maxforcePotion) && (minforcePotion >=0) && (maxforcePotion>=0)));
		controlEmmenager.ajouterDuide(nomVisiteur, forceDruide, minforcePotion, maxforcePotion);
	}
}
