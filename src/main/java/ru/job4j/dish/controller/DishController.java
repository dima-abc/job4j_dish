package ru.job4j.dish.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.job4j.dish.domain.Dish;
import ru.job4j.dish.service.DishService;

/**
 * 3. Мидл
 * 3.5. Микросервисы
 * Job4j Hungry Wolf
 * Job4j DISH
 * DishController REST API контроллер модели Dish
 * @author Dmitry Stepanov, user Dmitry
 * @since 27.04.2023
 */
@RestController
@RequestMapping("/dish")
@AllArgsConstructor
public class DishController {
    private final DishService dishService;

    @GetMapping("/{id}")
    public ResponseEntity<Dish> getOrderById(@PathVariable int id) {
        var dish = dishService.findDishById(id);
        return new ResponseEntity<>(
                dish.orElseThrow(
                        () -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Dish id: " + id + ", not found"
                        )
                ),
                HttpStatus.OK
        );
    }

    @PostMapping("/")
    public ResponseEntity<Dish> create(@RequestBody Dish dish) {
        var dishSave = dishService.create(dish);
        return new ResponseEntity<>(
                dishSave.orElseThrow(
                        () -> new ResponseStatusException(
                                HttpStatus.INTERNAL_SERVER_ERROR,
                                "The dish has not been saved"
                        )
                ),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/")
    public ResponseEntity<Void> update(@RequestBody Dish dish) {
        var dishUpdate = dishService.update(dish);
        return dishUpdate ? ResponseEntity.ok().build() : ResponseEntity.internalServerError().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        var dishDelete = dishService.delete(id);
        return dishDelete ? ResponseEntity.ok().build() : ResponseEntity.internalServerError().build();
    }
}
