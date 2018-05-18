package com.quantifiedselfspring;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class WebController{
    @Autowired
    FoodRepository foodRepository;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/api/v1/foods")
    public List<Food> retrieveAllStudents() {
        return foodRepository.findAll();
    }

    @GetMapping("/api/v1/foods/{id}")
    public Food retrieveStudent(@PathVariable long id) {
        Optional<Food> food = foodRepository.findById(id);

//        if (!food.isPresent())
//            throw new FoodNotFoundException("id-" + id);

        return food.get();
    }

    @PostMapping("/api/v1/foods")
    public ResponseEntity<Object> createFood(@RequestBody Food food) {
        Food savedFood = foodRepository.save(food);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedFood.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PatchMapping("/api/v1/foods/{id}")
    public ResponseEntity<Object> patchFood(@RequestBody Food food, @PathVariable long id) {

//        Optional<Food> foodOptional = foodRepository.findById(id);
//
//        if (!foodOptional.isPresent())
//            return ResponseEntity.notFound().build();

        food.setId(id);

        foodRepository.save(food);

        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/api/v1/foods/{id}")
    public void deleteFood(@PathVariable long id) {
        foodRepository.deleteById(id);
    }
}




