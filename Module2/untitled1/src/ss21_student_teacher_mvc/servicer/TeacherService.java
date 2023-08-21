package ss21_student_teacher_mvc.servicer;

import ss21_student_teacher_mvc.model.Teacher;

public interface TeacherService {
    Teacher[] findAll();
    void addTeacher(Teacher teacher);
    void updateTeacher(Teacher teacher);
    void deleteTeacher(Teacher teacher);
}
