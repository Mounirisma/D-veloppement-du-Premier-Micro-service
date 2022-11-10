package Org.said.bankaccountservice.mappers;

import Org.said.bankaccountservice.Entities.Account;
import Org.said.bankaccountservice.dtos.AccountRequestDTO;
import Org.said.bankaccountservice.dtos.AccountResponseDTO;
import Org.said.bankaccountservice.Entities.Account;
import Org.said.bankaccountservice.dtos.AccountRequestDTO;
import Org.said.bankaccountservice.dtos.AccountResponseDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class AccountMapper {
    public AccountResponseDTO fromAccount(Account account)
    {
        AccountResponseDTO responseDTO = new AccountResponseDTO();
        BeanUtils.copyProperties(account, responseDTO);
        return responseDTO;
    }

    public Account fromAccountDTO(AccountRequestDTO accountResponseDTO)
    {
        Account account = new Account();
        account.setId(UUID.randomUUID().toString());
        account.setCreated(new Date());
        BeanUtils.copyProperties(accountResponseDTO, account);
        return account;
    }
}
