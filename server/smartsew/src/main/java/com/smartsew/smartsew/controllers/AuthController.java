package com.smartsew.smartsew.controllers;

import com.smartsew.smartsew.requests.LoginRequest;
import com.smartsew.smartsew.responses.ResponseObject;
import com.smartsew.smartsew.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<ResponseObject> login(LoginRequest request) {
        return authenticationService.login(request);
    }

    @GetMapping("/google")
    public ResponseEntity<ResponseObject> getGoogleUrl() {
        return authenticationService.getGoogleUrl();
    }
}
