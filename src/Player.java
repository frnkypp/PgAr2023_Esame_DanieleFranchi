
public class Player extends Entity{
	private String name;
	private int points;
	
	public Player(String name) {
		super(20,5);
		this.name = name;
		points=0;
	}

	public String getName() {
		return name;
	}
	
	public void addPoints(int amount) {
		points+=amount;
	}
}
