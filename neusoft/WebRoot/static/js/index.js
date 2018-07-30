window.addEventListener('load', () => {
    // $.ajax({
    //     type: "post",
    //     url: "http://localhost:8080/neusoft/ShowMovie",
    //     dataType:"JSON",
    //     contentType:"application/json;charset=utf-8",
    //     data: JSON.stringify({
    //         count: 5
    //     }),
    //     success: function(str) {
    //      console.log(str);

    //         initIndexContentItems(str)
    //     },
    //     error: function() {
    //         console.log("error");
    //         console.log("进的这里");
    //     }
    // })
    // 
    initIndexContentItems(movieData);

    _prime(".index-content")[0].addEventListener("click", (e) => {
        if (e.target.nodeName == "IMG") {
            _prime(".alert-box")[0].setAttribute("style", "background-color:rgba(0, 0, 0, .5);z-index:1");
            _prime(".alert-content")[0].setAttribute("style", "opacity:1;z-index:1");

            initModalContent(e.target.getAttribute("movieId"));
        }
    })
    _prime(".index-content")[1].addEventListener("click", (e) => {
        if (e.target.nodeName == "IMG") {
            _prime(".alert-box")[0].setAttribute("style", "background-color:rgba(0, 0, 0, .5);z-index:1");
            _prime(".alert-content")[0].setAttribute("style", "opacity:1;z-index:1");

            initModalContent(e.target.getAttribute("movieId"));
        }
    })
    _prime(".index-content")[2].addEventListener("click", (e) => {
        if (e.target.nodeName == "IMG") {
            _prime(".alert-box")[0].setAttribute("style", "background-color:rgba(0, 0, 0, .5);z-index:1");
            _prime(".alert-content")[0].setAttribute("style", "opacity:1;z-index:1");

            initModalContent(e.target.getAttribute("movieId"));
        }
    })



    _prime(".close-button")[0].addEventListener("click", () => {
        _prime(".alert-box")[0].setAttribute("style", "background-color:rgba(0, 0, 0, 0);z-index:-1");
        _prime(".alert-content")[0].setAttribute("style", "z-index:-1;opacity:0");

        _prime(".alert-content")[0].innerHTML = "";
    })

})

const getDomElement = (type, className, text) => {
    let domNode = document.createElement(type);
    let textNode = document.createTextNode(text);

    domNode.appendChild(textNode);
    domNode.className = className;

    return domNode;
}

const initIndexContentItems = (movieData) => {

    let liArray = [];

    for (let i = 0; i < 20; i++) {
        let rootLi = getDomElement("li", "", "");
        let ulNode = getDomElement("ul", "index-movies-item", ""),
            imageLiNode = getDomElement('li', "image", ""),
            imageNode = getDomElement("img", "", ""),
            nameLiNode = getDomElement("li", "", movieData[i].movieName),
            scoreLiNode = getDomElement("li", "", ""),
            scoreSpanNode = getDomElement("span", "score", movieData[i].average + "分"),
            buttonLiNode = getDomElement("li", "", ""),
            buttonNode = getDomElement("button", "purchase", "选座购票");

        imageNode.setAttribute("src", "./" + movieData[i].picture);
        imageNode.setAttribute("movieid", movieData[i].movie_id - 1);

        // console.log(movieData[i].movie_id)

        imageLiNode.appendChild(imageNode);

        scoreLiNode.appendChild(scoreSpanNode);
        buttonLiNode.appendChild(buttonNode);

        ulNode.appendChild(imageLiNode);
        ulNode.appendChild(nameLiNode);
        ulNode.appendChild(scoreLiNode);
        ulNode.appendChild(buttonLiNode);

        rootLi.appendChild(ulNode);

        liArray.push(rootLi);
    }

    for (let i = 0; i < 5; i++) {
        // console.log("第一栏")
        _prime(".index-movies-silders")[0].appendChild(liArray[i]);
    }
    for (let i = 5; i < 10; i++) {
        // console.log("第二栏")
        _prime(".index-movies-silders")[1].appendChild(liArray[i]);
    }
    for (let i = 10; i < 15; i++) {
        // console.log("第三栏")
        _prime(".index-movies-silders")[2].appendChild(liArray[i]);
    }
}


