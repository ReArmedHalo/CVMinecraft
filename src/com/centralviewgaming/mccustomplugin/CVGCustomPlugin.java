package com.centralviewgaming.mccustomplugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class CVGCustomPlugin extends JavaPlugin{

	double pluginVersion = 1.0;
	String pluginName = "CVG Custom Minecraft Plugin";
	String pluginabv = "CVGCP";
	
    @Override
    public void onEnable(){
    		new MinecartEjectListener(this);
    		getLogger().info(pluginName + " " + pluginVersion + " enabled!");
    }
    
    @Override
    public void onDisable() {
		getLogger().info(pluginName + " " + pluginVersion + " disabled!");
    }
    
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
    		if(args.length>0){
	    		if(cmd.getName().equalsIgnoreCase("cvg")){
	    			if(args[0].equalsIgnoreCase("vanish")){
	            		if(!(sender instanceof Player)){
	            			Player hideMe = Bukkit.getPlayer(args[1]);
	                		for (Player p: Bukkit.getOnlinePlayers()){
	                			p.hidePlayer(hideMe);
	                		}
	                		return true;
	    				}
	    			}
	    			if(args[0].equalsIgnoreCase("show")){
	    				if(!(sender instanceof Player)){
	            			Player showMe = Bukkit.getPlayer(args[1]);
	                		for (Player p: Bukkit.getOnlinePlayers()){
	                			p.showPlayer(showMe);
	                		}
	                		return true;
	    				}
	    			}
	    		}
    		}
    		return false;
	}
   
}