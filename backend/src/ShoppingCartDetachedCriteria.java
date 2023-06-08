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
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ShoppingCartDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final CollectionExpression items;
	
	public ShoppingCartDetachedCriteria() {
		super(ShoppingCart.class, ShoppingCartCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		items = new CollectionExpression("ORM_Items", this.getDetachedCriteria());
	}
	
	public ShoppingCartDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, ShoppingCartCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		items = new CollectionExpression("ORM_Items", this.getDetachedCriteria());
	}
	
	public ItemDetachedCriteria createItemsCriteria() {
		return new ItemDetachedCriteria(createCriteria("ORM_Items"));
	}
	
	public ShoppingCart uniqueShoppingCart(PersistentSession session) {
		return (ShoppingCart) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public ShoppingCart[] listShoppingCart(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (ShoppingCart[]) list.toArray(new ShoppingCart[list.size()]);
	}
}

