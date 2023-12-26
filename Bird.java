package pack.FlappyBird;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;


public class Bird implements Listener {
	
	private Main plugin;

	public Bird(Main plugin) {
		this.plugin = plugin;				
		Bukkit.getPluginManager().registerEvents(this, plugin);
		
	}
	
	static Chicken flappyBird;
	static Obstacle[] obstacles = new Obstacle[2];
	static Player player;
		
	public void spawnFlappyBird(Player player, Obstacle[] obstacles) {
		
		Bird.player = player;
		Bird.obstacles[0] = obstacles[0];
		Bird.obstacles[1] = obstacles[1];
		
		Location playerLoc = player.getLocation().add(16, 0, 0);					
		flappyBird = player.getWorld().spawn(playerLoc, Chicken.class);
							
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	
	public void flapEvent(PlayerInteractEvent event) {
		
		if (event.getItem().getType() == Material.FEATHER) {
			flappyBird.setVelocity(new Vector(0, 0.5, 0));
//			flappyBird.setVelocity(new Vector(0, 3, 0));
			List<Entity> entities = player.getNearbyEntities(100, 100, 100);
			for(Entity x : entities) {
				x.setVelocity(new Vector(0, 0.5, 0));
			}

		}	
		
		if (event.getItem().getType() == Material.DIAMOND_BLOCK) {		
			flappyBird.setPassenger(player);
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void setPassenger(String args[]) {
		
		Player passenger = player.getServer().getPlayerExact(args[0]);
		flappyBird.setPassenger(passenger);
	}
	
	public static void spawnFlappyBird2(Player player) {
		Location playerLoc = player.getLocation().add(16, 0, 0);					
		flappyBird = player.getWorld().spawn(playerLoc, Chicken.class);
	}
	
}
