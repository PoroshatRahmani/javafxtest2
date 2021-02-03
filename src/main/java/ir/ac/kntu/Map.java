package ir.ac.kntu;

import ir.ac.kntu.soldier.Archer;
import ir.ac.kntu.soldier.Goblin;
import ir.ac.kntu.soldier.Knight;
import ir.ac.kntu.soldier.Shield;
import ir.ac.kntu.tower.BlackTower;
import ir.ac.kntu.tower.ElectricTower;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Map {

    private int rows;
    private int columns;
    private Entity[][] cells;
    private ArrayList<Entity> entities = new ArrayList<Entity>();
    private char[][] map;
    private boolean lost = false;
    ArrayList<Rectangle> rectangles;

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }

    public Map(int rows, int cols) {
        this.rows = rows;
        this.columns = cols;
        this.cells = new Entity[rows][cols];

        this.map = MapConvertor.StringTo2D_CharArray(
                MapReader.readFile(Consts.getMap()), rows, cols);



        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                switch(this.map[i][j]) {
                    case '0':
                        this.cells[i][j] = new Archer(i, j, this, Consts.getPig1());
                        this.entities.add(this.cells[i][j]);
                        break;
                    case '1':
                        this.cells[i][j] = new Goblin(i, j, this, Consts.getPig2());
                        this.entities.add(this.cells[i][j]);
                        break;
                    case '2':
                        this.cells[i][j] = new Knight(i, j, this, Consts.getPig3());
                        this.entities.add(this.cells[i][j]);
                        break;
                    case '3':
                        this.cells[i][j] = new Shield(i, j, this, Consts.getPig4());
                        this.entities.add(this.cells[i][j]);
                        break;
                    case '4':
                        this.cells[i][j] = new BlackTower(i, j, this, Consts.getCastle());
                        this.entities.add(this.cells[i][j]);
                        break;
                    case '5':
                        this.cells[i][j] = new ElectricTower(i, j, this, Consts.getCraft2());
                        this.entities.add(this.cells[i][j]);
                        break;
                    case '*':
                        this.cells[i][j] = new Castle(i, j, this, Consts.getCraft());
                        this.entities.add(this.cells[i][j]);
                        break;
                    case 'w':
                        this.cells[i][j] = new Entity(i, j,  Consts.getWall(),this) {
                            @Override
                            public void shot(Entity entity) {}
                        };
                        this.entities.add(this.cells[i][j]);
                        break;

                }
            }
        }

    }
}
