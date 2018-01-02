package exemplo.tacos.data;

import org.springframework.data.repository.CrudRepository;

import exemplo.tacos.domain.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}