package controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Food;
import repo.FoodRepository;

@RestController
public class WebController{
    @Autowired
    FoodRepository repository;

    @RequestMapping("/save")
    public String process(){
        // save a single Food
        repository.save(new Food("Waffle", "300"));

        // save a list of Foods
        repository.save(Arrays.asList(
                new Food("Pancake", "200"),
                new Food("Oatmeal", "100"),
                new Food("Egg", "50"),
                new Food("Cereal", "300")));

        return "Done";
    }

    @RequestMapping("/findall")
    public String findAll(){
        String result = "";

        for(Food food : repository.findAll()){
            result += food.toString() + "<br>";
        }

        return result;
    }

    @RequestMapping("/findbyid")
    public String findById(@RequestParam("id") long id){
        String result = "";

        result = repository.findById(id).toString();

        return result;
    }

    @RequestMapping("/findbyname")
    public String fetchDataByName(@RequestParam("name") String name){
        String result = "";

        for(Food food: repository.findByName(name)){
            result += food.toString() + "<br>";
        }

        return result;
    }

    @RequestMapping("/findbycalories")
    public String fetchDataByCalories(@RequestParam("calories") String calories){
        String result = "";

        for(Food food: repository.findByName(calories)){
            result += food.toString() + "<br>";
        }

        return result;
    }
}