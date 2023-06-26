package demo_writefilereadfile;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
            String a[] = new String[5];
            a[0] = "Macbook";
            a[1] = "Dell";
            a[2] = "Acer";
            a[3] = "Lenovo";
            a[4] = "Asus";

            File file = new File("data.txt");
            OutputStream outputStream = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            for (String item : a){
                    outputStreamWriter.write(item);
                    outputStreamWriter.flush();
            }


//        File file = new File("data.txt");
//        InputStream inputStream = new FileInputStream(file);
//        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//        BufferedReader reader = new BufferedReader(inputStreamReader);
//
//        String line = "";
//        while ((line = reader.readLine()) != null){
//            System.out.println(line);
//        }

    }
}
