package ss16_readfile_writefile.commons;

import ss16_readfile_writefile.models.Student;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FuncFileCSV {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String fileNameStudent = "src/ss16_readfile_writefile/data/Student.csv";
    private static final String FILE_HEADER = "name,grade,address";
    public static void writeStudentToFileCSV(ArrayList<Student> listStudent){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileNameStudent);
            fileWriter.append(FILE_HEADER);
            fileWriter.append(NEW_LINE_SEPARATOR);
            for (Student student :listStudent){
                fileWriter.append(student.getName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(student.getGrade());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(student.getAddress());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
        }catch (Exception e){
            System.out.println("Error in Csv file writer !!!");
        }finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            }catch (Exception ex){
                System.out.println("Error when flush or close");
            }
        }
    }
    public static ArrayList<Student> getFileCSVToListStudent(){
        BufferedReader bufferedReader = null;
        ArrayList<Student> listStudent = new ArrayList<>();
        Path path = Paths.get(fileNameStudent);
        if (!Files.exists(path)){
            try{
                Writer writer = new FileWriter(fileNameStudent);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        try {
            String line;
            bufferedReader = new BufferedReader(new FileReader(fileNameStudent));
            while ((line = bufferedReader.readLine())!= null){
                String[] splitData = line.split(",");
                if (splitData[0].equals("name")){
                    continue;
                }
                Student student = new Student();
                student.setName(splitData[0]);
                student.setGrade(splitData[1]);
                student.setAddress(splitData[2]);
                listStudent.add(student);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            try {
                bufferedReader.close();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        return listStudent;
    }
}
