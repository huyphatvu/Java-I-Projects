
public class Items{
	private static String[] itemCategory ={"AP","HP","MP"};
	private static String[][] itemName ={
			{"Soldier Axe", "Soldier Dagger", "Spear", "Sword"},
			{"Chest Armor","Helm","Cloaks"},
			{"Magic Ring","Magic Amulet","Magic Germ"},
			};
	private static int[][] itemValue ={
			{5,7,10},
			{20,30,40},
			{3, 6,12}
	};
	
	//PUBLIC METHODS
	public static String getItemName(int category,int nameIndex){
		return itemName[category][nameIndex];
	}//take in 2 int give out 1 String
	
	public static int getItemValueAP(int category,int valueIndex){
		return itemValue[category][valueIndex];
	}
	public static String getItemCategory(int index){
		return itemCategory[index];
	} 
}