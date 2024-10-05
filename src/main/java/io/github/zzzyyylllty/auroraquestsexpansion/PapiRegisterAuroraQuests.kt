package io.github.zzzyyylllty.auroraquestsexpansion

import gg.auroramc.quests.api.AuroraQuestsProvider
import gg.auroramc.quests.api.quest.Quest
import gg.auroramc.quests.api.quest.QuestManager
import gg.auroramc.quests.api.quest.QuestPool
import me.clip.placeholderapi.expansion.PlaceholderExpansion
import org.bukkit.OfflinePlayer
import org.bukkit.entity.Player


class PapiRegisterAuroraQuests : PlaceholderExpansion() {
    override fun getAuthor(): String {
        return "zzzyyylll_ty"
    }

    override fun getIdentifier(): String {
        return "aqakt"
    }

    override fun getVersion(): String {
        return "1.0.0"
    }

    override fun persist(): Boolean {
        return true // This is required or else PlaceholderAPI will unregister the Expansion on reload
    }

    override fun onRequest(player: OfflinePlayer, params: String): String {

        val mainparam = params.split("_")[0]
        val manager : QuestManager = AuroraQuestsProvider.getQuestManager()
        var secondaryParam: String? = null
        var thirdParam: String? = null
        val onlinePlayer: Player? = player.player

        if (params.split("_").size >= 3) {
            secondaryParam = params.split("_")[1]
            thirdParam = params.split("_")[2]
        }

        val pool : QuestPool = manager.getQuestPool(secondaryParam) ?: return "POOL NOT EXIST: $secondaryParam"
        val quest : Quest = pool.getQuest(thirdParam) ?: return "QUEST NOT EXIST: $thirdParam"

        if (mainparam.equals("queststat", ignoreCase = true)) {
            if (quest.isCompleted(player.player)) return "Completed"
            if (quest.isUnlocked(player.player)) return "Unlocked"
            return "Locked"
        } else if (mainparam.equals("difficulty", ignoreCase = true)) {
            return quest.difficulty
        } else if (mainparam.equals("cancomplete", ignoreCase = true)) {
            return quest.canComplete(onlinePlayer).toString()
        } else if (mainparam.equals("canstart", ignoreCase = true)) {
            return quest.canStart(onlinePlayer).toString()
        } else if (mainparam.equals("hasstartrequirements", ignoreCase = true)) {
            return quest.hasStartRequirements().toString()
        } else if (mainparam.equals("configname", ignoreCase = true)) {
            return quest.config.name
        } else if (mainparam.equals("configid", ignoreCase = true)) {
            return quest.config.id
        }
        return "ERROR" // Placeholder is unknown by the Expansion
    }
}