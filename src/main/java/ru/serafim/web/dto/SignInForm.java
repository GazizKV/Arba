package ru.serafim.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.serafim.web.validation.NotSameNames;
import ru.serafim.web.validation.ValidPassword;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@NotSameNames
public class SignInForm {

    @NotBlank
    @Email
    private String email;
    @NotBlank
    @ValidPassword
    private String password;

}
