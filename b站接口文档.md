## 获取各大分区详细列表：

## 全分区接口：

https://api.live.bilibili.com/room/v1/Area/getList


| 大分区 | 小分区 | 链接                                                         |
| :----- | ------ | ------------------------------------------------------------ |
| 娱乐   |        | https://api.live.bilibili.com/room/v1/area/getList?parent_id=1 |
| 网游   |        | http://api.live.bilibili.com/room/v1/area/getList?parent_id=2 |
| 手游   |        | http://api.live.bilibili.com/room/v1/area/getList?parent_id=3 |
| 绘画   |        | http://api.live.bilibili.com/room/v1/area/getList?parent_id=4 |
| 唱见   |        | http://api.live.bilibili.com/room/v1/area/getList?parent_id=5 |
| 单机   |        | http://api.live.bilibili.com/room/v1/area/getList?parent_id=6 |

如：

~~~json
{"code":0,"msg":"success","message":"success","data":									
 [
    {"id":"21","parent_id":"1","old_area_id":"10","name":"视频唱见","act_id":"0","pk_status":"1","hot_status":1,"lock_status":"0","pic":"https://i0.hdslb.com/bfs/vc/72b93ddafdf63c9f0b626ad546847a3c03c92b6f.png","is_new":0,"parent_name":"娱乐","area_type":0},
     {"id":"207","parent_id":"1","old_area_id":"10","name":"舞见","act_id":"0","pk_status":"1","hot_status":1,"lock_status":"0","pic":"https://i0.hdslb.com/bfs/vc/5837fa9608fab6c1465ec29c5abecab44f7bc376.png","is_new":0,"parent_name":"娱乐","area_type":0},
     {"id":"145","parent_id":"1","old_area_id":"6","name":"视频聊天","act_id":"0","pk_status":"1","hot_status":1,"lock_status":"0","pic":"https://i0.hdslb.com/bfs/vc/14a8c9c6d0a7685091db270cb523690b9e78b523.png","is_new":0,"parent_name":"娱乐","area_type":0},
     {"id":"143","parent_id":"1","old_area_id":"2","name":"才艺","act_id":"0","pk_status":"1","hot_status":0,"lock_status":"0","pic":"https://i0.hdslb.com/bfs/vc/a7a2cfad137c0db0d61aece9da2f77167466db64.png","is_new":0,"parent_name":"娱乐","area_type":0},
     {"id":"199","parent_id":"1","old_area_id":"6","name":"虚拟主播","act_id":"0","pk_status":"0","hot_status":0,"lock_status":"0","pic":"https://i0.hdslb.com/bfs/vc/7725a45469b776ee91f2d42afca1e5711f84ac51.png","is_new":0,"parent_name":"娱乐","area_type":0},
     {"id":"136","parent_id":"1","old_area_id":"6","name":"美食","act_id":"0","pk_status":"1","hot_status":0,"lock_status":"0","pic":"https://i0.hdslb.com/bfs/vc/a3580fcae212085cb2950b82b590caeaebedda81.png","is_new":0,"parent_name":"娱乐","area_type":0},
     {"id":"123","parent_id":"1","old_area_id":"6","name":"户外","act_id":"0","pk_status":"1","hot_status":0,"lock_status":"0","pic":"https://i0.hdslb.com/bfs/vc/a97daf9b1c6d16900495fab1237d8218667920c1.png","is_new":0,"parent_name":"娱乐","area_type":0},
     {"id":"25","parent_id":"1","old_area_id":"2","name":"手工","act_id":"0","pk_status":"0","hot_status":0,"lock_status":"0","pic":"https://i0.hdslb.com/bfs/vc/56fa9416b41b4aa3620749d16c1b1161c45dc0df.png","is_new":0,"parent_name":"娱乐","area_type":0},
     {"id":"28","parent_id":"1","old_area_id":"6","name":"萌宠","act_id":"0","pk_status":"0","hot_status":0,"lock_status":"0","pic":"https://i0.hdslb.com/bfs/vc/b6814fc82bf62dd915e2b284e890770969c8ccd5.png","is_new":0,"parent_name":"娱乐","area_type":0},
     {"id":"27","parent_id":"1","old_area_id":"6","name":"学习","act_id":"0","pk_status":"0","hot_status":0,"lock_status":"0","pic":"https://i0.hdslb.com/bfs/vc/d5034f128ed95acf447e903c8082c9c5b6bd7271.png","is_new":0,"parent_name":"娱乐","area_type":0},
     {"id":"33","parent_id":"1","old_area_id":"7","name":"映评馆","act_id":"0","pk_status":"0","hot_status":0,"lock_status":"0","pic":"https://i0.hdslb.com/bfs/vc/44b85dd5ead7a02dd5d3396972811cd610793ae6.png","is_new":0,"parent_name":"娱乐","area_type":0},
     {"id":"34","parent_id":"1","old_area_id":"7","name":"音乐台","act_id":"0","pk_status":"0","hot_status":0,"lock_status":"0","pic":"https://i0.hdslb.com/bfs/vc/8537694f4fe68ab0798dd5d493d3ca5deb908088.png","is_new":0,"parent_name":"娱乐","area_type":0}
 ]
}
~~~

parent_id 对应 parentAreaId，areaId 对应列表返回的id字段的值

[https://live.bilibili.com/p/eden/area-tags?parentAreaId=1&areaId=21](https://live.bilibili.com/p/eden/area-tags?parentAreaId=1&areaId=21)

## 所有直播间接口

https://api.live.bilibili.com/room/v1/room/get_user_recommend?page=1

~~~json
}
"code": 0,
"msg": "ok",
"message": "ok",
"data": [
    {
        "area": 0,
        "areaName": "",
        "face": "https://i2.hdslb.com/bfs/face/d8d54fb18afe79e6180997b0aa056cddc351cc9f.jpg",
        "is_bn": 0,
        "is_tv": 0,
        "link": "/21713898",
        "online": 0,
        "roomid": 21713898,
        "short_id": 0,
        "stream_id": 0,
        "system_cover": "https://i0.hdslb.com/bfs/live/21713898.jpg?01201446",
        "title": "该 摇 害 得 摇",
        "uid": 128608055,
        "uname": "淡泊宁静以致远丶",
        "user_cover": "https://i0.hdslb.com/bfs/live/user_cover/015b09c7b5948aac9e9aae39dada6072a21c4202.jpg"
    }
]
}
~~~

