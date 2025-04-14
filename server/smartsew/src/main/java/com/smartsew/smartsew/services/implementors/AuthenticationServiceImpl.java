package com.smartsew.smartsew.services.implementors;

import com.smartsew.smartsew.enums.Status;
import com.smartsew.smartsew.models.Account;
import com.smartsew.smartsew.repositories.AccountRepo;
import com.smartsew.smartsew.requests.LoginRequest;
import com.smartsew.smartsew.responses.ResponseObject;
import com.smartsew.smartsew.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AccountRepo accountRepo;

    private final String BASE_URL = "https://accounts.google.com/o/oauth2/v2/auth";

    private final String REDIRECT_URI = "http://localhost:5173/account/google/callback";

    @Value("${google.client.id}")
    private String clientId;

    @Value("${google.client.response-type}")
    private String responseType;

    @Value("${google.client.scope}")
    private String scope;

    @Value("${google.client.access-type}")
    private String accessType;

    @Override
    public ResponseEntity<ResponseObject> login(LoginRequest request) {
        Account account = accountRepo.findByUsernameAndPassword(request.getUsername(), request.getPassword()).orElse(null);
        if (account == null) {
            return ResponseEntity.ok().body(
                    ResponseObject.builder()
                            .success(false)
                            .message("Incorrect username or password")
                            .build()
            );
        }
        if (!account.getStatus().equalsIgnoreCase(Status.ACCOUNT_ACTIVE.getValue())) {
            return ResponseEntity.ok().body(
                    ResponseObject.builder()
                            .success(false)
                            .message("Account not found or unavailable")
                            .build()
            );
        }
        return ResponseEntity.ok().body(
                ResponseObject.builder()
                        .success(true)
                        .message("Login successfully")
                        .build()
        );
    }

    @Override
    public ResponseEntity<ResponseObject> logout() {
        return ResponseEntity.ok().body(
                ResponseObject.builder()
                        .success(true)
                        .message("Logout successfully")
                        .build()
        );
    }

    @Override
    public ResponseEntity<ResponseObject> getGoogleUrl() {
        Map<String, String> data = new HashMap<>();
        data.put("url", combineUrl());
        return ResponseEntity.ok().body(
                ResponseObject.builder()
                        .success(true)
                        .message("Get google url successfully")
                        .data(data)
                        .build()
        );
    }

    private String combineUrl() {
        String url = "?scope=" + scope + "&access_type=" + accessType + "&response_type=" + responseType + "&client_id=" + clientId + "&redirect_uri=" + REDIRECT_URI;
        url = url.replaceAll(" ", "%20").replaceAll(":", "%3A");
        return BASE_URL + url;
    }
}
