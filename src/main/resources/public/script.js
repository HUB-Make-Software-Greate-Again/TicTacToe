var value = true;
var playerOne = "X";
var playerTwo = "O";

function player(){
    return value ? playerOne : playerTwo;
}

function endGame(){
    $(".button").off('click');
    $(".field").off('mouseover').off('mouseout').removeClass('field');
    $("td").removeClass("button field").text("");
}

function startGame(){
    value = true;
    $("td").addClass("button field");
    $(".button").on('click', function(e){
        var my_x = this.attributes.x.value;
        var my_y = this.attributes.y.value;
        
        $.post("/game", {
            x: my_x,
            y: my_y
        }).done(function(response){
            this.innerHTML = player();
            value = !value;
            if (response.hasOwnProperty("winner")){
                endGame();
                var winner = "winner is: ";
                switch (response.winner) {
                    case 0:
                        winner = "Draw";
                        break;
                    case 1:
                        winner += playerOne;
                        break;
                    case 2:
                        winner += playerTwo;
                        break;
                    default:
                        winner = "Unknown gameover state";
                        break;
                }
                alert(winner);
                startGame();
            }
        }).fail(function(response){

        });
    
        $(this).removeClass("field").off("click").off("mouseover").off("mouseout");
    });

    $(".field").on("mouseover", function(e){
        this.innerHTML = player();
    });
    
    $(".field").on("mouseout", function(e){
        this.innerHTML = "";
    });
}

startGame();

$(window).on('load', function(){    
    $.post("/reset").done(function(res){
        console.log("reset");
    }).fail(function(res){
        console.log("fail");
    });
});
