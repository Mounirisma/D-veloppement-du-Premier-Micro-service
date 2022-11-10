package Org.said.bankaccountservice.repositories;

import Org.said.bankaccountservice.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
