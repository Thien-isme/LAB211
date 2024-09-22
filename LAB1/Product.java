package LAB1;
import java.io.Serializable;


public class Product implements Serializable {
    private String id;
    private String name;
    private String brandId;
    private String category_id;
    private int year;
    private double listPrice;

    public Product() {
    }

    public Product(String id, String name, String brandId, String category_id, int year, double listPrice) {
        this.id = id;
        this.name = name;
        this.brandId = brandId;
        this.category_id = category_id;
        this.year = year;
        this.listPrice = listPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getListPrice() {
        return listPrice;
    }

    public void setListPrice(double listPrice) {
        this.listPrice = listPrice;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", brandId=" + brandId + ", category_id=" + category_id + ", year=" + year + ", listPrice=" + listPrice + '}';
    }
    
    
}
