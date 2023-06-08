/**
 * Licensee: mariana(Universidade do Minho)
 * License Type: Academic
 */
import org.orm.*;
public class ListAAeSICTPData {
	private static final int ROW_COUNT = 100;
	
	public void listTestData() throws PersistentException {
		System.out.println("Listing User...");
		User[] users = UserDAO.listUserByQuery(null, null);
		int length = Math.min(users.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(users[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Admin...");
		Admin[] admins = AdminDAO.listAdminByQuery(null, null);
		length = Math.min(admins.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(admins[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Category...");
		Category[] categorys = CategoryDAO.listCategoryByQuery(null, null);
		length = Math.min(categorys.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(categorys[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Product...");
		Product[] products = ProductDAO.listProductByQuery(null, null);
		length = Math.min(products.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(products[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing ShoppingCart...");
		ShoppingCart[] shoppingCarts = ShoppingCartDAO.listShoppingCartByQuery(null, null);
		length = Math.min(shoppingCarts.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(shoppingCarts[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Order...");
		Order[] orders = OrderDAO.listOrderByQuery(null, null);
		length = Math.min(orders.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(orders[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Item...");
		Item[] items = ItemDAO.listItemByQuery(null, null);
		length = Math.min(items.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(items[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Material...");
		Material[] materials = MaterialDAO.listMaterialByQuery(null, null);
		length = Math.min(materials.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(materials[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing OrderState...");
		OrderState[] orderStates = OrderStateDAO.listOrderStateByQuery(null, null);
		length = Math.min(orderStates.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(orderStates[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Company...");
		Company[] companys = CompanyDAO.listCompanyByQuery(null, null);
		length = Math.min(companys.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(companys[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing SocialNetwork...");
		SocialNetwork[] socialNetworks = SocialNetworkDAO.listSocialNetworkByQuery(null, null);
		length = Math.min(socialNetworks.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(socialNetworks[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Review...");
		Review[] reviews = ReviewDAO.listReviewByQuery(null, null);
		length = Math.min(reviews.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(reviews[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing _Costumer...");
		_Costumer[] _Costumers = _CostumerDAO.list_CostumerByQuery(null, null);
		length = Math.min(_Costumers.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(_Costumers[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing OrderItem...");
		OrderItem[] orderItems = OrderItemDAO.listOrderItemByQuery(null, null);
		length = Math.min(orderItems.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(orderItems[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing TechnicalInfo...");
		TechnicalInfo[] technicalInfos = TechnicalInfoDAO.listTechnicalInfoByQuery(null, null);
		length = Math.min(technicalInfos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(technicalInfos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Image...");
		Image[] images = ImageDAO.listImageByQuery(null, null);
		length = Math.min(images.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(images[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException {
		System.out.println("Listing User by Criteria...");
		UserCriteria userCriteria = new UserCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//userCriteria.ID.eq();
		userCriteria.setMaxResults(ROW_COUNT);
		User[] users = userCriteria.listUser();
		int length =users== null ? 0 : Math.min(users.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(users[i]);
		}
		System.out.println(length + " User record(s) retrieved."); 
		
		System.out.println("Listing Admin by Criteria...");
		AdminCriteria adminCriteria = new AdminCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//adminCriteria.ID.eq();
		adminCriteria.setMaxResults(ROW_COUNT);
		Admin[] admins = adminCriteria.listAdmin();
		length =admins== null ? 0 : Math.min(admins.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(admins[i]);
		}
		System.out.println(length + " Admin record(s) retrieved."); 
		
		System.out.println("Listing Category by Criteria...");
		CategoryCriteria categoryCriteria = new CategoryCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//categoryCriteria.ID.eq();
		categoryCriteria.setMaxResults(ROW_COUNT);
		Category[] categorys = categoryCriteria.listCategory();
		length =categorys== null ? 0 : Math.min(categorys.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(categorys[i]);
		}
		System.out.println(length + " Category record(s) retrieved."); 
		
		System.out.println("Listing Product by Criteria...");
		ProductCriteria productCriteria = new ProductCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//productCriteria.ID.eq();
		productCriteria.setMaxResults(ROW_COUNT);
		Product[] products = productCriteria.listProduct();
		length =products== null ? 0 : Math.min(products.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(products[i]);
		}
		System.out.println(length + " Product record(s) retrieved."); 
		
		System.out.println("Listing ShoppingCart by Criteria...");
		ShoppingCartCriteria shoppingCartCriteria = new ShoppingCartCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//shoppingCartCriteria.ID.eq();
		shoppingCartCriteria.setMaxResults(ROW_COUNT);
		ShoppingCart[] shoppingCarts = shoppingCartCriteria.listShoppingCart();
		length =shoppingCarts== null ? 0 : Math.min(shoppingCarts.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(shoppingCarts[i]);
		}
		System.out.println(length + " ShoppingCart record(s) retrieved."); 
		
		System.out.println("Listing Order by Criteria...");
		OrderCriteria orderCriteria = new OrderCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//orderCriteria.ID.eq();
		orderCriteria.setMaxResults(ROW_COUNT);
		Order[] orders = orderCriteria.listOrder();
		length =orders== null ? 0 : Math.min(orders.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(orders[i]);
		}
		System.out.println(length + " Order record(s) retrieved."); 
		
		System.out.println("Listing Item by Criteria...");
		ItemCriteria itemCriteria = new ItemCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//itemCriteria.ID.eq();
		itemCriteria.setMaxResults(ROW_COUNT);
		Item[] items = itemCriteria.listItem();
		length =items== null ? 0 : Math.min(items.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(items[i]);
		}
		System.out.println(length + " Item record(s) retrieved."); 
		
		System.out.println("Listing Material by Criteria...");
		MaterialCriteria materialCriteria = new MaterialCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//materialCriteria.ID.eq();
		materialCriteria.setMaxResults(ROW_COUNT);
		Material[] materials = materialCriteria.listMaterial();
		length =materials== null ? 0 : Math.min(materials.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(materials[i]);
		}
		System.out.println(length + " Material record(s) retrieved."); 
		
		System.out.println("Listing OrderState by Criteria...");
		OrderStateCriteria orderStateCriteria = new OrderStateCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//orderStateCriteria.ID.eq();
		orderStateCriteria.setMaxResults(ROW_COUNT);
		OrderState[] orderStates = orderStateCriteria.listOrderState();
		length =orderStates== null ? 0 : Math.min(orderStates.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(orderStates[i]);
		}
		System.out.println(length + " OrderState record(s) retrieved."); 
		
		System.out.println("Listing Company by Criteria...");
		CompanyCriteria companyCriteria = new CompanyCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//companyCriteria.ID.eq();
		companyCriteria.setMaxResults(ROW_COUNT);
		Company[] companys = companyCriteria.listCompany();
		length =companys== null ? 0 : Math.min(companys.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(companys[i]);
		}
		System.out.println(length + " Company record(s) retrieved."); 
		
		System.out.println("Listing SocialNetwork by Criteria...");
		SocialNetworkCriteria socialNetworkCriteria = new SocialNetworkCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//socialNetworkCriteria.ID.eq();
		socialNetworkCriteria.setMaxResults(ROW_COUNT);
		SocialNetwork[] socialNetworks = socialNetworkCriteria.listSocialNetwork();
		length =socialNetworks== null ? 0 : Math.min(socialNetworks.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(socialNetworks[i]);
		}
		System.out.println(length + " SocialNetwork record(s) retrieved."); 
		
		System.out.println("Listing Review by Criteria...");
		ReviewCriteria reviewCriteria = new ReviewCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//reviewCriteria.ID.eq();
		reviewCriteria.setMaxResults(ROW_COUNT);
		Review[] reviews = reviewCriteria.listReview();
		length =reviews== null ? 0 : Math.min(reviews.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(reviews[i]);
		}
		System.out.println(length + " Review record(s) retrieved."); 
		
		System.out.println("Listing _Costumer by Criteria...");
		_CostumerCriteria l_CostumerCriteria = new _CostumerCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//l_CostumerCriteria.ID.eq();
		l_CostumerCriteria.setMaxResults(ROW_COUNT);
		_Costumer[] _Costumers = l_CostumerCriteria.list_Costumer();
		length =_Costumers== null ? 0 : Math.min(_Costumers.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(_Costumers[i]);
		}
		System.out.println(length + " _Costumer record(s) retrieved."); 
		
		System.out.println("Listing OrderItem by Criteria...");
		OrderItemCriteria orderItemCriteria = new OrderItemCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//orderItemCriteria.ID.eq();
		orderItemCriteria.setMaxResults(ROW_COUNT);
		OrderItem[] orderItems = orderItemCriteria.listOrderItem();
		length =orderItems== null ? 0 : Math.min(orderItems.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(orderItems[i]);
		}
		System.out.println(length + " OrderItem record(s) retrieved."); 
		
		System.out.println("Listing TechnicalInfo by Criteria...");
		TechnicalInfoCriteria technicalInfoCriteria = new TechnicalInfoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//technicalInfoCriteria.ID.eq();
		technicalInfoCriteria.setMaxResults(ROW_COUNT);
		TechnicalInfo[] technicalInfos = technicalInfoCriteria.listTechnicalInfo();
		length =technicalInfos== null ? 0 : Math.min(technicalInfos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(technicalInfos[i]);
		}
		System.out.println(length + " TechnicalInfo record(s) retrieved."); 
		
		System.out.println("Listing Image by Criteria...");
		ImageCriteria imageCriteria = new ImageCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//imageCriteria.ID.eq();
		imageCriteria.setMaxResults(ROW_COUNT);
		Image[] images = imageCriteria.listImage();
		length =images== null ? 0 : Math.min(images.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(images[i]);
		}
		System.out.println(length + " Image record(s) retrieved."); 
		
	}
	
	public static void main(String[] args) {
		try {
			ListAAeSICTPData listAAeSICTPData = new ListAAeSICTPData();
			try {
				listAAeSICTPData.listTestData();
				//listAAeSICTPData.listByCriteria();
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
