// create an enum class used for battle status
public enum Status{
	LOST(0),
	WIN(1),
	RUN(2);
	
	private int statusNum;
	Status(int statusNum){
		this.statusNum = statusNum;
	}
	
	public int getStatus(){
		return statusNum;
	}
}