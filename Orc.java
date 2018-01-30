public class Orc extends Monster{
	public Orc(){
		super("Orc",40,8,3);			
	}
	
    public void levelUp(int level){
    	super.monLevelUp(level, 3, 10, 5);
    }
}