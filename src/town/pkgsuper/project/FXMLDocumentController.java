/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package town.pkgsuper.project;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.animation.AnimationTimer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author shah1932
 */
public class FXMLDocumentController implements Initializable {
    private double probTime = 1, superTime = -1;
    private int dayTime =1;
    private double health = 20;//same as townHeal from town class
    private boolean ifProb = false, end = false, contin = false;
    private int sCount = 0, rCount = 0, cCount = 0, salary = 20000, buildGone = 0, pop = 50000 , numDie = 0, numBorn = 0;
    Town townClass = new Town();
    Superheroes superClass = new Superheroes();
    Civilians peopleClass = new Civilians();
    ArrayList <String> destroyedBuilds= new ArrayList<>();
    @FXML
    private Label day, infoLab, tMoney, superDie, totpop, die, born;
    @FXML
    private ProgressBar theal;
    @FXML
    private ProgressBar desLevel;
    @FXML
    private ListView buildLV;
    ObservableList <String> displayList = FXCollections.observableArrayList();
    @FXML
    private ListView destroyedBuild;
    ObservableList <String> showList = FXCollections.observableArrayList();
    @FXML
    private ImageView background;
    @FXML
    private void handleButtonAction(ActionEvent event) {
        town();
        start();
        //Town Interaction:
        /*
            Need a 2d array that contains the building cost, strength, and health of each building.
            Use a loop to add 30 buildings of all types ie. school, hospital, a work building, 
            a police station, apartment building, homes, city hall, or hotels.
            A statement in the loop will call the town class
        */
        //Problem Creator:
        /*
            A random number will determine if a problem arises (1-6; <3 is a problem)
            If a problem arises the problem class will be called
        */
        //Timer:
        /*
            Each day will be 7 seconds long, however, when a problem occurs, the day will be longer to represent how long it would take the superhero to slove the problem
            Added time will be based on the difficultly of the problem.
        */
        //Civilians:
        /*
            An integer will represent the number of civilians in the town.
            This intial number will change as people are being born and as people die.
            If the population becomes 0, the game will end, and the mayor has lost.
            The civilian class will be called after each problem.
        */
        //Superheros:
        /*
            There will be an array list that will represent all of the superheroes in this town.
            The array is going to be integers that will correspond to the villain array list.
            When a proble arises, the superhero class will be called.
        */
        //Mayor:
        /*
            Once the mayor is informed of the problem, and the problem is solved, the mayor will recieve a report of all the information.
            The mayor has to decide which buildings to save, this will call the mayor class.
        */
        //Report:
        /*
            All of the information will be returned back to the user/mayor
        */
    }
    @FXML
    private void keepPlaying(ActionEvent event){
        contin = true;
    }
    private void setInitial(){
        theal.setProgress(1);
        day.setText(Integer.toString(1));
        tMoney.setText(Integer.toString(salary));
        totpop.setText("");
        die.setText("");
        born.setText("");
        town();
    }
    ArrayList <Town> buildings= new ArrayList<>();
    ArrayList <String> typesOfBuild= new ArrayList<>();
    private void town(){
        boolean keepBuild = true;
        int buildCount = 0; 
        int whichType;
        for(int i = 0; i<21 ; i++){
            buildings.add(new Town());
            buildLV.setItems(displayList);
            
        }
        for(int i = 0; i<21 ; i++){
            destroyedBuild.setItems(showList);
            destroyedBuilds.add(townClass.getDestroyed());
        }
        while(keepBuild==true){
            whichType = (int) Math.floor(Math.random()*3)+1;
            if(whichType==1 && sCount<4){
                sCount++;
                buildCount++;
                typesOfBuild.add("School");
                displayList.add("School" + "                " + buildings.get(buildCount).getCost("School"));
                showList.add(townClass.getDestroyed());
            }
            if(whichType==2 && rCount<5){
                rCount++;
                buildCount++;
                typesOfBuild.add("Rare");
                displayList.add("Rare" + "                " + buildings.get(buildCount).getCost("Rare"));
                showList.add(townClass.getDestroyed());
            }
            if(whichType==3 && cCount<13){
                cCount++;
                buildCount++;
                typesOfBuild.add("Common");
                displayList.add("Common" + "                " + buildings.get(buildCount).getCost("Common"));
                showList.add(townClass.getDestroyed());
            }
            if(buildCount==20){
                keepBuild=false;
            }
            
        }
//        System.out.println(buildings);
    }
    private int hold =0;
    public boolean probCreate(){
        int whichDestroy;
        int check = (int) Math.floor(Math.random()*5)+1;
        ifProb = false;
        Problem prob = new Problem();
        double destruction = prob.destruction();
//        System.out.println(destruction);

        if(check<4){
            ifProb=true;
            setStory();
            desLevel.setProgress(destruction/10);
            superDie.setText(Boolean.toString(superClass.checkSupDie((int)destruction)));
            numDie = peopleClass.popDie((int)destruction);
            pop = pop - numDie;
            numBorn = peopleClass.popBorn((int)destruction);
            pop = pop + numBorn;
            totpop.setText(Integer.toString(pop));
            die.setText(Integer.toString(numDie));
            born.setText(Integer.toString(numBorn));
            hold = buildGone;
//            System.out.println("Destroyed buildings: " + prob.destroyBuild());
            buildGone= hold + ((int)prob.destroyBuild());//WONT ADD!!!! WHAT IS WRONG WITH COMPUTER
            System.out.println("hold: " + hold);
            health = health - buildGone;
            System.out.println("health: " + health);
            theal.setProgress(health/20);
            System.out.println("Num of Destroyed: " + buildGone);
            for(int i = 0; i< buildGone; i++){
                whichDestroy = (int)Math.floor(Math.random()*20);
                if(destroyedBuilds.get(whichDestroy).equals("Not Destroyed")){
                    destroyedBuilds.set(whichDestroy, "Destroyed");
//                    showList.set(whichDestroy, "Destroyed");
                }else{
                    i--;
                }
            }
            showList.clear();
            for(int y = 0; y<20;y++){
                showList.add(destroyedBuilds.get(y));
            }
//            System.out.println(destroyedBuilds);
            return ifProb;
        }
        else if (check>3){
            ifProb = false;
            setStory();
            desLevel.setProgress(0);
//            health = townClass.townHealth(ifProb, fix, 0);
            theal.setProgress(health/20);
            return ifProb;
        }
        return false;//Will not return here
    }
    @FXML
    private void handleClick(MouseEvent event) {
            int fixWhichBuild = (destroyedBuild.getSelectionModel().getSelectedIndex());
            if(destroyedBuilds.get(fixWhichBuild).equals("Destroyed")){
                salary = salary - buildings.get(fixWhichBuild).getCost(typesOfBuild.get(fixWhichBuild));
                if(typesOfBuild.get(fixWhichBuild).equals("Rare")){
                    pop = pop + 300;//If the mayor fixes a rare building, the population increases by 200 people
                }else if(typesOfBuild.get(fixWhichBuild).equals("School")){
                    pop = pop + 200;//If the mayor fixes a rare building, the population increases by 200 people
                }else if(typesOfBuild.get(fixWhichBuild).equals("Common")){
                    pop = pop + 100;//If the mayor fixes a rare building, the population increases by 100 people
                }
                totpop.setText(Integer.toString(pop));
                tMoney.setText(Integer.toString(salary));
                destroyedBuilds.set(fixWhichBuild,"Not Destroyed");
                showList.set(fixWhichBuild, "Not Destroyed");
                health++;
                buildGone--;
                if(buildGone==0){
                    health=20;
                }
            }
            System.out.println("BG: " + buildGone);
            theal.setProgress(health/20);
    }
    int count = 0;
    public void start() {  
        boolean addTime = false;
        probTime = System.nanoTime();
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(dayTime < 30 && salary > 0 && health > 0 && pop > 0){
                    //FIX
                    day.setText(Integer.toString(dayTime));
                    if(probTime>0){//Use booleans to check whether or not to add the two extra seconds
                        if(now-probTime>10000000000.0){
                            if(probCreate()){
                                probTime = System.nanoTime() + 2000000000;//If a problem occurs, the day will be longer by 2seconds, so the day will be a total of 9 seconds
                            }
                            else{
                                probTime = System.nanoTime();//This still is the same amount of time as problem  
                            }
                            if(dayTime%2==0){
                                taxes();
                            }
                            dayTime++;
                        }
                    }
                } else {
                    if(dayTime>30){
                        infoLab.setText(
                            "THE SIMULATION HAS FINISHED!"
                            + " As Mayor of Town Super, "
                            + " you were able to keep the town alive  "
                            + " for 30 days! If you wish to continue playing: "
                            + " PRESS THE CONTINNUE BUTTON BELOW!");
                        infoLab.wrapTextProperty();
                        if(contin == true){
                            dayTime=1;
                            count++;
                        }
                    }else{
                        infoLab.setText(
                            "YOU LOSE!"
                            + " As Mayor of Town Super, "
                            + " you were unable to keep the town alive!  "
                            + " If you wish to play again "
                            + " PRESS THE RESET BUTTON BELOW!");
                        infoLab.wrapTextProperty();
                    }
                }
            }
        }.start();
    }