全部直播总数接口：

https://api.live.bilibili.com/room/v1/Area/getLiveRoomCountByAreaID?areaId=0

~~~json
{
    "code": 0,
    "msg": "success",
    "message": "success",
    "data": {
        "num": 6642
    }
}
~~~

### 七日榜

https://api.live.bilibili.com/rankdb/v1/RoomRank/webSevenRank?roomid=982077&ruid=16692120

~~~json
// 20200120164831
// https://api.live.bilibili.com/rankdb/v1/RoomRank/webSevenRank?roomid=982077&ruid=16692120

{
    "code": 0,
    "msg": "OK",
    "message": "OK",
    "data": {
        "list": [
            {
                "uid": 103022133,
                "uname": "Med开",
                "face": "https://i0.hdslb.com/bfs/face/05d2487824dc51898764468078630588711b7091.jpg",
                "rank": 1,
                "score": 3243000,
                "guard_level": 2,
                "isSelf": 0
            },
            {
                "uid": 2630634,
                "uname": "佛系の熊熊",
                "face": "https://i0.hdslb.com/bfs/face/2867c686db3a2fc47b8f8502800be806fceffecf.jpg",
                "rank": 2,
                "score": 3002100,
                "guard_level": 2,
                "isSelf": 0
            },
            {
                "uid": 24856782,
                "uname": "runmsway",
                "face": "https://i2.hdslb.com/bfs/face/d592c150ee6cdcd955751f56e5dde0f2b2abbc4f.jpg",
                "rank": 3,
                "score": 2196000,
                "guard_level": 3,
                "isSelf": 0
            }
        ]
    }
}
~~~

#### 参数说明

| 参数  | 说明       |
| ----- | ---------- |
| uid   | 用户id     |
| uname | 用户名     |
| rank  | 排名       |
| score | 金瓜子数量 |
| face  | 用户头像   |



### 舰队

https://api.live.bilibili.com/xlive/app-room/v1/guardTab/topList?roomid=982077&page=2&ruid=16692120&page_size=29

~~~json
// 20200120153049
// https://api.live.bilibili.com/xlive/app-room/v1/guardTab/topList?roomid=982077&page=2&ruid=16692120&page_size=1

{
  "code": 0,
  "data": {
    "info": {
      "num": 49,
      "page": 46,
      "now": 2,
      "achievement_level": 1
    },
    "list": [
      {
        "uid": 4267426,
        "ruid": 16692120,
        "rank": 1,
        "username": "甜味kk",
        "face": "http://i0.hdslb.com/bfs/face/cd58e44deb567c050e8f46ece45af264567046e8.jpg",
        "is_alive": 0,
        "guard_level": 2,
        "guard_sub_level": 0
      }
    ],
    "top3": [
      {
        "uid": 2630634,
        "ruid": 16692120,
        "rank": 1,
        "username": "佛系の熊熊",
        "face": "http://i0.hdslb.com/bfs/face/2867c686db3a2fc47b8f8502800be806fceffecf.jpg",
        "is_alive": 1, 
        "guard_level": 2,
        "guard_sub_level": 0
      },
      {
        "uid": 24144445,
        "ruid": 16692120,
        "rank": 2,
        "username": "佛系の丫吖",
        "face": "http://i0.hdslb.com/bfs/face/950f9eaf7cb102b194836bdb7329b54d7fd5fbeb.jpg",
        "is_alive": 1,
        "guard_level": 2,
        "guard_sub_level": 0
      },
      {
        "uid": 2805924,
        "ruid": 16692120,
        "rank": 3,
        "username": "Stassika",
        "face": "http://i1.hdslb.com/bfs/face/fba307b577b0f5650504ec03781c46a5a4f1ab8c.jpg",
        "is_alive": 0,
        "guard_level": 2,
        "guard_sub_level": 0
      }
    ]
  },
  "message": "",
  "msg": ""
}
~~~

#### 参数说明

| **参数**    | **说明**             |
| ----------- | -------------------- |
| num         | 总舰数               |
| page        | 总页数               |
| now         | 当前页               |
| uid         | 用户id               |
| rank        | 排序                 |
| guard_level | 1.总督 2.提督 3.舰长 |
| is_alive    | 是否在观看           |

### 友爱社

https://api.live.bilibili.com/activity/v1/UnionFans/roomFansRank?roomid=764155&ruid=6905116

~~~json
// 20200120160119
// https://api.live.bilibili.com/activity/v1/UnionFans/roomFansRank?roomid=764155&ruid=6905116

{
  "code": 0,
  "msg": "",
  "message": "",
  "data": [
    {
      "id": 3129,
      "score": 54846,
      "rank": 1,
      "union_name": "纪米の小窝",
      "uid": "348958603",
      "uname": "纪米家的萌萌",
      "face": "https://i1.hdslb.com/bfs/face/a05d7fd66950a0631baecf2c4710f91c085af4b1.jpg",
      "days": 224,
      "fight_status": 0
    },
    {
      "id": 2026,
      "score": 112,
      "rank": 2,
      "union_name": "纪米花",
      "uid": "2768698",
      "uname": "ぃ夏ゞ忆ヾ",
      "face": "https://i2.hdslb.com/bfs/face/67129c88be9b7d1eb36cf07a362c2171a1766858.jpg",
      "days": 547,
      "fight_status": 0
    }
  ]
}
~~~

#### 参数说明

| 参数       | 说明       |
| ---------- | ---------- |
| union_name | 友爱社名称 |
| rank       | 友爱社排名 |
| uid        | 用户id     |
| uname      | 用户名     |
| days       | 应援天数   |
| face       | 用户头像   |

### 粉丝榜

https://api.live.bilibili.com/rankdb/v1/RoomRank/webMedalRank?roomid=9922197&ruid=300702024

~~~json
// 20200120175014
// https://api.live.bilibili.com/rankdb/v1/RoomRank/webMedalRank?roomid=9922197&ruid=300702024

