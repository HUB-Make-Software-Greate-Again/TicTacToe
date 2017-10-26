var value = true;
var playerOne = "X";
var playerTwo = "O";

$(".button").on('click', function(e){
    var my_x = this.attributes.x.value;
    var my_y = this.attributes.y.value;

    this.innerHTML = player();
    value = !value;

    $.post("/game", {
        x: my_x,
        y: my_y
    }).done(function(response){
        console.log(response);
    }).fail(function(response){
        console.log(response);
    });

    $(this).removeClass("field").off("click").off("mouseover").off("mouseout");
});

$(".field").on("mouseover", function(e){
    this.innerHTML = player();
});

$(".field").on("mouseout", function(e){
    this.innerHTML = "";
});

$("#reset").on("click", function(e){
    e.preventDefault();

    $.post("/reset").done(function(res){
        console.log("reset");
    }).fail(function(res){
        console.log("fail");
    });
})

function player(){
    return value ? playerOne : playerTwo;
}