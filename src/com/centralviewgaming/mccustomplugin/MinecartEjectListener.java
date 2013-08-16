package com.centralviewgaming.mccustomplugin;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Sign;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleMoveEvent;

public class MinecartEjectListener implements Listener{

    public MinecartEjectListener(CVGCustomPlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onVehicleMoveEvent(VehicleMoveEvent event){
    		if(event.getVehicle().getType() == EntityType.MINECART){
    			if(event.getVehicle().getPassenger() != null){
    				Player player = (Player) event.getVehicle().getPassenger();
    				Location loc = event.getVehicle().getLocation();
    				loc.setY(loc.getY() - 2);
    				if(loc.getBlock().getState() instanceof Sign){
    					Sign s = (Sign) loc.getBlock().getState();
    					if(s.getLine(0).toString().equals("(CVG EJECT)")){
    						event.getVehicle().eject();
    						String[] xyz = s.getLine(1).split("\\s+");
    						Double telX = Double.parseDouble(xyz[0]);
    						Double telY = Double.parseDouble(xyz[1]);
    						Double telZ = Double.parseDouble(xyz[2]);
    						Float telP = Float.parseFloat(s.getLine(2));
    						Location tele = new Location(Bukkit.getWorld(player.getWorld().getName()), telX, telY, telZ, telP, 0);
    						player.teleport(tele);
    					}
    				}
    			}
    		}
    	}
}