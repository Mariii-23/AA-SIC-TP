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

public class MaterialCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression name;
	public final StringExpression image;
	
	public MaterialCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		name = new StringExpression("name", this);
		image = new StringExpression("image", this);
	}
	
	public MaterialCriteria(PersistentSession session) {
		this(session.createCriteria(Material.class));
	}
	
	public MaterialCriteria() throws PersistentException {
		this(AAeSICTPPersistentManager.instance().getSession());
	}
	
	public Material uniqueMaterial() {
		return (Material) super.uniqueResult();
	}
	
	public Material[] listMaterial() {
		java.util.List list = super.list();
		return (Material[]) list.toArray(new Material[list.size()]);
	}
}

