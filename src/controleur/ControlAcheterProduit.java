package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}
	
	public String[] vendeurAvecProduit(String produit) {
		
		Gaulois[] vendeur = village.rechercherVendeursProduit(produit);
		
		if(vendeur != null) {
		
			int tailleStandard = vendeur.length;
		
			String[] nomVendeur = new String[tailleStandard];
		
			for(int k = 0; k<tailleStandard;k++) {
				nomVendeur[k] = vendeur[k].getNom();
			}
		
			return nomVendeur;
		}else {
			return null;
		}
	}
	
	public void acheterProduitMarcher(String nomVendeur,int quantite) {
		if(controlVerifierIdentite.verifierIdentite(nomVendeur)) {
			Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
			etal.acheterProduit(quantite);
		}
		else {
			System.out.println("Ce vendeur n'a pas d'étal dans le village!");
		}
	}
}
