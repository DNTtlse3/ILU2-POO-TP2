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
	
	public String acheterProduitMarcher(String nomVendeur,int quantite) {
		if(controlVerifierIdentite.verifierIdentite(nomVendeur)) {
			Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
			if(quantite <= etal.getQuantite()) {
				etal.acheterProduit(quantite);
				return "Vous avez acheter "+quantite+" "+etal.getProduit();
			}else {
				return "Désolé mon stock est limité, j'ai que "+ etal.getQuantite()+" "+etal.getProduit()+" !";
			}
		}
		else {
			return "Apparement, d'apès les sources ce vendeur n'est pas d'ici.";
		}
	}
}
