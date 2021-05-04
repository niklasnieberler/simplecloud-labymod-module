package net.mrmanhd.simplecloud.module.labymod.config.configuration

import net.labymod.serverapi.api.serverinteraction.actionmenu.ActionType

/**
 * Created by MrManHD
 * Class create at 04.05.2021 16:57
 */

class ActionMenuConfiguration(
    val displayName: String,
    val serverGroup: String?,
    val permission: String?,
    val type: String,
    val value: String
)