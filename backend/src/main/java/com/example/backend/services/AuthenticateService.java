package com.example.backend.services;

import com.example.backend.dto.AuthenticationRequest;
import com.example.backend.dto.AuthenticationResponse;
import com.example.backend.dto.CustomerDTO;
import com.example.backend.model.Customer;
import com.example.backend.model.ShoppingCart;
import com.example.backend.model.User;
import com.example.backend.repositories.CustomerRep;
import com.example.backend.repositories.UserRep;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticateService {
    private final UserRep userRep;
    private final CustomerRep customerRep;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(CustomerDTO request) {
        ShoppingCart shoppingCart = new ShoppingCart();
        Customer customer = new Customer(request.getBirthday(),
                request.getNif(),
                request.getAddress(),
                request.getEmail(),
                passwordEncoder.encode(request.getPassword()),
                request.getName(),
                shoppingCart);
        customerRep.save(customer);
        String token = jwtService.generateToken(customer);
        return new AuthenticationResponse(token);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate((
                new UsernamePasswordAuthenticationToken(request.getEmail(),
                request.getPassword()
                )));
        User user = userRep.findByEmail(request.getEmail()).orElseThrow();
        String token = jwtService.generateToken(user);
        return new AuthenticationResponse(token);
    }
}