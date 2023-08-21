package ss21_student_teacher_mvc.controller;

import ss21_student_teacher_mvc.model.Teacher;
import ss21_student_teacher_mvc.servicer.TeacherService;
import ss21_student_teacher_mvc.servicer.TeacherServiceImpl;

import java.util.Scanner;

public class TeacherController {
    private static TeacherService service = new TeacherServiceImpl();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int select = 0;
        do {
            System.out.println("---------Teacher Manage-----------");
            System.out.println("1. List");
            System.out.println("2. Add new teacher");
            System.out.println("3. Update teacher");
            System.out.println("4. Delete teacher");
            System.out.println("5. Exit");
            System.out.println("Please inpur number: ");
            select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case 1:
                    Teacher[] teachers = service.findAll();
                    for (Teacher teacher : teachers) {
                        System.out.println(teacher);
                    }
                    break;
                case 2:
                    System.out.println("Enter teacher ID:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter teacher name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter teacher age:");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter teacher address:");
                    String address = scanner.nextLine();
                    System.out.println("Enter teacher salary:");
                    double salary = scanner.nextDouble();

                    try {
                        Teacher newTeacher = new Teacher(id, name, age, address, salary);
                        service.addTeacher(newTeacher);
                        System.out.println("Teacher added successfully.");
                    } catch (Exception e) {
                        System.out.println("An error occurred while adding the teacher: " + e.getMessage());
                        e.printStackTrace();
                    }

                case 3:
                    System.out.println("Enter the ID of the teacher to update:");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    Teacher[] allTeachers = service.findAll();
                    for (Teacher teacher : allTeachers) {
                        if (teacher != null && teacher.getId() == updateId) {
                            System.out.println("Enter updated teacher name:");
                            String updatedName = scanner.nextLine();
                            System.out.println("Enter updated teacher age:");
                            int updatedAge = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Enter updated teacher address:");
                            String updatedAddress = scanner.nextLine();
                            System.out.println("Enter updated teacher salary:");
                            double updatedSalary = scanner.nextDouble();

                            Teacher updatedTeacher = new Teacher(updateId, updatedName, updatedAge, updatedAddress, updatedSalary);
                            service.updateTeacher(updatedTeacher);
                            System.out.println("Teacher updated successfully.");
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("Enter the ID of the teacher to delete:");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();


//                    Teacher[] teacher = service.findAll();
//                    for (Teacher teacher: teachers) {
//                        if (teacher != null && teacher.getId() == deleteId) {
//                            service.deleteTeacher(teacher);
//                            System.out.println("Teacher deleted successfully.");
//                            break;
//                        }
//                    }
                    break;
                case 5:
                    System.exit(0);
            }
        } while (true);
    }
}
