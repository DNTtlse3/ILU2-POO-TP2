package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {

		System.out.println("Quel produit voulez-vous acheter ?");
		
		String produitDemande = scan.nextLine();
		
		String[] tabVendeur = controlAcheterProduit.vendeurAvecProduit(produitDemande);
		
		if(tabVendeur != null) {
			int nbVendeur = 1;
			for(int k = 0; k<tabVendeur.length-1;k++) {
				System.out.println("-"+nbVendeur+" "+tabVendeur[k]);
				nbVendeur = k+1;
			}
			
			int choix,quantite;
			do {
				choix = Clavier.entrerEntier("Chez quel commerçant voulez-vous"
						+ " acheter des "+ produitDemande +"?"
						+ "\n");
				
			}while((choix > nbVendeur));
			
			String vendeur = tabVendeur[choix-1];
			
			System.out.println(nomAcheteur+" se déplace jusqu'à l'étal"
					+ " du vendeur "+vendeur);
			
			quantite = Clavier.entrerEntier("Combien de "+produitDemande+" voulez-vous "
					+ "acheter ?");
			
			controlAcheterProduit.acheterProduitMarcher(vendeur, quantite);
			
		}
		else {
			System.out.println("Désolé le produit que vous demandez est indisponible et n'apparaît sur aucun étal"
					+", revenez-plus tard, bonne journée.");
		}
	}
}
