/**
 * Licensee: mariana(Universidade do Minho)
 * License Type: Academic
 */
import org.orm.*;
public class CreateAAeSICTPData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = AAeSICTPPersistentManager.instance().getSession().beginTransaction();
		try {
			User user = UserDAO.createUser();
			// Initialize the properties of the persistent object here
			UserDAO.save(user);
			Admin admin = AdminDAO.createAdmin();
			// Initialize the properties of the persistent object here
			AdminDAO.save(admin);
			Category category = CategoryDAO.createCategory();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : products, subCategories
			CategoryDAO.save(category);
			Product product = ProductDAO.createProduct();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : images, reviews, infos, materials, price
			ProductDAO.save(product);
			ShoppingCart shoppingCart = ShoppingCartDAO.createShoppingCart();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : items
			ShoppingCartDAO.save(shoppingCart);
			Order order = OrderDAO.createOrder();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : items, total, storePickUp, state
			OrderDAO.save(order);
			Item item = ItemDAO.createItem();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : quantity, material, product
			ItemDAO.save(item);
			Material material = MaterialDAO.createMaterial();
			// Initialize the properties of the persistent object here
			MaterialDAO.save(material);
			OrderState orderState = OrderStateDAO.createOrderState();
			// Initialize the properties of the persistent object here
			OrderStateDAO.save(orderState);
			Company company = CompanyDAO.createCompany();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : socialNetworks, contact
			CompanyDAO.save(company);
			SocialNetwork socialNetwork = SocialNetworkDAO.createSocialNetwork();
			// Initialize the properties of the persistent object here
			SocialNetworkDAO.save(socialNetwork);
			Review review = ReviewDAO.createReview();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : classification, author
			ReviewDAO.save(review);
			_Costumer l_Costumer = _CostumerDAO.create_Costumer();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : favorites, orders
			_CostumerDAO.save(l_Costumer);
			OrderItem orderItem = OrderItemDAO.createOrderItem();
			// Initialize the properties of the persistent object here
			OrderItemDAO.save(orderItem);
			TechnicalInfo technicalInfo = TechnicalInfoDAO.createTechnicalInfo();
			// Initialize the properties of the persistent object here
			TechnicalInfoDAO.save(technicalInfo);
			Image image = ImageDAO.createImage();
			// Initialize the properties of the persistent object here
			ImageDAO.save(image);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateAAeSICTPData createAAeSICTPData = new CreateAAeSICTPData();
			try {
				createAAeSICTPData.createTestData();
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
