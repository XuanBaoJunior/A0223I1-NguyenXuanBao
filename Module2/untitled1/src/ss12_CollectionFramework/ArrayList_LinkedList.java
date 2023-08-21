package ss12_CollectionFramework;

import java.util.*;

public class ArrayList_LinkedList {
    private List<Product> products;

    public ArrayList_LinkedList() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void editProduct(int id, String newName, double newPrice) {
        for (Product product : products) {
            if (product.getId() == id) {
                product.name = newName;
                product.price = newPrice;
                break;
            }
        }
    }

    public void removeProduct(int id) {
        products.removeIf(product -> product.getId() == id);
    }

    public void displayProducts() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public Product searchProductByName(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    public void sortProductsAscending() {
        Collections.sort(products, Comparator.comparingDouble(Product::getPrice));
    }

    public void sortProductsDescending() {
        Collections.sort(products, Comparator.comparingDouble(Product::getPrice).reversed());
    }

    public static void main(String[] args) {
        ArrayList_LinkedList productManagement = new ArrayList_LinkedList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Sửa thông tin sản phẩm");
            System.out.println("3. Xoá sản phẩm");
            System.out.println("4. Hiển thị danh sách sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm theo tên");
            System.out.println("6. Sắp xếp sản phẩm tăng dần");
            System.out.println("7. Sắp xếp sản phẩm giảm dần");
            System.out.println("8. Thoát");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhập ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nhập tên: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập giá: ");
                    double price = scanner.nextDouble();
                    productManagement.addProduct(new Product(id, name, price));
                    break;
                case 2:
                    System.out.print("Nhập ID sản phẩm cần chỉnh sửa: ");
                    int editId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nhập tên mới: ");
                    String newName = scanner.nextLine();
                    System.out.print("Nhập giá mới: ");
                    double newPrice = scanner.nextDouble();
                    productManagement.editProduct(editId, newName, newPrice);
                    break;
                case 3:
                    System.out.print("Nhập ID của sản phẩm để xóa: ");
                    int removeId = scanner.nextInt();
                    productManagement.removeProduct(removeId);
                    break;
                case 4:
                    productManagement.displayProducts();
                    break;
                case 5:
                    System.out.print("Nhập tên sản phẩm để tìm kiếm: ");
                    String searchName = scanner.nextLine();
                    Product searchResult = productManagement.searchProductByName(searchName);
                    if (searchResult != null) {
                        System.out.println("Sản phầm: " + searchResult);
                    } else {
                        System.out.println("Không tìm thấy sản phẩm.");
                    }
                    break;
                case 6:
                    productManagement.sortProductsAscending();
                    System.out.println("Sản phẩm được sắp xếp theo thứ tự tăng dần.");
                    break;
                case 7:
                    productManagement.sortProductsDescending();
                    System.out.println("Sản phẩm được sắp xếp theo thứ tự giảm dần.");
                    break;
                case 8:
                    System.out.println("Thoát...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập một tùy chọn hợp lệ.");
            }
        }
    }
}

