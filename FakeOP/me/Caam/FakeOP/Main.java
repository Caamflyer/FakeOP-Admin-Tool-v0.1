package me.Caam.FakeOP;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	public static Bukkit plugin;


	public void onEnable(){
		getLogger().info("FakeOP has been Enabled!");
		PluginManager pm = this.getServer().getPluginManager();
		pm.addPermission(new Permissions().FakeOP);
		pm.addPermission(new Permissions().FakeDEOP);
		
	}
	
	public void onDisable(){
		getLogger().info("FakeOP has been Disabled!");
		PluginManager pm = this.getServer().getPluginManager();
		pm.removePermission(new Permissions().FakeOP);
		pm.removePermission(new Permissions().FakeDEOP);
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		Player player = (Player) sender;
		if(commandLabel.equalsIgnoreCase("fop") || commandLabel.equalsIgnoreCase("fakeop")){
			if(args.length == 0){
				if(player.hasPermission(new Permissions().FakeOP) || player.isOp()){
				player.sendMessage(ChatColor.GRAY + "Try /fop <player>");
				}else {
				player.sendMessage(ChatColor.DARK_RED + "You are not permitted to run this command!");
			}
			}
			if(args.length == 1){
				if(player.getServer().getPlayer(args[0]) !=null){
					if(player.hasPermission(new Permissions().FakeOP) || player.isOp()){
					Player targetPlayer = player.getServer().getPlayer(args[0]);
					targetPlayer.sendMessage(ChatColor.GRAY + "" + ChatColor.ITALIC + "[CONSOLE: Opped " + targetPlayer.getDisplayName() + "]");
					targetPlayer.sendMessage(ChatColor.YELLOW + "You are now op!");
					player.sendMessage(ChatColor.GRAY + "You have just fake opped " + targetPlayer.getDisplayName() + ".");
					
					}else{
						player.sendMessage(ChatColor.DARK_RED + "You are not permitted to run this command!");
					}
				}else {
					player.sendMessage(ChatColor.DARK_RED + "That player is not online!");
				}
				}
			}
		
		if(commandLabel.equalsIgnoreCase("fdeop") || commandLabel.equalsIgnoreCase("fakedeop")){
			if(args.length == 0){
				if(player.hasPermission(new Permissions().FakeDEOP) || player.isOp()){
				player.sendMessage(ChatColor.GRAY + "Try /fdeop <player>");
				}else {
				player.sendMessage(ChatColor.DARK_RED + "You are not permitted to run this command!");
			}
			}
			if(args.length == 1){
				if(player.getServer().getPlayer(args[0]) !=null){
					if(player.hasPermission(new Permissions().FakeDEOP) || player.isOp()){
					Player targetPlayer = player.getServer().getPlayer(args[0]);
					targetPlayer.sendMessage(ChatColor.YELLOW + "You are no longer op!");
					player.sendMessage(ChatColor.GRAY + "You have just fake deopped " + targetPlayer.getDisplayName() + ".");
					
					}else{
						player.sendMessage(ChatColor.DARK_RED + "You are not permitted to run this command!");
					}
				}else {
					player.sendMessage(ChatColor.DARK_RED + "That player is not online!");
				}
				}
			}
		return false;
	} 
}