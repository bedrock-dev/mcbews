## WebSocket  All Event

所有订阅事件的测试结果:

- ？ 表示测试了但是无效
- Y 表示工作正常
-  空白表示跳过

| 事件名称                          |                      翻译                       | 测试结果 |
| --------------------------------- | :---------------------------------------------: | -------- |
| AdditionalContentLoaded           |                                                 |          |
| AgentCommand                      |                                                 |          |
| AgentCreated                      |                    创建agent                    |          |
| ApiInit                           |                    api初始化                    |          |
| AppPaused                         |                    游戏暂停                     | ?        |
| AppResumed                        |                  游戏恢复运行                   | ?        |
| AppSuspended                      |                    游戏暂停                     | ?        |
| AwardAchievement                  |                    成就达成                     |          |
| BlockBroken                       |             在玩家破坏方块时触发 Y              | Y        |
| BlockPlaced                       |             在玩家放置方块时触发 Y              | Y        |
| BoardTextUpdated                  |                  黑板文字更新                   | ?        |
| BossKilled                        |              杀掉boss（指令无效）               | Y        |
| CameraUsed                        |                    使用相机                     |          |
| CauldronUsed                      |             任何和炼药锅交互的操作              | Y        |
| ChunkChanged                      |                    区块改变                     | ?        |
| ChunkLoaded                       |                    区块加载                     | ?        |
| ChunkUnloaded                     |                    区块卸载                     | ?        |
| ConfigurationChanged              |                    改变设置                     | ?        |
| ConnectionFailed                  |                    连接失败                     |          |
| CraftingSessionCompleted          |           关闭工作台界面或者背包界面            | Y        |
| EndOfDay                          |                    一天过完                     | ?        |
| EntitySpawned                     |                通过指令生成实体                 | Y        |
| FileTransmissionCancelled         |                  文件传输取消                   |          |
| FileTransmissionCompleted         |                  文件传输完成                   |          |
| FileTransmissionStarted           |                  文件传输开始                   |          |
| FirstTimeClientOpen               |                第一次打开客户端                 | ?        |
| FocusGained                       |                    获取焦点                     | ？       |
| FocusLost                         |                    焦点丢失                     | ？       |
| GameSessionComplete               |                    离开存档                     | ?        |
| GameSessionStart                  |            进入存档(世界加载的时候)             | Y        |
| HardwareInfo                      |                    硬件信息                     | ？       |
| HasNewContent                     |                    有新内容                     | ？       |
| ItemAcquired                      |            捡起掉落物,拿起合成的物品            | Y        |
| ItemCrafted                       |            物品从合成台拿出的那一刻             | Y        |
| ItemDestroyed                     |                    摧毁物品                     | ?        |
| ItemDropped                       |                    扔出物品                     | Y        |
| ItemEnchanted                     |                    物品附魔                     | ？       |
| ItemSmelted                       |                 取出熔炉内物品                  | Y        |
| ItemUsed                          | 使用物品(吃东西,放置方块，扔鸡蛋，使用弓箭等等) | Y        |
| JoinCanceled                      |                    取消加入                     |          |
| JukeboxUsed                       |               CD放入音符盒的时候                | Y        |
| LicenseCensus                     |                                                 |          |
| MascotCreated                     |                                                 |          |
| MenuShown                         |                                                 |          |
| MobInteracted                     |                    怪物？？                     | ?        |
| MobKilled                         |                 怪物被玩家杀死                  | Y        |
| MultiplayerConnectionStateChanged |                                                 |          |
| MultiplayerRoundEnd               |                                                 |          |
| MultiplayerRoundStart             |                                                 |          |
| NpcPropertiesUpdated              |                   npc信息更新                   | ？       |
| OptionsUpdated                    |                                                 |          |
| performanceMetrics                |                                                 |          |
| PackImportStage                   |                                                 |          |
| PlayerBounced                     |              玩家被床和粘液块弹起               | Y        |
| PlayerDied                        |                    玩家死亡                     | Y        |
| PlayerJoin                        |                    玩家加入                     | ？       |
| PlayerLeave                       |                    玩家离开                     | ?        |
| PlayerMessage                     |            在玩家发出一条消息时触发             | Y        |
| PlayerTeleported                  |               玩家怕被tp指令传送                | Y        |
| PlayerTransform                   |                    玩家移动                     | Y        |
| PlayerTravelled                   |       玩家移动（和上面那个几乎同时触发）        | Y        |
| PortalBuilt                       |           玩家创建传送门(下界和末地)            | Y        |
| PortalUsed                        |         玩家进入传送门方块(包括祭坛的)          | U        |
| PortfolioExported                 |                                                 |          |
| PotionBrewed                      |             从酿造台拿出药水的时候              | Y        |
| PurchaseAttempt                   |                                                 |          |
| PurchaseResolved                  |                                                 |          |
| RegionalPopup                     |                                                 |          |
| RespondedToAcceptContent          |                                                 |          |
| ScreenChanged                     |    打开任何UI都出发，点击任何设置页面也出发     | Y        |
| ScreenHeartbeat                   |                                                 |          |
| SignInToEdu                       |                                                 |          |
| SignInToXboxLive                  |                                                 |          |
| SignOutOfXboxLive                 |                                                 |          |
| SpecialMobBuilt                   |                  特殊怪物生成                   | ?        |
| StartClient                       |                                                 |          |
| StartWorld                        |                                                 |          |
| TextToSpeechToggled               |               文本转语音选项改变                |          |
| UgcDownloadCompleted              |                                                 |          |
| UgcDownloadStarted                |                                                 |          |
| UploadSkin                        |                    上传皮肤                     |          |
| VehicleExited                     |                    离开矿车                     | Y        |
| WorldExported                     |                                                 | ?        |
| WorldFilesListed                  |                                                 | ？       |
| WorldGenerated                    |                    世界生成                     | ？       |
| WorldLoaded                       |                    世界加载                     | ？       |
| WorldUnloaded                     |                    世界卸载                     | ？       |