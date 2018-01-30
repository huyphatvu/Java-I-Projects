import java.util.Scanner;
public class Map{
	
//Provide direction
	/*PUBLIC METHOD*/
	public static String getRoomDescription(Room myRoom){
		return String.format("You are in the %s\n%s\n", myRoom.getDescription(), myRoom.getDetails());
	}//Provide description for each room
	
public static Room getMap(Room myRoom, Dungeon dungeonModel){
		Scanner keyboard = new Scanner(System.in);
		boolean finish=false;
 
        Room newRoom = dungeonModel.getroom0();// current room number
			while(!finish){
				System.out.printf("You are in the %s, exits are %s\n", myRoom.getDescription(), myRoom.getExits());
				System.out.println("Choose Your Direction\n"
								+ "n: Go to the north\n"
								+ "s: Go to the south\n"
								+ "w: Go to the west\n"
								+ "e: go to the east\n"
								+ "q: Leave the catle and go home\n");
				String choice = keyboard.next();
				if(choice.equalsIgnoreCase("n")){
					if(myRoom.getNorth()!=null){
						newRoom= myRoom.getNorth();
						finish=true;
					}
					else
						System.out.println("There is no such exit!");

				}
				else if(choice.equalsIgnoreCase("s")){
					if(myRoom.getSouth()!=null){
						newRoom= myRoom.getSouth();
						finish=true;
					}
					else
						System.out.println("There is no such exit!");
						
				}
				else if(choice.equalsIgnoreCase("w")){
					if(myRoom.getWest()!=null){
						newRoom= myRoom.getWest();
						finish=true;
					}
					else
						System.out.println("There is no such exit!");
						
				}
				else if(choice.equalsIgnoreCase("e")){
					if(myRoom.getEast()!=null){
						newRoom= myRoom.getEast();
						finish=true;
					}
						
					else
						System.out.println("There is no such exit!");
				}
				else if(choice.equalsIgnoreCase("q")){	
					System.out.println("You leave the castle and go home\n"
							+ "Thank you for playing this AWESOME game!!!");
					newRoom= null;//User choose to quit the game so the room stay the same
					finish=true;
				}
				else{
					System.out.println("Invalid keyboard!!!\nPlease Reinsert");
				}
		}//end while
			return newRoom;
			 
	}//end method getMap return true if the Hero go to the next room; null if Hero go home
}