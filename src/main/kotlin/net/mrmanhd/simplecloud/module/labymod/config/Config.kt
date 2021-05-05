package net.mrmanhd.simplecloud.module.labymod.config

import net.mrmanhd.simplecloud.module.labymod.config.configuration.actionmenu.ActionMenuConfiguration
import net.mrmanhd.simplecloud.module.labymod.config.configuration.cinescopes.CinescopesConfiguration
import net.mrmanhd.simplecloud.module.labymod.config.configuration.playinggamemode.PlayingGamemodeConfiguration
import net.mrmanhd.simplecloud.module.labymod.config.configuration.recommendation.RecommendationConfiguration
import net.mrmanhd.simplecloud.module.labymod.config.configuration.richpresence.RichPresenceConfiguration
import net.mrmanhd.simplecloud.module.labymod.config.configuration.serverbanner.ServerBannerConfiguration
import net.mrmanhd.simplecloud.module.labymod.config.configuration.subtitle.SubtitleConfiguration
import net.mrmanhd.simplecloud.module.labymod.config.configuration.voicechat.VoiceChatConfiguration

/**
 * Created by MrManHD
 * Class create at 03.05.2021 21:55
 */

class Config(
    val playingGamemodeConfiguration: PlayingGamemodeConfiguration,
    val richPresenceConfiguration: RichPresenceConfiguration,
    val actionMenuConfiguration: ActionMenuConfiguration,
    val serverBannerConfiguration: ServerBannerConfiguration,
    val subtitleConfiguration: SubtitleConfiguration,
    val voiceChatConfiguration: VoiceChatConfiguration,
    val recommendationConfiguration: RecommendationConfiguration,
    val cinescopesConfiguration: CinescopesConfiguration
)