package net.mrmanhd.simplecloud.module.labymod.handler

import eu.thesimplecloud.api.player.ICloudPlayer
import net.labymod.serverapi.api.LabyAPI
import net.mrmanhd.simplecloud.module.labymod.config.Config
import net.mrmanhd.simplecloud.module.labymod.config.configuration.serverswitch.ServerSwitch
import org.bukkit.entity.Player

/**
 * Created by MrManHD
 * Class create at 05.05.2021 19:52
 */

class ServerSwitchHandler {

    fun handleServerSwitch(config: Config, cloudPlayer: ICloudPlayer, player: Player) {

        getMainServerSwitch(config)?.let {
            handlePlayerPermission(it, player)
            return
        }

        getServerSwitch(config, cloudPlayer)?.let {
            handlePlayerPermission(it, player)
        }

    }

    private fun handlePlayerPermission(serverSwitch: ServerSwitch, player: Player) {
        if (serverSwitch.permission != "ALL_PLAYERS" && !player.hasPermission(serverSwitch.permission)) {
            return
        }

        val serverSwitcherTransmitter = LabyAPI.getService().serverSwitcherTransmitter
        serverSwitcherTransmitter.transmit(player.uniqueId, serverSwitch.title, serverSwitch.address, serverSwitch.preview)
    }

    private fun getServerSwitch(config: Config, cloudPlayer: ICloudPlayer): ServerSwitch? {
        return config.serverSwitchConfiguration.serverSwitchList
            .firstOrNull { it.serverGroup == cloudPlayer.getConnectedServer()!!.getGroupName() }
    }

    private fun getMainServerSwitch(config: Config): ServerSwitch? {
        return config.serverSwitchConfiguration
            .serverSwitchList.firstOrNull { it.serverGroup == "ALL_SERVERS" }
    }

}