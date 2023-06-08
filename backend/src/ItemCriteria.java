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

public class ItemCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression productId;
	public final AssociationExpression product;
	public final IntegerExpression materialId;
	public final AssociationExpression material;
	public final IntegerExpression quantity;
	
	public ItemCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		productId = new IntegerExpression("product.ID", this);
		product = new AssociationExpression("product", this);
		materialId = new IntegerExpression("material.ID", this);
		material = new AssociationExpression("material", this);
		quantity = new IntegerExpression("quantity", this);
	}
	
	public ItemCriteria(PersistentSession session) {
		this(session.createCriteria(Item.class));
	}
	
	public ItemCriteria() throws PersistentException {
		this(AAeSICTPPersistentManager.instance().getSession());
	}
	
	public ProductCriteria createProductCriteria() {
		return new ProductCriteria(createCriteria("product"));
	}
	
	public MaterialCriteria createMaterialCriteria() {
		return new MaterialCriteria(createCriteria("material"));
	}
	
	public Item uniqueItem() {
		return (Item) super.uniqueResult();
	}
	
	public Item[] listItem() {
		java.util.List list = super.list();
		return (Item[]) list.toArray(new Item[list.size()]);
	}
}

