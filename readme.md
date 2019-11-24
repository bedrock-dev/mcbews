# Minecraft BE WebSocket API

## 说明
Minecraft BE版有一个`/connect`指令用来链接`WebSocket`服务器（以下简称服务器），可以让游戏和服务器进行交互，这里的服务器要区别于多人游戏用的[联机服务器]().游戏和服务器进行交互的方式是`json`.通过这种方式能做出一些有意思的东西出来,包括但不限于：

- 类似Worldedit的快速建造插件
- 多人游戏服务器数据统计,包括死亡次数，运动路径，杀死的怪物数量等等等。

下面是一些数据交互的详细信息。

##  数据交互格式

服务器向游戏发送的数据有两种，分别是指令和订阅信息

### 指令数据

第一种是指令，也就是说服务器向游戏发送的`json`数据中包含的指令信息将会被游戏执行,这个数据包的具体格式如下：

```json
{
    "body": {
        "origin": {
            "type": "player"
        },
        "commandLine": "say Hello",
        "version": 1
    },
    "header": {
        "requestId": "00000000-0000-0000-0000-000000000000", 
        "messagePurpose": "commandRequest", 
        "version": 1, 
        "messageType": "commandRequest"
    }
}
```

游戏执行指令后会发送给服务器一些反馈信息，这些信息也是`json`数据:

```json
{
    "body": {
        "statusCode": 0,
        "其他信息":{
    	
        }
    }
    },
    "header": {
        "messagePurpose": "commandResponse", 
        "requestId": "xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx",
        "version": 1
    }
}
```



### 订阅事件

所谓的订阅事件可以理解为，服务器向游戏发送一个指定的事件名称（该过程也叫订阅），当游戏内部发生某件事的时候，游戏就发该事情的相关信息发送给服务器。当然已经订阅的事件也可以取消订阅，订阅事件的数据包格式如下：

```json
{
	"body": {
		"eventName": "PlayerMessage"
	},
	"header": {
		"requestId": "00000000-0000-0000-0000-000000000000",
		"messagePurpose": "subscribe", 
		"version": 1,
		"messageType": "commandRequest"
	}
}
```

如果要取消订阅：

```json

{
    "body": {
        "eventName": "NameOfEvent"
    },
    "header": {
        "requestId": "xxxxxxxx-xxxx-xxxx-xxxxxxxxxxxxxxxxx",
        "messagePurpose": "unsubscribe", 
        "version": 1,
        "messageType": "commandRequest"
    }
}
```

当游戏内发生了订阅的事件的时候，游戏会把相关数据发送给服务器,该数据的格式如下：

```json
{
	"body": {
        "eventName": 事件名称,
        "measurements":{
        "Count": 1,
      	"RecordCnt": 1,
      	"SeqMax": 1714,
      	"SeqMin": 1714
            
        },
        "properties": {
   
        }
    },
	"header": {
        "meesagePurpose": "event",
        "requestId": "xxx","version":1
    }
}
```

有效信息全部放在`properties`里面，为了知道这里面的数据格式，笔者对所有的订阅事件做了测试，也记录了所有详细的`properties`信息。所有的相关信息你可以在本项目的json目录里面找到。

### WebSocket 服务端

为了方便开发，这里提供了一个用`java`写的 WebSokcet API,当然还有很多不足(demo 水平)，后面会慢慢维护。教程也会继续更新。
其实这个api是有现成的[PEWS-API](https://github.com/jocopa3/PEWS-API),但是这个太旧了，导致发送命令无法响应，于是参考这个重写了一个。


### 参考链接

[WebSocket](https://minecraft-zh.gamepedia.com/%E6%95%99%E7%A8%8B/WebSocket](https://minecraft-zh.gamepedia.com/教程/WebSocket)

[PEWS-API](https://github.com/jocopa3/PEWS-API)