{
  "code": 0,
  "msg": "OK",
  "message": "OK",
  "data": {
   	  "medal": {
      "status": 2
   				 },
      "own": {
      "uid": 301507852,
      "uname": "拜托了_喵大人",
      "face": "https://i0.hdslb.com/bfs/face/1889f5700a625c4c5b5a83e0cdde95bad5e6e31d.jpg",
      "target_id": 0,
      "medal_name": "",
      "level": 0,
      "color": 0,
      "rank": 0,
      "special": "",
      "isMax": 0,
      "guard_level": 0,
      "rank_text": "0"
    },
      "list": [
      {
        "uid": 301331156,
        "uname": "嘻嘻家の撒撒",
        "face": "https://i2.hdslb.com/bfs/face/0c9825901c1215ef8465a66abb050753c5b550dc.jpg",
        "rank": 1,
        "medal_name": "戒不掉",
        "level": 20,
        "color": 16752445,
        "target_id": 300702024,
        "special": "",
        "isSelf": 0,
        "guard_level": 3
      }
    ]
  }
}
~~~

#### 参数说明

| 参数       | 说明                                                         |
| ---------- | ------------------------------------------------------------ |
| uid        | 用户id                                                       |
| uname      | 用户姓名                                                     |
| rank       | 粉丝榜排名                                                   |
| medal_name | 粉丝牌名                                                     |
| level      | 粉丝牌等级                                                   |
| face       | 头像链接                                                     |
| color      | 金色：16752445 粉色：16746162 紫色：10512625 蓝色：5805790 绿色：6406234 |
| target_id  | 主播uid                                                      |



### 房管

https://api.live.bilibili.com/xlive/web-room/v1/roomAdmin/get_by_room?roomid=9922197&page_size=100

~~~json
{
  "code": 0,
  "message": "0",
  "ttl": 1,
  "data": {
    "page": {
      "page": 1,
      "page_size": 100,
      "total_page": 1,
      "total_count": 12
    },
    "data": [
      {
        "uid": 3690191,
        "uname": "断片先生skr",
        "face": "http://i2.hdslb.com/bfs/face/83a0991ae3e91fbcd7908e6f2a58ae64a525659c.jpg",
        "ctime": "2018-10-25 14:43:29"
      },
      {
        "uid": 301331156,
        "uname": "嘻嘻家の撒撒",
        "face": "http://i2.hdslb.com/bfs/face/0c9825901c1215ef8465a66abb050753c5b550dc.jpg",
        "ctime": "2018-11-12 14:06:39"
      },
      {
        "uid": 160506215,
        "uname": "铁锹突击手",
        "face": "http://i1.hdslb.com/bfs/face/66ec88f681cd22a3a3ad7d9b825688a1f01d56de.jpg",
        "ctime": "2019-04-13 13:57:09"
      },
      {
        "uid": 16063761,
        "uname": "嘻嘻家の柒ば翎佐",
        "face": "http://i0.hdslb.com/bfs/face/207fc1d70a035511fffc67b55d4705dac1373053.jpg",
        "ctime": "2019-04-20 14:43:54"
      },
      {
        "uid": 19751178,
        "uname": "新东方肄业の小阿厨",
        "face": "http://i0.hdslb.com/bfs/face/58c9df4af9b8363d883605dfd675105a7056a48e.jpg",
        "ctime": "2019-06-25 17:20:35"
      },
      {
        "uid": 30568022,
        "uname": "嘻嘻家のM酱",
        "face": "http://i2.hdslb.com/bfs/face/bb475960cc5d0042aa125abd91e004940eeb66f6.jpg",
        "ctime": "2019-06-25 17:30:47"
      },
      {
        "uid": 66008114,
        "uname": "嘻嘻家の小悟空",
        "face": "http://i2.hdslb.com/bfs/face/4c0043622e34508158a8e5abac27493a09704862.jpg",
        "ctime": "2019-07-11 13:28:51"
      },
      {
        "uid": 9078870,
        "uname": "犬君是个舔狗",
        "face": "http://i0.hdslb.com/bfs/face/828f939636842448a981a166a0703afbcc450d90.gif",
        "ctime": "2019-08-31 16:44:31"
      },
      {
        "uid": 383103,
        "uname": "暑假作业还没写完",
        "face": "http://i1.hdslb.com/bfs/face/01dc7888ba84674d6b2d887794d22392b055e4b9.jpg",
        "ctime": "2019-10-24 17:31:40"
      },
      {
        "uid": 346685845,
        "uname": "我还是叫KCC吧",
        "face": "http://i0.hdslb.com/bfs/face/f54155d719cde496fdbb32dcbb02af2e7fa82143.jpg",
        "ctime": "2019-11-12 14:16:42"
      },
      {
        "uid": 314824541,
        "uname": "嘻嘻家の贞贞小可爱",
        "face": "http://i1.hdslb.com/bfs/face/4de9c7938eb05fcc0ddc1e47ae312edc179c4f09.jpg",
        "ctime": "2019-12-29 18:11:52"
      },
      {
        "uid": 21993633,
        "uname": "老古没得感情",
        "face": "http://i0.hdslb.com/bfs/face/fe810222c00603b875184ac9865e9fe3469c0f49.jpg",
        "ctime": "2020-01-05 12:39:31"
      }
    ],
    "max_room_anchors_number": 150
  }
}
~~~

#### 参数说明

| 参数  | 说明     |
| ----- | -------- |
| uid   | 用户id   |
| uname | 用户名   |
| face  | 用户头像 |
| ctime | 任命时间 |

### 获取主播信息接口

~~~json
// 20200123142251
// https://api.live.bilibili.com/xlive/web-room/v1/index/getInfoByRoom?room_id=21660412

