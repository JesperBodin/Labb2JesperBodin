package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductHandler {

    static Scanner scanner = new Scanner(System.in);

    private static List<Product> productList = new ArrayList<>(getProduct());

    private static List<Product> getProduct() { //TODO skriv från fil (load file metod som ersätter get product)
        return List.of(
                new Product(new Category("FRUIT"), "BANANA", 5, "DOLE", "00001", 50),
                new Product(new Category("DAIRY"), "MILK", 21, "ARLA", "00002", 3),
                new Product(new Category("CANDY"), "CHOCOLATE", 24, "MARABOU", "00003", 40),
                new Product(new Category("BREAD"), "LINGONGROVA", 29, "POLAR", "00004", 15),
                new Product(new Category("FRUIT"), "APPLE", 15, "DOLE", "00005", 56),
                new Product(new Category("DAIRY"), "YOGHURT", 23, "YALLA", "00006", 80),
                new Product(new Category("BREAD"), "FRANSBRÖD", 19, "POLAR", "00007", 75),
                new Product(new Category("CANDY"), "FILLIDUTT", 8, "FILLIGOTT", "00008", 75));

    }

    public static void printProducts() {
        System.out.println("PRODUCTS");
        System.out.println("--------------");
        productList.stream()
                .map(Product::toString)
                .sorted()
                .forEach(System.out::println);

        TestMain.backToMenu();
    }

    public static void createNewProduct() {
        String category, productName, brand, productId;
        int price, stock;
        System.out.println("Enter Product category: ");
        category = scanner.nextLine().toUpperCase();
        System.out.println("Enter product name");
        productName = scanner.nextLine().toUpperCase();
        System.out.println("Enter brand");
        brand = scanner.nextLine().toUpperCase();
        System.out.println("Enter product ID");
        productId = scanner.nextLine();
        System.out.println("Enter Price");
        price = scanner.nextInt();
        System.out.println("Enter amount in stock");
        stock = scanner.nextInt();

        productList.add(new Product(new Category(category),productName,price,brand,productId,stock));

        TestMain.backToMenu();
    }

    public static void searchProduct() {

        System.out.println("Search Category or Product:");
        String userSearch = scanner.nextLine().toUpperCase();

        productList.stream()
                .filter(product -> product.getCategory().getCategoryName().equals(userSearch) || product.getName().equals(userSearch))
                .forEach(System.out::println);

        TestMain.backToMenu();

    } //TODO lägg till meddelande om produkt/kategori ej finns

    public static void searchProductByPrice(){

        System.out.println("Enter Min Price for product:");
        int minPriceInput = scanner.nextInt();
        System.out.println("Enter Max Price for product");
        int maxPriceInput = scanner.nextInt();

        productList.stream()
                .filter(price -> price.getPrice() >= minPriceInput && price.getPrice()<= maxPriceInput)
                .forEach(System.out::println);

        TestMain.backToMenu();



    }



//    public static void productManager() {
//        printProductName();
//        System.out.println("Choose product to manage by typing it below: ");
//        String userInput = scanner.nextLine().toUpperCase();
//
//        System.out.println("""
//                ----Manage Product----
//                1. Manage Stock (not in use)
//                2. Remove Product
//                3. Change category (not in use)
//                """);
//
//        char userMenuChoice = scanner.next().charAt(0);
//
//
//        switch (userMenuChoice) {
//            case '1':
//                addOrRemoveFromStock();
//            case '2':
//                removeProduct(userInput);
//            case 3:
//                ChangeCategory();
//        }
//
//
//
//    }

    private static void ChangeCategory() {

    }


    public static void printProductName() {
        System.out.println("-----Products-----");
        productList.stream()
                .map(Product::getName)
                .sorted()
                .forEach(System.out::println);

    } //används till removeProduct()

    public static void addOrRemoveFromStock(){
    }

//    public static void newStorageAmount(int userInput) {  //TODO Input crashar med bokstav
//        System.out.print("Enter amount:");
//        productList.get(userInput - 1).setBalance(scanner.nextInt());
//        productManager();
//    }

    public static void removeProduct (){
        printProductName();
        System.out.println("Choose a product to remove by typing it below: ");
        String userInput = scanner.nextLine().toUpperCase();

        Product removeAProduct = productList.stream()
                .filter(product -> product.getName().equals(userInput))
                .reduce((first,second) -> second).get();

        productList.remove(removeAProduct);

        System.out.println(userInput + " is Successfully removed!");

    } //TODO lägg in try/catch för att undvika crash!

    public static void listCategories() {
        System.out.println(">Categories<");
        System.out.println("------------");
        productList.stream()
                .map(Product::getCategory)
                .distinct()
                .forEach(System.out::println);

        TestMain.backToMenu();
    }

}



