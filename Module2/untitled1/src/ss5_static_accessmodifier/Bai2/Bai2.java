package ss5_static_accessmodifier.Bai2;

public class Bai2 {
    private String name;
    private String classes;

    public Bai2() {
        name = "John";
        classes = "C02";
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setClasses(String classes) {

        this.classes = classes;
    }


    public String getName() {

        return name;
    }

    public String getClasses() {

        return classes;
    }
}
