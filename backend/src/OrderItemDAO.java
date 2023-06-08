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

public class OrderItemDAO {
	public static OrderItem loadOrderItemByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return loadOrderItemByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static OrderItem getOrderItemByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return getOrderItemByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static OrderItem loadOrderItemByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return loadOrderItemByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static OrderItem getOrderItemByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return getOrderItemByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static OrderItem loadOrderItemByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (OrderItem) session.load(OrderItem.class, Integer.valueOf(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static OrderItem getOrderItemByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (OrderItem) session.get(OrderItem.class, Integer.valueOf(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static OrderItem loadOrderItemByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (OrderItem) session.load(OrderItem.class, Integer.valueOf(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static OrderItem getOrderItemByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (OrderItem) session.get(OrderItem.class, Integer.valueOf(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryOrderItem(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return queryOrderItem(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryOrderItem(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return queryOrderItem(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static OrderItem[] listOrderItemByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return listOrderItemByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static OrderItem[] listOrderItemByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return listOrderItemByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryOrderItem(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From OrderItem as OrderItem");
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
	
	public static List queryOrderItem(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From OrderItem as OrderItem");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("OrderItem", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static OrderItem[] listOrderItemByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryOrderItem(session, condition, orderBy);
			return (OrderItem[]) list.toArray(new OrderItem[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static OrderItem[] listOrderItemByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryOrderItem(session, condition, orderBy, lockMode);
			return (OrderItem[]) list.toArray(new OrderItem[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static OrderItem loadOrderItemByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return loadOrderItemByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static OrderItem loadOrderItemByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return loadOrderItemByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static OrderItem loadOrderItemByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		OrderItem[] orderItems = listOrderItemByQuery(session, condition, orderBy);
		if (orderItems != null && orderItems.length > 0)
			return orderItems[0];
		else
			return null;
	}
	
	public static OrderItem loadOrderItemByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		OrderItem[] orderItems = listOrderItemByQuery(session, condition, orderBy, lockMode);
		if (orderItems != null && orderItems.length > 0)
			return orderItems[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateOrderItemByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return iterateOrderItemByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateOrderItemByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AAeSICTPPersistentManager.instance().getSession();
			return iterateOrderItemByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateOrderItemByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From OrderItem as OrderItem");
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
	
	public static java.util.Iterator iterateOrderItemByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From OrderItem as OrderItem");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("OrderItem", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static OrderItem createOrderItem() {
		return new OrderItem();
	}
	
	public static boolean save(OrderItem orderItem) throws PersistentException {
		try {
			AAeSICTPPersistentManager.instance().saveObject(orderItem);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(OrderItem orderItem) throws PersistentException {
		try {
			AAeSICTPPersistentManager.instance().deleteObject(orderItem);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(OrderItem orderItem) throws PersistentException {
		try {
			AAeSICTPPersistentManager.instance().getSession().refresh(orderItem);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(OrderItem orderItem) throws PersistentException {
		try {
			AAeSICTPPersistentManager.instance().getSession().evict(orderItem);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static OrderItem loadOrderItemByCriteria(OrderItemCriteria orderItemCriteria) {
		OrderItem[] orderItems = listOrderItemByCriteria(orderItemCriteria);
		if(orderItems == null || orderItems.length == 0) {
			return null;
		}
		return orderItems[0];
	}
	
	public static OrderItem[] listOrderItemByCriteria(OrderItemCriteria orderItemCriteria) {
		return orderItemCriteria.listOrderItem();
	}
}
