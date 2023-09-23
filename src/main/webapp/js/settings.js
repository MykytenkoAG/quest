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


function download(url) {
    const a = document.createElement('a')
    a.href = url
    a.download = url.split('/').pop()
    document.body.appendChild(a)
    a.click()
    document.body.removeChild(a)
}

window.addEventListener("load", (event) => {
    if(getCookie("questTreeFileError")=="true"){
        deleteCookie("questTreeFileError");
        $("#modalError").modal("show");
    }
});

function modalClose(){
    $("#modalError").modal("hide")
}
