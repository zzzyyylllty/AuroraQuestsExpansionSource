package io.github.zzzyyylllty.auroraquestsexpansion.AuroraQuests.task

import me.clip.placeholderapi.PlaceholderAPI
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.MiniMessage
import org.bukkit.Bukkit


fun sendConsoleMessages(message:String) {

    val mm = MiniMessage.miniMessage()
    val placeholderadded = PlaceholderAPI.setPlaceholders(null, message)
    val refatored: Component = mm.deserialize(transferLegacyToMinimessage(placeholderadded))
    Bukkit.getConsoleSender().sendMessage(refatored)
}
