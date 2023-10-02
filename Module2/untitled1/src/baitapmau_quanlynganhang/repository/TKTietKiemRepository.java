package baitapmau_quanlynganhang.repository;

import baitapmau_quanlynganhang.model.TKTietKiem;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TKTietKiemRepository {
    private static final String fileXuongDong = "\n";
    private static final String fileKhoangCach = ",";
    private static final String fileHeaderTKTietKiem = "ID, NAME, SDT, BIRTHDAY, SO DU, CHI NHANH" +
            "SO TK, STATUS";
    private static final String fileNameTKTietKiem = "E:\\CodeGym\\A0223I1-NguyenXuanBao\\Module2\\untitled1\\src\\baitapmau_quanlynganhang\\data\\tktietkiem.csv";

    public List<TKTietKiem> list = new ArrayList<>();
    public void writeTKTietKiemCSV(List<TKTietKiem> list) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileNameTKTietKiem);
            fileWriter.append(fileHeaderTKTietKiem);
            fileWriter.append(fileXuongDong);
            for (TKTietKiem tietKiem : list) {
                fileWriter.append(String.valueOf(tietKiem.getId()));
                fileWriter.append(fileKhoangCach);
                fileWriter.append(tietKiem.getName());
                fileWriter.append(fileKhoangCach);
                fileWriter.append(tietKiem.getSdt());
                fileWriter.append(fileKhoangCach);
                fileWriter.append(tietKiem.getBirthday());
                fileWriter.append(fileKhoangCach);
                fileWriter.append(String.valueOf(tietKiem.getSoDu()));
                fileWriter.append(fileKhoangCach);
                fileWriter.append(tietKiem.getChiNhanh());
                fileWriter.append(fileKhoangCach);
                fileWriter.append(tietKiem.getSoTk());
                fileWriter.append(fileKhoangCach);
                fileWriter.append(tietKiem.getStatus());
                fileWriter.append(fileXuongDong);
            }
            fileWriter.close();
        } catch (IOException ex) {
            System.out.println("Error in CSV!!!");
        }
    }
    public List<TKTietKiem> readTKTietKiemToFile() {
        BufferedReader bufferedReader = null;
        List<TKTietKiem> tkTietKiemList = new ArrayList<>();
        Path path = Paths.get(fileNameTKTietKiem);
        if(!Files.exists(path)){
            try {
                Writer writer = new FileWriter(fileNameTKTietKiem);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        try{
            String line;
            bufferedReader = new BufferedReader(new FileReader(fileNameTKTietKiem));
            while ((line = bufferedReader.readLine()) != null){
                String[] splitData = line.split(",");
                try {
                    if (splitData.length >= 8) {
                        String stId = splitData[0];
                        if (!stId.equals("ID")){
                            int id = Integer.parseInt(splitData[0]);
                            String name = splitData[1];
                            String sdt = splitData[2];
                            String birthday = splitData[3];
                            double suDu = Double.parseDouble(splitData[4]);
                            String chiNhanh = splitData[5];
                            String soTk = splitData[6];
                            String status = splitData[7];
                            TKTietKiem tietKiem = new TKTietKiem(id, name, sdt, birthday, suDu, chiNhanh, soTk, status);
                            tkTietKiemList.add(tietKiem);
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
        return tkTietKiemList;
    }
}
