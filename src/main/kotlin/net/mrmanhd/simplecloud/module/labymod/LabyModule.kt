package net.mrmanhd.simplecloud.module.labymod

import net.mrmanhd.simplecloud.module.labymod.config.ConfigLoader

/**
 * Created by MrManHD
 * Class create at 03.05.2021 21:42
 */

class LabyModule {

    val configLoader = ConfigLoader()

    init {
        instance = this
    }

    companion object {
        lateinit var instance: LabyModule
    }

}