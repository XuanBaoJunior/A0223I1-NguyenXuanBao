package thi_cuoi_module.repository;

import thi_cuoi_module.model.TKThanhToan;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TKThanhToanRepository {
    public static String fileXuongDong = "\n";
    public static String fileKhoangCach = ",";
    public static String fileHeaderTK = "ID, MA TAI KHOAN, TEN CHU TAI KHOAN, NGAY TAO TAI KHOAN, SO TIEN GUI TIET KIEM, " +
                                        "NGAY GUI TIET KIEM, LAI SUAT, KY HAN, SO THE, SO TIEN TRONG THE";
    public static final String fileNameTKThanhToan = "E:\\CodeGym\\A0223I1-NguyenXuanBao\\Module2\\untitled1\\src\\thi_cuoi_module\\data\\tkthanhtoan.csv";
    public void writeTKThanhToanFileCSV(List<TKThanhToan> list){
        list = new ArrayList<>();
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileNameTKThanhToan);
            fileWriter.append(fileHeaderTK);
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
            fileWriter.append(fileKhoangCach);
            }
            fileWriter.close();
        }catch (IOException ex){
            System.out.println("Error in CSV");
        }
    }
    public List<TKThanhToan> readTKThanhToanToFile(){
        BufferedReader bufferedReader = null;
        List<TKThanhToan> tkThanhToanList = new ArrayList<>();
        try {
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
            System.out.println("Error in CSV.");
            e.printStackTrace();
        }
        return tkThanhToanList;
    }
}
