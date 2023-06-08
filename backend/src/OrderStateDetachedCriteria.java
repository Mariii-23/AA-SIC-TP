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

public class OrderStateDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	
	public OrderStateDetachedCriteria() {
		super(OrderState.class, OrderStateCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public OrderStateDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, OrderStateCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public OrderState uniqueOrderState(PersistentSession session) {
		return (OrderState) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public OrderState[] listOrderState(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (OrderState[]) list.toArray(new OrderState[list.size()]);
	}
}

