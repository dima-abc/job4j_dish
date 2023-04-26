package ru.job4j.dish.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.dish.domain.Dish;

/**
 * 3. Мидл
 * 3.5. Микросервисы
 * Job4j Hungry Wolf
 * Job4j DISH
 * DishRepository хранилище блюд в базе данных
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 26.04.2023
 */
public interface DishRepository extends CrudRepository<Dish, Integer> {
}
