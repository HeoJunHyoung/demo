package com.example.demo.user.domain.enumerate;

import lombok.Getter;

@Getter
public enum UserRole {
    MEMBER("일반 회원"),
    HOTEL_OWNER("호텔 주인"),
    ADMIN("관리자");

    private final String description;

    UserRole(String description) {
        this.description = description;
    }
}
