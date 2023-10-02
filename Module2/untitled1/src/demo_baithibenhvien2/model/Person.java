package demo_baithibenhvien2.model;

public class Person {
    private int id;
    private String name;
    private String gioiTinh;

    public Person() {
    }

    public Person(int id, String name, String gioiTinh) {
        this.id = id;
        this.name = name;
        this.gioiTinh = gioiTinh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                '}';
    }
}
