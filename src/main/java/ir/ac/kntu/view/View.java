package ir.ac.kntu.view;

import ir.ac.kntu.soldier.*;
import ir.ac.kntu.tower.BlackTower;
import ir.ac.kntu.tower.ElectricTower;
import ir.ac.kntu.tower.Towers;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.util.ArrayList;

public class View extends Application {
    static ArrayList<ArrayList<String>> mapTable = new ArrayList<>();
    public void start(Stage primaryStage) throws Exception {
        Group group = new Group();
        Group groupMenu = new Group();
        Scene scene1 = new Scene(groupMenu,1230,700);
        primaryStage.setScene(scene1);
        Label map1 = new Label("Map1");
        Label map2 = new Label("Map2");
//        FileInputStream menuImage = null;
//        try {
//            menuImage = new FileInputStream("C:\\Users\\sdfab\\Desktop\\javafxtest\\src\\main\\resources\\img\\clashroyal.jpg");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        Image menuI = new Image(menuImage);
//        ImagePattern menu = new ImagePattern(menuI);
//        scene1.setFill(menu);
        map1.setLayoutX(500);
        map1.setLayoutY(500);
        map2.setLayoutX(500);
        map2.setLayoutY(600);
        groupMenu.getChildren().addAll(map1,map2);
        map1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                getMapTable();
                ArrayList<Rectangle> rectangles = new ArrayList<>();
                ArrayList<Soldiers> player1Soldiers = new ArrayList<>();
                ArrayList<Soldiers> player2Soldiers = new ArrayList<>();
                ArrayList<Towers> player1towers = new ArrayList<>();
                ArrayList<Towers> player2towers = new ArrayList<>();
//                boolean b = false;
//        try{
//            File f = new File("soliderPlayer1Info.txt");
//            if (f.length()!=0){
//                FileInputStream fileIn = new FileInputStream("soliderPlayer1Info.txt");
//                ObjectInputStream in = new ObjectInputStream(fileIn);
//                students2 = (ArrayList<Student>) in.readObject();
//                in.close();
//                fileIn.close();
//                b = true;
//            }
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }

                for(int i=0;i<mapTable.size();i++){
                    for(int j=0;j<mapTable.get(i).size();j++){

                        Rectangle rectangle =new Rectangle(30,30);

                        switch ((mapTable.get(i).get(j))){
                            case "w":rectangle.setFill(Color.rgb(246,130,38));break;
                            case " " :rectangle.setFill(Color.rgb(216,220,38));break;
                            case "." : rectangle.setFill(Color.rgb(246,16,38));break;
                            case "0":
                                FileInputStream image1F = null;
                                try {
                                    image1F = new FileInputStream("src/main/resources/img/Pig-Soldier1.jpg");
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                }
                                Image image1 = new Image(image1F);
                                rectangle.setFill(new ImagePattern(image1));
                                Archer archer = new Archer(rectangle.getX(), rectangle.getY(),300, 200, 2, false,15, 1, rectangle);
                                player1Soldiers.add(archer);
                                break;
                            case "1":FileInputStream image2F = null;
                                try {
                                    image2F = new FileInputStream("src/main/resources/img/Pig-Soldier2.jpg");
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                };Image image2 = new Image(image2F);rectangle.setFill(new ImagePattern(image2));
                                Goblin goblin = new Goblin(rectangle.getX(), rectangle.getY(),200, 250, 1, false,10, 3, rectangle);
                                player1Soldiers.add(goblin);
                                break;
                            case "2":FileInputStream image3F = null;
                                try {
                                    image3F = new FileInputStream("src/main/resources/img/Pig-Soldier3.jpg");
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                };Image image3 = new Image(image3F);rectangle.setFill(new ImagePattern(image3));
                                Shield shield = new Shield(rectangle.getX(), rectangle.getY(),1000, 150, 1, false,10, 1, rectangle);
                                player1Soldiers.add(shield);
                                break;
                            case "3":FileInputStream image4F = null;
                                try {
                                    image4F = new FileInputStream("src/main/resources/img/Pig-Soldier4.jpg");
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                };Image image4 = new Image(image4F);rectangle.setFill(new ImagePattern(image4));
                                Knight knight = new Knight(rectangle.getX(), rectangle.getY(),600, 400, 1, false,30, 2, rectangle);
                                player1Soldiers.add(knight);
                                break;
                            case "*":FileInputStream castleF = null;
                                try {
                                    castleF = new FileInputStream("src/main/resources/img/craft2.jpg");
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                };Image castle = new Image(castleF);rectangle.setFill(new ImagePattern(castle));break;
                            case "4" : FileInputStream craftF = null;
                                try {
                                    craftF = new FileInputStream("src/main/resources/img/castle.jpg");
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                };Image craft = new Image(craftF);rectangle.setFill(new ImagePattern(craft));
                                BlackTower blackTower1 = new BlackTower();
                                blackTower1.setRectangle(rectangle);
                                player2towers.add(blackTower1);
                                break;
                            case "5" : FileInputStream craft2F = null;
                                try {
                                    craft2F = new FileInputStream("src/main/resources/img/craft.jpg");
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                };Image craft2 = new Image(craft2F);rectangle.setFill(new ImagePattern(craft2));
                                ElectricTower electricTower = new ElectricTower();
                                electricTower.setRectangle(rectangle);
                                player2towers.add(electricTower);
                                break;
                            case "t":
                                FileInputStream craftF2 = null;
                                try {
                                    craftF2 = new FileInputStream("src/main/resources/img/castle.jpg");
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                };Image craft22 = new Image(craftF2);rectangle.setFill(new ImagePattern(craft22));
                                BlackTower blackTower12 = new BlackTower();
                                blackTower12.setRectangle(rectangle);
                                player1towers.add(blackTower12);
                                break;
                            case "e":
                                FileInputStream craft2F3 = null;
                                try {
                                    craft2F3 = new FileInputStream("src/main/resources/img/craft.jpg");
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                };Image craft23 = new Image(craft2F3);rectangle.setFill(new ImagePattern(craft23));
                                ElectricTower electricTower3 = new ElectricTower();
                                electricTower3.setRectangle(rectangle);
                                player1towers.add(electricTower3);
                                break;
                            case "6":
                                FileInputStream image1F2 = null;
                                try {
                                    image1F2 = new FileInputStream("src/main/resources/img/Pig-Soldier1.jpg");
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                };Image image12 = new Image(image1F2);rectangle.setFill(new ImagePattern(image12));
                                Archer archer2 = new Archer(rectangle.getX(), rectangle.getY(),300, 200, 2, false,15, 1, rectangle);
                                player2Soldiers.add(archer2);
                                break;
                            case "7":FileInputStream image2F2 = null;
                                try {
                                    image2F2 = new FileInputStream("src/main/resources/img/Pig-Soldier2.jpg");
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                };Image image22 = new Image(image2F2);rectangle.setFill(new ImagePattern(image22));
                                Goblin goblin2 = new Goblin(rectangle.getX(), rectangle.getY(),200, 250, 1, false,10, 3, rectangle);
                                player2Soldiers.add(goblin2);
                                break;
                            case "8":
                                FileInputStream image3F2 = null;
                                try {
                                    image3F2 = new FileInputStream("src/main/resources/img/Pig-Soldier3.jpg");
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                }
                                Image image32 = new Image(image3F2);
                                rectangle.setFill(new ImagePattern(image32));
                                Shield shield2 = new Shield(rectangle.getX(), rectangle.getY(),1000, 150, 1, false,10, 1, rectangle);
                                player2Soldiers.add(shield2);
                                break;
                            case "9":
                                FileInputStream image4F2 = null;
                                try {
                                    image4F2 = new FileInputStream("src/main/resources/img/Pig-Soldier4.jpg");
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                };Image image42 = new Image(image4F2);rectangle.setFill(new ImagePattern(image42));
                                Knight knight2 = new Knight(rectangle.getX(), rectangle.getY(),600, 400, 1, false,30, 2, rectangle);
                                player2Soldiers.add(knight2);
                                break;

                        }
                        rectangles.add(rectangle);
                        rectangle.setX(30 * j);
                        rectangle.setY(30 * i);
                    }
                }
                Button buttonSave = new Button("Save And Quite");
                buttonSave.setLayoutX(1100);
                buttonSave.setLayoutY(650);

