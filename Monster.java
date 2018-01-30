/*Create a class object that store a Monster (both monster and hero)
//Health
//Attack Power
//Magic Power
*/
import java.util.Random;

public abstract class Monster extends GameCharacter{
	
    public Monster(String name,  int health, int attackPow, int xp){
        super(name, health, attackPow, xp);
        }
    
    public Monster(){
        super();
        }
    
    //Methods
    


    public void halfHP(){
        super.decreaseHP(super.getHP()/2);
    }

    public void newMonStatus(int health, int attackPow){
        super.increaseAP(attackPow);
        super.increaseHP(health);
    }
    
    public static Monster createMonster(int combatNum){
        Monster[] monster={
        new Goblin(),
        new Orc(),
        new Troll()
    };
        
    //using array of monster instead of multi-selection statements
        Random randomGenerate = new Random();
        int randomMon = randomGenerate.nextInt(3);
        int randomHP=randomGenerate.nextInt(5);
        int randomAP=randomGenerate.nextInt(2);
        if(randomMon<2){
        monster[randomMon].newMonStatus(randomHP, randomAP);
        }
        else{
        //Increase difficulty for Troll
        randomHP=randomGenerate.nextInt(10);
        monster[2].newMonStatus(randomHP, randomAP);
        }
        System.out.printf("\nYou have encountered a %s!\n",monster[randomMon].getName());

        	monster[randomMon].levelUp(combatNum/3); //Increase monster level 
        
        return monster[randomMon];
    }
    

    public void monLevelUp(int level, int ap, int hp, int xp){
    	for(int i =0; i <level; i++){
    		increaseLv();
        	increaseAP(ap);
        	increaseHP(hp);
        	increaseXP(xp);
    	}
    }
    public String toString(){
    	String monStat =
    	String.format("%s(lv:%d) HP: %d, AP: %d",   getName(), 
									    			getLv(), 
									    			getHP(),
									    			getAP());
	    return monStat;
	}
    
    public abstract void levelUp(int level);
}