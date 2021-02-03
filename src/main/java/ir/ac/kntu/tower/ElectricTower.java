package ir.ac.kntu.tower;

import ir.ac.kntu.Map;

public class ElectricTower extends Towers{
    public ElectricTower() {
    }

    public ElectricTower(int x, int y, Map map, String path) {
        super(x, y,map ,1500, 250, 3, false);
        super.setImgPath(path);
    }
}
