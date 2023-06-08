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

public class CategoryCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression name;
	public final StringExpression image;
	public final CollectionExpression subCategories;
	public final CollectionExpression products;
	
	public CategoryCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		name = new StringExpression("name", this);
		image = new StringExpression("image", this);
		subCategories = new CollectionExpression("ORM_SubCategories", this);
		products = new CollectionExpression("ORM_Products", this);
	}
	
	public CategoryCriteria(PersistentSession session) {
		this(session.createCriteria(Category.class));
	}
	
	public CategoryCriteria() throws PersistentException {
		this(AAeSICTPPersistentManager.instance().getSession());
	}
	
	public CategoryCriteria createSubCategoriesCriteria() {
		return new CategoryCriteria(createCriteria("ORM_SubCategories"));
	}
	
	public ProductCriteria createProductsCriteria() {
		return new ProductCriteria(createCriteria("ORM_Products"));
	}
	
	public Category uniqueCategory() {
		return (Category) super.uniqueResult();
	}
	
	public Category[] listCategory() {
		java.util.List list = super.list();
		return (Category[]) list.toArray(new Category[list.size()]);
	}
}

