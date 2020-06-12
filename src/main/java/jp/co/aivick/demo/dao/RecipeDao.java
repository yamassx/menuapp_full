package jp.co.aivick.demo.dao;

import java.util.List;

import org.seasar.doma.*;
import org.seasar.doma.boot.ConfigAutowireable;

import jp.co.aivick.demo.entity.Recipe;

@ConfigAutowireable
@Dao
public interface RecipeDao {
	
	@Select
    Recipe find(String id);

    @Select
    List<Recipe> findAll();

    @Insert
    int insert(Recipe recipe);

    @Update
    int update(Recipe recipe);
    
    @Select
    List<Recipe> search(Double mincal, Double maxcal);

}