const initModalContent = (movieId) => {
    let h1Node = getDomElement("h1", "", movieData[movieId].movieName + " " + movieData[movieId].type),
        imgNode = getDomElement("img", "", ""),
        directorPNode = getDomElement("p", "", "导演 ： " + movieData[movieId].director),
        actorPNode = getDomElement("p", "", "演员 ： " + movieData[movieId].actor),
        typePNode = getDomElement("p", "", "类型 ： " + movieData[movieId].type),
        datePNode = getDomElement("p", "", "日期 ： " + movieData[movieId].date),
        countryPNode = getDomElement("p", "", "地区 ： " + movieData[movieId].country),
        lanPNode = getDomElement("p", "", "语言 ： " + movieData[movieId].language),
        scoreSpanNode = getDomElement("span", "score", movieData[movieId].average + "分"),
        scorePNode = getDomElement("p", "", "评分 ： ");
        describePNode = getDomElement("p", "describe", "电影描述 ： " + movieData[movieId].describe);

    imgNode.setAttribute("src", "./" + movieData[movieId].picture);
    scorePNode.appendChild(scoreSpanNode);

    let rootDiv = _prime(".alert-content")[0];
    rootDiv.appendChild(h1Node);
    rootDiv.appendChild(imgNode);
    rootDiv.appendChild(directorPNode);
    rootDiv.appendChild(actorPNode);
    rootDiv.appendChild(typePNode);
    rootDiv.appendChild(datePNode);
    rootDiv.appendChild(countryPNode);
    rootDiv.appendChild(lanPNode);
    rootDiv.appendChild(scorePNode);
    rootDiv.appendChild(describePNode);
}

