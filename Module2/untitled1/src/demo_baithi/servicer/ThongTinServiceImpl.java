package demo_baithi.servicer;

import demo_baithi.controller.ThongTinController;
import demo_baithi.model.Student;
import demo_baithi.model.Teacher;
import demo_baithi.repository.StudentRepository;
import demo_baithi.repository.TeacherRepository;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ThongTinServiceImpl implements Service{
    StudentRepository studentRepository = new StudentRepository();
    TeacherRepository teacherRepository = new TeacherRepository();
    Scanner scanner = new Scanner(System.in);
    List<Student> studentList = studentRepository.readStudentToFile();
    List<Teacher> teacherList = teacherRepository.readTeacherToFile();
    ThongTinController thongTinController = new ThongTinController();
    int nextID = 1;

    private int generateNextStudentID() {
        int maxID = 0;
        for (Student student : studentList) {
            if (student.getId() > maxID) {
                maxID = student.getId();
            }
        }
        return maxID + 1;
    }

    private int generateNextTeacherID() {
        int maxID = 0;
        for (Teacher teacher : teacherList) {
            if (teacher.getId() > maxID) {
                maxID = teacher.getId();
            }
        }
        return maxID + 1;
    }
    @Override
    public void display() {
        studentList = studentRepository.readStudentToFile();
        teacherList = teacherRepository.readTeacherToFile();
        System.out.println("Danh sach hoc sinh");
        for (Student stdList: studentList){
            System.out.println(stdList.toString());
        }
        System.out.println("Danh sach giao vien");
        for (Teacher teaList : teacherList){
            System.out.println(teaList.toString());
        }
    }

    @Override
    public void add() {
        boolean check = false;
        while (!check){
            try {
                System.out.println("Danh sach thanh phan \n" +
                        "1. Danh sach sinh vien \n" +
                        "2. Danh sach giao vien \n" +
                        "3. Back to menu "
                );
                System.out.println("Chọn chức năng ");
                int choose = Integer.parseInt(scanner.nextLine());
                switch (choose){
                    case 1:
                        addDSSinhVien();
                        break;
                    case 2:
                        addDSGiaoVien();
                        break;
                    case 3:
                        thongTinController.displayThongTinMenu();
                        break;
                }

            }catch (InputMismatchException ex){
                System.out.println("Mời bạn nhập lại chức năng");
                scanner.nextLine();

            }catch (NumberFormatException ex){
                System.out.println("Mời bạn nhập lại chức năng");
                scanner.nextLine();
            }
        }
    }

    private void addDSGiaoVien() {
        Teacher teacher = new Teacher();
        teacher.setId(generateNextTeacherID());

        System.out.println("Nhập tên giáo viên:");
        String teacherName = scanner.nextLine();
        while (!isValidName(teacherName)) {
            System.out.println("Tên không hợp lệ. Vui lòng nhập lại tên giáo viên:");
            teacherName = scanner.nextLine();
        }
        teacher.setName(teacherName);

        System.out.println("Nhập tuổi giáo viên:");
        int teacherAge = getValidAge();
        teacher.setAge(teacherAge);

        System.out.println("Nhập lương giáo viên:");
        double teacherSalary = getValidSalary();
        teacher.setSalary(teacherSalary);

        System.out.println("Nhập chức vụ giáo viên:");
        String teacherExperience = scanner.nextLine();
        teacher.setExperience(teacherExperience);

        teacherList.add(teacher);
        teacherRepository.writeTeacherFileCSV(teacherList);
        System.out.println("Giáo viên đã được thêm mới");
    }

    private boolean isValidName(String name) {
        return name.matches("[A-Za-z\\s]+");
    }

    private int getValidAge() {
        int age;
        while (true) {
            try {
                age = Integer.parseInt(scanner.nextLine());
                if (age < 1 || age > 100) {
                    System.out.println("Tuổi phải nằm trong khoảng từ 1 đến 100. Vui lòng nhập lại:");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Tuổi không hợp lệ. Vui lòng nhập lại:");
            }
        }
        return age;
    }

    private double getValidSalary() {
        double salary;
        while (true) {
            try {
                salary = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Lương không hợp lệ. Vui lòng nhập lại:");
            }
        }
        return salary;
    }

    private void addDSSinhVien() {
        Student student = new Student();
        student.setId(generateNextStudentID());

        System.out.println("Nhập tên sinh viên:");
        String studentName = scanner.nextLine();
        while (!isValidName(studentName)) {
            System.out.println("Tên không hợp lệ. Vui lòng nhập lại tên sinh viên:");
            studentName = scanner.nextLine();
        }
        student.setName(studentName);

        System.out.println("Nhập tuổi sinh viên:");
        int studentAge = getValidAge();
        student.setAge(studentAge);

        System.out.println("Nhập điểm sinh viên:");
        double studentPoint = getValidPoint();
        student.setPoint(studentPoint);

        System.out.println("Nhập lớp sinh viên:");
        String studentClass = scanner.nextLine();
        student.setClasss(studentClass);

        System.out.println("Nhập học lực sinh viên:");
        String studentAcademic = scanner.nextLine();
        student.setAcademic(studentAcademic);

        studentList.add(student);
        studentRepository.writeStudentCSV(studentList);
        System.out.println("Sinh viên đã được thêm mới");
    }

    private double getValidPoint() {
        double point;
        while (true) {
            try {
                point = Double.parseDouble(scanner.nextLine());
                if (point < 1 || point > 10) {
                    System.out.println("Điểm phải nằm trong khoảng từ 1 đến 10. Vui lòng nhập lại:");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Điểm không hợp lệ. Vui lòng nhập lại:");
            }
        }
        return point;
    }

//    @Override
//    public void update() {
//        boolean check = false;
//        while (!check) {
//            try {
//                System.out.println("Danh sach thanh phan\n" +
//                        "1. Danh sach sinh vien\n" +
//                        "2. Danh sach giao vien\n" +
//                        "3. Back to menu"
//                );
//                System.out.println("Chọn chức năng");
//                int choose = Integer.parseInt(scanner.nextLine());
//                switch (choose) {
//                    case 1:
//                        updateDSSinhVien();
//                        break;
//                    case 2:
//                        updateDSGiaoVien();
//                        break;
//                    case 3:
//                        thongTinController.displayThongTinMenu();
//                        break;
//                }
//
//            } catch (InputMismatchException ex) {
//                System.out.println("Mời bạn nhập lại chức năng");
//                scanner.nextLine();
//            } catch (NumberFormatException ex) {
//                System.out.println("Mời bạn nhập lại chức năng");
//                scanner.nextLine();
//            }
//        }
//    }
//
//    private void updateDSSinhVien() {
//        System.out.println("Nhập ID của sinh viên bạn muốn cập nhật: ");
//        int idToUpdate = scanner.nextInt();
//        scanner.nextLine();
//
//        for (Student student : studentList) {
//            if (student.getId() == idToUpdate) {
//                System.out.println("Nhập thông tin cập nhật cho sinh viên có ID " + idToUpdate);
//
//                System.out.println("Nhập tên mới:");
//                student.setName(scanner.nextLine());
//
//                System.out.println("Nhập tuổi mới:");
//                student.setAge(scanner.nextInt());
//                scanner.nextLine();
//
//                System.out.println("Nhập điểm mới:");
//                student.setPoint(scanner.nextDouble());
//                scanner.nextLine();
//
//                System.out.println("Nhập lớp mới:");
//                student.setClasss(scanner.nextLine());
//
//                System.out.println("Nhập học lực mới:");
//                student.setAcademic(scanner.nextLine());
//
//                studentRepository.writeStudentCSV(studentList);
//                System.out.println("Thông tin sinh viên đã được cập nhật.");
//                return;
//            }
//        }
//
//        System.out.println("Không tìm thấy sinh viên có ID " + idToUpdate);
//    }
//
//    private void updateDSGiaoVien() {
//        System.out.println("Nhập ID của giáo viên bạn muốn cập nhật: ");
//        int idToUpdate = scanner.nextInt();
//        scanner.nextLine();
//
//        for (Teacher teacher : teacherList) {
//            if (teacher.getId() == idToUpdate) {
//                System.out.println("Nhập thông tin cập nhật cho giáo viên có ID " + idToUpdate);
//
//                System.out.println("Nhập tên mới:");
//                teacher.setName(scanner.nextLine());
//
//                System.out.println("Nhập tuổi mới:");
//                teacher.setAge(scanner.nextInt());
//                scanner.nextLine();
//
//                System.out.println("Nhập lương mới:");
//                teacher.setSalary(scanner.nextDouble());
//                scanner.nextLine();
//
//                System.out.println("Nhập chức vụ mới:");
//                teacher.setExperience(scanner.nextLine());
//
//                teacherRepository.writeTeacherFileCSV(teacherList);
//                System.out.println("Thông tin giáo viên đã được cập nhật.");
//                return;
//            }
//        }
//
//        System.out.println("Không tìm thấy giáo viên có ID " + idToUpdate);
//    }

    @Override
    public void update() {
        boolean check = false;
        while (!check) {
            try {
                System.out.println("Danh sach thanh phan\n" +
                        "1. Danh sach sinh vien\n" +
                        "2. Danh sach giao vien\n" +
                        "3. Back to menu"
                );
                System.out.println("Chọn chức năng");
                int choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        updateDSSinhVien();
                        break;
                    case 2:
                        updateDSGiaoVien();
                        break;
                    case 3:
                        thongTinController.displayThongTinMenu();
                        break;
                }

            } catch (InputMismatchException ex) {
                System.out.println("Mời bạn nhập lại chức năng");
                scanner.nextLine();
            } catch (NumberFormatException ex) {
                System.out.println("Mời bạn nhập lại chức năng");
                scanner.nextLine();
            }
        }
    }

    private void updateDSSinhVien() {
        System.out.println("Nhập ID của sinh viên bạn muốn cập nhật: ");
        int idToUpdate = scanner.nextInt();
        scanner.nextLine();

        for (Student student : studentList) {
            if (student.getId() == idToUpdate) {
                System.out.println("Nhập thông tin cập nhật cho sinh viên có ID " + idToUpdate);

                System.out.println("Nhập tên mới:");
                String studentName = scanner.nextLine();
                while (!isValidName(studentName)) {
                    System.out.println("Tên không hợp lệ. Vui lòng nhập lại tên sinh viên:");
                    studentName = scanner.nextLine();
                }
                student.setName(studentName);

                System.out.println("Nhập tuổi mới:");
                int studentAge = getValidAge();
                student.setAge(studentAge);

                System.out.println("Nhập điểm mới:");
                double studentPoint = getValidPoint();
                student.setPoint(studentPoint);

                System.out.println("Nhập lớp mới:");
                String studentClass = scanner.nextLine();
                student.setClasss(studentClass);

                System.out.println("Nhập học lực mới:");
                String studentAcademic = scanner.nextLine();
                student.setAcademic(studentAcademic);

                studentRepository.writeStudentCSV(studentList);
                System.out.println("Thông tin sinh viên đã được cập nhật.");
                return;
            }
        }

        System.out.println("Không tìm thấy sinh viên có ID " + idToUpdate);
    }

    private void updateDSGiaoVien() {
        System.out.println("Nhập ID của giáo viên bạn muốn cập nhật: ");
        int idToUpdate = scanner.nextInt();
        scanner.nextLine();

        for (Teacher teacher : teacherList) {
            if (teacher.getId() == idToUpdate) {
                System.out.println("Nhập thông tin cập nhật cho giáo viên có ID " + idToUpdate);

                System.out.println("Nhập tên mới:");
                String teacherName = scanner.nextLine();
                while (!isValidName(teacherName)) {
                    System.out.println("Tên không hợp lệ. Vui lòng nhập lại tên giáo viên:");
                    teacherName = scanner.nextLine();
                }
                teacher.setName(teacherName);

                System.out.println("Nhập tuổi mới:");
                int teacherAge = getValidAge();
                teacher.setAge(teacherAge);

                System.out.println("Nhập lương mới:");
                double teacherSalary = getValidSalary();
                teacher.setSalary(teacherSalary);

                System.out.println("Nhập chức vụ mới:");
                String teacherExperience = scanner.nextLine();
                teacher.setExperience(teacherExperience);

                teacherRepository.writeTeacherFileCSV(teacherList);
                System.out.println("Thông tin giáo viên đã được cập nhật.");
                return;
            }
        }

        System.out.println("Không tìm thấy giáo viên có ID " + idToUpdate);
    }

    @Override
    public void remove() {
        boolean check = false;
        while (!check) {
            try {
                System.out.println("Danh sach thanh phan\n" +
                        "1. Danh sach sinh vien\n" +
                        "2. Danh sach giao vien\n" +
                        "3. Back to menu"
                );
                System.out.println("Chọn chức năng");
                int choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        removeDSSinhVien();
                        break;
                    case 2:
                        removeDSGiaoVien();
                        break;
                    case 3:
                        thongTinController.displayThongTinMenu();
                        break;
                }

            } catch (InputMismatchException ex) {
                System.out.println("Mời bạn nhập lại chức năng");
                scanner.nextLine();
            } catch (NumberFormatException ex) {
                System.out.println("Mời bạn nhập lại chức năng");
                scanner.nextLine();
            }
        }
    }

    private void removeDSSinhVien() {
        System.out.println("Nhập ID của sinh viên bạn muốn xóa: ");
        int idToDelete = scanner.nextInt();
        scanner.nextLine();

        for (Student student : studentList) {
            if (student.getId() == idToDelete) {
                studentList.remove(student);
                studentRepository.writeStudentCSV(studentList);
                System.out.println("Sinh viên đã được xóa");
                return;
            }
        }

        System.out.println("Không tìm thấy sinh viên có ID " + idToDelete);
    }

    private void removeDSGiaoVien() {
        System.out.println("Nhập ID của giáo viên bạn muốn xóa: ");
        int idToDelete = scanner.nextInt();
        scanner.nextLine();

        for (Teacher teacher : teacherList) {
            if (teacher.getId() == idToDelete) {
                teacherList.remove(teacher);
                teacherRepository.writeTeacherFileCSV(teacherList);
                System.out.println("Giáo viên đã được xóa");
                return;
            }
        }

        System.out.println("Không tìm thấy giáo viên có ID " + idToDelete);
    }

}
