

import javax.swing.*;
import java.awt.*;

public class InterfaceUtilisateur extends JFrame {

    private Dessin panel;

    public InterfaceUtilisateur() {
        super();
        this.setSize(new Dimension(500, 500));
    }

    public void init(Map m) {
        this.setTitle("Pigeon");
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.panel = new Dessin(this, m);
        this.setContentPane(this.panel);

        for (Pigeon p : m.getPigeonList()) {
            DessinPigeon dessinPigeon = new DessinPigeon(p.getGridPosition());
            p.registerDessin(dessinPigeon);
            this.panel.ajoutDessin(dessinPigeon);
        }

        for (Nourriture n : m.getNourritureList()) {
            DessinNourriture dessinNourriture = new DessinNourriture(n.getGridPosition());
            n.registerDessin(dessinNourriture);
            this.panel.ajoutDessin(dessinNourriture);
        }
    }

    public void run() {
        this.panel.initShapes();
        this.panel.repaint();
    }

    public void reDraw() {
        this.panel.repaint();
    }

    public void mangeNourriture(DessinEntite dessinEntite) {
        this.panel.removeDessin(dessinEntite);
    }
}
