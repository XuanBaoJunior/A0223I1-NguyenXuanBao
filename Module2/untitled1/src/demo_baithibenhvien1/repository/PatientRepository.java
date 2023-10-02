package demo_baithibenhvien1.repository;


import demo_baithibenhvien1.model.Patient;
import demo_baithibenhvien1.model.Person;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PatientRepository {
    private static final String fileXuongDong = "\n";
    private static final String fileKhoangCach = ",";
    private static final String fileHeaderPatient = "ID, NAME, GIOI TINH, " +
            "CCCD, BAO HIEM Y TE, BENH AN, NGAY NHAP VIEN, NGAY RA VIEN";
    private static final String fileNamePatient = "src/demo_baithibenhvien1/data/patient.csv";

    public List<Person> list=new ArrayList<>();
    public void writePatientCSV(List<Patient> list){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileNamePatient);
            fileWriter.append(fileHeaderPatient);
            fileWriter.append(fileXuongDong);
            for (Patient bn: list){
                fileWriter.append(String.valueOf(bn.getId()));
                fileWriter.append(fileKhoangCach);
                fileWriter.append(bn.getName());
                fileWriter.append(fileKhoangCach);
                fileWriter.append(bn.getGioiTinh());
                fileWriter.append(fileKhoangCach);
                fileWriter.append(String.valueOf(bn.getCccd()));
                fileWriter.append(fileKhoangCach);
                fileWriter.append(bn.getBaoHiemYTe());
                fileWriter.append(fileKhoangCach);
                fileWriter.append(bn.getBenhAn());
                fileWriter.append(fileKhoangCach);
                fileWriter.append(String.valueOf(bn.getNgayNhapVien()));
                fileWriter.append(fileKhoangCach);
                fileWriter.append(String.valueOf(bn.getNgayRaVien()));
                fileWriter.append(fileXuongDong);
            }
            fileWriter.close();
        }catch (IOException ex){
            System.out.println("Error in CSV!!!");
        }
    }
    public List<Patient> readPatientToFile(){
        BufferedReader bufferedReader = null;
        List<Patient> patientList = new ArrayList<>();
        Path path = Paths.get(fileNamePatient);
        if(!Files.exists(path)){
            try {
                Writer writer = new FileWriter(fileNamePatient);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        try{
            String line;
            bufferedReader = new BufferedReader(new FileReader(fileNamePatient));
            while ((line = bufferedReader.readLine()) != null) {
                String[] splitData = line.split(",");

                if (splitData.length >= 8 && !splitData[0].equals("ID")) {
                    try {
                        int id = Integer.parseInt(splitData[0]);
                        String name = splitData[1];
                        String gioiTinh = splitData[2];
                        String cccd = splitData[3];
                        String baoHiemYTe = splitData[4];
                        String benhAn = splitData[5];

                        String ngayNhapVien = splitData[6];
                        String ngayRaVien = splitData[7];

                        Patient patient = new Patient(id, name, gioiTinh, cccd, baoHiemYTe, benhAn, ngayNhapVien, ngayRaVien);
                        patientList.add(patient);
                    } catch (NumberFormatException e) {
                        System.out.println("Lỗi dữ liệu từ CSV: " + e.getMessage());
                    }
                } else {
                    System.out.println("Lỗi dữ liệu: " + line);
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Error in CSV!!!");
            e.printStackTrace();
        }
        return patientList;
    }
}
