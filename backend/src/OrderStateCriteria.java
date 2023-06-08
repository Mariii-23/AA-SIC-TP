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

public class OrderStateCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	
	public OrderStateCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
	}
	
	public OrderStateCriteria(PersistentSession session) {
		this(session.createCriteria(OrderState.class));
	}
	
	public OrderStateCriteria() throws PersistentException {
		this(AAeSICTPPersistentManager.instance().getSession());
	}
	
	public OrderState uniqueOrderState() {
		return (OrderState) super.uniqueResult();
	}
	
	public OrderState[] listOrderState() {
		java.util.List list = super.list();
		return (OrderState[]) list.toArray(new OrderState[list.size()]);
	}
}

