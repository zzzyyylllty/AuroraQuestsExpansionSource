package io.github.zzzyyylllty.auroraquestsexpansion


import io.github.zzzyyylllty.auroraquestsexpansion.AuroraQuests.task.sendConsoleMessages
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import java.util.logging.Level


class AuroraQuestsExpansion : JavaPlugin() {

    companion object GlobalVars {
        lateinit var plugin : AuroraQuestsExpansion
        var instance: AuroraQuestsExpansion? = null
            private set
    }


    fun log(level: Level?, message: String?) {
        Bukkit.getLogger().log(level, message)
    }


    override fun onDisable() {
        sendConsoleMessages("<gradient:aqua:green:white>AuroraQuestsExpansion Disabled.")
    }


    override fun onEnable() {

        sendConsoleMessages("<green>AuroraQuestsExpansion NOW STARTING...")
        sendConsoleMessages("<gradient:aqua:green:white>POWERED BY AKACANDYKANGEL,LIMINAL SKYLINE TEAM")

        if (Bukkit.getPluginManager().getPlugin("AuroraQuests") == null) {
            sendConsoleMessages("<gradient:dark_purple:red:yellow>COUNDN'T FOUND AURORAQUESTS. DISABLING... | 未找到AuroraQuests,正在禁用.")
            plugin.onDisable()
            return
        }

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            sendConsoleMessages("<gradient:aqua:green:white>Hooking to PAPI... | 挂钩到 PAPI")
            try {
                PapiRegisterAuroraQuests().register()
            } catch (e: Exception) {
                sendConsoleMessages("<gradient:dark_purple:red:yellow>ERROR HAS ATTEMPTING TO ENABLING PLUGIN - HOOKING TO PAPI FAILED! | 挂钩到占位符时出现意外错误")
                sendConsoleMessages("<yellow>EXCEPTION: $e")
            }
        }
        sendConsoleMessages("<gradient:aqua:green:white>Registering commands... | 正在注册命令")
        try {
            getCommand("auroraquestsexpansion")!!.setExecutor(AuroraQuestsCommand())
        } catch (e : Exception) {
            sendConsoleMessages("<gradient:dark_purple:red:yellow>ERROR HAS ATTEMPTING TO ENABLING PLUGIN - REGISTERING COMMANDS FAILED! | 注册命令时出现意外错误")
            sendConsoleMessages("<yellow>EXCEPTION: $e")
        }
    }
}
