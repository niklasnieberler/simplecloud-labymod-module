package net.mrmanhd.simplecloud.module.labymod.handler

import eu.thesimplecloud.api.player.ICloudPlayer
import net.labymod.serverapi.api.LabyAPI
import net.mrmanhd.simplecloud.module.labymod.LabyModule
import net.mrmanhd.simplecloud.module.labymod.config.Config
import net.mrmanhd.simplecloud.module.labymod.config.configuration.playinggamemode.PlayingGamemode
import org.bukkit.entity.Player

/**
 * Created by MrManHD
 * Class create at 04.05.2021 14:48
 */

class PlayingGamemodeHandler {

    fun handlePlayingGamemode(config: Config, cloudPlayer: ICloudPlayer, player: Player) {

        getPlayingGamemode(config, cloudPlayer)?.let {
            if (it.permission != null && !player.hasPermission(it.permission)) {
                return
            }

            val playingGameModeTransmitter = LabyAPI.getService().playingGameModeTransmitter
            val replaceString = LabyModule.instance.replaceString(it.message, cloudPlayer.getConnectedServer()!!)

            playingGameModeTransmitter.transmit(player.uniqueId, replaceString)
        }
    }

    private fun getPlayingGamemode(config: Config, cloudPlayer: ICloudPlayer): PlayingGamemode? {
        return config.playingGamemodeConfiguration.playingGamemodeList
            .firstOrNull { it.serverGroup == cloudPlayer.getConnectedServer()!!.getGroupName() }
    }

}