package org.ten.ebankbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.ten.ebankbackend.entities.Customer;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
  /*@Query("select c from Customer c where c.name like :kw")
    List<Customer> searchCustomer(@Param(value = "kw") String keyword);*/

  @Query("select c from Customer c where c.name like :kw")
  List<Customer> searchCustomer(@Param("kw") String keyword);

}
