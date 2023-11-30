package org.ten.ebankbackend.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.ten.ebankbackend.entities.AccountOperation;


import java.util.List;

public interface AccountOperationRepository extends JpaRepository<AccountOperation,Long> {
   List<AccountOperation> findByBankAccountId(String accountId);
   Page<AccountOperation> findByBankAccountIdOrderByOperationDateDesc(String accountId, Pageable pageable);
}

