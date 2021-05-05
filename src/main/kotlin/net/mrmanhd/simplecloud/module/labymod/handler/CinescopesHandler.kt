package net.mrmanhd.simplecloud.module.labymod.handler

import com.google.gson.JsonObject
import eu.thesimplecloud.api.player.ICloudPlayer
import net.labymod.serverapi.api.LabyAPI
import net.mrmanhd.simplecloud.module.labymod.config.Config
import net.mrmanhd.simplecloud.module.labymod.config.configuration.cinescopes.Cinescopes
import net.mrmanhd.simplecloud.module.labymod.config.configuration.serverbanner.ServerBanner
import org.bukkit.entity.Player

/**
 * Created by MrManHD
 * Class create at 05.05.2021 11:20
 */

class CinescopesHandler {

    fun handleCinescopes(config: Config, cloudPlayer: ICloudPlayer, player: Player) {

        getMainCinescopes(config)?.let {
            handlePlayerPermission(it, player)
            return
        }

        getCinescopes(config, cloudPlayer)?.let {
            handlePlayerPermission(it, player)
        }

    }

    private fun handlePlayerPermission(cinescopes: Cinescopes, player: Player) {
        if (cinescopes.permission != "ALL_PLAYERS" && !player.hasPermission(cinescopes.permission)) {
            return
        }

        val cineScopesTransmitter = LabyAPI.getService().cineScopesTransmitter
        cineScopesTransmitter.transmit(player.uniqueId, true, cinescopes.coverage, cinescopes.duration)
    }

    private fun getCinescopes(config: Config, cloudPlayer: ICloudPlayer): Cinescopes? {
        return config.cinescopesConfiguration.cinescopesList
            .firstOrNull { it.serverGroup == cloudPlayer.getConnectedServer()!!.getGroupName() }
    }

    private fun getMainCinescopes(config: Config): Cinescopes? {
        return config.cinescopesConfiguration.cinescopesList.firstOrNull { it.serverGroup == "ALL_SERVERS" }
    }

}