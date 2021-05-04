package net.mrmanhd.simplecloud.module.labymod.handler

import eu.thesimplecloud.api.player.ICloudPlayer
import net.labymod.serverapi.api.LabyAPI
import net.labymod.serverapi.api.serverinteraction.actionmenu.ActionType
import net.mrmanhd.simplecloud.module.labymod.config.Config
import net.mrmanhd.simplecloud.module.labymod.config.configuration.ActionMenuConfiguration
import org.bukkit.entity.Player

/**
 * Created by MrManHD
 * Class create at 04.05.2021 17:04
 */

class ActionMenuHandler {

    fun handleActionMenu(config: Config, cloudPlayer: ICloudPlayer, player: Player) {
        val menuTransmitter = LabyAPI.getService().menuTransmitter

        getActionMenuConfigurationList(config, cloudPlayer)
            .filter { !(it.permission != null && !player.hasPermission(it.permission)) }
            .forEach {

            val menuEntry = LabyAPI.getService().menuEntryFactory.create(it.displayName, it.value, ActionType.valueOf(it.type))
            menuTransmitter.addEntry(menuEntry)

        }

        menuTransmitter.transmit(player.uniqueId)

    }

    private fun getActionMenuConfigurationList(config: Config, cloudPlayer: ICloudPlayer): List<ActionMenuConfiguration> {
        return config.actionMenuConfigurationList
            .filter { !(it.serverGroup != null && it.serverGroup != cloudPlayer.getConnectedServer()!!.getGroupName()) }
    }

}