<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
