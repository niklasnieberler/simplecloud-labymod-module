package net.mrmanhd.simplecloud.module.labymod.config

import eu.thesimplecloud.api.CloudAPI
import eu.thesimplecloud.jsonlib.JsonLib
import java.io.File

/**
 * Created by MrManHD
 * Class create at 03.05.2021 21:59
 */

class ConfigLoader {

    private val configFile = File("modules/labymodule", "config.json")
    private lateinit var config: Config

    fun loadConfig() {
        if (!configFile.exists()) {
            val config = DefaultConfig.get()
            saveConfig(config)
            this.config = config
        }

        val config = JsonLib.fromJsonFile(configFile)!!.getObject(Config::class.java)
        this.config = config

        CloudAPI.instance.getGlobalPropertyHolder().setProperty("laby-config", config)
    }

    private fun saveConfig(config: Config) {
        JsonLib.fromObject(config).saveAsFile(configFile)
    }

    fun getConfig(): Config {
        val property = CloudAPI.instance.getGlobalPropertyHolder().requestProperty<Config>("laby-config").getBlocking()
        return property.getValue()
    }

}