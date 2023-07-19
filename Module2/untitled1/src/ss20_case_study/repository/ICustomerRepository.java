package ss20_case_study.repository;

import ss20_case_study.model.Customer;

import java.util.List;

public interface ICustomerRepository extends Repository {
    Customer getCustomerById(String id);
    List<Customer> getAllCustomers();
}
