package com.unisew.unisew.services;

import com.unisew.unisew.requests.LoginRequest;
import com.unisew.unisew.responses.ResponseObject;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService {

    ResponseEntity<ResponseObject> login(LoginRequest request);

    ResponseEntity<ResponseObject> logout();

    ResponseEntity<ResponseObject> getGoogleUrl();
}
