package ru.job4j.dish.service;

import ru.job4j.dish.domain.Dish;

import java.util.Optional;

/**
 * 3. Мидл
 * 3.5. Микросервисы
 * Job4j Hungry Wolf
 * Job4j DISH
 * DishService повeдение бизнес логики обработки модели Dish
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 27.04.2023
 */
public interface DishService {
    Optional<Dish> create(Dish dish);

    Optional<Dish> findDishById(int dishId);

    boolean update(Dish dish);

    boolean delete(int dishId);
}
