package org.ten.ebankbackend.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.ten.ebankbackend.dtos.AccountOperationDTO;
import org.ten.ebankbackend.dtos.CurrentBankAccountDTO;
import org.ten.ebankbackend.dtos.CustomerDTO;
import org.ten.ebankbackend.dtos.SavingBankAccountDTO;
import org.ten.ebankbackend.entities.AccountOperation;
import org.ten.ebankbackend.entities.CurrentAccount;
import org.ten.ebankbackend.entities.Customer;
import org.ten.ebankbackend.entities.SavingAccount;


@Service
public class BankAccountMapperImpl {
    public CustomerDTO fromCustomer(Customer customer){
        CustomerDTO customerDTO=new CustomerDTO();
        BeanUtils.copyProperties(customer,customerDTO);



        return customerDTO;
    };
    public Customer fromCustomerDTO(CustomerDTO customerDTO){
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO, customer);
        return customer;
    };

    public SavingBankAccountDTO fromSavingBankAccount(SavingAccount savingAccount){
SavingBankAccountDTO savingBankAccountDTO= new SavingBankAccountDTO();
BeanUtils.copyProperties(savingAccount, savingBankAccountDTO);
savingBankAccountDTO.setCustomerDTO(fromCustomer(savingAccount.getCustomer()));
 savingBankAccountDTO.setType(savingAccount.getClass().getSimpleName());
return savingBankAccountDTO;
    }


    public SavingAccount fromSavingBankAccountDTO(SavingBankAccountDTO savingBankAccountDTO){
        SavingAccount savingAccount=new SavingAccount();
        BeanUtils.copyProperties(savingBankAccountDTO, savingAccount);
        savingAccount.setCustomer(fromCustomerDTO(savingBankAccountDTO.getCustomerDTO()));
        return savingAccount;
    }


    public CurrentBankAccountDTO fromCurrentBankAccount(CurrentAccount currentAccount){
CurrentBankAccountDTO currentBankAccountDTO=new CurrentBankAccountDTO();
BeanUtils.copyProperties(currentAccount, currentBankAccountDTO);
currentBankAccountDTO.setCustomerDTO(fromCustomer(currentAccount.getCustomer()));
        currentBankAccountDTO.setType(currentAccount.getClass().getSimpleName());
return currentBankAccountDTO;
    }
    public CurrentAccount fromCurrentBankAccountDTO(CurrentBankAccountDTO currentBankAccountDTO){
CurrentAccount currentAccount=new CurrentAccount();
BeanUtils.copyProperties(currentBankAccountDTO, currentAccount);
currentAccount.setCustomer(fromCustomerDTO(currentBankAccountDTO.getCustomerDTO()));
return currentAccount;
    }

    public AccountOperationDTO fromAccountOperation(AccountOperation accountOperation){
        AccountOperationDTO accountOperationDTO = new AccountOperationDTO();
        BeanUtils.copyProperties(accountOperation, accountOperationDTO);
        return accountOperationDTO;
    }

}

