<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Страница настроек</title>
    <link href="static/main.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
    <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
    <meta http-equiv="cache-control" content="max-age=0" />
    <meta http-equiv="Pragma" content="no-cache" />
    <meta http-equiv="Expires" content="0" />
</head>
<body>

<div class="row" style="margin-top: 10px; margin-right: 0px; margin-left: 0px;">
    <div class="col-6">
    </div>
    <div class="col-6 d-flex justify-content-end">
        <button type="button" class="btn btn-primary" onclick="window.location='index.jsp'">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-controller" viewBox="0 0 16 16">
                <path d="M11.5 6.027a.5.5 0 1 1-1 0 .5.5 0 0 1 1 0zm-1.5 1.5a.5.5 0 1 0 0-1 .5.5 0 0 0 0 1zm2.5-.5a.5.5 0 1 1-1 0 .5.5 0 0 1 1 0zm-1.5 1.5a.5.5 0 1 0 0-1 .5.5 0 0 0 0 1zm-6.5-3h1v1h1v1h-1v1h-1v-1h-1v-1h1v-1z"/>
                <path d="M3.051 3.26a.5.5 0 0 1 .354-.613l1.932-.518a.5.5 0 0 1 .62.39c.655-.079 1.35-.117 2.043-.117.72 0 1.443.041 2.12.126a.5.5 0 0 1 .622-.399l1.932.518a.5.5 0 0 1 .306.729c.14.09.266.19.373.297.408.408.78 1.05 1.095 1.772.32.733.599 1.591.805 2.466.206.875.34 1.78.364 2.606.024.816-.059 1.602-.328 2.21a1.42 1.42 0 0 1-1.445.83c-.636-.067-1.115-.394-1.513-.773-.245-.232-.496-.526-.739-.808-.126-.148-.25-.292-.368-.423-.728-.804-1.597-1.527-3.224-1.527-1.627 0-2.496.723-3.224 1.527-.119.131-.242.275-.368.423-.243.282-.494.575-.739.808-.398.38-.877.706-1.513.773a1.42 1.42 0 0 1-1.445-.83c-.27-.608-.352-1.395-.329-2.21.024-.826.16-1.73.365-2.606.206-.875.486-1.733.805-2.466.315-.722.687-1.364 1.094-1.772a2.34 2.34 0 0 1 .433-.335.504.504 0 0 1-.028-.079zm2.036.412c-.877.185-1.469.443-1.733.708-.276.276-.587.783-.885 1.465a13.748 13.748 0 0 0-.748 2.295 12.351 12.351 0 0 0-.339 2.406c-.022.755.062 1.368.243 1.776a.42.42 0 0 0 .426.24c.327-.034.61-.199.929-.502.212-.202.4-.423.615-.674.133-.156.276-.323.44-.504C4.861 9.969 5.978 9.027 8 9.027s3.139.942 3.965 1.855c.164.181.307.348.44.504.214.251.403.472.615.674.318.303.601.468.929.503a.42.42 0 0 0 .426-.241c.18-.408.265-1.02.243-1.776a12.354 12.354 0 0 0-.339-2.406 13.753 13.753 0 0 0-.748-2.295c-.298-.682-.61-1.19-.885-1.465-.264-.265-.856-.523-1.733-.708-.85-.179-1.877-.27-2.913-.27-1.036 0-2.063.091-2.913.27z"/>
            </svg>
        </button>
    </div>
</div>

<%@ include file='jsp/modalsSettings.jsp' %>

