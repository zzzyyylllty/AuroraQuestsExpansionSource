package io.github.zzzyyylllty.auroraquestsexpansion.rewards
import gg.auroramc.aurora.api.message.Placeholder
import gg.auroramc.aurora.api.reward.NumberReward
import io.github.zzzyyylllty.auroraquestsexpansion.AuroraQuestsExpansion.GlobalVars.plugin
import org.bukkit.configuration.ConfigurationSection
import org.bukkit.entity.Player
import su.nightexpress.coinsengine.api.CoinsEngineAPI
import java.util.logging.Level


class CoinsEngineReward : NumberReward() {
    private var currency: String? = null
    private var amount: String? = null

    override fun execute(player: Player, level: Long, placeholders: List<Placeholder<*>?>?) {

        val currency1 = currency
        val amount1 = amount

        if (currency1 == null || amount1 == null) run {
            plugin.log(Level.WARNING, "Amount or Currency may not be null.")
            return
        }

        val currencyInst = CoinsEngineAPI.getCurrency(currency1) ?: run {
            plugin.log(Level.WARNING, "Currency $currency not exist.")
            return
        }

    CoinsEngineAPI.addBalance(player, currencyInst, amount1.toDouble())
    }

    override fun init(args: ConfigurationSection) {
        super.init(args)
        currency = args.getString("currency", null) // 获取配置文件项
        amount = args.getString("amount", null)?.toDouble() ?: run {
            plugin.log(Level.WARNING, "Amount may not be null.")
            return
        }

    }
}