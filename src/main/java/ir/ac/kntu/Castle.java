package ir.ac.kntu;

public class Castle extends Entity{

    public Castle(int x,int y,Map map,String path) {
        super.setImgPath(path);
        super.setGrid(map);
        super.setX(x);
        super.setY(y);
    }

    @Override
    public void shot(Entity entity) {

    }
}
