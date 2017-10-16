import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class Dessin extends JPanel implements MouseListener {
    private List<DessinEntite> dessins;
    private Map m;

    public Dessin(InterfaceUtilisateur ui, Map m) {
        super();
        this.dessins = new ArrayList<>();
        this.m = m;

        this.addMouseListener(this);

        this.setSize(ui.getWidth(), ui.getHeight());

        System.out.println(this.getWidth() + " " + this.getHeight());
    }

    public void ajoutDessin(DessinEntite e) {
        this.dessins.add(e);
    }

    public void initShapes() {
        for (DessinEntite es : this.dessins) {
            System.out.println("Entity created");
            System.out.println(es);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        ArrayList<DessinEntite> deadShapes = new ArrayList<>();

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        try {
    		Image img = ImageIO.read(new File("pigeon.jpg"));
    		g.drawImage(img, getX(), getY(), this);
    		
    		
    		} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    		}
        
        
        	
        	 for (DessinEntite es : this.dessins) {
                 if (es.canDraw()) {
                	 
                     g.setColor(es.getColor());
                     Rectangle esDrawing = es.getDrawing();
                     g.fillRect(esDrawing.x, esDrawing.y, esDrawing.width, esDrawing.height);
                 } else {
                     deadShapes.add(es);
                 }
             }
             for (DessinEntite es : deadShapes) {
                 this.dessins.remove(es);
             }
        	
        
        
       
    }

    public void removeDessin(DessinEntite es) {
        this.dessins.remove(es);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point mousePosition = this.getMousePosition();
        System.out.println("Clicked on " + mousePosition);
        Nourriture n = new Nourriture(new Case(mousePosition));
        this.m.addNourriture(n);

        DessinNourriture dessinNourriture = new DessinNourriture(n.getGridPosition());
        n.registerDessin(dessinNourriture);
        this.ajoutDessin(dessinNourriture);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
