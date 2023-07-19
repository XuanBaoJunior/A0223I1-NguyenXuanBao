package ss20_case_study.repository;

import ss20_case_study.model.Employee;

import java.util.List;

public interface IEmployeeRepository extends Repository {
    Employee getEmployeeById(String id);
    List<Employee> getAllEmployees();
}
