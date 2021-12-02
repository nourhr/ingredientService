package tn.esprit.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value="/api/ingredients")
public class ingredientRest {
	private String titre="je suis l'ingredient microservice";
	@Autowired
	private ingredientService ingredService;
	@RequestMapping("/hello")
	public String sayHello()
	{
		System.out.println(titre);
		return titre;
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Ingredient>createIngredient(@RequestBody Ingredient ingredient)
	{
		return new ResponseEntity<>(ingredService.addIngred(ingredient),HttpStatus.OK);
	}
	
	@PutMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE) 
	 @ResponseStatus(HttpStatus.OK)
	 public ResponseEntity<Ingredient>updateCandidat(@PathVariable(value="id")int id,@RequestBody Ingredient ingredient)
	 {
		 return new ResponseEntity<>(ingredService.updateIngredient(id, ingredient),HttpStatus.OK);
	 }
	@DeleteMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE) 
	 @ResponseStatus(HttpStatus.OK)
	 public ResponseEntity<String>deleteIngredient(@PathVariable(value="id")int id,@RequestBody Ingredient ingredient)
	 {
		 return new ResponseEntity<String>(ingredService.deleteIngred(id),HttpStatus.OK);
	 }
	 
	
	
}
