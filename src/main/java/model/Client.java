package model;


import lombok.*;

import java.time.LocalDate;

//@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client extends User{

    @Setter
    private int code;
    public Client(int code, String firstName, String lastName, LocalDate birthDay, String phone, String address) {
        super(firstName, lastName, birthDay, phone, address);
        this.code = code;
    }

}
