package com.example.reactblogbe.login.controller;


import com.example.reactblogbe.login.entity.AuthRequest;
import com.example.reactblogbe.login.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class WelcomeController {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/welcome")
    public ResponseEntity<String> welcome() {
        String wel = "Welcome";
        return new ResponseEntity<>(wel, HttpStatus.ACCEPTED);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<String> generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            return new ResponseEntity<>(jwtUtil.generateToken(authRequest.getUserName()),HttpStatus.LOCKED);
        }
        return new ResponseEntity<>(jwtUtil.generateToken(authRequest.getUserName()),HttpStatus.ACCEPTED);
    }
}
