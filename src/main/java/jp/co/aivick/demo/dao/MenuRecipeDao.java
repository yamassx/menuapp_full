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
	 * @Update int update(Menu_Recipe MenuRecipe);
	 */
}
