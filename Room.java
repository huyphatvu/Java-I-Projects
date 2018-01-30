 
public class Room {
	private String description;
	private String details;//give extra details for the room
	private Room north;
	private Room west;
	private Room east;
	private Room south;

	//CONSTRUCTOR
	public Room(String description, String details){
		this.description = description;
		this.details= details;
	}
	public Room(){
		this.description ="";
		this.details="";
	}//Overloaded constructor
	
	public void setNorth(Room north){
		this.north = north;
	}
	public void setWest(Room west){
		this.west = west;
	}
	
	public void setEast(Room east){
		this.east = east;
	}
	
	public void setSouth(Room south){
		this.south = south;
	}
	public void setExits(Room n, Room e, Room w, Room s){
		this.north = n;
		this.east = e;
		this.west = w;
		this.east = e;
		this.south = s;
	}
	
	public Room getNorth(){
		return this.north;
	}
	public Room getEast(){
		return this.east;
	}
	public Room getWest(){
		return this.west;
	}
	public Room getSouth(){
		return this.south;
	}
	public String getDescription(){
		return this.description;
	}
	public String getDetails(){
		return this.details;
	}
	
	public String getExits(){
		String exit="";
		String[] dir = new String[4];
		int i =0;// use as index of dir, imediately increase to 1 enter if staments
		
		if(this.south!=null)
			dir[i++]="south";
		if(this.west!=null)
			dir[i++]="west";
		if(this.east!=null)
			dir[i++]="east";
		if(this.north!=null)
			dir[i++]="north";
		i--;//minus 1 before execute
		exit += dir[i];
		while(i>0){
			exit += ", "+dir[--i];//decrease by 1
 
		}
		
		return exit;
	}//return exit
	public String toString(){
		return getDescription()+" has "+getExits();
	}

}