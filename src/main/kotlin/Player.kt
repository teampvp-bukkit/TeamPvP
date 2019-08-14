import org.bukkit.Bukkit
import org.bukkit.entity.Player as BukkitPlayer

class Player(player: BukkitPlayer) {
    companion object {
        private val players = mutableMapOf<BukkitPlayer, Player>()

        fun fromUsername(username: String) : Player? = players[Bukkit.getPlayer(username)]
        fun create(player: BukkitPlayer) {

        }
    }
}