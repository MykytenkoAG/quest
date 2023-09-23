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

<%@ include file='jsp/modalsIndex.jsp' %>

<%--buttons--%>
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

<%--img--%>
<div class="container text-center mt-5">
    <div class="col-12 text-center fs-2 mt-2 mb-2">
        <img src="img/background/background.jpg" height="300px">
    </div>
</div>

<%--quest--%>
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

<%--Статистика--%>
<%@ include file='jsp/stats.jsp' %>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>

</body>
</html>