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
		
		String[] lesVendeurs = controlAcheterProduit.vendeurAvecProduit(produitDemande);
		
		if(lesVendeurs != null) {			
			for(int k = 0; (k<lesVendeurs.length)&&(lesVendeurs[k]!=null);k++) {
				System.out.println("|*<--->*|"+(k+1)+" "+lesVendeurs[k]);
			}

			int choix;
			do {
				choix = Clavier.entrerEntier("Chez quel commerçant voulez-vous"
						+ " acheter des "+ produitDemande +"?"
						+ "\n");
			}while((choix > lesVendeurs.length));
			String vendeur = lesVendeurs[choix-1];
			
			System.out.println(nomAcheteur+" se déplace jusqu'à l'étal"
					+ " du vendeur "+vendeur);
			int quantite;
			quantite = Clavier.entrerEntier("Combien de "+produitDemande+" voulez-vous "
					+ "acheter ?");
			
			String ctrl = controlAcheterProduit.acheterProduitMarcher(vendeur, quantite);
			
			System.out.println(ctrl);
		}
		else {
			System.out.println("Désolé le produit que vous demandez est indisponible et n'apparaît sur aucun étal"
					+", revenez-plus tard, bonne journée.");
		}
	}
}
