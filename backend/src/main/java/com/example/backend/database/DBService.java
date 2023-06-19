package com.example.backend.database;

import com.example.backend.exception.UserNotFoundException;
import com.example.backend.dto.userDTOs.CreateAdminDTO;
import com.example.backend.dto.userDTOs.CreateCustomerDTO;
import com.example.backend.model.*;
import com.example.backend.repositories.*;
import com.example.backend.services.AuthenticateService;
import com.example.backend.services.OrderService;
import com.example.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service("dbService")
public class DBService{
    @Autowired
    private AuthenticateService authenticateService;

    @Autowired
    private UserService userService;

    @Autowired
    private CustomerRep customerRep;

    @Autowired
    private ProductRep productRep;

    @Autowired
    private MaterialRep materialRep;

    @Autowired
    private CategoryRep categoryRep;

    @Autowired
    private SubCategoryRep subCategoryRep;

    @Autowired
    private ImageRep imageRep;

    @Autowired
    private OrderService orderService;

    @Autowired
    private CompanyRep companyRep;

    @Autowired
    private SocialNetworkRep socialNetworkRep;


    public void addUsers() throws Exception {

        authenticateService.register(new CreateCustomerDTO(new Date(1990, 3, 15), "123456789A", "123 Main Street, Cityville", "customer1@example.com", "password1", "John Smith"));
        authenticateService.register(new CreateCustomerDTO(new Date(1985, 7, 2), "987654321B", "456 Elm Avenue, Townsville", "customer2@example.com", "password2", "Jane Johnson"));
        authenticateService.register(new CreateCustomerDTO(new Date(1992, 1, 9), "246813579C", "789 Oak Road, Villageton", "customer3@example.com", "password3", "Robert Davis"));
        authenticateService.register(new CreateCustomerDTO(new Date(1988, 11, 26), "135792468D", "321 Pine Lane, Hamletown", "customer4@example.com", "password4", "Emily Wilson"));
        authenticateService.register(new CreateCustomerDTO(new Date(1995, 5, 4), "864209753E", "654 Maple Drive, Boroughburg", "customer5@example.com", "password5", "Michael Thompson"));
        authenticateService.register(new CreateCustomerDTO(new Date(1984, 2, 21), "579314682F", "987 Cedar Street, Villaville", "customer6@example.com", "password6", "Sarah Roberts"));
        authenticateService.register(new CreateCustomerDTO(new Date(1991, 8, 10), "951623487G", "159 Birch Court, Townberg", "customer7@example.com", "password7", "David Lee"));
        authenticateService.register(new CreateCustomerDTO(new Date(1987, 12, 3), "792468135H", "753 Oakwood Avenue, Hamletham", "customer8@example.com", "password8", "Jennifer Scott"));
        authenticateService.register(new CreateCustomerDTO(new Date(1993, 6, 18), "246813579I", "357 Pine Lane, Cityton", "customer9@example.com", "password9", "Christopher Martin"));
        authenticateService.register(new CreateCustomerDTO(new Date(1986, 9, 27), "468135792J", "951 Maple Drive, Villaburg", "customer10@example.com", "password10", "Amanda Turner"));
        authenticateService.register(new CreateCustomerDTO(new Date(1994, 4, 12), "246801357K", "753 Cedar Street, Boroughville", "customer11@example.com", "password11", "Matthew Harris"));
        authenticateService.register(new CreateCustomerDTO(new Date(1983, 10, 29), "135792468L", "357 Birch Court, Townham", "customer12@example.com", "password12", "Laura Clark"));
        authenticateService.register(new CreateCustomerDTO(new Date(1990, 2, 7), "579314682M", "951 Oakwood Avenue, Citytown", "customer13@example.com", "password13", "Daniel Baker"));
        authenticateService.register(new CreateCustomerDTO(new Date(1985, 7, 26), "468135792N", "753 Pine Lane, Villaville", "customer14@example.com", "password14", "Olivia Phillips"));
        authenticateService.register(new CreateCustomerDTO(new Date(1992, 1, 3), "791364825O", "357 Maple Drive, Hamletown", "customer15@example.com", "password15", "James Cooper"));
        authenticateService.register(new CreateCustomerDTO(new Date(1988, 11, 20), "579314682P", "951 Cedar Street, Cityville", "customer16@example.com", "password16", "Sophia Martinez"));
        authenticateService.register(new CreateCustomerDTO(new Date(1995, 6, 8), "468135792Q", "753 Birch Court, Townsville", "customer17@example.com", "password17", "Ryan Thompson"));
        authenticateService.register(new CreateCustomerDTO(new Date(1984, 3, 25), "791364825R", "357 Oakwood Avenue, Villageton", "customer18@example.com", "password18", "Emma Davis"));
        authenticateService.register(new CreateCustomerDTO(new Date(1991, 9, 14), "135792468S", "951 Pine Lane, Hamletown", "customer19@example.com", "password19", "Alexander Wilson"));
        authenticateService.register(new CreateCustomerDTO(new Date(1987, 12, 31), "579314682T", "753 Maple Drive, Boroughburg", "customer20@example.com", "password20", "Mia Johnson"));
        authenticateService.register(new CreateCustomerDTO(new Date(1993, 7, 17), "468135792U", "357 Cedar Street, Villaville", "customer21@example.com", "password21", "William Roberts"));
        authenticateService.register(new CreateCustomerDTO(new Date(1986, 10, 5), "791364825V", "951 Birch Court, Townberg", "customer22@example.com", "password22", "Grace Lee"));
        authenticateService.register(new CreateCustomerDTO(new Date(1994, 5, 21), "135792468W", "753 Oakwood Avenue, Hamletham", "customer23@example.com", "password23", "Joseph Scott"));
        authenticateService.register(new CreateCustomerDTO(new Date(1983, 11, 8), "579314682X", "357 Pine Lane, Cityton", "customer24@example.com", "password24", "Samantha Martin"));
        authenticateService.register(new CreateCustomerDTO(new Date(1990, 3, 24), "468135792Y", "951 Maple Drive, Villaburg", "customer25@example.com", "password25", "Benjamin Turner"));
        authenticateService.register(new CreateCustomerDTO(new Date(1985, 8, 12), "791364825Z", "753 Cedar Street, Boroughville", "customer26@example.com", "password26", "Natalie Harris"));
        authenticateService.register(new CreateCustomerDTO(new Date(1992, 2, 28), "246801357AA", "357 Birch Court, Townham", "customer27@example.com", "password27", "Andrew Clark"));
        authenticateService.register(new CreateCustomerDTO(new Date(1988, 12, 15), "135792468AB", "951 Oakwood Avenue, Citytown", "customer28@example.com", "password28", "Isabella Baker"));
        authenticateService.register(new CreateCustomerDTO(new Date(1995, 7, 2), "579314682AC", "753 Pine Lane, Villaville", "customer29@example.com", "password29", "Ethan Phillips"));
        authenticateService.register(new CreateCustomerDTO(new Date(1984, 4, 18), "468135792AD", "357 Maple Drive, Hamletown", "customer30@example.com", "password30", "Chloe Cooper"));
        authenticateService.register(new CreateCustomerDTO(new Date(1991, 10, 4), "246801357AE", "951 Cedar Street, Cityville", "customer31@example.com", "password31", "Liam Martinez"));
        authenticateService.register(new CreateCustomerDTO(new Date(1987, 12, 21), "135792468AF", "753 Birch Court, Townsville", "customer32@example.com", "password32", "Victoria Thompson"));
        authenticateService.register(new CreateCustomerDTO(new Date(1993, 8, 7), "579314682AG", "357 Oakwood Avenue, Villageton", "customer33@example.com", "password33", "Noah Davis"));
        authenticateService.register(new CreateCustomerDTO(new Date(1986, 11, 25), "468135792AH", "951 Pine Lane, Hamletown", "customer34@example.com", "password34", "Elizabeth Wilson"));
        authenticateService.register(new CreateCustomerDTO(new Date(1994, 6, 12), "246801357AI", "753 Maple Drive, Boroughburg", "customer35@example.com", "password35", "Jacob Johnson"));
        authenticateService.register(new CreateCustomerDTO(new Date(1983, 12, 29), "135792468AJ", "357 Cedar Street, Villaville", "customer36@example.com", "password36", "Ava Roberts"));
        authenticateService.register(new CreateCustomerDTO(new Date(1990, 4, 15), "579314682AK", "951 Birch Court, Townberg", "customer37@example.com", "password37", "Michael Lee"));
        authenticateService.register(new CreateCustomerDTO(new Date(1985, 9, 1), "468135792AL", "753 Oakwood Avenue, Hamletham", "customer38@example.com", "password38", "Emily Scott"));
        authenticateService.register(new CreateCustomerDTO(new Date(1992, 2, 17), "791364825AM", "357 Pine Lane, Cityton", "customer39@example.com", "password39", "Matthew Martin"));

        for(int i = 0; i < 500; i++){
            authenticateService.register(new CreateCustomerDTO(new Date(1995, 6, 8), String.valueOf(111111111 + i), "753 Birch Court, Townsville", "customer" + (40 + i) + "@example.com", "password" + (40 + i), "Ryan Thompson"));
        }


        userService.addAdminDTO(new CreateAdminDTO("admin@admin.com", "password", "Admin"));
        userService.addAdminDTO(new CreateAdminDTO("admin1@example.com", "adminpassword1", "Admin Smith"));
        userService.addAdminDTO(new CreateAdminDTO("admin2@example.com", "adminpassword2", "Admin Johnson"));
        userService.addAdminDTO(new CreateAdminDTO("admin3@example.com", "adminpassword3", "Admin Davis"));
        userService.addAdminDTO(new CreateAdminDTO("admin4@example.com", "adminpassword4", "Admin Wilson"));
        userService.addAdminDTO(new CreateAdminDTO("admin5@example.com", "adminpassword5", "Admin Thompson"));
        userService.addAdminDTO(new CreateAdminDTO("admin6@example.com", "adminpassword6", "Admin Roberts"));
        userService.addAdminDTO(new CreateAdminDTO("admin7@example.com", "adminpassword7", "Admin Lee"));
        userService.addAdminDTO(new CreateAdminDTO("admin8@example.com", "adminpassword8", "Admin Scott"));
        userService.addAdminDTO(new CreateAdminDTO("admin9@example.com", "adminpassword9", "Admin Martin"));
        userService.addAdminDTO(new CreateAdminDTO("admin10@example.com", "adminpassword10", "Admin Turner"));

    }

