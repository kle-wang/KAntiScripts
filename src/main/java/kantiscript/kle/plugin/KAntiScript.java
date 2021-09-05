package kantiscript.kle.plugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;


public final class KAntiScript extends JavaPlugin implements Listener {
    public int breakNum=0;
    public boolean verifyResult=false;
    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(this,this);
        Bukkit.getPluginCommand("kantiscripts").setExecutor(new Commands());
        getLogger().info("验证加载成功");
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    //gui监听
    @EventHandler
    public void OpenGui(InventoryClickEvent e){
        if(e.getView().getTitle().equals(ChatColor.LIGHT_PURPLE+"【昀汐落】点击附魔金苹果")) {
            e.setCancelled(true);

            if (e.getRawSlot() < 0 || e.getRawSlot() > e.getInventory().getSize() || e.getInventory() == null) {
                return;
            }
            Player player = (Player) e.getWhoClicked();
            if (e.getRawSlot()==new Scriptsfunction().getIndex()) {
                player.closeInventory();
                player.setInvulnerable(false);
                verifyResult=true;
            }else {
                player.closeInventory();
                player.setInvulnerable(false);
                verifyResult=true;
                player.kickPlayer("验证失败，请重新登陆！");
            }
        }
    }//end
    @EventHandler
    public void breakEvent(BlockBreakEvent e) {
        Player player = e.getPlayer();
        new BukkitRunnable(){
            @Override
            public void run(){
                breakNum=0;
            }
        }.runTaskTimer(this,1200L,1200L);
        if (e.getBlock().getType().equals(Material.DIAMOND_ORE)) {
            breakNum++;
        }

        if (breakNum >= 10) {
        new Scriptsfunction().startVerify(player);
        new BukkitRunnable(){
            @Override
            public void run(){
                if(!verifyResult){
                    breakNum=0;
                    player.kickPlayer("验证超时，请重新登陆！");
                    Bukkit.broadcastMessage("玩家："+player.getName()+"因未在规定时限完成认证被请出服务器！");
                }
            }
        }.runTaskLater(this,200L);
            verifyResult=false;
            breakNum = 0;
        }
    }






}
