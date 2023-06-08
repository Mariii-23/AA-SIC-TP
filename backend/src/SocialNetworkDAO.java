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

public class SocialNetworkDAO {
	public static SocialNetwork loadSocialNetworkByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return loadSocialNetworkByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static SocialNetwork getSocialNetworkByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return getSocialNetworkByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static SocialNetwork loadSocialNetworkByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return loadSocialNetworkByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static SocialNetwork getSocialNetworkByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return getSocialNetworkByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static SocialNetwork loadSocialNetworkByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (SocialNetwork) session.load(SocialNetwork.class, Integer.valueOf(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static SocialNetwork getSocialNetworkByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (SocialNetwork) session.get(SocialNetwork.class, Integer.valueOf(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static SocialNetwork loadSocialNetworkByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (SocialNetwork) session.load(SocialNetwork.class, Integer.valueOf(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static SocialNetwork getSocialNetworkByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (SocialNetwork) session.get(SocialNetwork.class, Integer.valueOf(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List querySocialNetwork(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return querySocialNetwork(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List querySocialNetwork(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return querySocialNetwork(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static SocialNetwork[] listSocialNetworkByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return listSocialNetworkByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static SocialNetwork[] listSocialNetworkByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return listSocialNetworkByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List querySocialNetwork(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From SocialNetwork as SocialNetwork");
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
	
	public static List querySocialNetwork(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From SocialNetwork as SocialNetwork");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("SocialNetwork", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static SocialNetwork[] listSocialNetworkByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = querySocialNetwork(session, condition, orderBy);
			return (SocialNetwork[]) list.toArray(new SocialNetwork[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static SocialNetwork[] listSocialNetworkByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = querySocialNetwork(session, condition, orderBy, lockMode);
			return (SocialNetwork[]) list.toArray(new SocialNetwork[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static SocialNetwork loadSocialNetworkByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return loadSocialNetworkByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static SocialNetwork loadSocialNetworkByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return loadSocialNetworkByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static SocialNetwork loadSocialNetworkByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		SocialNetwork[] socialNetworks = listSocialNetworkByQuery(session, condition, orderBy);
		if (socialNetworks != null && socialNetworks.length > 0)
			return socialNetworks[0];
		else
			return null;
	}
	
	public static SocialNetwork loadSocialNetworkByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		SocialNetwork[] socialNetworks = listSocialNetworkByQuery(session, condition, orderBy, lockMode);
		if (socialNetworks != null && socialNetworks.length > 0)
			return socialNetworks[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateSocialNetworkByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return iterateSocialNetworkByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateSocialNetworkByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return iterateSocialNetworkByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateSocialNetworkByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From SocialNetwork as SocialNetwork");
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
	
	public static java.util.Iterator iterateSocialNetworkByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From SocialNetwork as SocialNetwork");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("SocialNetwork", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static SocialNetwork createSocialNetwork() {
		return new SocialNetwork();
	}
	
	public static boolean save(SocialNetwork socialNetwork) throws PersistentException {
		try {
			AAeSICTPPersistentManager.instance().saveObject(socialNetwork);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(SocialNetwork socialNetwork) throws PersistentException {
		try {
			AAeSICTPPersistentManager.instance().deleteObject(socialNetwork);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(SocialNetwork socialNetwork) throws PersistentException {
		try {
			AAeSICTPPersistentManager.instance().getSession().refresh(socialNetwork);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(SocialNetwork socialNetwork) throws PersistentException {
		try {
			AAeSICTPPersistentManager.instance().getSession().evict(socialNetwork);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static SocialNetwork loadSocialNetworkByCriteria(SocialNetworkCriteria socialNetworkCriteria) {
		SocialNetwork[] socialNetworks = listSocialNetworkByCriteria(socialNetworkCriteria);
		if(socialNetworks == null || socialNetworks.length == 0) {
			return null;
		}
		return socialNetworks[0];
	}
	
	public static SocialNetwork[] listSocialNetworkByCriteria(SocialNetworkCriteria socialNetworkCriteria) {
		return socialNetworkCriteria.listSocialNetwork();
	}
}
