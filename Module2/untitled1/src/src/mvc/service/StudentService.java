package src.mvc.service;


import src.mvc.model.Student;
import src.mvc.repository.IStudentRepo;
import src.mvc.repository.StudentRepo;

import java.util.List;

public class StudentService implements IStudentService{
    IStudentRepo iStudentRepo = new StudentRepo();
    @Override
    public List<Student> showList() {
        return iStudentRepo.showList();
    }

    @Override
    public void add(Student student) {
        iStudentRepo.add(student);
    }
}
