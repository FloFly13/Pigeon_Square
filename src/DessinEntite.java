
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;

public abstract class DessinEntite extends JPanel {

    private Point position;
    private Rectangle drawing;
    protected static Image image;
    private Color color;
    private boolean isDrawable;
	private Object drawImage;

    public DessinEntite(Point position, Rectangle d, Image img, Color c) {
        super();
        this.position = position;
        this.drawImage = img;
        this.drawing = d;
        this.color = c;
        this.isDrawable = true;
        
        
    }

    public void move(Point newPosition) {
        this.position = newPosition;
        this.drawing.setLocation(newPosition.x, newPosition.y);
        
    }

    public Rectangle getDrawing() {
        return this.drawing;
    }
    
    public Image getDrawImage() {
        return this.getDrawImage();
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "DessinEntite{Color:" + this.color + ", Position: " + this.position + ", Rectangle: " + this.drawing + "}";
    }

    public void deadShape() {
        this.isDrawable = false;
    }

    public boolean canDraw() {
        return this.isDrawable;
    }
    
   
}