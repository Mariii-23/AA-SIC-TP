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

public class ReviewDAO {
	public static Review loadReviewByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return loadReviewByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Review getReviewByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return getReviewByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Review loadReviewByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return loadReviewByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Review getReviewByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return getReviewByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Review loadReviewByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Review) session.load(Review.class, Integer.valueOf(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Review getReviewByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Review) session.get(Review.class, Integer.valueOf(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Review loadReviewByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Review) session.load(Review.class, Integer.valueOf(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Review getReviewByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Review) session.get(Review.class, Integer.valueOf(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryReview(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return queryReview(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryReview(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return queryReview(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Review[] listReviewByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return listReviewByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Review[] listReviewByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return listReviewByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryReview(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Review as Review");
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
	
	public static List queryReview(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Review as Review");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Review", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Review[] listReviewByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryReview(session, condition, orderBy);
			return (Review[]) list.toArray(new Review[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Review[] listReviewByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryReview(session, condition, orderBy, lockMode);
			return (Review[]) list.toArray(new Review[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Review loadReviewByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return loadReviewByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Review loadReviewByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return loadReviewByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Review loadReviewByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Review[] reviews = listReviewByQuery(session, condition, orderBy);
		if (reviews != null && reviews.length > 0)
			return reviews[0];
		else
			return null;
	}
	
	public static Review loadReviewByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Review[] reviews = listReviewByQuery(session, condition, orderBy, lockMode);
		if (reviews != null && reviews.length > 0)
			return reviews[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateReviewByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return iterateReviewByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateReviewByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return iterateReviewByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateReviewByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Review as Review");
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
	
	public static java.util.Iterator iterateReviewByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Review as Review");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Review", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Review createReview() {
		return new Review();
	}
	
	public static boolean save(Review review) throws PersistentException {
		try {
			AAeSICTPPersistentManager.instance().saveObject(review);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(Review review) throws PersistentException {
		try {
			AAeSICTPPersistentManager.instance().deleteObject(review);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(Review review) throws PersistentException {
		try {
			AAeSICTPPersistentManager.instance().getSession().refresh(review);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(Review review) throws PersistentException {
		try {
			AAeSICTPPersistentManager.instance().getSession().evict(review);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Review loadReviewByCriteria(ReviewCriteria reviewCriteria) {
		Review[] reviews = listReviewByCriteria(reviewCriteria);
		if(reviews == null || reviews.length == 0) {
			return null;
		}
		return reviews[0];
	}
	
	public static Review[] listReviewByCriteria(ReviewCriteria reviewCriteria) {
		return reviewCriteria.listReview();
	}
}
