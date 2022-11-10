package Org.said.bankaccountservice.web;

import Org.said.bankaccountservice.Entities.Account;
import Org.said.bankaccountservice.dtos.AccountRequestDTO;
import Org.said.bankaccountservice.dtos.AccountResponseDTO;
import Org.said.bankaccountservice.repositories.BankAccountrepository;
import Org.said.bankaccountservice.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@AllArgsConstructor
// 3rd part : 43 : 00
public class AccountGraphqlController {
    private BankAccountrepository bar;
    private AccountService as;


    @QueryMapping
    public List<Account> accountsList()
    {
        return bar.findAll();
    }

    @QueryMapping
    public Account accountsById(@Argument String id)
    {
        return bar.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Account \' %s \' not Found", id)));
    }
    @MutationMapping
    public AccountResponseDTO addAccount(@Argument AccountRequestDTO account)
    {
        return as.AddAccount(account);
    }

    @MutationMapping
    public AccountResponseDTO updateAccount(@Argument String id, @Argument AccountRequestDTO account)
    {
        return as.update(account, id);
    }

    @MutationMapping
    public boolean deleteAcoount( @Argument String id)
    {
        return as.deleteAccount(id);
    }
}
