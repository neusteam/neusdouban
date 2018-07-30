window.addEventListener('load', () => {
    ajax({
        type: "post",
        url: "http://172.20.10.3:8080/neusoft/ShowMovie",
        timeOut: 5000,
        data: ,
        before: function() {
            console.log("before");
        },
        success: function(str) {
            console.log(str);
        },
        error: function() {
            console.log("error");
        }
    })
})