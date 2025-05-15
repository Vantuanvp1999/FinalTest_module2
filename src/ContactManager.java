import java.io.*;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactManager implements IManager<Contact> {
public static final String FILE_NAME="contacts.dat";
private static File file = new File(FILE_NAME);
private List<Contact> contacts = new ArrayList<>();
private Scanner scanner = new Scanner(System.in);

public void displayContacts(){
    if (contacts.isEmpty()){
        System.out.println("Danh bạ trống");
        return;
    }
    System.out.println("==DANH BẠ==");
    int count=0;
    for (int i = 0; i < contacts.size(); i++) {
        System.out.println(contacts.get(i));
        count++;
        if(count==5){
            System.out.println("Nhấn enter để tiếp tục");
            scanner.nextLine();
            count = 0;
        }
    }
    System.out.println("==HẾT DANH BẠ==");
}
 public void addContact(){
    String phone, group, name, gender, address,birthdate, email;
    while(true){
        System.out.println("Nhập số điện thoại");
        phone = scanner.nextLine();
        if (phone.isEmpty()){
            System.out.println("Số điện thoại Không được để trống!");
        } else if (!phone.matches("^\\d{10,11}$")) {
            System.out.println("Số điện thoại phải có 10 hoặc 11 chữ số.");
            
        }else {
            break;
        }
    }
     while(true){
         System.out.println("Nhập nhóm của danh bạ:");
         group = scanner.nextLine();
         if (group.isEmpty()){
             System.out.println("Nhóm Không được để trống!");
         } else {
             break;
         }
     }
     while(true){
         System.out.println("Nhập họ và tên của danh bạ:");
         name = scanner.nextLine();
         if (name.isEmpty()){
             System.out.println("Họ và tên Không được để trống!");
         } else {
             break;
         }
     }
     while(true){
         System.out.println("Nhập giới tính của danh bạ (Nam/Nữ):");
         gender = scanner.nextLine();
         if (gender.isEmpty()){
             System.out.println("Giới tính Không được để trống!");
         } else if (!gender.equals("Nam")&&!gender.equals("Nữ")) {
             System.out.println("Lỗi nhập liệu, yêu cầu nhập lại (Nam/Nữ) ");
         } else {
             break;
         }
     }
     while(true){
         System.out.println("Nhập địa chỉ của danh bạ:");
         address = scanner.nextLine();
         if (address.isEmpty()){
             System.out.println("địa chỉ Không được để trống!");
         } else {
             break;
         }
     }
     while(true){
         System.out.println("Nhập ngày sinh của danh bạ (dd/mm/yyyy):");
         birthdate = scanner.nextLine();
         if (birthdate.isEmpty()){
             System.out.println("Ngày sinh Không được để trống!");
         } else if (!birthdate.matches("^\\d{2}/\\d{2}/\\d{4}$")) {
             System.out.println("Lỗi nhập liệu, yêu cầu nhập lại (dd/mm/yyyy) ");
         } else {
             break;
         }
     }
     while(true) {
         System.out.println("Nhập email của danh bạ (VD: ten@gmail.com):");
         email = scanner.nextLine();
         if (email.isEmpty()) {
             System.out.println("Ngày sinh Không được để trống!");
         } else if (!email.matches("^[0-9a-zA-Z._%+-]+@[a-zA-Z0-9._]+\\.[a-zA-Z]{2,}$")) {
             System.out.println("Lỗi nhập liệu, yêu cầu nhập lại (VD: ten12@gmail.com) ");
         } else {
             break;
         }
     }
     contacts.add(new Contact(phone,group,name,gender,address,birthdate,email));
     System.out.println("Thêm danh bạ thành công!");
 }
 public void editContact(){
    while (true) {
        System.out.println("Nhập số điện thoại cần cập nhật:(Nhấn enter để thoát)");
        String phone ,group, name, gender,address,birthdate,email;
        phone = scanner.nextLine();
        if(phone.isEmpty()){
            System.out.println("Hủy cập nhật quay về menu!");
            break;

        }
        Contact contactToUpdate =null;
        for (Contact c:contacts){
            if(c.getPhone().equals(phone)){
                contactToUpdate=c;
            }
        }
        if (contactToUpdate==null){
            System.out.println("Không tìm thấy danh bạ trên");
            continue;
        }
        while(true){
            System.out.println("Nhập nhóm của danh bạ:");
            group = scanner.nextLine();
            if (group.isEmpty()){
                System.out.println("Nhóm Không được để trống!");
            } else {
                break;
            }
        }
        while(true){
            System.out.println("Nhập họ và tên của danh bạ:");
            name = scanner.nextLine();
            if (name.isEmpty()){
                System.out.println("Họ và tên Không được để trống!");
            } else {
                break;
            }
        }
        while(true){
            System.out.println("Nhập giới tính của danh bạ (Nam/Nữ):");
            gender = scanner.nextLine();
            if (gender.isEmpty()){
                System.out.println("Giới tính Không được để trống!");
            } else if (!gender.equals("Nam")&&!gender.equals("Nữ")) {
                System.out.println("Lỗi nhập liệu, yêu cầu nhập lại (Nam/Nữ) ");
            } else {
                break;
            }
        }
        while(true){
            System.out.println("Nhập địa chỉ của danh bạ:");
            address = scanner.nextLine();
            if (address.isEmpty()){
                System.out.println("địa chỉ Không được để trống!");
            } else {
                break;
            }
        }
        while(true){
            System.out.println("Nhập ngày sinh của danh bạ (dd/mm/yyyy):");
            birthdate = scanner.nextLine();
            if (birthdate.isEmpty()){
                System.out.println("Ngày sinh Không được để trống!");
            } else if (!birthdate.matches("^\\d{2}/\\d{2}/\\d{4}$")) {
                System.out.println("Lỗi nhập liệu, yêu cầu nhập lại (dd/mm/yyyy) ");
            } else {
                break;
            }
        }
        while(true) {
            System.out.println("Nhập email của danh bạ (VD: ten@gmail.com):");
            email = scanner.nextLine();
            if (email.isEmpty()) {
                System.out.println("Ngày sinh Không được để trống!");
            } else if (!email.matches("^[0-9a-zA-Z._%+-]+@[a-zA-Z0-9._]+\\.[a-zA-Z]{2,}$")) {
                System.out.println("Lỗi nhập liệu, yêu cầu nhập lại (VD: ten12@gmail.com) ");
            } else {
                break;
            }
        }
        contactToUpdate.setGroup(group);
        contactToUpdate.setName(name);
        contactToUpdate.setGender(gender);
        contactToUpdate.setAddress(address);
        contactToUpdate.setBirthdate(birthdate);
        contactToUpdate.setEmail(email);
        System.out.println("Cập nhật thành công!");
        return;
    }
 }
public void deleteContact() {
    String phone;
    while (true) {
        while (true) {
            System.out.println("Nhập số điện thoại của danh bạ mà bạn muốn xóa");
            phone = scanner.nextLine();
            if (!phone.matches("^\\d{10,11}$")) {
                System.out.println("Số điện thoại phải có 10 hoặc 11 chữ số.");

            } else {
                break;
            }
        }
        if (phone.isEmpty()) {
            System.out.println("Hủy xóa quay về menu");
            break;
        }
        Contact contactToDelete = null;
        for (Contact c :contacts){
            if(c.getPhone().equals(phone)){
                contactToDelete=c;
                break;
            }
        }
        if (contactToDelete==null){
            System.out.println("Không tìm thấy danh bạ với số điện thoại trên!");
            continue;
        }
        System.out.println("tìm thấy " +contactToDelete);
        System.out.println("Bạn có chắc muốn xóa (Y/N)");
        String confirm = scanner.nextLine();
        if (confirm.toLowerCase().equals("Y")){
            contacts.remove(contactToDelete);
            System.out.println("Xóa danh bạ thành công");
        }else{
            System.out.println("Không xóa quay về Menu!");
            break;
        }
        return;
    }
}
public void searchContact(){
    System.out.println("Nhập từ khóa của danh bạ (số điện thoại hoặc tên)!");
    String keyWord= scanner.nextLine().trim();

    List<Contact> results = new ArrayList<>();
    for (Contact c: contacts){
        if (c.getPhone().contains(keyWord)||c.getName().contains(keyWord)){
            results.add(c);
        }
    }
    if (results==null){
        System.out.println("Không tìm thấy danh bạ!");
    }else {
        System.out.println("Danh sách kết quả tìm kiếm!");
        for(Contact c : results){
            System.out.println(c);
        }
    }
}

    @Override
    public void addToCSV() {
        try {
            FileOutputStream fos =new FileOutputStream(file, true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(contacts);
            oos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Contact> readFromCSV() {
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            contacts= (ArrayList<Contact>) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return contacts;
    }

}