    public void addMaterials() throws IOException {
        List<Material> materials = new ArrayList<>();
        byte[] image1 = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/image1.jpg"));

        materials.add(new Material("Oak Wood", image1));
        materials.add(new Material("Mahogany", image1));
        materials.add(new Material("Leather", image1));
        materials.add(new Material("Wicker", image1));
        materials.add(new Material("Velvet", image1));
        materials.add(new Material("Bamboo", image1));
        materials.add(new Material("Suede", image1));
        materials.add(new Material("Rattan", image1));
        materials.add(new Material("Microfiber", image1));
        materials.add(new Material("Linen", image1));
        materials.add(new Material("Cotton", image1));
        materials.add(new Material("Silk", image1));
        materials.add(new Material("Acrylic", image1));
        materials.add(new Material("Polyester", image1));
        materials.add(new Material("Metal", image1));
        materials.add(new Material("Glass", image1));
        materials.add(new Material("Marble", image1));
        materials.add(new Material("Granite", image1));
        materials.add(new Material("Cork", image1));
        materials.add(new Material("Plastic", image1));

        materialRep.saveAll(materials);
    }

    public void addCategories() throws IOException {
        List<Category> categories = new ArrayList<>();
        byte[] image1 = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/image1.jpg"));
        byte[] image2 = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/image2.jpg"));
        byte[] image3 = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/image3.jpg"));


        categories.add(new Category("Living Room", image1));
        categories.add(new Category("Bedroom", image1));
        categories.add(new Category("Dining Room", image1));
        categories.add(new Category("Office",image1));
        categories.add(new Category("Outdoor", image1));
        categories.add(new Category("Kitchen", image1));
        categories.add(new Category("Bathroom", image2));
        categories.add(new Category("Kids", image2));
        categories.add(new Category("Entertainment", image2));
        categories.add(new Category("Storage", image2));
        categories.add(new Category("Accent", image2));
        categories.add(new Category("Workspace", image2));
        categories.add(new Category("Entryway", image2));
        categories.add(new Category("Garden", image2));
        categories.add(new Category("Nursery", image3));
        categories.add(new Category("Patio", image3));
        categories.add(new Category("Bar", image3));
        categories.add(new Category("Library", image3));
        categories.add(new Category("Playroom", image3));
        categories.add(new Category("Gym", image3));

        categoryRep.saveAll(categories);

    }

