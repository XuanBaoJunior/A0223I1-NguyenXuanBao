package src.mvc.service;


import src.mvc.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> showList();
    void add(Student student);

}
