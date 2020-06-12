package jp.co.aivick.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.aivick.demo.entity.Recipe;
import jp.co.aivick.demo.form.RecipeForm;
import jp.co.aivick.demo.form.SearchForm;
import jp.co.aivick.demo.service.RecipeService;

@Controller
@RequestMapping("/recipes")
public class RecipeController {
	@Autowired
	RecipeService recipeservice;
	@GetMapping("/list")
	public String list(Model model) {
		List<Recipe> recipes = recipeservice.findAll();
		model.addAttribute("recipes", recipes);
		
		return "recipes/list.html";
	}
	
	@GetMapping("/create")
	public String showCreate(Model model) {
		model.addAttribute("recipeForm", new RecipeForm());
		return "recipes/create.html";	
	}
	
	@PostMapping("/create")
	public String create(@Validated RecipeForm recipeForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
            return "recipes/create.html";
        }
		
		Recipe recipe = new Recipe();
        recipe.setName(recipeForm.getName());
        recipe.setCal(recipeForm.getCal());
        Recipe createdRecipe = recipeservice.create(recipe);

        return "redirect:/recipes/update/" + createdRecipe.getId();
	}
	
	@GetMapping("/update/{id}")
	public String showUpdate(@PathVariable("id") String id, Model model) {
		Recipe recipe = recipeservice.findBy(id);
		RecipeForm recipeForm = new RecipeForm();
		recipeForm.setId(recipe.getId());
		recipeForm.setName(recipe.getName());
		recipeForm.setCal(recipe.getCal());
		
		model.addAttribute("recipeForm" ,recipeForm);
		return "recipes/update.html";
	}
	
	@PostMapping("/update/{id}")
	public String update(@PathVariable("id") String id, @Validated RecipeForm recipeForm,
	        BindingResult bindingResult)
	{
		if (bindingResult.hasErrors()) {
            return "recipes/update.html";
        }
		Recipe recipe = recipeservice.findBy(id);
		recipe.setName(recipeForm.getName());
		recipe.setCal(recipeForm.getCal());
		//Recipe updatedRecipe = recipeservice.update(recipe);
		recipeservice.update(recipe);
		return "redirect:/recipes/list";
		//return "redirect:/recipes/update/" + updatedRecipe.getId();
	}
	@GetMapping("/search")
	public String search(SearchForm searchForm, Model model) {
			
		if(searchForm.getMincal() == null && searchForm.getMaxcal() == null) {
			
			List<Recipe> recipes = recipeservice.findAll();
			model.addAttribute("recipes", recipes);
			model.addAttribute("searchForm", new SearchForm());
			
		}else{
			List<Recipe> recipes = recipeservice.search(searchForm.getMincal(), searchForm.getMaxcal(), searchForm.getName());
			model.addAttribute("recipes", recipes);
			
		}
		return "recipes/search.html";		
		
	}
}
