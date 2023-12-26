package pack.FlappyBird;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.TreeType;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Directional;

public class Stage implements Listener {
	
@SuppressWarnings("unused")
private Main plugin;

	public Stage(Main plugin) {
		this.plugin = plugin;				
		Bukkit.getPluginManager().registerEvents(this, plugin);
		
	}
				
	@SuppressWarnings("deprecation")
	public static void buildPlatform(Player player) {
		
		Location playerLoc = player.getLocation();																
		playerLoc.add(20, 0, -14);
		
		for(int x = 0; x < 13 ; x++ ) {
			for(int z = 0; z < 28 ; z++) {					
				playerLoc.add(x, 0, z).getBlock().setType(Material.GRASS_BLOCK);
				playerLoc.add(-x, 0, -z);						
			}						
		}
		
		playerLoc.add(-1, 0, -1);
		
		for(int z = 0; z < 30; z++ ) {
			playerLoc.add(0, 0, z).getBlock().setType(Material.STRIPPED_OAK_LOG);
			playerLoc.add(0, 0, -z);
			playerLoc.add(-1, 0, z).getBlock().setType(Material.BIRCH_FENCE);
			playerLoc.add(1, 0, -z);
			playerLoc.add(0, 1, z).getBlock().setType(Material.SPRUCE_WOOD);
			playerLoc.add(0, -1, -z);
			
		}
		
		for(int x = 0; x < 15; x++) {
			playerLoc.add(x, 0, 0).getBlock().setType(Material.STRIPPED_OAK_LOG);
			playerLoc.add(-x, 0, 0);
			playerLoc.add(x, 1, 0).getBlock().setType(Material.SPRUCE_WOOD);
			playerLoc.add(-x, -1, 0);
		}
		
		playerLoc.add(14, 0, 29);
		
		for(int x = 0; x > -15; x--) {
			playerLoc.add(x, 0, 0).getBlock().setType(Material.STRIPPED_OAK_LOG);
			playerLoc.add(-x, 0, 0);
			playerLoc.add(x, 1, 0).getBlock().setType(Material.SPRUCE_WOOD);
			playerLoc.add(-x, -1, 0);
		}
		
		for(int z = 0; z > -30; z--) {
			playerLoc.add(0, 0, z).getBlock().setType(Material.STRIPPED_OAK_LOG);
			playerLoc.add(0, 0, -z);
			playerLoc.add(0, 1, z).getBlock().setType(Material.SPRUCE_WOOD);
			playerLoc.add(0, -1, -z);
			
			if(z == 0  || z == -29)
			continue;
						 	
			if (z == -1 || z == -28 || z == -10 || z == -20) {
				playerLoc.add(-1, 1, z).getWorld().generateTree(playerLoc, TreeType.TREE);
				playerLoc.add(1, -1, -z);
				continue;
			}
				
			playerLoc.add(-1, 1, z).getBlock().setType(Material.DARK_OAK_FENCE);
			playerLoc.add(1, -1, -z);
					
		}		
		
		playerLoc = player.getLocation().add(4, 0, 0);		
		for(int x = 0; x < 5 ; x++) {
			playerLoc.getBlock().setType(Material.LEGACY_BIRCH_WOOD_STAIRS);
			Block block = playerLoc.getBlock();
			Directional directional = (Directional) block.getBlockData();
			directional.setFacing(BlockFace.EAST);
			block.setBlockData(directional);			
			playerLoc.add(1, 1, 0);			
		}
		
		playerLoc = player.getLocation().add(4, 0, -1);
		for(int x = 0; x < 5 ; x++) {
			
			playerLoc.getBlock().setType(Material.DARK_OAK_STAIRS);			
			Block block = playerLoc.getBlock();
			Directional directional = (Directional) block.getBlockData();
			directional.setFacing(BlockFace.EAST);
			block.setBlockData(directional);			
			playerLoc.add(1, 1, 0);	
			
		}
		
		playerLoc = player.getLocation().add(4, 0, 1);		
		for(int x = 0; x < 5 ; x++) {
			playerLoc.getBlock().setType(Material.DARK_OAK_STAIRS);
			Block block = playerLoc.getBlock();
			Directional directional = (Directional) block.getBlockData();
			directional.setFacing(BlockFace.EAST);
			block.setBlockData(directional);			
			playerLoc.add(1, 1, 0);			
		}		
		
		playerLoc = player.getLocation().add(4, 0, 2);
		for(int x = 0; x < 9 ; x++) {
			playerLoc.getBlock().setType(Material.OAK_FENCE);
			if (x < 5)
				playerLoc.add(1, 1, 0);
			else
				playerLoc.add(1, 0, 0);
		}
		
		playerLoc = player.getLocation().add(4, 0, -2);
		for(int x = 0; x < 9 ; x++) {
			playerLoc.getBlock().setType(Material.OAK_FENCE);
			if (x < 5)
				playerLoc.add(1, 1, 0);
			else
				playerLoc.add(1, 0, 0);
		}
		
		playerLoc = player.getLocation().add(5, 0, -2);
		for(int x = 0; x < 8 ; x++) {
			playerLoc.getBlock().setType(Material.OAK_LOG);
			if (x < 4)
				playerLoc.add(1, 1, 0);
			else
				playerLoc.add(1, 0, 0);
		}
		
		playerLoc = player.getLocation().add(5, 0, 2);
		for(int x = 0; x < 8; x++) {
			playerLoc.getBlock().setType(Material.OAK_LOG);
			if (x < 4)
				playerLoc.add(1, 1, 0);
			else
				playerLoc.add(1, 0, 0);		
		}
		
		playerLoc = player.getLocation().add(9, 4, 0);
		for(int x = 0; x < 4; x++) {
			if (x == 3) 
				playerLoc.getBlock().setType(Material.QUARTZ_BLOCK);
			else
				playerLoc.getBlock().setType(Material.BIRCH_PLANKS);
				playerLoc.add(1, 0, 0);
						
		}
		
		playerLoc = player.getLocation().add(9, 4, -1);
		for(int x = 0; x < 4; x++) {
			playerLoc.getBlock().setType(Material.DARK_OAK_PLANKS);
			playerLoc.add(1, 0, 0);
		}
				
		playerLoc = player.getLocation().add(9, 4, 1);
		for(int x = 0; x < 4; x++) {
			playerLoc.getBlock().setType(Material.DARK_OAK_PLANKS);
			playerLoc.add(1, 0, 0);
		}	
		
	}	
	
}