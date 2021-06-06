/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package town.pkgsuper.project;

/**
 *
 * @author Saanji Shah
 */
public class Problem {
    private int destruction = 0;
    //Method int story
    /*
        When a problem arises, the problem will be assigned to a particular villain that is represented by an integer
        that will relate to the integer that represents the appropriate superhero
    */
    public double destruction(){
        destruction = (int) Math.floor(Math.random()*10)+1;
        return destruction;
    }
    //Method int destruction
    /*
        A random number will determine how much destruction(1-10) will be made to the town.
        This method will also call the rest of the methods
    */
    public int destroyBuild(){
        int numBuild = 0;
        if(destruction==10){
            numBuild = 7;
        }
        else if(destruction>7 && destruction<10){
            numBuild = (int) Math.floor(Math.random()*3)+4;
        }
        else if(destruction>4 && destruction<7){
            numBuild = (int) Math.floor(Math.random()*2)+3;
        }
        else if(destruction>0 && destruction<4){
            numBuild = (int) Math.floor(Math.random()*3)+1;
        }
//        else if(destruct==0){
//            numBuild = 0;
//        }
        return numBuild;
    }
    //Method int destroyBuild
    /*
        This method will use the destruction number to determine how many buildngs will be destroyed, which will affect the health of the town.
        This method will call the townHealth in the town class to lower the health, when a problem arises.
    */
    //Method int getDead
    /*
        This method will use the destruction number to determine what percentage of the population will die.
        This method will call the civilians class.
    */
}
