package repo;

import model.Food;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FoodRepository extends CrudRepository<Food, Long> {
    List<Food> findByName(String name);
}
