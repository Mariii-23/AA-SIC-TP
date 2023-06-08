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
public class ShoppingCart {
	public ShoppingCart() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_SHOPPINGCART_ITEMS) {
			return ORM_items;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int ID;
	
	private java.util.Set ORM_items = new java.util.HashSet();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	private void setORM_Items(java.util.Set value) {
		this.ORM_items = value;
	}
	
	private java.util.Set getORM_Items() {
		return ORM_items;
	}
	
	public final ItemSetCollection items = new ItemSetCollection(this, _ormAdapter, ORMConstants.KEY_SHOPPINGCART_ITEMS, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
