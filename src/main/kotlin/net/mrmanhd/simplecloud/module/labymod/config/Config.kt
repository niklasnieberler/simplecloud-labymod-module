package net.mrmanhd.simplecloud.module.labymod.config

import net.mrmanhd.simplecloud.module.labymod.config.configuration.ActionMenuConfiguration
import net.mrmanhd.simplecloud.module.labymod.config.configuration.PlayingOnConfiguration
import net.mrmanhd.simplecloud.module.labymod.config.configuration.RichPresenceConfiguration

/**
 * Created by MrManHD
 * Class create at 03.05.2021 21:55
 */

class Config(
    val settings: Settings,
    val playingOnConfigurationList: List<PlayingOnConfiguration>,
    val richPresenceConfigurationList: List<RichPresenceConfiguration>,
    val actionMenuConfigurationList: List<ActionMenuConfiguration>
)