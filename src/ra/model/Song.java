package ra.model;

import java.util.Date;
import java.util.Scanner;

public class Song {
    private String songId;
    private String songName;
    private String descriptions;
    private Singer singer;
    private String songWriter;
    private Date createDate;
    private boolean songStatus;

    public Song() {
        this.createDate = new Date();
    }

    public Song(String songId, String songName, String descriptions, Singer singer, String songWriter, Date createDate, boolean songStatus) {
        this.songId = songId;
        this.songName = songName;
        this.descriptions = descriptions;
        this.singer = singer;
        this.songWriter = songWriter;
        this.createDate = createDate;
        this.songStatus = songStatus;
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public String getSongWriter() {
        return songWriter;
    }

    public void setSongWriter(String songWriter) {
        this.songWriter = songWriter;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public boolean isSongStatus() {
        return songStatus;
    }

    public void setSongStatus(boolean songStatus) {
        this.songStatus = songStatus;
    }

    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mã bài hát (bắt đầu bằng 'S' và có 4 ký tự): ");
        this.songId = scanner.nextLine();
        // Kiểm tra và yêu cầu nhập lại nếu songId không hợp lệ
        while (!isValidSongId(this.songId)) {
            System.out.print("Mã bài hát không hợp lệ! Vui lòng nhập lại: ");
            this.songId = scanner.nextLine();
        }
        System.out.println("Nhap ten bai hat");
        this.songName = scanner.nextLine();
        System.out.println("Nhap mô ta");
        this.descriptions = scanner.nextLine();
        System.out.println("Nhap tac gia");
        this.songWriter = scanner.nextLine();
        System.out.println("Nhap trang thai");
        this.songStatus = Boolean.parseBoolean(scanner.nextLine());
    }

    private boolean isValidSongId(String songId) {
        return songId.length() == 4 && songId.startsWith("S"); // Mã bài hát có 4 ký tự và bắt đầu bằng 'S'
    }

    public void displayData() {
        System.out.println("Song{" +
                "songId='" + songId + '\'' +
                ", songName='" + songName + '\'' +
                ", descriptions='" + descriptions + '\'' +
                ", singer=" + singer +
                ", songWriter='" + songWriter + '\'' +
                ", createDate=" + createDate +
                ", songStatus=" + songStatus +
                '}');
    }

}


