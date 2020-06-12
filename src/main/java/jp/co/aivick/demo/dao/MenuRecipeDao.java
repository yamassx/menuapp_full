package jp.co.aivick.demo.dao;


import org.seasar.doma.*;
import org.seasar.doma.boot.ConfigAutowireable;

import jp.co.aivick.demo.entity.Menu_Recipe;

@ConfigAutowireable
@Dao
public interface MenuRecipeDao {
	@Insert
	int insert(Menu_Recipe recipes);

	/*
	 * @Select Menu_Recipe find(String id);
	 * 
	 * @Select List<Menu_Recipe> findAll();
	 */

	/*
	 * @Update int update(Menu_Recipe MenuRecipe);
	 */
}
