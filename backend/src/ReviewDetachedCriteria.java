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

public class ReviewDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression authorId;
	public final AssociationExpression author;
	public final IntegerExpression classification;
	public final StringExpression comment;
	
	public ReviewDetachedCriteria() {
		super(Review.class, ReviewCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		authorId = new IntegerExpression("author.ID", this.getDetachedCriteria());
		author = new AssociationExpression("author", this.getDetachedCriteria());
		classification = new IntegerExpression("classification", this.getDetachedCriteria());
		comment = new StringExpression("comment", this.getDetachedCriteria());
	}
	
	public ReviewDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, ReviewCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		authorId = new IntegerExpression("author.ID", this.getDetachedCriteria());
		author = new AssociationExpression("author", this.getDetachedCriteria());
		classification = new IntegerExpression("classification", this.getDetachedCriteria());
		comment = new StringExpression("comment", this.getDetachedCriteria());
	}
	
	public _CostumerDetachedCriteria createAuthorCriteria() {
		return new _CostumerDetachedCriteria(createCriteria("author"));
	}
	
	public Review uniqueReview(PersistentSession session) {
		return (Review) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Review[] listReview(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Review[]) list.toArray(new Review[list.size()]);
	}
}

