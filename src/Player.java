
public class Player extends Entity{
	private static int INITIAL_LIFE = 20;
	private static int INITIAL_ATTACK = 5;
	
	private String name;
	private int points;
	private int lifes;
	
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
	
	public void lifeLost() {
		lifes--;
	}
	
	public int getLifes() {
		return lifes;
	}
	
	public void respawn() {
		setHealth(INITIAL_LIFE);
		setAttack(INITIAL_ATTACK);
	}
}