//    boolean addTime = false;
//    public void start() {  
//        probTime = System.nanoTime();
//        new AnimationTimer() {
//            @Override
//            public void handle(long now) {
//                if(dayTime < 20 && salary > 0 && health > 0 && pop > 0){
//                    //FIX
//                    day.setText(Integer.toString(dayTime));
//                    if(probTime>0){//Use booleans to check whether or not to add the two extra seconds
//                        System.out.println("now: " +now);
//                        System.out.println("probTime: " +probTime);
//                        System.out.println(now-probTime);
//                        if(addTime==false){
//                            if(now-probTime>3000000000.0){
//                                System.out.println("3");
//                                if(probCreate()){
//                                    probTime = System.nanoTime();
//                                    addTime=true;
//                                    // + 2000000000;//If a problem occurs, the day will be longer by 2seconds, so the day will be a total of 9 seconds
//                                }
//                                else{
//                                    addTime = false;
//                                    probTime = System.nanoTime();//This still is the same amount of time as problem  
//                                }
//                                dayTime++;
//                            }
//                        }
//                        else if(addTime==true){
//                            if(now-probTime>7000000000.0){
//                                if(probCreate()){
//                                    probTime = System.nanoTime();
//                                    addTime=true;
//                                }
//                                else{
//                                    probTime = System.nanoTime();//This still is the same amount of time as problem  
//                                    addTime = false;
//                                }
//                                dayTime++;
//                            }
//                            
//                        }
//                        if(dayTime%2==0){
//                            taxes();
//                        }
//                        
//                    }
//                }else{
//                    infoLab.setText(
//                        "YOU LOSE!"
//                        + " As Mayor of Town Super, "
//                        + " you were unable to keep the town alive!  "
//                        + " If you wish to play again "
//                        + " PRESS THE RESET BUTTON BELOW!");
//                    infoLab.wrapTextProperty();
//                }
//            }
//        }.start();
//    }

    public void taxes(){
        salary += pop * 2;//$2 tax every two days per person
        tMoney.setText(Integer.toString(salary));
    }
    public void reset(){
        salary = 20000;
        dayTime = 1;
        pop = 50000;
        probTime = System.nanoTime();
        day.setText(Integer.toString(1));
        health = 20;
//        theal.setProgress(1);
        superClass.supersVillian();
        destroyedBuilds.clear();
        showList.clear();
        sCount = 0;
        rCount = 0;
        cCount = 0;
        displayList.clear();
        setInitial();
//        desLevel.setProgress(0);
    }
    @FXML 
    public void setStory(){
        if(ifProb==true){
            infoLab.setText(
                "WARNING! WARNING!"
                + " A problem has arrived! " + superClass.getVillian()
                + " has created a disaster! Luckily, " + superClass.getSuper()
                + " can takedown the villian. However, "
                + " the villian and the superhero have created major damage.");
            infoLab.wrapTextProperty();
        }else{
            infoLab.setText("NO PROBLEM TODAY!");
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        background.setImage(new Image("resources/background2.png"));
        theal.setProgress(1);
        tMoney.setText(Integer.toString(salary));
        totpop.setText(Integer.toString(pop));
        die.setText(Integer.toString(numDie));
        born.setText(Integer.toString(numBorn));
        day.setText(Integer.toString(0));
        infoLab.setText(
             "You are the Mayor of this town!"
             + " The town is different than most..."
             + " There are Superheroes, however"
             + " there are also Villians."
             + " It is up to you to keep the town alive! In order to do this, "
             + " you need to fix buildings within a town budget of $20,000!"
             + " GOOD LUCK!");
         infoLab.wrapTextProperty();
    }    
}
