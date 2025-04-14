package com.smartsew.smartsew.services;

import com.smartsew.smartsew.requests.LoginRequest;
import com.smartsew.smartsew.responses.ResponseObject;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService {

    ResponseEntity<ResponseObject> login(LoginRequest request);

    ResponseEntity<ResponseObject> logout();

    ResponseEntity<ResponseObject> getGoogleUrl();
}
