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
public class Order {
	public Order() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_ORDER_ITEMS) {
			return ORM_items;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_ORDER_STATE) {
			this.state = (OrderState) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int ID;
	
	private OrderState state;
	
	private java.util.Date date;
	
	private String address;
	
	private boolean storePickUp;
	
	private double total;
	
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
	
	public void setDate(java.util.Date value) {
		this.date = value;
	}
	
	public java.util.Date getDate() {
		return date;
	}
	
	public void setAddress(String value) {
		this.address = value;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setStorePickUp(boolean value) {
		this.storePickUp = value;
	}
	
	public boolean getStorePickUp() {
		return storePickUp;
	}
	
	public void setTotal(double value) {
		this.total = value;
	}
	
	public double getTotal() {
		return total;
	}
	
	private void setORM_Items(java.util.Set value) {
		this.ORM_items = value;
	}
	
	private java.util.Set getORM_Items() {
		return ORM_items;
	}
	
	public final OrderItemSetCollection items = new OrderItemSetCollection(this, _ormAdapter, ORMConstants.KEY_ORDER_ITEMS, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public void setState(OrderState value) {
		this.state = value;
	}
	
	public OrderState getState() {
		return state;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
