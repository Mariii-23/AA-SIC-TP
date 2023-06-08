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
import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

public class ImageDAO {
	public static Image loadImageByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return loadImageByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Image getImageByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return getImageByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Image loadImageByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return loadImageByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Image getImageByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return getImageByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Image loadImageByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Image) session.load(Image.class, Integer.valueOf(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Image getImageByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Image) session.get(Image.class, Integer.valueOf(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Image loadImageByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Image) session.load(Image.class, Integer.valueOf(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Image getImageByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Image) session.get(Image.class, Integer.valueOf(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryImage(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return queryImage(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryImage(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return queryImage(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Image[] listImageByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return listImageByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Image[] listImageByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return listImageByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryImage(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Image as Image");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryImage(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Image as Image");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Image", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Image[] listImageByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryImage(session, condition, orderBy);
			return (Image[]) list.toArray(new Image[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Image[] listImageByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryImage(session, condition, orderBy, lockMode);
			return (Image[]) list.toArray(new Image[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Image loadImageByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return loadImageByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Image loadImageByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return loadImageByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Image loadImageByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Image[] images = listImageByQuery(session, condition, orderBy);
		if (images != null && images.length > 0)
			return images[0];
		else
			return null;
	}
	
	public static Image loadImageByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Image[] images = listImageByQuery(session, condition, orderBy, lockMode);
		if (images != null && images.length > 0)
			return images[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateImageByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return iterateImageByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateImageByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return iterateImageByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateImageByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Image as Image");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateImageByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Image as Image");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Image", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Image createImage() {
		return new Image();
	}
	
	public static boolean save(Image image) throws PersistentException {
		try {
			AAeSICTPPersistentManager.instance().saveObject(image);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(Image image) throws PersistentException {
		try {
			AAeSICTPPersistentManager.instance().deleteObject(image);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(Image image) throws PersistentException {
		try {
			AAeSICTPPersistentManager.instance().getSession().refresh(image);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(Image image) throws PersistentException {
		try {
			AAeSICTPPersistentManager.instance().getSession().evict(image);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Image loadImageByCriteria(ImageCriteria imageCriteria) {
		Image[] images = listImageByCriteria(imageCriteria);
		if(images == null || images.length == 0) {
			return null;
		}
		return images[0];
	}
	
	public static Image[] listImageByCriteria(ImageCriteria imageCriteria) {
		return imageCriteria.listImage();
	}
}
