public class Troll extends Monster{
	public Troll(){
		super("Troll",45,10,4);			
	}
	
    public void levelUp(int level){
    	super.monLevelUp(level, 4, 10, 4);
    }
}