    public void addSubcategories() throws IOException {
        List<Category> categories = categoryRep.findAll();
        int size = categories.size();
        List<SubCategory> subCategories = new ArrayList<>();
        Random random = new Random();

        byte[] image1 = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/image1.jpg"));
        byte[] image2 = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/image2.jpg"));
        byte[] image3 = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/image3.jpg"));


        subCategories.add(new SubCategory("Sofas", image1, categories.get(0)));
        subCategories.add(new SubCategory("Beds", image1, categories.get(1)));
        subCategories.add(new SubCategory("Dining Tables", image1, categories.get( 2)));
        subCategories.add(new SubCategory("Desks", image1, categories.get(3)));
        subCategories.add(new SubCategory("Outdoor Sets", image1, categories.get( 4)));
        subCategories.add(new SubCategory("Cabinets", image2, categories.get( 5)));
        subCategories.add(new SubCategory("Toilets", image2, categories.get( 6)));
        subCategories.add(new SubCategory("Kids Beds", image2, categories.get( 7)));
        subCategories.add(new SubCategory("Chairs", image3, categories.get( 8)));
        subCategories.add(new SubCategory("Tables", image3, categories.get(9)));
        subCategories.add(new SubCategory("Bookcases", image3, categories.get(10)));
        subCategories.add(new SubCategory("Office Chairs", image3, categories.get(11)));
        subCategories.add(new SubCategory("Benches", image3, categories.get(12)));
        subCategories.add(new SubCategory("Garden Sets", image3, categories.get(13)));
        subCategories.add(new SubCategory("Cribs", image3, categories.get(14)));
        subCategories.add(new SubCategory("Patio Sets", image3, categories.get(15)));
        subCategories.add(new SubCategory("Bar Stools", image3, categories.get(16)));
        subCategories.add(new SubCategory("Bookshelves", image3, categories.get(17)));
        subCategories.add(new SubCategory("Play Tables", image3, categories.get(18)));
        subCategories.add(new SubCategory("Treadmills", image3, categories.get(19)));

        subCategoryRep.saveAll(subCategories);
    }

