import java.sql.SQLOutput;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ContactManager contactManager = new ContactManager();;
        String choice;
        do {
            menu();
             choice = readChoice();

            switch (choice){
                case "1":
                    contactManager.displayContacts();
                    break;
                case "2":
                    contactManager.addContact();
                    break;
                case "3":
                    contactManager.editContact();
                    break;
                case "4":
                    contactManager.deleteContact();
                    break;
                case "5":
                    contactManager.searchContact();
                    break;
                case "6":
                    contactManager.readFromCSV();
                    break;
                case "7":
                    contactManager.addToCSV();
                    break;
                case "8":
                    System.out.println("Thoát chương trình! Tạm biệt");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Chọn lại");
                    break;
            }

        }while(choice!="8");
    }
    public static void menu(){
        System.out.println("----CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ----");
        System.out.println("Chọn chức năng theo số (để tiếp tục):");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Tìm kiếm");
        System.out.println("6. Đọc từ file");
        System.out.println("7. Ghi vào file");
        System.out.println("8. Thoát");
        System.out.println("Chọn chức năng!");
    }
    public static String readChoice(){
        Scanner sc = new Scanner(System.in);;
        System.out.println("Chọn chức năng:");
        return sc.nextLine();
    }
}