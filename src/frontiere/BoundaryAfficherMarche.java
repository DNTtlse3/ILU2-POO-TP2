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
			int indice=0;
			
			for(int i=0;i<infosMarche.length;i=i+3) {
				
				String vendeur = infosMarche[indice];
				indice++;
				String quantite = infosMarche[indice];
				indice++;
				String produit = infosMarche[indice];
				indice++;
								
				System.out.println("-"+vendeur+" qui vend "+quantite+" "+produit);
			}
			
		}
	}
}
