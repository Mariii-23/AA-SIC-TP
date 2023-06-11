package com.example.backend.services;

import com.example.backend.dto.*;
import com.example.backend.model.*;
import com.example.backend.repositories.AdminRep;
import com.example.backend.repositories.CustomerRep;
import com.example.backend.repositories.ProductRep;
import com.example.backend.repositories.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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


    public Customer addCustomer(Customer customer) {
        return customerRep.save(customer);
    }

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

    public void addCustomerDTO(CustomerDTO costumerDTO){
        ShoppingCart cart = new ShoppingCart();
        Customer customer = new Customer(costumerDTO.getBirthday(),
                                         costumerDTO.getNif(),
                                         costumerDTO.getAddress(),
                                         costumerDTO.getEmail(),
                                         costumerDTO.getPassword(),
                                         costumerDTO.getName(),
                                         cart);
        addCustomer(customer);
    }

    public void addAdminDTO(AdminDTO adminDTO){
        Admin admin = new Admin(adminDTO.getEmail(),
                                adminDTO.getName(),
                                adminDTO.getPassword());
        addAdmin(admin);
    }

    public boolean login(LoginDTO loginDTO) {
        User user = userRep.findByEmail(loginDTO.getEmail());
        return user.getPassword().equals(loginDTO.getPassword());
    }

    public boolean logout(String token) {
        return true;
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
}
