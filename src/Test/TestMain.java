package Test;

import java.util.Scanner;

public class TestMain {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean menuOne = true;

        System.out.println("-----Welcome-----\n" +
                "1. Browse categories\n" +
                "2. Create new category\n" +
                "3. Manage inventory\n" +
                "4. Search for products");


        while (menuOne) {
            try {
                menuOne = false;
                int menuOneInput = scanner.nextInt();
                switch (menuOneInput) {
                    case 1:
                        System.out.println("Categories:");
                        break;
                    case 2:
                        System.out.println("Create category");
                        break;
                    case 3:
                        System.out.println("Manage balance");
                        break;
                    case 4:
                        System.out.println("Search");
                        break;
                    default:
                        menuOne = true;
                        System.out.println("Enter a valid input");
                }

            } catch (Exception e) {
                scanner.nextLine();
                menuOne = true;
                System.out.println("Enter a valid input");


            }
        }
    }
}
