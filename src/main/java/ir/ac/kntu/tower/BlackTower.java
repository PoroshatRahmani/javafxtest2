package ir.ac.kntu.tower;

import ir.ac.kntu.Map;

public class BlackTower extends Towers {
    public BlackTower() {
    }

    public BlackTower(int x, int y, Map map, String path) {
        super(x, y,map ,2000, 300, 2, false);
        super.setImgPath(path);
    }
}
