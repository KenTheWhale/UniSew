package com.unisew.unisew.services;

import com.unisew.unisew.requests.SignUpRequest;
import com.unisew.unisew.requests.UpdateAccountRequest;
import com.unisew.unisew.responses.ResponseObject;
import org.springframework.http.ResponseEntity;

public interface AccountService {
    ResponseEntity<ResponseObject> signUp(SignUpRequest request);

    ResponseEntity<ResponseObject> getAllAccounts();

    ResponseEntity<ResponseObject> getAccountById(Integer id);

    ResponseEntity<ResponseObject> updateAccount(Integer id, UpdateAccountRequest request);

    ResponseEntity<ResponseObject> deleteAccount(Integer id);

}
