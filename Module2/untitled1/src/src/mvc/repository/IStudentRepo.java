package src.mvc.repository;


import src.mvc.model.Student;

import java.util.List;

public interface IStudentRepo {
    List<Student> showList();
    void add(Student student);
}
