package pack.FlappyBird;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.Vector;

public class Obstacle {
		
	Player player;
	Block b1, b2, b3, b4, b5, b6, b7, b8;	
	int freeWay1, freeWay2, z;
	
	Obstacle(Player player, int z, int freeWay1, int freeWay2){
		
		this.player = player;
		this.freeWay1 = freeWay1;
		this.freeWay2 = freeWay2;		
		this.z = z +(int) player.getLocation().getZ();
		
		b1 = player.getLocation().add(16, -4, z).getBlock();
		b1.setType(Material.EMERALD_BLOCK);
		
		b2 = player.getLocation().add(16, -3, z).getBlock();
		b2.setType(Material.EMERALD_BLOCK);
		
		b3 = player.getLocation().add(16, -2, z).getBlock();
		b3.setType(Material.EMERALD_BLOCK);
		
		b4 = player.getLocation().add(16, -1, z).getBlock();
		b4.setType(Material.EMERALD_BLOCK);
		
		b5 = player.getLocation().add(16, 0, z).getBlock();
		b5.setType(Material.EMERALD_BLOCK);
		
		b6 = player.getLocation().add(16, 1, z).getBlock();
		b6.setType(Material.EMERALD_BLOCK);
		
		b7 = player.getLocation().add(16, 2, z).getBlock();
		b7.setType(Material.EMERALD_BLOCK);
		
		b8 = player.getLocation().add(16, 3, z).getBlock();
		b8.setType(Material.EMERALD_BLOCK);
								
		player.getLocation().add(16, this.freeWay1, z).getBlock().setType(Material.AIR);				
		player.getLocation().add(16, this.freeWay2, z).getBlock().setType(Material.AIR);			
							
	}
			
	public static Obstacle buildObstacle(Player player, int z) {
		
		Random randomizer = new Random();
		
		int freeWay1 = randomizer.nextInt(-3, 3);		
		int freeWay2 = freeWay1 + 1;			
										
		return new Obstacle(player, z, freeWay1, freeWay2);
				
	}
						
	public static Obstacle moveObstacle(Player player, Obstacle obstacle, int z) {
		
		obstacle = Obstacle.destroyObstacle(obstacle);
		
		if (obstacle.b1.getZ() <= (player.getLocation().getBlockZ() -14)) 
			obstacle = Obstacle.buildObstacle(player, 12);		
		else
			obstacle = new Obstacle(player, z - player.getLocation().getBlockZ(), obstacle.freeWay1, obstacle.freeWay2);
		
		return obstacle;
	}
	
	public static void followingObstacle(Player player) {
		
		Obstacle[] obstacles = new Obstacle[2];
		obstacles[0] = Obstacle.buildObstacle(player, 12);					
		obstacles[1] = Obstacle.buildObstacle(player, -2);
		

	}
	
	public static Obstacle destroyObstacle(Obstacle obstacle){
		
		obstacle.b1.setType(Material.AIR);
		obstacle.b2.setType(Material.AIR);
		obstacle.b3.setType(Material.AIR);
		obstacle.b4.setType(Material.AIR);
		obstacle.b5.setType(Material.AIR);
		obstacle.b6.setType(Material.AIR);
		obstacle.b7.setType(Material.AIR);
		obstacle.b8.setType(Material.AIR);
		
		return obstacle;	
	}

		
}
