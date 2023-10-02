package baitapmau_quanlynganhang.repository;

import baitapmau_quanlynganhang.model.TKTinDung;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TKTinDungRepository {
    private static final String fileXuongDong = "\n";
    private static final String fileKhoangCach = ",";
    private static final String fileHeaderTKTinDung = "ID, NAME, SDT, BIRTHDAY, SO DU, CHI NHANH" +
            "SO THE, MA PIN";
    private static final String fileNameTKTinDung = "E:\\CodeGym\\A0223I1-NguyenXuanBao\\Module2\\untitled1\\src\\baitapmau_quanlynganhang\\data\\tktindung.csv";

    public List<TKTinDung> list = new ArrayList<>();
    public void writeTKTinDungCSV(List<TKTinDung> list) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileNameTKTinDung);
            fileWriter.append(fileHeaderTKTinDung);
            fileWriter.append(fileXuongDong);
            for (TKTinDung tinDung : list) {
                fileWriter.append(String.valueOf(tinDung.getId()));
                fileWriter.append(fileKhoangCach);
                fileWriter.append(tinDung.getName());
                fileWriter.append(fileKhoangCach);
                fileWriter.append(tinDung.getSdt());
                fileWriter.append(fileKhoangCach);
                fileWriter.append(tinDung.getBirthday());
                fileWriter.append(fileKhoangCach);
                fileWriter.append(String.valueOf(tinDung.getSoDu()));
                fileWriter.append(fileKhoangCach);
                fileWriter.append(tinDung.getChiNhanh());
                fileWriter.append(fileKhoangCach);
                fileWriter.append(tinDung.getSoThe());
                fileWriter.append(fileKhoangCach);
                fileWriter.append(String.valueOf(tinDung.getMaPin()));
                fileWriter.append(fileXuongDong);
            }
            fileWriter.close();
        } catch (IOException ex) {
            System.out.println("Error in CSV!!!");
        }
    }
    public List<TKTinDung> readTKTinDungToFile() {
        BufferedReader bufferedReader = null;
        List<TKTinDung> tkTinDungList = new ArrayList<>();
        Path path = Paths.get(fileNameTKTinDung);
        if(!Files.exists(path)){
            try {
                Writer writer = new FileWriter(fileNameTKTinDung);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        try{
            String line;
            bufferedReader = new BufferedReader(new FileReader(fileNameTKTinDung));
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
                            String soThe = splitData[6];
                            int maPin = Integer.parseInt(splitData[7]);
                            TKTinDung tinDung = new TKTinDung(id, name, sdt, birthday, suDu, chiNhanh, soThe, maPin);
                            tkTinDungList.add(tinDung);
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
        return tkTinDungList;
    }
}
