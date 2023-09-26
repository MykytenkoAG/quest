<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script type="module" src="js/index.js"></script>

<audio src="../resources/audio/lose.mp3" id="audioLose"></audio>
<audio src="../resources/audio/victory.mp3" id="audioVictory"></audio>

<!-- Модальное окно с предысторией квеста -->
<div class="modal fade" id="prologueModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle"></h5>
                <button type="button" class="close btn-modal-prologue-close" data-dismiss="modal" aria-label="Close">
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
                <button type="button" class="btn btn-secondary btn-modal-prologue-close" data-dismiss="modal">Закрыть</button>
            </div>
        </div>
    </div>
</div>

<!-- ПОБЕДА -->
<div class="modal fade" id="victoryModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">ПОБЕДА</h5>
                <button type="button" class="close btn-modal-victory-close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body fs-5">
                <img src="../resources/img/victory/victory.gif" width="100%">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary btn-modal-victory-close" data-dismiss="modal">Закрыть</button>
            </div>
        </div>
    </div>
</div>

<!-- ПОРАЖЕНИЕ -->
<div class="modal fade" id="loseModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">ПОРАЖЕНИЕ</h5>
                <button type="button" class="close btn-modal-lose-close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body fs-5">
                <img src="../resources/img/lose/lose.gif" width="100%">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary btn-modal-lose-close" data-dismiss="modal">Закрыть</button>
            </div>
        </div>
    </div>
</div>
