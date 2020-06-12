
package jp.co.aivick.demo.entity;

import org.seasar.doma.*;

@Entity
@Table(name = "menu_recipe")
public class Menu_Recipe {

	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.IDENTITY)
	 * 
	 * @Column(name = "id") private Integer id;
	 */

	@Column(name = "menu_id")
	private Integer menu_id;

	@Column(name = "recipe_id")
	private Integer recipe_id;

	// getter&setter public Integer getMenu_id() { return menu_id; }

	public void setMenu_id(Integer menu_id) {
		this.menu_id = menu_id;
	}

	public Integer getRecipe_id() {
		return recipe_id;
	}

	public void setRecipe_id(Integer recipe_id) {
		this.recipe_id = recipe_id;
	}

}
