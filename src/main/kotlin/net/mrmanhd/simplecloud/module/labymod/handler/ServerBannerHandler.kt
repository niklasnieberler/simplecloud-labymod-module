package net.mrmanhd.simplecloud.module.labymod.handler

import com.google.gson.JsonObject
import eu.thesimplecloud.api.player.ICloudPlayer
import net.labymod.serverapi.api.LabyAPI
import net.mrmanhd.simplecloud.module.labymod.config.Config
import net.mrmanhd.simplecloud.module.labymod.config.configuration.serverbanner.ServerBanner
import org.bukkit.entity.Player

/**
 * Created by MrManHD
 * Class create at 04.05.2021 23:54
 */

class ServerBannerHandler {

    fun handleServerBanner(config: Config, cloudPlayer: ICloudPlayer, player: Player) {

        getServerBanner(config, cloudPlayer)?.let {
            handlePlayerPermission(it, player)
            return
        }

        getMainServerBanner(config)?.let {
            handlePlayerPermission(it, player)
        }

    }

    private fun handlePlayerPermission(serverBanner: ServerBanner, player: Player) {
        if (serverBanner.permission != "ALL_PLAYERS" && !player.hasPermission(serverBanner.permission)) {
            return
        }

        val jsonObject = JsonObject()
        jsonObject.addProperty("url", serverBanner.url)

        val payloadCommunicator = LabyAPI.getService().payloadCommunicator
        payloadCommunicator.sendLabyModMessage(player.uniqueId, "server_banner", jsonObject)
    }

    private fun getServerBanner(config: Config, cloudPlayer: ICloudPlayer): ServerBanner? {
        return config.serverBannerConfiguration.serverBannerList
            .firstOrNull { it.serverGroup == cloudPlayer.getConnectedServer()!!.getGroupName() }
    }

    private fun getMainServerBanner(config: Config): ServerBanner? {
        return config.serverBannerConfiguration.serverBannerList.firstOrNull { it.serverGroup == "ALL_SERVERS" }
    }

}