<div class="container text-left mt-5">
    <div class="col-md-12 col-xl-8" style="margin-left: auto; margin-right: auto">
        <table class="table text-left">
            <tbody>
                <tr>
                    <td class="fs-5 mt-1 mb-1" colspan="2">
                        <form method="get" action="/downloadExample">
                            <button type="submit" class="btn btn-primary" style="width: 100%;">
                                Скачать текущий файл квеста
                            </button>
                        </form>
                    </td>
                    <td class="fs-5 mt-1 mb-1" colspan="2">
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter" style="width: 100%;">
                            Ознакомиться с инструкцией по составлению файла
                        </button>
                    </td>
                </tr>
                <tr>
                    <form method="post" action="/formQuestFile" enctype="multipart/form-data">
                        <td class="fs-5 mt-1 mb-1" colspan="2">Загрузить новый файл квеста</td>
                        <td class="fs-5 mt-1 mb-1">
                            <input class="form-control" name="newQuestFile" type="file" id="newQuestFile">
                        </td>
                        <td class="fs-5 mt-1 mb-1">
                            <button type="submit" value="Upload" class="btn btn-primary" id="btn-upload-quest-file" disabled>
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-floppy2-fill" viewBox="0 0 16 16">
                                    <path d="M12 2h-2v3h2V2Z"/>
                                    <path d="M1.5 0A1.5 1.5 0 0 0 0 1.5v13A1.5 1.5 0 0 0 1.5 16h13a1.5 1.5 0 0 0 1.5-1.5V2.914a1.5 1.5 0 0 0-.44-1.06L14.147.439A1.5 1.5 0 0 0 13.086 0H1.5ZM4 6a1 1 0 0 1-1-1V1h10v4a1 1 0 0 1-1 1H4ZM3 9h10a1 1 0 0 1 1 1v5H2v-5a1 1 0 0 1 1-1Z"/>
                                </svg>
                            </button>
                        </td>
                    </form>
                </tr>
                <tr>
                    <form method="post" action="/formPrologueFile" enctype="multipart/form-data">
                        <td class="fs-5 mt-1 mb-1" colspan="2">Загрузить новый файл предыстории</td>
                        <td class="fs-5 mt-1 mb-1">
                            <input class="form-control" name="newPrologueFile" type="file" id="newPrologueFile">
                        </td>
                        <td class="fs-5 mt-1 mb-1">
                            <button type="submit" value="Upload" class="btn btn-primary" id="btn-upload-prologue-file" disabled>
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-floppy2-fill" viewBox="0 0 16 16">
                                    <path d="M12 2h-2v3h2V2Z"/>
                                    <path d="M1.5 0A1.5 1.5 0 0 0 0 1.5v13A1.5 1.5 0 0 0 1.5 16h13a1.5 1.5 0 0 0 1.5-1.5V2.914a1.5 1.5 0 0 0-.44-1.06L14.147.439A1.5 1.5 0 0 0 13.086 0H1.5ZM4 6a1 1 0 0 1-1-1V1h10v4a1 1 0 0 1-1 1H4ZM3 9h10a1 1 0 0 1 1 1v5H2v-5a1 1 0 0 1 1-1Z"/>
                                </svg>
                            </button>
                        </td>
                    </form>
                </tr>
                <tr>
                    <form method="post" action="/formBackgroundImg" enctype="multipart/form-data">
                        <td class="fs-5 mt-1 mb-1" colspan="2">Загрузить новый фоновый рисунок</td>
                        <td class="fs-5 mt-1 mb-1">
                            <input class="form-control" name="newBackgroundImg" type="file" id="newBackgroundImg">
                        </td>
                        <td class="fs-5 mt-1 mb-1">
                            <button type="submit" value="Upload" class="btn btn-primary" id="btn-upload-background-img" disabled>
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-floppy2-fill" viewBox="0 0 16 16">
                                    <path d="M12 2h-2v3h2V2Z"/>
                                    <path d="M1.5 0A1.5 1.5 0 0 0 0 1.5v13A1.5 1.5 0 0 0 1.5 16h13a1.5 1.5 0 0 0 1.5-1.5V2.914a1.5 1.5 0 0 0-.44-1.06L14.147.439A1.5 1.5 0 0 0 13.086 0H1.5ZM4 6a1 1 0 0 1-1-1V1h10v4a1 1 0 0 1-1 1H4ZM3 9h10a1 1 0 0 1 1 1v5H2v-5a1 1 0 0 1 1-1Z"/>
                                </svg>
                            </button>
                        </td>
                    </form>
                </tr>
                <tr>
                    <form method="post" action="/formPlayerName">
                        <td class="fs-5 mt-1 mb-1" colspan="2">Имя игрока</td>
                        <td class="fs-5 mt-1 mb-1">
                            <input type="text" id="player_name" name="player_name" class="form-control" aria-describedby="passwordHelpBlock">
                        </td>
                        <td class="fs-5 mt-1 mb-1">
                            <button type="submit" class="btn btn-primary" id="btn-change-player-name" disabled>
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-floppy2-fill" viewBox="0 0 16 16">
                                    <path d="M12 2h-2v3h2V2Z"/>
                                    <path d="M1.5 0A1.5 1.5 0 0 0 0 1.5v13A1.5 1.5 0 0 0 1.5 16h13a1.5 1.5 0 0 0 1.5-1.5V2.914a1.5 1.5 0 0 0-.44-1.06L14.147.439A1.5 1.5 0 0 0 13.086 0H1.5ZM4 6a1 1 0 0 1-1-1V1h10v4a1 1 0 0 1-1 1H4ZM3 9h10a1 1 0 0 1 1 1v5H2v-5a1 1 0 0 1 1-1Z"/>
                                </svg>
                            </button>
                        </td>
                    </form>
                </tr>
                <tr>
                    <td class="fs-5 mt-1 mb-1" colspan="2">
                        <form method="post" action="/clearGamesCount">
                            <button type="submit" class="btn btn-primary" style="width: 100%;">
                                Обнулить количество игр
                            </button>
                        </form>
                    </td>
                    <td class="fs-5 mt-1 mb-1" colspan="2"></td>
                </tr>
            </tbody>
        </table>
    </div>
</div>

<script type="module" src="js/settings.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</body>
</html>