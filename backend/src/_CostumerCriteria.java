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

public class _CostumerCriteria extends AbstractORMCriteria {
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
	
	public _CostumerCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		email = new StringExpression("email", this);
		password = new StringExpression("password", this);
		name = new StringExpression("name", this);
		cartId = new IntegerExpression("cart.ID", this);
		cart = new AssociationExpression("cart", this);
		birthday = new DateExpression("birthday", this);
		nif = new StringExpression("nif", this);
		address = new StringExpression("address", this);
		orders = new CollectionExpression("ORM_Orders", this);
		favorites = new CollectionExpression("ORM_Favorites", this);
	}
	
	public _CostumerCriteria(PersistentSession session) {
		this(session.createCriteria(_Costumer.class));
	}
	
	public _CostumerCriteria() throws PersistentException {
		this(AAeSICTPPersistentManager.instance().getSession());
	}
	
	public ShoppingCartCriteria createCartCriteria() {
		return new ShoppingCartCriteria(createCriteria("cart"));
	}
	
	public OrderCriteria createOrdersCriteria() {
		return new OrderCriteria(createCriteria("ORM_Orders"));
	}
	
	public ProductCriteria createFavoritesCriteria() {
		return new ProductCriteria(createCriteria("ORM_Favorites"));
	}
	
	public _Costumer unique_Costumer() {
		return (_Costumer) super.uniqueResult();
	}
	
	public _Costumer[] list_Costumer() {
		java.util.List list = super.list();
		return (_Costumer[]) list.toArray(new _Costumer[list.size()]);
	}
}

