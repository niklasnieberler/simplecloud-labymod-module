package net.mrmanhd.simplecloud.module.labymod.spigot.listener

import eu.thesimplecloud.api.player.ICloudPlayer
import eu.thesimplecloud.plugin.extension.getCloudPlayer
import net.labymod.serverapi.bukkit.event.BukkitLabyModPlayerLoginEvent
import net.mrmanhd.simplecloud.module.labymod.LabyModule
import net.mrmanhd.simplecloud.module.labymod.config.Config
import net.mrmanhd.simplecloud.module.labymod.config.Settings
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener

/**
 * Created by MrManHD
 * Class create at 04.05.2021 14:06
 */

class BukkitLabyModPlayerLoginListener : Listener {

    @EventHandler
    fun handleBukkitLabyModPlayerLogin(event: BukkitLabyModPlayerLoginEvent) {
        val config = LabyModule.instance.configLoader.getConfig()

        val player = event.player
        val cloudPlayer = player.getCloudPlayer()


        handle(config, cloudPlayer, player)

    }

    private fun handle(config: Config, cloudPlayer: ICloudPlayer, player: Player) {
        val settings = config.settings

        if (settings.activePlayingGamemode) {
            LabyModule.instance.playingGamemodeHandler.handlePlayingGamemode(config, cloudPlayer, player)
        }

        if (settings.activeActionMenu) {
            LabyModule.instance.actionMenuHandler.handleActionMenu(config, cloudPlayer, player)
        }

        if (settings.activeRichPresence) {
            LabyModule.instance.richPresenceHandler.handleRichPresence(config, cloudPlayer, player)
        }
    }


}