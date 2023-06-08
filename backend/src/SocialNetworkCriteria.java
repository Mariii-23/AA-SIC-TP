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

public class SocialNetworkCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression name;
	public final StringExpression link;
	
	public SocialNetworkCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		name = new StringExpression("name", this);
		link = new StringExpression("link", this);
	}
	
	public SocialNetworkCriteria(PersistentSession session) {
		this(session.createCriteria(SocialNetwork.class));
	}
	
	public SocialNetworkCriteria() throws PersistentException {
		this(AAeSICTPPersistentManager.instance().getSession());
	}
	
	public SocialNetwork uniqueSocialNetwork() {
		return (SocialNetwork) super.uniqueResult();
	}
	
	public SocialNetwork[] listSocialNetwork() {
		java.util.List list = super.list();
		return (SocialNetwork[]) list.toArray(new SocialNetwork[list.size()]);
	}
}

