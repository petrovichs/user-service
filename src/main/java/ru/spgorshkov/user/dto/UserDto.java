package ru.spgorshkov.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private UUID uuid;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
