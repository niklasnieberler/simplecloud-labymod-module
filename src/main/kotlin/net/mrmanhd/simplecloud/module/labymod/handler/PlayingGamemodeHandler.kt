package net.mrmanhd.simplecloud.module.labymod.handler

import eu.thesimplecloud.api.player.ICloudPlayer
import net.labymod.serverapi.api.LabyAPI
import net.mrmanhd.simplecloud.module.labymod.LabyModule
import net.mrmanhd.simplecloud.module.labymod.config.Config
import net.mrmanhd.simplecloud.module.labymod.config.configuration.playinggamemode.PlayingGamemode
import net.mrmanhd.simplecloud.module.labymod.config.configuration.serverbanner.ServerBanner
import org.bukkit.entity.Player

/**
 * Created by MrManHD
 * Class create at 04.05.2021 14:48
 */

class PlayingGamemodeHandler {

    fun handlePlayingGamemode(config: Config, cloudPlayer: ICloudPlayer, player: Player) {

        getMainPlayingGamemode(config)?.let {
            handlePlayerPermission(it, player, cloudPlayer)
            return
        }

        getPlayingGamemode(config, cloudPlayer)?.let {
            handlePlayerPermission(it, player, cloudPlayer)
        }
    }

    private fun handlePlayerPermission(playingGamemode: PlayingGamemode, player: Player, cloudPlayer: ICloudPlayer) {
        if (playingGamemode.permission != "ALL_PLAYERS" && !player.hasPermission(playingGamemode.permission)) {
            return
        }

        val playingGameModeTransmitter = LabyAPI.getService().playingGameModeTransmitter
        val replaceString = LabyModule.instance.replaceString(playingGamemode.message, cloudPlayer.getConnectedServer()!!)

        playingGameModeTransmitter.transmit(player.uniqueId, replaceString)

    }

    private fun getPlayingGamemode(config: Config, cloudPlayer: ICloudPlayer): PlayingGamemode? {
        return config.playingGamemodeConfiguration.playingGamemodeList
            .firstOrNull { it.serverGroup == cloudPlayer.getConnectedServer()!!.getGroupName() }
    }

    private fun getMainPlayingGamemode(config: Config): PlayingGamemode? {
        return config.playingGamemodeConfiguration.playingGamemodeList
            .firstOrNull { it.serverGroup == "ALL_SERVERS" }
    }

}