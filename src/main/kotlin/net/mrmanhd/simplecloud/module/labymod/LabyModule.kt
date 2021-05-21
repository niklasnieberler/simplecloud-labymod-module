package net.mrmanhd.simplecloud.module.labymod

import eu.thesimplecloud.api.service.ICloudService
import net.mrmanhd.simplecloud.module.labymod.config.ConfigLoader
import net.mrmanhd.simplecloud.module.labymod.handler.*
import org.bukkit.plugin.java.JavaPlugin

/**
 * Created by MrManHD
 * Class create at 03.05.2021 21:42
 */

class LabyModule(
    val javaPlugin: JavaPlugin? = null
) {

    val configLoader = ConfigLoader()
    val playingGamemodeHandler = PlayingGamemodeHandler()
    val richPresenceHandler = RichPresenceHandler()
    val actionMenuHandler = ActionMenuHandler()
    val serverBannerHandler = ServerBannerHandler()
    val subtitleHandler = SubtitleHandler()
    val voiceChatHandler = VoiceChatHandler()
    val recommendationHandler = RecommendationHandler()
    val cinescopesHandler = CinescopesHandler()
    val serverSwitchHandler = ServerSwitchHandler()

    init {
        instance = this
    }

    companion object {
        lateinit var instance: LabyModule
    }

    fun replaceString(message: String, cloudServer: ICloudService): String {
        return message
            .replace("%GROUP%", cloudServer.getGroupName())
            .replace("%NAME%", cloudServer.getName())
            .replace("%MOTD%", cloudServer.getMOTD())
            .replace("%NUMBER%", cloudServer.getServiceNumber().toString())
            .replace("%STATE%", cloudServer.getState().name)
            .replace("%ONLINE_PLAYERS%", cloudServer.getOnlineCount().toString())
            .replace("%MAX_PLAYERS%", cloudServer.getMaxPlayers().toString())
    }

}