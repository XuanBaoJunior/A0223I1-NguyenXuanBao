package ss10_mvc.codegym.com.view;

import ss10_mvc.codegym.com.controller.StudentController;
import ss10_mvc.codegym.com.model.Student;
import ss10_mvc.codegym.com.repository.IStudentRepository;
import ss10_mvc.codegym.com.repository.StudentRepository;
import ss10_mvc.codegym.com.service.StudentService;

import java.util.Scanner;

public class Main {
    private static final int OPTION_DISPLAY_ALL = 1;
    private static final int OPTION_ADD = 2;
    private static final int OPTION_UPDATE = 3;
    private static final int OPTION_DELETE = 4;
    private static final int OPTION_EXIT = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Student student1 = new Student(0, "Nguyễn Văn A", 20);
        Student student2 = new Student(0, "Nguyễn Văn B", 22);
        Student student3 = new Student(0, "Nguyễn Văn C", 21);

        IStudentRepository studentRepository = new StudentRepository();
        studentRepository.addStudent(student1);
        studentRepository.addStudent(student2);
        studentRepository.addStudent(student3);

        StudentService studentService = new StudentService(studentRepository);
        StudentController studentController = new StudentController(studentService);

        int option = 0;
        while (option != OPTION_EXIT) {
            displayMenu();
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case OPTION_DISPLAY_ALL:
                    studentController.displayAllStudents();
                    break;
                case OPTION_ADD:
                    System.out.print("Nhập tên sinh viên: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập tuổi sinh viên: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    studentController.addStudent(name, age);
                    break;
                case OPTION_UPDATE:
                    System.out.print("Nhập ID sinh viên: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nhập tên sinh viên: ");
                    name = scanner.nextLine();
                    System.out.print("Nhập tuổi sinh viên: ");
                    age = scanner.nextInt();
                    scanner.nextLine();
                    studentController.updateStudent(id, name, age);
                    break;
                case OPTION_DELETE:
                    System.out.print("Nhập ID sinh viên cần xóa: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    studentController.deleteStudent(id);
                    break;
                case OPTION_EXIT:
                    System.out.println("Thoát khỏi chương trình...");
                    break;
                default:
                    System.out.println("Tùy chọn không hợp lệ. Vui lòng thử lại.");
                    break;
            }
            System.out.println();
        }

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("Hệ thống quản lý sinh viên");
        System.out.println("-------------------------");
        System.out.println("1. Hiển thị tất cả sinh viên");
        System.out.println("2. Thêm mới một sinh viên");
        System.out.println("3. Cập nhật một sinh viên theo ID");
        System.out.println("4. Xóa một sinh viên theo ID");
        System.out.println("5. Thoát");
        System.out.print("Nhập một tùy chọn của bạn: ");
    }
}
