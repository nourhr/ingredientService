package tn.esprit.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ingredientService {
	@Autowired
	private ingredientRepo ingredientRepository;

public Ingredient addIngred(Ingredient ingred)
{	
	return ingredientRepository.save(ingred);
	}

public Ingredient updateIngredient(int id, Ingredient nweing)
{
	if (ingredientRepository.findById(id).isPresent())
	{
		Ingredient existingingred = ingredientRepository.findById(id).get();
		existingingred.setLabel(nweing.getLabel());

		
		return ingredientRepository.save(existingingred);
	}
	else 
		return null;
}


public String deleteIngred(int id)
{
	if(ingredientRepository.findById(id).isPresent())
	{
		ingredientRepository.deleteById(id);
		return "ingredient supprime";
	}
	else 
		return "ingredient non supprimé";
}


}
