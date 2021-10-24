package org.example.dto;

import lombok.Data;
import org.example.validation.PasswordMatchConstraint;

@Data
@PasswordMatchConstraint.List({
        @PasswordMatchConstraint(password = "password", passwordMatch = "reTypePassword"),
        //@PasswordMatchConstraint(password = "email", passwordMatch = "reTypeEmail")
})
public class UserDTO {

    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String reTypePassword;
//
//    private String email;
//    private String reTypeEmail;
//
}
