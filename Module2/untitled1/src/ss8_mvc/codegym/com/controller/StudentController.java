package ss8_mvc.codegym.com.controller;

import ss8_mvc.codegym.com.model.Student;
import ss8_mvc.codegym.com.service.StudentService;

public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    public void displayAllStudents() {
        Student[] students = studentService.getAllStudents();
        if (students.length > 0) {
            System.out.println("Danh sách sinh viên:");
            for (Student student : students) {
                if (student != null) {
                    System.out.println("ID: " + student.getId() + ", Name: " + student.getName() + ", Age: " + student.getAge());
                }
            }
        } else {
            System.out.println("Không tìm thấy sinh viên nào.");
        }
    }

    public void addStudent(String name, int age) {
        Student student = new Student(0, name, age);
        studentService.addStudent(student);
        System.out.println("Đã thêm sinh viên thành công.");
    }

    public void updateStudent(int id, String name, int age) {
        Student student = studentService.getStudentById(id);
        if (student != null) {
            student.setName(name);
            student.setAge(age);
            studentService.updateStudent(student);
            System.out.println("Sinh viên được cập nhật thành công.");
        } else {
            System.out.println("Không tìm thấy sinh viên.");
        }
    }

    public void deleteStudent(int id) {
        Student student = studentService.getStudentById(id);
        studentService.deleteStudent(id);
        if (student != null){
            System.out.println("Sinh viên đã xóa thành công.");
        }else {
            System.out.println("Không tìm thấy id sinh viên muốn xóa.");
        }
    }
}
