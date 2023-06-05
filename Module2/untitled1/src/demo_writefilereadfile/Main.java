package demo_writefilereadfile;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {
        String txt = "NguyenXuanBao";
        String arr[] = {"32"};
        try {
            FileWriter ten = new FileWriter("data.txt");
            BufferedWriter doc = new BufferedWriter(ten);
            for (String s : arr){
                doc.write(s);
                doc.newLine();
            }
            ten.close();
            doc.close();
        }catch (Exception e){

        }
    }
}