                Label pl1 = new Label("Player1");pl1.setTextFill(Color.CYAN);
                Label h1 = new Label("Health : "+0);h1.setTextFill(Color.CYAN);
                Label e1 = new Label("Energy : "+0);e1.setTextFill(Color.CYAN);

                Label pl2 = new Label("Player2");pl2.setTextFill(Color.PINK);
                Label h2 = new Label("Health : "+0);h2.setTextFill(Color.PINK);
                Label e2 = new Label("Energy : "+0);e2.setTextFill(Color.PINK);

                Label blackT1 = new Label("Black Tower : "+2000);blackT1.setTextFill(Color.CYAN);
                blackT1.setLayoutY(650);
                blackT1.setLayoutX(170);
                Label electricT1 = new Label("Electric Tower : "+1500);electricT1.setTextFill(Color.CYAN);
                electricT1.setLayoutX(170);
                electricT1.setLayoutY(680);

                Label blackT2 = new Label("Black Tower : "+2000);blackT2.setTextFill(Color.PINK);
                blackT2.setLayoutY(650);
                blackT2.setLayoutX(800);
                Label electricT2 = new Label("Electric Tower : "+1500);electricT2.setTextFill(Color.PINK);
                electricT2.setLayoutX(800);
                electricT2.setLayoutY(680);


                VBox player1Info = new VBox(pl1,h1,e1);
                VBox player2Info = new VBox(pl2,h2,e2);
                player1Info.setLayoutY(640);
                player2Info.setLayoutY(640);
                player2Info.setLayoutX(640);

                final int[] counter = {1000};
                final int[] counter2 = {1000};
                final int[] selectedSoliderPlayer1 = {0};
                final int[] selectedSoliderPlayer2 = {0};


