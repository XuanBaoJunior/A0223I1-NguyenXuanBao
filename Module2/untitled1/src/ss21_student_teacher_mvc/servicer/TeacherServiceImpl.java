package ss21_student_teacher_mvc.servicer;

import ss21_student_teacher_mvc.model.Teacher;
import ss21_student_teacher_mvc.repository.TeacherRepository;
import ss21_student_teacher_mvc.repository.TeacherRepositoryImpl;

public class TeacherServiceImpl implements TeacherService{
    public TeacherRepository repository = new TeacherRepositoryImpl();
    @Override
    public Teacher[] findAll() {
        return repository.findAll();
    }

    @Override
    public void addTeacher(Teacher teacher) {
        repository.addTeacher(teacher);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        repository.updateTeacher(teacher);
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        repository.deleteTeacher(teacher);
    }
}
