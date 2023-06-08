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

public class TechnicalInfoCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression name;
	public final StringExpression description;
	
	public TechnicalInfoCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		name = new StringExpression("name", this);
		description = new StringExpression("description", this);
	}
	
	public TechnicalInfoCriteria(PersistentSession session) {
		this(session.createCriteria(TechnicalInfo.class));
	}
	
	public TechnicalInfoCriteria() throws PersistentException {
		this(AAeSICTPPersistentManager.instance().getSession());
	}
	
	public TechnicalInfo uniqueTechnicalInfo() {
		return (TechnicalInfo) super.uniqueResult();
	}
	
	public TechnicalInfo[] listTechnicalInfo() {
		java.util.List list = super.list();
		return (TechnicalInfo[]) list.toArray(new TechnicalInfo[list.size()]);
	}
}

