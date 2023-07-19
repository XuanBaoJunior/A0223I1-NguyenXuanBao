package ss20_case_study.service;

import ss20_case_study.model.Employee;

public interface IEmployeeService extends Service{
    void assignTask(Employee employee, String task);
    void calculateSalary(Employee employee);
}
