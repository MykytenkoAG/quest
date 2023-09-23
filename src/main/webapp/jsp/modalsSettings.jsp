<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Modal -->
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Инструкция</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body fs-5">
        Файл квеста представляет собой json-файл, описывающий логическое дерево, со следующими ключами:
        <table class="table">
          <tbody>
          <tr>
            <td class="fs-6 mt-1 mb-1">Ключ</td>
            <td class="fs-6 mt-1 mb-1">Тип</td>
            <td class="fs-6 mt-1 mb-1">Описание</td>
          </tr>
          <tr>
            <td class="fs-6 mt-1 mb-1">question</td>
            <td class="fs-6 mt-1 mb-1">строка</td>
            <td class="fs-6 mt-1 mb-1">вопрос, к которому прилагается два варианта ответа</td>
          </tr>
          <tr>
            <td class="fs-6 mt-1 mb-1">button1</td>
            <td class="fs-6 mt-1 mb-1">строка</td>
            <td class="fs-6 mt-1 mb-1">ответ 1</td>
          </tr>
          <tr>
            <td class="fs-6 mt-1 mb-1">option1</td>
            <td class="fs-6 mt-1 mb-1">объект</td>
            <td class="fs-6 mt-1 mb-1">узел дерева квеста, на которое пользователь попадает в случае выбора ответа 1</td>
          </tr>
          <tr>
            <td class="fs-6 mt-1 mb-1">button2</td>
            <td class="fs-6 mt-1 mb-1">строка</td>
            <td class="fs-6 mt-1 mb-1">ответ 2</td>
          </tr>
          <tr>
            <td class="fs-6 mt-1 mb-1">option2</td>
            <td class="fs-6 mt-1 mb-1">объект</td>
            <td class="fs-6 mt-1 mb-1">узел дерева квеста, на которое пользователь попадает в случае выбора ответа 2</td>
          </tr>
          <tr>
            <td class="fs-6 mt-1 mb-1">victory</td>
            <td class="fs-6 mt-1 mb-1">строка</td>
            <td class="fs-6 mt-1 mb-1">строка со значением "victory" или "loose", которая обозначает окончание квеста</td>
          </tr>
          </tbody>
        </table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Закрыть</button>
      </div>
    </div>

  </div>
</div>

<div class="modal fade" id="modalError" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="">Ошибка</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body fs-5">
        Загруженный Вами файл имеет некорректный формат
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">ОК</button>
      </div>
    </div>
  </div>
</div>
