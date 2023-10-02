package BaiTap_QuanLyDienThoai.repository;

import BaiTap_QuanLyDienThoai.model.QLDienThoai;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class QLDienThoaiRepository {
    private static final String fileXuongDong = "\n";
    private static final String fileKhoangCach = ",";
    private static final String fileHeaderDienThoai = "ID, NAME, PRICE, PRODUCER";
    private static final String fileNameDienThoai = "E:\\CodeGym\\A0223I1-NguyenXuanBao\\Module2\\untitled1\\src\\BaiTap_QuanLyDienThoai\\data\\dsdienthoai.csv";

    public List<QLDienThoai> list = new ArrayList<>();

    public void writeDienThoaiCSV(List<QLDienThoai> list) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileNameDienThoai);
            fileWriter.append(fileHeaderDienThoai);
            fileWriter.append(fileXuongDong);
            for (QLDienThoai dienThoai : list) {
                fileWriter.append(String.valueOf(dienThoai.getId()));
                fileWriter.append(fileKhoangCach);
                fileWriter.append(dienThoai.getName());
                fileWriter.append(fileKhoangCach);
                fileWriter.append(String.valueOf(dienThoai.getPrice()));
                fileWriter.append(fileKhoangCach);
                fileWriter.append(dienThoai.getProducer());
                fileWriter.append(fileXuongDong);
            }
            fileWriter.close();
        } catch (IOException ex) {
            System.out.println("Error in CSV!!!");
        }
    }
    public List<QLDienThoai> readDienThoaiToFile() {
        BufferedReader bufferedReader = null;
        List<QLDienThoai> qlDienThoaiList = new ArrayList<>();
        Path path = Paths.get(fileNameDienThoai);
        if(!Files.exists(path)){
            try {
                Writer writer = new FileWriter(fileNameDienThoai);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        try{
            String line;
            bufferedReader = new BufferedReader(new FileReader(fileNameDienThoai));
            while ((line = bufferedReader.readLine()) != null){
                String[] splitData = line.split(",");
                try {
                    if (splitData.length >= 4) {
                        String stId = splitData[0];
                        if (!stId.equals("ID")){
                            int id = Integer.parseInt(splitData[0]);
                            String name = splitData[1];
                            double price = Double.parseDouble(splitData[2]);
                            String producer = splitData[3];
                            QLDienThoai qlDienThoai = new QLDienThoai(id, name, price, producer);
                            qlDienThoaiList.add(qlDienThoai);
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
        return qlDienThoaiList;
    }
}
