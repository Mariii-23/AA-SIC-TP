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

public class OrderDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression stateId;
	public final AssociationExpression state;
	public final DateExpression date;
	public final StringExpression address;
	public final BooleanExpression storePickUp;
	public final DoubleExpression total;
	public final CollectionExpression items;
	
	public OrderDetachedCriteria() {
		super(Order.class, OrderCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		stateId = new IntegerExpression("state.ID", this.getDetachedCriteria());
		state = new AssociationExpression("state", this.getDetachedCriteria());
		date = new DateExpression("date", this.getDetachedCriteria());
		address = new StringExpression("address", this.getDetachedCriteria());
		storePickUp = new BooleanExpression("storePickUp", this.getDetachedCriteria());
		total = new DoubleExpression("total", this.getDetachedCriteria());
		items = new CollectionExpression("ORM_Items", this.getDetachedCriteria());
	}
	
	public OrderDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, OrderCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		stateId = new IntegerExpression("state.ID", this.getDetachedCriteria());
		state = new AssociationExpression("state", this.getDetachedCriteria());
		date = new DateExpression("date", this.getDetachedCriteria());
		address = new StringExpression("address", this.getDetachedCriteria());
		storePickUp = new BooleanExpression("storePickUp", this.getDetachedCriteria());
		total = new DoubleExpression("total", this.getDetachedCriteria());
		items = new CollectionExpression("ORM_Items", this.getDetachedCriteria());
	}
	
	public OrderStateDetachedCriteria createStateCriteria() {
		return new OrderStateDetachedCriteria(createCriteria("state"));
	}
	
	public OrderItemDetachedCriteria createItemsCriteria() {
		return new OrderItemDetachedCriteria(createCriteria("ORM_Items"));
	}
	
	public Order uniqueOrder(PersistentSession session) {
		return (Order) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Order[] listOrder(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Order[]) list.toArray(new Order[list.size()]);
	}
}

