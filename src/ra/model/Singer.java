package ra.model;

import java.util.Scanner;

public class Singer {
    private int singerId;
    private String singerName;
    private int age;
    private String nationality;
    private boolean gender;
    private String genre;

    public Singer() {

    }
    public Singer(int singerId, String singerName, int age, String nationality, boolean gender, String genre) {
        this.singerId = singerId;
        this.singerName = singerName;
        this.age = age;
        this.nationality = nationality;
        this.gender = gender;
        this.genre = genre;
    }

    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập id ca sĩ");
        this.singerId = Integer.parseInt(scanner.nextLine());
        System.out.println("Mời bạn nhập tên ca sĩ");
        this.singerName = scanner.nextLine();
        System.out.println("Mời bạn nhập tuổi ca sĩ");
        this.age = Integer.parseInt(scanner.nextLine());
        System.out.println("Mời bạn nhập giới tính ca sĩ");
        this.gender = Boolean.parseBoolean(((scanner.nextLine())));
        System.out.println("Mời bạn nhập quốc tịch ca sĩ");
        this.nationality = scanner.nextLine();
        System.out.println("Mời bạn nhập thể loại");
        this.genre = scanner.nextLine();
    }

    public void displayData() {
        System.out.println("Singer{" +
                "singerId=" + singerId +
                ", singerName='" + singerName + '\'' +
                ", age=" + age +
                ", nationality='" + nationality + '\'' +
                ", gender=" + (gender ? "Nam" : "Nữ") +
                ", genre='" + genre + '\'' +
                '}');
    }
}
