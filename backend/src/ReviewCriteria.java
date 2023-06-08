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

public class ReviewCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression authorId;
	public final AssociationExpression author;
	public final IntegerExpression classification;
	public final StringExpression comment;
	
	public ReviewCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		authorId = new IntegerExpression("author.ID", this);
		author = new AssociationExpression("author", this);
		classification = new IntegerExpression("classification", this);
		comment = new StringExpression("comment", this);
	}
	
	public ReviewCriteria(PersistentSession session) {
		this(session.createCriteria(Review.class));
	}
	
	public ReviewCriteria() throws PersistentException {
		this(AAeSICTPPersistentManager.instance().getSession());
	}
	
	public _CostumerCriteria createAuthorCriteria() {
		return new _CostumerCriteria(createCriteria("author"));
	}
	
	public Review uniqueReview() {
		return (Review) super.uniqueResult();
	}
	
	public Review[] listReview() {
		java.util.List list = super.list();
		return (Review[]) list.toArray(new Review[list.size()]);
	}
}

