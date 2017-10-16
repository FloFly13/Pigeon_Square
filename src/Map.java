import java.util.ArrayList;
import java.util.List;

public class Map {
		
		private List<Pigeon> pigeonList;
	    private List<Nourriture> nourritureList;
	    private List<Nourriture> mauvaisList;
	    private InterfaceUtilisateur ui;
	    private boolean starting;
	    // size 10/10
	
	    public Map(InterfaceUtilisateur ui) {
	    	
	    	this.pigeonList = new ArrayList<>();
	    	this.nourritureList = new ArrayList<>();
	    	this.mauvaisList = new ArrayList<>();
	    	this.ui = ui;
	    	this.starting = true;

	    	this.init();
	    	this.ui.init(this);
	    	this.ui.run();
	    	this.run();
    }
	    public void init() {
	        
	        this.addPigeon(new Pigeon(new Case(150, 0), this));
	        this.addPigeon(new Pigeon(new Case(0, 200), this));
	        this.addPigeon(new Pigeon(new Case(490, 0), this));
	        this.addPigeon(new Pigeon(new Case(250, 350), this));
	        this.addPigeon(new Pigeon(new Case(360, 500), this));
	        this.addPigeon(new Pigeon(new Case(490, 300), this));


	    }
	    
	    public void run() {
	        
	        int peur = 0;
	        int effrayer = 0;
	        int probEffrayer = 10000; // every ~20secs
	        
	        System.out.println("---StartThread---");
	        System.out.println(this.toString());
	        System.out.println("---Initialisation du Thread Pigeon---");
	        
	        for (Pigeon p : pigeonList) {
	            p.start();
	            try {
	                Thread.sleep(50);
	             // TODO Auto-generated catch block
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	        
	        while (this.starting) {
	            try {
	                
	                peur = (int) (Math.random() * (probEffrayer - effrayer));// repositione les pigeons toute les 20 sec dans une position aleatoire
	                if (peur == 0) { // permet d'effaryer les pigeons lorsqu'il sont trop proche l'un de l'autre 
	                    
	                    effrayer = 0;
	                    for (Pigeon p : pigeonList) {
	                        if (p.isInterrupted()) { // booleen : test si le Thread est interrompu 
	                            p.notify(); // positionne les Threads dans la file d'attente 
	                        }
	                        p.dispertion();// empeche les pigeons de se telescoper
	                    }
	                }
	                    this.ui.reDraw();
	                    Thread.sleep(1);
	                    
	                    effrayer++;
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	        }
	        pigeonList.forEach(pigeon -> pigeon.kill()); // libère la mémoire
	        System.out.println(this.toString());
	    }
	    
	    public void addPigeon(Pigeon p) {
	        this.pigeonList.add(p);
	    }
	    
	    /*
	     * 
	    *AJOUTER DE LA NOURRITURE
	    *
	    */
	    public void addNourriture(Nourriture n) {
	        for (Nourriture nourriture : nourritureList) {
	            if (nourriture.Comestible()) { // si nourriture mangeable
	                nourriture.rot(); // creation de la nourriture
	                mauvaisList.add(nourriture); // passage de la nourriture mangeable à non mangeable
	            }
	        }
	        this.nourritureList.add(n);
	    }
	    
	    
	    /*
	     * 
	     * NOURRITURE A PROXIMITER
	     * 
	     */
	    
	    public Nourriture nourritureProxi(Entite e) {
	        Nourriture proxi = null;
	        int minDist = Integer.MAX_VALUE;
	        Case p = e.getPosition();

	        for (Nourriture n : nourritureList) {
	            if (n.Comestible()) {
	                int distance = p.distanceTo(n.getPosition());
	                if (distance < minDist) {
	                    proxi = n;
	                }
	            }
	        }

	        return proxi;
	    }
	    
	    /*
	     * 
	     * DELETE DE LA NOURRITURE
	     * 
	     */

	    public void deleteNourriture(Nourriture n) {
	        this.ui.mangeNourriture(n.getDessin());
	        this.nourritureList.remove(n);
	    }

	    @Override
	    public String toString(){
	        return "Map{\n\tNourriture: " + this.listF(this.nourritureList) + ",\n\tPigeon: " + this.listB(this.pigeonList) + "\n}";
	    }

	    private String listB(List<Pigeon> objects) {
	        String str = "[";
	        for (Object o : objects) {
	            str += o + ", ";
	        }
	        str += "]";
	        return str;
	    }

	    private String listF(List<Nourriture> objects) {
	        String str = "[";
	        for (Object o : objects) {
	            str += o + ", ";
	        }
	        str += "]";
	        return str;
	    }

	    public List<Pigeon> getPigeonList() {
	        return pigeonList;
	    }

	    public List<Nourriture> getNourritureList() {
	        return nourritureList;
	    }
	}


	            
	        

