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

public class ProductCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final DoubleExpression price;
	public final StringExpression name;
	public final StringExpression description;
	public final CollectionExpression materials;
	public final CollectionExpression infos;
	public final CollectionExpression reviews;
	public final CollectionExpression images;
	
	public ProductCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		price = new DoubleExpression("price", this);
		name = new StringExpression("name", this);
		description = new StringExpression("description", this);
		materials = new CollectionExpression("ORM_Materials", this);
		infos = new CollectionExpression("ORM_Infos", this);
		reviews = new CollectionExpression("ORM_Reviews", this);
		images = new CollectionExpression("ORM_Images", this);
	}
	
	public ProductCriteria(PersistentSession session) {
		this(session.createCriteria(Product.class));
	}
	
	public ProductCriteria() throws PersistentException {
		this(AAeSICTPPersistentManager.instance().getSession());
	}
	
	public MaterialCriteria createMaterialsCriteria() {
		return new MaterialCriteria(createCriteria("ORM_Materials"));
	}
	
	public TechnicalInfoCriteria createInfosCriteria() {
		return new TechnicalInfoCriteria(createCriteria("ORM_Infos"));
	}
	
	public ReviewCriteria createReviewsCriteria() {
		return new ReviewCriteria(createCriteria("ORM_Reviews"));
	}
	
	public ImageCriteria createImagesCriteria() {
		return new ImageCriteria(createCriteria("ORM_Images"));
	}
	
	public Product uniqueProduct() {
		return (Product) super.uniqueResult();
	}
	
	public Product[] listProduct() {
		java.util.List list = super.list();
		return (Product[]) list.toArray(new Product[list.size()]);
	}
}

