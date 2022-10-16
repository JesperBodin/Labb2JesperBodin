package Laboration2;

import java.util.Scanner;


public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CSVReader.csvProductList();
        runMenu();
    }

    public static void runMenu(){

        while (true) {
            mainMenu();
                char userInput = scanner.next().charAt(0);
                scanner.nextLine();
            switch (userInput) {
                case '1' -> ProductHandler.printProducts();
                case '2' -> ProductHandler.createNewProduct();
                case '3' -> ProductHandler.searchProduct();
                case '4' -> ProductHandler.searchProductByPrice();
                case '5' -> ProductHandler.removeProduct();
                case '6' -> ProductHandler.productManagerMenu();
                case '7' -> CSVReader.saveProduct();
                case 'e', 'E' -> {
                    CSVReader.saveProduct();
                    System.out.println("Closing & Saving");
                    System.exit(0);
                }
                default -> System.out.println("Enter a valid input");
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
                    6. Manage Product
                    7. Save to File
                    e. Exit & Save Program""";
            System.out.println(menuText);
        }

    }

