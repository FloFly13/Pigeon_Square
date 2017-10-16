

import java.awt.*;

public class DessinPigeon extends DessinEntite {

    public DessinPigeon(Point position) {
        super(position, new Rectangle(position.x, position.y, 25, 25), Color.DARK_GRAY);
    }

}