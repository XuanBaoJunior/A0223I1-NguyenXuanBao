package ss20_case_study.service;

import ss20_case_study.model.Customer;

public interface ICustomerService extends Service{
    void getLoyaltyPoints(Customer customer);
    void redeemLoyaltyPoints(Customer customer, int points);
}
