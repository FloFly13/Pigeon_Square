
public class Pigeon extends Entite { // constructeur de Base

	    protected int BasePigeon;
	    protected int devorer;
	    private boolean vivant;
	    private Map map;

	    public Pigeon(Case position, Map m) { // Constructeur d'initialisation 
	        
	    	super(position);
	        this.BasePigeon = 1; // le pigeon mange des que la nourriture touche sont bec ( = 1 )
	        this.devorer = 10; // On a toujours un peu faim
	        this.vivant = true; 
	        this.map = m;
	    }
	    
	    public void Manger(Nourriture n) {
	        this.devorer -= n.getTaille();
	    }

	    public void kill() {
	        this.vivant = false;
	    }

	    public void run() {
	        while(!this.Mort()) {
	            System.out.println(this);
	            this.Battifole();

	            try {
	                sleep(10);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    private void Battifole() {
	        // recherche de nourriture
	        Nourriture nourritureProxi = this.Cherche();
	        
	        if (nourritureProxi!= null) {
	            //Direction Nourriture
	            
	            this.Bouge(nourritureProxi);
	            
	            if (nourritureProxi.getPosition().distanceTo(this.position) == 0) { //si tu es a la bonne distance de la nourriture , mange la
	                
	            	this.Manger(nourritureProxi);
	               
	                this.map.deleteNourriture(nourritureProxi);
	            }
	        } else {
	            //Si pas de nourriture , pas de mouvement 
	            try {
	                sleep(2000);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    private void Bouge(Nourriture n) {
	    	
	        this.position.moveTo(n.getPosition());
	        this.dessin.move(this.getGridPosition());
	    }

	    private Nourriture Cherche() {
	        return this.map.nourritureProxi(this);
	    }

	    public boolean Mort() {
	        return !this.vivant;
	    }

	    @Override
	    public String toString() {
	        return "Bird{ID: " + this.getIdentifier() +  ",Case:" + this.getPosition() + "}";
	    }

	    public void dispertion() {
	        int x = (int) (Math.random() * (mapdSize - 50)),
	                y = (int) (Math.random() * (mapdSize - 50));
	        this.setPosition(new Case(x, y));
	        this.dessin.move(this.getGridPosition());
	    }
	}

	    

