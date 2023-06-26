package ss8_mvc.codegym.com.service;

import ss8_mvc.codegym.com.model.Student;
import ss8_mvc.codegym.com.repository.IStudentRepository;

public class StudentService {
    private IStudentRepository studentRepository;

    public StudentService(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student[] getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public Student getStudentById(int id) {
        return studentRepository.getStudentById(id);
    }

    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }

    public void updateStudent(Student student) {
        studentRepository.updateStudent(student);
    }

    public void deleteStudent(int id) {
        studentRepository.deleteStudent(id);
    }
}
