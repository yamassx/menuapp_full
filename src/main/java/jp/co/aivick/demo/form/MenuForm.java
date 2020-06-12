package jp.co.aivick.demo.form;

//import java.util.List;

//import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

//import jp.co.aivick.demo.entity.Recipe;

//import jp.co.aivick.demo.domain.MenuType;
//import jp.co.aivick.demo.entity.Menu_Recipe;

public class MenuForm {
//field	
	private Integer menu_id;
	
	@NotEmpty
	private String menuName;
	@NotEmpty
	//private MenuType menuType;
	@NotEmpty
	private String menuType;
	@NotNull
	private Integer menuPrice;

	private String[] recipes;
	
	public Integer getMenu_id() {
		return menu_id;
	}
//getter&setter
	public void setId(Integer menu_id) {
		this.menu_id = menu_id;
	}
	public String getName() {
		return menuName;
	}
	public void setName(String name) {
		this.menuName = name;
	}

	/*
	 * public MenuType getType() { return menuType; }
	 */
	public String getType() {
		return menuType;
	}
	/*
	 * public void setType(MenuType menuType) { this.menuType = menuType; }
	 */
	public void setType(String type) {
		this.menuType = type;
	}
	public Integer getPrice() {
		return menuPrice;
	}
	public void setPrice(Integer price) {
		this.menuPrice = price;
	}
	public String[] getRecipes() {
		return recipes;
	}
	public void setRecipes(String[] recipes) {
		this.recipes = recipes;
	}

}