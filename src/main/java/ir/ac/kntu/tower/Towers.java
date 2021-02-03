package ir.ac.kntu.tower;

import ir.ac.kntu.Entity;
import ir.ac.kntu.Map;
import ir.ac.kntu.soldier.Soldiers;
import javafx.scene.shape.Rectangle;

import java.io.Serializable;

public class Towers extends Entity implements Serializable {
    transient Rectangle rectangle;

    public Towers() {
        super.setDead(false);
    }

    public Towers(int x, int y, Map map, int health, int damage, int range, boolean dead) {
        super(x, y, map,health, damage, range, dead);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    @Override
    public void shot(Entity entity) {

        Soldiers soldier = (Soldiers) entity;

        soldier.setHealth(soldier.getHealth() - this.getDamage());

        if (soldier.getHealth() == 0) {
            soldier.setDead(true);
        }
    }



}
