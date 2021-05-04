package net.mrmanhd.simplecloud.module.labymod.cloud.commands

import eu.thesimplecloud.api.command.ICommandSender
import eu.thesimplecloud.launcher.console.command.CommandType
import eu.thesimplecloud.launcher.console.command.ICommandHandler
import eu.thesimplecloud.launcher.console.command.annotations.Command
import eu.thesimplecloud.launcher.console.command.annotations.CommandSubPath
import net.mrmanhd.simplecloud.module.labymod.LabyModule

/**
 * Created by MrManHD
 * Class create at 04.05.2021 16:24
 */

@Command("labymodule", CommandType.CONSOLE_AND_INGAME, "cloud.module.laby")
class ReloadCommand : ICommandHandler {

    @CommandSubPath("reload", "Reloads the labymod module")
    fun handleReload(sender: ICommandSender) {
        LabyModule.instance.configLoader.loadConfig()
        sender.sendProperty("labymodule.command.reload")
    }

}