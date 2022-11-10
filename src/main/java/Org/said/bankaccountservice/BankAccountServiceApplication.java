package Org.said.bankaccountservice;

import Org.said.bankaccountservice.Entities.Account;
import Org.said.bankaccountservice.Entities.Customer;
import Org.said.bankaccountservice.enums.AccountType;
import Org.said.bankaccountservice.repositories.BankAccountrepository;
import Org.said.bankaccountservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class BankAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAccountServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(BankAccountrepository br, CustomerRepository cr)
	{
		return args -> {
			Stream.of("ismail", "simo", "yassine")
					.forEach(c -> {
						Customer customer = new Customer();
						customer.setName(c);
						cr.save(customer);
					});
			cr.findAll().forEach(c -> {
				for (int i = 0; i < 10; i++)
				{
					Account account = Account.builder().id(UUID.randomUUID().toString())
							.balance(Math.random() * 1600)
							.created(new Date())
							.currency("Mad")
							.type(Math.random() > 0.5? AccountType.CURRENT_ACCOUNT: AccountType.SAVING_ACCOUNT)
							.customer(c)
							.build();
					br.save(account);
				}
			});


		};
	}
}
