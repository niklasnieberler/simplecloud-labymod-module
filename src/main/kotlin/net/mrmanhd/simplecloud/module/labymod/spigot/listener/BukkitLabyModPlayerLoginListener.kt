package net.mrmanhd.simplecloud.module.labymod.spigot.listener

import eu.thesimplecloud.api.player.ICloudPlayer
import eu.thesimplecloud.plugin.extension.getCloudPlayer
import net.labymod.serverapi.api.LabyAPI
import net.labymod.serverapi.bukkit.event.BukkitLabyModPlayerLoginEvent
import net.mrmanhd.simplecloud.module.labymod.LabyModule
import net.mrmanhd.simplecloud.module.labymod.config.Config
import net.mrmanhd.simplecloud.module.labymod.config.PlayingOnConfiguration
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
        val playingOnConfiguration = getPlayingOnConfiguration(config, cloudPlayer)

        playingOnConfiguration?.let {
            if (it.permission != null && !player.hasPermission(it.permission)) {
                return
            }

            LabyAPI.getService().playingGameModeTransmitter.transmit(player.uniqueId, it.message)
        }


    }

    private fun getPlayingOnConfiguration(config: Config, cloudPlayer: ICloudPlayer): PlayingOnConfiguration? {
        return config.playingOnConfigurationList
            .firstOrNull { it.serverGroup == cloudPlayer.getConnectedServer()!!.getGroupName() }
    }

}