                Scene scene = new Scene(group, 1230, 700);
                group.getChildren().addAll(rectangles);
                group.getChildren().addAll(electricT1, electricT2, blackT1, blackT2);
                scene.setFill(Color.BLACK);
                player1towers.get(0).setHealth(2000);
                player1towers.get(1).setHealth(1500);
                player2towers.get(0).setHealth(2000);
                player2towers.get(1).setHealth(1500);
                AnimationTimer animationTimer = new AnimationTimer() {
                    @Override
                    public void handle(long l) {
                        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                            @Override
                            public void handle(KeyEvent keyEvent) {
                                if (keyEvent.getCode() == KeyCode.Z) {
//                            System.out.println("DOwn");
                                    counter[0]++;
                                    player1Soldiers.get(counter[0] % 4).getRectangle().setStrokeWidth(2);
                                    player1Soldiers.get(counter[0] % 4).getRectangle().setStroke(Color.BLACK);
                                    player1Soldiers.get((counter[0] - 1) % 4).getRectangle().setStrokeWidth(0);
                                    selectedSoliderPlayer1[0] = counter[0] % 4;
                                }
                                if (keyEvent.getCode() == KeyCode.X) {
                                    counter[0]--;
                                    player1Soldiers.get(counter[0] % 4).getRectangle().setStrokeWidth(2);
                                    player1Soldiers.get(counter[0] % 4).getRectangle().setStroke(Color.BLACK);
                                    player1Soldiers.get((counter[0] + 1) % 4).getRectangle().setStrokeWidth(0);
                                    selectedSoliderPlayer1[0] = counter[0] % 4;
                                }
                                if (keyEvent.getCode().equals(KeyCode.N)) {
                                    counter2[0]++;
                                    player2Soldiers.get(counter2[0] % 4).getRectangle().setStrokeWidth(2);
                                    player2Soldiers.get(counter2[0] % 4).getRectangle().setStroke(Color.BLACK);
                                    player2Soldiers.get((counter2[0] - 1) % 4).getRectangle().setStrokeWidth(0);
                                    selectedSoliderPlayer2[0] = counter2[0] % 4;
                                }
                                if (keyEvent.getCode() == KeyCode.M) {
                                    counter2[0]--;
                                    player2Soldiers.get(counter2[0] % 4).getRectangle().setStrokeWidth(2);
                                    player2Soldiers.get(counter2[0] % 4).getRectangle().setStroke(Color.BLACK);
                                    player2Soldiers.get((counter2[0] + 1) % 4).getRectangle().setStrokeWidth(0);
                                    selectedSoliderPlayer2[0] = counter2[0] % 4;
                                }
                                if (keyEvent.getCode() == KeyCode.V) {
                                    player1Soldiers.get(selectedSoliderPlayer1[0]).getRectangle().setX(1140);
                                    player1Soldiers.get(selectedSoliderPlayer1[0]).getRectangle().setY(60);
                                    player2Soldiers.get(selectedSoliderPlayer2[0]).getRectangle().setX(60);
                                    player2Soldiers.get(selectedSoliderPlayer2[0]).getRectangle().setY(360);
                                    h1.setText("Health : " + String.valueOf(player1Soldiers.get(selectedSoliderPlayer1[0]).getHealth()));
                                    h2.setText("Health : " + String.valueOf(player2Soldiers.get(selectedSoliderPlayer2[0]).getHealth()));

                                }
                                if (keyEvent.getCode() == KeyCode.A) {
                                    player1Soldiers.get(selectedSoliderPlayer1[0]).getRectangle().setX(player1Soldiers.get(selectedSoliderPlayer1[0]).getRectangle().getX() - 20);
                                }
                                if (keyEvent.getCode() == KeyCode.W) {
                                    player1Soldiers.get(selectedSoliderPlayer1[0]).getRectangle().setY(player1Soldiers.get(selectedSoliderPlayer1[0]).getRectangle().getY() - 20);
                                }
                                if (keyEvent.getCode() == KeyCode.S) {
                                    player1Soldiers.get(selectedSoliderPlayer1[0]).getRectangle().setY(player1Soldiers.get(selectedSoliderPlayer1[0]).getRectangle().getY() + 20);
                                }
                                if (keyEvent.getCode() == KeyCode.D) {
                                    player1Soldiers.get(selectedSoliderPlayer1[0]).getRectangle().setX(player1Soldiers.get(selectedSoliderPlayer1[0]).getRectangle().getX() + 20);
                                }
                                if (keyEvent.getCode() == KeyCode.J) {
                                    player2Soldiers.get(selectedSoliderPlayer2[0]).getRectangle().setY(player2Soldiers.get(selectedSoliderPlayer2[0]).getRectangle().getY() + 20);
                                }
                                if (keyEvent.getCode() == KeyCode.H) {
                                    player2Soldiers.get(selectedSoliderPlayer2[0]).getRectangle().setX(player2Soldiers.get(selectedSoliderPlayer2[0]).getRectangle().getX() - 20);
                                }
                                if (keyEvent.getCode() == KeyCode.U) {
                                    player2Soldiers.get(selectedSoliderPlayer2[0]).getRectangle().setY(player2Soldiers.get(selectedSoliderPlayer2[0]).getRectangle().getY() - 20);
                                }
                                if (keyEvent.getCode() == KeyCode.K) {
                                    player2Soldiers.get(selectedSoliderPlayer2[0]).getRectangle().setX(player2Soldiers.get(selectedSoliderPlayer2[0]).getRectangle().getX() + 20);
                                }
                                if (player2Soldiers.get(selectedSoliderPlayer2[0]).getRectangle().getX()>=920 && player2Soldiers.get(selectedSoliderPlayer2[0]).getRectangle().getX()<=1060 && player2Soldiers.get(selectedSoliderPlayer2[0]).getRectangle().getY()>=340 && player2Soldiers.get(selectedSoliderPlayer2[0]).getRectangle().getY()<=480) {

                                    if (keyEvent.getCode() == KeyCode.P) {
//                                System.out.println(player2Soldiers.get(selectedSoliderPlayer2[0]).getRectangle().getY());
                                        if (player1towers.get(0).getHealth() - 100 > 0) {
                                            player1towers.get(0).setHealth(player1towers.get(0).getHealth() - 100);
                                            blackT1.setText("Black Tower Health : " + player1towers.get(0).getHealth());
                                        } else{
                                            player1towers.get(0).setHealth(0);
                                            player1towers.get(0).getRectangle().setVisible(false);
                                            blackT1.setText("Black Tower Health : " + 0);
                                        }
                                    }
                                }
                                if (player1Soldiers.get(selectedSoliderPlayer1[0]).getRectangle().getX()>=160 && player1Soldiers.get(selectedSoliderPlayer1[0]).getRectangle().getX()<=260 && player1Soldiers.get(selectedSoliderPlayer1[0]).getRectangle().getY()>=40 && player1Soldiers.get(selectedSoliderPlayer1[0]).getRectangle().getY()<=140) {
                                    if (keyEvent.getCode() == KeyCode.Q) {
//                                System.out.println(player1Soldiers.get(selectedSoliderPlayer1[0]).getRectangle().getY());
                                        if (player2towers.get(0).getHealth() - 100 > 0) {
                                            player2towers.get(0).setHealth(player2towers.get(0).getHealth() - 100);
                                            blackT2.setText("Black Tower Health : " + player2towers.get(0).getHealth());
                                        } else{
                                            player2towers.get(0).setHealth(0);
                                            player2towers.get(0).getRectangle().setVisible(false);
                                            blackT2.setText("Black Tower Health : " + 0);
                                        }
                                    }
                                }
                            }
                        });
                    }
                };
                animationTimer.start();
                buttonSave.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        try {
                            FileOutputStream fout1=new  FileOutputStream("soliderPlayer1Info.txt");
                            ObjectOutputStream out1=new  ObjectOutputStream(fout1);
                            for (Soldiers soldiers:player1Soldiers){
                                out1.writeObject(soldiers);
                            }
                            out1.close();
                            System.out.println("Saved!");
                            FileOutputStream fout2=new  FileOutputStream("soliderPlayer2Info.txt");
                            ObjectOutputStream out2=new  ObjectOutputStream(fout2);
                            for (Soldiers soldiers:player2Soldiers){
                                out2.writeObject(soldiers);
                            }
                            out2.close();
                            System.out.println("Saved!");
                            FileOutputStream fout31=new  FileOutputStream("towerPlayer1Info.txt");
                            ObjectOutputStream out31=new  ObjectOutputStream(fout31);
                            for (Towers tower:player1towers){
                                out31.writeObject(tower);
                            }
                            out31.close();
                            System.out.println("Saved!");
                            FileOutputStream fout32=new  FileOutputStream("towerPlayer2Info.txt");
                            ObjectOutputStream out32=new  ObjectOutputStream(fout32);
                            for (Towers tower:player2towers){
                                out32.writeObject(tower);
                            }
                            out32.close();
                            System.out.println("Saved!");
                        }catch (Exception e){
                            e.printStackTrace();
                            System.out.println("failed");
                        }
                    }
                });
                final Timeline timeline = new Timeline(
                        new KeyFrame(
                                Duration.millis( 1000 ),
                                event -> {
                                    if (player1Soldiers.get(selectedSoliderPlayer1[0]).getEnergy()>=1000 || player2Soldiers.get(selectedSoliderPlayer2[0]).getEnergy()>=1000){
                                        Label label = new Label("Game Over!");
                                        label.setLayoutX(600);
                                        label.setLayoutY(350);
                                        group.getChildren().add(label);

                                    }else {
                                        player1Soldiers.get(selectedSoliderPlayer1[0]).setEnergy(player1Soldiers.get(selectedSoliderPlayer1[0]).getEnergy()+10);
                                        player2Soldiers.get(selectedSoliderPlayer2[0]).setEnergy(player2Soldiers.get(selectedSoliderPlayer2[0]).getEnergy()+10);
                                        e1.setText("Energy : "+player1Soldiers.get(selectedSoliderPlayer1[0]).getEnergy());
                                        e2.setText("Energy : "+player2Soldiers.get(selectedSoliderPlayer2[0]).getEnergy());
                                    }

                                    if (player1Soldiers.get(selectedSoliderPlayer1[0]).getRectangle().getX()>=160 && player1Soldiers.get(selectedSoliderPlayer1[0]).getRectangle().getX()<=260 && player1Soldiers.get(selectedSoliderPlayer1[0]).getRectangle().getY()>=40 && player1Soldiers.get(selectedSoliderPlayer1[0]).getRectangle().getY()<=140) {
                                        if (player1Soldiers.get(selectedSoliderPlayer1[0]).getHealth() - 1 > 0) {
                                            player1Soldiers.get(selectedSoliderPlayer1[0]).setHealth(player1Soldiers.get(selectedSoliderPlayer1[0]).getHealth() - 1);
                                            h1.setText("Health : " + player1Soldiers.get(selectedSoliderPlayer1[0]).getHealth());
                                        } else{
                                            player1Soldiers.get(selectedSoliderPlayer1[0]).setHealth(0);
                                            player1Soldiers.get(selectedSoliderPlayer1[0]).getRectangle().setVisible(false);
                                            h1.setText("Health : " + 0);
                                        }
                                    }
                                }
                        )
                );
                timeline.setCycleCount( Animation.INDEFINITE );
                timeline.play();

                group.getChildren().addAll(player1Info,player2Info, buttonSave);

                primaryStage.setTitle("Clash Royal");

                primaryStage.setScene(scene);

            }
        });
        map2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                getMapTable2();
