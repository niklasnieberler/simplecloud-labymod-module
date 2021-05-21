package net.mrmanhd.simplecloud.module.labymod.handler

import eu.thesimplecloud.api.player.ICloudPlayer
import net.labymod.serverapi.api.LabyAPI
import net.labymod.serverapi.api.serverinteraction.addon.AddonRecommendationTransmitter
import net.mrmanhd.simplecloud.module.labymod.config.Config
import net.mrmanhd.simplecloud.module.labymod.config.configuration.recommendation.Recommendation
import org.bukkit.entity.Player
import java.util.*

/**
 * Created by MrManHD
 * Class create at 05.05.2021 11:01
 */

class RecommendationHandler {

    fun handleRecommendation(config: Config, cloudPlayer: ICloudPlayer, player: Player) {
        val addonRecommendationTransmitter = LabyAPI.getService().addonRecommendationTransmitter

        getRecommendation(config, cloudPlayer).forEach {
            handlePlayerPermission(addonRecommendationTransmitter, it)
            return
        }

        getMainRecommendation(config).forEach {
            handlePlayerPermission(addonRecommendationTransmitter, it)
        }

        addonRecommendationTransmitter.transmit(player.uniqueId)
    }

    private fun handlePlayerPermission(
        addonRecommendationTransmitter: AddonRecommendationTransmitter,
        recommendation: Recommendation
    ) {
        val recommendedAddonFactory = LabyAPI.getService().recommendedAddonFactory
        val factory = recommendedAddonFactory.create(UUID.fromString(recommendation.addonUniqueId), recommendation.required)

        addonRecommendationTransmitter.addRecommendAddon(factory)
    }

    private fun getRecommendation(config: Config, cloudPlayer: ICloudPlayer): List<Recommendation> {
        return config.recommendationConfiguration.recommendationList
            .filter { it.serverGroup == cloudPlayer.getConnectedServer()!!.getGroupName() }.toList()
    }

    private fun getMainRecommendation(config: Config): List<Recommendation> {
        return config.recommendationConfiguration.recommendationList
            .filter { it.serverGroup == "ALL_SERVERS" }.toList()
    }

}