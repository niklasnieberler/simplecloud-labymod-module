package net.mrmanhd.simplecloud.module.labymod.spigot.listener

import eu.thesimplecloud.api.player.ICloudPlayer
import eu.thesimplecloud.plugin.extension.getCloudPlayer
import net.labymod.serverapi.bukkit.event.BukkitLabyModPlayerLoginEvent
import net.mrmanhd.simplecloud.module.labymod.LabyModule
import net.mrmanhd.simplecloud.module.labymod.config.Config
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener

/**
 * Created by MrManHD
 * Class create at 04.05.2021 14:06
 */

class BukkitLabyModPlayerLoginListener : Listener {

    @EventHandler
    fun handleBukkitLabyModPlayerLogin(event: BukkitLabyModPlayerLoginEvent) {
        val config = LabyModule.instance.configLoader.getConfig()

        val player = event.player
        val cloudPlayer = player.getCloudPlayer()


        handle(config, cloudPlayer, player)

    }

    private fun handle(config: Config, cloudPlayer: ICloudPlayer, player: Player) {

        if (config.playingGamemodeConfiguration.activate) {
            LabyModule.instance.playingGamemodeHandler.handlePlayingGamemode(config, cloudPlayer, player)
        }

        if (config.actionMenuConfiguration.activate) {
            LabyModule.instance.actionMenuHandler.handleActionMenu(config, cloudPlayer, player)
        }

        if (config.richPresenceConfiguration.activate) {
            LabyModule.instance.richPresenceHandler.handleRichPresence(config, cloudPlayer, player)
        }

        if (config.serverBannerConfiguration.activate) {
            LabyModule.instance.serverBannerHandler.handleServerBanner(config, cloudPlayer, player)
        }

        if (config.subtitleConfiguration.activate) {
            LabyModule.instance.subtitleHandler.handleSubtitle(config, cloudPlayer, player)
        }

        if (config.voiceChatConfiguration.activate) {
            LabyModule.instance.voiceChatHandler.handleVoiceChat(config, cloudPlayer, player)
        }

        if (config.recommendationConfiguration.activate) {
            LabyModule.instance.recommendationHandler.handleRecommendation(config, cloudPlayer, player)
        }

        if (config.cinescopesConfiguration.activate) {
            LabyModule.instance.cinescopesHandler.handleCinescopes(config, cloudPlayer, player)
        }
    }


}