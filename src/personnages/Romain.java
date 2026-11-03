package personnages;
import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	private boolean isInvariantVerified() {
	    return force >= 0;
	}

	public Romain(String nom, int force) {

		this.nom = nom;
		this.force = force;
		assert isInvariantVerified();
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");

	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";

	}

	public void recevoirCoup(int forceCoup) {
		assert forceCoup > 0;
		int ancienneForce = force;
		force = force - forceCoup;

		if (force < 1) {
			force = 0;
			parler("J'abandonne !");
		} else {
			parler("Aïe");
		}
		assert isInvariantVerified();
		assert force < ancienneForce;
	}
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		System.out.println(Equipement.CASQUE);
		System.out.println(Equipement.BOUCLIER);
	}
	
	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
	    case 0:
	    	ajouterEquipement(equipement);
	        break;

	    case 1:
	    	if (equipements[0] == equipement) {
	            System.out.println("Le soldat " + nom + " possede deja un " + equipement + " !");
	        } else {
	            equipements[nbEquipement] = equipement;
	            nbEquipement++;
	            System.out.println("Le soldat " + nom + " s'equipe avec un " + equipement + ".");
	        }
	        break;

	    case 2:
	    	System.out.println("Le soldat " + nom + " est deja bien protege !");
	        break;
	}

	}
	private void ajouterEquipement(Equipement equipement) {
	    equipements[nbEquipement] = equipement;
	    nbEquipement++;
	    System.out.println("Le soldat " + nom + " s'equipe avec un " + equipement + ".");
	}

}
