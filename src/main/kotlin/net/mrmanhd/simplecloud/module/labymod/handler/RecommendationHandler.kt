package net.mrmanhd.simplecloud.module.labymod.handler

import com.google.gson.JsonObject
import eu.thesimplecloud.api.player.ICloudPlayer
import net.labymod.serverapi.api.LabyAPI
import net.mrmanhd.simplecloud.module.labymod.config.Config
import net.mrmanhd.simplecloud.module.labymod.config.configuration.recommendation.Recommendation
import net.mrmanhd.simplecloud.module.labymod.config.configuration.voicechat.VoiceChat
import org.bukkit.entity.Player
import java.util.*

/**
 * Created by MrManHD
 * Class create at 05.05.2021 11:01
 */

class RecommendationHandler {

    fun handleRecommendation(config: Config, cloudPlayer: ICloudPlayer, player: Player) {
        val addonRecommendationTransmitter = LabyAPI.getService().addonRecommendationTransmitter

        getRecommendation(config, cloudPlayer)
            .filter { !(it.permission != "ALL_PLAYERS" && !player.hasPermission(it.permission)) }
            .forEach {

            val recommendedAddonFactory = LabyAPI.getService().recommendedAddonFactory
            val factory = recommendedAddonFactory.create(UUID.fromString(it.addonUniqueId), it.required)

            addonRecommendationTransmitter.addRecommendAddon(factory)

        }

        addonRecommendationTransmitter.transmit(player.uniqueId)

    }

    private fun getRecommendation(config: Config, cloudPlayer: ICloudPlayer): List<Recommendation> {
        return config.recommendationConfiguration.recommendationList
            .filter { !(it.serverGroup != "ALL_SERVERS" && it.serverGroup != cloudPlayer.getConnectedServer()!!.getGroupName()) }
    }


}