package ra.run;

import ra.model.Singer;
import ra.model.Song;

import java.util.Scanner;

public class MusicManagement {
    static Singer[] singers = new Singer[100];
    static Song[] songs = new Song[100];
    static int songCount = 0;

    static int singerCount = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("-------------------MUSIC-MANAGEMENT----------------");
            System.out.println("1. Quản lý ca sĩ\n" +
                    "2. Quản lý bài hát\n" +
                    "3. Tìm kiếm bài hát \n" +
                    "4. Thoát ");
            System.out.println("Nhap lua chon");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    singerManagement(scanner);
                    break;
                case 2:
                    songManagement(scanner);
                    break;
                case 3:
                    searchManagement(scanner);
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Số bạn nhập không hợp lệ, mời nhập lại");
                    break;
            }
        }
    }

    public static void singerManagement(Scanner scanner) {
        int choice;
        do {
            System.out.println("**********************SINGER-MANAGEMENT************************");
            System.out.println("1. Nhập vào số lượng ca sĩ cần thêm và nhập thông tin cần thêm mới (có validate dữliệu nhập vào)");
            System.out.println("2. Hiển thị danh sách tất cả ca sĩ đã lưu trữ");
            System.out.println("3. Thay đổi thông tin ca sĩ theo mã id");
            System.out.println("4. Xóa ca sĩ theo mã id (kiểm tra xem nếu ca sĩ có bài hát thì không xóa được)");
            System.out.println("5. Thoát");
            System.out.print("Mời nhập lựa chọn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Nhập số lượng ca sĩ cần thêm mới");
                    int newSingerCount = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < newSingerCount; i++) {
                        singers[singerCount] = new Singer();
                        singers[singerCount].inputData();
                        singerCount++;
                    }
                    break;
                case 2:
                    for (int i = 0; i < singerCount; i++) {
                        singers[i].displayData();
                    }
                    break;
                case 3:
                    System.out.print("Nhập mã ca sĩ cần thay đổi thông tin: ");
                    int updateSingerId = Integer.parseInt(scanner.nextLine());
                    boolean foundSinger = false;
                    for (int i = 0; i < singerCount; i++) {
                        if (singers[i].getSingerId() == updateSingerId) {
                            foundSinger = true;
                            System.out.println("Thông tin hiện tại của singer có mã singer " + updateSingerId + ":");
                            singers[i].displayData();

                            System.out.println("Nhập thông tin mới cho singer có mã singer " + updateSingerId + ":");
                            singers[i].inputData();

                            System.out.println("Thông tin sau khi cập nhật:");
                            singers[i].displayData();
                        }
                    }

                    if (!foundSinger) {
                        System.out.println("Không tìm thấy ca sĩ có mã " + updateSingerId);
                    }
                    break;
                case 4:
                    System.out.print("Nhập mã ca sĩ cần xóa: ");
                    int deleteSingerId = Integer.parseInt(scanner.nextLine());
                    boolean found = false;
                    for (int i = 0; i < singerCount; i++) {
                        if (singers[i].getSingerId() == deleteSingerId) {
                            found = true;
                            for (int j = i; j < singerCount - 1; j++) {
                                singers[j] = singers[j + 1];
                            }
                            singerCount--;
                            System.out.println("Đã xóa singer có mã singer " + deleteSingerId);
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Không tìm thấy singer có mã singer " + deleteSingerId);
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (true);
    }

    public static void songManagement(Scanner scanner) {
        int choice;
        do {
            System.out.println("**********************SONG MANAGEMENT************************");
            System.out.println("1. .Nhập vào số lượng bài hát cần thêm và nhập thông tin cần thêm mới");
            System.out.println("2. Hiển thị danh sach tất cả bài hát đã lưu trữ");
            System.out.println("3. Thay đổi thông tin bài hát theo mã id");
            System.out.println("4. Xóa bài hát theo mã id");
            System.out.println("5. Thoát");
            System.out.print("Mời bạn lựa chọn : ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Nhập số lượng bài hát cần thêm mới");
                    int newSongCount = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < newSongCount; i++) {
                        songs[songCount] = new Song();
                        songs[songCount].inputData();
                        songCount++;
                    }
                    break;
                case 2:
                    for (int i = 0; i < songCount; i++) {
                        songs[i].displayData();
                    }
                    break;
                case 3:
                    System.out.print("Nhập mã bài hát cần thay đổi thông tin: ");
                    String updateSongId = scanner.nextLine();
                    boolean foundSong = false;
                    for (int i = 0; i < songCount; i++) {
                        if (songs[i].getSongId().equals(updateSongId)) {
                            foundSong = true;
                            System.out.println("Thông tin hiện tại của bài hát có mã " + updateSongId + ":");
                            songs[i].displayData();

                            System.out.println("Nhập thông tin mới cho bài hát có mã " + updateSongId + ":");
                            songs[i].inputData();

                            System.out.println("Thông tin sau khi cập nhật:");
                            songs[i].displayData();
                        }
                    }

                    if (!foundSong) {
                        System.out.println("Không tìm thấy bài hát có mã " + updateSongId);
                    }
                    break;
                case 4:
                    System.out.print("Nhập mã bài hát cần xóa: ");
                    String deleteSongId = scanner.nextLine();
                    boolean found = false;
                    for (int i = 0; i < songCount; i++) {
                        if (songs[i].getSongId().equals(deleteSongId)) {
                            found = true;
                            for (int j = i; j < songCount - 1; j++) {
                                songs[j] = songs[j + 1];
                            }
                            songCount--;
                            System.out.println("Đã xóa song có mã" + deleteSongId);
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Không tìm thấy bài hát có mã " + deleteSongId);
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (true);
    }

    public static void searchManagement(Scanner scanner) {
        int choice;
        do {
            System.out.println("**********************SEARCH-MANAGEMENT************************");
            System.out.println("1. Tìm kiếm bài hát theo tên ca sĩ hoặc thể loại");
            System.out.println("2. Tìm kiếm ca sĩ theo tên hoặc thể loại ");
            System.out.println("3. Hiển thị danh sách bài hát theo thứ tự tên tăng dần");
            System.out.println("4. Hiển thị 10 bài hát được đăng mới nhất ");
            System.out.println("5. Thoát");

            System.out.print("Mời bạn lựa chọn : ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Nhập tên bài hát tìm kiếm: ");
                    String searchSong = scanner.nextLine().toLowerCase();
                    boolean foundSong = false;
                    for (int i = 0; i < songCount; i++) {
                        Song currentSong = songs[i];
                        if (currentSong.getSongName().toLowerCase().contains(searchSong)) {
                            currentSong.displayData();
                            foundSong = true;
                        }
                    }
                    if (!foundSong) {
                        System.out.println("Không tìm thấy bài hát nào phù hợp.");
                    }
                    break;
                case 2:
                    System.out.print("Nhập tên ca sĩ cần tìm: ");
                    String searchSinger = scanner.nextLine().toLowerCase();
                    boolean foundSinger = false;
                    for (int i = 0; i < singerCount; i++) {
                        Singer currentSinger = singers[i];
                        if (currentSinger.getSingerName().toLowerCase().contains(searchSinger)) {
                            currentSinger.displayData();
                            foundSinger = true;
                        }
                    }
                    if (!foundSinger) {
                        System.out.println("Không tìm thấy ca sĩ nào phù hợp");
                    }
                    break;
                case 3:
                    for (int i = 0; i < songCount; i++) {
                        for (int j = i + 1; j < songCount; j++) {
                            if (songs[j].getSongName().charAt(0) < songs[i].getSongName().charAt(0)) {
                                Song temp = songs[i];
                                songs[i] = songs[j];
                                songs[j] = temp;
                            }
                        }
                    }
                    System.out.println("Đã sắp xếp sách theo ten tăng dần.");
                    for (int i = 0; i < songCount; i++) {
                        songs[i].displayData();
                    }
                    break;
                case 4:

                    break;
                case 5:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (true);
    }
}



