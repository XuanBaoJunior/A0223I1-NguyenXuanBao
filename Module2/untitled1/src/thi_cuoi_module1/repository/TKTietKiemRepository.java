package thi_cuoi_module1.repository;

import thi_cuoi_module1.model.TKTietKiem;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TKTietKiemRepository {
    private static final String fileXuongDong = "\n";
    private static final String fileKhoangCach = ",";
    private static final String fileHeaderNganHang = "ID, MA TAI KHOAN, TEN CHU TAI KHOAN, NGAY TAO TAI KHOAN, SO TIEN GUI TIET KIEM, " +
            "NGAY GUI TIET KIEM, LAI SUAT, KY HAN, SO THE, SO TIEN TRONG THE";
    private static final String fileNameTKTietKiem = "E:\\CodeGym\\A0223I1-NguyenXuanBao\\Module2\\untitled1\\src\\thi_cuoi_module1\\data\\taikhoantietkiem.csv";

    public void writeTKTietKiemFileCSV(List<TKTietKiem> list) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileNameTKTietKiem);
            fileWriter.append(fileHeaderNganHang);
            fileWriter.append(fileXuongDong);
            for (TKTietKiem tktk : list) {
                fileWriter.append(String.valueOf(tktk.getId()));
                fileWriter.append(fileKhoangCach);
                fileWriter.append(tktk.getMaTaiKhoan());
                fileWriter.append(fileKhoangCach);
                fileWriter.append(tktk.getTenChuTaiKhoan());
                fileWriter.append(fileKhoangCach);
                fileWriter.append(tktk.getNgayTaoTk());
                fileWriter.append(fileKhoangCach);
                fileWriter.append(tktk.getSoTienGuiTietKiem());
                fileWriter.append(fileKhoangCach);
                fileWriter.append(tktk.getNgayGuiTietKiem());
                fileWriter.append(fileKhoangCach);
                fileWriter.append(tktk.getLaiSuat());
                fileWriter.append(fileKhoangCach);
                fileWriter.append(tktk.getKyHan());
                fileWriter.append(fileXuongDong);
            }
            fileWriter.close();
        }catch (IOException ex){
            System.out.println("Error in CSV!!!");
        }
    }
    public List<TKTietKiem> readTKTietKiemToFile(){
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
                if(splitData[0].equals("ID")){
                    continue;
                }
                int id = Integer.parseInt(splitData[0]);
                String maTaiKhoan = splitData[1];
                String tenChuTaiKhoan = splitData[2];
                String ngayTaoTk = splitData[3];
                String soTienGuiTietKiem = splitData[4];
                String ngayGuiTietKiem = splitData[5];
                String laiSuat = splitData[6];
                String kyHan = splitData[7];
                TKTietKiem tkTietKiem = new TKTietKiem(id, maTaiKhoan, tenChuTaiKhoan, ngayTaoTk,soTienGuiTietKiem,ngayGuiTietKiem,laiSuat,kyHan);
                tkTietKiemList.add(tkTietKiem);

            }
            bufferedReader.close();

        }catch (Exception e){
            System.out.println("Error in CSV!!!");
            e.printStackTrace();

        }
        return tkTietKiemList;
    }
}
