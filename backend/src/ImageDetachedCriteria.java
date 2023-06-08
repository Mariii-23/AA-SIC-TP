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

public class ImageDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression path;
	
	public ImageDetachedCriteria() {
		super(Image.class, ImageCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		path = new StringExpression("path", this.getDetachedCriteria());
	}
	
	public ImageDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, ImageCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		path = new StringExpression("path", this.getDetachedCriteria());
	}
	
	public Image uniqueImage(PersistentSession session) {
		return (Image) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Image[] listImage(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Image[]) list.toArray(new Image[list.size()]);
	}
}

