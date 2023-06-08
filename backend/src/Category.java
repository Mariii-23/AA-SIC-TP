/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: mariana(Universidade do Minho)
 * License Type: Academic
 */
public class Category {
	public Category() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_CATEGORY_SUBCATEGORIES) {
			return ORM_subCategories;
		}
		else if (key == ORMConstants.KEY_CATEGORY_PRODUCTS) {
			return ORM_products;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int ID;
	
	private String name;
	
	private String image;
	
	private java.util.Set ORM_subCategories = new java.util.HashSet();
	
	private java.util.Set ORM_products = new java.util.HashSet();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setImage(String value) {
		this.image = value;
	}
	
	public String getImage() {
		return image;
	}
	
	private void setORM_SubCategories(java.util.Set value) {
		this.ORM_subCategories = value;
	}
	
	private java.util.Set getORM_SubCategories() {
		return ORM_subCategories;
	}
	
	public final CategorySetCollection subCategories = new CategorySetCollection(this, _ormAdapter, ORMConstants.KEY_CATEGORY_SUBCATEGORIES, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Products(java.util.Set value) {
		this.ORM_products = value;
	}
	
	private java.util.Set getORM_Products() {
		return ORM_products;
	}
	
	public final ProductSetCollection products = new ProductSetCollection(this, _ormAdapter, ORMConstants.KEY_CATEGORY_PRODUCTS, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
