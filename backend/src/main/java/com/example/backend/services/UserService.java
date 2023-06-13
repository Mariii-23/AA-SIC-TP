package com.example.backend.services;

import com.example.backend.Exception.ProductNotFoundException;
import com.example.backend.Exception.UserNotFoundException;
import com.example.backend.dto.*;
import com.example.backend.event.EmailEvent;
import com.example.backend.model.*;
import com.example.backend.repositories.AdminRep;
import com.example.backend.repositories.CustomerRep;
import com.example.backend.repositories.ProductRep;
import com.example.backend.repositories.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service("userService")
public class UserService {

    @Autowired
    private UserRep userRep;

    @Autowired
    private CustomerRep customerRep;

    @Autowired
    private AdminRep adminRep;

    @Autowired
    private ProductRep productRep;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;


    public Admin addAdmin(Admin admin) {
        return adminRep.save(admin);
    }

    public CustomerDTO getCustomerById(int id) throws UserNotFoundException {
        Customer customer = customerRep.findById(id).orElse(null);
        if (customer == null) {
            throw new UserNotFoundException("Custumer not found");
        }
        return new CustomerDTO(customer);
    }

    public AdminDTO getAdminById(int id) throws UserNotFoundException {
        Admin admin = adminRep.findById(id).orElse(null);
        if (admin == null) {
            throw new UserNotFoundException("Admin not found");
        }
        return new AdminDTO(admin);
    }

    public List<AdminDTO> getAllAdmins() {
        List<AdminDTO> result = new ArrayList<>();
        List<Admin> admins = adminRep.findAll();
        admins.forEach(admin -> {
            result.add(new AdminDTO(admin));
        });
        return result;
    }

    public List<CustomerDTO> getAllCustomers() {
        List<CustomerDTO> result = new ArrayList<>();
        List<Customer> customers = customerRep.findAll();
        customers.forEach(customer -> {
            result.add(new CustomerDTO(customer));
        });
        return result;
    }

    public void addAdminDTO(AdminDTO adminDTO){
        Admin admin = new Admin(adminDTO.getEmail(),
                                passwordEncoder.encode(adminDTO.getPassword()),
                                adminDTO.getName()
                );
        addAdmin(admin);
    }

    public List<FavouriteDTO> getFavourites(int id) throws UserNotFoundException {
        Customer customer = customerRep.findById(id).orElse(null);
        if (customer == null) {
            throw new UserNotFoundException("Custumer not found");
        }
        List<FavouriteDTO> result = new ArrayList<>();
        customer.getFavourites().forEach(product -> {
            result.add(new FavouriteDTO(product.getName(), product.getPrice()));
        });
        return result;
    }

    public ShoppingCartDTO getShoppingCart(int id) throws UserNotFoundException {
        Customer customer = customerRep.findById(id).orElse(null);
        if (customer == null) {
            throw new UserNotFoundException("Custumer not found");
        }
        List<ItemDTO> itens = new ArrayList<>();
        customer.getCart().getItems().forEach(item -> {
            itens.add(new ItemDTO(item.getProduct().getName(),
                                  item.getProduct().getPrice(),
                                  item.getQuantity(),
                                  item.getMaterial().getImage()));
        });
        return new ShoppingCartDTO(itens, customer.getCart().getTotalPrice());
    }

    public List<OrderSimpleDTO> getOrders(int id) throws UserNotFoundException {
        Customer customer = customerRep.findById(id).orElse(null);
        if (customer == null) {
            throw new UserNotFoundException("Custumer not found");
        }
        List<OrderSimpleDTO> result = new ArrayList<>();
        customer.getOrders().forEach(order -> {
            List<ItemDTO> itens = new ArrayList<>();
            order.getItems().forEach(orderitem -> {
                itens.add(new ItemDTO(orderitem.getProduct().getName(),
                                      orderitem.getPrice(),
                                      orderitem.getQuantity()));
            });
            result.add(new OrderSimpleDTO(order));
        });
        return result;
    }

