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
public class Item {
	public Item() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_ITEM_MATERIAL) {
			this.material = (Material) owner;
		}
		
		else if (key == ORMConstants.KEY_ITEM_PRODUCT) {
			this.product = (Product) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int ID;
	
	private Product product;
	
	private Material material;
	
	private int quantity;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setQuantity(int value) {
		this.quantity = value;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setMaterial(Material value) {
		this.material = value;
	}
	
	public Material getMaterial() {
		return material;
	}
	
	public void setProduct(Product value) {
		this.product = value;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
