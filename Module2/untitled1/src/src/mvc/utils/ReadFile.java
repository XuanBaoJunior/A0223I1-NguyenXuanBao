package src.mvc.utils;


import src.mvc.model.Student;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    private static final String PATH = "src/src/mvc/data/student.csv";
    public static List<Student> read(){
        List<Student> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String temp;

            while ((temp = bufferedReader.readLine()) !=null){
                String[] arr = temp.split(",");
                Student student = new Student();
                student.setId(Integer.parseInt(arr[0]));
                student.setName(arr[1]);
                student.setClassName(arr[2]);
                list.add(student);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
