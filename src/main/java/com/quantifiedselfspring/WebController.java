package com.quantifiedselfspring;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController{
    @Autowired
    FoodRepository foodRepository;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/foods")
    public List<Food> retrieveAllStudents() {
        return foodRepository.findAll();
    }

    @GetMapping("/foods/{id}")
    public Food retrieveStudent(@PathVariable long id) {
        Optional<Food> food = foodRepository.findById(id);

//        if (!student.isPresent())
//            throw new FoodNotFoundException("id-" + id);

        return food.get();
    }
}




