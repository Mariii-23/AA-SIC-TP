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

public class OrderCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression stateId;
	public final AssociationExpression state;
	public final DateExpression date;
	public final StringExpression address;
	public final BooleanExpression storePickUp;
	public final DoubleExpression total;
	public final CollectionExpression items;
	
	public OrderCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		stateId = new IntegerExpression("state.ID", this);
		state = new AssociationExpression("state", this);
		date = new DateExpression("date", this);
		address = new StringExpression("address", this);
		storePickUp = new BooleanExpression("storePickUp", this);
		total = new DoubleExpression("total", this);
		items = new CollectionExpression("ORM_Items", this);
	}
	
	public OrderCriteria(PersistentSession session) {
		this(session.createCriteria(Order.class));
	}
	
	public OrderCriteria() throws PersistentException {
		this(AAeSICTPPersistentManager.instance().getSession());
	}
	
	public OrderStateCriteria createStateCriteria() {
		return new OrderStateCriteria(createCriteria("state"));
	}
	
	public OrderItemCriteria createItemsCriteria() {
		return new OrderItemCriteria(createCriteria("ORM_Items"));
	}
	
	public Order uniqueOrder() {
		return (Order) super.uniqueResult();
	}
	
	public Order[] listOrder() {
		java.util.List list = super.list();
		return (Order[]) list.toArray(new Order[list.size()]);
	}
}

