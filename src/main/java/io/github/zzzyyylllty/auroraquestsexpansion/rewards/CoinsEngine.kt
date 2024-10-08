
import gg.auroramc.aurora.api.message.Placeholder
import gg.auroramc.aurora.api.reward.NumberReward
import org.bukkit.Bukkit
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
            Bukkit.getLogger().log(Level.WARNING, "Amount or Currency may not be null.")
            return
        }

        val currencyInst = CoinsEngineAPI.getCurrency(currency1) ?: run {
            Bukkit.getLogger().log(Level.WARNING, "Currency $currency not exist.")
            return
        }

    CoinsEngineAPI.addBalance(player, currencyInst, amount1.toDouble())
    }

    override fun init(args: ConfigurationSection) {
        super.init(args)
        currency = args.getString("currency", null) // 获取配置文件项
        amount = args.getString("amount", null)?.toDouble() ?: run {
            Bukkit.getLogger().log(Level.WARNING, "Amount may not be null.")
            return
        }

    }
}