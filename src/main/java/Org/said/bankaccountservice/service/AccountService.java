package Org.said.bankaccountservice.service;

import Org.said.bankaccountservice.dtos.AccountRequestDTO;
import Org.said.bankaccountservice.dtos.AccountResponseDTO;

import java.util.List;


public interface AccountService {
    public AccountResponseDTO AddAccount(AccountRequestDTO accountDTO);
    public List<AccountResponseDTO> getAccounts();
    public AccountResponseDTO getAccount(String id);
    public AccountResponseDTO update(AccountRequestDTO accountRequestDTO, String id);

    boolean deleteAccount(String id);
}
