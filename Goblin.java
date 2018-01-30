public class Goblin extends Monster{
	public Goblin(){
		super("Goblin",35,5,2);			
	}
	
    public void levelUp(int level){
    	super.monLevelUp(level, 2, 10, 3);
    }
}