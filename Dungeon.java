public class Dungeon{
	private static final Room[] rooms ={
			new Room("guest bedrooms", "There is a small bed"),
			new Room("South Hall","There is a luxious watch on the wall"),
			new Room("Dining rooms","There is a large table in the center"),
			new Room("Master Bedrooms","There is a beautiful picture of the jungle"),
			new Room("North Hall","It has a slippery floor"),
			new Room("guest Kitchen","There is a toast on the sink"),
			new Room("Balcony","What marvelous mountains!")
	};//exit in every dungeon
	
	private static void setDungeon(){
		rooms[0].setExits(rooms[3], rooms[1], null, null);
		rooms[1].setExits(rooms[4], rooms[2], rooms[0], null);
		rooms[2].setExits(rooms[5], null, rooms[1], null);
		rooms[3].setExits(null, rooms[4], null, rooms[0]);
		rooms[4].setExits(rooms[6], rooms[5], rooms[3], rooms[1]);
		rooms[5].setExits(null, null, rooms[4], rooms[2]);
		rooms[6].setExits(null, null, null, rooms[4]);
	}
	//CONSTRUCTOR
	public Dungeon(){
		setDungeon();
	}//Nothing will be constructed
	
	public Room getroom0(){
		return rooms[0];
	}//Return guest Bedrooms;
}