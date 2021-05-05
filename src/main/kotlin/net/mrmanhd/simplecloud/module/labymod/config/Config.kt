package net.mrmanhd.simplecloud.module.labymod.config

import net.mrmanhd.simplecloud.module.labymod.config.configuration.actionmenu.ActionMenuConfiguration
import net.mrmanhd.simplecloud.module.labymod.config.configuration.playinggamemode.PlayingGamemodeConfiguration
import net.mrmanhd.simplecloud.module.labymod.config.configuration.richpresence.RichPresenceConfiguration
import net.mrmanhd.simplecloud.module.labymod.config.configuration.serverbanner.ServerBannerConfiguration
import net.mrmanhd.simplecloud.module.labymod.config.configuration.subtitle.SubtitleConfiguration

/**
 * Created by MrManHD
 * Class create at 03.05.2021 21:55
 */

class Config(
    val playingGamemodeConfiguration: PlayingGamemodeConfiguration,
    val richPresenceConfiguration: RichPresenceConfiguration,
    val actionMenuConfiguration: ActionMenuConfiguration,
    val serverBannerConfiguration: ServerBannerConfiguration,
    val subtitleConfiguration: SubtitleConfiguration
)