package ss21_student_teacher_mvc.repository;

import ss21_student_teacher_mvc.model.Teacher;

public class TeacherRepositoryImpl implements TeacherRepository{
    private static Teacher[] teacherList;
    private static int size = 0;
    static {
        teacherList = new Teacher[10];
        teacherList[0] = new Teacher(1,"Nguyen Van A", 20, "Da Nang", 18000);
        teacherList[1] = new Teacher(2,"Nguyen Van B", 21, "Da Nang", 1200);
        teacherList[2] = new Teacher(3,"Nguyen Van C", 22, "Da Nang", 25200);
        size = 3;
    }

    @Override
    public Teacher[] findAll() {
        return teacherList;
    }

    @Override
    public void addTeacher(Teacher teacher) {
        if (size < teacherList.length) {
            teacherList[size] = teacher;
            size++;
        } else {
            int newSize = teacherList.length * 2;
            Teacher[] newTeacherList = new Teacher[newSize];
            for (int i = 0; i < size; i++) {
                newTeacherList[i] = teacherList[i];
            }
            newTeacherList[size] = teacher;
            size++;
            teacherList = newTeacherList;
        }
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        for (int i = 0; i < size; i++) {
            if (teacherList[i].getId() == teacher.getId()) {
                teacherList[i] = teacher;
            }
        }
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        for (int i = 0; i < size; i++) {
            if (teacherList[i].getId() == teacher.getId()) {
                for (int j = i; j < size - 1; j++) {
                    teacherList[j] = teacherList[j + 1];
                }
                teacherList[size - 1] = null;
                size--;
            }
        }
    }
}