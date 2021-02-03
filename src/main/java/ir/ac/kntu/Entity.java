package ir.ac.kntu;

import java.io.Serializable;

public abstract class Entity implements Serializable {
    private double x;
    private double y;
    private String imgPath;
    private  int health;
    private  int damage;
    private  int range;
    private boolean dead;
    private Map grid;

    public Entity() {
    }

    public Entity(double x, double y, int health, int damage, int range, boolean dead) {
        this.x = x;
        this.y = y;
        this.health = health;
        this.damage = damage;
        this.range = range;
        this.dead = dead;
    }

    public Entity(double x, double y, String imgPath, Map grid) {
        this.x = x;
        this.y = y;
        this.imgPath = imgPath;
        this.grid = grid;
    }

    public Entity(double x, double y, Map map, int health, int damage, int range, boolean dead) {
        this.x = x;
        this.y = y;
        this.health = health;
        this.damage = damage;
        this.range = range;
        this.dead = dead;
        this.grid = map;
    }

    public abstract void shot(Entity entity);
    public boolean isInRange(Entity entity){

        double distance = Math.sqrt(
                ((entity.getX() - this.getX())*(entity.getX() - this.getX()))
                + ((entity.getY() - this.getY())*(entity.getY() - this.getY())));
        return this.getRange() <= distance;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public Map getGrid() {
        return grid;
    }

    public void setGrid(Map grid) {
        this.grid = grid;

    }

    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }
}