{
  "code": 0,
  "message": "0",
  "ttl": 1,
  "data": {
    "room_info": {
      "uid": 478304235,
      "room_id": 21660412,
      "short_id": 0,
      "title": "(祖传口胡）唱歌机器已上线~",
      "cover": "http://i0.hdslb.com/bfs/live/user_cover/ffb2ccf7cfa2b33a06eae315a2c68708367b1f3c.jpg",
      "tags": "",
      "background": "http://static.hdslb.com/live-static/images/bg/6.jpg",
      "description": "<p># 21 2002年的第一场雪 36.5°C<br>A 爱囚 安河桥 宝贝 Always Online 爱你 爱的魔法 爱要坦荡荡 爱的双重魔力 爱的就是你 爱丫爱丫 爱你A.I.N.Y 爱了很久的朋友 爱你不是三两天<br>B 被驯服的象 别找我麻烦 不将就 不该 半情歌 被风吹过的夏天 不想 不染<br>C 侧脸 尘埃 成全 出卖 从前慢 猜不透 春风吹 曹操 宠坏 趁早<br>D 大鱼 带我走 当爱在靠近 当你 倒数 稻香 第一天 东西 豆浆油条 电台情歌 等你下课 达尔文 多想留在你的身边 断了的弦 第三人称 第二杯半价<br>E 恶作剧 <br>F 房间 浮生未歇 腐草为萤 分手快乐 非酋<br>G 感谢你曾来过 告白气球 搁浅 给我一个理由忘记 给我一首歌的时间 故梦 光年之外 广寒宫 孤单北半球 过客 咖喱咖喱 耿耿于怀<br>H 海芋恋 好不容易 好久不见 好想你 红色高跟鞋 后来 呼吸决定 幻听 Hey Jude 好像掉进爱情海里 红昭愿 会呼吸的痛 红颜旧 后会无期 跟我在一起 回忆的沙漏 <br>J 简单爱 今天你要嫁给我 锦鲤抄 就是爱你 静悄悄 寂寞沙洲冷 九张机 讲真的<br>K 开始懂了 可爱女人 可不可以 可念不可说 可惜不是你 空心 空港 靠近一点点 空白格 可惜没如果 空空如也 空山新雨后<br>L 来不及 来自天堂的魔鬼 浪人琵琶 练习题 恋人心 凉城 凉凉 领悟 Lydia 流着泪分手 Let You Go 绿色 浪漫爱 龙卷风<br>M 慢慢喜欢你 美人鱼 魔鬼中的天使 木头的心 芒种 马德里不思议 默爱 没有人不比我快乐  莫斯科没有眼泪 每个人都会 萌萌哒 没有什么不同 梦醒时分<br>N 那个男孩 那么骄傲 那些你很冒险的梦 你把我灌醉 你给我听好 逆光 年轮说 你的微笑 你不知道的事 那些花 女儿情 年轮 暖暖 你的酒馆对我打了烊 那女孩对我说 你曾是少年 你不是真正的快乐<br>O 欧若拉 欧巴我不傻<br>P 偏爱 漂洋过海来看你 泡沫 破裂<br>Q 其实都没有 牵丝戏 桥豆麻袋 晴天 雀跃 千年之恋 求佛 秋天不回来 情歌 青柠 青春不打烊 青睐 期待爱<br>R 人质 如果的事 如果有来生 如果这就是爱情 热气球<br>S 三寸天堂 山楂树之恋 少一点天分 盛夏的果实 世界上的另一个我 说好不哭 说谎 算什么男人 岁月神偷 说爱你 说散就散 十七岁的雨季 说好的幸福呢 十万毫升泪水 三人游 舒伯特玫瑰 失恋无罪 霜降 舍得 水星记<br>T 他不懂 太阳 叹云兮 棠梨煎雪 体面 甜甜的 同手同脚 推开世界的门 退后 天黑黑 她说 他不爱我 淘汰 天涯<br>W 外愈 为你写诗 我爱他 我不难过 我不愿让你一个人 我唱情歌给你听 我的秘密 我的世界 我怀念的 我喜欢上你的内心活动 我以为 问 我很快乐 外婆的澎湖湾 未闻花名 外面的世界 我想我不够好 我的天空 晚安喵 我愿平凡的陪在你身边 我还想她 味道 我要你 我的歌声里 我要找到你 我多喜欢你你会知道 我最亲爱的 我可以抱你吗 我真的受伤了<br>X 下一秒 下雨天 夏天的风 想你的夜 像鱼 小酒窝 小小 小幸运 小永远 笑忘书 修炼爱情 学猫叫 寻水的鱼 小芳 心安理得 下一个天亮 雪落下的声音 写给我第一个喜欢的女孩的歌 幸福了然后呢 小手拉大手 心墙  小宇 心动 心愿便利贴 需要人陪 想要你知道<br>Y 烟花易冷 烟雨成云 一个人想着一个人 一万个舍不得 一直很安静 以后的以后 易燃易爆炸 园游会 有点甜 有你的快乐 雨爱 预谋 遇见 遇见你的时候所有星星都落在我头上 原谅 月牙湾 越来越不懂 阴天 夜车 鱼玄机 隐形的翅膀 隐形人 有可能的夜晚 疑心病 一笑倾城 遇到 鱼 一个像夏天一个像秋天 有何不可 永不失联的爱 一路向北<br>Z 怎样 真的不容易 只对你有感觉 终于等到你 坠落星空 最初的梦想 最天使 最长的电影 醉赤壁 左边 怎么唱情歌 追光者 纸短情长 知否知否 最重要的决定 只是太爱你</p>",
      "live_status": 1,
      "live_start_time": 1579760407,
      "live_screen_type": 0,
      "lock_status": 0,
      "lock_time": 0,
      "hidden_status": 0,
      "hidden_time": 0,
      "area_id": 190,
      "area_name": "唱见电台",
      "parent_area_id": 5,
      "parent_area_name": "电台",
      "keyframe": "http://i0.hdslb.com/bfs/live/21660412.jpg?01230101",
      "special_type": 0,
      "up_session": "",
      "pk_status": 0,
      "is_studio": false,
      "pendants": {
        "frame": {
          "name": "鼠年初级头像框",
          "value": "https://i0.hdslb.com/bfs/vc/b132fdde54a32041e51133714604bc52f4f024d7.png",
          "desc": ""
        }
      },
      "on_voice_join": 0,
      "online": 1205,
      "room_type": {
        "4-1": 1
      }
    },
    "anchor_info": {
      "base_info": {
        "uname": "兔叽叽姐姐",
        "face": "http://i2.hdslb.com/bfs/face/859a3468d1ac4df8e2a7c915f5da8aa464b2a640.jpg",
        "gender": "保密",
        "official_info": {
          "role": -1,
          "title": "",
          "desc": ""
        }
      },
      "live_info": {
        "level": 24,
        "level_color": 10512625,
        "score": 2373036,
        "upgrade_score": 631774,
        "current": [
          620000,
          2214810
        ],
        "next": [
          790000,
          3004810
        ]
      },
      "relation_info": {
        "attention": 1878
      }
    },
    "rankdb_info": {
      "roomid": 21660412,
      "rank_desc": "小时总榜",
      "color": "#FB7299",
      "h5_url": "https://live.bilibili.com/p/html/live-app-rankcurrent/index.html?is_live_half_webview=1&hybrid_half_ui=1,5,85p,70p,FFE293,0,30,100,10;2,2,320,100p,FFE293,0,30,100,0;4,2,320,100p,FFE293,0,30,100,0;6,5,65p,60p,FFE293,0,30,100,10;5,5,55p,60p,FFE293,0,30,100,10;3,5,85p,70p,FFE293,0,30,100,10;7,5,65p,60p,FFE293,0,30,100,10;&anchor_uid=478304235&rank_type=master_realtime_hour_room&area_hour=1&area_v2_id=190&area_v2_parent_id=5",
      "web_url": "https://live.bilibili.com/blackboard/room-current-rank.html?rank_type=master_realtime_hour_room&area_hour=1&area_v2_id=190&area_v2_parent_id=5",
      "timestamp": 1579760572
    },
    "area_rank_info": {
      "areaRank": {
        "index": 4,
        "rank": ">100"
      }
    },
    "activity_init_info": {
      "eventList": [
        
      ],
      "weekInfo": {
        "bannerInfo": null,
        "giftName": null
      },
      "giftName": null,
      "lego": {
        "timestamp": 1579760572,
        "config": "[{\"name\":\"frame-mng\",\"url\":\"https:\\/\\/live.bilibili.com\\/p\\/html\\/live-web-mng\\/index.html?roomid=#roomid#&arae_id=#area_id#&parent_area_id=#parent_area_id#&ruid=#ruid#\",\"startTime\":1559544736,\"endTime\":1877167950,\"type\":\"frame-mng\"},{\"name\":\"gogogopage\",\"target\":\"sidebar\",\"icon\":\"https:\\/\\/i0.hdslb.com\\/bfs\\/activity-plat\\/static\\/20191028\\/827e14bd59aba86e36e4e29bd3ca6b0e\\/L6Yiz6WVx.png\",\"text\":\"\\u6bcf\\u65e5\\u5386\\u9669\",\"url\":\"https:\\/\\/live.bilibili.com\\/p\\/html\\/live-app-daily\\/index.html?room_id=#roomid#&width=376&height=600\",\"color\":\"#3a2d7c\",\"startTime\":1573142400,\"endTime\":1732264659},{\"name\":\"nys-task\",\"target\":\"sidebar\",\"icon\":\"https:\\/\\/i0.hdslb.com\\/bfs\\/activity-plat\\/static\\/20200112\\/de1d1dfd560c306a32bc79355a82fd45\\/JUCdxmxrh.png\",\"text\":\"\\u793c\\u5305\",\"url\":\"https:\\/\\/live.bilibili.com\\/activity\\/nys-2020-web\\/index.html?anchor=package#\\/page-one\",\"color\":\"#2e6fc0\",\"startTime\":1579420800,\"endTime\":1581177600},{\"name\":\"nys-rank\",\"target\":\"sidebar\",\"icon\":\"https:\\/\\/i0.hdslb.com\\/bfs\\/activity-plat\\/static\\/20200112\\/de1d1dfd560c306a32bc79355a82fd45\\/oTZYwQBLz7.png\",\"text\":\"\\u699c\\u5355\",\"url\":\"https:\\/\\/live.bilibili.com\\/activity\\/nys-2020-room\\/index.html?room_id=#roomid#&width=376&height=600\\/#\\/detail\",\"color\":\"#2e6fc0\",\"startTime\":1579420800,\"endTime\":1581177600}]"
      }
    },
    "web_banner_info": {
      "id": 0,
      "title": "",
      "left": "",
      "right": "",
      "jump_url": "",
      "bg_color": "",
      "hover_color": "",
      "text_bg_color": "",
      "text_hover_color": "",
      "link_text": "",
      "link_color": "",
      "input_color": "",
      "input_text_color": "",
      "input_hover_color": "",
      "input_border_color": "",
      "input_search_color": ""
    },
    "lol_info": {
      "lol_activity": {
        "status": 0,
        "guess_cover": "http://i0.hdslb.com/bfs/live/61d1c4bcce470080a5408d6c03b7b48e0a0fa8d7.png",
        "vote_cover": "https://i0.hdslb.com/bfs/activity-plat/static/20190930/4ae8d4def1bbff9483154866490975c2/oWyasOpox.png",
        "vote_h5_url": "https://live.bilibili.com/p/html/live-app-wishhelp/index.html?is_live_half_webview=1&hybrid_biz=live-app-wishhelp&hybrid_rotate_d=1&hybrid_half_ui=1,3,100p,360,0c1333,0,30,100;2,2,375,100p,0c1333,0,30,100;3,3,100p,360,0c1333,0,30,100;4,2,375,100p,0c1333,0,30,100;5,3,100p,360,0c1333,0,30,100;6,2,100p,360,0c1333,0,30,100;7,3,100p,360,0c1333,0,30,100;8,3,100p,360,0c1333,0,30,100;",
        "vote_use_h5": true
      }
    },
    "wish_list_info": {
      "status": 1,
      "list": [
        {
          "id": 75697,
          "uid": 478304235,
          "type": 1,
          "type_id": 25,
          "wish_limit": 1,
          "wish_progress": 0,
          "status": 1,
          "content": "明信片",
          "ctime": "2019-12-24 13:36:54",
          "count_map": [
            1,
            3,
            5
          ]
        }
      ]
    },
    "score_card_info": null,
    "governor_show_info": {
      "cnt": 0,
      "list": [
        
      ]
    },
    "pk_info": null,
    "battle_info": null,
    "silent_room_info": null,
    "switch_info": {
      "close_guard": false,
      "close_gift": false,
      "close_online": false,
      "close_danmaku": false
    },
    "record_switch_info": {
      "record_tab": false
    },
    "room_config_info": {
      "dm_text": "发个弹幕呗~"
    }
  }
}
~~~

