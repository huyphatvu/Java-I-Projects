/*
 * The	GameCharacter	class	is	the	superclass	of Hero and Monster hierarchy
 */
public class GameCharacter{
	private String name;
    private int attack;
    private int health;
    private int lv;//level 
    private int xp;//experience points
    
    public GameCharacter(String name, int health, int attackPow, int lv, int xp){
    	this.setCharacter(name, health, attackPow, lv, xp);

    }//Used by Hero Class

    public GameCharacter(String name, int health, int attack, int xp){
    	this.setCharacter(name, health, attack, 1, xp);

    }//Used by Monster Class
    
    public GameCharacter(){
    	this.setCharacter("", 0, 0, 1, 0);
    }
    
    public void setCharacter(String name, int health, int attackPow, int lv, int xp){
        setName(name);
    	setAttack(attackPow);
        setHealth(health);
        setLv(lv);
        setXP(xp);
    }

    
    public String getName(){
    	return name;
    }
    public int getAP(){
    	return attack;
    }
    public int getHP(){
    	return health;
    }

    public int getLv(){
    	return lv;
    }

    public int getXP(){
        return xp;
    }

    public void  increaseLv(){
    	this.lv += 1;
    }
    public void increaseXP(int xp){
    	this.xp += xp;
    }
    public void decreaseXP(int xp){
    	this.xp -= xp;
    }
 
    public void setName(String name){
    	 this.name =  name;
    }
    public void setAttack(int attack){
    	if(attack<0 || attack>1000){
    		throw new IllegalArgumentException("Attack must be between 0 and 1000");
    	}
    	 this.attack =  attack;
    }
    public void setHealth(int health){
    	if(health<0 || health>1000){
    		throw new IllegalArgumentException("Health must be between 0 and 1000");
    	}
    	 this.health =  health;
    }

    public void setLv(int lv){
    	if(health<0){
    		throw new IllegalArgumentException("Health must be greater than 0");
    	}
    	this.lv = lv;
    }
    public void setXP(int xp){
    	if(xp<0 || xp>1000){
    		throw new IllegalArgumentException("XP must be between 0 and 1000");
    	}
    	this.xp = xp;
    }
    
    public void decreaseHP(int damage){
        this.health-=damage;
    }


    public void increaseHP(int health){
        this.health+=health;
    }
    public void increaseAP(int attack){
        this.attack += attack;
    }

    public void increaseLv(int lv){
        this.lv += lv;
    }
    
    public String toString(){
    	String character =
        String.format("Character(lv:%d, xp:%d) HP: %d",lv, health)
	    + String.format(", AP: %d",attack);
	    return character;
	        }
 
}