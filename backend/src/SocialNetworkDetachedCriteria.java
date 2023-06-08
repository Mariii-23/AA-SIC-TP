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

public class SocialNetworkDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression name;
	public final StringExpression link;
	
	public SocialNetworkDetachedCriteria() {
		super(SocialNetwork.class, SocialNetworkCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		link = new StringExpression("link", this.getDetachedCriteria());
	}
	
	public SocialNetworkDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, SocialNetworkCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		link = new StringExpression("link", this.getDetachedCriteria());
	}
	
	public SocialNetwork uniqueSocialNetwork(PersistentSession session) {
		return (SocialNetwork) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public SocialNetwork[] listSocialNetwork(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (SocialNetwork[]) list.toArray(new SocialNetwork[list.size()]);
	}
}

