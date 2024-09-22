package LAB1;


import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        ProductManager list = new ProductManager();
        Scanner sc = new Scanner(System.in);

        int choice = 1;

        do {
            System.out.println("---------------");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Tìm kiếm sản phẩm");
            System.out.println("3. Cập nhật sản phẩm");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("5. Lưu các Product xuống file");
            System.out.println("6. Lấy các đối tượng đang có trong file vào List");
            System.out.println("7. In ra ds hiện tại");
            System.out.println("8. Kiểm tra trong list đang có bao nhiêu phần tử");
            System.out.println("9. Làm rỗng file và kết thúc chương trình");
            System.out.println("0. Quit");
            System.out.println("---------------");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    list.addProduct();
                    break;
                case 2:
                    list.search();
                    break;
                case 3:
                    list.update();
                    break;
                case 4:
                    list.delete();
                    break;
                case 5:
                    System.out.println("Tên file đã lưu: "+list.getF());
                    list.saveToFile();
                    break;
                case 6:
                    System.out.println("Lấy dữ liệu từ: "+list.getF());
                    list.getDataFromFile();
                    break;
                case 7:
                    list.print();
                    break;
                case 8: 
                    list.size();
                    break;
                case 9: 
                    list.makeFileEmpty();
                    choice = 0;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 0);

    }
}
