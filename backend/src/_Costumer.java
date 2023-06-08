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
public class _Costumer extends User {
	public _Costumer() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY__COSTUMER_ORDERS) {
			return ORM_orders;
		}
		else if (key == ORMConstants.KEY__COSTUMER_FAVORITES) {
			return ORM_favorites;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private ShoppingCart cart;
	
	private java.util.Date birthday;
	
	private String nif;
	
	private String address;
	
	private java.util.Set ORM_orders = new java.util.HashSet();
	
	private java.util.Set ORM_favorites = new java.util.HashSet();
	
	public void setBirthday(java.util.Date value) {
		this.birthday = value;
	}
	
	public java.util.Date getBirthday() {
		return birthday;
	}
	
	public void setNif(String value) {
		this.nif = value;
	}
	
	public String getNif() {
		return nif;
	}
	
	public void setAddress(String value) {
		this.address = value;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setCart(ShoppingCart value) {
		this.cart = value;
	}
	
	public ShoppingCart getCart() {
		return cart;
	}
	
	private void setORM_Orders(java.util.Set value) {
		this.ORM_orders = value;
	}
	
	private java.util.Set getORM_Orders() {
		return ORM_orders;
	}
	
	public final OrderSetCollection orders = new OrderSetCollection(this, _ormAdapter, ORMConstants.KEY__COSTUMER_ORDERS, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Favorites(java.util.Set value) {
		this.ORM_favorites = value;
	}
	
	private java.util.Set getORM_Favorites() {
		return ORM_favorites;
	}
	
	public final ProductSetCollection favorites = new ProductSetCollection(this, _ormAdapter, ORMConstants.KEY__COSTUMER_FAVORITES, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public String toString() {
		return super.toString();
	}
	
}
