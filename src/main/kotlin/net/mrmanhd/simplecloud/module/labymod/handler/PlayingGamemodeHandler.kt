package net.mrmanhd.simplecloud.module.labymod.handler

import eu.thesimplecloud.api.player.ICloudPlayer
import net.labymod.serverapi.api.LabyAPI
import net.mrmanhd.simplecloud.module.labymod.LabyModule
import net.mrmanhd.simplecloud.module.labymod.config.Config
import net.mrmanhd.simplecloud.module.labymod.config.configuration.playinggamemode.PlayingGamemode
import org.bukkit.entity.Player
import org.bukkit.scheduler.BukkitRunnable

/**
 * Created by MrManHD
 * Class create at 04.05.2021 14:48
 */

class PlayingGamemodeHandler {

    fun handlePlayingGamemode(config: Config, cloudPlayer: ICloudPlayer, player: Player) {

        getPlayingGamemode(config, cloudPlayer)?.let {
            handlePlayerPermission(it, player, cloudPlayer)
            return
        }

        getMainPlayingGamemode(config)?.let {
            handlePlayerPermission(it, player, cloudPlayer)
        }

    }

    private fun handlePlayerPermission(playingGamemode: PlayingGamemode, player: Player, cloudPlayer: ICloudPlayer) {
        if (playingGamemode.permission != "ALL_PLAYERS" && !player.hasPermission(playingGamemode.permission)) {
            return
        }

        val playingGameModeTransmitter = LabyAPI.getService().playingGameModeTransmitter
        val replaceString = LabyModule.instance.replaceString(playingGamemode.message, cloudPlayer.getConnectedServer()!!)

        object : BukkitRunnable() {
            override fun run() {
                playingGameModeTransmitter.transmit(player.uniqueId, replaceString)
            }

        }.runTaskLater(LabyModule.instance.javaPlugin!!, 10)

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