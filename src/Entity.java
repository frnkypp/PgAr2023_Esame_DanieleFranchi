import java.util.ArrayList;

public class Entity {
	private double health;
	private double attack;
	
	public Entity(double health, double attack){
		this.health = health;
		this.attack = attack;
	}
	
	public double getHealth() {
		return health;
	}
	

	public double getAttack() {
		return attack;
	}
	
	public void setHealth(double value) {
		health = value;
	}
	
	public void setAttack(double value) {
		attack = value;
	}
	
	public void receiveDamage(double amount) {
		health-=amount;
	}
	

	public void attack(Entity entity) {
		entity.receiveDamage(attack);
	}
	
	
	
	public void applyModifiers(ArrayList<Modifier> modifiers){
		for(Modifier m : modifiers) {
			switch(m.getType()) {
			case ATTACK:
				attack+=m.getValue();
				if(attack<0)
					attack=0;
				break;
		
			case HEALTH:
				health+=m.getValue();
				if(health<0)
					break;
			}
		}
	}
	
	public boolean isDead() {
		if(health<=0)
			return true;
		else return false;};
}
