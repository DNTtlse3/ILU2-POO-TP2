package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {

		boolean vendeurReconnu = controlLibererEtal.isVendeur(nomVendeur);

		if (!vendeurReconnu) {
			System.out.println("Mais vous n'êtes pas inscrit sur notre" + " aujourd'hui!");
		} else {

			String[] donnesEtal = controlLibererEtal.libererEtal(nomVendeur);
			if(donnesEtal != null) {
				String etalOccupe = donnesEtal[0];
				String name = donnesEtal[1];
				String produit = donnesEtal[2];
				String quantiteInitial = donnesEtal[3];
				String quantiteVendu = donnesEtal[4];

				if (etalOccupe.equals("true")) {
					System.out.println(
						name + " vous avez vendu " + quantiteVendu + " sur " + quantiteInitial + " " + produit + ".");
					System.out.println("Au revoir " + nomVendeur + ", passez une bonne journée");

				}
			}else {System.out.println("Rassurez-vous votre demande a été bien prise en compte!");}
		}
	}
}
