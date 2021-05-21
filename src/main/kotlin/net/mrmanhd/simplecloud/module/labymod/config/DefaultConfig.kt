package net.mrmanhd.simplecloud.module.labymod.config

import net.mrmanhd.simplecloud.module.labymod.config.configuration.actionmenu.ActionMenuConfiguration
import net.mrmanhd.simplecloud.module.labymod.config.configuration.playinggamemode.PlayingGamemode
import net.mrmanhd.simplecloud.module.labymod.config.configuration.richpresence.RichPresence
import net.mrmanhd.simplecloud.module.labymod.config.configuration.actionmenu.ActionMenu
import net.mrmanhd.simplecloud.module.labymod.config.configuration.cinescopes.Cinescopes
import net.mrmanhd.simplecloud.module.labymod.config.configuration.cinescopes.CinescopesConfiguration
import net.mrmanhd.simplecloud.module.labymod.config.configuration.playinggamemode.PlayingGamemodeConfiguration
import net.mrmanhd.simplecloud.module.labymod.config.configuration.recommendation.Recommendation
import net.mrmanhd.simplecloud.module.labymod.config.configuration.recommendation.RecommendationConfiguration
import net.mrmanhd.simplecloud.module.labymod.config.configuration.richpresence.RichPresenceConfiguration
import net.mrmanhd.simplecloud.module.labymod.config.configuration.serverbanner.ServerBanner
import net.mrmanhd.simplecloud.module.labymod.config.configuration.serverbanner.ServerBannerConfiguration
import net.mrmanhd.simplecloud.module.labymod.config.configuration.serverswitch.ServerSwitch
import net.mrmanhd.simplecloud.module.labymod.config.configuration.serverswitch.ServerSwitchConfiguration
import net.mrmanhd.simplecloud.module.labymod.config.configuration.subtitle.Subtitle
import net.mrmanhd.simplecloud.module.labymod.config.configuration.subtitle.SubtitleConfiguration
import net.mrmanhd.simplecloud.module.labymod.config.configuration.voicechat.VoiceChat
import net.mrmanhd.simplecloud.module.labymod.config.configuration.voicechat.VoiceChatConfiguration

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
                ServerBannerConfiguration(true, getServerBannerList()),
                SubtitleConfiguration(true, getSubtitleList()),
                VoiceChatConfiguration(true, getVoiceChatList()),
                RecommendationConfiguration(true, getRecommendationList()),
                CinescopesConfiguration(true, getCinescopesList()),
                ServerSwitchConfiguration(true, getServerSwitchList())
            )
        }

        private fun getPlayingGamemodeList(): List<PlayingGamemode> {
            return listOf(
                PlayingGamemode("ALL_SERVERS", "ALL_PLAYERS", "%GROUP%-%NUMBER% §8(§e%ONLINE_PLAYERS%§8/§c%MAX_PLAYERS%§8)"),
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
                ServerBanner("ALL_SERVERS", "ALL_PLAYERS","https://i.imgur.com/eTQJ1IX.png"),
                ServerBanner("Lobby", "cloud.laby.serverbanner","https://i.imgur.com/eTQJ1IX.png")
            )
        }

        private fun getSubtitleList(): List<Subtitle> {
            return listOf(
                Subtitle("§cPizza","ALL_SERVERS", "cloud.laby.subtitle.pizza", 0.8),
                Subtitle("§6Bohemian Rhapsody","Lobby", "ALL_PLAYERS", 1.6)
            )
        }

        private fun getVoiceChatList(): List<VoiceChat> {
            return listOf(
                VoiceChat("ALL_SERVERS", "cloud.laby.voicechat", false),
                VoiceChat("Lobby", "ALL_PLAYERS", true)
            )
        }

        private fun getRecommendationList(): List<Recommendation> {
            return listOf(
                Recommendation("ALL_SERVERS", "cloud.laby.recommendation", "7d62bffd-fe3f-4667-8200-e8decb384fa0",false),
                Recommendation("Lobby", "ALL_PLAYERS", "01687f50-baee-4af9-9123-9e1c680f2d9d",true)
            )
        }

        private fun getCinescopesList(): List<Cinescopes> {
            return listOf(
                Cinescopes("ALL_SERVERS", "cloud.laby.cinescops", 0, 20),
                Cinescopes("Lobby", "ALL_PLAYERS", 50,100)
            )
        }

        private fun getServerSwitchList(): List<ServerSwitch> {
            return listOf(
                ServerSwitch("ALL_SERVERS", "cloud.laby.serverswitch", "127.0.0.1", "Cooler Server", false),
                ServerSwitch("Lobby", "ALL_PLAYERS", "TrayMC.net", ":)", true)
            )
        }

    }

}