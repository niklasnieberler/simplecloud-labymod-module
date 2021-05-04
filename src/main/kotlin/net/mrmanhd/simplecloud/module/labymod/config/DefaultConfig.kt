package net.mrmanhd.simplecloud.module.labymod.config

import net.mrmanhd.simplecloud.module.labymod.config.configuration.actionmenu.ActionMenuConfiguration
import net.mrmanhd.simplecloud.module.labymod.config.configuration.playinggamemode.PlayingGamemode
import net.mrmanhd.simplecloud.module.labymod.config.configuration.richpresence.RichPresence
import net.mrmanhd.simplecloud.module.labymod.config.configuration.actionmenu.ActionMenu
import net.mrmanhd.simplecloud.module.labymod.config.configuration.playinggamemode.PlayingGamemodeConfiguration
import net.mrmanhd.simplecloud.module.labymod.config.configuration.richpresence.RichPresenceConfiguration
import net.mrmanhd.simplecloud.module.labymod.config.configuration.serverbanner.ServerBanner
import net.mrmanhd.simplecloud.module.labymod.config.configuration.serverbanner.ServerBannerConfiguration

/**
 * Created by MrManHD
 * Class create at 03.05.2021 21:58
 */

class DefaultConfig {

    companion object {

        fun get(): Config {
            return Config(
                PlayingGamemodeConfiguration(true, getPlayingGamemodeList()),
                RichPresenceConfiguration(true, getRichPresenceList()),
                ActionMenuConfiguration(true, getActionMenuList()),
                ServerBannerConfiguration(true, getServerBannerList())
            )
        }

        private fun getPlayingGamemodeList(): List<PlayingGamemode> {
            return listOf(
                PlayingGamemode("BW-2x1", "ALL_PLAYERS", "BedWars-%NUMBER% §8(§e%ONLINE_PLAYERS%§8/§c%MAX_PLAYERS%§8)"),
                PlayingGamemode("BW-2x2", "cloud.laby.bedwars", "BedWars 2x2")
            )
        }

        private fun getRichPresenceList(): List<RichPresence> {
            return listOf(
                RichPresence("Lobby", "ALL_PLAYERS", "Lobby-%NUMBER% (%MOTD%)"),
                RichPresence("SW-2x1", "cloud.laby.skywars", "SkyWars [%STATE%] §8(§e%ONLINE_PLAYERS%§8/§c%MAX_PLAYERS%§8)")
            )
        }

        private fun getActionMenuList(): List<ActionMenu> {
            return listOf(
                ActionMenu("Kick player", "ALL_SERVERS", "cloud.laby.kick", "RUN_COMMAND", "kick {name}"),
                ActionMenu("Open shop", "Lobby", "ALL_PLAYERS", "OPEN_BROWSER", "https://shop.labymod.net"),
                ActionMenu("Copy playername", "Lobby", "ALL_PLAYERS", "CLIPBOARD", "{name}"),
                ActionMenu("Report player", "ALL_SERVERS", "ALL_PLAYERS", "SUGGEST_COMMAND", "report {name}")
            )
        }

        private fun getServerBannerList(): List<ServerBanner> {
            return listOf(
                ServerBanner("ALL_SERVERS", ""),
                ServerBanner("Lobby", "")
            )
        }

    }

}