package com.example.backend.database;

import com.example.backend.Exception.UserNotFoundException;
import com.example.backend.dto.AdminDTO;
import com.example.backend.dto.CustomerDTO;
import com.example.backend.model.*;
import com.example.backend.repositories.*;
import com.example.backend.services.AuthenticateService;
import com.example.backend.services.InfoService;
import com.example.backend.services.OrderService;
import com.example.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private UserRep userRep;

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
    private OrderRep orderRep;

    public void addUsers() {
        List<User> users = new ArrayList<>();

        authenticateService.register(new CustomerDTO(new Date(1985, 7, 2), "987654321B", "456 Elm Avenue, Townsville", "customer2@example.com", "password2", "Jane Johnson"));
        authenticateService.register(new CustomerDTO(new Date(1992, 1, 9), "246813579C", "789 Oak Road, Villageton", "customer3@example.com", "password3", "Robert Davis"));
        authenticateService.register(new CustomerDTO(new Date(1990, 3, 15), "123456789A", "123 Main Street, Cityville", "customer1@example.com", "password1", "John Smith"));
        authenticateService.register(new CustomerDTO(new Date(1988, 11, 26), "135792468D", "321 Pine Lane, Hamletown", "customer4@example.com", "password4", "Emily Wilson"));
        authenticateService.register(new CustomerDTO(new Date(1995, 5, 4), "864209753E", "654 Maple Drive, Boroughburg", "customer5@example.com", "password5", "Michael Thompson"));
        authenticateService.register(new CustomerDTO(new Date(1984, 2, 21), "579314682F", "987 Cedar Street, Villaville", "customer6@example.com", "password6", "Sarah Roberts"));
        authenticateService.register(new CustomerDTO(new Date(1991, 8, 10), "951623487G", "159 Birch Court, Townberg", "customer7@example.com", "password7", "David Lee"));
        authenticateService.register(new CustomerDTO(new Date(1987, 12, 3), "792468135H", "753 Oakwood Avenue, Hamletham", "customer8@example.com", "password8", "Jennifer Scott"));
        authenticateService.register(new CustomerDTO(new Date(1993, 6, 18), "246813579I", "357 Pine Lane, Cityton", "customer9@example.com", "password9", "Christopher Martin"));
        authenticateService.register(new CustomerDTO(new Date(1986, 9, 27), "468135792J", "951 Maple Drive, Villaburg", "customer10@example.com", "password10", "Amanda Turner"));
        authenticateService.register(new CustomerDTO(new Date(1994, 4, 12), "246801357K", "753 Cedar Street, Boroughville", "customer11@example.com", "password11", "Matthew Harris"));
        authenticateService.register(new CustomerDTO(new Date(1983, 10, 29), "135792468L", "357 Birch Court, Townham", "customer12@example.com", "password12", "Laura Clark"));
        authenticateService.register(new CustomerDTO(new Date(1990, 2, 7), "579314682M", "951 Oakwood Avenue, Citytown", "customer13@example.com", "password13", "Daniel Baker"));
        authenticateService.register(new CustomerDTO(new Date(1985, 7, 26), "468135792N", "753 Pine Lane, Villaville", "customer14@example.com", "password14", "Olivia Phillips"));
        authenticateService.register(new CustomerDTO(new Date(1992, 1, 3), "791364825O", "357 Maple Drive, Hamletown", "customer15@example.com", "password15", "James Cooper"));
        authenticateService.register(new CustomerDTO(new Date(1988, 11, 20), "579314682P", "951 Cedar Street, Cityville", "customer16@example.com", "password16", "Sophia Martinez"));
        authenticateService.register(new CustomerDTO(new Date(1995, 6, 8), "468135792Q", "753 Birch Court, Townsville", "customer17@example.com", "password17", "Ryan Thompson"));
        authenticateService.register(new CustomerDTO(new Date(1984, 3, 25), "791364825R", "357 Oakwood Avenue, Villageton", "customer18@example.com", "password18", "Emma Davis"));
        authenticateService.register(new CustomerDTO(new Date(1991, 9, 14), "135792468S", "951 Pine Lane, Hamletown", "customer19@example.com", "password19", "Alexander Wilson"));
        authenticateService.register(new CustomerDTO(new Date(1987, 12, 31), "579314682T", "753 Maple Drive, Boroughburg", "customer20@example.com", "password20", "Mia Johnson"));
        authenticateService.register(new CustomerDTO(new Date(1993, 7, 17), "468135792U", "357 Cedar Street, Villaville", "customer21@example.com", "password21", "William Roberts"));
        authenticateService.register(new CustomerDTO(new Date(1986, 10, 5), "791364825V", "951 Birch Court, Townberg", "customer22@example.com", "password22", "Grace Lee"));
        authenticateService.register(new CustomerDTO(new Date(1994, 5, 21), "135792468W", "753 Oakwood Avenue, Hamletham", "customer23@example.com", "password23", "Joseph Scott"));
        authenticateService.register(new CustomerDTO(new Date(1983, 11, 8), "579314682X", "357 Pine Lane, Cityton", "customer24@example.com", "password24", "Samantha Martin"));
        authenticateService.register(new CustomerDTO(new Date(1990, 3, 24), "468135792Y", "951 Maple Drive, Villaburg", "customer25@example.com", "password25", "Benjamin Turner"));
        authenticateService.register(new CustomerDTO(new Date(1985, 8, 12), "791364825Z", "753 Cedar Street, Boroughville", "customer26@example.com", "password26", "Natalie Harris"));
        authenticateService.register(new CustomerDTO(new Date(1992, 2, 28), "246801357AA", "357 Birch Court, Townham", "customer27@example.com", "password27", "Andrew Clark"));
        authenticateService.register(new CustomerDTO(new Date(1988, 12, 15), "135792468AB", "951 Oakwood Avenue, Citytown", "customer28@example.com", "password28", "Isabella Baker"));
        authenticateService.register(new CustomerDTO(new Date(1995, 7, 2), "579314682AC", "753 Pine Lane, Villaville", "customer29@example.com", "password29", "Ethan Phillips"));
        authenticateService.register(new CustomerDTO(new Date(1984, 4, 18), "468135792AD", "357 Maple Drive, Hamletown", "customer30@example.com", "password30", "Chloe Cooper"));
        authenticateService.register(new CustomerDTO(new Date(1991, 10, 4), "246801357AE", "951 Cedar Street, Cityville", "customer31@example.com", "password31", "Liam Martinez"));
        authenticateService.register(new CustomerDTO(new Date(1987, 12, 21), "135792468AF", "753 Birch Court, Townsville", "customer32@example.com", "password32", "Victoria Thompson"));

        userService.addAdminDTO(new AdminDTO("admin@admin.com", "password", "Admin"));
        userService.addAdminDTO(new AdminDTO("admin1@example.com", "adminpassword1", "Admin Smith"));
        userService.addAdminDTO(new AdminDTO("admin2@example.com", "adminpassword2", "Admin Johnson"));
        userService.addAdminDTO(new AdminDTO("admin3@example.com", "adminpassword3", "Admin Davis"));
        userService.addAdminDTO(new AdminDTO("admin4@example.com", "adminpassword4", "Admin Wilson"));
        userService.addAdminDTO(new AdminDTO("admin5@example.com", "adminpassword5", "Admin Thompson"));
        userService.addAdminDTO(new AdminDTO("admin6@example.com", "adminpassword6", "Admin Roberts"));
        userService.addAdminDTO(new AdminDTO("admin7@example.com", "adminpassword7", "Admin Lee"));
        userService.addAdminDTO(new AdminDTO("admin8@example.com", "adminpassword8", "Admin Scott"));
        userService.addAdminDTO(new AdminDTO("admin9@example.com", "adminpassword9", "Admin Martin"));
        userService.addAdminDTO(new AdminDTO("admin10@example.com", "adminpassword10", "Admin Turner"));

    }

    public void addMaterials() {
        List<Material> materials = new ArrayList<>();

        materials.add(new Material("Oak Wood", "material".getBytes()));
        materials.add(new Material("Mahogany", "material".getBytes()));
        materials.add(new Material("Leather", "material1".getBytes()));
        materials.add(new Material("Wicker", "material1".getBytes()));
        materials.add(new Material("Velvet", "material1".getBytes()));
        materials.add(new Material("Bamboo", "material1".getBytes()));
        materials.add(new Material("Suede", "material1".getBytes()));
        materials.add(new Material("Rattan", "material1".getBytes()));
        materials.add(new Material("Microfiber", "material1".getBytes()));
        materials.add(new Material("Linen", "material1".getBytes()));
        materials.add(new Material("Cotton", "material1".getBytes()));
        materials.add(new Material("Silk", "material1".getBytes()));
        materials.add(new Material("Acrylic", "material1".getBytes()));
        materials.add(new Material("Polyester", "material1".getBytes()));
        materials.add(new Material("Metal", "material1".getBytes()));
        materials.add(new Material("Glass", "material1".getBytes()));
        materials.add(new Material("Marble", "material1".getBytes()));
        materials.add(new Material("Granite", "material1".getBytes()));
        materials.add(new Material("Cork", "material1".getBytes()));
        materials.add(new Material("Plastic", "material1".getBytes()));

        materialRep.saveAll(materials);
    }

    public void addCategories() {
        List<Category> categories = new ArrayList<>();

        categories.add(new Category("Living Room", "livingRoomImageBytes".getBytes()));
        categories.add(new Category("Bedroom", "bedroomImageBytes".getBytes()));
        categories.add(new Category("Dining Room", "diningRoomImageBytes".getBytes()));
        categories.add(new Category("Office", "officeImageBytes".getBytes()));
        categories.add(new Category("Outdoor", "outdoorImageBytes".getBytes()));
        categories.add(new Category("Kitchen", "kitchenImageBytes".getBytes()));
        categories.add(new Category("Bathroom", "bathroomImageBytes".getBytes()));
        categories.add(new Category("Kids", "kidsImageBytes".getBytes()));
        categories.add(new Category("Entertainment", "entertainmentImageBytes".getBytes()));
        categories.add(new Category("Storage", "storageImageBytes".getBytes()));
        categories.add(new Category("Accent", "accentImageBytes".getBytes()));
        categories.add(new Category("Workspace", "workspaceImageBytes".getBytes()));
        categories.add(new Category("Entryway", "entrywayImageBytes".getBytes()));
        categories.add(new Category("Garden", "gardenImageBytes".getBytes()));
        categories.add(new Category("Nursery", "nurseryImageBytes".getBytes()));
        categories.add(new Category("Patio", "patioImageBytes".getBytes()));
        categories.add(new Category("Bar", "barImageBytes".getBytes()));
        categories.add(new Category("Library", "libraryImageBytes".getBytes()));
        categories.add(new Category("Playroom", "playroomImageBytes".getBytes()));
        categories.add(new Category("Gym", "gymImageBytes".getBytes()));

        categoryRep.saveAll(categories);

    }

    public void addSubcategories() {
        List<Category> categories = categoryRep.findAll();
        int size = categories.size();
        List<SubCategory> subCategories = new ArrayList<>();
        Random random = new Random();

        subCategories.add(new SubCategory("Sofas", "sofasImageBytes".getBytes(), categories.get(random.nextInt(size))));
        subCategories.add(new SubCategory("Beds", "bedsImageBytes".getBytes(), categories.get(random.nextInt(size))));
        subCategories.add(new SubCategory("Dining Tables", "diningTablesImageBytes".getBytes(), categories.get(random.nextInt(size))));
        subCategories.add(new SubCategory("Desks", "desksImageBytes".getBytes(), categories.get(random.nextInt(size))));
        subCategories.add(new SubCategory("Outdoor Sets", "outdoorSetsImageBytes".getBytes(), categories.get(random.nextInt(size))));
        subCategories.add(new SubCategory("Cabinets", "cabinetsImageBytes".getBytes(), categories.get(random.nextInt(size))));
        subCategories.add(new SubCategory("Toilets", "toiletsImageBytes".getBytes(), categories.get(random.nextInt(size))));
        subCategories.add(new SubCategory("Kids Beds", "kidsBedsImageBytes".getBytes(), categories.get(random.nextInt(size))));
        subCategories.add(new SubCategory("TV Stands", "tvStandsImageBytes".getBytes(), categories.get(random.nextInt(size))));
        subCategories.add(new SubCategory("Bookcases", "bookcasesImageBytes".getBytes(), categories.get(random.nextInt(size))));
        subCategories.add(new SubCategory("Chairs", "chairsImageBytes".getBytes(), categories.get(random.nextInt(size))));
        subCategories.add(new SubCategory("Mattresses", "mattressesImageBytes".getBytes(), categories.get(random.nextInt(size))));
        subCategories.add(new SubCategory("Bar Tables", "barTablesImageBytes".getBytes(), categories.get(random.nextInt(size))));
        subCategories.add(new SubCategory("Office Chairs", "officeChairsImageBytes".getBytes(), categories.get(random.nextInt(size))));
        subCategories.add(new SubCategory("Outdoor Chairs", "outdoorChairsImageBytes".getBytes(), categories.get(random.nextInt(size))));
        subCategories.add(new SubCategory("Shelves", "shelvesImageBytes".getBytes(), categories.get(random.nextInt(size))));
        subCategories.add(new SubCategory("Bathroom Vanities", "bathroomVanitiesImageBytes".getBytes(), categories.get(random.nextInt(size))));
        subCategories.add(new SubCategory("Kids Desks", "kidsDesksImageBytes".getBytes(), categories.get(random.nextInt(size))));
        subCategories.add(new SubCategory("Media Cabinets", "mediaCabinetsImageBytes".getBytes(), categories.get(random.nextInt(size))));
        subCategories.add(new SubCategory("Storage Benches", "storageBenchesImageBytes".getBytes(), categories.get(random.nextInt(size))));

        subCategoryRep.saveAll(subCategories);
    }

    public void addProducts() {
        List<Material> materials = materialRep.findAll();
        List<SubCategory> subCategories = subCategoryRep.findAll();
        List<Product> products = new ArrayList<>();

        int materials_size = materials.size();
        int subcategories_size = subCategories.size();

        Random random = new Random();

        SubCategory s1 = subCategories.get(random.nextInt(0,subcategories_size));
        List<Material> m1 = new ArrayList<>();
        for(int i = 0; i < 2; i++) m1.add(materials.get(random.nextInt(0,materials_size)));
        products.add(new Product(799.99, "Leather Sofa", "Stylish and comfortable leather sofa.", materials.subList(0, 2), s1.getCategory(), s1));

        SubCategory s2 = subCategories.get(random.nextInt(subCategories.size()));
        List<Material> m2 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            m2.add(materials.get(random.nextInt(materials.size())));
        }
        products.add(new Product(499.99, "Platform Bed", "Modern platform bed with sleek design.", m2, s2.getCategory(), s2));

        SubCategory s3 = subCategories.get(random.nextInt(subCategories.size()));
        List<Material> m3 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            m3.add(materials.get(random.nextInt(materials.size())));
        }
        products.add(new Product(299.99, "Dining Table", "Elegant dining table for family gatherings.", m3, s3.getCategory(), s3));

        SubCategory s4 = subCategories.get(random.nextInt(subCategories.size()));
        List<Material> m4 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            m4.add(materials.get(random.nextInt(materials.size())));
        }
        products.add(new Product(199.99, "Writing Desk", "Compact writing desk for home office.", m4, s4.getCategory(), s4));

        SubCategory s5 = subCategories.get(random.nextInt(subCategories.size()));
        List<Material> m5 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            m5.add(materials.get(random.nextInt(materials.size())));
        }
        products.add(new Product(599.99, "Outdoor Dining Set", "Durable outdoor dining set for backyard parties.", m5, s5.getCategory(), s5));

        SubCategory s6 = subCategories.get(random.nextInt(subCategories.size()));
        List<Material> m6 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            m6.add(materials.get(random.nextInt(materials.size())));
        }
        products.add(new Product(249.99, "Storage Cabinet", "Versatile storage cabinet for organizing items.", m6, s6.getCategory(), s6));

        SubCategory s7 = subCategories.get(random.nextInt(subCategories.size()));
        List<Material> m7 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            m7.add(materials.get(random.nextInt(materials.size())));
        }
        products.add(new Product(149.99, "Toilet Bowl", "Modern toilet bowl with efficient flush.", m7, s7.getCategory(), s7));

        SubCategory s8 = subCategories.get(random.nextInt(subCategories.size()));
        List<Material> m8 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            m8.add(materials.get(random.nextInt(materials.size())));
        }
        products.add(new Product(399.99, "TV Stand", "Sleek TV stand with ample storage space.", m8, s8.getCategory(), s8));

        SubCategory s9 = subCategories.get(random.nextInt(subCategories.size()));
        List<Material> m9 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            m9.add(materials.get(random.nextInt(materials.size())));
        }
        products.add(new Product(179.99, "Bookcase", "Stylish bookcase for showcasing your collection.", m9, s9.getCategory(), s9));

        SubCategory s11 = subCategories.get(random.nextInt(subCategories.size()));
        List<Material> m11 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            m11.add(materials.get(random.nextInt(materials.size())));
        }
        products.add(new Product(199.99, "Accent Chair", "Eye-catching accent chair for adding flair to any room.", m11, s11.getCategory(), s11));

        SubCategory s12 = subCategories.get(random.nextInt(subCategories.size()));
        List<Material> m12 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            m12.add(materials.get(random.nextInt(materials.size())));
        }
        products.add(new Product(799.99, "Memory Foam Mattress", "Luxurious memory foam mattress for a good night's sleep.", m12, s12.getCategory(), s12));

        SubCategory s13 = subCategories.get(random.nextInt(subCategories.size()));
        List<Material> m13 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            m13.add(materials.get(random.nextInt(materials.size())));
        }
        products.add(new Product(249.99, "Bar Table", "Compact bar table for entertaining guests.", m13, s13.getCategory(), s13));

        SubCategory s14 = subCategories.get(random.nextInt(subCategories.size()));
        List<Material> m14 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            m14.add(materials.get(random.nextInt(materials.size())));
        }
        products.add(new Product(149.99, "Mesh Office Chair", "Comfortable office chair with breathable mesh back.", m14, s14.getCategory(), s14));

        SubCategory s15 = subCategories.get(random.nextInt(subCategories.size()));
        List<Material> m15 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            m15.add(materials.get(random.nextInt(materials.size())));
        }
        products.add(new Product(299.99, "Outdoor Lounge Chair", "Relaxing outdoor lounge chair for sunbathing.", m15, s15.getCategory(), s15));

        SubCategory s16 = subCategories.get(random.nextInt(subCategories.size()));
        List<Material> m16 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            m16.add(materials.get(random.nextInt(materials.size())));
        }
        products.add(new Product(199.99, "Floating Shelf", "Stylish floating shelf for displaying decorative items.", m16, s16.getCategory(), s16));

        SubCategory s17 = subCategories.get(random.nextInt(subCategories.size()));
        List<Material> m17 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            m17.add(materials.get(random.nextInt(materials.size())));
        }
        products.add(new Product(149.99, "Bathroom Vanity", "Elegant bathroom vanity for a sophisticated look.", m17, s17.getCategory(), s17));

        SubCategory s18 = subCategories.get(random.nextInt(subCategories.size()));
        List<Material> m18 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            m18.add(materials.get(random.nextInt(materials.size())));
        }
        products.add(new Product(349.99, "Study Desk", "Spacious study desk with built-in storage.", m18, s18.getCategory(), s18));

        SubCategory s19 = subCategories.get(random.nextInt(subCategories.size()));
        List<Material> m19 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            m19.add(materials.get(random.nextInt(materials.size())));
        }
        products.add(new Product(179.99, "Shoe Rack", "Convenient shoe rack for keeping your footwear organized.", m19, s19.getCategory(), s19));

        SubCategory s20 = subCategories.get(random.nextInt(subCategories.size()));
        List<Material> m20 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            m20.add(materials.get(random.nextInt(materials.size())));
        }
        products.add(new Product(299.99, "Lounge Sofa", "Comfortable lounge sofa for relaxation.", m20, s20.getCategory(), s20));

        SubCategory s21 = subCategories.get(random.nextInt(subCategories.size()));
        List<Material> m21 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            m21.add(materials.get(random.nextInt(materials.size())));
        }
        products.add(new Product(249.99, "Bar Stool", "Sleek and modern bar stool for elevated seating.", m21, s21.getCategory(), s21));

        SubCategory s22 = subCategories.get(random.nextInt(subCategories.size()));
        List<Material> m22 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            m22.add(materials.get(random.nextInt(materials.size())));
        }
        products.add(new Product(399.99, "Sectional Sofa", "Versatile and spacious sectional sofa for lounging.", m22, s22.getCategory(), s22));

        SubCategory s23 = subCategories.get(random.nextInt(subCategories.size()));
        List<Material> m23 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            m23.add(materials.get(random.nextInt(materials.size())));
        }
        products.add(new Product(179.99, "Coffee Table", "Elegant coffee table for serving and storage.", m23, s23.getCategory(), s23));

        SubCategory s24 = subCategories.get(random.nextInt(subCategories.size()));
        List<Material> m24 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            m24.add(materials.get(random.nextInt(materials.size())));
        }
        products.add(new Product(599.99, "Recliner Chair", "Plush and comfortable recliner chair for ultimate relaxation.", m24, s24.getCategory(), s24));

        SubCategory s25 = subCategories.get(random.nextInt(subCategories.size()));
        List<Material> m25 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            m25.add(materials.get(random.nextInt(materials.size())));
        }
        products.add(new Product(349.99, "Dresser", "Stylish dresser with ample storage space for clothes.", m25, s25.getCategory(), s25));

        SubCategory s26 = subCategories.get(random.nextInt(subCategories.size()));
        List<Material> m26 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            m26.add(materials.get(random.nextInt(materials.size())));
        }
        products.add(new Product(199.99, "Side Table", "Compact and functional side table for placing essentials.", m26, s26.getCategory(), s26));

        SubCategory s27 = subCategories.get(random.nextInt(subCategories.size()));
        List<Material> m27 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            m27.add(materials.get(random.nextInt(materials.size())));
        }
        products.add(new Product(449.99, "Console Table", "Sleek console table for hallway or living room decor.", m27, s27.getCategory(), s27));

        SubCategory s28 = subCategories.get(random.nextInt(subCategories.size()));
        List<Material> m28 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            m28.add(materials.get(random.nextInt(materials.size())));
        }
        products.add(new Product(299.99, "Armchair", "Comfortable and stylish armchair for relaxation.", m28, s28.getCategory(), s28));

        SubCategory s29 = subCategories.get(random.nextInt(subCategories.size()));
        List<Material> m29 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            m29.add(materials.get(random.nextInt(materials.size())));
        }
        products.add(new Product(549.99, "Bed Frame", "Sturdy bed frame for a restful night's sleep.", m29, s29.getCategory(), s29));

        SubCategory s30 = subCategories.get(random.nextInt(subCategories.size()));
        List<Material> m30 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            m30.add(materials.get(random.nextInt(materials.size())));
        }
        products.add(new Product(179.99, "Accent Cabinet", "Chic accent cabinet for storage and display.", m30, s30.getCategory(), s30));

        SubCategory s31 = subCategories.get(random.nextInt(subCategories.size()));
        List<Material> m31 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            m31.add(materials.get(random.nextInt(materials.size())));
        }
        products.add(new Product(299.99, "Bar Cabinet", "Elegant bar cabinet for storing your favorite drinks.", m31, s31.getCategory(), s31));

        SubCategory s32 = subCategories.get(random.nextInt(subCategories.size()));
        List<Material> m32 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            m32.add(materials.get(random.nextInt(materials.size())));
        }
        products.add(new Product(499.99, "Chaise Lounge", "Luxurious chaise lounge for relaxation and comfort.", m32, s32.getCategory(), s32));

        SubCategory s33 = subCategories.get(random.nextInt(subCategories.size()));
        List<Material> m33 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            m33.add(materials.get(random.nextInt(materials.size())));
        }
        products.add(new Product(199.99, "TV Console", "Sleek and functional TV console for entertainment setup.", m33, s33.getCategory(), s33));

        SubCategory s34 = subCategories.get(random.nextInt(subCategories.size()));
        List<Material> m34 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            m34.add(materials.get(random.nextInt(materials.size())));
        }
        products.add(new Product(399.99, "Nightstand", "Compact nightstand with storage for bedside essentials.", m34, s34.getCategory(), s34));

        SubCategory s35 = subCategories.get(random.nextInt(subCategories.size()));
        List<Material> m35 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            m35.add(materials.get(random.nextInt(materials.size())));
        }
        products.add(new Product(599.99, "Sectional Sleeper Sofa", "Versatile sectional sofa that converts into a bed.", m35, s35.getCategory(), s35));

        SubCategory s36 = subCategories.get(random.nextInt(subCategories.size()));
        List<Material> m36 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            m36.add(materials.get(random.nextInt(materials.size())));
        }
        products.add(new Product(249.99, "Ottoman", "Stylish ottoman for resting your feet or extra seating.", m36, s36.getCategory(), s36));

        SubCategory s37 = subCategories.get(random.nextInt(subCategories.size()));
        List<Material> m37 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            m37.add(materials.get(random.nextInt(materials.size())));
        }
        products.add(new Product(149.99, "Console Cabinet", "Elegant console cabinet for hallway or living room.", m37, s37.getCategory(), s37));

        SubCategory s38 = subCategories.get(random.nextInt(subCategories.size()));
        List<Material> m38 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            m38.add(materials.get(random.nextInt(materials.size())));
        }
        products.add(new Product(349.99, "Vanity Desk", "Chic vanity desk for getting ready in style.", m38, s38.getCategory(), s38));

        SubCategory s39 = subCategories.get(random.nextInt(subCategories.size()));
        List<Material> m39 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            m39.add(materials.get(random.nextInt(materials.size())));
        }
        products.add(new Product(199.99, "Accent Mirror", "Eye-catching accent mirror for adding depth to your space.", m39, s39.getCategory(), s39));

        SubCategory s40 = subCategories.get(random.nextInt(subCategories.size()));
        List<Material> m40 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            m40.add(materials.get(random.nextInt(materials.size())));
        }
        products.add(new Product(179.99, "Entryway Bench", "Functional entryway bench with storage compartments.", m40, s40.getCategory(), s40));

        SubCategory s41 = subCategories.get(random.nextInt(subCategories.size()));
        List<Material> m41 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            m41.add(materials.get(random.nextInt(materials.size())));
        }
        products.add(new Product(299.99, "Bookshelf", "Versatile bookshelf for organizing your book collection.", m41, s41.getCategory(), s41));

        SubCategory s42 = subCategories.get(random.nextInt(subCategories.size()));
        List<Material> m42 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            m42.add(materials.get(random.nextInt(materials.size())));
        }
        products.add(new Product(399.99, "Dining Table", "Elegant dining table for hosting family and friends.", m42, s42.getCategory(), s42));

        SubCategory s43 = subCategories.get(random.nextInt(subCategories.size()));
        List<Material> m43 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            m43.add(materials.get(random.nextInt(materials.size())));
        }
        products.add(new Product(149.99, "Desk Chair", "Comfortable desk chair for productive work sessions.", m43, s43.getCategory(), s43));

        SubCategory s44 = subCategories.get(random.nextInt(subCategories.size()));
        List<Material> m44 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            m44.add(materials.get(random.nextInt(materials.size())));
        }
        products.add(new Product(599.99, "Sleeper Sofa", "Convertible sleeper sofa for overnight guests.", m44, s44.getCategory(), s44));

        SubCategory s45 = subCategories.get(random.nextInt(subCategories.size()));
        List<Material> m45 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            m45.add(materials.get(random.nextInt(materials.size())));
        }
        products.add(new Product(249.99, "Sideboard", "Stylish sideboard for storing dining essentials.", m45, s45.getCategory(), s45));

        SubCategory s46 = subCategories.get(random.nextInt(subCategories.size()));
        List<Material> m46 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            m46.add(materials.get(random.nextInt(materials.size())));
        }
        products.add(new Product(199.99, "Bean Bag Chair", "Casual and comfortable bean bag chair for lounging.", m46, s46.getCategory(), s46));

        SubCategory s47 = subCategories.get(random.nextInt(subCategories.size()));
        List<Material> m47 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            m47.add(materials.get(random.nextInt(materials.size())));
        }
        products.add(new Product(349.99, "Chest of Drawers", "Functional chest of drawers for clothing storage.", m47, s47.getCategory(), s47));

        SubCategory s48 = subCategories.get(random.nextInt(subCategories.size()));
        List<Material> m48 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            m48.add(materials.get(random.nextInt(materials.size())));
        }
        products.add(new Product(399.99, "Armless Chair", "Sleek armless chair for modern seating arrangements.", m48, s48.getCategory(), s48));

        SubCategory s49 = subCategories.get(random.nextInt(subCategories.size()));
        List<Material> m49 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            m49.add(materials.get(random.nextInt(materials.size())));
        }
        products.add(new Product(299.99, "Folding Table", "Versatile folding table for indoor and outdoor use.", m49, s49.getCategory(), s49));

        SubCategory s50 = subCategories.get(random.nextInt(subCategories.size()));
        List<Material> m50 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            m50.add(materials.get(random.nextInt(materials.size())));
        }
        products.add(new Product(179.99, "Shelving Unit", "Functional shelving unit for displaying decor and storage.", m50, s50.getCategory(), s50));


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

   /* public void addMoreOrders() {
        List<Customer> customers = customerRep.findAll();
        List<Order> orders = new ArrayList<>();

        Random random = new Random();

        for (int i = 1; i <= 100; i++) {
            LocalDate currentDate = LocalDate.now();
            LocalDate orderDate = currentDate.minusDays(i); // Subtracting days to simulate different order dates

            boolean storePickUp = i % 2 == 0; // Alternating between store pick-up and delivery
            OrderState state;

            if (i % 3 == 0) {
                state = OrderState.READY;
            } else if (i % 3 == 1) {
                state = OrderState.DONE;
            } else {
                state = OrderState.PENDING;
            }

            Customer customer = customers.get(random.nextInt(customers.size())); // Randomly select a customer

            Order order;
            if (storePickUp) order = new Order(orderDate, "Store", storePickUp, state, customer);
            else order = new Order(orderDate, customer.getAddress(), storePickUp, state, customer);
            orders.add(order);
        }

        orderRep.saveAll(orders);
    }*/

    public void addImages() {
        List<Product> products = productRep.findAll();
        List<Image> images = new ArrayList<>();

        Random random = new Random();

        int i = 1;
        for(Product p : products) {
            String imageName = "image" + i + "Bytes";
            images.add(new Image(imageName.getBytes(), p));
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
                String address = c.getAddress();
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

    public void addCompany() {
        String schedule = "Monday - Friday\n" +
                "9:00 AM - 12:30 PM | 2:00 PM - 7:00 PM\n" +
                "Saturday\n" +
                "CLOSED\n" +
                "Sunday\n" +
                "CLOSED\n";
        Company company = new Company("Móveis Rodrigues","geral@rodrigues-moveis.pt","252 993 990",
                "Rua do Carvalhal, nº 18, Vila Nova de Famalicão, Portugal",
                "MoveisRodrigues".getBytes(),
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