    public void addFavourite(int costumerId, int productId) throws UserNotFoundException, ProductNotFoundException {
        Customer customer = customerRep.findById(costumerId).orElse(null);
        if (customer == null) {
            throw new UserNotFoundException("Custumer not found");
        }
        Product product = productRep.findById(productId).orElse(null);
        if (product == null) {
            throw new ProductNotFoundException("Product not found");
        }
        customer.addFavourite(product);
        customerRep.save(customer);
    }

    public void deleteFavourite(int costumerId, int productId) throws UserNotFoundException, ProductNotFoundException {
        Customer customer = customerRep.findById(costumerId).orElse(null);
        if (customer == null) {
            throw new UserNotFoundException("Custumer not found");
        }
        List<Product> favourites = customer.getFavourites();
        Product product = favourites.stream().filter(p -> p.getiD() == productId).findFirst().orElse(null);
        if (product == null) {
            throw new ProductNotFoundException("Product not in favourites");
        }
        customer.removeFavourite(product);
        customerRep.save(customer);
    }

    public void removeAdmin(int adminId) throws UserNotFoundException {
        Admin admin = adminRep.findById(adminId).orElse(null);
        if (admin == null) {
            throw new UserNotFoundException("Admin not found");
        }
        adminRep.delete(admin);
    }

    public void editCustomer(int customer_id, CustomerDTO costumerDTO) throws Exception {
        Customer customer = customerRep.getReferenceById(customer_id);
        if (customer == null) {
            throw new UserNotFoundException("Custumer not found");
        }
        if (costumerDTO.getEmail() != null) {
            if (customerRep.existsByEmail(costumerDTO.getEmail())) {
                throw new Exception("Email already exists");
            }
            customer.setEmail(costumerDTO.getEmail());
        }
        if (costumerDTO.getPassword() != null) customer.setPassword(costumerDTO.getPassword());
        if (costumerDTO.getName() != null) customer.setName(costumerDTO.getName());
        if (costumerDTO.getBirthday() != null) customer.setBirthday(costumerDTO.getBirthday());
        if (costumerDTO.getNif() != null) {
            if (customerRep.existsByNif(costumerDTO.getNif())) {
                throw new Exception("Nif already exists");
            }
            customer.setNif(costumerDTO.getNif());
        }
        if (costumerDTO.getAddress() != null) customer.setAddress(costumerDTO.getAddress());
        customerRep.save(customer);
    }

    public void editAdmin(int adminId, AdminDTO adminDTO) throws Exception {
        Admin admin = adminRep.findById(adminId).orElse(null);
        if (admin == null) {
            throw new UserNotFoundException("Admin not found");
        }
        if (adminDTO.getEmail() != null) {
            User user = userRep.findByEmail(adminDTO.getEmail()).orElse(null);
            if (user != null) {
                throw new Exception("Email already in use");
            }
            admin.setEmail(adminDTO.getEmail());
        }
        if (adminDTO.getPassword() != null) admin.setPassword(adminDTO.getPassword());
        if (adminDTO.getName() != null) admin.setName(adminDTO.getName());
        adminRep.save(admin);
    }

    public String recoverPassword(int userId) throws UserNotFoundException {
        SecureRandom secureRandom = new SecureRandom();
        Base64.Encoder encoder = Base64.getUrlEncoder();
        byte[] randomBytes = new byte[24];
        secureRandom.nextBytes(randomBytes);
        String token = encoder.encodeToString(randomBytes);

        String subject = "Password Recovery";
        String message = "Use this token to recover your password: " + token;
        User user = userRep.findById(userId).orElse(null);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        user.setPasswordToken(token);
        userRep.save(user);

        applicationEventPublisher.publishEvent(new EmailEvent(this, user, subject, message));
        return token;
    }

    public boolean confirmRecoverPassword(int userId, String token, String newPassword) throws UserNotFoundException {
        User user = userRep.findById(userId).orElse(null);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        if (user.getPasswordToken().equals(token)) {
            user.setPassword(passwordEncoder.encode(newPassword));
            user.setPasswordToken(null);
            userRep.save(user);
            return true;
        }
        return false;
    }
}
