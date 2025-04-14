package com.smartsew.smartsew.responses;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResponseObject {
    boolean success;
    String message;
    Object data;
}
