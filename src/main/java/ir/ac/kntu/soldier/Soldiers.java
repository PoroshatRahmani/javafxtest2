package ir.ac.kntu.soldier;

import ir.ac.kntu.Entity;
import ir.ac.kntu.Map;
import ir.ac.kntu.tower.Towers;
import javafx.scene.shape.Rectangle;

import java.io.Serializable;

public class Soldiers extends Entity implements Serializable {

    private int energy;
    private int speed;
    transient private Rectangle rectangle;

    public Soldiers() {
         super.setDead(false);
    }


    public Soldiers(double x, double y,Map map, int health, int damage, int range, boolean dead,
                    int energy, int speed) {
        super(x, y, map,health, damage, range, dead);
        this.energy = energy;
        this.speed = speed;
    }

    public Soldiers(double x, double y, int health, int damage, int range, boolean dead, int energy, int speed, Rectangle rectangle) {
        super(x, y, health, damage, range, dead);
        this.energy = energy;
        this.speed = speed;
        this.rectangle = rectangle;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }



    @Override
    public void shot(Entity entity) {


        Towers tower = (Towers) entity;
        tower.setHealth(tower.getHealth() - this.getDamage());
        if (tower.getHealth() == 0){
            tower.setDead(true);
        }
    }
    public boolean travelable(){
        for (int i = 0; i < super.getGrid().getEntities().size(); i++) {
            if (this.isInRange(super.getGrid().getEntities().get(i))){
                return !(super.getGrid().getEntities().get(i) instanceof Towers) ||
                        ((Soldiers)(super.getGrid().getEntities().get(i))).getSpeed() < this.getSpeed();
            }
        }
        return false;
    }
}
