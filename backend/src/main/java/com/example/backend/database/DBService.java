package com.example.backend.database;

import com.example.backend.dto.orderDTOs.OrderDetailedDTO;
import com.example.backend.exception.ProductNotFoundException;
import com.example.backend.exception.UserNotFoundException;
import com.example.backend.dto.userDTOs.CreateAdminDTO;
import com.example.backend.dto.userDTOs.CreateCustomerDTO;
import com.example.backend.model.*;
import com.example.backend.repositories.*;
import com.example.backend.services.AuthenticateService;
import com.example.backend.services.OrderService;
import com.example.backend.services.ProductService;
import com.example.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
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
    private ProductService productService;

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

    @Autowired
    private TechnicalInfoRep technicalInfoRep;


    public void addUsers() throws Exception {

        authenticateService.register(new CreateCustomerDTO(LocalDate.of(1990, 3, 15), "123456789A", "123 Main Street, Cityville", "customer1@example.com", "password1", "John Smith"));
        authenticateService.register(new CreateCustomerDTO(LocalDate.of(1985, 7, 2), "987654321B", "456 Elm Avenue, Townsville", "customer2@example.com", "password2", "Jane Johnson"));
        authenticateService.register(new CreateCustomerDTO(LocalDate.of(1992, 1, 9), "246813579C", "789 Oak Road, Villageton", "customer3@example.com", "password3", "Robert Davis"));
        authenticateService.register(new CreateCustomerDTO(LocalDate.of(1988, 11, 26), "135792468D", "321 Pine Lane, Hamletown", "customer4@example.com", "password4", "Emily Wilson"));
        authenticateService.register(new CreateCustomerDTO(LocalDate.of(1995, 5, 4), "864209753E", "654 Maple Drive, Boroughburg", "customer5@example.com", "password5", "Michael Thompson"));
        authenticateService.register(new CreateCustomerDTO(LocalDate.of(1984, 2, 21), "579314682F", "987 Cedar Street, Villaville", "customer6@example.com", "password6", "Sarah Roberts"));
        authenticateService.register(new CreateCustomerDTO(LocalDate.of(1991, 8, 10), "951623487G", "159 Birch Court, Townberg", "customer7@example.com", "password7", "David Lee"));
        authenticateService.register(new CreateCustomerDTO(LocalDate.of(1987, 12, 3), "792468135H", "753 Oakwood Avenue, Hamletham", "customer8@example.com", "password8", "Jennifer Scott"));
        authenticateService.register(new CreateCustomerDTO(LocalDate.of(1993, 6, 18), "246813579I", "357 Pine Lane, Cityton", "customer9@example.com", "password9", "Christopher Martin"));
        authenticateService.register(new CreateCustomerDTO(LocalDate.of(1986, 9, 27), "468135792J", "951 Maple Drive, Villaburg", "customer10@example.com", "password10", "Amanda Turner"));
        authenticateService.register(new CreateCustomerDTO(LocalDate.of(1994, 4, 12), "246801357K", "753 Cedar Street, Boroughville", "customer11@example.com", "password11", "Matthew Harris"));
        authenticateService.register(new CreateCustomerDTO(LocalDate.of(1983, 10, 29), "135792468L", "357 Birch Court, Townham", "customer12@example.com", "password12", "Laura Clark"));
        authenticateService.register(new CreateCustomerDTO(LocalDate.of(1990, 2, 7), "579314682M", "951 Oakwood Avenue, Citytown", "customer13@example.com", "password13", "Daniel Baker"));
        authenticateService.register(new CreateCustomerDTO(LocalDate.of(1985, 7, 26), "468135792N", "753 Pine Lane, Villaville", "customer14@example.com", "password14", "Olivia Phillips"));
        authenticateService.register(new CreateCustomerDTO(LocalDate.of(1992, 1, 3), "791364825O", "357 Maple Drive, Hamletown", "customer15@example.com", "password15", "James Cooper"));
        authenticateService.register(new CreateCustomerDTO(LocalDate.of(1988, 11, 20), "579314682P", "951 Cedar Street, Cityville", "customer16@example.com", "password16", "Sophia Martinez"));
        authenticateService.register(new CreateCustomerDTO(LocalDate.of(1995, 6, 8), "468135792Q", "753 Birch Court, Townsville", "customer17@example.com", "password17", "Ryan Thompson"));
        authenticateService.register(new CreateCustomerDTO(LocalDate.of(1984, 3, 25), "791364825R", "357 Oakwood Avenue, Villageton", "customer18@example.com", "password18", "Emma Davis"));
        authenticateService.register(new CreateCustomerDTO(LocalDate.of(1991, 9, 14), "135792468S", "951 Pine Lane, Hamletown", "customer19@example.com", "password19", "Alexander Wilson"));
        authenticateService.register(new CreateCustomerDTO(LocalDate.of(1987, 12, 31), "579314682T", "753 Maple Drive, Boroughburg", "customer20@example.com", "password20", "Mia Johnson"));
        authenticateService.register(new CreateCustomerDTO(LocalDate.of(1993, 7, 17), "468135792U", "357 Cedar Street, Villaville", "customer21@example.com", "password21", "William Roberts"));
        authenticateService.register(new CreateCustomerDTO(LocalDate.of(1986, 10, 5), "791364825V", "951 Birch Court, Townberg", "customer22@example.com", "password22", "Grace Lee"));
        authenticateService.register(new CreateCustomerDTO(LocalDate.of(1994, 5, 21), "135792468W", "753 Oakwood Avenue, Hamletham", "customer23@example.com", "password23", "Joseph Scott"));
        authenticateService.register(new CreateCustomerDTO(LocalDate.of(1983, 11, 8), "579314682X", "357 Pine Lane, Cityton", "customer24@example.com", "password24", "Samantha Martin"));
        authenticateService.register(new CreateCustomerDTO(LocalDate.of(1990, 3, 24), "468135792Y", "951 Maple Drive, Villaburg", "customer25@example.com", "password25", "Benjamin Turner"));
        authenticateService.register(new CreateCustomerDTO(LocalDate.of(1985, 8, 12), "791364825Z", "753 Cedar Street, Boroughville", "customer26@example.com", "password26", "Natalie Harris"));
        authenticateService.register(new CreateCustomerDTO(LocalDate.of(1992, 2, 28), "246801357AA", "357 Birch Court, Townham", "customer27@example.com", "password27", "Andrew Clark"));
        authenticateService.register(new CreateCustomerDTO(LocalDate.of(1988, 12, 15), "135792468AB", "951 Oakwood Avenue, Citytown", "customer28@example.com", "password28", "Isabella Baker"));
        authenticateService.register(new CreateCustomerDTO(LocalDate.of(1995, 7, 2), "579314682AC", "753 Pine Lane, Villaville", "customer29@example.com", "password29", "Ethan Phillips"));
        authenticateService.register(new CreateCustomerDTO(LocalDate.of(1984, 4, 18), "468135792AD", "357 Maple Drive, Hamletown", "customer30@example.com", "password30", "Chloe Cooper"));
        authenticateService.register(new CreateCustomerDTO(LocalDate.of(1991, 10, 4), "246801357AE", "951 Cedar Street, Cityville", "customer31@example.com", "password31", "Liam Martinez"));
        authenticateService.register(new CreateCustomerDTO(LocalDate.of(1987, 12, 21), "135792468AF", "753 Birch Court, Townsville", "customer32@example.com", "password32", "Victoria Thompson"));
        authenticateService.register(new CreateCustomerDTO(LocalDate.of(1993, 8, 7), "579314682AG", "357 Oakwood Avenue, Villageton", "customer33@example.com", "password33", "Noah Davis"));
        authenticateService.register(new CreateCustomerDTO(LocalDate.of(1986, 11, 25), "468135792AH", "951 Pine Lane, Hamletown", "customer34@example.com", "password34", "Elizabeth Wilson"));
        authenticateService.register(new CreateCustomerDTO(LocalDate.of(1994, 6, 12), "246801357AI", "753 Maple Drive, Boroughburg", "customer35@example.com", "password35", "Jacob Johnson"));
        authenticateService.register(new CreateCustomerDTO(LocalDate.of(1983, 12, 29), "135792468AJ", "357 Cedar Street, Villaville", "customer36@example.com", "password36", "Ava Roberts"));
        authenticateService.register(new CreateCustomerDTO(LocalDate.of(1990, 4, 15), "579314682AK", "951 Birch Court, Townberg", "customer37@example.com", "password37", "Michael Lee"));
        authenticateService.register(new CreateCustomerDTO(LocalDate.of(1985, 9, 1), "468135792AL", "753 Oakwood Avenue, Hamletham", "customer38@example.com", "password38", "Emily Scott"));
        authenticateService.register(new CreateCustomerDTO(LocalDate.of(1992, 2, 17), "791364825AM", "357 Pine Lane, Cityton", "customer39@example.com", "password39", "Matthew Martin"));

        for(int i = 0; i < 500; i++){
            authenticateService.register(new CreateCustomerDTO(LocalDate.of(1995, 6, 8), String.valueOf(111111111 + i), "753 Birch Court, Townsville", "customer" + (40 + i) + "@example.com", "password" + (40 + i), "Ryan Thompson"));
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

        byte[] oak = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/oak.jpg"));
        byte[] mahogany = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/mahogany.jpg"));
        byte[] leather = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/leather.jpg"));
        byte[] wicker = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/wicker.jpg"));
        byte[] velvet = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/velvet.jpg"));
        byte[] bamboo = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/bamboo.jpg"));
        byte[] suede = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/suede.jpg"));
        byte[] rattan = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/rattan.jpg"));
        byte[] microfiber = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/microfiber.jpg"));
        byte[] linen = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/linen.jpg"));
        byte[] cotton = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/cotton.jpg"));
        byte[] silk = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/silk.jpg"));
        byte[] acrylic = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/acrylic.jpg"));
        byte[] polyester = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/polyester.jpg"));
        byte[] metal = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/metal.jpg"));
        byte[] glass = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/glass.jpg"));
        byte[] marble = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/marble.jpg"));
        byte[] cork = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/cork.jpg"));
        byte[] granite = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/granite.jpg"));
        byte[] plastic = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/plastic.jpg"));
        byte[] porcelain = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/porcelain.jpg"));

        materials.add(new Material("Oak Wood", oak));
        materials.add(new Material("Mahogany", mahogany));
        materials.add(new Material("Leather", leather));
        materials.add(new Material("Wicker", wicker));
        materials.add(new Material("Velvet", velvet));
        materials.add(new Material("Bamboo", bamboo));
        materials.add(new Material("Suede", suede));
        materials.add(new Material("Rattan", rattan));
        materials.add(new Material("Microfiber", microfiber));
        materials.add(new Material("Linen", linen));
        materials.add(new Material("Cotton", cotton));
        materials.add(new Material("Silk", silk));
        materials.add(new Material("Acrylic", acrylic));
        materials.add(new Material("Polyester", polyester));
        materials.add(new Material("Metal", metal));
        materials.add(new Material("Glass", glass));
        materials.add(new Material("Marble", marble));
        materials.add(new Material("Granite", granite));
        materials.add(new Material("Cork", cork));
        materials.add(new Material("Plastic", plastic));
        materials.add(new Material("Porcelain", porcelain));

        materialRep.saveAll(materials);
    }

    public void addCategories() throws IOException {
        List<Category> categories = new ArrayList<>();
        byte[] image1 = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/image1.jpg"));
        byte[] image2 = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/image2.jpg"));
        byte[] image3 = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/image3.jpg"));

        byte[] livingRoom = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/image2.jpg"));
        byte[] bedroom = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/bedroom.jpg"));
        byte[] diningRoom = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/dining.jpg"));
        byte[] office = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/office.jpg"));
        byte[] outdoor = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/outdoor.jpg"));
        byte[] kitchen = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/kitchen.jpg"));
        byte[] bathroom = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/bathroom.jpg"));
        byte[] kids = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/kids.jpg"));
        byte[] entertainment = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/entertainment.jpg"));
        byte[] storage = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/storage.jpg"));
        byte[] accent = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/accent.jpg"));
        byte[] workspace = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/workspace.jpg"));
        byte[] entryway = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/entryway.jpg"));
        byte[] garden = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/garden.jpg"));
        byte[] nursery = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/nursery.jpg"));
        byte[] patio = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/patio.jpg"));
        byte[] bar = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/bar.jpg"));
        byte[] library = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/library.jpg"));
        byte[] playroom = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/playroom.jpg"));
        byte[] gym = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/gym.jpg"));

        categories.add(new Category("Living Room", livingRoom));
        categories.add(new Category("Bedroom", bedroom));
        categories.add(new Category("Dining Room", diningRoom));
        categories.add(new Category("Office", office));
        categories.add(new Category("Outdoor", outdoor));
        categories.add(new Category("Kitchen", kitchen));
        categories.add(new Category("Bathroom", bathroom));
        categories.add(new Category("Kids", kids));
        categories.add(new Category("Entertainment", entertainment));
        categories.add(new Category("Storage", storage));
        categories.add(new Category("Accent", accent));
        categories.add(new Category("Workspace", workspace));
        categories.add(new Category("Entryway", entryway));
        categories.add(new Category("Garden", garden));
        categories.add(new Category("Nursery", nursery));
        categories.add(new Category("Patio", patio));
        categories.add(new Category("Bar", bar));
        categories.add(new Category("Library", library));
        categories.add(new Category("Playroom", playroom));
        categories.add(new Category("Gym", gym));

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

        byte[] sofas = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/sofas.jpg"));
        byte[] armchairs = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/armchairs.jpg"));
        byte[] beds = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/beds.jpg"));
        byte[] diningTables = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/diningTables.jpg"));
        byte[] desks = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/desks.jpg"));
        byte[] outdoorSets = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/outdoorSets.jpg"));
        byte[] cabinets = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/cabinets.jpg"));
        byte[] toilets = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/toilets.jpg"));
        byte[] kidsBeds = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/kidsBeds.jpg"));
        byte[] chairs = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/chairs.jpg"));
        byte[] tables = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/tables.jpg"));
        byte[] bookcases = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/bookcase.jpg"));
        byte[] officeChairs = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/officeChairs.jpg"));
        byte[] benches = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/benches.jpg"));
        byte[] gardenSets = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/gardenSets.jpg"));
        byte[] cribs = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/cribs.jpg"));
        byte[] patioSets = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/patioSets.jpg"));
        byte[] barStools = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/barStools.jpg"));
        byte[] bookshelves = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/bookshelves.jpg"));
        byte[] playTables = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/playTables.jpg"));
        byte[] treadmills = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/treadmills.jpg"));


        subCategories.add(new SubCategory("Sofas", sofas, categories.get(0)));
        subCategories.add(new SubCategory("Armchairs", armchairs, categories.get(0)));
        subCategories.add(new SubCategory("Beds", beds, categories.get(1)));
        subCategories.add(new SubCategory("Dining Tables", diningTables, categories.get( 2)));
        subCategories.add(new SubCategory("Desks", desks, categories.get(3)));
        subCategories.add(new SubCategory("Outdoor Sets", outdoorSets, categories.get( 4)));
        subCategories.add(new SubCategory("Cabinets", cabinets, categories.get( 5)));
        subCategories.add(new SubCategory("Toilets", toilets, categories.get( 6)));
        subCategories.add(new SubCategory("Kids Beds", kidsBeds, categories.get( 7)));
        subCategories.add(new SubCategory("Chairs", chairs, categories.get( 8)));
        subCategories.add(new SubCategory("Tables", tables, categories.get(9)));
        subCategories.add(new SubCategory("Bookcases", bookcases, categories.get(10)));
        subCategories.add(new SubCategory("Office Chairs", officeChairs, categories.get(11)));
        subCategories.add(new SubCategory("Benches", benches, categories.get(12)));
        subCategories.add(new SubCategory("Garden Sets", gardenSets, categories.get(13)));
        subCategories.add(new SubCategory("Cribs", cribs, categories.get(14)));
        subCategories.add(new SubCategory("Patio Sets", patioSets, categories.get(15)));
        subCategories.add(new SubCategory("Bar Stools", barStools, categories.get(16)));
        subCategories.add(new SubCategory("Bookshelves", bookshelves, categories.get(17)));
        subCategories.add(new SubCategory("Play Tables", playTables, categories.get(18)));
        subCategories.add(new SubCategory("Treadmills", treadmills, categories.get(19)));

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

        SubCategory s1_2 = subCategories.get(0);
        List<Material> m1_2 = new ArrayList<>();
        for(int i = 0; i < 2; i++) m1_2.add(materials.get(random.nextInt(materials_size)));
        products.add((new Product(699.99, "Fabric Sofa", "Stylish and comfortable fabric sofa.", m1_2, s1_2.getCategory(), s1_2)));

        SubCategory s1_3 = subCategories.get(1);
        List<Material> m1_3 = new ArrayList<>();
        for(int i = 0; i < 2; i++) m1_3.add(materials.get(random.nextInt(materials_size)));
        products.add((new Product(399.99, "Leather Armchair", "Stylish and comfortable leather armchair.", m1_3, s1_3.getCategory(), s1_3)));

        SubCategory s1_4 = subCategories.get(1);
        List<Material> m1_4 = new ArrayList<>();
        for(int i = 0; i < 2; i++) m1_4.add(materials.get(random.nextInt(materials_size)));
        products.add((new Product(299.99, "Fabric Armchair", "Stylish and comfortable fabric armchair.", m1_4, s1_4.getCategory(), s1_4)));

        SubCategory s2 = subCategories.get(2);
        List<Material> m2 = new ArrayList<>();
        for(int i = 0; i < 2; i++) m2.add(materials.get(random.nextInt(materials_size)));
        products.add((new Product(499.99, "Wooden Bed", "Stylish and comfortable wooden bed.", m2, s2.getCategory(), s2)));

        SubCategory s3 = subCategories.get(3);
        List<Material> m3 = new ArrayList<>();
        for(int i = 0; i < 2; i++) m3.add(materials.get(random.nextInt(materials_size)));
            products.add((new Product(299.99, "Wooden Dining Table", "Stylish and comfortable wooden dining table.", m3, s3.getCategory(), s3)));

        SubCategory s4 = subCategories.get(4);
        List<Material> m4 = new ArrayList<>();
        for(int i = 0; i < 2; i++) m4.add(materials.get(random.nextInt(materials_size)));
        products.add((new Product(199.99, "Wooden Desk", "Stylish and comfortable wooden desk.", m4, s4.getCategory(), s4)));

        SubCategory s5 = subCategories.get(5);
        List<Material> m5 = new ArrayList<>();
        for(int i = 0; i < 2; i++) m5.add(materials.get(random.nextInt(materials_size)));
        products.add((new Product(99.99, "Wooden Outdoor Set", "Stylish and comfortable wooden outdoor set.", m5, s5.getCategory(), s5)));

        SubCategory s6 = subCategories.get(6);
        List<Material> m6 = new ArrayList<>();
        for(int i = 0; i < 2; i++) m6.add(materials.get(random.nextInt(materials_size)));
        products.add((new Product(99.99, "Wooden Cabinet", "Stylish and comfortable wooden cabinet.", m6, s6.getCategory(), s6)));

        SubCategory s7 = subCategories.get(7);
        List<Material> m7 = new ArrayList<>();
        for(int i = 0; i < 2; i++) m7.add(materials.get(random.nextInt(materials_size)));
        products.add((new Product(99.99, "Porcelain Toilet", "Stylish and comfortable porcelain toilet.", m7, s7.getCategory(), s7)));

        SubCategory s8 = subCategories.get(8);
        List<Material> m8 = new ArrayList<>();
        for(int i = 0; i < 2; i++) m8.add(materials.get(random.nextInt(materials_size)));
        products.add((new Product(99.99, "Wooden Kids Bed", "Stylish and comfortable wooden kids bed.", m8, s8.getCategory(), s8)));

        SubCategory s9 = subCategories.get(9);
        List<Material> m9 = new ArrayList<>();
        for(int i = 0; i < 2; i++) m9.add(materials.get(random.nextInt(materials_size)));
        products.add((new Product(99.99, "Wooden Chair", "Stylish and comfortable wooden chair.", m9, s9.getCategory(), s9)));

        SubCategory s10 = subCategories.get(10);
        List<Material> m10 = new ArrayList<>();
        for(int i = 0; i < 2; i++) m10.add(materials.get(random.nextInt(materials_size)));
        products.add((new Product(99.99, "Wooden Coffee Table", "Stylish and comfortable wooden coffee table.", m10, s10.getCategory(), s10)));

        SubCategory s11 = subCategories.get(11);
        List<Material> m11 = new ArrayList<>();
        for(int i = 0; i < 2; i++) m11.add(materials.get(random.nextInt(materials_size)));
        products.add((new Product(99.99, "Wooden Bookshelf", "Stylish and comfortable wooden bookshelf.", m11, s11.getCategory(), s11)));

        SubCategory s12 = subCategories.get(12);
        List<Material> m12 = new ArrayList<>();
        for(int i = 0; i < 2; i++) m12.add(materials.get(random.nextInt(materials_size)));
        products.add((new Product(99.99, "Leather Office Chair", "Stylish and comfortable office chair.", m12, s12.getCategory(), s12)));

        SubCategory s13 = subCategories.get(13);
        List<Material> m13 = new ArrayList<>();
        for(int i = 0; i < 2; i++) m13.add(materials.get(random.nextInt(materials_size)));
        products.add((new Product(99.99, "Wooden Bench", "Stylish and comfortable wooden bench.", m13, s13.getCategory(), s13)));

        SubCategory s14 = subCategories.get(14);
        List<Material> m14 = new ArrayList<>();
        for(int i = 0; i < 2; i++) m14.add(materials.get(random.nextInt(materials_size)));
        products.add((new Product(99.99, "Suede Garden Set", "Stylish and comfortable garden set.", m14, s14.getCategory(), s14)));

        SubCategory s15 = subCategories.get(15);
        List<Material> m15 = new ArrayList<>();
        for(int i = 0; i < 2; i++) m15.add(materials.get(random.nextInt(materials_size)));
        products.add((new Product(99.99, "Wood Crib", "Stylish and comfortable crib.", m15, s15.getCategory(), s15)));

        SubCategory s16 = subCategories.get(16);
        List<Material> m16 = new ArrayList<>();
        for(int i = 0; i < 2; i++) m16.add(materials.get(random.nextInt(materials_size)));
        products.add((new Product(99.99, "Bamboo Patio Set", "Stylish and comfortable patio set.", m16, s16.getCategory(), s16)));

        SubCategory s17 = subCategories.get(17);
        List<Material> m17 = new ArrayList<>();
        for(int i = 0; i < 2; i++) m17.add(materials.get(random.nextInt(materials_size)));
        products.add((new Product(99.99, "Wooden Bar Stools", "Stylish and comfortable wooden bar stools.", m17, s17.getCategory(), s17)));

        SubCategory s18 = subCategories.get(18);
        List<Material> m18 = new ArrayList<>();
        for(int i = 0; i < 2; i++) m18.add(materials.get(random.nextInt(materials_size)));
        products.add((new Product(99.99, "Wooden BookShelves", "Stylish and comfortable wooden dining bench.", m18, s18.getCategory(), s18)));

        SubCategory s19 = subCategories.get(19);
        List<Material> m19 = new ArrayList<>();
        for(int i = 0; i < 2; i++) m19.add(materials.get(random.nextInt(materials_size)));
        products.add((new Product(99.99, "Wooden Play Table", "Stylish and comfortable wooden playtable.", m19, s19.getCategory(), s19)));

        SubCategory s20 = subCategories.get(20);
        List<Material> m20 = new ArrayList<>();
        for(int i = 0; i < 2; i++) m20.add(materials.get(random.nextInt(materials_size)));
        products.add((new Product(99.99, "Treadmill 3000", "Stylish treadmill.", m20, s20.getCategory(), s20)));


        productRep.saveAll(products);
    }

    public void addInfos() {
        List<Product> products = productRep.findAll();
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            TechnicalInfo info1 = new TechnicalInfo("Height (cm)","100", products.get(i));
            product.addInfo(info1);
            TechnicalInfo info2 = new TechnicalInfo("Width (cm)","100", products.get(i));
            product.addInfo(info2);
            productRep.save(product);
        }
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

    public void addImages() throws IOException, ProductNotFoundException {
        List<Product> products = productRep.findAll();
        List<Image> images = new ArrayList<>();

        byte[] image1 = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/image1.jpg"));
        byte[] image2 = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/image2.jpg"));
        byte[] image3 = Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/image3.jpg"));

        List<byte[]> imagesList = new ArrayList<>();

        imagesList.add(Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/products/leatherSofa.jpg")));
        imagesList.add(Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/products/fabricSofa.jpg")));
        imagesList.add(Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/products/leatherArmchair.jpg")));
        imagesList.add(Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/products/fabricArmchair.jpg")));
        imagesList.add(Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/products/woodenBed.jpg")));
        imagesList.add(Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/products/woodenDiningTable.jpg")));
        imagesList.add(Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/products/woodenDesk.jpg")));
        imagesList.add(Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/products/woodenOutdoorSet.jpg")));
        imagesList.add(Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/products/woodenCabinet.jpg")));
        imagesList.add(Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/products/porcelainToilet.jpg")));
        imagesList.add(Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/products/woodenKidsBed.jpg")));
        imagesList.add(Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/products/woodenChair.jpg")));
        imagesList.add(Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/products/woodenCoffeeTable.jpg")));
        imagesList.add(Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/products/woodenBookshelf.jpg")));
        imagesList.add(Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/products/leatherOfficeChair.jpg")));
        imagesList.add(Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/products/woodenBench.jpg")));
        imagesList.add(Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/products/suedeGardenSet.jpg")));
        imagesList.add(Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/products/woodenCrib.jpg")));
        imagesList.add(Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/products/bambooPatioSet.jpg")));
        imagesList.add(Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/products/woodenBarStools.jpg")));
        imagesList.add(Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/products/woodenBookshelve.jpg")));
        imagesList.add(Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/products/woodenPlayTable.jpg")));
        imagesList.add(Files.readAllBytes(Paths.get("src/main/java/com/example/backend/database/images/products/treadmill.jpg")));

        for(int i = 0; i < products.size(); i++) {
            productService.addProductImage(products.get(i).getiD(), imagesList.get(i));
        }

        int i = 1;
        for(Product p : products) {
            if (i % 3 == 0) {
                productService.addProductImage(p.getiD(), image1);
            } else if (i % 3 == 1) {
                productService.addProductImage(p.getiD(), image2);
            } else {
                productService.addProductImage(p.getiD(), image3);
            }
            i++;
        }

    }

    public void addItems() throws Exception {
        List<Product> products = productRep.findAll();
        List<Customer> customers = customerRep.findAll();

        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 5 ;j++){
                Customer customer = customers.get(i);
                int quantity = random.nextInt(5) + 1; // Random quantity between 1 and 5
                Product product = products.get(random.nextInt(products.size())); // Randomly select a product
                Material material = product.getMaterials().get(random.nextInt(product.getMaterials().size())); // Randomly select a material
                orderService.addProductToShoppingCart(customer.getiD(), product.getiD(), material.getiD(),quantity);
            }
        }

        //
    }

    public void addOrders() throws Exception {
        List<Customer> customers = customerRep.findAll();
        Random random = new Random();

        for(int i = 0; i < 100; i++){
            if (i % 2 == 0) {
                Customer c = customers.get(i);
                boolean storePickUp = random.nextBoolean();
                String address;
                if (storePickUp) address = null;
                else address = c.getAddress();
                orderService.createOrder(c.getiD(), address, storePickUp);
            }
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
                OrderDetailedDTO order = orderService.createOrder(c.getiD(), address, storePickUp);
                int order_id = order.getId();
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
