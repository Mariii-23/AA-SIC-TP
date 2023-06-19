package com.example.backend.services;

import com.example.backend.dto.orderDTOs.ItemDTO;
import com.example.backend.dto.orderDTOs.ShoppingCartDTO;
import com.example.backend.dto.productDTOs.ProductDetailedDTO;
import com.example.backend.dto.productDTOs.ProductSimpleDTO;
import com.example.backend.dto.userDTOs.*;
import com.example.backend.exception.ProductNotFoundException;
import com.example.backend.exception.UserNotFoundException;
import com.example.backend.dto.*;
import com.example.backend.event.EmailEvent;
import com.example.backend.model.*;
import com.example.backend.repositories.*;
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


    public AdminDTO addAdmin(Admin admin) {
        return new AdminDTO(adminRep.save(admin));
    }

    public CustomerDTO getCustomerById(int id) throws UserNotFoundException {
        Customer customer = customerRep.findById(id).orElse(null);
        if (customer == null) {
            throw new UserNotFoundException("Customer not found");
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

    public EnvelopeDTO<AdminDTO> getAllAdmins(int offset, int numItems) {
        List<AdminDTO> list = new ArrayList<>();
        List<Admin> admins = adminRep.findAdminPagination(offset, numItems + 1);
        boolean isLast;
        if (admins.size() == numItems + 1) {
            admins.remove(admins.size() - 1);
            isLast = false;
        } else {
            isLast = true;
        }
        admins.forEach(admin -> {
            list.add(new AdminDTO(admin));
        });
        return new EnvelopeDTO<>(isLast, list);
    }

    public EnvelopeDTO<CustomerDTO> getAllCustomers(int offset, int numItems) {
        List<CustomerDTO> list = new ArrayList<>();
        List<Customer> customers = customerRep.findCustomerPagination(offset, numItems + 1);
        boolean isLast;
        if (customers.size() == numItems + 1) {
            customers.remove(customers.size() - 1);
            isLast = false;
        } else {
            isLast = true;
        }
        customers.forEach(customer -> {
            list.add(new CustomerDTO(customer));
        });
        return new EnvelopeDTO<>(isLast, list);
    }

    public AdminDTO addAdminDTO(CreateAdminDTO adminDTO){
        Admin admin = new Admin(adminDTO.getEmail(),
                                passwordEncoder.encode(adminDTO.getPassword()),
                                adminDTO.getName());
        boolean valid = true; /*emailVerifier
                .post()
                .bodyValue("email=" + admin.getEmail())
                .retrieve()
                .bodyToMono(JsonNode.class)
                .map(jsonNode -> jsonNode.get("valid").asBoolean())
                .block();*/
        if(valid) {
            return addAdmin(admin);
        }

        return null;
    }

    public EnvelopeDTO<ProductSimpleDTO> getFavourites(int id, int offset, int numItems) throws UserNotFoundException {
        List<Product> products = productRep.findFavouritesPagination(id, offset, numItems);
        List<ProductSimpleDTO> list = new ArrayList<>();
        products.forEach(product -> {
            list.add(new ProductSimpleDTO(product));
        });
        boolean isLast = (offset + numItems) >= getNumberOfFavourites(id);
        return new EnvelopeDTO<>(isLast, list);
    }

    public ShoppingCartDTO getShoppingCart(int id) throws UserNotFoundException {
        Customer customer = customerRep.findById(id).orElse(null);
        if (customer == null) {
            throw new UserNotFoundException("Customer not found");
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

    public void addFavourite(int customerId, int productId) throws UserNotFoundException, ProductNotFoundException {
        Customer customer = customerRep.findById(customerId).orElse(null);
        if (customer == null) {
            throw new UserNotFoundException("Customer not found");
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
            throw new UserNotFoundException("Customer not found");
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

    public void editCustomer(int customer_id, CreateCustomerDTO costumerDTO) throws Exception {
        Customer customer = customerRep.findById(customer_id).orElse(null);
        if (customer == null) {
            throw new UserNotFoundException("Customer not found");
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

    public void editAdmin(int adminId, CreateAdminDTO adminDTO) throws Exception {
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

    public String recoverPassword(String email) throws UserNotFoundException {
        SecureRandom secureRandom = new SecureRandom();
        Base64.Encoder encoder = Base64.getUrlEncoder();
        byte[] randomBytes = new byte[24];
        secureRandom.nextBytes(randomBytes);
        String token = encoder.encodeToString(randomBytes);

        String subject = "Password Recovery";
        String message = "Use this token to recover your password: " + token;
        User user = userRep.findByEmail(email).orElseThrow(() -> new UserNotFoundException("User not found"));
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

    public int getNumberOfCustomers() {
        return customerRep.getNumberOfCustomers();
    }

    public int getNumberOfAdmins() {
        return adminRep.getNumberOfAdmins();
    }

    public int getNumberOfFavourites(int id) throws UserNotFoundException {
        Customer c = customerRep.findById(id).orElse(null);
        if (c == null) {
            throw new UserNotFoundException("Customer not found");
        } else return c.getFavourites().size();
    }
}
