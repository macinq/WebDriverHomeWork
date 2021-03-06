#language: ru

@T
Функционал: Получение значения
  Структура сценария: Найдем самые дорогие принтеры на авито по <Категория><Предмет><Город><Сортировка><Число>
    Пусть открыт ресурс авито
    И в выпадающем списке категорий выбрана <Категория>
    И в поле поиска введено значение <Предмет>
    Тогда кликнуть по выпадающему списку региона
    Тогда в поле регион введено значение <Город>
    И нажата кнопка показать объявления
    Тогда открылась страница результаты по запросу <Предмет>
    И активирован чекбокс только с фотографией
    И в выпадающем списке сортировка выбрано значение <Сортировка>
    И в консоль выведено значение названия и цены <Число> первых товаров

    Примеры:
    | Категория               | Предмет       | Город            | Сортировка | Число |
    | оргтехника_и_расходники | "принтер"     | "Владивосток"    | дороже     | 3     |