package com.smartsew.smartsew.services;

import com.smartsew.smartsew.requests.SignUpRequest;
import com.smartsew.smartsew.requests.UpdateAccountRequest;
import com.smartsew.smartsew.responses.ResponseObject;
import org.springframework.http.ResponseEntity;

public interface AccountService {
    ResponseEntity<ResponseObject> signUp(SignUpRequest request);

    ResponseEntity<ResponseObject> getAllAccounts();

    ResponseEntity<ResponseObject> getAccountById(Integer id);

    ResponseEntity<ResponseObject> updateAccount(Integer id, UpdateAccountRequest request);

    ResponseEntity<ResponseObject> deleteAccount(Integer id);

}
