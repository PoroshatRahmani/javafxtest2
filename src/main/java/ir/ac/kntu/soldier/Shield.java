package ir.ac.kntu.soldier;

import ir.ac.kntu.Map;
import javafx.scene.shape.Rectangle;

public class Shield extends Soldiers{
    public Shield(double x, double y, Map map, String path) {
        super(x, y, map,1000, 150, 1, false, 10, 1);
        super.setImgPath(path);
    }

    public Shield(double x, double y, int health, int damage, int range, boolean dead, int energy, int speed, Rectangle rectangle) {
        super(x, y, health, damage, range, dead, energy, speed, rectangle);
    }
}
