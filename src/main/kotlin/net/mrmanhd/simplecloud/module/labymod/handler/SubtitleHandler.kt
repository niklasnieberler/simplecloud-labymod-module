package net.mrmanhd.simplecloud.module.labymod.handler

import eu.thesimplecloud.api.player.ICloudPlayer
import net.labymod.serverapi.api.LabyAPI
import net.mrmanhd.simplecloud.module.labymod.config.Config
import net.mrmanhd.simplecloud.module.labymod.config.configuration.subtitle.Subtitle
import org.bukkit.entity.Player

/**
 * Created by MrManHD
 * Class create at 05.05.2021 00:24
 */

class SubtitleHandler {

    fun handleSubtitle(config: Config, cloudPlayer: ICloudPlayer, player: Player) {

        getSubtitle(config, cloudPlayer)?.let {
            handlePlayerPermission(it, player)
            return
        }

        getMainSubtitle(config)?.let {
            handlePlayerPermission(it, player)
        }

    }

    private fun handlePlayerPermission(subtitle: Subtitle, player: Player) {
        if (subtitle.permission != "ALL_PLAYERS" && !player.hasPermission(subtitle.permission)) {
            return
        }

        val factory = LabyAPI.getService().subTitleFactory.create(player.uniqueId, subtitle.displayName, subtitle.size)
        LabyAPI.getService().subTitleTransmitter.addSubtitle(factory).transmit(player.uniqueId)
    }

    private fun getSubtitle(config: Config, cloudPlayer: ICloudPlayer): Subtitle? {
        return config.subtitleConfiguration.subtitleList
            .firstOrNull { it.serverGroup == cloudPlayer.getConnectedServer()!!.getGroupName() }
    }

    private fun getMainSubtitle(config: Config): Subtitle? {
        return config.subtitleConfiguration.subtitleList.firstOrNull { it.serverGroup == "ALL_SERVERS" }
    }

}