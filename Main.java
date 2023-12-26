package pack.FlappyBird;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		new Stage(this);
		new Bird(this);
		
	}
		
	public boolean onCommand(CommandSender commandSender, Command commandSent, String string, String[] args ) {
						
		String command = commandSent.getName().toLowerCase();
		Player player = (Player) commandSender;
		
		switch(command) {
				
			case "flappy" :
				Stage.buildPlatform(player);				
				break;
				
			case "fsetpassenger":
				Bird.setPassenger(args);
				break;
				
			case "bird":
				Bird.spawnFlappyBird2(player);
				break;
				
			case "fstart" :	
				
				Obstacle[] obstacles = new Obstacle[2];
				obstacles[0] = Obstacle.buildObstacle(player, 12);					
				obstacles[1] = Obstacle.buildObstacle(player, -2);
					
				new Bird(this).spawnFlappyBird(player, obstacles);
					
				new BukkitRunnable() {
					
					public void run() {
						
//						Obstacle.followingObstacle(player);
						obstacles[0] =  Obstacle.moveObstacle(player, obstacles[0], obstacles[0].b1.getZ() -1);
						obstacles[0].z = obstacles[0].z-1;
						
						obstacles[1] =  Obstacle.moveObstacle(player, obstacles[1], obstacles[1].b1.getZ() -1);
						obstacles[1].z = obstacles[1].z-1;
																		
						if(obstacles[0].z == player.getLocation().getBlockZ()) {	
							
							if(Bird.flappyBird.getLocation().getBlockY() != player.getLocation().add(16, obstacles[0].freeWay1, 0).getBlockY() &&
							   Bird.flappyBird.getLocation().getBlockY() != player.getLocation().add(16, obstacles[0].freeWay2, 0).getBlockY()					
							   ) {
																																											
								Bird.flappyBird.damage(20);								
								Obstacle.destroyObstacle(obstacles[0]);
								Obstacle.destroyObstacle(obstacles[1]);
								player.sendMessage("You lost");
//								player.getWorld().strikeLightning(Bird.flappyBird.getLocation());
//								player.getWorld().createExplosion(player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ(), 4F, true);
								cancel();
																		
							}
						}

						if(obstacles[1].z == Bird.flappyBird.getLocation().getBlockZ()) {								
							
							if(Bird.flappyBird.getLocation().getBlockY() != player.getLocation().add(16, obstacles[1].freeWay1, 0).getBlockY() &&
							   Bird.flappyBird.getLocation().getBlockY() != player.getLocation().add(16, obstacles[1].freeWay2, 0).getBlockY()
							   ) {
																												
								Bird.flappyBird.damage(20);
								Obstacle.destroyObstacle(obstacles[0]);
								Obstacle.destroyObstacle(obstacles[1]);
								player.sendMessage("You lost");
//								player.getWorld().strikeLightning(Bird.flappyBird.getLocation());
//								player.getWorld().createExplosion(player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ(), 4F, true);
									
								cancel();									
								}
							}
						}														
						
				}.runTaskTimer(this, 10L, 6L) ;
								
				break;												
		}		
		return true;
	};
}