    public void addProducts() throws IOException {
        List<Material> materials = materialRep.findAll();
        List<SubCategory> subCategories = subCategoryRep.findAll();
        List<Product> products = new ArrayList<>();

        int materials_size = materials.size();
        int subcategories_size = subCategories.size();

        Random random = new Random();

        SubCategory s1 = subCategories.get(0);
        List<Material> m1 = new ArrayList<>();
        for(int i = 0; i < 2; i++) m1.add(materials.get(random.nextInt(materials_size)));
        products.add((new Product(799.99, "Leather Sofa", "Stylish and comfortable leather sofa.", m1, s1.getCategory(), s1)));

        SubCategory s2 = subCategories.get(1);
        List<Material> m2 = new ArrayList<>();
        for(int i = 0; i < 2; i++) m2.add(materials.get(random.nextInt(materials_size)));
        products.add((new Product(499.99, "Wooden Bed", "Stylish and comfortable wooden bed.", m2, s2.getCategory(), s2)));

        SubCategory s3 = subCategories.get(2);
        List<Material> m3 = new ArrayList<>();
        for(int i = 0; i < 2; i++) m3.add(materials.get(random.nextInt(materials_size)));
            products.add((new Product(299.99, "Wooden Dining Table", "Stylish and comfortable wooden dining table.", m3, s3.getCategory(), s3)));

        SubCategory s4 = subCategories.get(3);
        List<Material> m4 = new ArrayList<>();
        for(int i = 0; i < 2; i++) m4.add(materials.get(random.nextInt(materials_size)));
        products.add((new Product(199.99, "Wooden Desk", "Stylish and comfortable wooden desk.", m4, s4.getCategory(), s4)));

        SubCategory s5 = subCategories.get(4);
        List<Material> m5 = new ArrayList<>();
        for(int i = 0; i < 2; i++) m5.add(materials.get(random.nextInt(materials_size)));
        products.add((new Product(99.99, "Wooden Outdoor Set", "Stylish and comfortable wooden outdoor set.", m5, s5.getCategory(), s5)));

        SubCategory s6 = subCategories.get(5);
        List<Material> m6 = new ArrayList<>();
        for(int i = 0; i < 2; i++) m6.add(materials.get(random.nextInt(materials_size)));
        products.add((new Product(99.99, "Wooden Cabinet", "Stylish and comfortable wooden cabinet.", m6, s6.getCategory(), s6)));

        SubCategory s7 = subCategories.get(6);
        List<Material> m7 = new ArrayList<>();
        for(int i = 0; i < 2; i++) m7.add(materials.get(random.nextInt(materials_size)));
        products.add((new Product(99.99, "Wooden Toilet", "Stylish and comfortable wooden toilet.", m7, s7.getCategory(), s7)));

        SubCategory s8 = subCategories.get(7);
        List<Material> m8 = new ArrayList<>();
        for(int i = 0; i < 2; i++) m8.add(materials.get(random.nextInt(materials_size)));
        products.add((new Product(99.99, "Wooden Kids Bed", "Stylish and comfortable wooden kids bed.", m8, s8.getCategory(), s8)));

        SubCategory s9 = subCategories.get(8);
        List<Material> m9 = new ArrayList<>();
        for(int i = 0; i < 2; i++) m9.add(materials.get(random.nextInt(materials_size)));
        products.add((new Product(99.99, "Wooden Chair", "Stylish and comfortable wooden chair.", m9, s9.getCategory(), s9)));

        SubCategory s10 = subCategories.get(9);
        List<Material> m10 = new ArrayList<>();
        for(int i = 0; i < 2; i++) m10.add(materials.get(random.nextInt(materials_size)));
        products.add((new Product(99.99, "Wooden Coffee Table", "Stylish and comfortable wooden coffee table.", m10, s10.getCategory(), s10)));

        SubCategory s11 = subCategories.get(10);
        List<Material> m11 = new ArrayList<>();
        for(int i = 0; i < 2; i++) m11.add(materials.get(random.nextInt(materials_size)));
        products.add((new Product(99.99, "Wooden Bookshelf", "Stylish and comfortable wooden bookshelf.", m11, s11.getCategory(), s11)));

        SubCategory s12 = subCategories.get(11);
        List<Material> m12 = new ArrayList<>();
        for(int i = 0; i < 2; i++) m12.add(materials.get(random.nextInt(materials_size)));
        products.add((new Product(99.99, "Wooden Wardrobe", "Stylish and comfortable wooden wardrobe.", m12, s12.getCategory(), s12)));

        SubCategory s13 = subCategories.get(12);
        List<Material> m13 = new ArrayList<>();
        for(int i = 0; i < 2; i++) m13.add(materials.get(random.nextInt(materials_size)));
        products.add((new Product(99.99, "Wooden Stool", "Stylish and comfortable wooden stool.", m13, s13.getCategory(), s13)));

        SubCategory s14 = subCategories.get(13);
        List<Material> m14 = new ArrayList<>();
        for(int i = 0; i < 2; i++) m14.add(materials.get(random.nextInt(materials_size)));
        products.add((new Product(99.99, "Wooden Sofa", "Stylish and comfortable wooden sofa.", m14, s14.getCategory(), s14)));

        SubCategory s15 = subCategories.get(14);
        List<Material> m15 = new ArrayList<>();
        for(int i = 0; i < 2; i++) m15.add(materials.get(random.nextInt(materials_size)));
        products.add((new Product(99.99, "Wooden Bed", "Stylish and comfortable wooden bed.", m15, s15.getCategory(), s15)));

        SubCategory s16 = subCategories.get(15);
        List<Material> m16 = new ArrayList<>();
        for(int i = 0; i < 2; i++) m16.add(materials.get(random.nextInt(materials_size)));
        products.add((new Product(99.99, "Wooden Dining Table", "Stylish and comfortable wooden dining table.", m16, s16.getCategory(), s16)));

        SubCategory s17 = subCategories.get(16);
        List<Material> m17 = new ArrayList<>();
        for(int i = 0; i < 2; i++) m17.add(materials.get(random.nextInt(materials_size)));
        products.add((new Product(99.99, "Wooden Dining Chair", "Stylish and comfortable wooden dining chair.", m17, s17.getCategory(), s17)));

        SubCategory s18 = subCategories.get(17);
        List<Material> m18 = new ArrayList<>();
        for(int i = 0; i < 2; i++) m18.add(materials.get(random.nextInt(materials_size)));
        products.add((new Product(99.99, "Wooden Dining Bench", "Stylish and comfortable wooden dining bench.", m18, s18.getCategory(), s18)));

        SubCategory s19 = subCategories.get(18);
        List<Material> m19 = new ArrayList<>();
        for(int i = 0; i < 2; i++) m19.add(materials.get(random.nextInt(materials_size)));
        products.add((new Product(99.99, "Wooden Sideboard", "Stylish and comfortable wooden sideboard.", m19, s19.getCategory(), s19)));

        SubCategory s20 = subCategories.get(19);
        List<Material> m20 = new ArrayList<>();
        for(int i = 0; i < 2; i++) m20.add(materials.get(random.nextInt(materials_size)));
        products.add((new Product(99.99, "Wooden TV Stand", "Stylish and comfortable wooden TV stand.", m20, s20.getCategory(), s20)));


        productRep.saveAll(products);
    }

