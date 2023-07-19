package thi_cuoi_module1.repository;

import thi_cuoi_module1.model.TKThanhToan;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TKThanhToanRepository {
    private static final String fileXuongDong = "\n";
    private static final String fileKhoangCach = ",";
    private static final String fileHeaderNganHang = "ID, MA TAI KHOAN, TEN CHU TAI KHOAN, NGAY TAO TAI KHOAN, SO TIEN GUI TIET KIEM, " +
            "NGAY GUI TIET KIEM, LAI SUAT, KY HAN, SO THE, SO TIEN TRONG THE";
    private static final String fileNameTKThanhToan = "E:\\CodeGym\\A0223I1-NguyenXuanBao\\Module2\\untitled1\\src\\thi_cuoi_module1\\data\\taikhoanthanhtoan.csv";
    public void writeTKThanhToanFileCSV(List<TKThanhToan> list){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileNameTKThanhToan);
            fileWriter.append(fileHeaderNganHang);
            fileWriter.append(fileXuongDong);
            for (TKThanhToan tktt: list){
                fileWriter.append(String.valueOf(tktt.getId()));
                fileWriter.append(fileKhoangCach);
                fileWriter.append(tktt.getMaTaiKhoan());
                fileWriter.append(fileKhoangCach);
                fileWriter.append(tktt.getTenChuTaiKhoan());
                fileWriter.append(fileKhoangCach);
                fileWriter.append(tktt.getNgayTaoTk());
                fileWriter.append(fileKhoangCach);
                fileWriter.append(tktt.getSoThe());
                fileWriter.append(fileKhoangCach);
                fileWriter.append(tktt.getSoTienTrongTaiKhoan());
                fileWriter.append(fileXuongDong);
            }
            fileWriter.close();
        }catch (IOException ex){
            System.out.println("Error in CSV!!!");
        }
    }
    public List<TKThanhToan> readTKThanhToanToFile(){
        BufferedReader bufferedReader = null;
        List<TKThanhToan> tkThanhToanList = new ArrayList<>();
        Path path = Paths.get(fileNameTKThanhToan);
        if(!Files.exists(path)){
            try {
                Writer writer = new FileWriter(fileNameTKThanhToan);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        try{
            String line;
            bufferedReader = new BufferedReader(new FileReader(fileNameTKThanhToan));
            while ((line = bufferedReader.readLine()) != null){
                String[] splitData = line.split(",");
                if(splitData[0].equals("ID")){
                    continue;
                }
                int id = Integer.parseInt(splitData[0]);
                String maTaiKhoan = splitData[1];
                String tenChuTaiKhoan = splitData[2];
                String ngayTaoTaiKhoan = splitData[3];
                String soThe = splitData[4];
                String soTienTrongTaiKhoan = splitData[5];
                TKThanhToan tkThanhToan = new TKThanhToan(id,maTaiKhoan,tenChuTaiKhoan,ngayTaoTaiKhoan,soThe, soTienTrongTaiKhoan);
                tkThanhToanList.add(tkThanhToan);



            }
            bufferedReader.close();

        }catch (Exception e){
            System.out.println("Error in CSV!!!");
            e.printStackTrace();

        }
        return tkThanhToanList;
    }
}
