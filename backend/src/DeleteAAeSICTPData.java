/**
 * Licensee: mariana(Universidade do Minho)
 * License Type: Academic
 */
import org.orm.*;
public class DeleteAAeSICTPData {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = AAeSICTPPersistentManager.instance().getSession().beginTransaction();
		try {
			User user = UserDAO.loadUserByQuery(null, null);
			// Delete the persistent object
			UserDAO.delete(user);
			Admin admin = AdminDAO.loadAdminByQuery(null, null);
			// Delete the persistent object
			AdminDAO.delete(admin);
			Category category = CategoryDAO.loadCategoryByQuery(null, null);
			// Delete the persistent object
			CategoryDAO.delete(category);
			Product product = ProductDAO.loadProductByQuery(null, null);
			// Delete the persistent object
			ProductDAO.delete(product);
			ShoppingCart shoppingCart = ShoppingCartDAO.loadShoppingCartByQuery(null, null);
			// Delete the persistent object
			ShoppingCartDAO.delete(shoppingCart);
			Order order = OrderDAO.loadOrderByQuery(null, null);
			// Delete the persistent object
			OrderDAO.delete(order);
			Item item = ItemDAO.loadItemByQuery(null, null);
			// Delete the persistent object
			ItemDAO.delete(item);
			Material material = MaterialDAO.loadMaterialByQuery(null, null);
			// Delete the persistent object
			MaterialDAO.delete(material);
			OrderState orderState = OrderStateDAO.loadOrderStateByQuery(null, null);
			// Delete the persistent object
			OrderStateDAO.delete(orderState);
			Company company = CompanyDAO.loadCompanyByQuery(null, null);
			// Delete the persistent object
			CompanyDAO.delete(company);
			SocialNetwork socialNetwork = SocialNetworkDAO.loadSocialNetworkByQuery(null, null);
			// Delete the persistent object
			SocialNetworkDAO.delete(socialNetwork);
			Review review = ReviewDAO.loadReviewByQuery(null, null);
			// Delete the persistent object
			ReviewDAO.delete(review);
			_Costumer l_Costumer = _CostumerDAO.load_CostumerByQuery(null, null);
			// Delete the persistent object
			_CostumerDAO.delete(l_Costumer);
			OrderItem orderItem = OrderItemDAO.loadOrderItemByQuery(null, null);
			// Delete the persistent object
			OrderItemDAO.delete(orderItem);
			TechnicalInfo technicalInfo = TechnicalInfoDAO.loadTechnicalInfoByQuery(null, null);
			// Delete the persistent object
			TechnicalInfoDAO.delete(technicalInfo);
			Image image = ImageDAO.loadImageByQuery(null, null);
			// Delete the persistent object
			ImageDAO.delete(image);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			DeleteAAeSICTPData deleteAAeSICTPData = new DeleteAAeSICTPData();
			try {
				deleteAAeSICTPData.deleteTestData();
			}
			finally {
				AAeSICTPPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
