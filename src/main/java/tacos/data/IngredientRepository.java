package tacos.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tacos.model.Ingredient;


public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
