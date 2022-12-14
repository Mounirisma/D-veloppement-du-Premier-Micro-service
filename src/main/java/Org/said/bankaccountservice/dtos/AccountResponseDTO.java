package Org.said.bankaccountservice.dtos;

import Org.said.bankaccountservice.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountResponseDTO {

    private String id;
    private Date created;
    private Double balance;
    private String currency;
    private AccountType type;
}
