package net.mrmanhd.simplecloud.module.labymod

import eu.thesimplecloud.api.service.ICloudService
import net.mrmanhd.simplecloud.module.labymod.config.ConfigLoader
import net.mrmanhd.simplecloud.module.labymod.handler.ActionMenuHandler
import net.mrmanhd.simplecloud.module.labymod.handler.PlayingGamemodeHandler
import net.mrmanhd.simplecloud.module.labymod.handler.RichPresenceHandler

/**
 * Created by MrManHD
 * Class create at 03.05.2021 21:42
 */

class LabyModule {

    val configLoader = ConfigLoader()
    val playingGamemodeHandler = PlayingGamemodeHandler()
    val richPresenceHandler = RichPresenceHandler()
    val actionMenuHandler = ActionMenuHandler()

    init {
        instance = this
    }

    companion object {
        lateinit var instance: LabyModule
    }

    fun replaceString(message: String, cloudServer: ICloudService): String {
        return message
            .replace("%MOTD%", cloudServer.getMOTD())
            .replace("%NUMBER%", cloudServer.getServiceNumber().toString())
            .replace("%STATE%", cloudServer.getState().name)
            .replace("%ONLINE_PLAYERS%", cloudServer.getOnlineCount().toString())
            .replace("%MAX_PLAYERS%", cloudServer.getMaxPlayers().toString())
    }

}