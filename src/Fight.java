import it.kibo.fp.lib.RandomDraws;
public class Fight {
	Entity e1;
	Entity e2;
	boolean entityTurn; // - true e1 - false e2
	
	public Fight(Entity e1, Entity e2) {
		this.e1 = e1;
		this.e2 = e2;
	}
	
	public void fight() {
		entityTurn = RandomDraws.estraiBoolean();
		
		while(e1.isDead() || e2.isDead()) {
			if(entityTurn)
				e1.attack(e2);
			else e2.attack(e1);
			}
		entityTurn = !entityTurn; // cambia turno
	}
}
