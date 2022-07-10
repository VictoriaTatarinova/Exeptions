# Задание 1. NotFoundException (обязательное к выполнению)
Вы развиваете приложение с менеджером товаров, который мы рассматривали на лекции, и решили сделать так, чтобы при попытке удаления несуществующего объекта из репозитория генерировалось ваше исключение, а не ArrayIndexOfBoundsException.

Обратите внимание: это правильный подход, поскольку таким образом вы сообщаете (через генерацию исключения), что это исключение, вписывающееся в вашу логику, а не является ошибкой программиста.

Что нужно сделать:

Возьмите проект (мы его писали в рамках дз про наследование) с менеджером, репозиторием и товарами.
Создайте класс исключения NotFoundException отнаследовавшись от RuntimeException и реализуйте как минимум конструктор с параметром-сообщением (он будет просто вызывать супер-конструктор предка, см. подсказку)
В методе удаления removeById сначала проверяйте, есть ли элемент (для этого прямо из метода removeById вызывайте метод findById (про него ниже): если результат - null, тогда выкидывайте исключение NotFoundException)
Напишите 2 автотеста на репозиторий: первый должен проверять успешность удаления существующего элемента, второй - генерации NotFoundException при попытке удаления несуществующего элемента
Подсказка
Для реализации этой логики вам понадобится добавить метод findById, предназначенный для поиска товара в репозитории по его id. Так, он должен принимать параметром id искомого товара, пробегаться по всем товарам репозитория и сверять их id с искомом, в случае совпадения делать return этого товара. Если же пробежав все товары репозитория ни один подходящий найден не был (т.е. цикл закончился без вызова return внутри него), то следует сделать return null. Общая схема этого метода будет такой:
```
public Product findById(???) {
  for (???) {
    if (???) {
      return product;
    }
  }
  return null;
}
```
Убедитесь, что ваши автотесты проходят (напоминаем, что проект должен быть на базе Maven, с подключенными зависимостями и необходимыми плагинами).

Итого: у вас должен быть репозиторий на GitHub, в котором расположен ваш Java-код и автотесты к нему.

Мы рекомендуем вам указывать в сообщении исключения: при удалении по какому конкретно id было сгенерировано ваше исключение. Сделать это можно следующим образом (простейший способ): "Element with id: " + id + " not found".

## Итого: отправьте на проверку ссылку на гитхаб-репозиторий с вашим проектом.
