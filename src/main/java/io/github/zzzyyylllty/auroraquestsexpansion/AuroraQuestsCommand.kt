package io.github.zzzyyylllty.auroraquestsexpansion

import gg.auroramc.quests.api.AuroraQuestsProvider
import gg.auroramc.quests.api.quest.QuestManager
import io.github.zzzyyylllty.auroraquestsexpansion.AuroraQuests.task.sendRefatorMessages
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.TabExecutor


class AuroraQuestsCommand : TabExecutor {

    private val manager : QuestManager = AuroraQuestsProvider.getQuestManager()

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {

        if (args == null || args.size < 2) return false

        val pool = manager.getQuestPool(args[0]) ?: run {
            sendRefatorMessages("<gradient:red:dark_red>执行失败: 未找到任务池 ${args[0]}",sender)
            return false
        }
        val quest = pool.getQuest(args[1]) ?: run {
            sendRefatorMessages("<gradient:red:dark_red>执行失败: 未找到任务 ${args[0]} - ${args[1]}",sender)
            return false
        }

        val player = Bukkit.getPlayer(if (args.size >= 4) args[3] else sender.name) ?: run {
            sendRefatorMessages("<gradient:red:dark_red>执行失败: 未找到玩家 ${Bukkit.getPlayer(if (args.size >= 4) args[3] else sender.name)}",sender)
            return false
        }

        if (args[1] == "#MODIFY_POOL") {
            when (args[2]) {
                "COMPLETE" -> quest.complete(player)
                "TRYSTART" -> quest.tryStart(player)
                "FORCESTART" -> quest.forceStart(player)
            }
        } else {
            when (args[2]) {
                "COMPLETE" -> quest.complete(player)
                "TRYSTART" -> quest.tryStart(player)
                "FORCESTART" -> quest.forceStart(player)
                "TAKEITEMS" -> quest.tryTakeItems(player)
            }
        }


        return false
    }

    override fun onTabComplete(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>?
    ): MutableList<String>? {
        if (args == null) return null
        val tabLists = listOf<String>().toMutableList()
        when (args.size) {
            1 -> {
                tabLists.addAll(manager.questPools.map { it.id })
            }
            2 -> {
                tabLists.addAll(manager.getQuestPool(args[0]).quests.map { it.id })
                // TtabLists.add("#MODIFY_POOL")
            }
            3 -> {
                tabLists.add("TRYSTART")
                tabLists.add("FORCESTART")
                tabLists.add("COMPLETE")
                tabLists.add("TAKEITEMS")
            }
            4 -> {
                tabLists.addAll(Bukkit.getOnlinePlayers().map { it.name })
            }
        }

        return tabLists
    }
}