/*
 * package jp.co.aivick.demo.domain; import org.seasar.doma.Domain; import
 * java.lang.IllegalArgumentException;
 * 
 * //enum保存用クラス
 * 
 * @Domain(valueType= String.class, factoryMethod = "of") public enum MenuType{
 * 和食("1"), 洋食("2"), 中華("3");
 * 
 * private final String value;
 * 
 * private MenuType(String value) { this.value = value; }
 * 
 * public static MenuType of(String value) { for(String menutype :
 * MenuType.values()) { if (menutype.value.equals(value)) { return menutype; } }
 * //throw new IllegalArgumentException(value); }
 * 
 * public String getValue() { return value; }
 * 
 * @Override public String toString() { return value; }
 * 
 * }
 */