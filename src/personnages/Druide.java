
package personnages;

import objets.Chaudron;

public class Druide {

    private String nom;
    private int force;
    private Chaudron chaudron = new Chaudron();
    public Druide(String nom, int force) {
        this.nom = nom;
        this.force = force;
    }

    public void parler(String texte) {
        System.out.println(prendreParole() + "\"" + texte + "\"");
    }

    private String prendreParole() {
        return "Le Druide " + nom + " : ";
    }

    public void fabriquerPotion(int quantite, int forcePotion) {
        chaudron.remplirChaudron(quantite, forcePotion);

        parler("J'ai concocte " + quantite
                + " doses de potion magique. Elle a une force de "
                + forcePotion + ".");
    }


    public void booster(Gaulois gaulois) {
        if (gaulois.getNom().equals("Obélix")) {
           parler("Non, Obélix Non !... Et tu le sais tres bien !");
        } else {
            parler("Tiens " + gaulois.getNom() + " un peu de potion magique.");
            int forcePotion = chaudron.prendreLouche();

            if (forcePotion > 0) {
                gaulois.boirePotion(forcePotion);
            }
          }
    }

    public String getNom() {
        return nom;
    }
}