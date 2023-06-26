package ss8_mvc.codegym.com.repository;

import ss8_mvc.codegym.com.model.Student;

public class StudentRepository implements IStudentRepository {
    private Student[] students;
    private int nextId;

    public StudentRepository() {
        students = new Student[100];
        nextId = 1;
    }

    @Override
    public Student[] getAllStudents() {
        return students;
    }

    @Override
    public Student getStudentById(int id) {
        for (Student student : students) {
            if (student != null && student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    @Override
    public void addStudent(Student student) {
        student.setId(nextId++);
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                break;
            }
        }
    }

    @Override
    public void updateStudent(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].getId() == student.getId()) {
                students[i] = student;
                break;
            }
        }
    }

    @Override
    public void deleteStudent(int id) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].getId() == id) {
                students[i] = null;
                break;
            }
        }
    }
}