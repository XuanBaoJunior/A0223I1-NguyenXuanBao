package ss21_student_teacher_mvc.repository;

import ss21_student_teacher_mvc.model.Teacher;

public interface TeacherRepository {
    Teacher[] findAll();
    void addTeacher(Teacher teacher);
    void updateTeacher(Teacher teacher);
    void deleteTeacher(Teacher teacher);
}
