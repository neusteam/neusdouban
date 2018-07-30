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

    _prime(".index-content")[0].addEventListener("click", (e) => {
        if (e.target.nodeName == "IMG") {
            _prime(".alert-box")[0].setAttribute("style", "background-color:rgba(0, 0, 0, .5);z-index:1");
            _prime(".alert-content")[0].setAttribute("style", "opacity:1;z-index:1");

            initModalContent(1);
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

    for (var i = movieData.length - 1; i >= 0; i--) {
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
        imageNode.setAttribute("movieid", movieData[i].movie_id);

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

    for (var i = liArray.length - 1; i >= 0; i--) {
        _prime(".index-movies-silders")[0].appendChild(liArray[i]);
    }
}


const initModalContent = (movieId)=>{
    let h1Node = getDomElement("h1", "", movieData[movieId].movieName + " " + movieData[movieId].type),
        imgNode = getDomElement("img", "", "./" + movieData[movieId].picture),
        directorPNode = getDomElement("p", "", "导演 ： " + movieData[movieId].director),
        actorPNode = getDomElement("p", "", "演员 ： " + movieData[movieId].actor),
        typePNode = getDomElement("p", "", "类型 ： " + movieData[movieId].type),
        datePNode = getDomElement("p", "", "日期 ： " + movieData[movieId].date),
        countryPNode = getDomElement("p", "", "地区 ： " + movieData[movieId].country),
        lanPNode = getDomElement("p", "", "语言 ： " + movieData[movieId].language),
        scoreSpanNode = getDomElement("span","score", movieData[movieId].average + "分"),
        scorePNode = getDomElement("p", "", "评分 ： ");

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
        "describe": ""
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
        "describe": ""
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
        "describe": ""
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
        "describe": ""
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
        "describe": ""
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
        "describe": ""
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
        "describe": ""
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
        "describe": ""
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
        "describe": ""
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
        "describe": ""
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
        "describe": ""
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
        "describe": ""
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
        "describe": ""
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
        "describe": ""
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
        "describe": ""
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
        "describe": ""
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
        "describe": ""
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
        "describe": "null"
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
        "describe": "null"
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
        "describe": "null"
    }
]