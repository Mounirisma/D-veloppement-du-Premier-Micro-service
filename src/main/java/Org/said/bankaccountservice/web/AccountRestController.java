package Org.said.bankaccountservice.web;

import Org.said.bankaccountservice.Entities.Account;
import Org.said.bankaccountservice.dtos.AccountRequestDTO;
import Org.said.bankaccountservice.dtos.AccountResponseDTO;
import Org.said.bankaccountservice.repositories.BankAccountrepository;
import Org.said.bankaccountservice.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class AccountRestController {
    private BankAccountrepository bar;
    private AccountService accountService;

    @GetMapping("/accounts")
    public List<AccountResponseDTO> getAccounts()
    {
        return accountService.getAccounts();
    }

    @GetMapping("/accounts/{id}")
    public AccountResponseDTO getAccount(@PathVariable() String id)
    {
        return accountService.getAccount(id);
    }

    @PostMapping("/accounts")
    public AccountResponseDTO save(@RequestBody AccountRequestDTO accountSTO)
    {
        return accountService.AddAccount(accountSTO);
    }
    @PutMapping("/accounts/{id}")
    public AccountResponseDTO update(@RequestBody AccountRequestDTO accountRequestDTO, @PathVariable String id)
    {
        return accountService.update(accountRequestDTO, id);
    }

    @DeleteMapping("/accounts/{id}")
    public boolean delete(@PathVariable String id)
    {
        bar.deleteById(id);
        Account account = bar.findById(id).orElse(null);
        return account == null;
    }

}
