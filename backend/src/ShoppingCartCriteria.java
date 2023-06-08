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
import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ShoppingCartCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final CollectionExpression items;
	
	public ShoppingCartCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		items = new CollectionExpression("ORM_Items", this);
	}
	
	public ShoppingCartCriteria(PersistentSession session) {
		this(session.createCriteria(ShoppingCart.class));
	}
	
	public ShoppingCartCriteria() throws PersistentException {
		this(AAeSICTPPersistentManager.instance().getSession());
	}
	
	public ItemCriteria createItemsCriteria() {
		return new ItemCriteria(createCriteria("ORM_Items"));
	}
	
	public ShoppingCart uniqueShoppingCart() {
		return (ShoppingCart) super.uniqueResult();
	}
	
	public ShoppingCart[] listShoppingCart() {
		java.util.List list = super.list();
		return (ShoppingCart[]) list.toArray(new ShoppingCart[list.size()]);
	}
}

