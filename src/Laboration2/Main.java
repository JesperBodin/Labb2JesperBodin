package Laboration2;

import java.util.Scanner;


public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CSVReader.csvProductList();
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
                        ProductHandler.printProducts();
                        break;
                    case '2':
                        ProductHandler.createNewProduct();
                        break;
                    case '3':
                        ProductHandler.searchProduct();
                        break;
                    case '4':
                        ProductHandler.searchProductByPrice();
                        break;
                    case '5':
                        ProductHandler.removeProduct();
                        break;
                    case '6':
                        CSVReader.saveProduct();
                        break;
                    case '7':
                        break;
                    case 'e','E':
                        CSVReader.saveProduct();
                        System.out.println("Closing & Saving");
                        System.exit(0);
                    default:
                        System.out.println("Enter a valid input");
                }

            }

        }

        private static void mainMenu () {
            String menuText = """
                    --------Welcome--------
                    1. Browse Products
                    2. Add New Product
                    3. Search Category/Product
                    4. Search Product by price
                    5. Remove Product
                    6. Manage Inventory
                    e. Exit & Save Program""";
            System.out.println(menuText);
        }

    }

