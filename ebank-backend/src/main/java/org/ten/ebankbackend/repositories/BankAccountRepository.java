package org.ten.ebankbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ten.ebankbackend.entities.BankAccount;
import org.ten.ebankbackend.entities.Customer;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
}
