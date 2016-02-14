package package1;

public class Space {

	private String card;
	
	// makes player number equal to param.
	public Space(String card){
		this.card = card;
	}
	
	//returns the player's number in a space
	public String getCardSpace(){
		return card;
	}
}
