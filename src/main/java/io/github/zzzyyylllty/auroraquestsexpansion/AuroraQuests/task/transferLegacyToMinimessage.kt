package io.github.zzzyyylllty.auroraquestsexpansion.AuroraQuests.task

fun transferLegacyToMinimessage(input: String) : String {



    var i = input
    i = i.replace("§","&")
    i = i.replace("&x&(.)&(.)&(.)&(.)&(.)&(.)".toRegex(),"<#$1$2$3$4$5$6>")
    i = i.replace("&a","<reset><green>", ignoreCase = true)
    i = i.replace("&b","<reset><aqua>", ignoreCase = true)
    i = i.replace("&c","<reset><red>", ignoreCase = true)
    i = i.replace("&d","<reset><light_purple>", ignoreCase = true)
    i = i.replace("&e","<reset><yellow>", ignoreCase = true)
    i = i.replace("&f","<reset><white>", ignoreCase = true)
    i = i.replace("&1","<reset><dark_blue>", ignoreCase = true)
    i = i.replace("&2","<reset><dark_green>", ignoreCase = true)
    i = i.replace("&3","<reset><dark_aqua>", ignoreCase = true)
    i = i.replace("&4","<reset><dark_red>", ignoreCase = true)
    i = i.replace("&5","<reset><dark_purple>", ignoreCase = true)
    i = i.replace("&6","<reset><gold>", ignoreCase = true)
    i = i.replace("&7","<reset><gray>", ignoreCase = true)
    i = i.replace("&8","<reset><dark_gray>", ignoreCase = true)
    i = i.replace("&9","<reset><blue>", ignoreCase = true)
    i = i.replace("&0","<reset><black>", ignoreCase = true)

    i = i.replace("&l","<b>", ignoreCase = true)
    i = i.replace("&o","<i>", ignoreCase = true)
    i = i.replace("&n","<u>", ignoreCase = true)
    i = i.replace("&m","<st>", ignoreCase = true)
    i = i.replace("&k","<obf>", ignoreCase = true)
    i = i.replace("&r","<reset>", ignoreCase = true)

    return i
}
