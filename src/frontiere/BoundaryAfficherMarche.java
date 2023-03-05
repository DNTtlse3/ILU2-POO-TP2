package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
		if(infosMarche.length == 0) {
			System.out.println("Le marché est vide, revenez plus tard");
		}else {
			System.out.println(nomAcheteur+" vous trouverez au marché ");
			
			int tailleStantard =( infosMarche.length/3),k=0;
			
			while(k < tailleStantard) {
				String vendeur = infosMarche[k];
				k++;
				String quantite = infosMarche[k];
				k++;
				String produit = infosMarche[k];
				k++;
				System.out.println("-"+vendeur+" qui vend "+quantite+" "+produit);
			}
		}

	}
}
