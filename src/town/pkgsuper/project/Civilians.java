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
public class Civilians {
    private int townPop = 50000, numDie = 0, numBorn = 0;
    public int popDie(int destruction){
        numDie = (destruction*100);
        return numDie;
    }//950 //549
    public int popBorn(int destruction){
        numBorn = (int) (Math.floor(Math.random()*10)+1) *5;
        return numBorn;
    }
    //Method int population
    /*
        The population will start at 20K.
        As problems arise, a percentage of the population will die; when this happens, the decrease method will be called.
        However, everyday a certain amount of people will be born; this will call the increase method.
    */
    //Method int decrease
    /*
        This method will be called by the problem class to decrease the population.
        The percentage obtained in the problem class will be taken out of the population.
        If the population becomes less than or equal to 0, the game will end.
    */
    //Method int increase
    /*
        This method will determine the population and add a percentage of the people back everyday. 
    */
    //Method int pleased
    /*
        This method will randomly decide a number from 1-10 to show how pleased the town is with the mayor. (Can change to be not random later)
        An average will be calculated about the rating each civilian gives, and be returned.
    */
}
