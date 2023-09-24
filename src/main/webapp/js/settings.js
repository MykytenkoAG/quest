import {getCookie, deleteCookie, setCookie} from "../js/cookies.js";

//  Разблокировка кнопок для загрузки файлов и изменения имени игрока
$("body").on('input', "#newPrologueFile", function() {
    $("#btn-upload-prologue-file").prop("disabled", false);
});
$("body").on('input', "#newQuestFile", function() {
    $("#btn-upload-quest-file").prop("disabled", false);
});
$("body").on('input', "#newBackgroundImg", function() {
    $("#btn-upload-background-img").prop("disabled", false);
});
$("body").on('input', "#player_name", function() {

    let pattern = new RegExp(/^[a-zA-Zа-яА-Я']{1,15}$/);
    let player_name = document.getElementById("player_name");

    if (pattern.test(player_name.value)) {
        player_name.setAttribute("style", "font-weight: nomal; background-color: white; color:black;");
        $("#btn-change-player-name").prop("disabled", false);
    } else {
        player_name.setAttribute("style", "font-weight: bold; background-color: pink; color:red;");
        $("#btn-change-player-name").prop("disabled", true);
    }

});


window.addEventListener("load", (event) => {
    if(getCookie("questTreeFileError")=="true"){
        deleteCookie("questTreeFileError");
        $("#modalError").modal("show");
    }
    if(getCookie("infoQuestFileOK")=="true"){
        deleteCookie("infoQuestFileOK");
        $('#modal-info-message').append("Файл квеста успешно обновлен. Приятной игры");
        $("#modalInfo").modal("show");
    }
    if(getCookie("infoPrologueFileOK")=="true"){
        deleteCookie("infoPrologueFileOK");
        $('#modal-info-message').append("Файл предыстории квеста успешно обновлен");
        $("#modalInfo").modal("show");
    }
    if(getCookie("infoBgImgOK")=="true"){
        deleteCookie("infoBgImgOK");
        $('#modal-info-message').append("Фоновый рисунок квеста успешно обновлен");
        $("#modalInfo").modal("show");
    }
    if(getCookie("infoPlayerNameChanged")=="true"){
        deleteCookie("infoPlayerNameChanged");
        $('#modal-info-message').append("Имя пользователя успешно изменено");
        $("#modalInfo").modal("show");
    }
    if(getCookie("infoGamesCounterWasReset")=="true"){
        deleteCookie("infoGamesCounterWasReset");
        $('#modal-info-message').append("Счетчик игр успешно сброшен");
        $("#modalInfo").modal("show");
    }
});

$("body").on('click', ".btn-close-modal-file-incorrect-format", function() {
    $("#modalError").modal("hide");
})

$("body").on('click', ".btn-close-modal-info", function() {
    $("#modalInfo").modal("hide");
})
