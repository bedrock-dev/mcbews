# Minecraft BE WebSocket API

## 说明
Minecraft BE版有一个`/connect`指令用来链接`WebSocket`服务器（以下简称服务器），可以让游戏和服务器进行交互，这里的服务器要区别于多人游戏用的[联机服务器]().游戏和服务器进行交互的方式是`json`.通过这种方式能做出一些有意思的东西出来,包括但不限于：

- 类似Worldedit的快速建造插件
- 多人游戏服务器数据统计,包括死亡次数，运动路径，杀死的怪物数量等等等。

### WebSocket 服务端

为了方便开发，这里提供了一个用`java`写的 WebSokcet API,当然还有很多不足(demo 水平)，后面会慢慢维护。教程也会继续更新。
其实这个api是有现成的[PEWS-API](https://github.com/jocopa3/PEWS-API),但是这个太旧了，导致发送命令无法响应，于是参考这个重写了一个。


### 参考链接

[WebSocket](https://minecraft-zh.gamepedia.com/%E6%95%99%E7%A8%8B/WebSocket](https://minecraft-zh.gamepedia.com/教程/WebSocket)

[PEWS-API](https://github.com/jocopa3/PEWS-API)
