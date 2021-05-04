package net.mrmanhd.simplecloud.module.labymod.handler

import eu.thesimplecloud.api.player.ICloudPlayer
import net.labymod.serverapi.api.LabyAPI
import net.labymod.serverapi.api.serverinteraction.actionmenu.ActionType
import net.labymod.serverapi.api.serverinteraction.actionmenu.MenuEntry
import net.mrmanhd.simplecloud.module.labymod.config.Config
import net.mrmanhd.simplecloud.module.labymod.config.configuration.ActionMenuConfiguration
import org.bukkit.entity.Player

/**
 * Created by MrManHD
 * Class create at 04.05.2021 17:04
 */

class ActionMenuHandler {

    private val menuEntryMap = hashMapOf<Player, ArrayList<MenuEntry>>()

    fun handleActionMenu(config: Config, cloudPlayer: ICloudPlayer, player: Player) {
        val menuTransmitter = LabyAPI.getService().menuTransmitter

        getActionMenuConfigurationList(config, cloudPlayer)
            .filter { !(it.permission != null && !player.hasPermission(it.permission)) }
            .forEach {

            val menuEntry = LabyAPI.getService().menuEntryFactory.create(it.displayName, it.value, ActionType.valueOf(it.type))
            addMenuEntry(player, menuEntry)

        }

        menuEntryMap[player]?.let {
            menuTransmitter.addEntries(*it.toTypedArray()).transmit(player.uniqueId)
            menuEntryMap.remove(player)
        }

    }

    private fun getActionMenuConfigurationList(config: Config, cloudPlayer: ICloudPlayer): List<ActionMenuConfiguration> {
        return config.actionMenuConfigurationList
            .filter { !(it.serverGroup != null && it.serverGroup != cloudPlayer.getConnectedServer()!!.getGroupName()) }
    }

    private fun addMenuEntry(player: Player, menuEntry: MenuEntry) {
        if (menuEntryMap[player] == null) {
            menuEntryMap[player] = arrayListOf(menuEntry)
        }

        val arrayList = menuEntryMap[player]!!
        arrayList.add(menuEntry)

        menuEntryMap[player] = arrayList
    }

}