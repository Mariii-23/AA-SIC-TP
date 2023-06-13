package com.example.backend.services;

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

    public CustomerDTO getCustomerById(int id) {
        Customer customer = customerRep.findById(id).orElse(null);
        return new CustomerDTO(customer);
    }

    public AdminDTO getAdminById(int id) {
        Admin admin = adminRep.findById(id).orElse(null);
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

    public List<FavouriteDTO> getFavourites(int id) {
        Customer customer = customerRep.findById(id).orElse(null);
        List<FavouriteDTO> result = new ArrayList<>();
        customer.getFavourites().forEach(product -> {
            result.add(new FavouriteDTO(product.getName(), product.getPrice()));
        });
        return result;
    }

    public ShoppingCartDTO getShoppingCart(int id) {
        Customer customer = customerRep.findById(id).orElse(null);
        List<ItemDTO> itens = new ArrayList<>();
        customer.getCart().getItems().forEach(item -> {
            itens.add(new ItemDTO(item.getProduct().getName(),
                                  item.getProduct().getPrice(),
                                  item.getQuantity(),
                                  item.getMaterial().getImage()));
        });
        return new ShoppingCartDTO(itens, customer.getCart().getTotalPrice());
    }

    public List<OrderSimpleDTO> getOrders(int id) {
        Customer customer = customerRep.findById(id).orElse(null);
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

    public void addFavourite(int costumerId, int productId) {
        Customer customer = customerRep.getReferenceById(costumerId);
        Product product = productRep.getReferenceById(productId);
        customer.addFavourite(product);
        customerRep.save(customer);
    }

    public void deleteFavourite(int costumerId, int productId) {
        Customer customer = customerRep.getReferenceById(costumerId);
        Product product = productRep.getReferenceById(productId);
        customer.removeFavourite(product);
        customerRep.save(customer);
    }

    public void removeAdmin(int adminId) {
        Admin admin = adminRep.getReferenceById(adminId);
        adminRep.delete(admin);
    }

    public void editCustomer(int customer_id, CustomerDTO costumerDTO) {
        Customer customer = customerRep.getReferenceById(customer_id);
        if (costumerDTO.getEmail() != null) customer.setEmail(costumerDTO.getEmail());
        if (costumerDTO.getPassword() != null) customer.setPassword(costumerDTO.getPassword());
        if (costumerDTO.getName() != null) customer.setName(costumerDTO.getName());
        if (costumerDTO.getBirthday() != null) customer.setBirthday(costumerDTO.getBirthday());
        if (costumerDTO.getNif() != null) customer.setNif(costumerDTO.getNif());
        if (costumerDTO.getAddress() != null) customer.setAddress(costumerDTO.getAddress());
        customerRep.save(customer);
    }

    public void editAdmin(int adminId, AdminDTO adminDTO) {
        Admin admin = adminRep.getReferenceById(adminId);
        if (adminDTO.getEmail() != null) admin.setEmail(adminDTO.getEmail());
        if (adminDTO.getPassword() != null) admin.setPassword(adminDTO.getPassword());
        if (adminDTO.getName() != null) admin.setName(adminDTO.getName());
        adminRep.save(admin);
    }

    public String recoverPassword(int userId) {
        SecureRandom secureRandom = new SecureRandom();
        Base64.Encoder encoder = Base64.getUrlEncoder();
        byte[] randomBytes = new byte[24];
        secureRandom.nextBytes(randomBytes);
        String token = encoder.encodeToString(randomBytes);

        String subject = "Password Recovery";
        String message = "Use this token to recover your password: " + token;
        User user = userRep.findById(userId).orElse(null);
        user.setPasswordToken(token);
        userRep.save(user);

        applicationEventPublisher.publishEvent(new EmailEvent(this, user, subject, message));
        return token;
    }

    public boolean confirmRecoverPassword(int userId, String token, String newPassword) {
        User user = userRep.findById(userId).orElse(null);
        if (user.getPasswordToken().equals(token)) {
            user.setPassword(passwordEncoder.encode(newPassword));
            user.setPasswordToken(null);
            userRep.save(user);
            return true;
        }
        return false;
    }
}
