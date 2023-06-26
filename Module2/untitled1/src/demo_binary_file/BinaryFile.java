package demo_binary_file;

import java.io.*;

public class BinaryFile {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        SinhVien sinhVien = new SinhVien();
//        sinhVien.setMaSo("044459");
//        sinhVien.setHoTen("Nguyen Xuan Bao");
//        sinhVien.setTuoi(20);
//        sinhVien.setDiaChi("Da Nang");
//
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("sinhvien1.dat")));
//        objectOutputStream.writeObject(sinhVien);

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("sinhvien1.dat"));
        SinhVien sinhVien = (SinhVien) objectInputStream.readObject();

        System.out.println(sinhVien.getMaSo());
        System.out.println(sinhVien.getHoTen());
        System.out.println(sinhVien.getTuoi());
        System.out.println(sinhVien.getDiaChi());
    }
}
