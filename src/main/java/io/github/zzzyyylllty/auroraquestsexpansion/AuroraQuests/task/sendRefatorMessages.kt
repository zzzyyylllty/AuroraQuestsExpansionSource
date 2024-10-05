package io.github.zzzyyylllty.auroraquestsexpansion.AuroraQuests.task

import me.clip.placeholderapi.PlaceholderAPI
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.MiniMessage
import org.bukkit.command.CommandSender
import org.bukkit.command.ConsoleCommandSender
import org.bukkit.entity.Player


fun sendRefatorMessages(message:String, player: Player) {

    val mm = MiniMessage.miniMessage()
    val placeholderadded = PlaceholderAPI.setPlaceholders(player, message)
    player
    val refatored: Component = mm.deserialize(placeholderadded)
    player.sendMessage(refatored)
}


fun sendRefatorMessages(message:String, sendto: ConsoleCommandSender) {
    val mm = MiniMessage.miniMessage()
    val placeholderadded = PlaceholderAPI.setPlaceholders(null, message)
    val refatored: Component = mm.deserialize(placeholderadded)
    sendto.sendMessage(refatored)
}

fun sendRefatorMessages(message:String, sendto: CommandSender) {

    val mm = MiniMessage.miniMessage()
    val placeholderadded = PlaceholderAPI.setPlaceholders(null, message)
    val refatored: Component = mm.deserialize(placeholderadded)
    sendto.sendMessage(refatored)

}


