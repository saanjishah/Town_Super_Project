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
public class Town {
    /*
        There will be a total of 20 buildings.
        This method calls the getType method to determine what type of building it is.
        This method calls the getStrength method to determine how stable the building is, 
        and how much force it would take to destroy the building.
        This method will call the getCost method to determine how much moneu it will cost to repair the building
        All of the buildings will start with a 10/10 health.
    */
    private int genType; //This Instance Field will be used to find out if the building is rare, common, or a school
//    private int schoolCount = 0, rareCount = 0, commonCount = 0;
    private int schoolDestroy = 0, rareDestroy = 0, commonDestroy = 0;
    private String type = "";
    private int strength = 0, cost = 0, townHeal = 20; 
    //Method int getType
    /*
        The type of building will correspond to an integer, which will be returned.
        This method will choose a random number between 1-3; This number will determine if the building is rare or a school.
        if rare
            Once a number is picked it will no longer be available for use, to eliminate repeats of rare buildings.
        if school
            The building will automatically be a school, however there will only be 3 schools. 
        After all of the rare buildings have been assigned, the rest of the spots will be filled up randomly by common
        buildings.
    */
    public int getStrength(){
        if(type.equals("School")){
            strength = 6;
        }
        else if(type.equals("Rare")){
            strength = (int) Math.floor(Math.random()*3)+7;
        }
        else{
            strength = (int) Math.floor(Math.random()*3)+1;
        }
        return strength;
    }
    //Method int getStrength
    /*
        This method will use the type of the building to determine how strong thr building is on a scale of 1-10.
        Rare buildings will be the strongest, and common buildings will be the weakest.
        This number will be used to determine how much of the health of the building will go down.
    */
    public int getCost(String type){
        if(type.equals("Rare")){
            cost = (int) (Math.floor(Math.random()*5)+7)*1000;
        }else if(type.equals("School")){
            cost = (int) (Math.floor(Math.random()*5)+3)*1000;
        }else if(type.equals("Common")){
            cost = (int) (Math.floor(Math.random()*4)+1)*1000;
        }
        return cost;
    }
    //Method int getCost
    /*
        This method will create a random number to determine how much money the building costs to fix, when broken.
        That number will be added to depending on the strength and type of the building.
    */
    public String getDestroyed(){
//        if()
        return "Not Destroyed";
    }
//    public int townHealth(boolean prob, boolean fix, double destruction){
////        if(prob==true){
////           Problem probClass = new Problem();
//////           int buildGone = probClass.destroyBuild(destruction);
//////           townHeal = townHeal - buildGone;
////        }
//        if(fix==true){
//            townHeal++;
//        }
//        return townHeal;
//    }
    //Method int townHeath
    /*
        The town starts with a 20/20 health, each "point" of health represents a building. 
        This function is called by the problem class and the health will change as the mayor makes decisions and problems arise
    */
}
