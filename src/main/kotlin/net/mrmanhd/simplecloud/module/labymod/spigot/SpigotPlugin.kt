package net.mrmanhd.simplecloud.module.labymod.spigot

import net.mrmanhd.simplecloud.module.labymod.LabyModule
import net.mrmanhd.simplecloud.module.labymod.spigot.listener.BukkitLabyModPlayerLoginListener
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

/**
 * Created by MrManHD
 * Class create at 03.05.2021 22:09
 */

class SpigotPlugin : JavaPlugin() {

    override fun onEnable() {
        LabyModule(this)
        registerEvents()

    }

    override fun onDisable() {

    }

    private fun registerEvents() {
        val pluginManager = Bukkit.getPluginManager()
        pluginManager.registerEvents(BukkitLabyModPlayerLoginListener(), this)
    }

}