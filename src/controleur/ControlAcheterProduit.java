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
		
		Gaulois[] vendeurs = village.rechercherVendeursProduit(produit);
		String[] lesVendeurs = null;
		
		if(vendeurs == null) {
			return lesVendeurs;
		}else {
			lesVendeurs = new String[vendeurs.length];
			for(int k=0; (k<vendeurs.length);k++) {
				lesVendeurs[k] = vendeurs[k].getNom();
			}
		}
		return lesVendeurs;
	}
	
	public String acheterProduitMarcher(String nomVendeur,int quantite) {
		if(controlVerifierIdentite.verifierIdentite(nomVendeur)) {
			Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
			if(quantite <= etal.getQuantite()) {
				
				if(etal != null) etal.acheterProduit(quantite);
				
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
