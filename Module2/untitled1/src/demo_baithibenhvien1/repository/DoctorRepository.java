package demo_baithibenhvien1.repository;

import demo_baithibenhvien1.model.Doctor;
import demo_baithibenhvien1.model.Person;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DoctorRepository {
    private static final String fileXuongDong = "\n";
    private static final String fileKhoangCach = ",";
    private static final String fileHeaderDoctor = "ID, NAME, GIOI TINH, " +
            "SDT, KHOA BENH, SALARY";
    private static final String fileNameDoctor = "src/demo_baithibenhvien1/data/doctor.csv";

    public List<Person> list = new ArrayList<>();

    public void writeDoctorCSV(List<Doctor> list) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileNameDoctor);
            fileWriter.append(fileHeaderDoctor);
            fileWriter.append(fileXuongDong);
            for (Doctor dt : list) {
                fileWriter.append(String.valueOf(dt.getId()));
                fileWriter.append(fileKhoangCach);
                fileWriter.append(dt.getName());
                fileWriter.append(fileKhoangCach);
                fileWriter.append(dt.getGioiTinh());
                fileWriter.append(fileKhoangCach);
                fileWriter.append(String.valueOf(dt.getSdt()));
                fileWriter.append(fileKhoangCach);
                fileWriter.append(dt.getKhoaBenh());
                fileWriter.append(fileKhoangCach);
                fileWriter.append(String.valueOf(dt.getSalary()));
                fileWriter.append(fileXuongDong);
            }
            fileWriter.close();
        } catch (IOException ex) {
            System.out.println("Error in CSV!!!");
        }
    }

    public List<Doctor> readDoctorToFile() {
        BufferedReader bufferedReader = null;
        List<Doctor> doctorList = new ArrayList<>();
        Path path = Paths.get(fileNameDoctor);
        if(!Files.exists(path)){
            try {
                Writer writer = new FileWriter(fileNameDoctor);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        try{
            String line;
            bufferedReader = new BufferedReader(new FileReader(fileNameDoctor));
            while ((line = bufferedReader.readLine()) != null){
                String[] splitData = line.split(",");
                try {
                    if (splitData.length >= 7) {
                        String stId = splitData[0];
                        if (!stId.equals("ID")){
                            int id = Integer.parseInt(splitData[0]);
                            String name = splitData[1];
                            String gioiTinh = (splitData[2]);
                            String sdt = (splitData[3]);
                            String chucVu = splitData[4];
                            String khoaBenh = splitData[5];
                            double salary =Double.parseDouble(splitData[6]);
                            Doctor doctor = new Doctor(id, name, gioiTinh, sdt, chucVu, khoaBenh, salary);
                            doctorList.add(doctor);
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
        return doctorList;
    }
}
