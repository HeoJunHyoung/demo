package com.example.demo.user.domain;

import com.example.demo.common.domain.JpaBaseEntity;
import com.example.demo.user.domain.enumerate.UserRole;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "users")
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class UserEntity extends JpaBaseEntity {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", length = 100, unique = true)
    private String email;

    @Column(name = "name", length = 50)
    private String name; // 실명 (예약자명)

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "user_role", nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private UserRole role;

    private UserEntity(String email, String name, LocalDate birthDate, UserRole role) {
        this.email = email;
        this.name = name;
        this.birthDate = birthDate;
        this.role = role;
    }

    public static UserEntity of(String email, String name, LocalDate birthDate, UserRole role) {
        return new UserEntity(email, name, birthDate, role);
    }
}
