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

public class TechnicalInfoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression name;
	public final StringExpression description;
	
	public TechnicalInfoDetachedCriteria() {
		super(TechnicalInfo.class, TechnicalInfoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		description = new StringExpression("description", this.getDetachedCriteria());
	}
	
	public TechnicalInfoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, TechnicalInfoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		description = new StringExpression("description", this.getDetachedCriteria());
	}
	
	public TechnicalInfo uniqueTechnicalInfo(PersistentSession session) {
		return (TechnicalInfo) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public TechnicalInfo[] listTechnicalInfo(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (TechnicalInfo[]) list.toArray(new TechnicalInfo[list.size()]);
	}
}

