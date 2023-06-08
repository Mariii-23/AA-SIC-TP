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
public class Product {
	public Product() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_PRODUCT_MATERIALS) {
			return ORM_materials;
		}
		else if (key == ORMConstants.KEY_PRODUCT_INFOS) {
			return ORM_infos;
		}
		else if (key == ORMConstants.KEY_PRODUCT_REVIEWS) {
			return ORM_reviews;
		}
		else if (key == ORMConstants.KEY_PRODUCT_IMAGES) {
			return ORM_images;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int ID;
	
	private double price;
	
	private String name;
	
	private String description;
	
	private java.util.Set ORM_materials = new java.util.HashSet();
	
	private java.util.Set ORM_infos = new java.util.HashSet();
	
	private java.util.Set ORM_reviews = new java.util.HashSet();
	
	private java.util.Set ORM_images = new java.util.HashSet();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setPrice(double value) {
		this.price = value;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setDescription(String value) {
		this.description = value;
	}
	
	public String getDescription() {
		return description;
	}
	
	private void setORM_Materials(java.util.Set value) {
		this.ORM_materials = value;
	}
	
	private java.util.Set getORM_Materials() {
		return ORM_materials;
	}
	
	public final MaterialSetCollection materials = new MaterialSetCollection(this, _ormAdapter, ORMConstants.KEY_PRODUCT_MATERIALS, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	private void setORM_Infos(java.util.Set value) {
		this.ORM_infos = value;
	}
	
	private java.util.Set getORM_Infos() {
		return ORM_infos;
	}
	
	public final TechnicalInfoSetCollection infos = new TechnicalInfoSetCollection(this, _ormAdapter, ORMConstants.KEY_PRODUCT_INFOS, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Reviews(java.util.Set value) {
		this.ORM_reviews = value;
	}
	
	private java.util.Set getORM_Reviews() {
		return ORM_reviews;
	}
	
	public final ReviewSetCollection reviews = new ReviewSetCollection(this, _ormAdapter, ORMConstants.KEY_PRODUCT_REVIEWS, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Images(java.util.Set value) {
		this.ORM_images = value;
	}
	
	private java.util.Set getORM_Images() {
		return ORM_images;
	}
	
	public final ImageSetCollection images = new ImageSetCollection(this, _ormAdapter, ORMConstants.KEY_PRODUCT_IMAGES, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
