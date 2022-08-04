package ua.ponomarov.Illia.chat.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class PersonDTO {

    @NotEmpty(message = "Username should be not empty")
    @Size(min = 2, max = 100, message = "Username should be between 2 and 100 characters")
    private String username;

    @Min(value = 1900, message = "Year of birth should be large then 1990")
    private int yearOfBirth;

    @Email
    private String email;


    private String password;
}
