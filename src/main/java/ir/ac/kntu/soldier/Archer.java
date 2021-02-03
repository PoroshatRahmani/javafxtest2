package ir.ac.kntu.soldier;

import ir.ac.kntu.Map;
import javafx.scene.shape.Rectangle;

public class Archer extends Soldiers{

    public Archer(double x, double y, Map map, String path) {
        super(x, y, map, 300, 200, 2, false, 15, 1);
        super.setImgPath(path);
    }

    public Archer(double x, double y, int health, int damage, int range, boolean dead, int energy, int speed, Rectangle rectangle) {
        super(x, y, 300, 200, 2, false, 15, 1, rectangle);
    }
}
