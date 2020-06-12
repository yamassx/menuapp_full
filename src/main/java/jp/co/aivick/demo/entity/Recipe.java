package jp.co.aivick.demo.entity;

import org.seasar.doma.*;

@Entity
@Table(name="recipe")
public class Recipe {
//field
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
	private Integer recipe_id;
	
	@Column(name="recipe_name")
	private String recipe_name;
	
	@Column(name = "cal")
	private Double cal;
	
//getter&setter
	public Integer getId() {
		return recipe_id;
	}

	public void setId(Integer recipe_id) {
		this.recipe_id = recipe_id;
	}

	public String getName() {
		return recipe_name;
	}

	public void setName(String recipe_name) {
		this.recipe_name = recipe_name;
	}

	public Double getCal() {
		return cal;
	}

	public void setCal(Double cal) {
		this.cal = cal;
	}
	
}
