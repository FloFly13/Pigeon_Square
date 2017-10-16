import java.awt.Point;



	public abstract class Entite extends Thread {
		
	    protected final static int mapdSize = 500;
	    private final  int gridSizer = 1;
	    protected  long id = 0;
	    protected long identifier;
	    protected Case position;
	    protected DessinEntite dessin;

	    public Entite(Case position) {
	        this.position = position;
	        this.identifier = id;
	        this.dessin = null;
	        id += 1;
	    }

	    public Case getPosition() {
	        return position;
	    }

	    public void setPosition(Case position) {
	        this.position = position;
	    }

	    public Point getGridPosition() {
	        return new Point(this.position.getX() * gridSizer, this.position.getY() * gridSizer);
	    }

	    public long getIdentifier() {
	        return this.identifier;
	    }

	    public void registerDessin(DessinEntite dessin) {
	        this.dessin = dessin;
	    }

	    public DessinEntite getDessin() {
	        return dessin;
	    }
	}


