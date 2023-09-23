<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
    <title>Quest</title>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
    <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
    <meta http-equiv="cache-control" content="max-age=0" />
    <meta http-equiv="Pragma" content="no-cache" />
    <meta http-equiv="Expires" content="0" />
</head>
<body>

<!-- Modal Prologue -->
<div class="modal fade" id="prologueModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle"></h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="modalClose()">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body fs-5" id="prologueText">

            </div>
                <table>
                    <form method="post" action="/formPlayerName">
                        <td class="fs-5 mt-1 mb-1">
                            <input type="text" id="player_name" name="player_name" class="form-control" aria-describedby="passwordHelpBlock">
                        </td>
                        <td class="fs-5 mt-1 mb-1">
                            <button type="submit" class="btn btn-primary" id="btn-save-player-name" disabled>
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-floppy2-fill" viewBox="0 0 16 16">
                                    <path d="M12 2h-2v3h2V2Z"/>
                                    <path d="M1.5 0A1.5 1.5 0 0 0 0 1.5v13A1.5 1.5 0 0 0 1.5 16h13a1.5 1.5 0 0 0 1.5-1.5V2.914a1.5 1.5 0 0 0-.44-1.06L14.147.439A1.5 1.5 0 0 0 13.086 0H1.5ZM4 6a1 1 0 0 1-1-1V1h10v4a1 1 0 0 1-1 1H4ZM3 9h10a1 1 0 0 1 1 1v5H2v-5a1 1 0 0 1 1-1Z"/>
                                </svg>
                            </button>
                        </td>
                    </form>
                </table>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal" onclick="modalClose()">Закрыть</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="victoryModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">ПОБЕДА</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="modalVictoryClose()">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body fs-5">
                <img src="img/victory/135067.gif" width="100%">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal" onclick="modalVictoryClose()">Закрыть</button>
            </div>
        </div>
    </div>
</div>


<div class="modal fade" id="loseModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">ПОРАЖЕНИЕ</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="modalLoseClose()">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body fs-5">
                <img src="img/lose/haha.gif" width="100%">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal" onclick="modalLoseClose()">Закрыть</button>
            </div>
        </div>
    </div>
</div>

<div class="row" style="margin-top: 10px; margin-right: 0px; margin-left: 0px;">
    <div class="col-6">
        <button type="button" class="btn btn-primary" onclick="window.location='/start'">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-counterclockwise" viewBox="0 0 16 16">
                <path fill-rule="evenodd" d="M8 3a5 5 0 1 1-4.546 2.914.5.5 0 0 0-.908-.417A6 6 0 1 0 8 2v1z"/>
                <path d="M8 4.466V.534a.25.25 0 0 0-.41-.192L5.23 2.308a.25.25 0 0 0 0 .384l2.36 1.966A.25.25 0 0 0 8 4.466z"/>
            </svg>
        </button>
    </div>
    <div class="col-6 d-flex justify-content-end">
        <button type="button" class="btn btn-primary" onclick="document.location='settings.jsp'">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-gear-fill" viewBox="0 0 16 16">
                <path d="M9.405 1.05c-.413-1.4-2.397-1.4-2.81 0l-.1.34a1.464 1.464 0 0 1-2.105.872l-.31-.17c-1.283-.698-2.686.705-1.987 1.987l.169.311c.446.82.023 1.841-.872 2.105l-.34.1c-1.4.413-1.4 2.397 0 2.81l.34.1a1.464 1.464 0 0 1 .872 2.105l-.17.31c-.698 1.283.705 2.686 1.987 1.987l.311-.169a1.464 1.464 0 0 1 2.105.872l.1.34c.413 1.4 2.397 1.4 2.81 0l.1-.34a1.464 1.464 0 0 1 2.105-.872l.31.17c1.283.698 2.686-.705 1.987-1.987l-.169-.311a1.464 1.464 0 0 1 .872-2.105l.34-.1c1.4-.413 1.4-2.397 0-2.81l-.34-.1a1.464 1.464 0 0 1-.872-2.105l.17-.31c.698-1.283-.705-2.686-1.987-1.987l-.311.169a1.464 1.464 0 0 1-2.105-.872l-.1-.34zM8 10.93a2.929 2.929 0 1 1 0-5.86 2.929 2.929 0 0 1 0 5.858z"/>
            </svg>
        </button>
    </div>
</div>

<div class="container text-center mt-5">
    <div class="col-12 text-center fs-2 mt-2 mb-2">
        <img src="img/background/background.jpg" height="300px">
    </div>
</div>

<div class="container text-center mt-5">
    <div class="col-12 text-center fs-2 mt-2 mb-2">
        ${questTree.getQuestion()}
    </div>
    <div class="row">
        <div class="col-6">
            <button type="button" class="btn col-8 btn-primary" onclick="window.location='/logic?button=1'" style="${button1Visibility}">
                ${button1Text}
            </button>
        </div>
        <div class="col-6">
            <button type="button" class="btn col-8 btn-primary" onclick="window.location='/logic?button=2'" style="${button2Visibility}">
                ${button2Text}
            </button>
        </div>
    </div>
</div>

<div class="col-4 position-absolute bottom-0 start-0 mt-0 mb-0 p-0">
    <table class="table text-left">
        <tbody>
            <tr>
                <td class="fs-5 mt-1 mb-1" colspan="2">Статистика:</td>
            </tr>
            <tr>
                <td class="fs-5 mt-1 mb-1">IP-address:</td>
                <td class="fs-5 mt-1 mb-1">${remoteAddr}</td>
            </tr>
            <tr>
                <td class="fs-5 mt-1 mb-1">Имя в игре:</td>
                <td class="fs-5 mt-1 mb-1">${playerName}</td>
            </tr>
            <tr>
                <td class="fs-5 mt-1 mb-1">Количество игр:</td>
                <td class="fs-5 mt-1 mb-1">${gamesCount}</td>
            </tr>
        </tbody>
    </table>
</div>

<script>

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
                }
                if(getCookie("lose")=="true"){
                    deleteCookie("lose");
                    $("#loseModal").modal("show");
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

    function modalClose(){

        $("#prologueModal").modal("hide")
        deleteCookie("fromModal");
    }


    function modalVictoryClose(){

        $("#victoryModal").modal("hide");
    }


    function modalLoseClose(){

        $("#loseModal").modal("hide");
    }

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

    function getCookie(name) {
        let matches = document.cookie.match(new RegExp(
            "(?:^|; )" + name.replace(/([\.$?*|{}\(\)\[\]\\\/\+^])/g, '\\$1') + "=([^;]*)"
        ));
        return matches ? decodeURIComponent(matches[1]) : undefined;
    }

    function setCookie(name, value, options = {}) {

        options = {
            path: '/',
            ...options
        };

        if (options.expires instanceof Date) {
            options.expires = options.expires.toUTCString();
        }

        let updatedCookie = encodeURIComponent(name) + "=" + encodeURIComponent(value);

        for (let optionKey in options) {
            updatedCookie += "; " + optionKey;
            let optionValue = options[optionKey];
            if (optionValue !== true) {
                updatedCookie += "=" + optionValue;
            }
        }

        document.cookie = updatedCookie;
    }

    function deleteCookie(name) {
        setCookie(name, "", {
            'max-age': -1
        })
    }

</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>


</body>
</html>