//        Circle circle=new Circle();
                ArrayList<Rectangle> rectangles = new ArrayList<>();
                ArrayList<Soldiers> player1Soldiers = new ArrayList<>();
                ArrayList<Soldiers> player2Soldiers = new ArrayList<>();
                ArrayList<Towers> player1towers = new ArrayList<>();
                ArrayList<Towers> player2towers = new ArrayList<>();
                boolean b = false;
//        try{
//            File f = new File("soliderPlayer1Info.txt");
//            if (f.length()!=0){
//                FileInputStream fileIn = new FileInputStream("soliderPlayer1Info.txt");
//                ObjectInputStream in = new ObjectInputStream(fileIn);
//                students2 = (ArrayList<Student>) in.readObject();
//                in.close();
//                fileIn.close();
//                b = true;
//            }
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }

                for(int i=0;i<mapTable.size();i++){
                    for(int j=0;j<mapTable.get(i).size();j++){

                        Rectangle rectangle =new Rectangle(30,30);

                        switch ((mapTable.get(i).get(j))){
                            case "w":rectangle.setFill(Color.rgb(246,130,38));break;
                            case " " :rectangle.setFill(Color.rgb(216,220,38));break;
                            case "." : rectangle.setFill(Color.rgb(246,16,38));break;
                            case "0":
                                FileInputStream image1F = null;
                                try {
                                    image1F = new FileInputStream("src/main/resources/img/Pig-Soldier1.jpg");
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                }
                                Image image1 = new Image(image1F);
                                rectangle.setFill(new ImagePattern(image1));
                                Archer archer = new Archer(rectangle.getX(), rectangle.getY(),300, 200, 2, false,15, 1, rectangle);
                                player1Soldiers.add(archer);
                                break;
                            case "1":FileInputStream image2F = null;
                                try {
                                    image2F = new FileInputStream("src/main/resources/img/Pig-Soldier2.jpg");
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                };Image image2 = new Image(image2F);rectangle.setFill(new ImagePattern(image2));
                                Goblin goblin = new Goblin(rectangle.getX(), rectangle.getY(),200, 250, 1, false,10, 3, rectangle);
                                player1Soldiers.add(goblin);
                                break;
                            case "2":FileInputStream image3F = null;
                                try {
                                    image3F = new FileInputStream("src/main/resources/img/Pig-Soldier3.jpg");
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                };Image image3 = new Image(image3F);rectangle.setFill(new ImagePattern(image3));
                                Shield shield = new Shield(rectangle.getX(), rectangle.getY(),1000, 150, 1, false,10, 1, rectangle);
                                player1Soldiers.add(shield);
                                break;
                            case "3":FileInputStream image4F = null;
                                try {
                                    image4F = new FileInputStream("src/main/resources/img/Pig-Soldier4.jpg");
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                };Image image4 = new Image(image4F);rectangle.setFill(new ImagePattern(image4));
                                Knight knight = new Knight(rectangle.getX(), rectangle.getY(),600, 400, 1, false,30, 2, rectangle);
                                player1Soldiers.add(knight);
                                break;
                            case "*":FileInputStream castleF = null;
                                try {
                                    castleF = new FileInputStream("src/main/resources/img/craft2.jpg");
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                };Image castle = new Image(castleF);rectangle.setFill(new ImagePattern(castle));break;
                            case "4" : FileInputStream craftF = null;
                                try {
                                    craftF = new FileInputStream("src/main/resources/img/castle.jpg");
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                };Image craft = new Image(craftF);rectangle.setFill(new ImagePattern(craft));
                                BlackTower blackTower1 = new BlackTower();
                                blackTower1.setRectangle(rectangle);
                                player2towers.add(blackTower1);
                                break;
                            case "5" : FileInputStream craft2F = null;
                                try {
                                    craft2F = new FileInputStream("src/main/resources/img/craft.jpg");
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                };Image craft2 = new Image(craft2F);rectangle.setFill(new ImagePattern(craft2));
                                ElectricTower electricTower = new ElectricTower();
                                electricTower.setRectangle(rectangle);
                                player2towers.add(electricTower);
                                break;
                            case "t":
                                FileInputStream craftF2 = null;
                                try {
                                    craftF2 = new FileInputStream("src/main/resources/img/castle.jpg");
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                };Image craft22 = new Image(craftF2);rectangle.setFill(new ImagePattern(craft22));
                                BlackTower blackTower12 = new BlackTower();
                                blackTower12.setRectangle(rectangle);
                                player1towers.add(blackTower12);
                                break;
                            case "e":
                                FileInputStream craft2F3 = null;
                                try {
                                    craft2F3 = new FileInputStream("src/main/resources/img/craft.jpg");
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                };Image craft23 = new Image(craft2F3);rectangle.setFill(new ImagePattern(craft23));
                                ElectricTower electricTower3 = new ElectricTower();
                                electricTower3.setRectangle(rectangle);
                                player1towers.add(electricTower3);
                                break;
                            case "6":
                                FileInputStream image1F2 = null;
                                try {
                                    image1F2 = new FileInputStream("src/main/resources/img/Pig-Soldier1.jpg");
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                };Image image12 = new Image(image1F2);rectangle.setFill(new ImagePattern(image12));
                                Archer archer2 = new Archer(rectangle.getX(), rectangle.getY(),300, 200, 2, false,15, 1, rectangle);
                                player2Soldiers.add(archer2);
                                break;
                            case "7":FileInputStream image2F2 = null;
                                try {
                                    image2F2 = new FileInputStream("src/main/resources/img/Pig-Soldier2.jpg");
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                };Image image22 = new Image(image2F2);rectangle.setFill(new ImagePattern(image22));
                                Goblin goblin2 = new Goblin(rectangle.getX(), rectangle.getY(),200, 250, 1, false,10, 3, rectangle);
                                player2Soldiers.add(goblin2);
                                break;
                            case "8":
                                FileInputStream image3F2 = null;
                                try {
                                    image3F2 = new FileInputStream("src/main/resources/img/Pig-Soldier3.jpg");
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                }
                                Image image32 = new Image(image3F2);
                                rectangle.setFill(new ImagePattern(image32));
                                Shield shield2 = new Shield(rectangle.getX(), rectangle.getY(),1000, 150, 1, false,10, 1, rectangle);
                                player2Soldiers.add(shield2);
                                break;
                            case "9":
                                FileInputStream image4F2 = null;
                                try {
                                    image4F2 = new FileInputStream("src/main/resources/img/Pig-Soldier4.jpg");
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                };Image image42 = new Image(image4F2);rectangle.setFill(new ImagePattern(image42));
                                Knight knight2 = new Knight(rectangle.getX(), rectangle.getY(),600, 400, 1, false,30, 2, rectangle);
                                player2Soldiers.add(knight2);
                                break;

                        }
                        rectangles.add(rectangle);
                        rectangle.setX(30 * j);
                        rectangle.setY(30 * i);
                    }
                }
                Button buttonSave = new Button("Save And Quite");
                buttonSave.setLayoutX(1100);
                buttonSave.setLayoutY(650);

                Label pl1 = new Label("Player1");pl1.setTextFill(Color.CYAN);
                Label h1 = new Label("Health : "+0);h1.setTextFill(Color.CYAN);
                Label e1 = new Label("Energy : "+0);e1.setTextFill(Color.CYAN);

                Label pl2 = new Label("Player2");pl2.setTextFill(Color.PINK);
                Label h2 = new Label("Health : "+0);h2.setTextFill(Color.PINK);
                Label e2 = new Label("Energy : "+0);e2.setTextFill(Color.PINK);

                Label blackT1 = new Label("Black Tower : "+2000);blackT1.setTextFill(Color.CYAN);
                blackT1.setLayoutY(650);
                blackT1.setLayoutX(170);
                Label electricT1 = new Label("Electric Tower : "+1500);electricT1.setTextFill(Color.CYAN);
                electricT1.setLayoutX(170);
                electricT1.setLayoutY(680);

                Label blackT2 = new Label("Black Tower : "+2000);blackT2.setTextFill(Color.PINK);
                blackT2.setLayoutY(650);
                blackT2.setLayoutX(800);
                Label electricT2 = new Label("Electric Tower : "+1500);electricT2.setTextFill(Color.PINK);
                electricT2.setLayoutX(800);
                electricT2.setLayoutY(680);


                VBox player1Info = new VBox(pl1,h1,e1);
                VBox player2Info = new VBox(pl2,h2,e2);
                player1Info.setLayoutY(640);
                player2Info.setLayoutY(640);
                player2Info.setLayoutX(640);

                final int[] counter = {1000};
                final int[] counter2 = {1000};
                final int[] selectedSoliderPlayer1 = {0};
                final int[] selectedSoliderPlayer2 = {0};
                Scene scene = new Scene(group, 1230, 700);
                group.getChildren().addAll(rectangles);
                group.getChildren().addAll(electricT1, electricT2, blackT1, blackT2);
                scene.setFill(Color.BLACK);
                player1towers.get(0).setHealth(2000);
                player1towers.get(1).setHealth(1500);
                player2towers.get(0).setHealth(2000);
                player2towers.get(1).setHealth(1500);
                AnimationTimer animationTimer = new AnimationTimer() {
                    @Override
                    public void handle(long l) {
                        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                            @Override
                            public void handle(KeyEvent keyEvent) {
                                if (keyEvent.getCode() == KeyCode.Z) {
//                            System.out.println("DOwn");
                                    counter[0]++;
                                    player1Soldiers.get(counter[0] % 4).getRectangle().setStrokeWidth(2);
                                    player1Soldiers.get(counter[0] % 4).getRectangle().setStroke(Color.BLACK);
                                    player1Soldiers.get((counter[0] - 1) % 4).getRectangle().setStrokeWidth(0);
                                    selectedSoliderPlayer1[0] = counter[0] % 4;
                                }
                                if (keyEvent.getCode() == KeyCode.X) {
                                    counter[0]--;
                                    player1Soldiers.get(counter[0] % 4).getRectangle().setStrokeWidth(2);
                                    player1Soldiers.get(counter[0] % 4).getRectangle().setStroke(Color.BLACK);
                                    player1Soldiers.get((counter[0] + 1) % 4).getRectangle().setStrokeWidth(0);
                                    selectedSoliderPlayer1[0] = counter[0] % 4;
                                }
                                if (keyEvent.getCode().equals(KeyCode.N)) {
                                    counter2[0]++;
                                    player2Soldiers.get(counter2[0] % 4).getRectangle().setStrokeWidth(2);
                                    player2Soldiers.get(counter2[0] % 4).getRectangle().setStroke(Color.BLACK);
                                    player2Soldiers.get((counter2[0] - 1) % 4).getRectangle().setStrokeWidth(0);
                                    selectedSoliderPlayer2[0] = counter2[0] % 4;
                                }
                                if (keyEvent.getCode() == KeyCode.M) {
                                    counter2[0]--;
                                    player2Soldiers.get(counter2[0] % 4).getRectangle().setStrokeWidth(2);
                                    player2Soldiers.get(counter2[0] % 4).getRectangle().setStroke(Color.BLACK);
                                    player2Soldiers.get((counter2[0] + 1) % 4).getRectangle().setStrokeWidth(0);
                                    selectedSoliderPlayer2[0] = counter2[0] % 4;
                                }
                                if (keyEvent.getCode() == KeyCode.V) {
                                    player1Soldiers.get(selectedSoliderPlayer1[0]).getRectangle().setX(1140);
                                    player1Soldiers.get(selectedSoliderPlayer1[0]).getRectangle().setY(60);
                                    player2Soldiers.get(selectedSoliderPlayer2[0]).getRectangle().setX(60);
                                    player2Soldiers.get(selectedSoliderPlayer2[0]).getRectangle().setY(360);
                                    h1.setText("Health : " + String.valueOf(player1Soldiers.get(selectedSoliderPlayer1[0]).getHealth()));
                                    h2.setText("Health : " + String.valueOf(player2Soldiers.get(selectedSoliderPlayer2[0]).getHealth()));

                                }
                                if (keyEvent.getCode() == KeyCode.A) {
                                    player1Soldiers.get(selectedSoliderPlayer1[0]).getRectangle().setX(player1Soldiers.get(selectedSoliderPlayer1[0]).getRectangle().getX() - 20);
                                }
                                if (keyEvent.getCode() == KeyCode.W) {
                                    player1Soldiers.get(selectedSoliderPlayer1[0]).getRectangle().setY(player1Soldiers.get(selectedSoliderPlayer1[0]).getRectangle().getY() - 20);
                                }
                                if (keyEvent.getCode() == KeyCode.S) {
                                    player1Soldiers.get(selectedSoliderPlayer1[0]).getRectangle().setY(player1Soldiers.get(selectedSoliderPlayer1[0]).getRectangle().getY() + 20);
                                }
                                if (keyEvent.getCode() == KeyCode.D) {
                                    player1Soldiers.get(selectedSoliderPlayer1[0]).getRectangle().setX(player1Soldiers.get(selectedSoliderPlayer1[0]).getRectangle().getX() + 20);
                                }
                                if (keyEvent.getCode() == KeyCode.J) {
                                    player2Soldiers.get(selectedSoliderPlayer2[0]).getRectangle().setY(player2Soldiers.get(selectedSoliderPlayer2[0]).getRectangle().getY() + 20);
                                }
                                if (keyEvent.getCode() == KeyCode.H) {
                                    player2Soldiers.get(selectedSoliderPlayer2[0]).getRectangle().setX(player2Soldiers.get(selectedSoliderPlayer2[0]).getRectangle().getX() - 20);
                                }
                                if (keyEvent.getCode() == KeyCode.U) {
                                    player2Soldiers.get(selectedSoliderPlayer2[0]).getRectangle().setY(player2Soldiers.get(selectedSoliderPlayer2[0]).getRectangle().getY() - 20);
                                }
                                if (keyEvent.getCode() == KeyCode.K) {
                                    player2Soldiers.get(selectedSoliderPlayer2[0]).getRectangle().setX(player2Soldiers.get(selectedSoliderPlayer2[0]).getRectangle().getX() + 20);
                                }
                                if (player2Soldiers.get(selectedSoliderPlayer2[0]).getRectangle().getX()>=920 && player2Soldiers.get(selectedSoliderPlayer2[0]).getRectangle().getX()<=1060 && player2Soldiers.get(selectedSoliderPlayer2[0]).getRectangle().getY()>=340 && player2Soldiers.get(selectedSoliderPlayer2[0]).getRectangle().getY()<=480) {

                                    if (keyEvent.getCode() == KeyCode.P) {
//                                System.out.println(player2Soldiers.get(selectedSoliderPlayer2[0]).getRectangle().getY());
                                        if (player1towers.get(0).getHealth() - 100 > 0) {
                                            player1towers.get(0).setHealth(player1towers.get(0).getHealth() - 100);
                                            blackT1.setText("Black Tower Health : " + player1towers.get(0).getHealth());
                                        } else{
                                            player1towers.get(0).setHealth(0);
                                            player1towers.get(0).getRectangle().setVisible(false);
                                            blackT1.setText("Black Tower Health : " + 0);
                                        }
                                    }
                                }
                                if (player1Soldiers.get(selectedSoliderPlayer1[0]).getRectangle().getX()>=160 && player1Soldiers.get(selectedSoliderPlayer1[0]).getRectangle().getX()<=260 && player1Soldiers.get(selectedSoliderPlayer1[0]).getRectangle().getY()>=40 && player1Soldiers.get(selectedSoliderPlayer1[0]).getRectangle().getY()<=140) {
                                    if (keyEvent.getCode() == KeyCode.Q) {
//                                System.out.println(player1Soldiers.get(selectedSoliderPlayer1[0]).getRectangle().getY());
                                        if (player2towers.get(0).getHealth() - 100 > 0) {
                                            player2towers.get(0).setHealth(player2towers.get(0).getHealth() - 100);
                                            blackT2.setText("Black Tower Health : " + player2towers.get(0).getHealth());
                                        } else{
                                            player2towers.get(0).setHealth(0);
                                            player2towers.get(0).getRectangle().setVisible(false);
                                            blackT2.setText("Black Tower Health : " + 0);
                                        }
                                    }
                                }
                                if (player1Soldiers.get(selectedSoliderPlayer1[0]).getRectangle().getX() >= 160 && player1Soldiers.get(selectedSoliderPlayer1[0]).getRectangle().getX() <= 260 && player1Soldiers.get(selectedSoliderPlayer1[0]).getRectangle().getY() >= 40 && player1Soldiers.get(selectedSoliderPlayer1[0]).getRectangle().getY() <= 140) {
                                    if (keyEvent.getCode() == KeyCode.E) {
//                                System.out.println(player2Soldiers.get(selectedSoliderPlayer2[0]).getRectangle().getY());
                                        if (player1towers.get(0).getHealth() - 100 > 0) {
                                            player1towers.get(0).setHealth(player1towers.get(0).getHealth() - 100);
                                            electricT1.setText("Electric Tower Health : " + player1towers.get(0).getHealth());
                                        } else {
                                            player1towers.get(0).setHealth(0);
                                            player1towers.get(0).getRectangle().setVisible(false);
                                            electricT1.setText("Electric Tower Health : " + 0);
                                        }
                                    }
                                }
                                if (player1Soldiers.get(selectedSoliderPlayer1[0]).getRectangle().getX()>=160 && player1Soldiers.get(selectedSoliderPlayer1[0]).getRectangle().getX()<=260 && player1Soldiers.get(selectedSoliderPlayer1[0]).getRectangle().getY()>=40 && player1Soldiers.get(selectedSoliderPlayer1[0]).getRectangle().getY()<=140) {
                                    if (keyEvent.getCode() == KeyCode.I) {
//                                System.out.println(player1Soldiers.get(selectedSoliderPlayer1[0]).getRectangle().getY());
                                        if (player2towers.get(0).getHealth() - 100 > 0) {
                                            player2towers.get(0).setHealth(player2towers.get(0).getHealth() - 100);
                                            electricT2.setText("Electric Tower Health : " + player2towers.get(0).getHealth());
                                        } else{
                                            player2towers.get(0).setHealth(0);
                                            player2towers.get(0).getRectangle().setVisible(false);
                                            electricT2.setText("Electric Tower Health : " + 0);
                                        }
                                    }
                                }

                            }
                        });
                    }
                };
                animationTimer.start();
                buttonSave.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        try {
                            FileOutputStream fout1=new  FileOutputStream("soliderPlayer1Info.txt");
                            ObjectOutputStream out1=new  ObjectOutputStream(fout1);
                            for (Soldiers soldiers:player1Soldiers){
                                out1.writeObject(soldiers);
                            }
                            out1.close();
                            System.out.println("Saved!");
                            FileOutputStream fout2=new  FileOutputStream("soliderPlayer2Info.txt");
                            ObjectOutputStream out2=new  ObjectOutputStream(fout2);
                            for (Soldiers soldiers:player2Soldiers){
                                out2.writeObject(soldiers);
                            }
                            out2.close();
                            System.out.println("Saved!");
                            FileOutputStream fout31=new  FileOutputStream("towerPlayer1Info.txt");
                            ObjectOutputStream out31=new  ObjectOutputStream(fout31);
                            for (Towers tower:player1towers){
                                out31.writeObject(tower);
                            }
                            out31.close();
                            System.out.println("Saved!");
                            FileOutputStream fout32=new  FileOutputStream("towerPlayer2Info.txt");
                            ObjectOutputStream out32=new  ObjectOutputStream(fout32);
                            for (Towers tower:player2towers){
                                out32.writeObject(tower);
                            }
                            out32.close();
                            System.out.println("Saved!");
                        }catch (Exception e){
                            e.printStackTrace();
                            System.out.println("failed");
                        }
                    }
                });
                final Timeline timeline = new Timeline(
                        new KeyFrame(
                                Duration.millis( 1000 ),
                                event -> {
                                    if (player1Soldiers.get(selectedSoliderPlayer1[0]).getEnergy()>=1000 || player2Soldiers.get(selectedSoliderPlayer2[0]).getEnergy()>=1000){
                                        Label label = new Label("Game Over!");
                                        label.setLayoutX(600);
                                        label.setLayoutY(350);
                                        group.getChildren().add(label);

                                    }else {
                                        player1Soldiers.get(selectedSoliderPlayer1[0]).setEnergy(player1Soldiers.get(selectedSoliderPlayer1[0]).getEnergy()+10);
                                        player2Soldiers.get(selectedSoliderPlayer2[0]).setEnergy(player2Soldiers.get(selectedSoliderPlayer2[0]).getEnergy()+10);
                                        e1.setText("Energy : "+player1Soldiers.get(selectedSoliderPlayer1[0]).getEnergy());
                                        e2.setText("Energy : "+player2Soldiers.get(selectedSoliderPlayer2[0]).getEnergy());
                                    }

                                    if (player1Soldiers.get(selectedSoliderPlayer1[0]).getRectangle().getX()>=160 && player1Soldiers.get(selectedSoliderPlayer1[0]).getRectangle().getX()<=260 && player1Soldiers.get(selectedSoliderPlayer1[0]).getRectangle().getY()>=40 && player1Soldiers.get(selectedSoliderPlayer1[0]).getRectangle().getY()<=140) {
                                        if (player1Soldiers.get(selectedSoliderPlayer1[0]).getHealth() - 1 > 0) {
                                            player1Soldiers.get(selectedSoliderPlayer1[0]).setHealth(player1Soldiers.get(selectedSoliderPlayer1[0]).getHealth() - 1);
                                            h1.setText("Health : " + player1Soldiers.get(selectedSoliderPlayer1[0]).getHealth());
                                        } else{
                                            player1Soldiers.get(selectedSoliderPlayer1[0]).setHealth(0);
                                            player1Soldiers.get(selectedSoliderPlayer1[0]).getRectangle().setVisible(false);
                                            h1.setText("Health : " + 0);
                                        }
                                    }
                                    if (player2Soldiers.get(selectedSoliderPlayer2[0]).getRectangle().getX()>=160 && player2Soldiers.get(selectedSoliderPlayer2[0]).getRectangle().getX()<=260 && player2Soldiers.get(selectedSoliderPlayer2[0]).getRectangle().getY()>=40 && player2Soldiers.get(selectedSoliderPlayer2[0]).getRectangle().getY()<=140) {
                                        if (player2Soldiers.get(selectedSoliderPlayer2[0]).getHealth() - 1 > 0) {
                                            player2Soldiers.get(selectedSoliderPlayer2[0]).setHealth(player2Soldiers.get(selectedSoliderPlayer2[0]).getHealth() - 1);
                                            h2.setText("Health : " + player2Soldiers.get(selectedSoliderPlayer2[0]).getHealth());
                                        } else{
                                            player2Soldiers.get(selectedSoliderPlayer2[0]).setHealth(0);
                                            player2Soldiers.get(selectedSoliderPlayer2[0]).getRectangle().setVisible(false);
                                            h2.setText("Health : " + 0);
                                        }
                                    }

                                }
                        )
                );
                timeline.setCycleCount( Animation.INDEFINITE );
                timeline.play();

                group.getChildren().addAll(player1Info,player2Info, buttonSave);

                primaryStage.setTitle("Clash Royal");

                primaryStage.setScene(scene);
            }
        });
        primaryStage.show();
    }
    public static void getMapTable(){
        try(BufferedReader reader = new BufferedReader(new FileReader(new File("src/main/resources/map.txt")))) {
            String line;
            while ((line=reader.readLine()) != null){
                ArrayList<String> temp = new ArrayList<>();
                for(int i=0;i<line.length();i++){
                    temp.add(String.valueOf(line.charAt(i)));

                }
                mapTable.add(temp);
            }
        } catch (Exception ignored){}
    }
    public static void getMapTable2(){
        try(BufferedReader reader = new BufferedReader(new FileReader(new File("src/main/resources/map2.txt")))) {
            String line;
            while ((line=reader.readLine()) != null){
                ArrayList<String> temp = new ArrayList<>();
                for(int i=0;i<line.length();i++){
                    temp.add(String.valueOf(line.charAt(i)));

                }
                mapTable.add(temp);
            }
        } catch (Exception ignored){}
    }
    public static void main(String[] args) {
        launch(args);
    }
}