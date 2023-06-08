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

public class CompanyCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression name;
	public final StringExpression email;
	public final IntegerExpression contact;
	public final StringExpression address;
	public final StringExpression logoImage;
	public final StringExpression postCode;
	public final StringExpression schedule;
	public final CollectionExpression socialNetworks;
	
	public CompanyCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		name = new StringExpression("name", this);
		email = new StringExpression("email", this);
		contact = new IntegerExpression("contact", this);
		address = new StringExpression("address", this);
		logoImage = new StringExpression("logoImage", this);
		postCode = new StringExpression("postCode", this);
		schedule = new StringExpression("schedule", this);
		socialNetworks = new CollectionExpression("ORM_SocialNetworks", this);
	}
	
	public CompanyCriteria(PersistentSession session) {
		this(session.createCriteria(Company.class));
	}
	
	public CompanyCriteria() throws PersistentException {
		this(AAeSICTPPersistentManager.instance().getSession());
	}
	
	public SocialNetworkCriteria createSocialNetworksCriteria() {
		return new SocialNetworkCriteria(createCriteria("ORM_SocialNetworks"));
	}
	
	public Company uniqueCompany() {
		return (Company) super.uniqueResult();
	}
	
	public Company[] listCompany() {
		java.util.List list = super.list();
		return (Company[]) list.toArray(new Company[list.size()]);
	}
}

