package LAB1;

/**
 * ProductManager
 */

 import java.io.BufferedWriter;
 import java.io.File;
 import java.io.FileInputStream;
 import java.io.FileOutputStream;
 import java.io.FileWriter;
 import java.io.InputStream;
 import java.io.ObjectInputStream;
 import java.io.ObjectOutputStream;
 import java.io.OutputStream;
 import java.io.PrintWriter;
 import java.util.ArrayList;
 import java.util.Comparator;
 import java.util.List;
 import java.util.Scanner;
 
 public class ProductManager {
 
     private List<Product> list = new ArrayList<>();
     File fo = new File("F:\\Ky_3_FPT\\LAB\\BaiGiai\\My_LAB1\\My_LAB1\\data.txt");
     File ft = new File("F:\\Ky_3_FPT\\LAB\\BaiGiai\\My_LAB1\\My_LAB1\\Product.txt");
     Scanner sc = new Scanner(System.in);
     private int quantity = 0;
 
     public ProductManager() {
         this.list = list;
     }
 
     public String getF() {
         return fo.toPath() + "";
     }
 
     public List<Product> sort() {
         List<Product> sorted = list;
         sorted.sort(new Comparator<Product>() {
             @Override
             public int compare(Product o1, Product o2) {
                 if (o1.getListPrice() != o2.getListPrice()) {
                     return Double.compare(o2.getListPrice(), o1.getListPrice());
                 } else {
                     return o1.getName().compareTo(o2.getName());
                 }
 
             }
         });
 
         return sorted;
     }
 
     // In ra list hiện tại
     public void print() {
         list = sort();
         if (list.isEmpty()) {
             System.out.println("Hiện tại không có phần tử trong mảng");
             return;
         }
 
         for (Product product : list) {
             System.out.println(product.toString());
         }
     }
 
     // Function 1 add Product
     public void addProduct() {
 
         System.out.println("Nhập Id(String): ");
         String id = sc.nextLine();
         System.out.println("Nhập Name(String): ");
         String name = sc.nextLine();
         System.out.println("Nhập brandId(String): ");
         String brandId = sc.nextLine();
         System.out.println("Nhập category_id(String): ");
         String category_id = sc.nextLine();
         System.out.println("Nhập year(int): ");
         int year = sc.nextInt();
         System.out.println("Enter listPrice(double): ");
         double listPrice = sc.nextDouble();
         sc.nextLine();
 
         Product p = new Product(id, name, brandId, category_id, year, listPrice);
         list.add(p);
         quantity++;
 
         System.out.println("Thêm thành công");
         System.out.println("Trong list đang có: " + list.size() + " phần tử");
     }
 
     // Function 2 search Product
     public void search() {
         System.out.println("Nhập tên sản phầm muốn tìm kiếm");
         String name = sc.nextLine();
 
         if (list.isEmpty()) {
             System.out.println("Chưa có sản phẩm nào trong List");
             return;
         }
 
         List<Product> result = new ArrayList<>();
         for (Product product : list) {
             if (product.getName().contains(name)) {
                 result.add(product);
             }
         }
 
         if (!result.isEmpty()) {
             result.sort(new Comparator<Product>() {
                 @Override
                 public int compare(Product o1, Product o2) {
                     return Integer.compare(o2.getYear(), o1.getYear());
                 }
             });
 
             for (Product product : result) {
                 System.out.println(product.toString());
             }
         } else {
             System.out.println("Không tìm thấy");
         }
 
     }
 
     // Function 3  Update Product Information
     public void update() {
         System.out.println("Nhập id sản phầm cần cập nhật");
         String id = sc.nextLine();
         for (Product product : list) {
             if (product.getId().equalsIgnoreCase(id)) {
                 // Nhập các giá trị cần thay đổi
                 System.out.println("Thay đổi tên(String) " + product.getName() + " thành: ");
                 String newName = sc.nextLine();
                 System.out.println("Thay đổi BrandId(String) " + product.getBrandId() + " thành: ");
                 String newBrandId = sc.nextLine();
                 System.out.println("Thay đổi Category_id(String) " + product.getCategory_id() + " thành: ");
                 String newCategory_id = sc.nextLine();
                 System.out.println("Thay đổi year(int) " + product.getYear() + " thành: ");
                 int newYear = sc.nextInt();
                 System.out.println("Thay đổi ListPrice(double) " + product.getListPrice() + " thành: ");
                 double newListPrice = sc.nextDouble();
                 sc.nextLine();
                 // Cập nhật giá trị vừa nhập
                 product.setName(newName);
                 product.setBrandId(newBrandId);
                 product.setCategory_id(newCategory_id);
                 product.setYear(newYear);
                 product.setListPrice(newListPrice);
 
                 System.out.println("Đã cập nhật thành công");
                 return;
             }
         }
 
         System.out.println("Không có sản phẩm chứa id = " + id + " mà bạn muốn cập nhật");
         System.out.println("!KHÔNG THỂ UPDATE");
     }
 
     // Function 4 Xóa sản phẩm theo ID
     public void delete() {
         System.out.println("Nhập id của sản phầm cần xóa");
         String id = sc.nextLine();
         List<Product> subList = list.subList(0, list.size());
         for (Product product : subList) {
             if (product.getId().trim().equalsIgnoreCase(id.trim())) {
                 System.out.println("Bạn có chắc chắn muốn xóa sản phẩm ID = " + id + "(nhập: Y/N)");
                 String yn = sc.nextLine();
                 if (yn.equalsIgnoreCase("y")) {
                     subList.remove(product);
                     quantity--;
 
                     System.out.println("Xóa thành công");
                     return;
                 } else {
                     System.out.println("Bạn đã KHÔNG xóa sản phẩm");
                 }
 
             }
         }
 
         System.out.println("Không có sản phẩm chứa " + id + " cần xóa");
     }
 
     // Function 5: lưu dữ liệu xuống file
     public void saveToFile() {
         // Lưu dạng text
 
         try (PrintWriter writer = new PrintWriter(new FileWriter(ft.getAbsolutePath()))) {
             for (Product product : list) {
                 writer.println(product.getId() + ", " + product.getName() + ", " + product.getBrandId() + ", "
                         + product.getCategory_id() + ", " + product.getYear() + ", " + product.getListPrice());
             }
             System.out.println("Đã lưu dữ liệu thành công");
         } catch (Exception e) {
             System.out.println("Đã có lỗi ở file text");
             e.printStackTrace();
         }
         // Lưu đối tượng
         try {
             OutputStream oso = new FileOutputStream(fo);
             ObjectOutputStream oos = new ObjectOutputStream(oso);
 
             for (Product product : list) {
                 oos.writeObject(product);
             }
             oos.flush();
             oos.close();
             System.out.println("Đã lưu dữ liệu thành công");
         } catch (Exception e) {
             System.out.println("Đã có lỗi ở file đối tượng");
 //            e.printStackTrace();
         }
 
     }
 
     // Function 6: Lấy dữ liệu Object từ file vào list
     public void getDataFromFile() {
         try {
             InputStream is = new FileInputStream(fo);
             ObjectInputStream ois = new ObjectInputStream(is);
 
             Product temp = null;
 
             while (true) {
                 try {
                     temp = (Product) ois.readObject();
                     list.add(temp);
                     quantity++;
                 } catch (Exception e) {
                     break;
                 }
             }
 
         } catch (Exception e) {
             System.out.println("Đã có lỗi");
             e.printStackTrace();
             return;
         }
         System.out.println("Đã lấy dữ liệu thành công");
     }
 
     public void size() {
         System.out.println("Đang có: " + quantity + " trong list");
     }
 
     // Làm rỗng file
     public void makeFileEmpty() {
 
         try {
             FileOutputStream foso = new FileOutputStream(fo);// làm trống file đối tượng
             FileOutputStream fost = new FileOutputStream(ft);// làm truống file text
         } catch (Exception e) {
         }
 
 //        try {
 //            OutputStream os = new FileOutputStream(f);
 //            ObjectOutputStream oos = new ObjectOutputStream(os);
 //            quantity = 0;
 //            oos.close();
 //        } catch (Exception e) {
 //            System.out.println("Đã có lỗi");
 ////            e.printStackTrace();
 //            return;
 //        }
 //        try {
 //            InputStream is = new FileInputStream(f);
 //            ObjectInputStream ois = new ObjectInputStream(is);
 //            
 //        } catch (Exception e) {
 //        }
     }
 }
 