var value = true;

$(".button").on('click', function(e){
    document.getElementById(this.id).removeEventListener("click", setValue, false);

    var my_x = this.attributes.x.value;
    var my_y = this.attributes.y.value;
    var winner;

    $.post("/game", {
        x: my_x,
        y: my_y
    }).done(function(response){
        console.log(response);

    }).fail(function(response){
        console.log(response);
    })
});

$(".button").on("mouseover", function(e){
    console.log("hovering");
});

$(".button").on("mouseout", function(e){
    console.log("Exiting");
});

$("#reset").on("click", function(e){
    e.preventDefault();

    $.post("/reset").done(function(res){
        console.log("reset");
    }).fail(function(res){
        console.log("fail");
    });
})

function setValue(buttonID) {
    if(!document.getElementById(buttonID).classList.contains("clicked")){
        if(value){
            document.getElementById(buttonID).innerHTML = "X";
            value = false;
        }
        else{
            document.getElementById(buttonID).innerHTML = "O";
            value = true;
        }
        document.getElementById(buttonID).classList.add("clicked");
    }
}