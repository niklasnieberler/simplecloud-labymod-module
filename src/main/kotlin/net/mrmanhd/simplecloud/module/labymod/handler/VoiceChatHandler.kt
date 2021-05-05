package net.mrmanhd.simplecloud.module.labymod.handler

import com.google.gson.JsonObject
import eu.thesimplecloud.api.player.ICloudPlayer
import net.labymod.serverapi.api.LabyAPI
import net.mrmanhd.simplecloud.module.labymod.config.Config
import net.mrmanhd.simplecloud.module.labymod.config.configuration.subtitle.Subtitle
import net.mrmanhd.simplecloud.module.labymod.config.configuration.voicechat.VoiceChat
import org.bukkit.entity.Player

/**
 * Created by MrManHD
 * Class create at 05.05.2021 10:37
 */

class VoiceChatHandler {

    fun handleVoiceChat(config: Config, cloudPlayer: ICloudPlayer, player: Player) {

        getMainVoiceChat(config)?.let {
            handlePlayerPermission(it, player)
            return
        }

        getVoiceChat(config, cloudPlayer)?.let {
            handlePlayerPermission(it, player)
        }

    }

    private fun handlePlayerPermission(voiceChat: VoiceChat, player: Player) {
        if (voiceChat.permission != "ALL_PLAYERS" && !player.hasPermission(voiceChat.permission)) {
            return
        }

        val jsonObject = JsonObject()
        jsonObject.addProperty("allowed", !voiceChat.disableVoiceChat)

        val payloadCommunicator = LabyAPI.getService().payloadCommunicator
        payloadCommunicator.sendLabyModMessage(player.uniqueId, "voicechat", jsonObject)
    }

    private fun getVoiceChat(config: Config, cloudPlayer: ICloudPlayer): VoiceChat? {
        return config.voiceChatConfiguration.voiceChatList
            .firstOrNull { it.serverGroup == cloudPlayer.getConnectedServer()!!.getGroupName() }
    }

    private fun getMainVoiceChat(config: Config): VoiceChat? {
        return config.voiceChatConfiguration.voiceChatList.firstOrNull { it.serverGroup == "ALL_SERVERS" }
    }

}