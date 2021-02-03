package ir.ac.kntu.soldier;

import ir.ac.kntu.Map;
import javafx.scene.shape.Rectangle;

public class Knight extends Soldiers{
    public Knight(double x, double y, Map map, String path) {
        super(x, y, map,600, 400, 1, false, 30, 2);
        super.setImgPath(path);
    }

    public Knight(double x, double y, int health, int damage, int range, boolean dead, int energy, int speed, Rectangle rectangle) {
        super(x, y, health, damage, range, dead, energy, speed, rectangle);
    }
}
