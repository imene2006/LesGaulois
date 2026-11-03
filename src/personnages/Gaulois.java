package personnages;
import village_gaulois.Village;

public class Gaulois {
	
	private String nom;
	private Village village;
	private int force;
	private int effetPotion = 1;
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	public String getNom() {
		return nom;
	}
	
	public Village getVillage() {
	    return village;
	}

	public void setVillage(Village village) {
	    this.village = village;
	}
	
	@Override
	public String toString() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
		
	}
	

    public void frapper(Romain romain) {
       System.out.println(nom + " envoie un grand coup dans la machoire de " + romain.getNom());
       romain.recevoirCoup(force * effetPotion / 3);

       if (effetPotion > 1) {
          effetPotion--;
       }
    }
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
	public void boirePotion(int forcePotion) {
	    effetPotion = forcePotion;
	}
	
	public int getForce() {
	    return force;
	}
	public void sePresenter() {
	    if (village == null) {
	        System.out.println("Le Gaulois " + nom + " : \"Bonjour, je m'appelle " + nom
	                + ". Je voyage de villages en villages.\"");
	    } else if (village.getChef() == this) {
	        System.out.println("Le Gaulois " + nom + " : \"Bonjour, je m'appelle " + nom
	                + ". Je suis le chef le village : " + village.getNom() + ".\"");
	    } else {
	        System.out.println("Le Gaulois " + nom + " : \"Bonjour, je m'appelle " + nom
	                + ". J'habite le village : " + village.getNom() + ".\"");
	    }
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		Romain romain = new Romain("Brutus", 10);
		System.out.println(asterix);
		asterix.frapper(romain);
	}
	

}
