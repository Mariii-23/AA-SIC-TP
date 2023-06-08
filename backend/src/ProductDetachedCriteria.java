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

public class ProductDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final DoubleExpression price;
	public final StringExpression name;
	public final StringExpression description;
	public final CollectionExpression materials;
	public final CollectionExpression infos;
	public final CollectionExpression reviews;
	public final CollectionExpression images;
	
	public ProductDetachedCriteria() {
		super(Product.class, ProductCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		price = new DoubleExpression("price", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		description = new StringExpression("description", this.getDetachedCriteria());
		materials = new CollectionExpression("ORM_Materials", this.getDetachedCriteria());
		infos = new CollectionExpression("ORM_Infos", this.getDetachedCriteria());
		reviews = new CollectionExpression("ORM_Reviews", this.getDetachedCriteria());
		images = new CollectionExpression("ORM_Images", this.getDetachedCriteria());
	}
	
	public ProductDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, ProductCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		price = new DoubleExpression("price", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		description = new StringExpression("description", this.getDetachedCriteria());
		materials = new CollectionExpression("ORM_Materials", this.getDetachedCriteria());
		infos = new CollectionExpression("ORM_Infos", this.getDetachedCriteria());
		reviews = new CollectionExpression("ORM_Reviews", this.getDetachedCriteria());
		images = new CollectionExpression("ORM_Images", this.getDetachedCriteria());
	}
	
	public MaterialDetachedCriteria createMaterialsCriteria() {
		return new MaterialDetachedCriteria(createCriteria("ORM_Materials"));
	}
	
	public TechnicalInfoDetachedCriteria createInfosCriteria() {
		return new TechnicalInfoDetachedCriteria(createCriteria("ORM_Infos"));
	}
	
	public ReviewDetachedCriteria createReviewsCriteria() {
		return new ReviewDetachedCriteria(createCriteria("ORM_Reviews"));
	}
	
	public ImageDetachedCriteria createImagesCriteria() {
		return new ImageDetachedCriteria(createCriteria("ORM_Images"));
	}
	
	public Product uniqueProduct(PersistentSession session) {
		return (Product) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Product[] listProduct(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Product[]) list.toArray(new Product[list.size()]);
	}
}

