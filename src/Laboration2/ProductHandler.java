package Laboration2;

import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;
import static Laboration2.CSVReader.productList;

public class ProductHandler {
    static Scanner scanner = new Scanner(System.in);

    public static void printProducts() {
        System.out.println("PRODUCTS");
        System.out.println("--------------");
        productList.stream()
                .map(Product::toString)
                .sorted()
                .forEach(System.out::println);

        backToMenu();
    }
    public static void createNewProduct() {
        String category, name, brand, productId;
        int stock, price;

        try {
            System.out.println("Enter Product category: ");
            category = scanner.nextLine().toUpperCase();
            System.out.println("Enter product name");
            name = scanner.nextLine().toUpperCase();
            System.out.println("Enter brand");
            brand = scanner.nextLine().toUpperCase();
            System.out.println("Enter product ID");
            productId = scanner.nextLine();
            System.out.println("Enter Price");
            price = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter amount in stock");
            stock = scanner.nextInt();
            scanner.nextLine();

            CSVReader.productList.add(new Product(category, name, price, brand, productId, stock));

            backToMenu();
        }catch (InputMismatchException e){
            System.out.println("Invalid input");
        }
    }
    public static void searchProduct() {

        System.out.println("Search Category or Product:");
        String userSearch = scanner.nextLine().toUpperCase();

        System.out.println("RESULT:");
        productList.stream()
                .filter(product -> product.getCategory().contains(userSearch) || product.getName().contains(userSearch))
                .forEach(System.out::println);

        backToMenu();

    }
    public static void searchProductByPrice() {

        try {
            System.out.println("Enter Min Price for product:");
            int minPriceInput = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter Max Price for product");
            int maxPriceInput = scanner.nextInt();
            scanner.nextLine();

            System.out.println("RESULT:");
            productList.stream()
                    .filter(price -> price.getPrice() >= minPriceInput && price.getPrice() <= maxPriceInput)
                    .sorted(Comparator.comparing(Product::getPrice))
                    .forEach(System.out::println);

            backToMenu();
        }catch (Exception e){
            System.out.println("Invalid input");
        }

    }
    public static void printProductName() {
        System.out.println("-----Products-----");
        productList.stream()
                .map(Product::getName)
                .sorted()
                .forEach(System.out::println);

    }
    public static void removeProduct() {
        printProductName();
        System.out.println("Choose a product to remove by typing it below: ");
        String userInput = scanner.nextLine().toUpperCase();

        try {
            Product removeAProduct = productList.stream()
                    .filter(product -> product.getName().equals(userInput))
                    .reduce((first, second) -> second).get();

            productList.remove(removeAProduct);

            System.out.println(userInput + " is Successfully removed!");
        }catch (Exception e){
            System.out.println("Invalid input");
        }
    }

    public static void productManagerMenu() {
        printProductName();
        System.out.println("Type in the product you want to manage: ");
        String userProductChoice = scanner.nextLine().toUpperCase();
                String menuText = """
                -------PRODUCT MANAGER-------
                1. Change Product Name
                2. Change Category
                3. Change Balance
                4. Change Price
                e. Back to Main Menu""";

        System.out.println(menuText);

        char userInput =scanner.next().charAt(0);
        switch (userInput) {
            case '1' -> changeProductName(userProductChoice);
            case '2' -> changeCategory(userProductChoice);
            case '3' -> changeBalance(userProductChoice);
            case '4' -> changePrice(userProductChoice);
            case 'e' -> scanner.nextLine();
            default -> System.out.println("Enter a valid input");
        }
    }

    private static void changeProductName (String userChoice) {
        scanner.nextLine();
        System.out.println("Enter new name for product");
        String newName = scanner.nextLine().toUpperCase();
        productList.stream()
                .filter(product -> product.getName().equals(userChoice))
                .forEach(product -> product.setName(newName));

        System.out.println("Name updated");
    }
    private static void changeCategory (String userChoice){
        scanner.nextLine();
        System.out.println("Enter new category for product");
        String newCategory = scanner.nextLine().toUpperCase();
        productList.stream()
                .filter(product -> product.getName().equals(userChoice))
                .forEach(product -> product.setCategory(newCategory));

        System.out.println("Category updated");
    }
    private static void changeBalance(String userChoice) {
        scanner.nextLine();
        System.out.println("Enter new balance for product");
        int newBalance = scanner.nextInt();
        productList.stream()
                .filter(product -> product.getName().equals(userChoice))
                .forEach(product -> product.setBalance(newBalance));

        System.out.println("Balance updated");
        scanner.nextLine();
    }
    private static void changePrice(String userChoice) {
        scanner.nextLine();
        System.out.println("Enter new price for product");
        double newPrice = scanner.nextInt();
        productList.stream()
                .filter(product -> product.getName().equals(userChoice))
                .forEach(product -> product.setPrice(newPrice));

        System.out.println("Price updated");
        scanner.nextLine();
    }

    public static void backToMenu() {
        System.out.println("Press \"ENTER\" to return");
        scanner.nextLine();
    }
}