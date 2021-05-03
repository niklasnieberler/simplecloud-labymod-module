package net.mrmanhd.simplecloud.module.labymod

import eu.thesimplecloud.api.external.ICloudModule
import net.mrmanhd.simplecloud.module.labymod.config.ConfigLoader

/**
 * Created by MrManHD
 * Class create at 03.05.2021 21:42
 */

class LabyModule(
    val cloudModule: ICloudModule
) {

    val configLoader = ConfigLoader()

    init {
        instance = this
    }

    companion object {
        lateinit var instance: LabyModule
    }

}