package demo_baithi.repository;

import demo_baithi.model.Student;
import demo_baithi.model.Teacher;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TeacherRepository {
    private static final String fileXuongDong = "\n";
    private static final String fileKhoangCach = ",";
    private static final String fileHeaderTeacher = "ID, NAME, AGE, " +
            "SALARY, EXPERIENCE";
    private static final String fileNameTeacher = "E:\\CodeGym\\A0223I1-NguyenXuanBao\\Module2\\untitled1\\src\\demo_baithi\\data\\teacher.csv";
    public void writeTeacherFileCSV(List<Teacher> list) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileNameTeacher);
            fileWriter.append(fileHeaderTeacher);
            fileWriter.append(fileXuongDong);
            for (Teacher tc : list) {
                fileWriter.append(String.valueOf(tc.getId()));
                fileWriter.append(fileKhoangCach);
                fileWriter.append(tc.getName());
                fileWriter.append(fileKhoangCach);
                fileWriter.append(String.valueOf(tc.getAge()));
                fileWriter.append(fileKhoangCach);
                fileWriter.append(String.valueOf(tc.getSalary()));
                fileWriter.append(fileKhoangCach);
                fileWriter.append(tc.getExperience());
                fileWriter.append(fileXuongDong);
            }
            fileWriter.close();
        }catch (IOException ex){
            System.out.println("Error in CSV!!!");
        }
    }
    public List<Teacher> readTeacherToFile(){
        BufferedReader bufferedReader = null;
        List<Teacher> teacherList = new ArrayList<>();
        Path path = Paths.get(fileNameTeacher);
        if(!Files.exists(path)){
            try {
                Writer writer = new FileWriter(fileNameTeacher);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        try{
            String line;
            bufferedReader = new BufferedReader(new FileReader(fileNameTeacher));
            while ((line = bufferedReader.readLine()) != null){
                String[] splitData = line.split(",");
                try {
                    if (splitData.length >= 5 && !splitData[0].equals("ID")) {
                        int id = Integer.parseInt(splitData[0]);
                        String name = splitData[1];
                        int age = Integer.parseInt(splitData[2]);
                        double salary = Double.parseDouble(splitData[3]);
                        String experience = splitData[4];
                        Teacher teacher = new Teacher(id, name, age, salary, experience);
                        teacherList.add(teacher);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Lỗi dữ liệu từ CSV: " + e.getMessage());
                }
            }
            bufferedReader.close();

        }catch (Exception e){
            System.out.println("Error in CSV!!!");
            e.printStackTrace();

        }
        return teacherList;
    }
}