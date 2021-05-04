package net.mrmanhd.simplecloud.module.labymod.module

import eu.thesimplecloud.api.external.ICloudModule
import net.mrmanhd.simplecloud.module.labymod.LabyModule

/**
 * Created by MrManHD
 * Class create at 03.05.2021 21:42
 */

class CloudModule : ICloudModule {

    override fun isReloadable(): Boolean = true

    override fun onEnable() {
        val labyModule = LabyModule()
        labyModule.configLoader.loadConfig()

    }

    override fun onDisable() {

    }

}