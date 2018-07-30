window.addEventListener('load', () => {
    ajax({
        type: "post",
        url: "localhost:8080/neusoft/ShowMovie",
        timeOut: 5000,
        contentType: "application/json;charset=UTF-8",
        data: JSON.stringify({
            count: 5
        }),
        before: function() {
            console.log("before");
        },
        success: function(str) {
            initIndexContentItems(str)
        },
        error: function() {
            console.log("error");
        }
    })

    initIndexContentItems(data)
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
            scoreLiNode = getDomElement("li", "",""),
            scoreSpanNode = getDomElement("span", "score", movieData[i].average + "分"),
            buttonLiNode = getDomElement("li", "", ""),
            buttonNode = getDomElement("button","purchase","选座购票");

        imageNode.setAttribute("src", "./" + movieData[i].picture)
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