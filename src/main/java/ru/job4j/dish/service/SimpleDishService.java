package ru.job4j.dish.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.job4j.dish.domain.Dish;
import ru.job4j.dish.repository.DishRepository;

import java.util.Optional;

/**
 * 3. Мидл
 * 3.5. Микросервисы
 * Job4j Hungry Wolf
 * Job4j DISH
 * SimpleDishService бизнес логика обработки модели Dish
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 27.04.2023
 */
@Service
@AllArgsConstructor
@Slf4j
public class SimpleDishService implements DishService {
    private final DishRepository dishRepository;

    @Override
    public Optional<Dish> create(Dish dish) {
        try {
            dishRepository.save(dish);
            return Optional.of(dish);
        } catch (Exception e) {
            log.error("Fail create dish: {}, error: {}", dish, e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<Dish> findDishById(int dishId) {
        return dishRepository.findById(dishId);
    }

    @Override
    public boolean update(Dish dish) {
        try {
            dishRepository.save(dish);
            return true;
        } catch (Exception e) {
            log.error("Fail update dish: {}, error: {}", dish, e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(int dishId) {
        try {
            dishRepository.deleteById(dishId);
            return true;
        } catch (Exception e) {
            log.error("Fail delete dishId: {}, error: {}", dishId, e.getMessage());
            return false;
        }
    }
}
