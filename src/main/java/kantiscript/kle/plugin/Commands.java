package kantiscript.kle.plugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Commands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player=(Player)sender;
        switch (args[0]){
            case "a":
                if(player.isOp()){
                    new Scriptsfunction().startVerify(player);
                    return true;
                }
               return true;
        }
        return true;
    }
}
