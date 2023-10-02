package caseStudy_module2.model;

public class Room extends Facility{
    private String servierFree;

    public Room() {
    }

    public Room(String servierFree) {
        this.servierFree = servierFree;
    }

    public Room(String tenDichVu, String dienTichSuDung, String chiPhiThue, int soLuongNguoiToiDa, String kieuThue, String servierFree) {
        super(tenDichVu, dienTichSuDung, chiPhiThue, soLuongNguoiToiDa, kieuThue);
        this.servierFree = servierFree;
    }

    public String getServierFree() {
        return servierFree;
    }

    public void setServierFree(String servierFree) {
        this.servierFree = servierFree;
    }

    @Override
    public String toString() {
        return "Room{" +
                "tenDichVu='" + getTenDichVu() + '\'' +
                ", dienTichSuDung='" + getDienTichSuDung() + '\'' +
                ", chiPhiThue='" + getChiPhiThue() + '\'' +
                ", soLuongNguoiToiDa=" + getSoLuongNguoiToiDa() +
                ", kieuThue='" + getKieuThue() + '\'' +
                ", servierFree='" + servierFree + '\'' +
                '}';
    }
}