### 获取主播信息接口2

https://api.live.bilibili.com/room_ex/v1/RoomNews/get?roomid=21660412&uid=478304235

~~~json
// 20200123143238
// https://api.live.bilibili.com/room_ex/v1/RoomNews/get?roomid=21660412&uid=478304235

{
  "code": 0,
  "msg": "ok",
  "message": "ok",
  "data": {
    "roomid": "21660412",
    "uid": "478304235",
    "content": "每天上午九点 下午两点直播",
    "ctime": "2020-01-22 11:50:30",
    "status": "0",
    "uname": "兔叽叽姐姐"
  }
}
~~~



### 头衔接口

https://api.live.bilibili.com/rc/v1/Title/webTitles



url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAGAAAABgCAMAAADVRocKAAADAFBMV…h1Lue213NNCs7VEarPBT3XJl+gWAz4rs9/fv79mzevWP6/ATsRAQhTWDk0AAAAAElFTkSuQmCC);

## 通过房间号获取uid

https://api.live.bilibili.com/xlive/web-room/v1/index/getInfoByRoom?room_id=10998

~~~json
// 20200127120229
// https://api.live.bilibili.com/xlive/web-room/v1/index/getInfoByRoom?room_id=10998

{
  "code": 0,
  "message": "0",
  "ttl": 1,
  "data": {
    "room_info": {
      "uid": 106514,
      "room_id": 10998,
      "short_id": 1219,
      "title": "新年新气象",
      "cover": "http://i0.hdslb.com/bfs/live/room_cover/46a18ce9d64458e5bd25ab3ee12eb8a0811f48b2.jpg",
      "tags": "炉石传说,小点,起飞咯",
      "background": "http://static.hdslb.com/live-static/images/bg/1.jpg",
      "description": "<p>喜欢的话请关注 喂食 上舰支持一下~</p>\n<p>龙门阵QQ群：687941619</p>\n<p>直播歌单：网易云音乐搜好哥哥点</p>\n<p>&nbsp;</p>",
      "live_status": 0,
      "live_start_time": 0,
      "live_screen_type": 0,
      "lock_status": 0,
      "lock_time": 0,
      "hidden_status": 0,
      "hidden_time": 0,
      "area_id": 91,
      "area_name": "炉石传说",
      "parent_area_id": 2,
      "parent_area_name": "网游",
      "keyframe": "http://i0.hdslb.com/bfs/live/10998.jpg?01261701",
      "special_type": 0,
      "up_session": "",
      "pk_status": 0,
      "is_studio": false,
      "pendants": {
        "frame": {
          "name": "",
          "value": "",
          "desc": ""
        }
      },
      "on_voice_join": 0,
      "online": 2026,
      "room_type": {
        "4-1": 1
      }
    },
    "anchor_info": {
      "base_info": {
        "uname": "好哥哥小点君",
        "face": "http://i1.hdslb.com/bfs/face/5d90ef03e5e6b5f41c4d905de4472162e69faaa6.jpg",
        "gender": "男",
        "official_info": {
          "role": -1,
          "title": "",
          "desc": ""
        }
      },
      "live_info": {
        "level": 29,
        "level_color": 10512625,
        "score": 9312987,
        "upgrade_score": 2570823,
        "current": [
          2104000,
          9013810
        ],
        "next": [
          2870000,
          11883810
        ]
      },
      "relation_info": {
        "attention": 19906
      }
    },
    "rankdb_info": {
      "roomid": 10998,
      "rank_desc": "小时总榜",
      "color": "#FB7299",
      "h5_url": "https://live.bilibili.com/p/html/live-app-rankcurrent/index.html?is_live_half_webview=1&hybrid_half_ui=1,5,85p,70p,FFE293,0,30,100,10;2,2,320,100p,FFE293,0,30,100,0;4,2,320,100p,FFE293,0,30,100,0;6,5,65p,60p,FFE293,0,30,100,10;5,5,55p,60p,FFE293,0,30,100,10;3,5,85p,70p,FFE293,0,30,100,10;7,5,65p,60p,FFE293,0,30,100,10;&anchor_uid=106514&rank_type=master_realtime_hour_room&area_hour=1&area_v2_id=91&area_v2_parent_id=2",
      "web_url": "https://live.bilibili.com/blackboard/room-current-rank.html?rank_type=master_realtime_hour_room&area_hour=1&area_v2_id=91&area_v2_parent_id=2",
      "timestamp": 1580097750
    },
    "area_rank_info": {
      "areaRank": {
        "index": 0,
        "rank": ">1000"
      }
    },
    "activity_init_info": {
      "eventList": [
        
      ],
      "weekInfo": {
        "bannerInfo": null,
        "giftName": {
          "30046": {
            "gift_id": 30046,
            "uanme": "",
            "face": "http://i0.hdslb.com/bfs/face/5d94b9727a49815716cd66fc7ba3840382025c56.jpg",
            "first_uname": "ZenosYX",
            "first_face": "http://i2.hdslb.com/bfs/face/ca0a26f865734c2b44101b3b1a320c7a36702beb.jpg"
          },
          "30064": {
            "gift_id": 30064,
            "uanme": "",
            "face": "http://i2.hdslb.com/bfs/face/d0dad8800774a4903547b1326d1fd927df47b4e9.jpg",
            "first_uname": "辣椒沫儿迷之喜欢TK",
            "first_face": "http://i1.hdslb.com/bfs/face/3a409e449704072278ff27970b689cb0c67176f6.jpg"
          },
          "30087": {
            "gift_id": 30087,
            "uanme": "",
            "face": "http://i2.hdslb.com/bfs/face/cb08aff97a24bb6a18a46cf924229d3c3bb5960e.jpg",
            "first_uname": "此情待追忆当时却枉然",
            "first_face": "http://i0.hdslb.com/bfs/face/ea7a750ee01eae09bb7c5e8dba0f328ae8ce735a.jpg"
          },
          "30088": {
            "gift_id": 30088,
            "uanme": "",
            "face": "http://i2.hdslb.com/bfs/face/bcdf640faa16ebaacea1d4c930baabaec9087a80.jpg",
            "first_uname": "改不回来的壁花",
            "first_face": "http://i0.hdslb.com/bfs/face/fcf95e6dbeee1a441800ff9c31d541acd51e0a61.jpg"
          },
          "30089": {
            "gift_id": 30089,
            "uanme": "",
            "face": "http://i2.hdslb.com/bfs/face/f6624ae51b19f336c70fc108b6bda9de7bd0eae2.jpg",
            "first_uname": "綺羅-",
            "first_face": "http://i1.hdslb.com/bfs/face/792f500254dedd3bca2e8b60aa01b72aedeadc7c.jpg"
          },
          "30090": {
            "gift_id": 30090,
            "uanme": "",
            "face": "http://i2.hdslb.com/bfs/face/b8bd2c79fe59196a5aae3aa66105b684c316e565.jpg",
            "first_uname": "489吱钵钵老母鸡",
            "first_face": "http://i0.hdslb.com/bfs/face/92f9f16ae3d226e82b924338a42c72e0e4b4ccb9.jpg"
          },
          "30091": {
            "gift_id": 30091,
            "uanme": "",
            "face": "http://i1.hdslb.com/bfs/face/0eb7ef1ac87ed643d1734ea07dd1b0da6a3084c6.jpg",
            "first_uname": "花田田的田",
            "first_face": "http://static.hdslb.com/images/member/noface.gif"
          },
          "30229": {
            "gift_id": 30229,
            "uanme": "",
            "face": "http://i2.hdslb.com/bfs/face/f6d3536c3004254174d8da34a1c261115f90e3c0.jpg",
            "first_uname": "LadonQ",
            "first_face": "http://i1.hdslb.com/bfs/face/efda10841a6a4a5b23003b7749e48cbded7fb18a.jpg"
          }
        }
      },
      "giftName": {
        "30046": {
          "gift_id": 30046,
          "uname": "EdmundDZhang",
          "face": "http://i0.hdslb.com/bfs/face/5d94b9727a49815716cd66fc7ba3840382025c56.jpg",
          "first_uname": "ZenosYX",
          "first_face": "http://i2.hdslb.com/bfs/face/ca0a26f865734c2b44101b3b1a320c7a36702beb.jpg",
          "bg_url": "http://i0.hdslb.com/bfs/live/9eab4a0babdbbc68b884fbb885827abb4eb71da2.png",
          "text_color_1": "#FFFFFF",
          "text_color_2": "#ECCEFF"
        },
        "30064": {
          "gift_id": 30064,
          "uname": "逍遥散人",
          "face": "http://i2.hdslb.com/bfs/face/d0dad8800774a4903547b1326d1fd927df47b4e9.jpg",
          "first_uname": "辣椒沫儿迷之喜欢TK",
          "first_face": "http://i1.hdslb.com/bfs/face/3a409e449704072278ff27970b689cb0c67176f6.jpg",
          "bg_url": "http://i0.hdslb.com/bfs/live/9eab4a0babdbbc68b884fbb885827abb4eb71da2.png",
          "text_color_1": "#FFFFFF",
          "text_color_2": "#ECCEFF"
        },
        "30087": {
          "gift_id": 30087,
          "uname": "正直的男U",
          "face": "http://i2.hdslb.com/bfs/face/cb08aff97a24bb6a18a46cf924229d3c3bb5960e.jpg",
          "first_uname": "此情待追忆当时却枉然",
          "first_face": "http://i0.hdslb.com/bfs/face/ea7a750ee01eae09bb7c5e8dba0f328ae8ce735a.jpg",
          "bg_url": "http://i0.hdslb.com/bfs/live/9eab4a0babdbbc68b884fbb885827abb4eb71da2.png",
          "text_color_1": "#FFFFFF",
          "text_color_2": "#ECCEFF"
        },
        "30088": {
          "gift_id": 30088,
          "uname": "痒局长",
          "face": "http://i2.hdslb.com/bfs/face/bcdf640faa16ebaacea1d4c930baabaec9087a80.jpg",
          "first_uname": "改不回来的壁花",
          "first_face": "http://i0.hdslb.com/bfs/face/fcf95e6dbeee1a441800ff9c31d541acd51e0a61.jpg",
          "bg_url": "http://i0.hdslb.com/bfs/live/9eab4a0babdbbc68b884fbb885827abb4eb71da2.png",
          "text_color_1": "#FFFFFF",
          "text_color_2": "#ECCEFF"
        },
        "30089": {
          "gift_id": 30089,
          "uname": "顾于浮生如梦",
          "face": "http://i2.hdslb.com/bfs/face/f6624ae51b19f336c70fc108b6bda9de7bd0eae2.jpg",
          "first_uname": "綺羅-",
          "first_face": "http://i1.hdslb.com/bfs/face/792f500254dedd3bca2e8b60aa01b72aedeadc7c.jpg",
          "bg_url": "http://i0.hdslb.com/bfs/live/9eab4a0babdbbc68b884fbb885827abb4eb71da2.png",
          "text_color_1": "#FFFFFF",
          "text_color_2": "#ECCEFF"
        },
        "30090": {
          "gift_id": 30090,
          "uname": "绝不早到小吱吱",
          "face": "http://i2.hdslb.com/bfs/face/b8bd2c79fe59196a5aae3aa66105b684c316e565.jpg",
          "first_uname": "489吱钵钵老母鸡",
          "first_face": "http://i0.hdslb.com/bfs/face/92f9f16ae3d226e82b924338a42c72e0e4b4ccb9.jpg",
          "bg_url": "http://i0.hdslb.com/bfs/live/9eab4a0babdbbc68b884fbb885827abb4eb71da2.png",
          "text_color_1": "#FFFFFF",
          "text_color_2": "#ECCEFF"
        },
        "30091": {
          "gift_id": 30091,
          "uname": "甜九__微微醺",
          "face": "http://i1.hdslb.com/bfs/face/0eb7ef1ac87ed643d1734ea07dd1b0da6a3084c6.jpg",
          "first_uname": "花田田的田",
          "first_face": "http://static.hdslb.com/images/member/noface.gif",
          "bg_url": "http://i0.hdslb.com/bfs/live/9eab4a0babdbbc68b884fbb885827abb4eb71da2.png",
          "text_color_1": "#FFFFFF",
          "text_color_2": "#ECCEFF"
        },
        "30229": {
          "gift_id": 30229,
          "uname": "C酱です",
          "face": "http://i2.hdslb.com/bfs/face/f6d3536c3004254174d8da34a1c261115f90e3c0.jpg",
          "first_uname": "LadonQ",
          "first_face": "http://i1.hdslb.com/bfs/face/efda10841a6a4a5b23003b7749e48cbded7fb18a.jpg",
          "bg_url": "http://i0.hdslb.com/bfs/live/9eab4a0babdbbc68b884fbb885827abb4eb71da2.png",
          "text_color_1": "#FFFFFF",
          "text_color_2": "#ECCEFF"
        }
      },
      "lego": {
        "timestamp": 1580097750,
        "config": "[{\"name\":\"frame-mng\",\"url\":\"https:\\/\\/live.bilibili.com\\/p\\/html\\/live-web-mng\\/index.html?roomid=#roomid#&arae_id=#area_id#&parent_area_id=#parent_area_id#&ruid=#ruid#\",\"startTime\":1559544736,\"endTime\":1877167950,\"type\":\"frame-mng\"},{\"name\":\"gogogopage\",\"target\":\"sidebar\",\"icon\":\"https:\\/\\/i0.hdslb.com\\/bfs\\/activity-plat\\/static\\/20191028\\/827e14bd59aba86e36e4e29bd3ca6b0e\\/L6Yiz6WVx.png\",\"text\":\"\\u6bcf\\u65e5\\u5386\\u9669\",\"url\":\"https:\\/\\/live.bilibili.com\\/p\\/html\\/live-app-daily\\/index.html?room_id=#roomid#&width=376&height=600\",\"color\":\"#3a2d7c\",\"startTime\":1573142400,\"endTime\":1732264659},{\"name\":\"nys-task\",\"target\":\"sidebar\",\"icon\":\"https:\\/\\/i0.hdslb.com\\/bfs\\/activity-plat\\/static\\/20200112\\/de1d1dfd560c306a32bc79355a82fd45\\/JUCdxmxrh.png\",\"text\":\"\\u793c\\u5305\",\"url\":\"https:\\/\\/live.bilibili.com\\/activity\\/nys-2020-web\\/index.html?anchor=package#\\/page-one\",\"color\":\"#2e6fc0\",\"startTime\":1579420800,\"endTime\":1581177600},{\"name\":\"nys-rank\",\"target\":\"sidebar\",\"icon\":\"https:\\/\\/i0.hdslb.com\\/bfs\\/activity-plat\\/static\\/20200112\\/de1d1dfd560c306a32bc79355a82fd45\\/oTZYwQBLz7.png\",\"text\":\"\\u699c\\u5355\",\"url\":\"https:\\/\\/live.bilibili.com\\/activity\\/nys-2020-room\\/index.html?room_id=#roomid#&width=376&height=600\\/#\\/detail\",\"color\":\"#2e6fc0\",\"startTime\":1579420800,\"endTime\":1581177600}]"
      }
    },
    "web_banner_info": {
      "id": 0,
      "title": "",
      "left": "",
      "right": "",
      "jump_url": "",
      "bg_color": "",
      "hover_color": "",
      "text_bg_color": "",
      "text_hover_color": "",
      "link_text": "",
      "link_color": "",
      "input_color": "",
      "input_text_color": "",
      "input_hover_color": "",
      "input_border_color": "",
      "input_search_color": ""
    },
    "lol_info": {
      "lol_activity": {
        "status": 0,
        "guess_cover": "http://i0.hdslb.com/bfs/live/61d1c4bcce470080a5408d6c03b7b48e0a0fa8d7.png",
        "vote_cover": "https://i0.hdslb.com/bfs/activity-plat/static/20190930/4ae8d4def1bbff9483154866490975c2/oWyasOpox.png",
        "vote_h5_url": "https://live.bilibili.com/p/html/live-app-wishhelp/index.html?is_live_half_webview=1&hybrid_biz=live-app-wishhelp&hybrid_rotate_d=1&hybrid_half_ui=1,3,100p,360,0c1333,0,30,100;2,2,375,100p,0c1333,0,30,100;3,3,100p,360,0c1333,0,30,100;4,2,375,100p,0c1333,0,30,100;5,3,100p,360,0c1333,0,30,100;6,2,100p,360,0c1333,0,30,100;7,3,100p,360,0c1333,0,30,100;8,3,100p,360,0c1333,0,30,100;",
        "vote_use_h5": true
      }
    },
    "wish_list_info": {
      "status": 1,
      "list": [
        {
          "id": 2459,
          "uid": 106514,
          "type": 1,
          "type_id": 4,
          "wish_limit": 2000,
          "wish_progress": 147,
          "status": 1,
          "content": "喵娘",
          "ctime": "2018-01-13 11:24:12",
          "count_map": [
            1,
            10,
            100
          ]
        },
        {
          "id": 3111,
          "uid": 106514,
          "type": 1,
          "type_id": 8,
          "wish_limit": 2333,
          "wish_progress": 1792,
          "status": 1,
          "content": "嘲笑我吧！",
          "ctime": "2018-01-14 14:03:10",
          "count_map": [
            1,
            3,
            5
          ]
        },
        {
          "id": 7291,
          "uid": 106514,
          "type": 1,
          "type_id": 3,
          "wish_limit": 1219,
          "wish_progress": 1088,
          "status": 1,
          "content": "勋章",
          "ctime": "2018-01-24 14:52:03",
          "count_map": [
            1,
            10,
            100
          ]
        }
      ]
    },
    "score_card_info": null,
    "governor_show_info": {
      "cnt": 0,
      "list": [
        
      ]
    },
    "pk_info": null,
    "battle_info": null,
    "silent_room_info": null,
    "switch_info": {
      "close_guard": false,
      "close_gift": false,
      "close_online": false,
      "close_danmaku": false
    },
    "record_switch_info": {
      "record_tab": false
    },
    "room_config_info": {
      "dm_text": "发个弹幕呗~"
    }
  }
}
~~~

## 消息推送（钉钉机器人）

https://oapi.dingtalk.com/robot/send?access_token=08b7b4e629624423f37058158c85d3809029f10eef0807ee0c9a3c585a79a006

~~~cmd
curl 'https://oapi.dingtalk.com/robot/sendaccess_token=08b7b4e629624423f37058158c85d3809029f10eef0807ee0c9a3c585a79a006' \ -H 'Content-Type: application/json' \ -d '{"msgtype": "text", "text": { "content": "本条服务器消息为测试消息，关键词为服务器测试" } }' 
~~~

