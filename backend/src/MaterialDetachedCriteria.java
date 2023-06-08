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

public class MaterialDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression name;
	public final StringExpression image;
	
	public MaterialDetachedCriteria() {
		super(Material.class, MaterialCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		image = new StringExpression("image", this.getDetachedCriteria());
	}
	
	public MaterialDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, MaterialCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		image = new StringExpression("image", this.getDetachedCriteria());
	}
	
	public Material uniqueMaterial(PersistentSession session) {
		return (Material) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Material[] listMaterial(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Material[]) list.toArray(new Material[list.size()]);
	}
}

