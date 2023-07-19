package case_study.service.Impl;

import case_study.model.Employee;
import case_study.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    static List<Employee> employeeList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void display() {
        for (Employee employee: employeeList){
            System.out.println(employee.toString());
        }
    }

    @Override
    public void addNew() {
        Employee employee = new Employee();
        System.out.println("Nhập id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên: ");
        employee.setName(scanner.nextLine());
        System.out.println("Nhập tuổi: ");
        int age = Integer.parseInt(scanner.nextLine());
//        System.out.println("Nhập giới tính: ");
//        String sex = scanner.nextLine();
//        System.out.println("Nhập CCCD: ");
//        String idCard = scanner.nextLine();
        System.out.println("Nhập địa chỉ: ");
        employee.setAddress(scanner.nextLine());
        System.out.println("Nhập chức vụ: ");
        employee.setLevel(scanner.nextLine());
        System.out.println("Nhập vị trí: ");
        employee.setPosition(scanner.nextLine());
        System.out.println("Nhập lương: ");
        employee.setSalary(scanner.nextInt());
        employeeList.add(employee);
    }

    @Override
    public void edit() {

    }

    @Override
    public void delete() {

    }
}
