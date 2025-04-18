package com.unisew.unisew.requests;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SignUpRequest {

    String username;

    String phone;

    String address;

    String email;

    String password;

    String confirmPassword;

}
