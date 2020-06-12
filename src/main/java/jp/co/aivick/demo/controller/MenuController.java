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

import jp.co.aivick.demo.entity.Menu;
import jp.co.aivick.demo.entity.Recipe;
import jp.co.aivick.demo.form.MenuForm;
import jp.co.aivick.demo.service.MenuService;
import jp.co.aivick.demo.service.RecipeService;

@Controller
@RequestMapping("/menus")
public class MenuController {
	@Autowired
	MenuService menuService;
	@Autowired
	RecipeService recipeService;

	@GetMapping("/list")
	public String list(Model model) {
		List<Menu> menus = menuService.findAll();
		model.addAttribute("menus", menus);
		
		return "menus/list.html";
	}

	@GetMapping("/create")
	public String showCreate(Model model) {
		model.addAttribute("menuForm", new MenuForm());
		List<Recipe> recipes = recipeService.findAll();
		model.addAttribute("recipes", recipes);


		return "menus/create.html";
	}

	@PostMapping("/create")
	public String create(@Validated MenuForm menuForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "menus/create.html";
		}

		// Menu menu = new Menu(null, menuForm.getName(), menuForm.getType(),
		// menuForm.getPrice());

		Menu menu = new Menu();
		menu.setMenuName(menuForm.getName());
		menu.setMenuPrice(menuForm.getPrice());
		menu.setMenuType(menuForm.getType());

		//Menu createdMenu = menuService.create(menu, menuForm.getRecipes());
		menuService.create(menu, menuForm.getRecipes());
		return "redirect:/menus/create/";
		//return "redirect:/menus/update/" + createdMenu.getId();
		// return "redirect:/menus/create/"+ createdMenu.getId();
	}

	@GetMapping("/update/{menu_id}")
	public String showUpdate(@PathVariable("menu_id") String menu_id, Model model) {
		Menu menu = menuService.findBy(menu_id);
		MenuForm menuForm = new MenuForm();
		// Menu(null, menu.getName(), menu.getType(), menu.getPrice());

		menuForm.setId(menu.getId());
		menuForm.setName(menu.getName());
		menuForm.setType(menu.getType());
		menuForm.setPrice(menu.getPrice());

		model.addAttribute("menuForm", menuForm);
		return "menus/update.html";
	}

	/*
	 * @PostMapping("/update/{menu_id}") public String
	 * update(@PathVariable("menu_id") String menu_id, @Validated MenuForm menuForm,
	 * BindingResult bindingResult) { if (bindingResult.hasErrors()) { return
	 * "menus/update.html"; }
	 * 
	 * Menu menu = menuService.findBy(menu_id); // Menu(menuForm.getMenu_id(), //
	 * menuForm.getName(),menuForm.getType(),menuForm.getPrice());
	 * 
	 * menu.setMenuName(menuForm.getName()); menu.setMenuPrice(menuForm.getPrice());
	 * menu.setMenuType(menuForm.getType());
	 * 
	 * Menu updatedMenu = menuService.update(menu);
	 * 
	 * return "redirect:/menus/update" + updatedMenu.getId(); }
	 */
}