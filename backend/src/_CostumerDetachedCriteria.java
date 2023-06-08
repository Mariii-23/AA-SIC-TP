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

public class _CostumerDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression email;
	public final StringExpression password;
	public final StringExpression name;
	public final IntegerExpression cartId;
	public final AssociationExpression cart;
	public final DateExpression birthday;
	public final StringExpression nif;
	public final StringExpression address;
	public final CollectionExpression orders;
	public final CollectionExpression favorites;
	
	public _CostumerDetachedCriteria() {
		super(_Costumer.class, _CostumerCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		cartId = new IntegerExpression("cart.ID", this.getDetachedCriteria());
		cart = new AssociationExpression("cart", this.getDetachedCriteria());
		birthday = new DateExpression("birthday", this.getDetachedCriteria());
		nif = new StringExpression("nif", this.getDetachedCriteria());
		address = new StringExpression("address", this.getDetachedCriteria());
		orders = new CollectionExpression("ORM_Orders", this.getDetachedCriteria());
		favorites = new CollectionExpression("ORM_Favorites", this.getDetachedCriteria());
	}
	
	public _CostumerDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, _CostumerCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		cartId = new IntegerExpression("cart.ID", this.getDetachedCriteria());
		cart = new AssociationExpression("cart", this.getDetachedCriteria());
		birthday = new DateExpression("birthday", this.getDetachedCriteria());
		nif = new StringExpression("nif", this.getDetachedCriteria());
		address = new StringExpression("address", this.getDetachedCriteria());
		orders = new CollectionExpression("ORM_Orders", this.getDetachedCriteria());
		favorites = new CollectionExpression("ORM_Favorites", this.getDetachedCriteria());
	}
	
	public ShoppingCartDetachedCriteria createCartCriteria() {
		return new ShoppingCartDetachedCriteria(createCriteria("cart"));
	}
	
	public OrderDetachedCriteria createOrdersCriteria() {
		return new OrderDetachedCriteria(createCriteria("ORM_Orders"));
	}
	
	public ProductDetachedCriteria createFavoritesCriteria() {
		return new ProductDetachedCriteria(createCriteria("ORM_Favorites"));
	}
	
	public _Costumer unique_Costumer(PersistentSession session) {
		return (_Costumer) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public _Costumer[] list_Costumer(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (_Costumer[]) list.toArray(new _Costumer[list.size()]);
	}
}

