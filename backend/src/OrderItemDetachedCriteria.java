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

public class OrderItemDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression productId;
	public final AssociationExpression product;
	public final IntegerExpression materialId;
	public final AssociationExpression material;
	public final IntegerExpression quantity;
	public final DoubleExpression price;
	
	public OrderItemDetachedCriteria() {
		super(OrderItem.class, OrderItemCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		productId = new IntegerExpression("product.ID", this.getDetachedCriteria());
		product = new AssociationExpression("product", this.getDetachedCriteria());
		materialId = new IntegerExpression("material.ID", this.getDetachedCriteria());
		material = new AssociationExpression("material", this.getDetachedCriteria());
		quantity = new IntegerExpression("quantity", this.getDetachedCriteria());
		price = new DoubleExpression("price", this.getDetachedCriteria());
	}
	
	public OrderItemDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, OrderItemCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		productId = new IntegerExpression("product.ID", this.getDetachedCriteria());
		product = new AssociationExpression("product", this.getDetachedCriteria());
		materialId = new IntegerExpression("material.ID", this.getDetachedCriteria());
		material = new AssociationExpression("material", this.getDetachedCriteria());
		quantity = new IntegerExpression("quantity", this.getDetachedCriteria());
		price = new DoubleExpression("price", this.getDetachedCriteria());
	}
	
	public ProductDetachedCriteria createProductCriteria() {
		return new ProductDetachedCriteria(createCriteria("product"));
	}
	
	public MaterialDetachedCriteria createMaterialCriteria() {
		return new MaterialDetachedCriteria(createCriteria("material"));
	}
	
	public OrderItem uniqueOrderItem(PersistentSession session) {
		return (OrderItem) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public OrderItem[] listOrderItem(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (OrderItem[]) list.toArray(new OrderItem[list.size()]);
	}
}

