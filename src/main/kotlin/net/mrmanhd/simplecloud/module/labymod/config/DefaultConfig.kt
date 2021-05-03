package net.mrmanhd.simplecloud.module.labymod.config

/**
 * Created by MrManHD
 * Class create at 03.05.2021 21:58
 */

class DefaultConfig {

    companion object {

        fun get(): Config {
            return Config(
                listOf(
                    PlayingOnConfiguration("BW-2x1", null, "BedWars 2x1"),
                    PlayingOnConfiguration("BW-2x2", "cloud.laby.bedwars", "BedWars 2x2")
                )
            )
        }

    }

}