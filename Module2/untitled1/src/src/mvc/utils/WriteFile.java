package src.mvc.utils;


import src.mvc.model.Student;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
    private static final String PATH = "src/src/mvc/data/student.csv";
    public static void write(Student student){
        try {
            FileWriter fileWriter = new FileWriter(PATH,true);
            BufferedWriter bufferedWriter =
                    new BufferedWriter(fileWriter);
            bufferedWriter.write(student.writeToFile());
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
