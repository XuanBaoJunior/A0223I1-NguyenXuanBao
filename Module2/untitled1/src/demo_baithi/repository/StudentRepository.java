package demo_baithi.repository;


import demo_baithi.model.Person;
import demo_baithi.model.Student;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private static final String fileXuongDong = "\n";
    private static final String fileKhoangCach = ",";
    private static final String fileHeaderStudent = "ID, NAME, AGE, " +
            "POINT, CLASSS, ACADEMIC";
    private static final String fileNameStudent = "E:\\CodeGym\\A0223I1-NguyenXuanBao\\Module2\\untitled1\\src\\demo_baithi\\data\\student.csv";

    public List<Person> list=new ArrayList<>();
    public void writeStudentCSV(List<Student> list) {

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileNameStudent);
            fileWriter.append(fileHeaderStudent);
            fileWriter.append(fileXuongDong);
            for (Student std: list){
                fileWriter.append(String.valueOf(std.getId()));
                fileWriter.append(fileKhoangCach);
                fileWriter.append(std.getName());
                fileWriter.append(fileKhoangCach);
                fileWriter.append(String.valueOf(std.getAge()));
                fileWriter.append(fileKhoangCach);
                fileWriter.append(String.valueOf(std.getPoint()));
                fileWriter.append(fileKhoangCach);
                fileWriter.append(std.getClasss());
                fileWriter.append(fileKhoangCach);
                fileWriter.append(std.getAcademic());
                fileWriter.append(fileXuongDong);
            }
            fileWriter.close();
        }catch (IOException ex){
            System.out.println("Error in CSV!!!");
        }
    }
    public List<Student> readStudentToFile(){
        BufferedReader bufferedReader = null;
        List<Student> studentList = new ArrayList<>();
        Path path = Paths.get(fileNameStudent);
        if(!Files.exists(path)){
            try {
                Writer writer = new FileWriter(fileNameStudent);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        try{
            String line;
            bufferedReader = new BufferedReader(new FileReader(fileNameStudent));
            while ((line = bufferedReader.readLine()) != null){
                String[] splitData = line.split(",");
                try {
                    if (splitData.length >= 6) {
                        String stId = splitData[0];
                        if (!stId.equals("ID")){
                            int id = Integer.parseInt(splitData[0]);
                            String name = splitData[1];
                            int age = Integer.parseInt(splitData[2]);
                            double point = Double.parseDouble(splitData[3]);
                            String classs = splitData[4];
                            String academic = splitData[5];
                            Student student = new Student(id, name, age, point, classs, academic);
                            studentList.add(student);
                        }
                    } else {
                        System.out.println("Lỗi dữ liệu: " + line);
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
        return studentList;
    }
}
