/**
 * Licensee: mariana(Universidade do Minho)
 * License Type: Academic
 */
import org.orm.*;
public class RetrieveAndUpdateAAeSICTPData {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = AAeSICTPPersistentManager.instance().getSession().beginTransaction();
		try {
			User user = UserDAO.loadUserByQuery(null, null);
			// Update the properties of the persistent object
			UserDAO.save(user);
			Admin admin = AdminDAO.loadAdminByQuery(null, null);
			// Update the properties of the persistent object
			AdminDAO.save(admin);
			Category category = CategoryDAO.loadCategoryByQuery(null, null);
			// Update the properties of the persistent object
			CategoryDAO.save(category);
			Product product = ProductDAO.loadProductByQuery(null, null);
			// Update the properties of the persistent object
			ProductDAO.save(product);
			ShoppingCart shoppingCart = ShoppingCartDAO.loadShoppingCartByQuery(null, null);
			// Update the properties of the persistent object
			ShoppingCartDAO.save(shoppingCart);
			Order order = OrderDAO.loadOrderByQuery(null, null);
			// Update the properties of the persistent object
			OrderDAO.save(order);
			Item item = ItemDAO.loadItemByQuery(null, null);
			// Update the properties of the persistent object
			ItemDAO.save(item);
			Material material = MaterialDAO.loadMaterialByQuery(null, null);
			// Update the properties of the persistent object
			MaterialDAO.save(material);
			OrderState orderState = OrderStateDAO.loadOrderStateByQuery(null, null);
			// Update the properties of the persistent object
			OrderStateDAO.save(orderState);
			Company company = CompanyDAO.loadCompanyByQuery(null, null);
			// Update the properties of the persistent object
			CompanyDAO.save(company);
			SocialNetwork socialNetwork = SocialNetworkDAO.loadSocialNetworkByQuery(null, null);
			// Update the properties of the persistent object
			SocialNetworkDAO.save(socialNetwork);
			Review review = ReviewDAO.loadReviewByQuery(null, null);
			// Update the properties of the persistent object
			ReviewDAO.save(review);
			_Costumer l_Costumer = _CostumerDAO.load_CostumerByQuery(null, null);
			// Update the properties of the persistent object
			_CostumerDAO.save(l_Costumer);
			OrderItem orderItem = OrderItemDAO.loadOrderItemByQuery(null, null);
			// Update the properties of the persistent object
			OrderItemDAO.save(orderItem);
			TechnicalInfo technicalInfo = TechnicalInfoDAO.loadTechnicalInfoByQuery(null, null);
			// Update the properties of the persistent object
			TechnicalInfoDAO.save(technicalInfo);
			Image image = ImageDAO.loadImageByQuery(null, null);
			// Update the properties of the persistent object
			ImageDAO.save(image);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving User by UserCriteria");
		UserCriteria userCriteria = new UserCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//userCriteria.ID.eq();
		System.out.println(userCriteria.uniqueUser());
		
		System.out.println("Retrieving Admin by AdminCriteria");
		AdminCriteria adminCriteria = new AdminCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//adminCriteria.ID.eq();
		System.out.println(adminCriteria.uniqueAdmin());
		
		System.out.println("Retrieving Category by CategoryCriteria");
		CategoryCriteria categoryCriteria = new CategoryCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//categoryCriteria.ID.eq();
		System.out.println(categoryCriteria.uniqueCategory());
		
		System.out.println("Retrieving Product by ProductCriteria");
		ProductCriteria productCriteria = new ProductCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//productCriteria.ID.eq();
		System.out.println(productCriteria.uniqueProduct());
		
		System.out.println("Retrieving ShoppingCart by ShoppingCartCriteria");
		ShoppingCartCriteria shoppingCartCriteria = new ShoppingCartCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//shoppingCartCriteria.ID.eq();
		System.out.println(shoppingCartCriteria.uniqueShoppingCart());
		
		System.out.println("Retrieving Order by OrderCriteria");
		OrderCriteria orderCriteria = new OrderCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//orderCriteria.ID.eq();
		System.out.println(orderCriteria.uniqueOrder());
		
		System.out.println("Retrieving Item by ItemCriteria");
		ItemCriteria itemCriteria = new ItemCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//itemCriteria.ID.eq();
		System.out.println(itemCriteria.uniqueItem());
		
		System.out.println("Retrieving Material by MaterialCriteria");
		MaterialCriteria materialCriteria = new MaterialCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//materialCriteria.ID.eq();
		System.out.println(materialCriteria.uniqueMaterial());
		
		System.out.println("Retrieving OrderState by OrderStateCriteria");
		OrderStateCriteria orderStateCriteria = new OrderStateCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//orderStateCriteria.ID.eq();
		System.out.println(orderStateCriteria.uniqueOrderState());
		
		System.out.println("Retrieving Company by CompanyCriteria");
		CompanyCriteria companyCriteria = new CompanyCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//companyCriteria.ID.eq();
		System.out.println(companyCriteria.uniqueCompany());
		
		System.out.println("Retrieving SocialNetwork by SocialNetworkCriteria");
		SocialNetworkCriteria socialNetworkCriteria = new SocialNetworkCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//socialNetworkCriteria.ID.eq();
		System.out.println(socialNetworkCriteria.uniqueSocialNetwork());
		
		System.out.println("Retrieving Review by ReviewCriteria");
		ReviewCriteria reviewCriteria = new ReviewCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//reviewCriteria.ID.eq();
		System.out.println(reviewCriteria.uniqueReview());
		
		System.out.println("Retrieving _Costumer by _CostumerCriteria");
		_CostumerCriteria l_CostumerCriteria = new _CostumerCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//l_CostumerCriteria.ID.eq();
		System.out.println(l_CostumerCriteria.unique_Costumer());
		
		System.out.println("Retrieving OrderItem by OrderItemCriteria");
		OrderItemCriteria orderItemCriteria = new OrderItemCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//orderItemCriteria.ID.eq();
		System.out.println(orderItemCriteria.uniqueOrderItem());
		
		System.out.println("Retrieving TechnicalInfo by TechnicalInfoCriteria");
		TechnicalInfoCriteria technicalInfoCriteria = new TechnicalInfoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//technicalInfoCriteria.ID.eq();
		System.out.println(technicalInfoCriteria.uniqueTechnicalInfo());
		
		System.out.println("Retrieving Image by ImageCriteria");
		ImageCriteria imageCriteria = new ImageCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//imageCriteria.ID.eq();
		System.out.println(imageCriteria.uniqueImage());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateAAeSICTPData retrieveAndUpdateAAeSICTPData = new RetrieveAndUpdateAAeSICTPData();
			try {
				retrieveAndUpdateAAeSICTPData.retrieveAndUpdateTestData();
				//retrieveAndUpdateAAeSICTPData.retrieveByCriteria();
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
