package jp.co.aivick.demo.entity;

import org.seasar.doma.*;

//import jp.co.aivick.demo.domain.MenuType;

@Entity
@Table(name = "menu")
public class Menu {

//field
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "menu_id")
	private Integer menu_id;

	@Column(name = "menuName")
	private String menuName;

	@Column(name = "menuType")
	private String menuType;

	@Column(name = "menuPrice")
	private Integer menuPrice;

	// constructor
	/*
	 * public Menu(Integer menu_id, String menuName, String menuType, Integer
	 * menuPrice) { this.menu_id = menu_id; this.menuName = menuName; this.menuPrice
	 * = menuPrice; this.menuType = menuType;
	 */
	//setter
	public void setMenu_id(Integer menu_id) {
		this.menu_id = menu_id;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}

	public void setMenuPrice(Integer menuPrice) {
		this.menuPrice = menuPrice;
	}



//getter
	public Integer getId() {
		return menu_id;
	}

	public String getName() {
		return menuName;
	}

	public String getType() {
		return menuType;
	}

	public Integer getPrice() {
		return menuPrice;
	}

}