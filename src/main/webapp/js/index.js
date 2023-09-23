import {getCookie, deleteCookie, setCookie} from "../js/cookies.js";

window.addEventListener("load", (event) => {

    $.ajax({
        url: '/formPrologueFile',
        type: 'GET',
        contentType: 'text/plain; charset=UTF-8;',
        async: false,
        success:  function(result) {
            document.getElementById("prologueText").append(result.toString());
            if(getCookie("newQuest")=="true"){
                deleteCookie("newQuest");
                setCookie("fromModal","true");
                $("#prologueModal").modal("show");
            }
            if(getCookie("victory")=="true"){
                deleteCookie("victory");
                $("#victoryModal").modal("show");
                $("#audioVictory").trigger("play");
            }
            if(getCookie("lose")=="true"){
                deleteCookie("lose");
                $("#loseModal").modal("show");
                $("#audioLose").prop("loop","true");
                $("#audioLose").trigger("play");
            }
        }
    });
});

$("body").on('input', "#player_name", function() {

    let pattern = new RegExp(/^[a-zA-Zа-яА-Я']{1,15}$/);
    let player_name = document.getElementById("player_name");

    if (pattern.test(player_name.value)) {
    player_name.setAttribute("style", "font-weight: nomal; background-color: white; color:black;");
    $("#btn-save-player-name").prop("disabled", false);
} else {
    player_name.setAttribute("style", "font-weight: bold; background-color: pink; color:red;");
    $("#btn-save-player-name").prop("disabled", true);
}

});


$("body").on('click', ".btn-modal-prologue-close", function() {
    $("#prologueModal").modal("hide");
    deleteCookie("fromModal");
})

$("body").on('click', ".btn-modal-victory-close", function() {
    $("#victoryModal").modal("hide");
})

$("body").on('click', ".btn-modal-lose-close", function() {
    $("#audioLose").prop("loop","false");
    $("#audioLose").trigger("pause");
    $("#loseModal").modal("hide");
})

function restart() {
    $.ajax({
        url: '/restart',
        type: 'POST',
        contentType: 'application/json;charset=UTF-8',
        async: false,
        success: function () {
            location.reload();
        }
    });
}