    public void addFavourites() {
        List<Product> products = productRep.findAll();
        List<Customer> customers = customerRep.findAll();
        List<Customer> customersWithFavourites = new ArrayList<>();

        Random random = new Random();

        for (int i = 1; i <= 120; i++) {
            Customer customer = customers.get(random.nextInt(customers.size())); // Randomly select a customer
            Product product = products.get(random.nextInt(products.size())); // Randomly select a product
            customer.addFavourite(product);
            customersWithFavourites.add(customer);
        }
        customerRep.saveAll(customersWithFavourites);
    }

    public void addImages() throws IOException {
        List<Product> products = productRep.findAll();
        List<Image> images = new ArrayList<>();

        byte[] image1 = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/image1.jpg"));
        byte[] image2 = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/image2.jpg"));
        byte[] image3 = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/image3.jpg"));


        int i = 1;
        for(Product p : products) {
            if (i % 3 == 0) {
                images.add(new Image(image1, p));
            } else if (i % 3 == 1) {
                images.add(new Image(image2, p));
            } else {
                images.add(new Image(image3, p));
            }
            i++;
        }

        imageRep.saveAll(images);
    }

    public void addItems() throws Exception {
        List<Product> products = productRep.findAll();
        List<Customer> customers = customerRep.findAll();

        Random random = new Random();

        for (Customer customer : customers) {
            for (int j = 0; j < 5 ;j++){
                int quantity = random.nextInt(5) + 1; // Random quantity between 1 and 5
                Product product = products.get(random.nextInt(products.size())); // Randomly select a product
                Material material = product.getMaterials().get(random.nextInt(product.getMaterials().size())); // Randomly select a material
                orderService.addProductToShoppingCart(customer.getiD(), product.getiD(), material.getiD(),quantity);
            }
        }

        //
    }

