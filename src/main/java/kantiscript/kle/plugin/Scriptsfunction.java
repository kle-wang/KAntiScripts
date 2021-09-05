package kantiscript.kle.plugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.ArrayList;
import java.util.List;

public class Scriptsfunction {
    static int index = (int) (1 + Math.random() * (52 - 1 + 1));
    public void Gui(Player player) {
        Inventory Inv = Bukkit.createInventory(player, 6 * 9, ChatColor.LIGHT_PURPLE + "【昀汐落】点击附魔金苹果");
        //附魔金苹果
        ItemStack enchants_golden_apple = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE);
        ItemMeta meta = enchants_golden_apple.getItemMeta();
        meta.setDisplayName("请点击我");
        List<String> enchants_golden_apple_lore = new ArrayList<>();
        enchants_golden_apple_lore.add("点击我通过验证");
        meta.setLore(enchants_golden_apple_lore);
        enchants_golden_apple.setItemMeta(meta);
        //干扰项
        ItemStack g1 = new ItemStack(Material.GOLDEN_APPLE);
        ItemMeta g1meta = g1.getItemMeta();
        g1meta.setDisplayName("不要点击我，否则你会被惩罚");
        List<String> g1lore = new ArrayList<>();
        g1lore.add("不要点击我，否则你会被惩罚");
        g1meta.setLore(g1lore);
        g1.setItemMeta(g1meta);

        ItemStack g2 = new ItemStack(Material.APPLE);
        ItemMeta g2meta = g2.getItemMeta();
        g2meta.setDisplayName("不要点击我，否则你会被惩罚");
        List<String> g2lore = new ArrayList<>();
        g2lore.add("不要点击我，否则你会被惩罚");
        g2meta.setLore(g2lore);
        g2.setItemMeta(g2meta);

        ItemStack g3 = new ItemStack(Material.STRING);
        ItemMeta g3meta = g3.getItemMeta();
        g3meta.setDisplayName("不要点击我，否则你会被惩罚");
        List<String> g3lore = new ArrayList<>();
        g3lore.add("不要点击我，否则你会被惩罚");
        g3meta.setLore(g3lore);
        g3.setItemMeta(g3meta);

        ItemStack g4 = new ItemStack(Material.COBWEB);
        ItemMeta g4meta = g4.getItemMeta();
        g4meta.setDisplayName("不要点击我，否则你会被惩罚");
        List<String> g4lore = new ArrayList<>();
        g4lore.add("不要点击我，否则你会被惩罚");
        g4meta.setLore(g4lore);
        g4.setItemMeta(g4meta);
        //end
        //干扰项
        for (int i = 0; i <= 100; i++) {
            int index1 = (int) (1 + Math.random() * (52 - 1 + 1));
            int index2 = (int) (1 + Math.random() * (52 - 1 + 1));
            int index3 = (int) (1 + Math.random() * (52 - 1 + 1));
            Inv.setItem(index1, g1);
            Inv.setItem(index2, g2);
            Inv.setItem(index3, g3);
        }
        //正确点击
        Inv.setItem(index, enchants_golden_apple);
        //opengui
        player.openInventory(Inv);
    }//endgui

    //return index
    public int getIndex() {
        return index;
    }//end return index

    //startVerify
    public void startVerify(Player player) {
        //GOD TRUE
        player.setInvulnerable(true);
        //OPEN GUI
        Gui(player);



    }


}



