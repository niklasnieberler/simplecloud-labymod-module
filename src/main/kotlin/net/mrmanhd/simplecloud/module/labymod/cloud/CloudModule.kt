package net.mrmanhd.simplecloud.module.labymod.cloud

import eu.thesimplecloud.api.external.ICloudModule
import eu.thesimplecloud.launcher.startup.Launcher
import net.mrmanhd.simplecloud.module.labymod.LabyModule
import net.mrmanhd.simplecloud.module.labymod.cloud.commands.ReloadCommand

/**
 * Created by MrManHD
 * Class create at 03.05.2021 21:42
 */

class CloudModule : ICloudModule {

    override fun isReloadable(): Boolean = true

    override fun onEnable() {
        val labyModule = LabyModule()
        labyModule.configLoader.loadConfig()

        registerCommands()

    }

    override fun onDisable() {

    }

    private fun registerCommands() {
        val commandManager = Launcher.instance.commandManager
        commandManager.registerCommand(this, ReloadCommand())
    }

}