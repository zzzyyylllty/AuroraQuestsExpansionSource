# auroraquestsexpansion  
This is an **UnOfficial** Expansion of [AURORAQUESTS](https://modrinth.com/plugin/auroraquests).
It added some **Placeholders and Manage Commands**.


Tested on Leaf (Paper) 1.20.1

As this is a very small plugin, it should run well on other versions. If there are any incompatible situations, please contact me.

**Possible Placeholders:**


- `%aqakt_difficulty_QUESTPOOL_QUESTNAME%`: Return quest difficulty, Such as `Easy`
- `%aqakt_queststat_QUESTPOOL_QUESTNAME%`: Return quest state, Possible return: `Completed`,`Unlocked`,`Locked`
- `%aqakt_cancomplete_QUESTPOOL_QUESTNAME%`:  Return can the task be completed, Return `true` or `false`
- `%aqakt_canstart_QUESTPOOL_QUESTNAME%`: Return can the task be started, Return `true` or `false`
- `%aqakt_hasstartrequirements_QUESTPOOL_QUESTNAME%`: Return the player has start requirements, Return `true` or `false`
- `%aqakt_configname_QUESTPOOL_QUESTNAME%`: Return quest name section in config
- `%aqakt_configid_QUESTPOOL_QUESTNAME%`: Return quest config file name,such as 'example'(file is example.yml)

**Placeholder Show:**
![Papi Show](https://cdn.modrinth.com/data/cached_images/84b2a0120c53e2eb1069d8f01424f5f1cc9a2e79.png)

**Command Usage:**

/auroraquestsexpansion [QuestPool] [Quest] [Action] [Optional:Player]

Actions: `TRYSTART`,`FORCESTART`,`TAKEITEMS`,`COMPLETE`

**_Why no lock action: I could not find this in AuroraQuests API._**

**Caution: Do NOT ask support about this plugin to offical AuroraQuests Team.**

**If you have any suggestion or bug reports,contact me at Discord.**
