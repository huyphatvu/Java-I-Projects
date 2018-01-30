import java.util.Random;
import java.util.Scanner;
//Begin the combat right here!
public class StartCombat{
	public static void run(boolean combat, Hero classHero, Room myRoom, Dungeon dungeonModel){
		Random ranGen = new Random();
		int combatNum =0;
		while(combat){
            classHero.upgradeHero();//Create and upgrade hero
            Room checkRoom = dungeonModel.getroom0();
            checkRoom = Map.getMap(myRoom, dungeonModel);
            if(checkRoom!=null){
            	myRoom = checkRoom;//Assign Hero's current room to new room
            }
            else{
            	//when myRoom equals checkRoom, the user chose to quit the game
            	combat = false;
            	continue;
            }
 
    		System.out.println(Map.getRoomDescription(myRoom));//Report hero's new room
                        
            int luckNumber = ranGen.nextInt(6);
            //use it to decide whether hero meet a monster or see a box went move to next room
            if(luckNumber>=1){
	    		Monster monster = Monster.createMonster(combatNum); //using method createMonster of Monster Class
	            //Start random Generator for monster
	            int check = classHero.startCombat(monster);
	            switch(check){
		            case 0:{
		            	//Lost in the battle
		            	combat = false;
		            	System.out.println("Goodbye!");
		            	break;
		            }
		            case 1:{
		            	//Win in the battle
		                classHero.increaseXP(monster.getXP());//increase the XP of the class Hero
		                classHero.increasePoints(monster.getXP());
		                classHero.checkLV();
		                System.out.printf("%s is ready for next ground!!!\n",classHero.getName());
		                break;
	            	}
		            case 2:{
		            	//Runaway
		            	break;
		            }	     
	            }//end switch
            }//end if
            else{
            	//luckNumber == 1
            	Scanner kpd = new Scanner(System.in);

            	boolean control = true;
            	while(control){
	            	System.out.printf("%s encountered an unsealed chest!\nEnter:\n", classHero.getName() );
	            	System.out.println("1: Open\n2: Leave");
	            	String userChoice= kpd.next();
	            	if(userChoice.equals("1")){
	            		int category = ranGen.nextInt(3);
	            		int index = ranGen.nextInt(3);
	            		System.out.printf("Congratulation! You received a "
	            		+ "%s\nIt will increase %s's "
	            		+ "%s by %d points\n\n",Items.getItemName(category, index), classHero.getName(), Items.getItemCategory(category),Items.getItemValueAP(category, index));
	            		if(Items.getItemCategory(category).equals("AP")){
	            			classHero.increaseAP(Items.getItemValueAP(category, index));
	            		}
	            		else if(Items.getItemCategory(category).equals("HP")){
	            			classHero.increaseHP(Items.getItemValueAP(category, index));
	            		}
	            		else {
	            			classHero.increaseMP(Items.getItemValueAP(category, index));
	            		}
	           
	            		System.out.println(classHero);
	            		System.out.println();
	            		control=false;
	            	}
	            	else if(userChoice.equals("2")){
	            		System.out.printf("%s leaves the room\n", classHero.getName());
	            		control=false;
	            	}
	            	else{
	            		System.out.println("Please enter 1 or 2!");
	            	}
            	}//end while control
            	
            }
            combatNum++;
		}//end while
	}//end run
}