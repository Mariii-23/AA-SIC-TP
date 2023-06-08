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

public class CompanyDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression name;
	public final StringExpression email;
	public final IntegerExpression contact;
	public final StringExpression address;
	public final StringExpression logoImage;
	public final StringExpression postCode;
	public final StringExpression schedule;
	public final CollectionExpression socialNetworks;
	
	public CompanyDetachedCriteria() {
		super(Company.class, CompanyCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		contact = new IntegerExpression("contact", this.getDetachedCriteria());
		address = new StringExpression("address", this.getDetachedCriteria());
		logoImage = new StringExpression("logoImage", this.getDetachedCriteria());
		postCode = new StringExpression("postCode", this.getDetachedCriteria());
		schedule = new StringExpression("schedule", this.getDetachedCriteria());
		socialNetworks = new CollectionExpression("ORM_SocialNetworks", this.getDetachedCriteria());
	}
	
	public CompanyDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, CompanyCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		contact = new IntegerExpression("contact", this.getDetachedCriteria());
		address = new StringExpression("address", this.getDetachedCriteria());
		logoImage = new StringExpression("logoImage", this.getDetachedCriteria());
		postCode = new StringExpression("postCode", this.getDetachedCriteria());
		schedule = new StringExpression("schedule", this.getDetachedCriteria());
		socialNetworks = new CollectionExpression("ORM_SocialNetworks", this.getDetachedCriteria());
	}
	
	public SocialNetworkDetachedCriteria createSocialNetworksCriteria() {
		return new SocialNetworkDetachedCriteria(createCriteria("ORM_SocialNetworks"));
	}
	
	public Company uniqueCompany(PersistentSession session) {
		return (Company) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Company[] listCompany(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Company[]) list.toArray(new Company[list.size()]);
	}
}

