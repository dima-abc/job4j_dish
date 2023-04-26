--Создание таблицы для хранения моделей блюд DISH
CREATE TABLE DISH
(
    id               SERIAL PRIMARY KEY,
    dish_name        VARCHAR(2000),
    dish_description VARCHAR(2000)
);