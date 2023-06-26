package binary_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Demo {
    private static final String PATH = "src/binary_file/binary";
    public static void main(String[] args) {
        Student student = new Student(1,"Nguyễn Văn A");
        Student student1 = new Student(1,"Nguyễn Văn B");
        Student student2 = new Student(1,"Nguyễn Văn B");
        List<Student> list = new ArrayList<>();
        list.add(student);
        list.add(student1);
        try {
            FileOutputStream fileOutputStream =
                    new FileOutputStream(PATH);
            ObjectOutputStream objectOutputStream =
                    new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(list);
//            objectOutputStream.writeObject(student2);
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            List<Student> students;
            FileInputStream fileInputStream =
                    new FileInputStream(PATH);
            ObjectInputStream objectInputStream =
                    new ObjectInputStream(fileInputStream);
            students = (List<Student>) objectInputStream.readObject();
            System.out.println(students);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
