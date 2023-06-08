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

public class MaterialDAO {
	public static Material loadMaterialByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return loadMaterialByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Material getMaterialByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return getMaterialByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Material loadMaterialByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return loadMaterialByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Material getMaterialByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return getMaterialByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Material loadMaterialByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Material) session.load(Material.class, Integer.valueOf(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Material getMaterialByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Material) session.get(Material.class, Integer.valueOf(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Material loadMaterialByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Material) session.load(Material.class, Integer.valueOf(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Material getMaterialByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Material) session.get(Material.class, Integer.valueOf(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryMaterial(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return queryMaterial(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryMaterial(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return queryMaterial(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Material[] listMaterialByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return listMaterialByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Material[] listMaterialByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return listMaterialByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryMaterial(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Material as Material");
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
	
	public static List queryMaterial(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Material as Material");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Material", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Material[] listMaterialByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryMaterial(session, condition, orderBy);
			return (Material[]) list.toArray(new Material[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Material[] listMaterialByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryMaterial(session, condition, orderBy, lockMode);
			return (Material[]) list.toArray(new Material[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Material loadMaterialByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return loadMaterialByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Material loadMaterialByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return loadMaterialByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Material loadMaterialByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Material[] materials = listMaterialByQuery(session, condition, orderBy);
		if (materials != null && materials.length > 0)
			return materials[0];
		else
			return null;
	}
	
	public static Material loadMaterialByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Material[] materials = listMaterialByQuery(session, condition, orderBy, lockMode);
		if (materials != null && materials.length > 0)
			return materials[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateMaterialByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return iterateMaterialByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateMaterialByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return iterateMaterialByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateMaterialByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Material as Material");
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
	
	public static java.util.Iterator iterateMaterialByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Material as Material");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Material", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Material createMaterial() {
		return new Material();
	}
	
	public static boolean save(Material material) throws PersistentException {
		try {
			AAeSICTPPersistentManager.instance().saveObject(material);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(Material material) throws PersistentException {
		try {
			AAeSICTPPersistentManager.instance().deleteObject(material);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(Material material) throws PersistentException {
		try {
			AAeSICTPPersistentManager.instance().getSession().refresh(material);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(Material material) throws PersistentException {
		try {
			AAeSICTPPersistentManager.instance().getSession().evict(material);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Material loadMaterialByCriteria(MaterialCriteria materialCriteria) {
		Material[] materials = listMaterialByCriteria(materialCriteria);
		if(materials == null || materials.length == 0) {
			return null;
		}
		return materials[0];
	}
	
	public static Material[] listMaterialByCriteria(MaterialCriteria materialCriteria) {
		return materialCriteria.listMaterial();
	}
}
