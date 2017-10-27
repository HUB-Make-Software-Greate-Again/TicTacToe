var value = true;
var playerOne = "X";
var playerTwo = "O";

$(document).ready(function() {
    $.post("/reset", function() {
        console.log("reseting");
    });
    startGame();
    $('#newGame').click(resetGame);
});

function player() {
    return value ? playerOne : playerTwo;
}

function endGame() {
    $(".button").off('click');
    $(".field").off('mouseover').off('mouseout').removeClass('field');
    $("td").removeClass("button field").text("");
}

function startGame() {
    value = true;

    $("td").addClass("button field");
    $(".button").on('click', function(e) {
        var my_x = this.attributes.x.value;
        var my_y = this.attributes.y.value;
        $.post("/game", {
            x: my_x,
            y: my_y
        }).then(function(response) {
            this.innerHTML = player();
            value = !value;
            if (response.hasOwnProperty("winner")) {
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
                infoScreen(winner);
            }
        }).fail(function(response) {

        });

        $(this).removeClass("field").off("click").off("mouseover").off("mouseout");
    });

    $(".field").on("mouseover", function(e) {
        this.innerHTML = player();
    });

    $(".field").on("mouseout", function(e) {
        this.innerHTML = "";
    });
}


function resetGame() {
    infoScreen();
    $.post("/reset").done(function(res) {
        var $tdList = $('td.button.field');
        $tdList.each(function(td) {
            var $td = $(td);
            $td.text('');
        });
    }).fail(function(res) {
        console.log(res);
    })
    startGame();
}

function infoScreen(text) {
    var $info = $('#information');
    var $board = $('#board');
    if (text) {
        $info.removeClass("hidden");
        $board.addClass("hidden");
    } else {
        $info.addClass("hidden");
        $board.removeClass("hidden");
    }
    $info.find('p').text(text);
}