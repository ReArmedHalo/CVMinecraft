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
    					if(s.getLine(3).toString().equals("(CVG EJECT)")){
    						event.getVehicle().eject();
    						Location tele = new Location(Bukkit.getWorld(player.getWorld().getName()), 81, 100, 493.5, -90, 0);
    						player.teleport(tele);
    					}
    				}
    			}
    		}
    	}
}