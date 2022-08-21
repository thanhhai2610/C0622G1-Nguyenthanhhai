package demo.arraylist.Model;

public class Student {
    private int id;
    private String name;
    private int namSinh;
    private double diemTrungBinh;

    public Student(int id, String name, int namSinh, double diemTrungBinh) {
        this.id = id;
        this.name = name;
        this.namSinh = namSinh;
        this.diemTrungBinh = diemTrungBinh;
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

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public double getDiemTrungBinh() {
        return diemTrungBinh;
    }

    public void setDiemTrungBinh(double diemTrungBinh) {
        this.diemTrungBinh = diemTrungBinh;
    }

    @Override
    public String toString() {
        return String.format("|%-9d|%-10s|%-4d|%.2f|", id, name,namSinh,diemTrungBinh);

    }
}
