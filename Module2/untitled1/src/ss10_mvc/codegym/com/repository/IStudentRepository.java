package ss10_mvc.codegym.com.repository;

import ss10_mvc.codegym.com.model.Student;

public interface IStudentRepository {
    Student[] getAllStudents();
    Student getStudentById(int id);
    void addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(int id);
}
