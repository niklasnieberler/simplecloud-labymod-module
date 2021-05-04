package net.mrmanhd.simplecloud.module.labymod.handler

import eu.thesimplecloud.api.player.ICloudPlayer
import net.labymod.serverapi.api.LabyAPI
import net.mrmanhd.simplecloud.module.labymod.LabyModule
import net.mrmanhd.simplecloud.module.labymod.config.Config
import net.mrmanhd.simplecloud.module.labymod.config.configuration.richpresence.RichPresence
import org.bukkit.entity.Player

/**
 * Created by MrManHD
 * Class create at 04.05.2021 14:50
 */

class RichPresenceHandler {

    fun handleRichPresence(config: Config, cloudPlayer: ICloudPlayer, player: Player) {

        getRichPresence(config, cloudPlayer)?.let {
            if (it.permission != "ALL_PLAYERS" && !player.hasPermission(it.permission)) {
                return
            }

            val richPresenceTransmitter = LabyAPI.getService().richPresenceTransmitter
            val replaceString = LabyModule.instance.replaceString(it.message, cloudPlayer.getConnectedServer()!!)

            richPresenceTransmitter.updateRichPresence(player.uniqueId, replaceString, 0, 0)
        }
    }

    private fun getRichPresence(config: Config, cloudPlayer: ICloudPlayer): RichPresence? {
        return config.richPresenceConfiguration.richPresenceList
            .firstOrNull { it.serverGroup == cloudPlayer.getConnectedServer()!!.getGroupName() }
    }

}