package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class TestMain {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        runMenu();

    }
    public static void runMenu(){

        boolean runMenu = true;

        while (runMenu) {
            mainMenu();
                char menuOneInput = scanner.next().charAt(0);
                scanner.nextLine();
                switch (menuOneInput) {
                    case '1':
                        CategoryHandler.listCategories();
                        break;
                    case '2':
                        CategoryHandler.createNewCategory();
                        break;
                    case '3':
                        ProductHandler.printProducts();
                        break;
                    case '4':
                        ProductHandler.handleProductStock();
                        break;
                    case '5':
                        System.out.println("Search");
                        ProductHandler.printProductByCategory();
                        break;
                    case 'e','E':
                        runMenu = false;
                        System.out.println("Closing Program");
                        break;
                    default:
                        System.out.println("Enter a valid input");
                }

            }

        }

        private static void mainMenu () {
            String menuText = """
                    --------Welcome--------
                    1. Browse categories
                    2. Create new category
                    3. Browse products
                    4. Manage inventory
                    5. Search for products
                    e. Exit Program""";
            System.out.println(menuText);
        }

        public static void backToMenu() {
            System.out.println("Press \"ENTER\" to return");
            scanner.nextLine();
        }

    }

