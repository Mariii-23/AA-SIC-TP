package com.example.backend.services;

import com.example.backend.Exception.UserNotFoundException;
import com.example.backend.dto.AuthenticationRequest;
import com.example.backend.dto.AuthenticationResponse;
import com.example.backend.dto.CustomerDTO;
import com.example.backend.model.Customer;
import com.example.backend.model.ShoppingCart;
import com.example.backend.model.Token;
import com.example.backend.model.User;
import com.example.backend.repositories.CustomerRep;
import com.example.backend.repositories.TokenRep;
import com.example.backend.repositories.UserRep;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class AuthenticateService {
    private final UserRep userRep;
    private final CustomerRep customerRep;
    private final TokenRep tokenRep;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final WebClient emailVerifier;

    public AuthenticationResponse register(CustomerDTO request) throws Exception {
        boolean valid = true;/*emailVerifier
                            .post()
                            .bodyValue("email=" + request.getEmail())
                            .retrieve()
                            .bodyToMono(JsonNode.class)
                            .map(jsonNode -> jsonNode.get("valid").asBoolean())
                            .block();*/
        if (valid) {
            ShoppingCart shoppingCart = new ShoppingCart();
            if (customerRep.existsByEmail(request.getEmail())) {
                throw new Exception("Email already registered");
            }
            if (customerRep.existsByNif(request.getNif())) {
                throw new Exception("NIF already registered");
            }
            Customer customer = new Customer(request.getBirthday(),
                    request.getNif(),
                    request.getAddress(),
                    request.getEmail(),
                    passwordEncoder.encode(request.getPassword()),
                    request.getName(),
                    shoppingCart);
            String token = jwtService.generateToken(customer);
            Token tokenObj = new Token(token, customer);
            try {
                customerRep.save(customer);
                tokenRep.save(tokenObj);
            } catch (Exception e) {
                throw e;
            }
            return new AuthenticationResponse(token);
        } else {
            throw new Exception("Email not valid");
        }
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) throws UserNotFoundException {
        authenticationManager.authenticate((
                new UsernamePasswordAuthenticationToken(request.getEmail(),
                request.getPassword()
                )));
        User user = userRep.findByEmail(request.getEmail()).orElse(null);
        if (user == null) {
            throw new UserNotFoundException("User with email " + request.getEmail() + " not found");
        }
        String token = jwtService.generateToken(user);
        Token tokenObj = new Token(token, user);
        userRep.save(user);
        tokenRep.save(tokenObj);
        return new AuthenticationResponse(token);
    }

    public boolean logout(String token) throws Exception {
        Token tokenObj = tokenRep.findByToken(token).orElseThrow(() -> new Exception("Token not found"));
        if (tokenObj == null) {
            return false;
        }
        tokenRep.delete(tokenObj);
        return true;
    }
}
