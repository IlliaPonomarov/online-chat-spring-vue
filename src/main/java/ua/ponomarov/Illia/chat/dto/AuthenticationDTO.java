package ua.ponomarov.Illia.chat.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class AuthenticationDTO {

    @NotEmpty(message = "Username should not be empty")
    @Size(min = 2, max = 100, message = "Username length should be between 2 and 100 characters")
    private String username;

    private String password;
}
