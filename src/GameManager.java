import java.util.ArrayList;
import it.kibo.fp.lib.RandomDraws;
import it.kibo.fp.lib.InputData;

public class GameManager {
	private static int N_WORLDS=10;
	
	private ArrayList<World> worlds=new ArrayList<World>();
	private World currentWorld;
	Player player;
	private int lifes;
	
	
	public GameManager() {
		
		player = new Player(InputData.readNonEmptyString("Inserisci il tuo nome: ", true));
		
		for(int n=0; n<N_WORLDS; n++) {
			worlds.add(new World(RandomDraws.drawInteger(10, 100)));
		}
	}
	
	private boolean evrethingFinished() {
		for(World w : worlds)
			if(!w.isCompleted())
				return false;
		
		return true;
	}
	
	public int worldSelection() {
		ArrayList<World> availableWorlds= new ArrayList<World>();
		for(World w : availableWorlds) {
			if(!w.isCompleted()) {
				availableWorlds.add(w);
				System.out.println(w);
			}
		}
		
		int selection=-1;
		if(!availableWorlds.isEmpty()) {
			boolean inputValid=false;
			while(inputValid) {
				selection =InputData.readInteger("Scegli uno dei mondi disponibili [ID]: ");
				for(World w : availableWorlds) {
					if(w.getId()==selection) {
						inputValid=true;
						break;
					}	
				}
			}
		}
		return selection;
	}
	
	public void play() {
		while(player.getLifes()>0 || !evrethingFinished()) {
			int worldSelected = worldSelection();
			
			for(World w: worlds)
				if(w.getId() == worldSelection())
					w.play(player);
		}
		
		if(player.getLifes()<0)
			System.out.println("GAME OVER");
		else System.out.println("Hai vinto");
	}
	
}
