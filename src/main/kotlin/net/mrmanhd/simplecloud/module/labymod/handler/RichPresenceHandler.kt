package net.mrmanhd.simplecloud.module.labymod.handler

import eu.thesimplecloud.api.player.ICloudPlayer
import net.labymod.serverapi.api.LabyAPI
import net.mrmanhd.simplecloud.module.labymod.LabyModule
import net.mrmanhd.simplecloud.module.labymod.config.Config
import net.mrmanhd.simplecloud.module.labymod.config.configuration.richpresence.RichPresence
import net.mrmanhd.simplecloud.module.labymod.config.configuration.serverbanner.ServerBanner
import org.bukkit.entity.Player

/**
 * Created by MrManHD
 * Class create at 04.05.2021 14:50
 */

class RichPresenceHandler {

    fun handleRichPresence(config: Config, cloudPlayer: ICloudPlayer, player: Player) {

        getRichPresence(config, cloudPlayer)?.let {
            handlePlayerPermission(it, cloudPlayer, player)
            return
        }

        getMainRichPresence(config)?.let {
            handlePlayerPermission(it, cloudPlayer, player)
        }

    }

    private fun handlePlayerPermission(richPresence: RichPresence, cloudPlayer: ICloudPlayer, player: Player) {
        if (richPresence.permission != "ALL_PLAYERS" && !player.hasPermission(richPresence.permission)) {
            return
        }

        val richPresenceTransmitter = LabyAPI.getService().richPresenceTransmitter
        val replaceString = LabyModule.instance.replaceString(richPresence.message, cloudPlayer.getConnectedServer()!!)

        richPresenceTransmitter.updateRichPresence(player.uniqueId, replaceString, 0, 0)
    }

    private fun getRichPresence(config: Config, cloudPlayer: ICloudPlayer): RichPresence? {
        return config.richPresenceConfiguration.richPresenceList
            .firstOrNull { it.serverGroup == cloudPlayer.getConnectedServer()!!.getGroupName() }
    }

    private fun getMainRichPresence(config: Config): RichPresence? {
        return config.richPresenceConfiguration.richPresenceList.firstOrNull { it.serverGroup == "ALL_SERVERS" }
    }

}