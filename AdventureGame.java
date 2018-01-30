/**
 * A program that creat a hero
 * There are different types of hero to choose
 * and put him into a castle 
 * When move to another room,
 * the player will encounter monster or a brief case that contains 
 * special items that increase the hero's power  
 * Hero will level up as his xp increase
 * Monster will level up
 *
 * @author 	Huy Vu
 * @revised	24 October, 2016
 */ 
 
public class AventureGame{

	public static void main(String[] args){
        Hero classHero = new Hero(); //create a classHero
        classHero = classHero.heroChoice();
        System.out.println(classHero+"\n");
        boolean combat = true;
        Dungeon dungeonModel = new Dungeon();//create a dungeon
        Room myRoom = dungeonModel.getroom0();// current room number
        StartCombat.run(combat, classHero, myRoom, dungeonModel);
		}//end main
	}
