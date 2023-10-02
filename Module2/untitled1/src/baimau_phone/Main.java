package baimau_phone;

import java.util.Scanner;

public class Main {
    private static final PhoneService phoneService = new PhoneService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("=== Menu Phone ===");
            System.out.println("1. Create \n" +
                    "2. Update \n" +
                    "3. Delete \n" +
                    "4. Search by price \n" +
                    "5. Display \n" +
                    " 6. Exit");

            int choice = getChoice();

            switch (choice) {
                case 1 : create();
                case 2 : update();
                case 3 : delete();
                case 4 : searchByPrice();
                case 5 : display();
                case 6 : System.exit(0);
            }
        }
    }

    private static void create() {
        save(false);
        System.out.println("create successfully");
    }

    private static void update() {
        save(true);
        System.out.println("Updated successfully");
    }

    private static void delete() {
        int choice = choicePhone();
        int id = Integer.parseInt(getInput("Enter ID you want to delete"));
        phoneService.deleteById(choice==1, id);
        System.out.println("Deleted successful");
    }

    private static void searchByPrice() {
        int choice = choicePhone();
        Double price = Double.parseDouble(getInput("Enter price want to search"));
        phoneService.findByPrice(choice==1,price).forEach(System.out::println);
    }

    private static void display() {
        System.out.print("1. Authentic \n" +
                "2. Hand");

        int choice = getChoice();

        if (choice == 1) {
//            List<AuthenticPhone> authenticPhoneList = phoneService.findAllAuthentic();
//            for (int i = 0; i < authenticPhoneList.size(); i++) {
//                System.out.println(authenticPhoneList.get(i));
//            }

            phoneService.findAllAuthentic().forEach(System.out::println);
        } else {
            phoneService.findAllHand().forEach(System.out::println);
        }

    }

    private static int getChoice() {
        System.out.print("Enter your choice:");
        return Integer.parseInt(scanner.nextLine());
    }

    private static String getInput(String field) {
        System.out.print(field + ":");
        return scanner.nextLine();
    }

    private static void save(boolean isEdit) {
        int id = 0;
        int choice = choicePhone();

        if (isEdit) {
            id = Integer.parseInt(getInput("Enter ID you want to update"));
        }


        String name = getInput("Name");
        Double price = Double.parseDouble(getInput("Price"));
        String manufacture = getInput("Manufacture");

        Phone phone;

        if (choice == 1) {
            int granteeByYear = Integer.parseInt(getInput("Grantee By Year"));
            String granteeCode = getInput("Grantee Code");

            phone = new AuthenticPhone(id, name, price, manufacture, granteeByYear, granteeCode);
        } else {
            String country = getInput("Country");
            String status = getInput("Status");

            phone = new HandPhone(id, name, price, manufacture, country, status);
        }

        phoneService.save(phone);
    }

    private static int choicePhone(){
        System.out.print("1. Authentic \n" +
                "2. Hand");
        return getChoice();
    }
}

