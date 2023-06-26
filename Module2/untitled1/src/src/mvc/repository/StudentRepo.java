package src.mvc.repository;



import src.mvc.model.Student;
import src.mvc.utils.ReadFile;
import src.mvc.utils.WriteFile;

import java.util.List;

public class StudentRepo implements IStudentRepo {

    @Override
    public List<Student> showList() {
        return ReadFile.read();
    }

    @Override
    public void add(Student student) {
        WriteFile.write(student);
    }
}
