package personnages;

public class Gaulois {
	@Override
	public String toString() {
		return nom;
	}
	private String nom;
	private int force;
	private int effetPotion = 1;
	public Gaulois(String nom, int force) {
		super();
		this.nom = nom;
		this.force = force;
	}
	public String getNom() {
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
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		Romain romain = new Romain("Brutus", 10);
		System.out.println(asterix);
		asterix.frapper(romain);
	}
	public void boirePotion(int forcePotion) {
	    effetPotion = forcePotion;
	}
	
	public int getForce() {
	    return force;
	}
	

}
