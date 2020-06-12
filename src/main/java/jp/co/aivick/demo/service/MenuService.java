package jp.co.aivick.demo.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//import org.seasar.doma.jdbc.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.aivick.demo.dao.MenuDao;
import jp.co.aivick.demo.dao.MenuRecipeDao;
import jp.co.aivick.demo.entity.Menu;
import jp.co.aivick.demo.entity.Menu_Recipe;
//import jp.co.aivick.demo.entity.Recipe;

@Service
public class MenuService {
	@Autowired(required = true)
	private MenuDao menuDao;
	@Autowired
	private MenuRecipeDao menuRecipeDao;

	public Menu findBy(String id) {
		return menuDao.find(id);
	}

	public List<Menu> findAll() {
		return this.menuDao.findAll();
	}

	@Transactional
	public Menu create(Menu menu, String[] recipes) {
		// int menuResult = menuDao.insert(menu);
		// Menu createdMenu = menuResult.getEntity();
		menuDao.insert(menu);

		List<Menu_Recipe> menuRecipes = IntStream.range(0, recipes.length)
												 .mapToObj(i -> {
													Menu_Recipe mr = new Menu_Recipe();
													mr.setRecipe_id(Integer.parseInt(recipes[i]));
													mr.setMenu_id(menu.getId());
													return mr;})										
												 .collect(Collectors.toList());

		for(Menu_Recipe menuRecipe : menuRecipes) {
			menuRecipeDao.insert(menuRecipe);
		}
		return menu;
	}

	/*
	 * @Transactional public Menu update(Menu menu) { menuDao.update(menu); return
	 * menu; }
	 */
}