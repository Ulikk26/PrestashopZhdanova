1. ТЕСТИРОВАНИЕ РЕГИСТРАЦИИ И АВТОРИЗАЦИИ
1.1 Регистрация нового пользователя:

"Authentication/Create an account"
1.1.1 Проверить, что форма регистрации корректно принимает адрес электронной почты на странице 
"Authentication/Create an account".

"Your personal information"
1.1.2 Проверить, что форма регистрации "Your personal information" корректно принимает все необходимые данные.
1.1.3 Проверить, что регистрация возможна, при заполнении только обязательных полей.
1.1.4 Проверить, что регистрация невозможна без заполнения обязательных полей.
1.1.5 Проверить правильность ввода данных (например, правильность формата электронной почты, минимальную/максимальную 
длину пароля).
1.1.7 Убедитесь, что система не позволяет регистрировать несколько аккаунтов с одним и тем же адресом электронной почты.

1.2 Авторизация (логин):
1.2.1 Проверить вход с корректными данными (email/пароль).
1.2.2 Проверить вход с некорректными данными (неверный email или пароль).
1.2.3 Проверить, что система редиректит на страницу "My account после" успешного входа.

1.3.Выход (logout):
1.3.1 Проверить, что кнопка выхода корректно завершает сессию пользователя.
1.3.2 После выхода убедитесь, что пользователь не может получить доступ к страницам, требующим авторизации.

2. ТЕСТИРОВАНИЕ КОРЗИНЫ
2.1 Добавление товаров в корзину:
2.1.1 Проверить, что товары корректно добавляются в корзину.
2.1.2 Проверить, что количество товаров можно изменить (например, увеличить или уменьшить).
2.1.3 Проверить, что цена корректно обновляется при изменении количества товаров.

2.2 Просмотр содержимого корзины:
2.2.1 Убедитесь, что корзина отображает правильные товары, их количество, цену и общую стоимость.
2.2.2 Проверить, что товары можно удалить из корзины (кнопка удаления).
2.2.3 Проверить, что корзина очищается после оформления заказа.

2.3 Проверка сохранения корзины:
2.3.1 Убедитесь, что корзина сохраняется для пользователя при перезагрузке страницы (при условии, что пользователь
авторизован).

2.4 Очистка корзины:
2.4.1 После очистки корзины убедиться, что корзина пустая и пользователь видит сообщение об этом.

3. ТЕСТИРОВАНИЕ ОФОРМЛЕНИЯ ЗАКАЗА
3.1 "Your addresses"
3.1.1 Проверить, что форма корректно принимает все необходимые данные 
3.1.2 Проверить, что сохранение страницы возможно, при заполнении только обязательных полей
3.1.3 Проверить, что сохранение страницы невозможна без заполнения обязательных полей
3.1.4 Проверить правильность ввода данных (например, правильность формата электронной почты, минимальную/максимальную
длину пароля).

3.2 "Shipping"
3.2.1 Проверить, что все доступные способы доставки корректно отображаются на странице оформления заказа.
3.2.2 Проверить что оформление недоступно без подтверждения согласия с условиями обслуживания.

3.3 "Payment"
3.3.1 Проверить оповещение об установленных платежных системах, если они еще не установлены.

3.4 Оформление заказа без авторизации:
3.4.1 Убедитесь, что  заказ нельзя оформить без регистрации/входа  и система запрашивает данные для оформления заказа, 
даже если пользователь не зарегистрирован.