import java.awt.Color;

public class Nourriture extends Entite {

	private int taille;
    private boolean Mangeable;
    private int Duree= 10000;

    public Nourriture(Case position) {
        super(position);
        this.taille = 1; // each food is a size 1 food
        this.Mangeable = true;
    }

    public int getTaille() {
        return taille;
    }

    public boolean Comestible() {
        return this.Mangeable;
    }

    public void rot() {
        this.dessin.setColor(new Color(85, 107, 47));
        this.Mangeable = false;
    }

    public void killShape() {
        this.dessin.deadShape();
    }

    @Override
    public String toString() {
        return "Nourriture{" + "Position: " + this.position + '}';
    }

    public int getDuree() {
        return Duree;
    }

    public void setDuree(int Duree) {
        this.Duree = Duree;
    }
}


