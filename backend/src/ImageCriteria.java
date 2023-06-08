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

public class ImageCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression path;
	
	public ImageCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		path = new StringExpression("path", this);
	}
	
	public ImageCriteria(PersistentSession session) {
		this(session.createCriteria(Image.class));
	}
	
	public ImageCriteria() throws PersistentException {
		this(AAeSICTPPersistentManager.instance().getSession());
	}
	
	public Image uniqueImage() {
		return (Image) super.uniqueResult();
	}
	
	public Image[] listImage() {
		java.util.List list = super.list();
		return (Image[]) list.toArray(new Image[list.size()]);
	}
}

