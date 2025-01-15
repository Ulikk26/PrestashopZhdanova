package models;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class PersonalInformation {
    private String title;
    private String firstName;
    private String lastName;
    private String password;
    private String dateOfBirth;
}
