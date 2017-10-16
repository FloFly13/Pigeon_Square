

import java.awt.*;

public class DessinNourriture extends DessinEntite {

    public DessinNourriture(Point position) {
        super(position, new Rectangle(position.x, position.y, 10, 10), image, Color.green);
    }

}