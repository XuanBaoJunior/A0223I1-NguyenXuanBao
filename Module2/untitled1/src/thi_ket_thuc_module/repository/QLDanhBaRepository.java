package thi_ket_thuc_module.repository;

import thi_ket_thuc_module.model.QLDanhBa;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class QLDanhBaRepository {
    private static final String fileXuongDong = "\n";
    private static final String fileKhoangCach = ",";
    private static final String fileHeaderDanhBa = "ID, HO TEN, SO DIEN THOAI, DIA CHI EMAIL, FACEBOOK";
    private static final String fileNameDanhBa ="E:\\CodeGym\\A0223I1-NguyenXuanBao\\Module2\\untitled1\\src\\thi_ket_thuc_module\\data\\danhba.csv";
    public void writeDanhBaFileCSV(List<QLDanhBa> list){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileNameDanhBa);
            fileWriter.append(fileHeaderDanhBa);
            fileWriter.append(fileXuongDong);
            for (QLDanhBa qldb: list){
                fileWriter.append(String.valueOf(qldb.getId()));
                fileWriter.append(fileKhoangCach);
                fileWriter.append(qldb.getHoTen());
                fileWriter.append(fileKhoangCach);
                fileWriter.append(qldb.getSoDienThoai());
                fileWriter.append(fileKhoangCach);
                fileWriter.append(qldb.getDiaChi());
                fileWriter.append(fileKhoangCach);
                fileWriter.append(qldb.getEmail());
                fileWriter.append(fileKhoangCach);
                fileWriter.append(qldb.getFacebook());
                fileWriter.append(fileXuongDong);
            }
            fileWriter.close();
        }catch (IOException ex){
            System.out.println("Error in CSV!!!");
        }
    }
    public List<QLDanhBa> readDanhBaToFile(){
        BufferedReader bufferedReader = null;
        List<QLDanhBa> qlDanhBaList = new ArrayList<>();
        Path path = Paths.get(fileNameDanhBa);
        if(!Files.exists(path)){
            try {
                Writer writer = new FileWriter(fileNameDanhBa);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        try{
            String line;
            bufferedReader = new BufferedReader(new FileReader(fileNameDanhBa));
            while ((line = bufferedReader.readLine()) != null){
                String[] splitData = line.split(",");
                if(splitData[0].equals("ID")){
                    continue;
                }
                int id = Integer.parseInt(splitData[0]);
                String hoTen = splitData[1];
                String soDienThoai = splitData[2];
                String diaChi = splitData[3];
                String email = splitData[4];
                String facebook = splitData[5];
                QLDanhBa qlDanhBa = new QLDanhBa(id, hoTen, soDienThoai, diaChi, email, facebook);
                qlDanhBaList.add(qlDanhBa);
            }
            bufferedReader.close();

        }catch (Exception e){
            System.out.println("Error in CSV!!!");
            e.printStackTrace();

        }
        return qlDanhBaList;
    }
}