    public void addOrders() throws UserNotFoundException {
        List<Customer> customers = customerRep.findAll();
        Random random = new Random();

        int i = 0;
        for(Customer c : customers){
            if (i % 2 == 0) {
                boolean storePickUp = random.nextBoolean();
                String address;
                if (storePickUp) address = null;
                else address = c.getAddress();
                orderService.createOrder(c.getiD(), address, storePickUp);
            }
            i++;
        }
    }

    public void addMoreOrders() throws Exception {
        List<Customer> customers = customerRep.findAll();
        List<Product> products = productRep.findAll();

        Random random = new Random();

        for(int i = 0; i < 2; i++){
            Customer c = customers.get(random.nextInt(customers.size()));
            for (int j = 0; j < 30; j++){
                boolean storePickUp = random.nextBoolean();
                String address = c.getAddress();
                Product p = products.get(random.nextInt(products.size()));
                Material m = p.getMaterials().get(random.nextInt(p.getMaterials().size()));
                orderService.addProductToShoppingCart(c.getiD(), p.getiD(), m.getiD(), 1);
                int order_id = orderService.createOrder(c.getiD(), address, storePickUp);
                if(j % 2 == 0) orderService.setOrderState(order_id, OrderState.READY);
                else orderService.setOrderState(order_id, OrderState.DONE);
            }
        }
    }

    public void addCompany() throws IOException {
        byte[] logo = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/logo.png"));

        String schedule = "Monday - Friday\n" +
                "9:00 AM - 12:30 PM | 2:00 PM - 7:00 PM\n" +
                "Saturday\n" +
                "CLOSED\n" +
                "Sunday\n" +
                "CLOSED\n";
        Company company = new Company("Móveis Rodrigues","geral@rodrigues-moveis.pt","252993990",
                "Rua do Carvalhal, nº 18, Vila Nova de Famalicão, Portugal",
                logo,
                "4770-847",
                schedule);
        companyRep.save(company);
    }

    public void addSocialNetworks() {
        List<SocialNetwork> socialNetworks = new ArrayList<>();
        Company c = companyRep.findAll().get(0);
        socialNetworks.add(new SocialNetwork("Facebook", "https://www.facebook.com/MoveisRodrigues",c));
        socialNetworks.add(new SocialNetwork("Instagram", "https://instagram.com/azevedorodriguesmoveis?igshid=NTc4MTIwNjQ2YQ==",c));
        socialNetworkRep.saveAll(socialNetworks);
    }
}
