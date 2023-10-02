package demo_quanlyphuongtiengiaothong.repository;

import demo_quanlyphuongtiengiaothong.model.PhuongTien;
import demo_quanlyphuongtiengiaothong.model.XeMay;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class XeMayRepository {
    private static final String fileXuongDong = "\n";
    private static final String fileKhoangCach = ",";
    private static final String fileHeaderXeMay = "ID, BIEN SO, NHA SAN XUAT, NAM SAN XUAT, CHU SO HUU, " +
            "CONG SUAT";
    private static final String fileNameXeMay = "E:\\CodeGym\\A0223I1-NguyenXuanBao\\Module2\\untitled1\\src\\demo_quanlyphuongtiengiaothong\\data\\XeMay.csv";

    public List<PhuongTien> list = new ArrayList<>();

    public void writeXeMayCsv(List<XeMay> list) {
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileNameXeMay);
            fileWriter.append(fileHeaderXeMay);
            fileWriter.append(fileXuongDong);
            for (XeMay xeMay : list) {
                fileWriter.append(String.valueOf(xeMay.getId()));
                fileWriter.append(fileKhoangCach);
                fileWriter.append(xeMay.getBienSo());
                fileWriter.append(fileKhoangCach);
                fileWriter.append(xeMay.getNhaSanXuat());
                fileWriter.append(fileKhoangCach);
                fileWriter.append(xeMay.getNamSanXuat());
                fileWriter.append(fileKhoangCach);
                fileWriter.append(xeMay.getChuSoHuu());
                fileWriter.append(fileKhoangCach);
                fileWriter.append(xeMay.getCongSuat());
                fileWriter.append(fileXuongDong);
            }
            fileWriter.close();
        } catch (IOException ex) {
            System.out.println("Error in CSV!!!");
        }
    }
    public List<XeMay> readXeMayCsv() {
        BufferedReader bufferedReader = null;
        List<XeMay> xeMayList = new ArrayList<>();
        Path path = Paths.get(fileNameXeMay);
        if (!Files.exists(path)) {
            try {
                Writer writer = new FileWriter(fileNameXeMay);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            String line;
            bufferedReader = new BufferedReader(new FileReader(fileNameXeMay));
            while ((line = bufferedReader.readLine()) != null) {
                String[] splitData = line.split(",");
                try {
                    if (splitData.length >= 6) {
                        String stId = splitData[0];
                        if (!stId.equals("ID")) {
                            int id = Integer.parseInt(splitData[0]);
                            String bienSo = splitData[1];
                            String nhaSanXuat = splitData[2];
                            String namSanXuat = splitData[3];
                            String chuSoHuu = splitData[4];
                            String congXuat = splitData[5];
                            XeMay xeMay = new XeMay(id, bienSo, nhaSanXuat, namSanXuat, chuSoHuu, congXuat);
                            xeMayList.add(xeMay);
                        }
                    } else {
                        System.out.println("Lỗi dữ liệu: " + line);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Lỗi dữ liệu từ CSV: " + e.getMessage());
                }
            }
            bufferedReader.close();

        } catch (Exception e) {
            System.out.println("Error in CSV!!!");
            e.printStackTrace();
        }
        return xeMayList;
    }
}
