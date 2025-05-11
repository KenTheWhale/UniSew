package com.unisew.unisew.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Status {
    ACCOUNT_ACTIVE("active"),
    ACCOUNT_DELETED("deleted");
    private final String value;
}
