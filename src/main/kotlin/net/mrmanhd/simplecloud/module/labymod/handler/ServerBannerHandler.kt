package net.mrmanhd.simplecloud.module.labymod.handler

import com.google.gson.JsonArray
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

        getMainServerBanner(config)?.let {
            sendServerBanner(player, it.url)
            return
        }

        getServerBanner(config, cloudPlayer)?.let {
            sendServerBanner(player, it.url)
        }

    }

    private fun getServerBanner(config: Config, cloudPlayer: ICloudPlayer): ServerBanner? {
        return config.serverBannerConfiguration.tablistList
            .firstOrNull { it.serverGroup == cloudPlayer.getConnectedServer()!!.getGroupName() }
    }

    private fun getMainServerBanner(config: Config): ServerBanner? {
        return config.serverBannerConfiguration.tablistList.firstOrNull { it.serverGroup == "all" }
    }

    private fun sendServerBanner(player: Player, url: String) {
        val jsonObject = JsonObject()
        jsonObject.addProperty("url", url)

        val payloadCommunicator = LabyAPI.getService().payloadCommunicator
        payloadCommunicator.sendLabyModMessage(player.uniqueId, "server_banner", jsonObject)
    }

}