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

public class CategoryDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression name;
	public final StringExpression image;
	public final CollectionExpression subCategories;
	public final CollectionExpression products;
	
	public CategoryDetachedCriteria() {
		super(Category.class, CategoryCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		image = new StringExpression("image", this.getDetachedCriteria());
		subCategories = new CollectionExpression("ORM_SubCategories", this.getDetachedCriteria());
		products = new CollectionExpression("ORM_Products", this.getDetachedCriteria());
	}
	
	public CategoryDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, CategoryCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		image = new StringExpression("image", this.getDetachedCriteria());
		subCategories = new CollectionExpression("ORM_SubCategories", this.getDetachedCriteria());
		products = new CollectionExpression("ORM_Products", this.getDetachedCriteria());
	}
	
	public CategoryDetachedCriteria createSubCategoriesCriteria() {
		return new CategoryDetachedCriteria(createCriteria("ORM_SubCategories"));
	}
	
	public ProductDetachedCriteria createProductsCriteria() {
		return new ProductDetachedCriteria(createCriteria("ORM_Products"));
	}
	
	public Category uniqueCategory(PersistentSession session) {
		return (Category) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Category[] listCategory(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Category[]) list.toArray(new Category[list.size()]);
	}
}

