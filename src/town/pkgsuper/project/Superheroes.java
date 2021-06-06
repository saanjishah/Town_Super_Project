/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package town.pkgsuper.project;

import java.util.ArrayList;

/**
 *
 * @author Saanji Shah
 */
public class Superheroes {
    ArrayList <String> supers= new ArrayList<>();
    String superheroNames [] = new String[10];
    ArrayList <String> villians= new ArrayList<>();
    String villianNames [] = new String[10];
    int randomSup;
    public Superheroes(){
        for(int j = 0 ; j<10;j++){
            supers.add("");
            villians.add("");
        }
        superheroNames[0] = "Superman";
        superheroNames[1] = "Spiderman";
        superheroNames[2] = "Batman";
        superheroNames[3] = "Thor";
        superheroNames[4] = "Flash";
        superheroNames[5] = "Green Lantern";
        superheroNames[6] = "Antman";
        superheroNames[7] = "Black Panther";
        superheroNames[8] = "Wonder Woman";
        superheroNames[9] = "Hulk";
        
        villianNames[0] = "Lex Luthor";
        villianNames[1] = "Venom";
        villianNames[2] = "Joker";
        villianNames[3] = "Loki";
        villianNames[4] = "Captain Cold";
        villianNames[5] = "Simistero";
        villianNames[6] = "Wasp";
        villianNames[7] = "Killmonger";
        villianNames[8] = "Cheetah";
        villianNames[9] = "The Abomination";
        for(int i = 0 ; i <10;i++){
            int where = (int) Math.floor(Math.random()*10);
            if(supers.get(where).equals("")){
                supers.set(where, superheroNames[i]);
                villians.set(where, villianNames[i]);
            }else{
                i--;
            }
        }
        System.out.println(supers);
        System.out.println(villians);
    }
    public String getVillian(){
        randomSup = (int) Math.floor(Math.random()*10);
        String whichVillian = villians.get(randomSup);
        return whichVillian;
    }
    public String getSuper(){
        String whichSuper = supers.get(randomSup);
        return whichSuper;
    }
    public void supersVillian(){
        supers.clear();
        villians.clear();
        for(int j = 0 ; j<10;j++){
            supers.add("");
            villians.add("");
        }
        for(int i = 0 ; i <10;i++){
            int where = (int) Math.floor(Math.random()*10);
            if(supers.get(where).equals("")){
                supers.set(where, superheroNames[i]);
                villians.set(where, villianNames[i]);
            }else{
                i--;
            }
        }
        System.out.println(supers);
        System.out.println(villians);
    }
    //Method int getSuper
    /*
        This method will use the integer represented by the villain to determine which randomly selected superhero was chosen.
        Once the super is chosen, the rest of the methods will be called
    */
    public boolean checkSupDie(int destructLevel){
        boolean didDie = false;
        if(destructLevel==10){
            supers.remove(randomSup);
            villians.remove(randomSup);
            didDie = true;
        }
        return didDie;
    }
    //Method boolean checkDie
    /*
        This method will use the difficulty of the problem check if the superhero died in the process of saving the problem. 
        If the super dies, that super will be removed from the array list.
        If all of the superheroes die, the game will end. 
    */
}
