package net.mrmanhd.simplecloud.module.labymod.handler

import com.google.gson.JsonArray
import eu.thesimplecloud.api.player.ICloudPlayer
import net.labymod.serverapi.api.LabyAPI
import net.labymod.serverapi.api.serverinteraction.actionmenu.ActionType
import net.mrmanhd.simplecloud.module.labymod.config.Config
import net.mrmanhd.simplecloud.module.labymod.config.configuration.actionmenu.ActionMenu
import net.mrmanhd.simplecloud.module.labymod.config.configuration.actionmenu.ActionMenuConfiguration
import org.bukkit.entity.Player

/**
 * Created by MrManHD
 * Class create at 04.05.2021 17:04
 */

class ActionMenuHandler {

    fun handleActionMenu(config: Config, cloudPlayer: ICloudPlayer, player: Player) {
        val entries = JsonArray()

        getActionMenuList(config, cloudPlayer)
            .filter { !(it.permission != "ALL_PLAYERS" && !player.hasPermission(it.permission)) }
            .forEach {

            val menuEntry = LabyAPI.getService().menuEntryFactory.create(it.displayName, it.value, ActionType.valueOf(it.type))
            entries.add(menuEntry.asJsonObject())

        }

        sendActionMenu(player, entries)

    }

    private fun getActionMenuList(config: Config, cloudPlayer: ICloudPlayer): List<ActionMenu> {
        return config.actionMenuConfiguration.actionMenuList
            .filter { !(it.serverGroup != "ALL_SERVERS" && it.serverGroup != cloudPlayer.getConnectedServer()!!.getGroupName()) }
    }

    private fun sendActionMenu(player: Player, entries: JsonArray) {
        val payloadCommunicator = LabyAPI.getService().payloadCommunicator
        payloadCommunicator.sendLabyModMessage(player.uniqueId, "user_menu_actions", entries)
    }

}