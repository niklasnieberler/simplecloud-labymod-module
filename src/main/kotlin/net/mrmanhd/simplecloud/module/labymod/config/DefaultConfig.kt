package net.mrmanhd.simplecloud.module.labymod.config

import net.labymod.serverapi.api.serverinteraction.actionmenu.ActionType
import net.mrmanhd.simplecloud.module.labymod.config.configuration.ActionMenuConfiguration
import net.mrmanhd.simplecloud.module.labymod.config.configuration.PlayingOnConfiguration
import net.mrmanhd.simplecloud.module.labymod.config.configuration.RichPresenceConfiguration

/**
 * Created by MrManHD
 * Class create at 03.05.2021 21:58
 */

class DefaultConfig {

    companion object {

        fun get(): Config {
            return Config(
                Settings(activeActionMenu = true, activePlayingGamemode = true, activeRichPresence = true),
                getPlayingOnConfigurationList(),
                getRichPresenceConfigurationList(),
                getActionMenuConfigurationList()
            )
        }

        private fun getPlayingOnConfigurationList(): List<PlayingOnConfiguration> {
            return listOf(
                PlayingOnConfiguration("BW-2x1", null, "BedWars-%NUMBER% §8(§e%ONLINE_PLAYERS%§8/§c%MAX_PLAYERS%§8)"),
                PlayingOnConfiguration("BW-2x2", "cloud.laby.bedwars", "BedWars 2x2")
            )
        }

        private fun getRichPresenceConfigurationList(): List<RichPresenceConfiguration> {
            return listOf(
                RichPresenceConfiguration("Lobby", null, "Lobby-%NUMBER% (%MOTD%)"),
                RichPresenceConfiguration("SW-2x1", "cloud.laby.skywars", "SkyWars [%STATE%] §8(§e%ONLINE_PLAYERS%§8/§c%MAX_PLAYERS%§8)")
            )
        }

        private fun getActionMenuConfigurationList(): List<ActionMenuConfiguration> {
            return listOf(
                ActionMenuConfiguration("Kick player", null, "cloud.laby.kick", "RUN_COMMAND", "kick {player}"),
                ActionMenuConfiguration("Open shop", "Lobby", null, "OPEN_BROWSER", "https://shop.labymod.net"),
                ActionMenuConfiguration("Copy playername", "Lobby", null, "CLIPBOARD", "{player}"),
                ActionMenuConfiguration("Report player", null, null, "SUGGEST_COMMAND", "report {player} >reason<")
            )
        }

    }

}