let movieData = [
    {
        "movie_id": "1",
        "movieName": "我不是药神",
        "date": "2018-07-07",
        "director": "文牧野",
        "actor": "徐峥/王传君",
        "type": "剧情/喜剧",
        "country": "中国大陆",
        "language": "普通话",
        "picture": "image/yao.png",
        "average": "8.9",
        "describe": "普通中年男子程勇（徐峥 饰）经营着一家保健品店，失意又失婚。不速之客吕受益（王传君 饰）的到来，让他开辟了一条去印度买药做代购的新事业，虽然困难重重，但他在这条买药之路上发现了商机，一发不可收拾地做起了治疗慢粒白血病的印度仿制药独家代理商。赚钱的同时，他也认识了几个病患及家属，为救女儿被迫做舞女的思慧（谭卓 饰）、说一口流利神父腔英语的刘牧师（杨新鸣 饰），，以及脾气暴烈的黄毛（章宇 饰），几个人合伙做起了生意，利润倍增的同时也危机四伏。程勇昔日的小舅子曹警官（周一围 饰）奉命调查仿制药的源头，假药贩子张长林（王砚辉 饰）和瑞士正牌医药代表（李乃文 饰）也对其虎视眈眈，生意逐渐变成了一场关于救赎的拉锯战。 "
    },
    {
        "movie_id": "2",
        "movieName": "西红柿首富",
        "date": "2018-07-27",
        "director": "闫非/彭大魔",
        "actor": "沈腾/张一鸣",
        "type": "喜剧",
        "country": "中国大陆",
        "language": "普通话",
        "picture": "image/xi.png",
        "average": "6.8",
        "describe": "《西虹市首富》的故事发生在《夏洛特烦恼》中的特烦恼之城西虹市。混迹于丙级业余足球队的守门员王多鱼（沈腾饰演），因比赛失利被开除离队。正处于人生最低谷的他接受了神秘台湾财团一个月花光十亿资金的挑战。本以为快乐生活就此开始，王多鱼却第一次感到“花钱特烦恼！想要人生反转走上巅峰，真的没有那么简单。"
    },
    {
        "movie_id": "3",
        "movieName": "狄仁杰之四大天王",
        "date": "2018-07-27",
        "director": "徐克/陈国富",
        "actor": "赵又廷/冯绍峰",
        "type": "动作/悬疑/古装",
        "country": "中国大陆/香港",
        "language": "普通话",
        "picture": "image/di.png",
        "average": "6.7",
        "describe": "狄仁杰（赵又廷 饰）大破神都龙王案，获御赐亢龙锏，并掌管大理寺，使他成为武则天（刘嘉玲 饰）走向权力之路最大的威胁。武则天为了消灭眼中钉，命令尉迟真金（冯绍峰 饰）集结实力强劲的「异人组」，妄图夺取亢龙锏。 在医官沙陀忠（林更新 饰）的协助下，狄仁杰既要守护亢龙锏，又要破获神秘奇案，还要面对武则天的步步紧逼，大唐江山陷入了空前的危机之中……"
    },
    {
        "movie_id": "4",
        "movieName": "摩天营救",
        "date": "2018-07-20",
        "director": "罗森",
        "actor": "强森/坎贝尔",
        "type": "动作/惊悚/冒险",
        "country": "美国",
        "language": "英语/粤语/普通话",
        "picture": "image/mo.png",
        "average": "6.6",
        "describe": "在香港市中心，世界上最高、结构最复杂的摩天大楼遭到破坏，危机一触即发。威尔·索耶（道恩·强森 饰）的妻子萨拉（内芙·坎贝尔 饰）和孩子们在98层被劫为人质，直接暴露在火线上。威尔，这位战争英雄、前联邦调查局救援队员，作为大楼的安保顾问，却被诬陷纵火和谋杀。他必须奋力营救家人，为自己洗脱罪名，关乎生死存亡的高空任务就此展开。"
    },
    {
        "movie_id": "5",
        "movieName": "邪不压正",
        "date": "2018-07-13",
        "director": "姜文",
        "actor": "彭于晏/姜文",
        "type": "剧情/喜剧/动作",
        "country": "中国大陆",
        "language": "普通话",
        "picture": "image/xie.png",
        "average": "7.1",
        "describe": "七七事变前夕，华裔青年小亨德勒（彭于晏 饰）从美国远赴重洋，回到阔别十数年之久的北平从医。然而他真正的名字叫李天然，十三岁那年曾亲眼目睹师父一家遭师兄朱潜龙（廖凡 饰）和日本人根本一郎（泽田谦也 饰）灭门。侥幸逃生的天然被美国人亨德勒医生送往大洋彼岸，接受了极其严苛的训练，而今他怀着绝密的任务踏上故土。亨德勒父子租住神秘男子蓝青峰（姜文 饰）的宅子，蓝是当年辛亥革命的参与者，他与现为警察局长的朱潜龙过从甚密，却又以杀死李天然为筹码，暗中怂恿朱除掉根本一郎。复仇心切的李天然寻找到了仇人，而亨德勒医生则全力阻止养子冒险。在这一过程中，交际花唐凤仪（许晴 饰）与裁缝关巧红（周韵 饰）也卷入了男人的勾心斗角的漩涡里。直到七七事变爆发，所有的矛盾迎来了决断的时刻…… "
    },
    {
        "movie_id": "6",
        "movieName": "侏罗纪世界2",
        "date": "2018-06-15",
        "director": "胡安·安东尼奥·巴亚纳",
        "actor": "科林·特雷沃罗/ 布莱丝·达拉斯·霍华德",
        "type": "动作/科幻/冒险",
        "country": "美国/西班牙",
        "language": "英语",
        "picture": "image/zhu.png",
        "average": "6.8",
        "describe": "侏罗纪世界主题公园及豪华度假村被失控的恐龙们摧毁已有三年。如今，纳布拉尔岛已经被人类遗弃，岛上幸存的恐龙们在丛林中自给自足。 当岛上的休眠火山开始活跃以后，欧文（克里斯·帕拉特 饰）与克莱尔（布莱丝·达拉斯·霍华德 饰）发起了一场运动，想要保护岛上幸存的恐龙们免于灭绝。 欧文一心想要找到自己依然失踪在野外的迅猛龙首领布鲁，克莱尔如今也尊重起这些生物，以保护它们为己任。两人在熔岩开始喷发时来到了危险的小岛，他们的冒险也揭开了一个可能让地球回到史前时代般混乱秩序的阴谋。"
    },
    {
        "movie_id": "7",
        "movieName": "死侍2",
        "date": "2018-05-18",
        "director": "大卫·雷奇",
        "actor": "瑞恩·雷诺兹 / 乔什·布洛林 ",
        "type": "喜剧/动作/科幻/冒险",
        "country": "美国",
        "language": "英语",
        "picture": "image/dp.png",
        "average": "7.7",
        "describe": "拥有不死之身的死侍韦德·威尔森（瑞恩·雷诺兹 Ryan Reynolds 饰）继续在惩恶扬善、毒舌嘴贱的路上绝命狂奔，与此同时他和女友瓦内莎（莫蕾娜·巴卡林 Morena Baccarin 饰）的爱情逐渐升华，两人全新期待新生命的到来。谁知命运难测，因瓦内莎意外身亡，韦德万念俱灰，绝望地渴求生命的终结。在他最失落的时候，钢力士和少年弹头等将他领走，成为X战警中的一员。在某次行动中，死侍因袒护暴走的14岁变种人拉塞尔（朱利安·迪尼森 Julian Dennison 饰）而随同对方被关入冰盒监狱。没过多久，来自未来的电索（乔什·布洛林 Josh Brolin 饰）闯入监狱，意图杀死在未来引起无数灾难的拉塞尔。为了阻止电索，逃离监狱的死侍找到一群战友与之对抗，而拉塞尔则朝着黑暗渐渐远去…… "
    },
    {
        "movie_id": "8",
        "movieName": "头号玩家（ReadyPlayerOne）",
        "date": "2018-03-30",
        "director": "史蒂文·斯皮尔伯格",
        "actor": "泰伊·谢里丹 / 奥利维亚·库克",
        "type": "动作/科幻/冒险",
        "country": "美国",
        "language": "英语",
        "picture": "image/tou.png",
        "average": "8.7",
        "describe": "故事发生在2045年，虚拟现实技术已经渗透到了人类生活的每一个角落。詹姆斯哈利迪（马克·里朗斯 Mark Rylance 饰）一手建造了名为绿洲的虚拟现实游戏世界，临终前，他宣布自己在游戏中设置了一个彩蛋，找到这枚彩蛋的人即可成为绿洲的继承人。要找到这枚彩蛋，必须先获得三把钥匙，而寻找钥匙的线索就隐藏在詹姆斯的过往之中。 韦德（泰尔·谢里丹 Tye Sheridan 饰）、艾奇（丽娜·维特 Lena Waithe 饰）、大东（森崎温 饰）和修（赵家正 饰）是游戏中的好友，和之后遇见的阿尔忒弥斯（奥利维亚·库克 Olivia Cooke 饰）一起，五人踏上了寻找彩蛋的征程。他们所要对抗的，是名为诺兰索伦托（本·门德尔森 Ben Mendelsohn 饰）的大资本家。"
    },
    {
        "movie_id": "9",
        "movieName": "超时空同居",
        "date": "2018-05-18",
        "director": "苏伦",
        "actor": "雷佳音 / 佟丽娅",
        "type": "喜剧/爱情/奇幻",
        "country": "中国大陆",
        "language": "普通话",
        "picture": "image/chao.png",
        "average": "7.0",
        "describe": "生活在2018年的大龄女青年谷小焦（佟丽娅 饰），梦想能够嫁一个能买得起她幼时豪宅的有钱人，却屡屡受挫，只能蜗居在一栋老居民楼里。生活在1999年的陆鸣（雷佳音 饰）手握着自己设计的宏伟蓝图，却始终找不到投资人，同时也面临重大的事业危机。奇怪的时刻来临了，失意的两个人回到家中居然发生了惊人的一幕，同一扇门关上后居然是两个时空的交汇点，两个不同时空的人相遇了，为了拯救自己的未来，两人共商大计，开启了幻想一夜暴富的一系列措施，引发了啼笑皆非的连锁反应。而他们不知道的是，两个时空的重叠是人为的操控，他们每走一步都会引发不可预知的结果，更要命的事，本来只是视对方为赚钱拍档的两人引发了爱的火花……"
    },
    {
        "movie_id": "10",
        "movieName": "复仇者联盟3：无限战争",
        "date": "2018-05-11",
        "director": "安东尼·罗素 / 乔·罗素",
        "actor": "小罗伯特·唐尼 / 克里斯·海姆斯沃斯",
        "type": "动作/科幻/奇幻/冒险",
        "country": "美国",
        "language": "英语",
        "picture": "image/fu.png",
        "average": "8.2",
        "describe": "《复仇者联盟3：无限战争》是漫威电影宇宙10周年的历史性集结，将为影迷们带来史诗版的终极对决。面对灭霸突然发起的闪电袭击，复仇者联盟及其所有超级英雄盟友必须全力以赴，才能阻止他对全宇宙造成毁灭性的打击。"
    },
    {
        "movie_id": "11",
        "movieName": "红海行动",
        "date": "2018-02-16",
        "director": "林超贤",
        "actor": "张译 / 黄景瑜/海清",
        "type": "动作/战争",
        "country": "中国大陆",
        "language": "普通话",
        "picture": "image/hong.png",
        "average": "8.3",
        "describe": "中东国家伊维亚共和国发生政变，武装冲突不断升级。刚刚在索马里执行完解救人质任务的海军护卫舰临沂号，受命前往伊维亚执行撤侨任务。舰长高云（张涵予 饰）派出杨锐（张译 饰）率领的蛟龙突击队登陆战区，护送华侨安全撤离。谁知恐怖组织扎卡却将撤侨部队逼入交火区，一场激烈的战斗在所难免。与此同时，法籍华人记者夏楠（海清 饰）正在伊维亚追查威廉·柏森博士贩卖核原料的事实，而扎卡则突袭柏森博士所在的公司，意图抢走核原料。混战中，一名隶属柏森博士公司的中国员工成为人质。为了解救该人质，八名蛟龙队员必须潜入有150名恐怖分子的聚集点，他们用自己的信念和鲜血铸成中国军人顽强不屈的丰碑！"
    },
    {
        "movie_id": "12",
        "movieName": "战狼2",
        "date": "2017-07-27",
        "director": "吴京",
        "actor": "吴京/张翰/卢靖姗",
        "type": "动作",
        "country": "中国大陆",
        "language": "普通话",
        "picture": "image/zhan.png",
        "average": "7.1",
        "describe": "故事发生在非洲附近的大海上，主人公冷锋（吴京 饰）遭遇人生滑铁卢，被开除军籍，本想漂泊一生的他，正当他打算这么做的时候，一场突如其来的意外打破了他的计划，突然被卷入了一场非洲国家叛乱，本可以安全撤离，却因无法忘记曾经为军人的使命，孤身犯险冲回沦陷区，带领身陷屠杀中的同胞和难民，展开生死逃亡。随着斗争的持续，体内的狼性逐渐复苏，最终孤身闯入战乱区域，为同胞而战斗。"
    },
    {
        "movie_id": "13",
        "movieName": "寻梦环游记",
        "date": "2017-11-24",
        "director": "李·昂克里奇 / 阿德里安·莫利纳",
        "actor": "安东尼·冈萨雷斯",
        "type": "喜剧/动画/音乐/奇幻",
        "country": "美国",
        "language": "英语/西班牙语",
        "picture": "image/xun.png",
        "average": "9.0",
        "describe": "热爱音乐的米格尔（安东尼·冈萨雷兹 Anthony Gonzalez 配音）不幸地出生在一个视音乐为洪水猛兽的大家庭之中，一家人只盼着米格尔快快长大，好继承家里传承了数代的制鞋产业。一年一度的亡灵节即将来临，每逢这一天，去世的亲人们的魂魄便可凭借着摆在祭坛上的照片返回现世和生者团圆。 在一场意外中，米格尔竟然穿越到了亡灵国度之中，在太阳升起之前，他必须得到一位亲人的祝福，否则就将会永远地留在这个世界里。米格尔决定去寻找已故的歌神德拉库斯（本杰明·布拉特 Benjamin Bratt 配音），因为他很有可能就是自己的祖父。途中，米格尔邂逅了落魄乐手埃克托（盖尔·加西亚·贝纳尔 Gael García Bernal 配音），也渐渐发现了德拉库斯隐藏已久的秘密"
    },
    {
        "movie_id": "14",
        "movieName": "无问西东",
        "date": "2018-01-12",
        "director": "李芳芳",
        "actor": "章子怡/黄晓明/张震/王力宏",
        "type": "剧情/爱情/战争",
        "country": "中国大陆",
        "language": "普通话",
        "picture": "image/wu.png",
        "average": "7.6",
        "describe": "如果提前了解了你所要面对的人生，你是否还会有勇气前来？吴岭澜、沈光耀、王敏佳、陈鹏、张果果，几个年轻人满怀诸多渴望，在四个非同凡响的时空中一路前行。 吴岭澜（陈楚生 饰），出发时意气风发，却很快在途中迷失了方向。沈光耀（王力宏 饰），自愿参与了最残酷的战争，他一直在努力去做那些令他害怕，但重要的事。王敏佳（章子怡 饰）最初的错误，只是为了虚荣撒了一个小谎；最初的烦恼，只是在两个优秀的男人中选择一个。但命运，却把她拖入被众人唾骂的深渊。陈鹏（黄晓明 饰）把爱情摆在了理想前面，但爱情却没有把他摆在前面。他说，我有人要照顾，纵然这意味着与所有人作对，意味着要和她一起被放逐千里。张果果（张震 饰），身处尔虞我诈的职场，赢是他的习惯。为了赢，他总是见招拆招，先发制人。而有一天，他却面临了一个比“赢”更重要的选择。这几个年轻人，在最好的年纪迎来了最残酷的考验,并成就了永不褪色的青春传奇"
    },
    {
        "movie_id": "15",
        "movieName": "看不见的客人",
        "date": "2017-09-15",
        "director": "奥里奥尔·保罗",
        "actor": " 马里奥·卡萨斯 / 阿娜·瓦格纳 ",
        "type": "剧情/悬疑/惊悚/犯罪",
        "country": "西班牙",
        "language": "西班牙语",
        "picture": "image/kan.png",
        "average": "8.7",
        "describe": "艾德里安（马里奥·卡萨斯 Mario Casas 饰）经营着一间科技公司，事业蒸蒸日上，家中有美丽贤惠的妻子和活泼可爱的女儿，事业家庭双丰收的他是旁人羡慕的对象。然而，野心勃勃的艾德里安并未珍惜眼前来之不易的生活，一直以来，他和一位名叫劳拉（芭芭拉·蓝妮 Bárbara Lennie 饰）的女摄影师保持着肉体关系。 某日幽会过后，两人驱车离开别墅，却在路上发生了车祸，为了掩盖事件的真相，两人决定将在车祸中死去的青年丹尼尔联同他的车一起沉入湖底。之后，劳拉遇见了一位善良的老人，老人将劳拉坏掉的车拉回家中修理，然而，令劳拉没有想到的是，这位老人，竟然就是丹尼尔的父亲。"
    },
    {
        "movie_id": "16",
        "movieName": "天才枪手",
        "date": "2017-10-13",
        "director": "纳塔吾·彭皮里亚",
        "actor": "茱蒂蒙·琼查容苏因 / 查侬·散顶腾古",
        "type": "剧情/悬疑/犯罪",
        "country": "泰国",
        "language": "泰语/英语",
        "picture": "image/tian.png",
        "average": "8.1",
        "describe": "影片根据2014年轰动一时的亚洲考场作弊案改编，讲述了天才学霸利用高智商考场作弊牟取暴利的故事。出生平凡的天才少女Lynn（茱蒂蒙·琼查容苏因 饰）在进入贵族学校后，结识了富二代同学Grace（依莎亚·贺苏汪饰）与Pat（披纳若·苏潘平佑饰），从此开始了考场作弊生涯，与此同时，另一名记忆力极佳的天才学霸Bank（查侬·散顶腾古 饰）发现了Lynn不为人知的交易。经过多场险象环生的作弊战争后，Lynn接下最后一单在国际考场上为富家子弟作弊的天价委托。一场横跨两大洲的完美作弊方案横空出世，然而一切并不像他们想的那么简单……"
    },
    {
        "movie_id": "17",
        "movieName": "唐人街探案2",
        "date": "2018-02-16",
        "director": "陈思诚",
        "actor": "王宝强 / 刘昊然 ",
        "type": "喜剧/动作/悬疑/犯罪",
        "country": "中国大陆",
        "language": "普通话",
        "picture": "image/tang.png",
        "average": "6.7",
        "describe": "唐仁（王宝强 饰）为巨额奖金欺骗秦风（刘昊然 饰）到纽约参加世界名侦探大赛，然而随着和世界各国侦探们啼笑皆非的较量，两人却发现了隐藏在这次挑战背后的更大秘密..."
    },
    {
        "movie_id": "18",
        "movieName": "环太平洋：雷霆再起",
        "date": "2018-03-23",
        "director": "斯蒂文·S·迪奈特",
        "actor": "约翰·博耶加 / 斯科特·伊斯特伍德",
        "type": "动作/科幻/冒险",
        "country": "美国/中国大陆",
        "language": "英语",
        "picture": "image/huan.png",
        "average": "5.5",
        "describe": "在对抗外星人的入侵并成功封住虫洞的十年后，人类从废墟中站起来。他们忘记了恐惧，纵情狂欢，其中便包括斯特克·潘特考斯特将军的儿子杰克（约翰·博耶加 John Boyega 饰）。在一次偷到废弃机甲零件的过程中，他偶然遭遇以一己之力组装迷你机甲的少女阿玛拉（卡莉·史派妮 Cailee Spaeny 饰）。此后，在姐姐森麻子（菊地凛子 饰）的安排下，杰克和阿玛拉莫玉兰基地接受机甲驾驶员的培训工作。与此同时，总部位于上海的邵氏集团，在总裁邵丽雯（景甜 饰）的主持下，正致力于以无人机甲取代传统机甲。就在这关键时刻，一个与复仇流浪者极其相似的黑色机甲突然出现，并向人类展开了无情杀戮。 人们发现，遥远的外星先驱仍在蠢蠢欲动，时刻等待着消灭地球人的时机……"
    },
    {
        "movie_id": "19",
        "movieName": "帕丁顿熊2",
        "date": "2017-12-08",
        "director": "保罗·金",
        "actor": " 本·卫肖 / 休·格兰特",
        "type": "喜剧/动画/家庭",
        "country": "英国/法国/美国",
        "language": "英语",
        "picture": "image/pa.png",
        "average": "8.1",
        "describe": "露西婶婶（伊梅尔达·斯汤顿 Imelda Staunton 配音）的生日即将到来，帕丁顿（本·威士肖 Ben Whishaw 配音）决定送婶婶一份会让她终生难忘的礼物。最终，帕丁顿选中了一本立体绘本，然而这绘本是世间仅此一份的珍贵宝物，为了存钱购买绘本，帕丁顿决定开始工作，在遭遇了一连串的失败后，帕丁顿终于找到了适合他的工作——清洁玻璃窗。 就在帕丁顿的存款即将达标之际，绘本竟然被一名神出鬼没的小偷给偷走了，同时出现在案发现场的帕丁顿被当做嫌疑犯捉拿归案，并最终被关进了监狱。在监狱里，帕丁顿凭借着自己的爱与勇气改变了墙内死气沉沉的氛围，监狱外，布朗一家人亦从来没有放弃过替帕丁顿洗清冤屈的机会。"
    },
    {
        "movie_id": "20",
        "movieName": "黑豹",
        "date": "2018-03-09",
        "director": "瑞恩·库格勒",
        "actor": "查德维克·博斯曼 / 露皮塔·尼永奥",
        "type": "动作/科幻/冒险",
        "country": "美国",
        "language": "英语",
        "picture": "image/hei.png",
        "average": "6.4",
        "describe": "在漫威影业的影片《黑豹》中，特查拉在其父亲——前瓦坎达国王去世之后，回到了这个科技先进但与世隔绝的非洲国家，继任成为新一任黑豹及国王。当旧敌重现时，作为黑豹及国王的特查拉身陷两难境地，眼看着瓦坎达及全世界陷于危难之中。面对背叛与危险，这位年轻的国王必须联合同盟， 释放黑豹全部力量，奋力捍卫他的人民和国土。"
    }
]