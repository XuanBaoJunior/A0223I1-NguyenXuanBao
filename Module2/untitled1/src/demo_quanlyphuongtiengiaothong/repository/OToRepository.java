package demo_quanlyphuongtiengiaothong.repository;

import demo_quanlyphuongtiengiaothong.model.OTo;
import demo_quanlyphuongtiengiaothong.model.PhuongTien;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class OToRepository {
    private static final String fileXuongDong = "\n";
    private static final String fileKhoangCach = ",";
    private static final String fileHeaderOTo = "ID, BIEN SO, NHA SAN XUAT, NAM SAN XUAT, CHU SO HUU, " +
            "SO CHO, KIEU XE";
    private static final String fileNameOTo = "E:\\CodeGym\\A0223I1-NguyenXuanBao\\Module2\\untitled1\\src\\demo_quanlyphuongtiengiaothong\\data\\OTo.csv";

    public List<PhuongTien> list = new ArrayList<>();

    public void writeOToCsv(List<OTo> list) {
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileNameOTo);
            fileWriter.append(fileHeaderOTo);
            fileWriter.append(fileXuongDong);
            for (OTo oTo : list) {
                fileWriter.append(String.valueOf(oTo.getId()));
                fileWriter.append(fileKhoangCach);
                fileWriter.append(oTo.getBienSo());
                fileWriter.append(fileKhoangCach);
                fileWriter.append(oTo.getNhaSanXuat());
                fileWriter.append(fileKhoangCach);
                fileWriter.append(oTo.getNamSanXuat());
                fileWriter.append(fileKhoangCach);
                fileWriter.append(oTo.getChuSoHuu());
                fileWriter.append(fileKhoangCach);
                fileWriter.append(String.valueOf(oTo.getSoCho()));
                fileWriter.append(fileKhoangCach);
                fileWriter.append(oTo.getKieuXe());
                fileWriter.append(fileXuongDong);
            }
            fileWriter.close();
        } catch (IOException ex) {
            System.out.println("Error in CSV!!!");
        }
    }

    public List<OTo> readOToCsv() {
        BufferedReader bufferedReader = null;
        List<OTo> oToList = new ArrayList<>();
        Path path = Paths.get(fileNameOTo);
        if (!Files.exists(path)) {
            try {
                Writer writer = new FileWriter(fileNameOTo);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            String line;
            bufferedReader = new BufferedReader(new FileReader(fileNameOTo));
            while ((line = bufferedReader.readLine()) != null) {
                String[] splitData = line.split(",");
                try {
                    if (splitData.length >= 7) {
                        String stId = splitData[0];
                        if (!stId.equals("ID")) {
                            int id = Integer.parseInt(splitData[0]);
                            String bienSo = splitData[1];
                            String nhaSanXuat = splitData[2];
                            String namSanXuat = splitData[3];
                            String chuSoHuu = splitData[4];
                            int soCho = Integer.parseInt(splitData[5]);
                            String kieuXe = splitData[6];
                            OTo oTo = new OTo(id, bienSo, nhaSanXuat, namSanXuat, chuSoHuu, soCho, kieuXe);
                            oToList.add(oTo);
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
        return oToList;
    }
}